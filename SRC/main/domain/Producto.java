package domain;

/**
 * La clase {@code Producto} representa un producto con diversos atributos como nombre, precio, descripción,
 * peso y marca. Este objeto se utiliza para gestionar y almacenar productos dentro de un sistema de gestión de productos,
 * permitiendo realizar diversas operaciones sobre ellos, como la modificación de su precio, peso, o afinidad con otros productos.
 *
 * <p>La clase incluye los siguientes atributos importantes:</p>
 * <ul>
 *     <li>{@code id}: Identificador único del producto.</li>
 *     <li>{@code nombre}: El nombre del producto.</li>
 *     <li>{@code precio}: El precio del producto.</li>
 *     <li>{@code descripcion}: Descripción del producto.</li>
 *     <li>{@code peso}: El peso del producto.</li>
 *     <li>{@code marca}: La marca del producto.</li>
 *     <li>{@code posMatriz}: La posición del producto en la matriz de afinidades.</li>
 * </ul>
 *
 * <p>Este objeto también incluye funcionalidades para gestionar la afinidad entre productos, permitiendo que cada producto
 * pueda tener una posición en una matriz de afinidades, utilizada para representar relaciones entre los productos.</p>
 *
 * <p>Principales responsabilidades:</p>
 * <ul>
 *     <li>Permitir la creación y gestión de productos con validación de sus atributos.</li>
 *     <li>Gestionar la afinidad entre productos a través de la posición en la matriz de afinidades.</li>
 *     <li>Proveer métodos para obtener y modificar atributos del producto como su nombre, precio, peso, etc.</li>
 * </ul>
 *
 * <p>Este objeto es clave para la gestión y análisis de productos dentro del sistema, interactuando con otras clases como {@code CjtProductos}
 * para realizar tareas más complejas de distribución y gestión de inventarios.</p>
 *
 * @see CjtProductos
 */
public class Producto {
    /**
     * El identificador único del producto. Este campo se utiliza para distinguir a cada producto
     * dentro del sistema y garantizar su integridad y acceso eficiente.
     *
     * <p>El {@code id} es asignado de manera única a cada producto, y no debe ser modificado una vez asignado.
     * Este identificador es fundamental para realizar operaciones como la modificación de afinidades, la
     * selección de productos o la gestión de distribuciones.</p>
     *
     * @return El {@code id} único del producto.
     */
    private final int id;

    /**
     * El nombre del producto. Este campo representa el nombre de cada producto gestionado en el sistema.
     *
     * <p>El nombre del producto se utiliza para identificarlo de manera más comprensible para el usuario
     * y facilitar la búsqueda, la gestión y las operaciones relacionadas con el producto.</p>
     *
     * <p>Este atributo es obligatorio y debe ser proporcionado al crear un producto. No puede ser nulo ni estar vacío.</p>
     *
     * @return El nombre del producto como una cadena de texto.
     */
    private String nombre;

    /**
     * La posición del producto en la matriz de afinidades. Este campo representa la ubicación del producto
     * en la matriz utilizada para gestionar las afinidades entre los productos en el sistema.
     *
     * <p>La posición es asignada cuando los productos son organizados en la matriz y se utiliza para referirse
     * a las relaciones de afinidad entre productos específicos en esa matriz. Cada producto tiene una posición única
     * en la matriz, lo que permite la manipulación eficiente de los datos relacionados con las afinidades.</p>
     *
     * <p>Este atributo es esencial para gestionar el acceso a las afinidades de manera rápida y precisa en el sistema.</p>
     *
     * @return La posición del producto en la matriz de afinidades como un valor entero.
     */
    private int posMatriz;

    /**
     * El precio del producto. Este campo almacena el valor monetario del producto en el sistema.
     *
     * <p>El precio es utilizado para determinar el costo del producto en transacciones, análisis de
     * ventas y cálculos de distribución. Este valor debe ser positivo y se utiliza en varias operaciones
     * del sistema que involucran la gestión de productos y su relación con otros productos o distribuciones.</p>
     *
     * <p>Este atributo es clave para la gestión comercial y el cálculo de la rentabilidad del producto.</p>
     *
     * @return El precio del producto como un valor de tipo {@code double}.
     */
    private double precio;

    /**
     * La descripción del producto. Este atributo almacena una descripción textual del producto.
     *
     * <p>La descripción proporciona información adicional sobre el producto, como sus características,
     * usos, beneficios o cualquier otro detalle relevante para el usuario. Este atributo es útil para mostrar
     * detalles del producto en interfaces de usuario o generar informes comerciales.</p>
     *
     * <p>Puede incluir detalles técnicos, marketing o cualquier otra información
     * que se considere útil para describir el producto en el sistema.</p>
     *
     * @return La descripción del producto como una cadena de texto {@code String}.
     */
    private String descripcion;

