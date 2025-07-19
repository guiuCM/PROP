**UPC-PROP grup 42.3**

Projecte de Programació, Grup 40, subgrup 42.3.

Professor: Ignasi Gómez (ignasi.gomez@upc.edu).

**Credits**

Oriol Farrés (oriol.farres@estudiantat.upc.edu)

Daniela Cervantes (daniela.cervantes@estudiantat.upc.edu)

Guiu Carol (guiu.carol@estudiantat.upc.edu)

Daniel Martínez (daniel.martinez@estudiantat.upc.edu)

**Elements del directori**

* DOCS: Conté tota la documentació referent als tests d'integració de tot el projecte, relació de les classes implementades per membre de l’equip i la documentació Javadoc de tot el codi.

* EXE: Fitxers executables (.class) de totes les classes que permeten provar les funcionalitats principals implementades i un fitxer .jar del qual es pot executar el programa sencer Hi ha subdirectoris per cada un dels tipus de classes: test, excepcions, funcions, tipus, que segueixen l'estructura determinada pels packages

* LIB: S'hi troben les llibreries externes que hem hagut d'utilitzar per als tests JUnit.

* SRC: Codi de les classes de domini, persistència i presentació associades a les funcionalitats principals. Inclou també els tests JUnit. Tots els fitxers estan dins dels subdirectoris que segueixen l'estructura de packages, perquè el codi sigui recompilable directament. També inclou el fitxer Makefile.

* db: Conté la base de dades i un fitxer per aplicar configuracions a aquesta des del Makefile

**Provar el programa**

* Ejecutar directamente el archivo ejectuable: java -jar EXE/app.jar

* make jar: Este comando genera un archivo .jar empaquetado con todas las dependencias necesarias (fat jar). El archivo resultante se guarda en la carpeta EXE.

* make run: Ejecuta la aplicación desde las clases compiladas.

* make all: Todos los archivos .java se compilan y se almacenan en la carpeta out.

* make test: Ejecuta todas las pruebas en la carpeta SRC/test y muestra los resultados en la consola.

* make cleanDB: Restablece el estado de la base de datos.

* make clean: Limpia el proyecto eliminando los directorios out, out/test, javadoc, EXE, y archivos temporales
