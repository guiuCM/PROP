    package domain.controller;

    import domain.*;
    import Persistencia.ControladorPersistencia;
    import util.*;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    import static domain.RolUsuario.ANALISTA;
    import static domain.RolUsuario.GESTOR_SUPERMERCADO;

    /**
     * La clase {@code ControladorDominio} actúa como intermediario entre la capa de presentación y la lógica de negocio.
     * Gestiona las operaciones relacionadas con los usuarios, sesiones y productos mediante la interacción con {@link CtrlUsuario}.
     */
    public class ControladorDominio {

        private final ControladorPersistencia CtlP;
        private CtrlUsuario CU;
        private CjtProductos CP;

        /**
         * Construye una nueva instancia de {@code ControladorDominio}.
         *
         * @pre Ninguna dependencia requerida para inicialización.
         * @post Se inicializa {@code CtrlUsuario} para gestionar usuarios.
         */
        public ControladorDominio() {
            CU = new CtrlUsuario();
            CP = CjtProductos.obtenerInstancia();
            CtlP = new ControladorPersistencia();
        }

        /**
         * Crea un nuevo usuario con los datos proporcionados.
         *
         * @param nombre      el nombre del nuevo usuario
         * @param contraseña  la contraseña del nuevo usuario
         * @param correo      el correo electrónico del nuevo usuario
         * @pre {@code nombre}, {@code contraseña} y {@code correo} no deben ser {@code null} ni estar vacíos.
         * @post Se crea un usuario con los datos proporcionados.
         * @throws IllegalArgumentException si {@code nombre}, {@code contraseña} o {@code correo} son {@code null} o están vacíos,
         *                                  o si ya existe un usuario con el nombre proporcionado.
         */
        public boolean crearUsuario(String nombre, String contraseña, String correo, RolUsuario rol) {
                if (!this.existe(nombre)) {
                    CtlP.insertTablaUsuarios(nombre, contraseña, correo, rol.name());
                    return true;
                }
                else {
                    System.out.println("Usuario ya existe");
                    return false;
                }
        }

        /**
         * Elimina un usuario existente del sistema.
         *
         * @param name el nombre del usuario a eliminar
         * @pre {@code name} corresponde al nombre de un usuario existente.
         * @post El usuario especificado ha sido eliminado del sistema.
         * @throws IllegalArgumentException si {@code name} no corresponde a ningún usuario existente.
         */
        public void eliminarUsuario(String name) {
            if (CU.quienSoy().equals(name)) {
                this.cerrarSesion();
                CtlP.deleteTablaUsuarios(name);
            }
            else {
                System.out.println("Error al borrar usuario");
            }
        }

        /**
         * Muestra la matriz de afinidades de los productos seleccionados.
         *
         * @pre Debe haber productos seleccionados.
         * @post Se muestra la matriz de afinidades de los productos seleccionados.
         * @throws IllegalStateException si no hay productos seleccionados.
         */
        public void mostrarMatrizAfinidadesProductosSeleccionados() {
            CP.mostrarMatrizAfinidadesProductosSeleccionados();
        }

        /**
         * Agrega una lista de productos a la selección actual.
         *
         * @param productIds un arreglo de IDs de productos a agregar a la selección
         * @pre {@code productIds} no debe ser {@code null} y debe contener IDs válidos de productos existentes.
         * @post Los productos especificados han sido agregados a la selección.
         * @throws IllegalArgumentException si {@code productIds} es {@code null} o contiene IDs inválidos.
         */
        public void agregarProductosALaSeleccion(int[] productIds) {
            CP.agregarProductosALaSeleccion(productIds);
        }

        /**
         * Deselecciona una lista de productos de la selección actual.
         *
         * @param productIds un arreglo de IDs de productos a deseleccionar
         * @pre {@code productIds} no debe ser {@code null} y debe contener IDs válidos de productos actualmente seleccionados.
         * @post Los productos especificados han sido deseleccionados.
         * @throws IllegalArgumentException si {@code productIds} es {@code null} o contiene IDs inválidos.
         */
        public void deseleccionarListaProductos(int[] productIds) {
            CP.deseleccionarListaProductos(productIds);
        }

        /**
         * Muestra la matriz completa de afinidades entre todos los productos.
         *
         * @pre Debe haber productos con afinidades definidas.
         * @post Se muestra la matriz completa de afinidades.
         * @throws IllegalStateException si no hay afinidades definidas.
         */
        public void mostrarMatrizAfinidades(){
            CP.mostrarMatrizAfinidades();
        }
        /**
         * Obtiene la cantidad total de productos en el sistema.
         *
         * @return el número total de productos
         * @post Retorna la cantidad total de productos.
         */
        public int obtenerProductosLength(){
            return CP.obtenerProductosLength();
        }

        /**
         * Obtiene el nombre del usuario actualmente activo.
         *
         * @return el nombre del usuario activo
         * @pre Un usuario debe estar activo.
         * @post Retorna el nombre del usuario activo.
         * @throws IllegalStateException si no hay un usuario activo.
         */
        public String quienSoy() {
            String u = CU.quienSoy();
            if (u == null) {
                throw new IllegalStateException("No hay un usuario activo.");
            }
            return u;
        }

        /**
         * Inicia la sesión de un usuario con las credenciales proporcionadas.
         *
         * @param name     el nombre del usuario que intenta iniciar sesión
         * @param password la contraseña del usuario que intenta iniciar sesión
         * @pre {@code name} y {@code password} corresponden a un usuario existente con credenciales correctas.
         * @post El usuario ha iniciado sesión correctamente.
         * @return {@code true} si la sesión se inició exitosamente, {@code false} en caso contrario.
         * @throws IllegalArgumentException si {@code name} o {@code password} son {@code null} o están vacíos.
         * @throws IllegalStateException    si ya hay un usuario activo.
         */
        public boolean iniciarSesion(String name, String password) {
            if (CtlP.selectTablaUsuarios(name, password)) {
                Map<Integer, Par<int[][], String>> args = CtlP.selectDistrosUser(name);
                Map<Integer, Par<Integer, Long>> args2 = CtlP.selectDistrosUser2(name);
                RolUsuario rol = CtlP.selectRolUser(name);
                CU.iniciarSesion(name, password, rol, args, args2);
                return true;
            }
            return false;
        }

        /**
         * Cierra la sesión del usuario actualmente activo.
         *
         * @pre Debe haber un usuario activo que haya iniciado sesión.
         * @post El usuario ha cerrado sesión y no hay usuarios activos.
         * @throws IllegalStateException si no hay ningún usuario activo.
         */
        public void cerrarSesion() {CU.cerrarSesion();}

        /**
         * Cambia la contraseña del usuario activo verificando la contraseña actual.
         *
         * @param oldPasword la contraseña actual del usuario
         * @param newPasword la nueva contraseña a establecer
         * @pre El usuario debe haber iniciado sesión y {@code oldPasword} debe ser correcta.
         *      {@code newPasword} no debe ser {@code null} ni estar vacío.
         * @post La contraseña del usuario ha sido actualizada.
         * @throws IllegalArgumentException si {@code newPasword} es {@code null} o está vacío.
         * @throws IllegalStateException    si no hay ningún usuario activo.
         */
        public boolean cambiarContrasena(String oldPasword, String newPasword, String newPasword2) {
            if (CtlP.cambiarContrasena(CU.quienSoy(), oldPasword, newPasword, newPasword2)) {
                CU.cambiarContrasena(newPasword);
                return true;
            }
            return true;
        }


        public boolean existe(String name) {
            return CtlP.existeUsuario(name);
        }

        /**
         * Agrega un nuevo producto al sistema.
         *
         * @param idProd      el ID único del producto a agregar
         * @param nameProd    el nombre del producto a agregar
         * @param precio      el precio del producto
         * @param descripcion la descripción del producto
         * @param peso        el peso del producto
         * @param marca       la marca del producto
         * @pre {@code nameProd} no debe ser nulo ni vacío.
         *      {@code idProd} debe ser único y positivo.
         *      {@code precio} debe ser mayor o igual a cero.
         *      {@code descripcion} no debe ser nula ni vacía.
         *      {@code peso} debe ser mayor que cero.
         *      {@code marca} no debe ser nula ni vacía.
         *      Debe haber un usuario activo con permisos para agregar productos.
         * @post Se ha agregado un producto con el nombre, ID, precio, descripción, peso y marca especificados.
         * @throws IllegalArgumentException si {@code nameProd} es {@code null}, si ya existe un producto con ese nombre,
         *                                  o si {@code idProd} no es único.
         * @throws IllegalStateException    si no hay ningún usuario activo con permisos para agregar productos.
         */
        // Falta comprobar si existe o no el producto
        // Falta comprobar si estan fijados los datos o no
        public void agregarProducto(int idProd, String nameProd, double precio, String descripcion, double peso, String marca) {
            CU.agregarProducto(idProd, nameProd, precio, descripcion, peso, marca);
            CtlP.insertarProducto(idProd, nameProd, precio, descripcion, peso, marca);
        }

        /**
         * Elimina un producto existente del sistema.
         *
         * @param idProd el ID del producto a eliminar.
         * @pre {@code idProd} corresponde a un producto existente.
         * @post El producto especificado ha sido eliminado.
         * @throws IllegalArgumentException si {@code idProd} no corresponde a ningún producto existente.
         * @throws IllegalStateException    si no hay ningún usuario activo con permisos para eliminar productos.
         */
        // Falta comprobar si existe o no el producto
        // Falta comprobar si estan fijados los datos o no
        public void eliminarProducto(int idProd) {
            // Validación del ID
            if (idProd < 0) {
                throw new IllegalArgumentException("El ID del producto debe ser un valor positivo.");
            }
            // Eliminar el producto a través del controlador de productos
            CU.eliminarProducto(idProd);
            CtlP.borrarProducto(idProd);
        }

        /**
         * Modifica la afinidad entre dos productos especificados utilizando sus IDs.
         *
         * @param idProd1 el ID del primer producto.
         * @param idProd2 el ID del segundo producto.
         * @param valor   el nuevo valor de afinidad.
         * @pre {@code idProd1} y {@code idProd2} deben ser IDs de productos existentes, y {@code valor} debe estar en un rango válido.
         * @post La afinidad entre los productos especificados ha sido actualizada.
         * @throws IllegalArgumentException si {@code idProd1} o {@code idProd2} son negativos, iguales, o si {@code valor} está fuera del rango válido.
         * @throws IllegalStateException    si no hay ningún usuario activo con permisos para modificar afinidades, o si los productos no existen.
         */
        public void modificarAfinidad(int idProd1, int idProd2, int valor) {
            if (idProd1 < 0 || idProd2 < 0) {
                throw new IllegalArgumentException("Los IDs de los productos deben ser valores positivos.");
            }
            if (idProd1 == idProd2) {
                throw new IllegalArgumentException("No se puede modificar afinidad entre el mismo producto.");
            }
            CU.modificarAfinidad(idProd1, idProd2, valor);
            CtlP.modificarSimilitud(idProd1, idProd2, valor);
        }

        /**
         * Resetea la selección de todos los productos.
         *
         * @pre Puede haber uno o más productos seleccionados.
         * @post Todos los productos han sido deseleccionados.
         * @throws IllegalStateException si no hay ningún usuario activo.
         */
        public void resetarSeleccion() {
            CP.resetarSeleccion();
        }

        /**
         * Muestra la lista de todos los productos disponibles en el sistema.
         *
         * @pre Debe haber productos registrados en el sistema.
         * @post Se muestra la lista de productos registrados.
         * @throws IllegalStateException si no hay ningún producto registrado.
         */
        public void listaProductos() {
            CU.mostrarProductos();
        }

        /**
         * Muestra la lista de todos los productos actualmente seleccionados.
         *
         * @pre Debe haber productos seleccionados en el sistema.
         * @post Se muestra la lista de productos seleccionados.
         * @throws IllegalStateException si no hay ningún producto seleccionado.
         */
        public void listaProductosSelecionados() {
            CU.mostrarProductosSelecionados();
        }

        /**
         * Obtiene y retorna la distribución de estantería correspondiente al índice especificado.
         *
         * @param num el índice de la distribución a obtener
         * @return la matriz que representa la distribución de estantería correspondiente al índice especificado
         * @pre {@code num} debe ser un índice válido dentro de las distribuciones almacenadas.
         * @post Muestra la distribución de estantería correspondiente al índice especificado.
         * @throws IllegalArgumentException si {@code num} no es un índice válido.
         * @throws IllegalStateException    si no hay ningún usuario activo.
         */
        public void imprimirDistribucion(int num) {
            CU.imprimirDistribucion(num);
        }

        /**
         * Muestra todas las distribuciones de estantería almacenadas en el sistema.
         *
         * @pre Debe haber distribuciones almacenadas en el sistema.
         * @post Todas las distribuciones de estantería se muestran por consola.
         * @throws IllegalStateException si no hay ninguna distribución almacenada.
         */
        public void printAllDistributions() {
            CU.printAllDistributions();
            // Post: Todas las distribuciones de estantería se muestran por consola
        }

        /**
         * Agrega una nueva estantería con el número de baldas especificado y los productos seleccionados.
         *
         * @param numeroBaldas el número de baldas de la nueva estantería
         * @pre {@code numeroBaldas} debe ser un valor positivo.
         *      Deben haber productos seleccionados para asignar a la estantería.
         * @post Se ha agregado una nueva estantería con los productos especificados.
         * @throws IllegalArgumentException si {@code numeroBaldas} no es positivo.
         * @throws IllegalStateException    si no hay ningún usuario activo con permisos para agregar estanterías.
         */
        public void agregarEstanteriaPriorizandoProximidadLateral(AlgoritmosTSP a, int numeroBaldas) {
            List<Producto> l = CP.obtenerListaProductosSeleccionados();
            CU.agregarEstanteriaPriorizandoProximidadLateral(a, numeroBaldas, l);
            // Post: Se ha agregado una nueva estantería con los productos especificados
        }

        public Par<Integer, Tripleta<Integer, Long, int[][]>> agregarEstanteriaPriorizandoProximidadLateralR(AlgoritmosTSP a, int numeroBaldas) {
            List<Producto> l = CP.obtenerListaProductosSeleccionados();
            Par<Integer, Tripleta<Integer, Long, int[][]>> pareja = CU.agregarEstanteriaPriorizandoProximidadLateralR(a, numeroBaldas, l);
            Tripleta<Integer, Long, int[][]> solucion = pareja.obtenerSegundo();
            this.exportarDistro(pareja.obtenerPrimero(), a.name() , solucion.obtenerPrimero(), solucion.obtenerSegundo(), solucion.obtenerTercero());
            return pareja;
        }

        public void agregarEstanteriaPriorizandoProximidadVecina(AlgoritmosQAP a, int numeroBaldas) {
            List<Producto> l = CP.obtenerListaProductosSeleccionados();
            CU.agregarEstanteriaPriorizandoProximidadVecina(a, numeroBaldas, l);
            // Post: Se ha agregado una nueva estantería con los productos especificados
        }

        public Par<Integer, Tripleta<Integer, Long, int[][]>> agregarEstanteriaPriorizandoProximidadVecinaR(AlgoritmosQAP a, int numeroBaldas) {
            List<Producto> l = CP.obtenerListaProductosSeleccionados();
            Par<Integer, Tripleta<Integer, Long, int[][]>> pareja = CU.agregarEstanteriaPriorizandoProximidadVecinaR(a, numeroBaldas, l);
            Tripleta<Integer, Long, int[][]> solucion = pareja.obtenerSegundo();
            this.exportarDistro(pareja.obtenerPrimero(), a.name() , solucion.obtenerPrimero(), solucion.obtenerSegundo(), solucion.obtenerTercero());
            return pareja;
        }
        /**
         * Intercambia dos productos dentro de una distribución específica.
         *
         * @param idDist el ID de la distribución donde se realizará el intercambio
         * @param id1    el ID del primer producto a intercambiar
         * @param id2    el ID del segundo producto a intercambiar
         * @pre {@code idDist} debe corresponder a una distribución existente.
         *      {@code id1} y {@code id2} deben corresponder a productos existentes dentro de la distribución.
         * @post Los productos especificados han sido intercambiados en la distribución dada.
         * @throws IllegalArgumentException si alguno de los IDs es inválido.
         * @throws IllegalStateException    si no hay ningún usuario activo con permisos para modificar distribuciones.
         */
        public void swapDosProductosDistribucion(int idDist, int id1, int id2) {
            Par<int[][], String> temp = CU.swapDosProductosDistribucion(idDist, id1, id2);
            int puntuacion = CtlP.obtenerPuntuacion(idDist, quienSoy()); // FALTA CONSEGUIR LA PUNTUACIÓN NUEVA (CREAR UNA FUNCION PARA PUNTUAR FUERA DE LOS ALGORITMOS)
            long steps = CtlP.obtenerSteps(idDist, quienSoy()); // REVISAR SI LOS STEPS CAMBIAN
            CtlP.borrarDistribucion(idDist, this.quienSoy());
            this.exportarDistro(idDist, temp.obtenerSegundo(), puntuacion, steps, temp.obtenerPrimero());
        }

        /**
         * Cambia el método de cálculo de afinidades utilizado en el sistema.
         *
         * @param nuevoMetodo el nuevo algoritmo de cálculo a establecer
         * @pre {@code nuevoMetodo} no debe ser {@code null}.
         * @post El método de cálculo de afinidades ha sido actualizado al nuevo método especificado.
         * @throws IllegalArgumentException si {@code nuevoMetodo} es {@code null}.
         * @throws IllegalStateException    si no hay ningún usuario activo con permisos para cambiar el método de cálculo.
         */
        public void cambiarMetodoCalculo(AlgoritmosTSP nuevoMetodo) {
            CU.cambiarMetodoCalculo(nuevoMetodo);
        }

        /**
         * Agrega una afinidad entre dos productos específicos.
         *
         * @param idp1     el ID del primer producto
         * @param idp2     el ID del segundo producto
         * @param afinidad el valor de afinidad a establecer entre los productos
         * @pre {@code idp1} y {@code idp2} deben ser IDs de productos existentes y distintos.
         *      {@code afinidad} debe estar en un rango válido.
         * @post Se ha agregado la afinidad especificada entre los dos productos.
         * @throws IllegalArgumentException si alguno de los IDs es inválido o si {@code afinidad} está fuera del rango válido.
         * @throws IllegalStateException    si no hay ningún usuario activo con permisos para agregar afinidades.
         */
        public void agregarAfinidadEntreDosProductos(int idp1, int idp2, int afinidad) {
            CP.agregarAfinidadEntreDosProductos(idp1, idp2, afinidad);
            CtlP.modificarSimilitud(idp1, idp2, afinidad);
        }

        /**
         * Fija los datos actuales de los productos, consolidando cualquier cambio realizado.
         *
         * @pre Deben haber cambios realizados en los productos que necesitan ser fijados.
         * @post Los datos de los productos han sido fijados y consolidados.
         * @throws IllegalStateException si ocurre un error al fijar los datos.
         */
        public void fijarDatos() {
            CP.fijarDatos();
            this.ConfigDatosPersistencia();
            this.InicializarSimilitudes();
        }

        /**
         * Inicializa la base de datos del sistema.
         *
         * @pre La base de datos debe estar accesible y no estar corrupta.
         * @post La base de datos ha sido inicializada correctamente.
         * @throws IllegalStateException si ocurre un error durante la inicialización de la base de datos.
         */
        public void inicializarBaseDeDatos() {
            CtlP.inicializarBaseDeDatos();
        }

        public void InicializarSimilitudes() {
            List<Producto> productos = CP.obtenerTodosLosProductos();
            Map<Integer, Integer> posMatrixToId = new HashMap<>();

            int index = 0;
            for (Producto producto : productos) {
                posMatrixToId.put(index, producto.obtenerId());
                producto.establecerPosMatriz(index);
                index++;
            }

            for (int i = 0; i < posMatrixToId.size(); i++) {
                int idProducto1 = posMatrixToId.get(i);
                for (int j = 0; j < i; j++) { // Recorre solo las posiciones donde j < i
                    int idProducto2 = posMatrixToId.get(j);

                    CtlP.insertarSimilitud(
                            idProducto1,
                            idProducto2,
                            CP.obtenerAfinidad(idProducto1, idProducto2)
                    );
                }
                /*CtlP.insertarSimilitud(
                        idProducto1,
                        idProducto1,
                        CP.agregarAfinidadMismoProducto(idProducto1)
                );*/
            }
        }

        public void exportarDistro(int idDistribucion, String tipoAlgoritmo, int puntuacion, long steps, int[][] matrizDistribucion) {
            try {
                CtlP.insertarDistribucion(idDistribucion, CU.quienSoy(), tipoAlgoritmo, puntuacion , steps, matrizDistribucion);
            } catch (Exception e) {
                System.out.println("Error al exportar la distribución con ID " + idDistribucion + ": " + e.getMessage());
            }
        }

        public int obtenerPuntuacion(int idDistro) {
            return CtlP.obtenerPuntuacion(idDistro, this.quienSoy());
        }

        public int obtenerSteps(int idDistro) {
            return CtlP.obtenerSteps(idDistro, this.quienSoy());
        }

        public Par<int[][], String> obtenerDistribucion(int idDistribucion){
            return CtlP.selectDistribucion(idDistribucion, this.quienSoy());
        }

        public void borrarDistribucion(int idDistro) {
            CtlP.borrarDistribucion(idDistro, this.quienSoy());
        }

        public RolUsuario obtenerRol(String nombre){
            return CtlP.selectRolUser(nombre);
        }

        public void importFromDB() {
            if (!CtlP.existeUsuario("BD")) CtlP.insertTablaUsuarios("BD","BD","BD",GESTOR_SUPERMERCADO.name());
            this.iniciarSesion("BD","BD");
            CtlP.modificarRol("BD", GESTOR_SUPERMERCADO.name());
            Object[][] Prod = CtlP.selectTodosLosProductos();
            for (Object[] objects : Prod) {
                CP.agregarProducto((int) objects[0], (String) objects[1], (double) objects[2], (String) objects[3], (double) objects[4], (String) objects[5]);
            }
            if (CtlP.consultConfig("FijarDatos") == 1) {
                CP.fijarDatos();
                CtlP.modificarRol("BD", ANALISTA.name());
                Object[][] sim = CtlP.selectTodasLasSimilitudes();
                for(Object[] objects : sim) {
                    CP.agregarAfinidadEntreDosProductos((int) objects[0], (int) objects[1], (int) objects[2]);
                }
            }
            this.eliminarUsuario("BD");
        }

        public void ConfigDatosPersistencia() {
            int DF = this.datosFijados();
            CtlP.modificarConfigValue("FijarDatos", DF);
        }

        public int datosFijados(){
            int DF = 0;
            if (CP.obtenerDatosFijados()) DF = 1;
            return DF;
        }

        public void reset() {
//            if (CtlP.selectRolUser(CU.quienSoy()) == GESTOR_SUPERMERCADO) {
//                this.cerrarSesion();
//
//            }
            CtlP.borrarBaseDatos();
            CtlP.inicializarBaseDeDatos();
        }
        // NO DEBERIA SER UN USUARIO ESTANDARD EL QUE PUEDA HACER ESTO
        public void desfijarDatos() {
            CtlP.deleteTodasDistribuciones();
            CtlP.deleteTablaSimilitudes();
            CtlP.inicializarBaseDeDatos();
            CU.borrarDistribucionesActivas();
            CP.desfijarDatos();
            this.ConfigDatosPersistencia();
        }

        /**
         * Importa productos desde un archivo de texto.
         * El archivo debe tener el siguiente formato por línea:
         * id,nombre,precio,descripcion,peso,marca
         *
         * @param filePath Ruta del archivo de texto.
         * @throws IOException Si ocurre un error al leer el archivo.
         */
        // FALTA CONSULTAR SI ESTAN FIJADOS O NO LOS DATOS???
        public void importProductosFromFile(String filePath) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length != 6) {
                        System.err.println("Formato inválido: " + line);
                        continue;
                    }

                    try {
                        int id = Integer.parseInt(fields[0]);
                        String nombre = fields[1];
                        double precio = Double.parseDouble(fields[2]);
                        String descripcion = fields[3];
                        double peso = Double.parseDouble(fields[4]);
                        String marca = fields[5];

                        agregarProducto(id, nombre, precio, descripcion, peso, marca);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear datos: " + line);
                    }
                }

                System.out.println("Productos importados exitosamente desde: " + filePath);
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        }

        /**
         * Importa similitudes entre productos desde un archivo de texto.
         * El archivo debe tener el siguiente formato por línea:
         * id_producto1,id_producto2,similitud
         *
         * @param filePath Ruta del archivo de texto.
         * @throws IOException Si ocurre un error al leer el archivo.
         */
        public void importSimilitudesFromFile(String filePath) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length != 3) {
                        System.err.println("Formato inválido: " + line);
                        continue;
                    }

                    try {
                        int idProducto1 = Integer.parseInt(fields[0]);
                        int idProducto2 = Integer.parseInt(fields[1]);
                        int similitud = Integer.parseInt(fields[2]);

                        agregarAfinidadEntreDosProductos(idProducto1, idProducto2, similitud);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear datos: " + line);
                    }
                }

                System.out.println("Similitudes importadas exitosamente desde: " + filePath);
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        }

        public boolean comprobarContraseña(String oldP){
            return CU.comprobarContraseña(oldP);
        }

        public String recordarContrasena(String name, String email) {
            return CtlP.recordarContrasena(name, email);
        }

        public List<Producto> obtenerTodosLosProductos() {
            /*
            // Obtener la matriz de objetos desde CtlP
            Object[][] prods = CtlP.selectTodosLosProductos();

            // Crear una lista para almacenar los productos
            List<Producto> productos = new ArrayList<>();

            // Iterar sobre las filas de la matriz
            for (Object[] fila : prods) {
                // Castear cada elemento de la fila al tipo adecuado y crear un producto
                int id = (int) fila[0];
                String nombre = (String) fila[1];
                double precio = (double) fila[2];
                String descripcion = (String) fila[3];
                double peso = (double) fila[4];
                String marca = (String) fila[5];

                // Crear el objeto Producto y agregarlo a la lista
                Producto producto = new Producto(id, nombre, precio, descripcion, peso, marca);
                productos.add(producto);
            }

            // Retornar la lista de productos
            return productos;
            */
            return CP.obtenerTodosLosProductos();
        }

        public Map<Integer, Par<int[][], String>> obtenerDistribuciones() {
            return CU.obtenerDistribuciones();
        }

        public Producto obtenerP(int id){
            return CP.obtenerProducto(id);
        }

        public Integer obtenerCoste(int idDist) {
            return CU.obtenerCoste(idDist);
        }

        public Long obtenerPasos(int idDist) {
            return CU.obtenerPasos(idDist);
        }
    }