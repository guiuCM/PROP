# Variables
SRC_DIR = SRC/main
TEST_SRC_DIR = SRC/test
OUT_DIR = EXE/out
TEST_OUT_DIR = out/test
MAIN_CLASS = exe.main
LIB_DIR = LIB
JAR_DIR = EXE
DOCS_DIR = javadoc
DB_DIR = db
JAR_FILE = $(JAR_DIR)/app.jar

# Encontrar todos los archivos .java dentro de SRC_DIR y TEST_SRC_DIR
SOURCES = $(shell find $(SRC_DIR) -name "*.java")
TEST_SOURCES = $(shell find $(TEST_SRC_DIR) -name "*.java")

# Construir el classpath con las dependencias en lib/
CLASSPATH = $(LIB_DIR)/*:$(OUT_DIR):$(TEST_OUT_DIR)

# Comandos
JAVAC = javac
JAVA = java
JAR = jar
JAVADOC = javadoc

# Flags
JAVAC_FLAGS = -d $(OUT_DIR) -classpath $(CLASSPATH)
TEST_JAVAC_FLAGS = -d $(TEST_OUT_DIR) -classpath $(CLASSPATH)

# Regla principal: compilar todo
all:
	@echo "Compilando todos los archivos Java..."
	@mkdir -p $(OUT_DIR)
	$(JAVAC) $(JAVAC_FLAGS) $(SOURCES)

# Compilar y ejecutar pruebas
test: all
	@echo "Compilando y ejecutando pruebas..."
	@mkdir -p $(TEST_OUT_DIR)
	$(JAVAC) $(TEST_JAVAC_FLAGS) $(TEST_SOURCES)
	@echo "Ejecutando pruebas..."
	$(JAVA) -cp $(CLASSPATH) org.junit.runner.JUnitCore \
	$(shell find $(TEST_SRC_DIR) -name "*.java" | sed 's|$(TEST_SRC_DIR)/||' | sed 's|/|.|g' | sed 's|.java||')

# Compilar solo los tests sin ejecutarlos
compile-tests:
	@echo "Compilando tests..."
	@mkdir -p $(TEST_OUT_DIR)
	$(JAVAC) $(TEST_JAVAC_FLAGS) $(TEST_SOURCES)

# Crear un archivo .jar en la carpeta exe, incluyendo dependencias (fat jar)
jar: all
	@echo "Creando el archivo JAR (fat jar)..."
	@mkdir -p $(JAR_DIR) temp-lib
	for lib in $(LIB_DIR)/*.jar; do \
	    unzip -qo $$lib -d temp-lib; \
	done
	$(JAR) cfe $(JAR_FILE) $(MAIN_CLASS) -C $(OUT_DIR) . -C temp-lib .
	@rm -rf temp-lib
	@echo "Archivo JAR creado en $(JAR_FILE)"

# Generar documentación Javadoc
javadoc:
	@echo "Generando documentación Javadoc..."
	@mkdir -p $(DOCS_DIR)
	$(JAVADOC) -d $(DOCS_DIR) -sourcepath $(SRC_DIR) -subpackages . -classpath $(CLASSPATH)
	@echo "Documentación generada en $(DOCS_DIR)"

# Ejecutar la aplicación desde clases compiladas
run: all
	@echo "Ejecutando la aplicación..."
	$(JAVA) -cp $(CLASSPATH) $(MAIN_CLASS)

# Limpiar los archivos generados
clean:
	@echo "Limpiando archivos compilados y temporales..."
	rm -rf $(OUT_DIR) $(TEST_OUT_DIR) $(JAR_FILE) temp-lib $(DOCS_DIR)

# Reiniciar la base de datos
cleanDB:
	@echo "Reiniciando la base de datos..."
	sqlite3 $(DB_DIR)/DataBase.db < $(DB_DIR)/reset.sql

# Ayuda
help:
	@echo "Comandos disponibles:"
	@echo "  all            - Compilar todos los archivos .java"
	@echo "  jar            - Empaquetar el proyecto en un archivo .jar con dependencias"
	@echo "  javadoc        - Generar documentación Javadoc"
	@echo "  run            - Compilar y ejecutar la aplicación"
	@echo "  test           - Compilar y ejecutar las pruebas"
	@echo "  compile-tests  - Compilar los tests sin ejecutarlos"
	@echo "  clean          - Eliminar todos los archivos compilados y el .jar"
	@echo "  cleanDB        - Reiniciar la base de datos usando reset.sql"
	@echo "  help           - Mostrar este mensaje de ayuda"