    /**
     * El peso del producto. Este atributo almacena el peso del producto en unidades de peso estándar (por ejemplo, kilogramos o gramos).
     *
     * <p>El peso es una propiedad importante del producto, ya que puede ser utilizado en el cálculo de tarifas de envío, almacenamiento
     * o cualquier otra operación logística relacionada con el manejo del producto.</p>
     *
     * <p>El valor de {@code peso} debe ser mayor que cero, ya que no tiene sentido asociar un producto con un peso no positivo.</p>
     *
     * @return El peso del producto como un valor de tipo {@code double}.
     */
    private double peso;

    /**
     * La marca del producto. Este atributo almacena el nombre de la marca del producto, que representa el fabricante o el origen del producto.
     *
     * <p>La marca es un atributo clave en el reconocimiento y diferenciación de productos, siendo esencial tanto para los consumidores como para el control de inventarios y la gestión de ventas.</p>
     *
     * <p>El valor de {@code marca} no puede ser nulo ni estar vacío, ya que se considera un atributo obligatorio para la identificación del producto.</p>
     *
     * @return El nombre de la marca del producto como una cadena de texto {@code String}.
     */
    private String marca;

    /**
     * Constructor para crear una instancia de la clase {@code Producto}.
     * Este constructor inicializa un producto con los atributos proporcionados, validando que los valores
     * sean correctos según las restricciones especificadas.
     *
     * <p>El constructor realiza las siguientes validaciones:</p>
     * <ul>
     *     <li>El {@code id} debe ser un valor único y positivo.</li>
     *     <li>El {@code nombre} no debe ser {@code null} ni estar vacío.</li>
     *     <li>El {@code precio} debe ser mayor o igual a cero.</li>
     *     <li>La {@code descripcion} no debe ser {@code null} ni estar vacía.</li>
     *     <li>El {@code peso} debe ser mayor que cero.</li>
     *     <li>La {@code marca} no debe ser {@code null} ni estar vacía.</li>
     * </ul>
     *
     * <p>Si cualquiera de estas condiciones no se cumple, el constructor lanzará una {@link IllegalArgumentException}.</p>
     *
     * @param id El ID único del producto. Debe ser un valor positivo.
     * @param nombre El nombre del producto. No debe ser {@code null} ni vacío.
     * @param precio El precio del producto. Debe ser un valor mayor o igual a cero.
     * @param descripcion La descripción del producto. No debe ser {@code null} ni vacío.
     * @param peso El peso del producto. Debe ser mayor que cero.
     * @param marca La marca del producto. No debe ser {@code null} ni vacío.
     *
     * @throws IllegalArgumentException Si cualquiera de las validaciones falla.
     */
    public Producto(int id, String nombre, double precio, String descripcion, double peso, String marca) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID del producto debe ser único y positivo.");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no debe ser null ni estar vacío.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del producto debe ser mayor o igual a cero.");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción del producto no debe ser null ni estar vacía.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso del producto debe ser mayor que cero.");
        }
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca del producto no debe ser null ni estar vacía.");
        }
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.peso = peso;
        this.marca = marca;
        this.posMatriz = -1;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * <p>Este método devuelve el nombre del producto almacenado en la instancia de la clase {@code Producto}.
     * El nombre se encuentra almacenado en el atributo {@code nombre} y puede ser utilizado para
     * identificar al producto dentro del sistema.</p>
     *
     * @return El nombre del producto, representado como una cadena de texto.
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * <p>Este método permite asignar un nuevo nombre al producto. Si el nombre proporcionado es nulo o está vacío,
     * se lanza una excepción {@code IllegalArgumentException} para asegurar que el nombre del producto sea válido.</p>
     *
     * @param nombre El nuevo nombre que se asignará al producto. No debe ser nulo ni estar vacío.
     * @throws IllegalArgumentException Si el nombre proporcionado es nulo o está vacío.
     */
    public void establecerNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe ser null ni estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * <p>Este método devuelve el precio actual del producto, que es un valor numérico de tipo {@code double}.
     * El precio debe ser mayor o igual a cero y se asigna durante la creación del producto.</p>
     *
     * @return El precio del producto.
     */
    public double obtenerPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * <p>Este método permite asignar un nuevo valor de precio al producto. El precio debe ser mayor o igual a cero.
     * Si se proporciona un valor negativo, se lanza una {@link IllegalArgumentException}.</p>
     *
     * @param precio El nuevo precio del producto. Debe ser mayor o igual a cero.
     * @throws IllegalArgumentException Si el precio proporcionado es negativo.
     */
    public void establecerPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    /**
     * Obtiene el peso del producto.
     *
     * <p>Este método devuelve el peso del producto en su unidad correspondiente.</p>
     *
     * @return El peso del producto.
     */
    public double obtenerPeso() {
        return peso;
    }

    /**
     * Establece el peso del producto.
     *
     * <p>Este método permite establecer el peso del producto. Si el valor proporcionado es menor o igual a cero,
     * se lanzará una excepción indicando que el peso no puede ser negativo o cero.</p>
     *
     * @param peso El peso a establecer para el producto. Debe ser mayor que cero.
     * @throws IllegalArgumentException Si el peso es menor o igual a cero.
     */
    public void establecerPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso no puede ser menor o igual a cero.");
        }
        this.peso = peso;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * <p>Este método devuelve la descripción asociada al producto. La descripción proporciona información
     * detallada sobre el producto y se almacena como una cadena de texto.</p>
     *
     * @return La descripción del producto.
     */
    public String obtenerDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * <p>Este método asigna una nueva descripción al producto. La descripción debe ser una cadena no nula
     * ni vacía. Si la descripción proporcionada es inválida, se lanzará una excepción.</p>
     *
     * @param descripcion La nueva descripción del producto. No debe ser nula ni estar vacía.
     * @throws IllegalArgumentException Si la descripción es nula o está vacía.
     */
    public void establecerDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no debe ser null ni estar vacía.");
        }
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la marca del producto.
     *
     * <p>Este método devuelve la marca asociada al producto, que es una cadena de texto representando la
     * marca del mismo.</p>
     *
     * @return La marca del producto como una cadena de texto.
     */
    public String obtenerMarca() {
        return marca;
    }

    /**
     * Establece la marca del producto.
     *
     * <p>Este método permite asignar un valor a la marca del producto. Si el valor proporcionado es nulo
     * o está vacío, se lanza una excepción {@link IllegalArgumentException}.</p>
     *
     * @param marca La marca que se asignará al producto. No debe ser nula ni estar vacía.
     * @throws IllegalArgumentException Si la marca es {@code null} o está vacía.
     */
    public void establecerMarca(String marca) {
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca no debe ser null ni estar vacía.");
        }
        this.marca = marca;
    }

    /**
     * Obtiene el ID del producto.
     *
     * <p>Este método devuelve el identificador único asociado al producto. El ID es un valor numérico
     * que permite identificar de manera unívoca el producto dentro del sistema.</p>
     *
     * @return El ID del producto, un valor entero.
     */
    public int obtenerId() {
        return id;
    }

    /**
     * Establece la posición del producto en la matriz de afinidades.
     *
     * <p>Este método asigna una posición específica en la matriz de afinidades al producto.
     * La posición en la matriz es utilizada para representar las relaciones de afinidad
     * entre los productos en el sistema. Cada producto tendrá una posición única en la matriz
     * que se utilizará para el cálculo de afinidades entre ellos.</p>
     *
     * @param posMatriz La posición en la matriz donde se debe colocar el producto.
     *                  Debe ser un valor entero mayor o igual a cero.
     */
    public void establecerPosMatriz(int posMatriz) {
        this.posMatriz = posMatriz;
    }

    /**
     * Obtiene la posición del producto en la matriz de afinidades.
     *
     * <p>Este método devuelve la posición del producto en la matriz de afinidades, que es utilizada
     * para representar las relaciones de afinidad entre los productos en el sistema. La posición es
     * un valor entero que se asigna cuando se establece la relación del producto en la matriz.</p>
     *
     * @return La posición del producto en la matriz de afinidades, representada por un valor entero.
     *         Si el producto no tiene posición asignada, se devuelve el valor {@code -1}.
     */
    public int obtenerPosMatriz() {
        return posMatriz;
    }

    /**
     * Devuelve una representación en formato cadena del objeto {@code Producto}.
     *
     * <p>Este método genera una cadena de texto que contiene todos los detalles importantes del producto,
     * incluyendo su nombre, ID, posición en la matriz de afinidades, precio, descripción, peso y marca.</p>
     *
     * @return Una cadena de texto que representa el estado actual del producto, con todos sus atributos
     *         relevantes, como el nombre, el ID, la posición en la matriz, el precio, la descripción, el peso
     *         y la marca.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", posMatriz=" + posMatriz +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", marca='" + marca + '\'' +
                '}';
    }

    /**
     * Compara este objeto {@code Producto} con otro objeto para determinar si son iguales.
     *
     * <p>Este método verifica si el objeto proporcionado es una instancia de la clase {@code Producto} y si
     * tiene el mismo ID que el objeto actual. Dos productos se consideran iguales si tienen el mismo ID.</p>
     *
     * @param o El objeto con el que se va a comparar este producto. Puede ser otro objeto de tipo {@code Producto}.
     * @return {@code true} si el objeto proporcionado es un {@code Producto} y tiene el mismo ID que este producto;
     *         {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producto producto = (Producto) o;

        return id == producto.id;
    }

    /**
     * Devuelve un valor de código hash para este objeto {@code Producto}.
     *
     * <p>Este método genera un valor de código hash basado en el ID del producto. El código hash es utilizado
     * en colecciones como {@code HashSet} o {@code HashMap} para almacenar y comparar objetos de manera eficiente.
     * Dado que el método {@code equals} compara los productos basándose en su ID, el código hash también debe
     * estar basado en el ID para garantizar la consistencia.</p>
     *
     * @return Un valor entero que representa el código hash del producto basado en su ID.
     */
    @Override
    public int hashCode() {
        return id;
    }
}
