package domain;

import util.*;
import domain.controller.ControladorDominio;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

/**
 * La clase {@code Main} actúa como punto de entrada para ejecutar la lógica principal de la aplicación.
 * Esta clase gestiona la interacción con el usuario a través de la consola, inicializa la base de datos,
 * importa datos, y ejecuta los comandos disponibles que permiten gestionar usuarios, productos, afinidades
 * y distribuciones en el sistema.
 *
 * <p>Este programa está diseñado para ser ejecutado en la consola, donde el usuario puede ingresar comandos
 * para realizar diversas operaciones sobre el sistema, como crear usuarios, gestionar productos, modificar
 * afinidades y calcular distribuciones.</p>
 *
 * <p>El flujo de trabajo es el siguiente:
 * <ul>
 *     <li>Inicialización de la base de datos y carga de datos desde la fuente persistente.</li>
 *     <li>Presentación de un conjunto de comandos que el usuario puede ejecutar para interactuar con el sistema.</li>
 *     <li>Procesamiento y ejecución de comandos introducidos por el usuario.</li>
 *     <li>El sistema termina su ejecución al recibir el comando de salida, persiste los datos antes de salir.</li>
 * </ul>
 * </p>
 *
 * <p>El sistema admite varios grupos de operaciones que permiten realizar tareas específicas de acuerdo a la categoría
 * del comando, tales como:</p>
 * <ul>
 *     <li>Gestión de usuarios y sesiones.</li>
 *     <li>Gestión de productos y selecciones.</li>
 *     <li>Gestión de afinidades entre productos.</li>
 *     <li>Gestión de distribuciones y cálculo de estanterías.</li>
 * </ul>
 *
 * <p>Los comandos disponibles están agrupados y se ejecutan según las instrucciones del usuario, quien puede realizar
 * operaciones como agregar y eliminar productos, iniciar sesión, cambiar contraseñas, y calcular distribuciones
 * de productos en estanterías.</p>
 *
 * @see ControladorDominio
 * @see Instruccion
 */
public class Main {

    /**
     * Instancia única de la clase {@code ControladorDominio}.
     *
     * <p>Esta instancia se utiliza para gestionar la lógica de negocio del sistema. {@code ControladorDominio}
     * es responsable de coordinar las acciones entre las diferentes capas del sistema, como el acceso a los datos
     * y la implementación de la lógica de procesamiento de las solicitudes.</p>
     *
     * <p>La instancia se crea de manera estática para garantizar que solo haya una única instancia de la clase
     * {@code ControladorDominio}, siguiendo el patrón de diseño Singleton.</p>
     *
     * @see ControladorDominio
     */
    private static final ControladorDominio cd = new ControladorDominio();

