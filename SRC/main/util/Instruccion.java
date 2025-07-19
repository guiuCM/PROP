package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * La clase {@code Instruccion} representa una instrucción con un código único, nombre, atajo,
 * parámetros y un mensaje descriptivo. Esta clase también contiene un enumerado {@link Comando}
 * que define diferentes comandos disponibles.
 *
 * <p>Esta clase es fundamental para manejar las instrucciones disponibles en la aplicación,
 * proporcionando métodos para acceder a sus propiedades y una enumeración de comandos predefinidos.</p>
 */
public class Instruccion {
    /**
     * El código único de la instrucción.
     */
    private final int codigo;

    /**
     * Pareja que contiene el nombre de la instrucción y su atajo correspondiente.
     */
    private final Par<String, String> nombreYAtajo;

    /**
     * Lista de nombres de parámetros que la instrucción acepta.
     */
    private final List<String> parametros;

    /**
     * Mensaje descriptivo de la instrucción.
     */
    private final String mensaje;

    /**
     * Construye una nueva instancia de {@code Instruccion} con los parámetros especificados.
     *
     * @param codigo        el código único de la instrucción
     * @param nombreYAtajo  una pareja que contiene el nombre de la instrucción y su atajo correspondiente
     * @param parametros    una lista de nombres de parámetros que la instrucción acepta
     * @param mensaje       un mensaje descriptivo de la instrucción
     * @pre {@code nombreYAtajo}, {@code parametros} y {@code mensaje} no deben ser {@code null}
     * @post La instrucción se inicializa con el código, nombre y atajo, parámetros y mensaje proporcionados
     * @throws IllegalArgumentException si alguno de los parámetros es {@code null}
     */
    public Instruccion(int codigo, Par<String, String> nombreYAtajo, List<String> parametros, String mensaje) {
        if (nombreYAtajo == null || parametros == null || mensaje == null) {
            throw new IllegalArgumentException("Los parámetros no deben ser null.");
        }
        this.codigo = codigo;
        this.nombreYAtajo = nombreYAtajo;
        this.parametros = parametros;
        this.mensaje = mensaje;
    }

    /**
     * Obtiene el código único de la instrucción.
     *
     * @return el código de la instrucción
     */
    public int obtenerCodigo() {
        return codigo;
    }

    /**
     * Obtiene la pareja que contiene el nombre de la instrucción y su atajo correspondiente.
     *
     * @return una {@code Par} con el nombre y el atajo de la instrucción
     */
    public Par<String, String> obtenerNombreYAtajo() {
        return nombreYAtajo;
    }

    /**
     * Obtiene la lista de nombres de parámetros que la instrucción acepta.
     *
     * @return una lista de parámetros de la instrucción
     */
    public List<String> obtenerParametros() {
        return parametros;
    }

    /**
     * Obtiene el mensaje descriptivo de la instrucción.
     *
     * @return el mensaje de la instrucción
     */
    public String obtenerMensaje() {
        return mensaje;
    }

    /**
     * Obtiene el número de argumentos que la instrucción acepta.
     *
     * @return el número de argumentos
     * @post Se devuelve el tamaño de la lista de parámetros
     */
    public int obtenerNumeroArgumentos() {
        return parametros.size();
    }

    /**
     * Construye una cadena que representa el uso correcto de la instrucción, incluyendo su atajo y parámetros.
     *
     * @return una cadena que muestra el uso correcto de la instrucción
     * @post Se devuelve una cadena con el formato "(atajo) param1 param2 ..."
     */
    public String obtenerUsoCorrecto() {
        StringBuilder uso = new StringBuilder();
        uso.append("(").append(nombreYAtajo.obtenerSegundo()).append(")");
        for (String param : parametros) {
            uso.append(" ").append(param);
        }
        return uso.toString();
    }

