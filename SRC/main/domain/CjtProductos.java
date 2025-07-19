package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * La clase {@code CjtProductos} representa un conjunto centralizado de productos gestionados en el sistema.
 * Implementa el patrón Singleton, asegurando que solo haya una instancia única de productos, accesible
 * a través del método {@link CjtProductos#obtenerInstancia()}.
 *
 * <p>Principales responsabilidades:
 * <ul>
 *     <li>Gestionar los productos disponibles en el sistema.</li>
 *     <li>Almacenar y gestionar afinidades entre productos.</li>
 *     <li>Permitir la selección de productos para operaciones específicas como cálculos de afinidades o distribuciones.</li>
 *     <li>Fijar y controlar el estado de los datos (productos y afinidades) para evitar modificaciones no deseadas.</li>
 * </ul>
 *
 * <p>Atributos y métodos destacados:
 * <ul>
 *     <li>Constructor privado para asegurar que solo exista una instancia mediante el patrón Singleton.</li>
 *     <li>Método para agregar productos al conjunto de productos gestionados.</li>
 *     <li>Método para fijar los datos y las matrices de afinidades.</li>
 *     <li>Método para agregar y eliminar afinidades entre productos.</li>
 *     <li>Métodos para mostrar las matrices de afinidades y los productos seleccionados.</li>
 *     <li>Control de selección y deselección de productos, con actualización de la matriz de afinidades seleccionados.</li>
 * </ul>
 *
 * <p>Este tipo de clase está diseñada para centralizar la gestión de productos, sus afinidades y las operaciones
 * específicas que involucran productos seleccionados, proporcionando métodos eficientes para interactuar con ellos.
 *
 * @see Producto
 * @see CjtProductos#obtenerInstancia()
 */
public class CjtProductos {
    /**
     * Instancia única de la clase {@code CjtProductos} (patrón Singleton).
     * Este atributo asegura que solo exista una única instancia de la clase en toda la aplicación,
     * permitiendo un acceso centralizado a los productos gestionados.
     *
     * <p>Esta instancia se inicializa de manera controlada y se obtiene mediante el método estático
     * {@code obtenerInstancia}.
     */
    private static CjtProductos instance;

    /**
     * Mapa que asocia los identificadores únicos (IDs) de los productos con sus instancias correspondientes.
     *
     * <p>Clave: Un entero que representa el ID único del producto.</p>
     * <p>Valor: Un objeto de tipo {@link Producto} que contiene la información del producto asociado.</p>
     *
     * <p>Este mapa se utiliza para gestionar los productos de manera dinámica dentro del sistema,
     * permitiendo un acceso eficiente a los productos a través de su ID.</p>
     */
    private Map<Integer, Producto> productosDinamicos;

    /**
     * Matriz que representa la afinidad entre los productos.
     *
     * <p>Cada elemento de la matriz, {@code matrizAfinidad[i][j]}, indica el nivel de afinidad entre
     * el producto con ID {@code i} y el producto con ID {@code j}.</p>
     *
     * <p>La afinidad puede ser utilizada para calcular relaciones o proximidades entre productos,
     * optimizar distribuciones, o sugerir combinaciones basadas en similitudes.</p>
     *
     * <p>Dimensiones: La matriz es cuadrada, con un tamaño igual al número total de productos en el sistema.</p>
     */
    private int[][] matrizAfinidad;

    /**
     * Indica si los datos asociados al sistema están fijados y no pueden ser modificados.
     *
     * <p>Este atributo se utiliza para controlar si ciertas operaciones, como la modificación de productos
     * o afinidades, están permitidas. Cuando su valor es {@code true}, los datos son considerados inmutables.</p>
     *
     * <p>Valores posibles:
     * <ul>
     *     <li>{@code true}: Los datos están fijados y no pueden ser modificados.</li>
     *     <li>{@code false}: Los datos son modificables.</li>
     * </ul>
     */
    private boolean datosFijados;

    /**
     * Lista que almacena los productos seleccionados por el usuario.
     *
     * <p>La lista contiene objetos de tipo {@link Producto} que han sido seleccionados para
     * operaciones específicas, como configuraciones de distribuciones o cálculos de afinidad.</p>
     *
     * <p>Características:
     * <ul>
     *     <li>Ordenada: Los productos se almacenan en el orden en que fueron seleccionados.</li>
     *     <li>Modificable: Productos pueden ser añadidos o eliminados según las necesidades del usuario.</li>
     * </ul>
     *
     * <p>Esta lista se utiliza principalmente para personalizar operaciones relacionadas con
     * un subconjunto de productos en lugar de trabajar con todos los productos disponibles.</p>
     */
    private List<Producto> productosSeleccionados;

    /**
     * Mapa que representa las afinidades entre los productos seleccionados.
     *
     * <p>La estructura es un mapa de mapas:
     * <ul>
     *     <li>Clave externa: Un entero que representa el ID de un producto seleccionado.</li>
     *     <li>Valor: Otro mapa, donde:
     *         <ul>
     *             <li>Clave: El ID de otro producto seleccionado.</li>
     *             <li>Valor: La afinidad entre ambos productos.</li>
     *         </ul>
     *     </li>
     * </ul>
     * </p>
     *
     * <p>Uso principal:
     * <ul>
     *     <li>Permitir cálculos y operaciones específicas para productos seleccionados en lugar de todos los productos.</li>
     *     <li>Optimizar distribuciones o análisis basados en un subconjunto más relevante de datos.</li>
     * </ul>
     */
    private Map<Integer, Map<Integer, Integer>> matrizAfinidadesSeleccionados;

    /**
     * Constructor privado de la clase {@code CjtProductos}.
     *
     * <p>Inicializa las estructuras de datos internas utilizadas para gestionar los productos y su estado:
     * <ul>
     *     <li>{@code productosDinamicos}: Se inicializa como un {@link LinkedHashMap} para mantener un orden
     *     predecible de inserción al gestionar los productos dinámicos.</li>
     *     <li>{@code datosFijados}: Se inicializa en {@code false}, indicando que los datos son modificables
     *     por defecto.</li>
     *     <li>{@code productosSeleccionados}: Se inicializa como una {@link ArrayList} para almacenar productos
     *     seleccionados de manera dinámica.</li>
     * </ul>
     * </p>
     *
     * <p>El constructor es privado para implementar el patrón Singleton, asegurando que solo una instancia
     * de la clase sea creada y accesible a través de métodos controlados.</p>
     */
    private CjtProductos() {
        productosDinamicos = new LinkedHashMap<>();
        datosFijados = false;
        productosSeleccionados = new ArrayList<>();
    }

    /**
     * Obtiene la instancia única de la clase {@code CjtProductos} utilizando el patrón Singleton.
     *
     * <p>Este método asegura que solo exista una única instancia de la clase durante la ejecución de la aplicación.
     * Si la instancia aún no ha sido creada, se inicializa mediante el constructor privado.</p>
     *
     * @return La instancia única de la clase {@code CjtProductos}.
     */
    public static CjtProductos obtenerInstancia() {
        if (instance == null) {
            instance = new CjtProductos();
        }
        return instance;
    }

    /**
     * Agrega un nuevo producto al conjunto de productos gestionados.
     *
     * <p>Este método valida todos los parámetros antes de agregar el producto al mapa de productos dinámicos.
     * Si los datos ya están fijados o si el ID del producto ya existe, lanza una excepción.</p>
     *
     * @param id El ID único del producto. No debe coincidir con el ID de un producto existente.
     * @param nombre El nombre del producto. No debe ser nulo ni estar vacío.
     * @param precio El precio del producto. Debe ser mayor o igual a cero.
     * @param descripcion La descripción del producto. No debe ser nula ni estar vacía.
     * @param peso El peso del producto. Debe ser mayor que cero.
     * @param marca La marca del producto. No debe ser nula ni estar vacía.
     *
     * @throws IllegalStateException Si los datos están fijados y no se permiten más modificaciones.
     * @throws IllegalArgumentException Si:
     *         <ul>
     *             <li>El ID del producto ya existe.</li>
     *             <li>El nombre del producto es nulo o está vacío.</li>
     *             <li>El precio del producto es negativo.</li>
     *             <li>La descripción del producto es nula o está vacía.</li>
     *             <li>El peso del producto es menor o igual a cero.</li>
     *             <li>La marca del producto es nula o está vacía.</li>
     *         </ul>
     */
    public void agregarProducto(int id, String nombre, double precio, String descripcion, double peso, String marca) {
        if (datosFijados) {
            throw new IllegalStateException("Los datos ya han sido fijados. No se pueden agregar más productos.");
        }
        if (productosDinamicos.containsKey(id)) {
            throw new IllegalArgumentException("Ya existe un producto con el ID: " + id);
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no debe ser null ni estar vacío.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del producto debe ser mayor o igual a cero.");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no debe ser null ni estar vacía.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso del producto debe ser mayor que cero.");
        }
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca no debe ser null ni estar vacía.");
        }

        Producto producto = new Producto(id, nombre, precio, descripcion, peso, marca);
        productosDinamicos.put(id, producto);
    }

    /**
     * Muestra en consola la matriz de afinidades entre los productos seleccionados.
     *
     * <p>Este método genera una representación tabular donde las filas y columnas representan los productos
     * seleccionados y las celdas contienen los valores de afinidad entre ellos. Si un producto no tiene afinidad
     * registrada con otro, se muestra un guion {@code -} en la celda correspondiente. Además, los valores en
     * la diagonal principal (afinidad consigo mismo) se muestran como {@code 100}.</p>
     *
     * <p>Características principales:
     * <ul>
     *     <li>Los productos seleccionados se obtienen de la estructura {@code matrizAfinidadesSeleccionados}.</li>
     *     <li>Los nombres de los productos se obtienen de {@code productosDinamicos}.</li>
     *     <li>Se ajusta dinámicamente el ancho de las columnas para una mejor visualización.</li>
     *     <li>Si un producto no tiene un nombre asociado, se muestra como {@code ID_X}, donde {@code X} es su ID.</li>
     * </ul>
     * </p>
     *
     * <p>Formato de la tabla:
     * <ul>
     *     <li>Primera fila: Encabezados de las columnas, centrados y ajustados dinámicamente.</li>
     *     <li>Primera columna: Encabezados de las filas con nombres de los productos y sus IDs.</li>
     *     <li>Celdas: Valores de afinidad entre productos, centrados y ajustados dinámicamente.</li>
     * </ul>
     * </p>
     */
    public void mostrarMatrizAfinidadesProductosSeleccionados() {
        System.out.println("Matriz de Afinidades de Productos Seleccionados:");

        List<Integer> idsProductos = new ArrayList<>(matrizAfinidadesSeleccionados.keySet());
        for (Map<Integer, Integer> afinidades : matrizAfinidadesSeleccionados.values()) {
            for (Integer id : afinidades.keySet()) {
                if (!idsProductos.contains(id)) {
                    idsProductos.add(id);
                }
            }
        }
        Collections.sort(idsProductos);

        Map<Integer, String> idToName = new HashMap<>();
        Map<Integer, Integer> columnWidths = new HashMap<>();
        int maxValueWidth = 3;

        for (Integer id : idsProductos) {
            Producto producto = productosDinamicos.get(id);
            String nombreProducto = (producto != null) ? producto.obtenerNombre() : "ID_" + id;
            String nombreConId = nombreProducto + " [" + id + "]";
            idToName.put(id, nombreConId);
            int columnWidth = Math.max(nombreConId.length(), maxValueWidth) + 2;
            columnWidths.put(id, columnWidth);
        }

        int firstColumnWidth = Collections.max(columnWidths.values());
        String formatFirstColumn = "%-" + firstColumnWidth + "s";

        System.out.printf(formatFirstColumn, "");
        for (Integer idColumna : idsProductos) {
            String nombreColumna = idToName.get(idColumna);
            int columnWidth = columnWidths.get(idColumna);
            String formattedName = centerString(nombreColumna, columnWidth);
            System.out.print(formattedName);
        }
        System.out.println();

        for (Integer idFila : idsProductos) {
            String nombreFila = idToName.get(idFila);
            int rowNameWidth = firstColumnWidth;
            String formattedRowName = String.format("%-" + rowNameWidth + "s", nombreFila);
            System.out.print(formattedRowName);

            for (Integer idColumna : idsProductos) {
                Integer afinidad;
                if (idFila.equals(idColumna)) {
                    afinidad = 100;
                } else {
                    Map<Integer, Integer> afinidadesFila = matrizAfinidadesSeleccionados.get(idFila);
                    if (afinidadesFila != null) {
                        afinidad = afinidadesFila.get(idColumna);
                    } else {
                        afinidad = null;
                    }
                }
                String valorMostrar = (afinidad != null) ? afinidad.toString() : "-";
                int columnWidth = columnWidths.get(idColumna);
                String formattedValue = centerString(valorMostrar, columnWidth);
                System.out.print(formattedValue);
            }
            System.out.println();
        }
    }

    /**
     * Centra un texto dentro de un ancho especificado añadiendo espacios a la izquierda y a la derecha.
     *
     * <p>Si el texto es más largo o igual al ancho especificado, se devuelve sin modificaciones.
     * Si el texto es más corto, se calcula la cantidad de espacios necesarios para centrarlo
     * y se añaden equitativamente a ambos lados. Si hay un espacio sobrante, se asigna a la izquierda.</p>
     *
     * @param text El texto que se desea centrar. No debe ser nulo.
     * @param width El ancho total dentro del cual se desea centrar el texto.
     * @return Una cadena con el texto centrado dentro del ancho especificado.
     */
    private String centerString(String text, int width) {
        if (text.length() >= width) {
            return text;
        } else {
            int totalPadding = width - text.length();
            int leftPadding = (totalPadding + 1) / 2;
            int rightPadding = totalPadding - leftPadding;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < leftPadding; i++) {
                sb.append(" ");
            }
            sb.append(text);
            for (int i = 0; i < rightPadding; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }

    /**
     * Elimina un producto del conjunto de productos gestionados dado su ID.
     *
     * <p>Este método verifica si los datos están fijados antes de permitir la eliminación. Si los datos
     * están fijados, lanza una excepción. También valida que el producto con el ID especificado exista
     * en el conjunto antes de intentar eliminarlo.</p>
     *
     * @param id El ID del producto que se desea eliminar.
     *
     * @throws IllegalStateException Si los datos están fijados y no se permite eliminar productos.
     * @throws IllegalArgumentException Si no existe un producto con el ID especificado.
     */
    public void eliminarProducto(int id) {
        if (datosFijados) {
            throw new IllegalStateException("Los datos ya han sido fijados. No se pueden eliminar productos.");
        }
        if (!productosDinamicos.containsKey(id)) {
            throw new IllegalArgumentException("No existe un producto con el ID: " + id);
        }
        productosDinamicos.remove(id);
    }

    /**
     * Fija los datos del conjunto de productos, marcándolos como inmutables y preparando
     * las estructuras necesarias para gestionar afinidades entre productos.
     *
     * <p>Este método realiza las siguientes operaciones:
     * <ul>
     *     <li>Verifica si los datos ya están fijados. Si es así, lanza una {@link IllegalStateException}.</li>
     *     <li>Comprueba que existe al menos un producto en {@code productosDinamicos}. Si no es así,
     *     lanza una {@link IllegalArgumentException}.</li>
     *     <li>Crea y inicializa la matriz de afinidades {@code matrizAfinidad}, que es cuadrada y tiene
     *     un tamaño igual al número de productos en {@code productosDinamicos}.</li>
     *     <li>Asigna un índice de posición de matriz a cada producto mediante el método
     *     {@code establecerPosMatriz}.</li>
     *     <li>Inicializa todos los valores de la matriz de afinidades en 0.</li>
     *     <li>Marca los datos como fijados estableciendo {@code datosFijados} a {@code true}.</li>
     * </ul>
     * </p>
     *
     * @throws IllegalStateException Si los datos ya están fijados y no se permite realizar esta operación.
     * @throws IllegalArgumentException Si no hay productos en {@code productosDinamicos}.
     */
    public void fijarDatos() {
        if (datosFijados) {
            throw new IllegalStateException("Los datos ya han sido fijados. No se pueden fijar nuevos datos.");
        }
        if (productosDinamicos.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos un producto para fijar los datos.");
        }

        int n = productosDinamicos.size();
        matrizAfinidad = new int[n][n];

        int index = 0;
        for (Producto producto : productosDinamicos.values()) {
            producto.establecerPosMatriz(index);
            index++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizAfinidad[i][j] = 0;
            }
        }
        datosFijados = true;
    }

    public void desfijarDatos() {
        if (!datosFijados) {
            throw new IllegalStateException("Los datos no estan fijados.");
        }
        matrizAfinidad = null;
        productosSeleccionados.clear();
        datosFijados = false;
    }

    /**
     * Agrega o actualiza la afinidad entre dos productos en la matriz de afinidades general
     * y, si corresponde, en la submatriz de productos seleccionados.
     *
     * <p>Este método realiza las siguientes operaciones:
     * <ul>
     *     <li>Verifica que los datos estén fijados antes de permitir la modificación.</li>
     *     <li>Valida que los IDs de los productos sean diferentes y que ambos existan.</li>
     *     <li>Actualiza la matriz de afinidades general para reflejar la afinidad entre los productos.</li>
     *     <li>Si ambos productos están seleccionados, también actualiza la submatriz de afinidades de productos seleccionados.</li>
     * </ul>
     * </p>
     *
     * @param id1 El ID del primer producto.
     * @param id2 El ID del segundo producto.
     * @param valor El valor de afinidad a establecer entre los dos productos.
     *
     * @throws IllegalStateException Si los datos no están fijados.
     * @throws IllegalArgumentException Si:
     *         <ul>
     *             <li>Se intenta establecer afinidad entre el mismo producto.</li>
     *             <li>Uno o ambos productos no existen.</li>
     *         </ul>
     */
    public void agregarAfinidadEntreDosProductos(int id1, int id2, int valor) {
        if (!datosFijados) {
            throw new IllegalStateException("Los datos aún no han sido fijados. No se pueden agregar afinidades.");
        }
        if (id1 == id2) {
            throw new IllegalArgumentException("No se puede establecer afinidad entre el mismo producto.");
        }
        Producto prod1 = obtenerProducto(id1);
        Producto prod2 = obtenerProducto(id2);
        if (prod1 == null || prod2 == null) {
            throw new IllegalArgumentException("Uno o ambos productos no existen.");
        }

        int pos1 = prod1.obtenerPosMatriz();
        int pos2 = prod2.obtenerPosMatriz();

        matrizAfinidad[pos1][pos2] = valor;
        matrizAfinidad[pos2][pos1] = valor;

        if (productosSeleccionados != null && !productosSeleccionados.isEmpty() && matrizAfinidadesSeleccionados != null) {
            Set<Integer> idsProductosSeleccionados = productosSeleccionados.stream()
                    .map(Producto::obtenerId)
                    .collect(Collectors.toSet());

            if (idsProductosSeleccionados.contains(id1) && idsProductosSeleccionados.contains(id2)) {
                matrizAfinidadesSeleccionados.computeIfAbsent(id1, k -> new HashMap<>()).put(id2, valor);
                matrizAfinidadesSeleccionados.computeIfAbsent(id2, k -> new HashMap<>()).put(id1, valor);

                System.out.println("La afinidad entre los productos con ID " + id1 + " y " + id2 + " ha sido actualizada en la submatriz de productos seleccionados.");
            } else {
                System.out.println("La afinidad se actualizó en la matriz general, pero no en la submatriz de productos seleccionados porque uno o ambos productos no están seleccionados.");
            }
        } else {
            System.out.println("No hay productos seleccionados o la submatriz de afinidades no está inicializada. Solo se actualizó la matriz general.");
        }
    }

    /**
     * Obtiene la cantidad total de productos almacenados en el conjunto dinámico de productos.
     *
     * @return Un entero que representa el número de productos actualmente gestionados en {@code productosDinamicos}.
     */
    public int obtenerProductosLength() {
        return productosDinamicos.size();
    }

    /**
     * Muestra en consola la matriz de afinidades entre todos los productos gestionados.
     *
     * <p>Este método genera una tabla tabular que representa la matriz de afinidades entre productos.
     * Las filas y columnas corresponden a los productos, y cada celda muestra el valor de afinidad entre
     * dos productos. Si un producto no tiene una afinidad definida con otro, la celda muestra un guion {@code -}.
     * Los valores en la diagonal principal (afinidad de un producto consigo mismo) se establecen en {@code 100}.</p>
     *
     * <p>Características principales:
     * <ul>
     *     <li>Los productos se ordenan de acuerdo con su posición en la matriz, obtenida mediante {@code obtenerPosMatriz()}.</li>
     *     <li>Se ajusta dinámicamente el ancho de las columnas para adaptarse al nombre más largo o al valor de afinidad más grande.</li>
     *     <li>Los nombres de los productos incluyen su ID entre corchetes para mayor claridad.</li>
     * </ul>
     * </p>
     *
     * <p>Formato de la tabla:
     * <ul>
     *     <li>Primera fila: Encabezados de las columnas con nombres e IDs de los productos, centrados y ajustados dinámicamente.</li>
     *     <li>Primera columna: Encabezados de las filas con nombres e IDs de los productos, alineados a la izquierda.</li>
     *     <li>Celdas: Valores de afinidad entre productos, centrados y ajustados dinámicamente.</li>
     * </ul>
     * </p>
     */
    public void mostrarMatrizAfinidades() {
        System.out.println("Matriz de Afinidades:");

        int n = productosDinamicos.size();
        Producto[] productosOrdenados = new Producto[n];
        for (Producto producto : productosDinamicos.values()) {
            int pos = producto.obtenerPosMatriz();
            productosOrdenados[pos] = producto;
        }

        Map<Integer, String> posToName = new HashMap<>();
        Map<Integer, Integer> columnWidths = new HashMap<>();
        int maxValueWidth = 3;
        int maxNameLength = 0;

        for (int i = 0; i < n; i++) {
            Producto producto = productosOrdenados[i];
            String nombreProducto = (producto != null) ? producto.obtenerNombre() : "Pos_" + i;
            String nombreConId = nombreProducto + " [" + producto.obtenerId() + "]";
            posToName.put(i, nombreConId);
            int nameLength = nombreConId.length();
            if (nameLength > maxNameLength) {
                maxNameLength = nameLength;
            }
            int columnWidth = Math.max(nameLength, maxValueWidth) + 2; // Añadir espacio adicional
            columnWidths.put(i, columnWidth);
        }

        int firstColumnWidth = maxNameLength + 2;
        String formatFirstColumn = "%-" + firstColumnWidth + "s";

        System.out.printf(formatFirstColumn, "");
        for (int j = 0; j < n; j++) {
            String nombreColumna = posToName.get(j);
            int columnWidth = columnWidths.get(j);
            String formattedName = centerString(nombreColumna, columnWidth);
            System.out.print(formattedName);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            String nombreFila = posToName.get(i);
            String formattedRowName = String.format("%-" + firstColumnWidth + "s", nombreFila);
            System.out.print(formattedRowName);

            for (int j = 0; j < n; j++) {
                Integer afinidad;
                if (i == j) {
                    afinidad = 100;
                } else {
                    afinidad = matrizAfinidad[i][j];
                }
                String valorMostrar = (afinidad != null) ? afinidad.toString() : "-";
                int columnWidth = columnWidths.get(j);
                String formattedValue = centerString(valorMostrar, columnWidth);
                System.out.print(formattedValue);
            }
            System.out.println();
        }
    }

    /**
     * Elimina la afinidad entre dos productos en la matriz de afinidades general.
     *
     * <p>Este método realiza las siguientes operaciones:
     * <ul>
     *     <li>Verifica que los datos estén fijados antes de permitir la eliminación.</li>
     *     <li>Valida que ambos productos existan y no sean el mismo producto.</li>
     *     <li>Establece a {@code 0} el valor de afinidad entre los productos en ambas direcciones
     *     en la matriz de afinidades.</li>
     * </ul>
     * </p>
     *
     * @param id1 El ID del primer producto.
     * @param id2 El ID del segundo producto.
     *
     * @throws IllegalStateException Si los datos no están fijados.
     * @throws IllegalArgumentException Si:
     *         <ul>
     *             <li>Ambos IDs corresponden al mismo producto.</li>
     *             <li>Uno o ambos productos no existen en el sistema.</li>
     *         </ul>
     */
    public void eliminarAfinidadEntreDosProductos(int id1, int id2) {
        if (!datosFijados) {
            throw new IllegalStateException("Los datos aún no han sido fijados. No se pueden eliminar afinidades.");
        }
        Producto prod1 = obtenerProducto(id1);
        Producto prod2 = obtenerProducto(id2);
        if (prod1 == prod2) {
            throw new IllegalArgumentException("Son el mismo producto.");
        }
        if (prod1 == null || prod2 == null) {
            throw new IllegalArgumentException("Uno o ambos productos no existen.");
        }
        int pos1 = prod1.obtenerPosMatriz();
        int pos2 = prod2.obtenerPosMatriz();
        matrizAfinidad[pos1][pos2] = 0;
        matrizAfinidad[pos2][pos1] = 0;
    }

    /**
     * Obtiene el producto asociado al ID especificado.
     *
     * <p>Este método busca en el mapa de productos dinámicos y devuelve el producto correspondiente
     * al ID proporcionado. Si el ID no existe en el mapa, devuelve {@code null}.</p>
     *
     * @param id El ID del producto que se desea obtener. Debe ser mayor o igual a cero.
     *
     * @return El producto asociado al ID proporcionado, o {@code null} si no existe.
     *
     * @throws IllegalArgumentException Si el ID es menor que cero.
     */
    public Producto obtenerProducto(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID del producto debe ser mayor o igual a cero.");
        }
        return productosDinamicos.get(id);
    }

    /**
     * Obtiene una lista de todos los productos almacenados en el conjunto dinámico de productos.
     *
     * <p>Este método devuelve una nueva lista que contiene todos los valores (productos) del mapa
     * {@code productosDinamicos}. La lista devuelta es independiente del mapa original, por lo que
     * cualquier modificación a la lista no afectará al mapa subyacente.</p>
     *
     * @return Una lista de objetos {@link Producto} que representa todos los productos gestionados.
     *         Si no hay productos, devuelve una lista vacía.
     */
    public List<Producto> obtenerTodosLosProductos() {
        return new ArrayList<>(productosDinamicos.values());
    }

    /**
     * Obtiene el mapa de productos dinámicos gestionados.
     *
     * <p>Este método devuelve el mapa {@code productosDinamicos}, donde las claves son los IDs únicos
     * de los productos y los valores son las instancias de {@link Producto} correspondientes.</p>
     *
     * <p>Nota: La referencia al mapa original es devuelta, por lo que cualquier modificación directa
     * al mapa afectará los datos subyacentes.</p>
     *
     * @return El mapa de productos dinámicos gestionados, donde:
     *         <ul>
     *             <li>Clave: Un entero que representa el ID del producto.</li>
     *             <li>Valor: Un objeto {@link Producto} asociado al ID.</li>
     *         </ul>
     */
    public Map<Integer, Producto> obtenerProductosDinamicos() {
        return productosDinamicos;
    }

    /**
     * Obtiene la lista de productos seleccionados.
     *
     * <p>Este método devuelve la lista {@code productosSeleccionados}, que contiene los productos
     * seleccionados para operaciones específicas, como cálculos de afinidad o distribuciones.
     * La lista devuelta es una referencia directa, por lo que cualquier modificación afectará
     * la lista subyacente.</p>
     *
     * @return Una lista de objetos {@link Producto} que representa los productos seleccionados.
     *         Si no hay productos seleccionados, devuelve una lista vacía.
     */
    public List<Producto> obtenerProductosSeleccionados() {
        return productosSeleccionados;
    }

    /**
     * Obtiene el valor de afinidad entre dos productos dados sus IDs.
     *
     * <p>Este método busca en la matriz de afinidades el valor correspondiente a la relación
     * entre los dos productos especificados. Los productos deben existir en el conjunto, y
     * los datos deben estar fijados antes de invocar este método.</p>
     *
     * @param id1 El ID del primer producto.
     * @param id2 El ID del segundo producto.
     *
     * @return Un entero que representa el valor de afinidad entre los dos productos.
     *         Si no hay afinidad registrada, devuelve {@code 0}.
     *
     * @throws IllegalStateException Si los datos aún no han sido fijados.
     * @throws IllegalArgumentException Si uno o ambos productos no existen en el conjunto.
     */
    public Integer obtenerAfinidad(int id1, int id2) { // Renombrado
        if (!datosFijados) {
            throw new IllegalStateException("Los datos aún no han sido fijados.");
        }
        Producto prod1 = productosDinamicos.get(id1);
        Producto prod2 = productosDinamicos.get(id2);
        if (prod1 == null || prod2 == null) {
            throw new IllegalArgumentException("Uno o ambos productos no existen.");
        }
        int pos1 = prod1.obtenerPosMatriz();
        int pos2 = prod2.obtenerPosMatriz();
        return matrizAfinidad[pos1][pos2];
    }

    /**
     * Establece una nueva instancia para la clase {@code CjtProductos}.
     *
     * <p>Este método permite sobrescribir la instancia única de la clase {@code CjtProductos},
     * generalmente para propósitos de prueba o reinicialización. La nueva instancia debe ser no nula.</p>
     *
     * @param nuevaInstancia La nueva instancia de {@code CjtProductos} a establecer. No debe ser nula.
     *
     * @throws IllegalArgumentException Si la nueva instancia proporcionada es {@code null}.
     */
    public static void establecerInstancia(CjtProductos nuevaInstancia) { // Renombrado
        if (nuevaInstancia == null) {
            throw new IllegalArgumentException("La nueva instancia no puede ser null.");
        }
        instance = nuevaInstancia;
    }

    /**
     * Reinicia la selección de productos eliminando todos los productos de la lista de seleccionados.
     *
     * <p>Este método vacía la lista {@code productosSeleccionados}, asegurándose de que no contenga
     * ningún producto. Si la lista ya está vacía, lanza una excepción.</p>
     *
     * @throws IllegalArgumentException Si la lista de productos seleccionados ya está vacía o es {@code null}.
     */
    public void resetarSeleccion() {
        if (productosSeleccionados == null || productosSeleccionados.isEmpty()) {
            throw new IllegalArgumentException("La lista ya está vacía.");
        }
        productosSeleccionados.clear();
    }

    /**
     * Agrega productos a la lista de productos seleccionados.
     *
     * <p>Este método permite agregar una lista de productos a la selección de productos. Si un producto
     * ya está en la lista de productos seleccionados, se omite y se muestra un mensaje. Si el producto
     * no existe en el conjunto de productos disponibles, también se omite y se muestra un mensaje. Además,
     * se actualiza la matriz de afinidades de los productos seleccionados.</p>
     *
     * @param productIds Un arreglo de IDs de productos a agregar a la selección. No debe ser nulo ni vacío.
     *
     * @throws IllegalArgumentException Si el arreglo de IDs de productos es nulo o está vacío.
     */
    public void agregarProductosALaSeleccion(int[] productIds) {
        if (productIds == null || productIds.length == 0) {
            throw new IllegalArgumentException("La lista de productos no debe ser null ni estar vacía.");
        }

        if (this.productosSeleccionados == null) {
            this.productosSeleccionados = new ArrayList<>();
        }

        Set<Integer> idsSeleccionados = new HashSet<>();
        for (Producto producto : this.productosSeleccionados) {
            idsSeleccionados.add(producto.obtenerId());
        }

        for (Integer id : productIds) {
            if (!productosDinamicos.containsKey(id)) {
                System.out.println("No existe un producto con el ID: " + id + ". Se omite este producto.");
                continue;
            }

            if (idsSeleccionados.contains(id)) {
                System.out.println("El producto con ID " + id + " y nombre " +
                        productosDinamicos.get(id).obtenerNombre() + " ya está en la lista.");
            } else {
                this.productosSeleccionados.add(productosDinamicos.get(id));
                idsSeleccionados.add(id);
                System.out.println("Producto con ID " + id + " añadido correctamente.");
            }
        }

        this.matrizAfinidadesSeleccionados = new HashMap<>();
        for (Producto producto1 : this.productosSeleccionados) {
            Map<Integer, Integer> afinidades = new HashMap<>();
            for (Producto producto2 : this.productosSeleccionados) {
                if (!producto1.equals(producto2)) {
                    Integer afinidad = obtenerAfinidad(producto1.obtenerId(), producto2.obtenerId());
                    if (afinidad != null && afinidad != -1) {
                        afinidades.put(producto2.obtenerId(), afinidad);
                    }
                }
            }
            matrizAfinidadesSeleccionados.put(producto1.obtenerId(), afinidades);
        }
    }

    /**
     * Elimina los productos especificados de la lista de productos seleccionados.
     *
     * <p>Este método permite deseleccionar productos de la lista {@code productosSeleccionados} dada
     * una lista de IDs. Si un producto no existe o no está seleccionado, se omite. Además, se actualiza
     * la matriz de afinidades para reflejar la eliminación de los productos seleccionados.</p>
     *
     * @param productIds Un arreglo de IDs de productos a deseleccionar. No debe ser nulo ni vacío.
     *
     * @throws IllegalArgumentException Si el arreglo de IDs de productos es nulo o está vacío.
     */
    public void deseleccionarListaProductos(int[] productIds) {
        if (productIds == null || productIds.length == 0) {
            throw new IllegalArgumentException("La lista de productos no debe ser null ni estar vacía.");
        }

        Set<Integer> idsYaTratados = new HashSet<>();

        for (Integer id : productIds) {
            if (!productosDinamicos.containsKey(id)) {
                System.out.println("No existe un producto con el ID: " + id + ". Se omite este producto.");
                continue;
            }

            if (idsYaTratados.contains(id)) {
                System.out.println("El producto con ID " + id + " está repetido en la lista de entrada. Se omite este producto.");
                continue;
            }

            idsYaTratados.add(id);

            boolean productoEncontrado = this.productosSeleccionados.removeIf(producto -> producto.obtenerId() == id);
            if (!productoEncontrado) {
                System.out.println("El producto con ID " + id + " no está en la lista de productos seleccionados. Se omite este producto.");
                continue;
            }

            matrizAfinidadesSeleccionados.remove(id);

            for (Map<Integer, Integer> afinidades : matrizAfinidadesSeleccionados.values()) {
                afinidades.remove(id);
            }

            System.out.println("Producto con ID " + id + " deseleccionado correctamente.");
        }
    }

    /**
     * Obtiene la lista de productos actualmente seleccionados.
     *
     * <p>Este método devuelve la lista {@code productosSeleccionados} que contiene los productos
     * que han sido seleccionados para realizar operaciones adicionales, como el cálculo de afinidades
     * o distribuciones.</p>
     *
     * @return Una lista de objetos {@link Producto} que representa los productos seleccionados.
     *         Si no hay productos seleccionados, devuelve una lista vacía.
     */
    public List<Producto> obtenerListaProductosSeleccionados() {
        return productosSeleccionados;
    }

    /**
     * Restablece la instancia de {@code CjtProductos} a {@code null}.
     *
     * <p>Este método permite restablecer la instancia única de la clase {@code CjtProductos},
     * dejándola en un estado en el que puede ser inicializada de nuevo.</p>
     *
     * <p>Es útil para escenarios donde se desea reiniciar el estado de la clase o para pruebas
     * que requieren una nueva instancia.</p>
     */
    public static void resetearInstancia() { // Renombrado
        instance = null;
    }

    /**
     * Obtiene la matriz de afinidades entre los productos seleccionados.
     *
     * <p>Este método construye y devuelve una matriz bidimensional de enteros representando
     * las afinidades entre los productos seleccionados. La matriz es de tamaño {@code n x n}, donde
     * {@code n} es el número de productos seleccionados. Cada celda de la matriz contiene el valor de
     * afinidad entre los productos correspondientes a esa fila y columna. La diagonal principal se
     * llena con el valor {@code 100}, representando la afinidad de un producto consigo mismo.</p>
     *
     * <p>Si no existe una afinidad registrada entre dos productos, la matriz se mantiene con el valor
     * predeterminado {@code 0} en esa posición.</p>
     *
     * @return Una matriz bidimensional de enteros que representa las afinidades entre los productos seleccionados.
     *         La diagonal principal tendrá el valor {@code 100}.
     */
    public int[][] obtenerMat() {
        int n = productosSeleccionados.size();
        int[][] mat = new int[n][n];

        Map<Integer, Integer> idToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idToIndex.put(productosSeleccionados.get(i).obtenerId(), i);
        }

        for (Map.Entry<Integer, Map<Integer, Integer>> filaEntry : matrizAfinidadesSeleccionados.entrySet()) {
            int filaId = filaEntry.getKey();
            Integer filaIndex = idToIndex.get(filaId);
            if (filaIndex == null) continue;

            for (Map.Entry<Integer, Integer> columnaEntry : filaEntry.getValue().entrySet()) {
                int columnaId = columnaEntry.getKey();
                Integer columnaIndex = idToIndex.get(columnaId);
                if (columnaIndex == null) continue;
                mat[filaIndex][columnaIndex] = columnaEntry.getValue();
            }
        }

        for (int i = 0; i < n; i++) {
            mat[i][i] = 100;
        }
        return mat;
    }

    /**
     * Obtiene el estado de si los datos han sido fijados.
     *
     * <p>Este método devuelve un valor booleano que indica si los datos han sido fijados, es decir,
     * si la matriz de afinidades y la lista de productos están configuradas y listas para su uso.</p>
     *
     * @return {@code true} si los datos han sido fijados; {@code false} si los datos aún no han sido fijados.
     */
    public boolean obtenerDatosFijados() {
        return this.datosFijados;
    }

    /**
     * Obtiene la matriz de afinidades entre los productos.
     *
     * <p>Este método devuelve la matriz de afinidades que contiene los valores de afinidad entre los productos.
     * La matriz es bidimensional y tiene un tamaño de {@code n x n}, donde {@code n} es el número de productos
     * gestionados. Los valores en la matriz representan las afinidades entre los productos, con la diagonal principal
     * (afinidad de un producto consigo mismo) establecida en {@code 100}.</p>
     *
     * @return Una matriz bidimensional de enteros que representa las afinidades entre los productos.
     */
    public int[][] getMatrizAfinidad() {
        return matrizAfinidad;
    }

    /**
     * Obtiene el mapa de productos dinámicos gestionados.
     *
     * <p>Este método devuelve el mapa {@code productosDinamicos} que contiene todos los productos gestionados
     * por el sistema. Las claves de este mapa son los IDs de los productos y los valores son las instancias
     * de la clase {@link Producto} correspondientes a cada ID.</p>
     *
     * <p>La referencia al mapa original es devuelta, por lo que cualquier modificación directa al mapa
     * afectará los datos subyacentes.</p>
     *
     * @return El mapa de productos dinámicos gestionados, donde la clave es el ID del producto y el valor es
     *         un objeto {@link Producto} correspondiente.
     */
    public Map<Integer, Producto> getProductosDinamicos() {
        return productosDinamicos;
    }

    /**
     * Obtiene el número de productos seleccionados.
     *
     * <p>Este método devuelve el tamaño de la lista {@code productosSeleccionados}, que contiene los productos
     * que han sido seleccionados para operaciones adicionales, como el cálculo de afinidades o distribuciones.</p>
     *
     * @return El número de productos seleccionados en la lista {@code productosSeleccionados}.
     */
    public int obtenerProductosSeleccionadosLength() {
        return productosSeleccionados.size();
    }

    /*public int agregarAfinidadMismoProducto(int id1) {
        if (!datosFijados) {
            throw new IllegalStateException("Los datos aún no han sido fijados. No se pueden agregar afinidades.");
        }
        Producto prod1 = obtenerProducto(id1); // Asumiendo que este método obtiene el producto por ID
        if (prod1 == null) {
            throw new IllegalArgumentException("No existe el producto.");
        }
        // Obtener posiciones en la matriz de afinidades
        int pos1 = prod1.obtenerPosMatriz();

        // Actualizar valores en la matriz de afinidades general
        matrizAfinidad[pos1][pos1] = 100;
        return 100;
    }*/
}