    /**
     * Muestra los comandos disponibles en el sistema agrupados por categorías.
     *
     * <p>Este método recorre todos los comandos definidos en {@link Instruccion.Comando}, organiza los comandos
     * en grupos de acuerdo a su código y los imprime en la consola. Los comandos están agrupados por categorías
     * como "Salida", "Ayuda", "Gestión general", etc., y se presentan con su respectiva descripción. Además, el
     * método verifica si hay códigos duplicados y emite una advertencia en caso de encontrarlos.</p>
     *
     * <p>El formato de salida muestra los grupos de comandos, seguidos de los comandos dentro de cada grupo,
     * con un encabezado que identifica el grupo y su descripción. Se incluyen las siguientes categorías:</p>
     * <ul>
     *     <li>Grupo -10: Salida</li>
     *     <li>Grupo 0: Ayuda</li>
     *     <li>Grupo 10: Gestión general</li>
     *     <li>Grupo 20: Gestión de usuarios y sesiones</li>
     *     <li>Grupo 40: Gestión de productos y selecciones</li>
     *     <li>Grupo 60: Gestión de afinidades</li>
     *     <li>Grupo 80: Gestión de distribuciones y cálculo</li>
     * </ul>
     *
     * <p>En caso de que un código de comando se repita, el sistema imprimirá una advertencia indicando el código duplicado.</p>
     */
    private static void muestra_metodos() {
        System.out.println("Podemos ejecutar las siguientes comandos: ");
        Set<Integer> codigosUnicos = new HashSet<>(); // Para verificar duplicados
        int grupoActual = -1;

        for (Instruccion.Comando c : Instruccion.Comando.values()) {
            Instruccion instruccion = c.obtenerInstruccion();

            int codigo = instruccion.obtenerCodigo();
            int grupo;
            if (codigo >= -10 && codigo <= -1) {
                grupo = -10;
            } else if (codigo >= 0 && codigo <= 9) {
                grupo = 0;
            } else if (codigo >= 10 && codigo <= 19) {
                grupo = 10;
            } else if (codigo >= 20 && codigo <= 39) {
                grupo = 20;
            } else if (codigo >= 40 && codigo <= 59) {
                grupo = 40;
            } else if (codigo >= 60 && codigo <= 79) {
                grupo = 60;
            } else if (codigo >= 80 && codigo <= 99) {
                grupo = 80;
            } else {
                grupo = -99;
            }

            if (grupo != grupoActual) {
                grupoActual = grupo;

                System.out.println();
                System.out.println(" // ========================");
                switch (grupoActual) {
                    case -10:
                        System.out.println(" // Grupo -10: Salida");
                        break;
                    case 0:
                        System.out.println(" // Grupo 0: Ayuda");
                        break;
                    case 10:
                        System.out.println(" // Grupo 10: Gestión general");
                        break;
                    case 20:
                        System.out.println(" // Grupo 20: Gestión de usuarios y sesiones");
                        break;
                    case 40:
                        System.out.println(" // Grupo 40: Gestión de productos y selecciones");
                        break;
                    case 60:
                        System.out.println(" // Grupo 60: Gestión de afinidades");
                        break;
                    case 80:
                        System.out.println(" // Grupo 80: Gestión de distribuciones y cálculo");
                        break;
                    default:
                        System.out.println(" // Grupo desconocido: Código fuera de rango esperado");
                        break;
                }
                System.out.println(" // ========================");
            }

            if (!codigosUnicos.add(codigo)) {
                System.out.println("¡Advertencia! Código duplicado: " + codigo);
            }

            System.out.println(instruccion);
        }
    }