    /**
     * Devuelve una representación en cadena de la instrucción, incluyendo su código, nombre, uso correcto y mensaje.
     *
     * @return una cadena que representa la instrucción en el formato "(codigo) nombre usoCorrecto --- mensaje"
     */
    @Override
    public String toString() {
        return "(" + codigo + ") " + nombreYAtajo.obtenerPrimero() + " " + obtenerUsoCorrecto() + " --- " + mensaje;
    }

    /**
     * El enumerado {@code Comando} define una lista de comandos disponibles, cada uno con un código,
     * nombre, atajo, parámetros y mensaje descriptivo.
     */
    public enum Comando {
        // Grupo -1: Salida
        SALIR(-1, new Par<>("salir", "s"), Collections.emptyList(), "Sale del programa"),

        // Grupo 0: Ayuda
        AYUDA(0, new Par<>("ayuda", "a"), Collections.emptyList(), "Muestra todas las comandas disponibles"),

        // Grupo 10: Gestión general
        IMPRIMIR_DISTRIBUCION(10, new Par<>("imprimirDistribucion", "id"), Arrays.asList("<num>"), "Imprime una distribución con el nombre"),
        RESETEAR_SELECCION(11, new Par<>("resetearSeleccion", "rs"), Collections.emptyList(), "Resetea la selección"),
        FIJAR_DATOS(12, new Par<>("fijarDatos", "fd"), Collections.emptyList(), "Fija productos"),
        IMPRIMIR_TODAS_LAS_DISTRIBUCIONES(13, new Par<>("imprimirTodasLasDistribuciones", "itd"), Collections.emptyList(), "Imprime todas las distribuciones con el nombre"),
        IMPRIMIR_DISTRIBUCION_ID(14, new Par<>("imprimirDistribucionID", "idi"), Arrays.asList("<num>"), "Imprime una distribución con el ID"),
        IMPRIMIR_TODAS_LAS_DISTRIBUCIONES_ID(15, new Par<>("imprimirTodasLasDistribucionesID", "itdi"), Collections.emptyList(), "Imprime todas las distribuciones con el ID"),
        EXPORTAR_PRODUCTOS_Y_SIMILITUDES(16, new Par<>("exportarProductosYSimilitudes", "ed"), Collections.emptyList(), "Exporta datos"),
        EXPORTAR_DISTRIBUCIONES(17, new Par<>("exportarDistribuciones", "id"), Collections.emptyList(), "Exporta distribuciones"),

        // Grupo 20: Gestión de usuarios y sesiones
        INICIAR_SESION(21, new Par<>("iniciarSesion", "is"), Arrays.asList("<nombre>", "<password>"), "Inicia la sesión"),
        CERRAR_SESION(22, new Par<>("cerrarSesion", "cs"), Collections.emptyList(), "Cierra la sesión"),
        QUIEN_SOY(23, new Par<>("quienSoy", "qs"), Collections.emptyList(), "Muestra el usuario actual"),
        CREAR_USUARIO(24, new Par<>("crearUsuario", "cu"), Arrays.asList("<nombre>", "<password>", "<email>", "<rol>"), "Crea el usuario con nombre especificado y si no se especifica rol, se asume usuario ESTANDAR"),
        ELIMINAR_USUARIO(26, new Par<>("eliminarUsuario", "eu"), Arrays.asList("<nombre>"), "Elimina el usuario con nombre especificado"),
        CAMBIAR_CONTRASENA(29, new Par<>("cambiarContrasena", "cc"), Arrays.asList("<oldPassword>", "<newPassword>"), "Cambia la contraseña"),