    /**
     * Método principal de la aplicación que actúa como el punto de entrada para ejecutar la lógica del programa.
     *
     * <p>Este método es responsable de la inicialización del sistema, la gestión de la base de datos, la interacción
     * con el usuario a través de la consola y la ejecución de comandos. Proporciona un menú de comandos y se ejecuta
     * de manera continua hasta que se elija salir del programa.</p>
     *
     * <p>El programa ofrece la funcionalidad de gestionar usuarios, productos, afinidades y distribuciones, y
     * permite realizar operaciones como agregar o eliminar productos, cambiar contraseñas, gestionar la selección
     * de productos, imprimir distribuciones, modificar afinidades entre productos y mucho más.</p>
     *
     * <p>El flujo de trabajo es el siguiente:
     * <ul>
     *     <li>Se inicializa la base de datos y se importa la información desde la base de datos.</li>
     *     <li>Se presenta un conjunto de comandos que el usuario puede ejecutar desde la consola.</li>
     *     <li>El usuario ingresa comandos, los cuales son procesados y ejecutados de acuerdo a las instrucciones definidas.</li>
     *     <li>Al finalizar, los datos de la aplicación se persisten antes de salir.</li>
     * </ul>
     * </p>
     *
     * <p>El método maneja diversas excepciones y errores de entrada, proporcionando mensajes adecuados en caso de
     * comandos malformados o problemas al ejecutar una operación.</p>
     *
     * @param args Los argumentos de línea de comandos, que no se utilizan en este caso.
     */
    public static void main(String[] args) {
        System.out.println("Driver Principal Dominio (PROP Grup 42.3)");
        System.out.println();
        muestra_metodos();

        /*
         * Nota: Este bloque de código está comentado porque aparentemente se está utilizando una interfaz gráfica de usuario
         * en lugar de la interacción por consola. Si decides utilizar la consola en el futuro, puedes descomentar este bloque.
         *
        System.out.println();
        System.out.println("BIENVENIDO!");

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 1) {
            System.out.print("Pulsa 1 para crear un usuario: ");
            opcion = scanner.nextInt();

            if (opcion != 1) {
                System.out.println("Entrada no válida. Por favor, pulsa 1.");
            }
        }
        scanner = new Scanner(System.in);
        System.out.print("Introduce nombre de usuario: ");
        String nombre  ="";
        nombre  = scanner.nextLine().trim();

        System.out.print("Introduce contraseña: ");
        String contrasena  ="";
        contrasena  = scanner.nextLine().trim();

        System.out.print("Introduce correo: ");
        String correo  ="";
        correo  = scanner.nextLine().trim();

        // Leer y validar el rol
        System.out.print("Rol a seleccionar: ESTANDAR, ANALISTA, GESTOR_SUPERMERCADO: ");
        String rolusuario ="";
        rolusuario = scanner.nextLine().trim();

        try {
            RolUsuario rol = RolUsuario.valueOf(rolusuario.toUpperCase());
            cd.crearUsuarioConRol(nombre, contrasena, correo, rol);
            System.out.println("Creando usuario...");
            System.out.println("Usuario " + nombre + " con rol: " + rol + " creado correctamente");
            cd.iniciarSesion(nombre, contrasena);
        }  catch (IllegalArgumentException e) {
            System.out.println("Rol no válido. Por favor, selecciona entre ESTANDAR, ANALISTA o GESTOR_SUPERMERCADO.");
        }
        */

        Scanner scanner = new Scanner(System.in);
        cd.inicializarBaseDeDatos();
        cd.importFromDB();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty() || input.charAt(0) == '#') continue; // Ignorar líneas vacías o comentarios

            String[] argumentos = input.trim().split("\\s+");
            String comanda = argumentos[0];

            Instruccion.Comando comandoSeleccionado = null;
            for (Instruccion.Comando comando : Instruccion.Comando.values()) {
                Instruccion instruccion = comando.obtenerInstruccion();
                if (comanda.equals(String.valueOf(instruccion.obtenerCodigo())) ||
                        comanda.equals(instruccion.obtenerNombreYAtajo().obtenerPrimero()) ||
                        comanda.equals(instruccion.obtenerNombreYAtajo().obtenerSegundo())) {
                    comandoSeleccionado = comando;
                    break;
                }
            }

            if (comandoSeleccionado == null) {
                System.out.println("Comando no reconocido: " + comanda);
                continue;
            }

            Instruccion instruccionSeleccionada = comandoSeleccionado.obtenerInstruccion();

            if (instruccionSeleccionada.obtenerCodigo() == -1) {
                break;
            }
            int numArgumentosEsperados = instruccionSeleccionada.obtenerNumeroArgumentos();
            int numArgumentosIngresados = argumentos.length - 1;

            boolean esComandoEspecial = (instruccionSeleccionada.obtenerCodigo() == 43 && numArgumentosIngresados > 1) ||
                    (instruccionSeleccionada.obtenerCodigo() == 44 && numArgumentosIngresados > 1);
            if (numArgumentosIngresados != numArgumentosEsperados && !esComandoEspecial) {
                System.out.println("Uso incorrecto de los argumentos");
                System.out.println("Uso correcto: " + instruccionSeleccionada.obtenerUsoCorrecto());
                continue;
            }

            try {
                switch (comandoSeleccionado) {
                    // ========================
                    // Grupo -10: Salida
                    // ========================
                    case SALIR:
                        if (0 == cd.datosFijados()) { cd.InicializarSimilitudes(); }
                        cd.ConfigDatosPersistencia();
                        System.exit(0);
                        System.out.println("Saliendo del programa...");
                        break;

                    // ========================
                    // Grupo 0: Ayuda
                    // ========================
                    case AYUDA:
                        muestra_metodos();
                        break;

                    // ========================
                    // Grupo 10: Gestión general
                    // ========================
                    case IMPRIMIR_DISTRIBUCION:
                        if (argumentos.length != 2) {
                            System.out.println("Uso incorrecto de los argumentos para IMPRIMIR_DISTRIBUCION.");
                            break;
                        }
                        int num = Integer.parseInt(argumentos[1]);
                        cd.imprimirDistribucion(num);
                        System.out.println("Print de la distribución hecho correctamente");
                        break;

                    case RESETEAR_SELECCION:
                        cd.resetarSeleccion();
                        System.out.println("Selección reseteada correctamente");
                        break;

                    case FIJAR_DATOS:
                        cd.fijarDatos();
                        System.out.println("Datos fijados correctamente");
                        break;

                    case IMPRIMIR_TODAS_LAS_DISTRIBUCIONES:
                        cd.printAllDistributions();
                        System.out.println("Impresión de todas las distribuciones realizada correctamente");
                        break;

                    case EXPORTAR_PRODUCTOS_Y_SIMILITUDES:
                        cd.InicializarSimilitudes();
                        System.out.println("Se han exportado los productos y las similitudes correctamente");
                        break;

                    // ========================
                    // Grupo 20: Gestión de usuarios y sesiones
                    // ========================

                    case INICIAR_SESION:
                        if (argumentos.length != 3) {
                            System.out.println("Uso incorrecto de los argumentos para INICIAR_SESION.");
                            break;
                        }
                        cd.iniciarSesion(argumentos[1], argumentos[2]);
                        break;

                    case CERRAR_SESION:
                        cd.cerrarSesion();
                        System.out.println("Sesión cerrada correctamente");
                        break;

                    case QUIEN_SOY:
                        String nombreUsuario = cd.quienSoy();
                        if (nombreUsuario != null) {
                            System.out.println("Soy el usuario: " + nombreUsuario + " y he sido identificado correctamente");
                        }
                        break;

                    case CREAR_USUARIO:
                        if (argumentos.length != 5) {
                        System.out.println("Uso incorrecto de los argumentos para CREAR_USUARIO.");
                        } else {
                            try {
                                RolUsuario rol1 = RolUsuario.valueOf(argumentos[4].toUpperCase());
                                cd.crearUsuario(argumentos[1], argumentos[2], argumentos[3], rol1);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Rol no válido. Por favor, selecciona entre ESTANDAR, ANALISTA o GESTOR_SUPERMERCADO.");
                            }
                        }
                        break;

                    case ELIMINAR_USUARIO:
                        if (argumentos.length != 2) {
                            System.out.println("Uso incorrecto de los argumentos para ELIMINAR_USUARIO.");
                            break;
                        }
                        cd.eliminarUsuario(argumentos[1]);
                        System.out.println("Usuario " + argumentos[1] + " eliminado correctamente");
                        break;


                    case CAMBIAR_CONTRASENA:
                        if (argumentos.length != 4) {
                            System.out.println("Uso incorrecto de los argumentos para CAMBIAR_CONTRASENA.");
                            break;
                        }
                        cd.cambiarContrasena(argumentos[1], argumentos[2], argumentos[3]);
                        System.out.println("Contraseña cambiada correctamente");
                        break;


                    // ========================
                    // Grupo 40: Gestión de productos y selecciones
                    // ========================
                    case LISTAR_PRODUCTOS:
                        cd.listaProductos();
                        System.out.println("Productos listados correctamente");
                        break;

                    case AGREGAR_PRODUCTO:
                        if (argumentos.length != 7) {
                            System.out.println("Uso incorrecto de los argumentos para AGREGAR_PRODUCTO.");
                            break;
                        }
                        int idProducto = Integer.parseInt(argumentos[1]);
                        String nombreProducto = argumentos[2];
                        double precio = Double.parseDouble(argumentos[3]);
                        String descripcion = argumentos[4];
                        double peso = Double.parseDouble(argumentos[5]);
                        String marca = argumentos[6];
                        cd.agregarProducto(idProducto, nombreProducto, precio, descripcion, peso, marca);
                        System.out.println("Producto con ID: " + idProducto + " creado correctamente");
                        break;

                    case ELIMINAR_PRODUCTO:
                        if (argumentos.length != 2) {
                            System.out.println("Uso incorrecto de los argumentos para ELIMINAR_PRODUCTO.");
                            break;
                        }
                        int idEliminar = Integer.parseInt(argumentos[1]);
                        cd.eliminarProducto(idEliminar);
                        System.out.println("Producto con ID: " + idEliminar + " eliminado correctamente");
                        break;

                    case AGREGAR_PRODUCTOS_A_LA_SELECCION:
                        if (argumentos.length < 2) {
                            System.out.println("Uso incorrecto de los argumentos para AGREGAR_PRODUCTOS_A_LA_SELECCION.");
                            break;
                        }
                        int[] productIds = Arrays.stream(Arrays.copyOfRange(argumentos, 1, argumentos.length))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        cd.agregarProductosALaSeleccion(productIds);
                        System.out.println("Lista de productos seleccionada correctamente");
                        break;

                    case QUITAR_PRODUCTOS_DE_LA_SELECCION:
                        if (argumentos.length < 2) {
                            System.out.println("Uso incorrecto de los argumentos para QUITAR_PRODUCTOS_DE_LA_SELECCION.");
                            break;
                        }
                        int[] productIds2 = Arrays.stream(Arrays.copyOfRange(argumentos, 1, argumentos.length))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        cd.deseleccionarListaProductos(productIds2);
                        System.out.println("Lista de productos deseleccionada correctamente");
                        break;

                    case LISTAR_PRODUCTOS_SELECCIONADOS:
                        cd.listaProductosSelecionados();
                        System.out.println("Productos seleccionados listados correctamente");
                        break;

                    case AGREGAR_ESTANTERIA_PRIORIZANDO_LA_PROXIMIDAD_LATERAL:
                        if (argumentos.length != 3) {
                            System.out.println("Uso incorrecto de los argumentos para AGREGAR_ESTANTERIA_PRIORIZANDO_LA_PROXIMIDAD_LATERAL.");
                            break;
                        }
                        AlgoritmosTSP a = AlgoritmosTSP.valueOf(argumentos[1].toUpperCase());
                        int numeroBaldas = Integer.parseInt(argumentos[2]);
                        try {
                            cd.agregarEstanteriaPriorizandoProximidadLateral(a, numeroBaldas);
                            System.out.println("Estantería agregada correctamente con " + numeroBaldas + " baldas.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error al agregar estantería: " + e.getMessage());
                        }
                        break;

                    case AGREGAR_ESTANTERIA_PRIORIZANDO_LA_PROXIMIDAD_VECINA:
                        if (argumentos.length != 3) {
                            System.out.println("Uso incorrecto de los argumentos para AGREGAR_ESTANTERIA_PRIORIZANDO_LA_PROXIMIDAD_VECINA.");
                            break;
                        }
                        AlgoritmosQAP aq = AlgoritmosQAP.valueOf(argumentos[1].toUpperCase());
                        int numBaldas = Integer.parseInt(argumentos[2]);
                        try {
                            cd.agregarEstanteriaPriorizandoProximidadVecina(aq, numBaldas);
                            System.out.println("Estantería agregada correctamente con " + numBaldas + " baldas.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error al agregar estantería: " + e.getMessage());
                        }
                        break;

                    // ========================
                    // Grupo 60: Gestión de afinidades
                    // ========================
                    case MODIFICAR_AFINIDAD:
                        if (argumentos.length != 4) {
                            System.out.println("Uso incorrecto de los argumentos para MODIFICAR_AFINIDAD.");
                            break;
                        }
                        int idProd1 = Integer.parseInt(argumentos[1]);
                        int idProd2 = Integer.parseInt(argumentos[2]);
                        int valor = Integer.parseInt(argumentos[3]);
                        cd.modificarAfinidad(idProd1, idProd2, valor);
                        System.out.println("Afinidad modificada correctamente");
                        break;

                    case AGREGAR_AFINIDAD_ENTRE_DOS_PRODUCTOS:
                        if (argumentos.length != 4) {
                            System.out.println("Uso incorrecto de los argumentos para AGREGAR_AFINIDAD_ENTRE_DOS_PRODUCTOS.");
                            break;
                        }
                        int idp1 = Integer.parseInt(argumentos[1]);
                        int idp2 = Integer.parseInt(argumentos[2]);
                        int afinidad = Integer.parseInt(argumentos[3]);
                        if (afinidad < 0 || afinidad > 100) {
                            System.out.println("Afinidad inválida. Debe estar entre 0 y 100");
                        } else {
                            cd.agregarAfinidadEntreDosProductos(idp1, idp2, afinidad);
                            System.out.println("Afinidad agregada correctamente");
                        }
                        break;

                    case MOSTRAR_MATRIZ_AFINIDADES:
                        cd.mostrarMatrizAfinidades();
                        System.out.println("Matriz mostrada correctamente");
                        break;

                    case MOSTRAR_MATRIZ_AFINIDADES_PRODUCTOS_SELECCIONADOS:
                        cd.mostrarMatrizAfinidadesProductosSeleccionados();
                        System.out.println("Matriz de productos seleccionados mostrada correctamente");
                        break;

                    // ========================
                    // Grupo 80: Gestión de distribuciones y cálculo
                    // ========================
                    /*
                    case CAMBIAR_METODO_CALCULO:
                        if (argumentos.length != 2) {
                            System.out.println("Uso incorrecto de los argumentos para CAMBIAR_METODO_CALCULO.");
                            break;
                        }
                        try {
                            AlgoritmosTSP metodoCalculo = AlgoritmosTSP.valueOf(argumentos[1].toUpperCase());
                            cd.cambiarMetodoCalculo(metodoCalculo);
                            System.out.println("Método de cálculo cambiado correctamente");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Método de cálculo inválido. Por favor, selecciona un método válido.");
                        }
                        break;
                    */

                    case SWAP_DOS_PRODUCTOS_DISTRIBUCION:
                        if (argumentos.length != 4) {
                            System.out.println("Uso incorrecto de los argumentos para SWAP_DOS_PRODUCTOS_DISTRIBUCION.");
                            break;
                        }
                        int idDistribucion = Integer.parseInt(argumentos[1]);
                        int id1 = Integer.parseInt(argumentos[2]);
                        int id2 = Integer.parseInt(argumentos[3]);
                        cd.swapDosProductosDistribucion(idDistribucion, id1, id2);
                        System.out.println("Swap de los productos realizado correctamente");
                        break;

                    // ========================
                    // Caso por defecto
                    // ========================
                    default:
                        System.out.println("Comando no implementado: " + instruccionSeleccionada.obtenerNombreYAtajo().obtenerPrimero());
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error al ejecutar el comando: " + e.getMessage());
            }
        }
        if (0 == cd.datosFijados()) { cd.InicializarSimilitudes(); }
        cd.ConfigDatosPersistencia();
        System.exit(0);
        System.out.println("Fin de la ejecución");
    }
}