        // Grupo 40: Gestión de productos y selecciones
        LISTAR_PRODUCTOS(40, new Par<>("listarProductos", "lp"), Collections.emptyList(), "Lista todos los productos"),
        AGREGAR_PRODUCTO(41, new Par<>("agregarProducto", "ap"), Arrays.asList("<id>", "<nombre>", "<precio>", "<descripcion>", "<peso>", "<marca>"), "Agrega el producto con el ID especificado"),
        ELIMINAR_PRODUCTO(42, new Par<>("eliminarProducto", "ep"), Arrays.asList("<id>"), "Elimina el producto con el ID especificado"),
        AGREGAR_PRODUCTOS_A_LA_SELECCION(43, new Par<>("agregarProductosALaSeleccion", "apals"), Arrays.asList("<idProducto1> <idProducto2> ..."), "Selecciona una lista de productos"),
        QUITAR_PRODUCTOS_DE_LA_SELECCION(44, new Par<>("quitarProductosDeLaSeleccion", "qpdls"), Arrays.asList("<idProducto1> <idProducto2> ..."), "Deselecciona una lista de productos"),
        LISTAR_PRODUCTOS_SELECCIONADOS(45, new Par<>("listarProductosSeleccionados", "lps"), Collections.emptyList(), "Lista todos los productos seleccionados"),
        AGREGAR_ESTANTERIA_PRIORIZANDO_LA_PROXIMIDAD_LATERAL(46, new Par<>("agregarEstanteriaPriorizandoLaProximidadLateral", "aeplpl"), Arrays.asList("<algoritmo>, <numerobaldas>"), "Agrega una estantería priorizando la proximidad entre productos a su izquierda y su derecha"),
        AGREGAR_ESTANTERIA_PRIORIZANDO_LA_PROXIMIDAD_VECINA(47, new Par<>("agregarEstanteriaPriorizandoLaProximidadVecina", "aeplpv"), Arrays.asList("<algoritmo>, <numerobaldas>"), "Agrega una estantería priorizando la proximidad entre productos vecinos"),

        // Grupo 60: Gestión de afinidades
        MODIFICAR_AFINIDAD(60, new Par<>("modificarAfinidad", "ma"), Arrays.asList("<producto1>", "<producto2>", "<valor>"), "Modifica la afinidad entre productos"),
        AGREGAR_AFINIDAD_ENTRE_DOS_PRODUCTOS(61, new Par<>("agregarAfinidadEntreDosProductos", "aae2p"), Arrays.asList("<idProducto1>", "<idProducto2>", "afinidad"), "Agrega afinidad entre dos productos"),
        MOSTRAR_MATRIZ_AFINIDADES(63, new Par<>("mostrarMatrizAfinidades", "mma"), Collections.emptyList(), "Muestra la matriz de afinidades por pantalla"),
        MOSTRAR_MATRIZ_AFINIDADES_PRODUCTOS_SELECCIONADOS(64, new Par<>("mostrarMatrizAfinidadesProductosSeleccionados", "mmaps"), Collections.emptyList(), "Muestra la matriz de afinidades de los productos seleccionados por pantalla"),

        // Grupo 80: Gestión de distribuciones y cálculo
        CAMBIAR_METODO_CALCULO(80, new Par<>("cambiarMetodoCalculo", "cmc"), Arrays.asList("Algoritmo"), "Selecciona el método de cálculo"),
        SWAP_DOS_PRODUCTOS_DISTRIBUCION(81, new Par<>("swapDosProductosDistribucion", "sdpd"), Arrays.asList("<idDist>", "<idProducto1>", "<idProducto2>"), "Intercambia dos productos de la distribución");

        /**
         * La instrucción asociada al comando.
         */
        private final Instruccion instruccion;

        /**
         * Construye una nueva instancia de {@code Comando} con los parámetros especificados.
         *
         * @param codigo        el código único del comando
         * @param nombreYAtajo  una pareja que contiene el nombre del comando y su atajo correspondiente
         * @param parametros    una lista de nombres de parámetros que el comando acepta
         * @param mensaje       un mensaje descriptivo del comando
         */
        Comando(int codigo, Par<String, String> nombreYAtajo, List<String> parametros, String mensaje) {
            this.instruccion = new Instruccion(codigo, nombreYAtajo, parametros, mensaje);
        }

        /**
         * Obtiene la instrucción asociada a este comando.
         *
         * @return una instancia de {@code Instruccion} que representa el comando
         */
        public Instruccion obtenerInstruccion() {
            return instruccion;
        }
    }
}
