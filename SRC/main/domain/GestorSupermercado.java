package domain;

/**
 * La clase {@code GestorSupermercado} representa a un usuario encargado de la gestión de productos
 * en el sistema. Extiende la clase base {@link Usuario} e incluye funcionalidades específicas para
 * agregar, eliminar y gestionar productos.
 *
 * <p>Principales responsabilidades:
 * <ul>
 *     <li>Agregar nuevos productos al conjunto, validando los datos proporcionados.</li>
 *     <li>Eliminar productos existentes del conjunto, asegurándose de que el ID sea válido.</li>
 *     <li>Proporcionar el rol específico de GESTOR_SUPERMERCADO.</li>
 * </ul>
 *
 * <p>Atributos y métodos destacados:
 * <ul>
 *     <li>Constructor para inicializar un gestor con validación de nombre y contraseña.</li>
 *     <li>Método para agregar productos con validación integral de parámetros.</li>
 *     <li>Método para eliminar productos validando su existencia en el sistema.</li>
 *     <li>Método para obtener el rol asociado.</li>
 * </ul>
 *
 * <p>Este tipo de usuario está diseñado para interactuar directamente con el conjunto de productos y
 * realizar tareas de administración dentro del sistema.
 *
 * @see Usuario
 * @see RolUsuario
 * @see Producto
 * @see CjtProductos
 */
public class GestorSupermercado extends Usuario {

    /**
     * Constructor para la clase GestorSupermercado.
     * Inicializa un gestor con un nombre y una contraseña, validando que ambos sean válidos.
     *
     * @param nombre El nombre del gestor del supermercado. No debe ser nulo ni estar vacío.
     * @param contrasena La contraseña del gestor del supermercado. No debe ser nula ni estar vacía.
     * @throws IllegalArgumentException Si el nombre o la contraseña son nulos o están vacíos.
     */
    public GestorSupermercado(String nombre, String contrasena) {
        super(nombre, contrasena);
        if (nombre == null || nombre.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            throw new IllegalArgumentException("Nombre y contraseña no deben ser null ni estar vacíos.");
        }
    }

    /**
     * Agrega un nuevo producto al conjunto de productos.
     * Valida que todos los parámetros sean correctos antes de agregar el producto.
     *
     * @param idProd El ID del producto. Debe ser un valor positivo y único.
     * @param nomProd El nombre del producto. No debe ser nulo ni estar vacío.
     * @param precio El precio del producto. Debe ser un valor positivo.
     * @param descripcion La descripción del producto. No debe ser nula ni estar vacía.
     * @param peso El peso del producto. Debe ser mayor que cero.
     * @param marca La marca del producto. No debe ser nula ni estar vacía.
     * @throws IllegalArgumentException Si alguno de los parámetros no cumple con las validaciones requeridas.
     * @throws IllegalStateException Si ya existe un producto con el mismo ID en el conjunto.
     */
    public void agregarProducto(int idProd, String nomProd, double precio, String descripcion, double peso, String marca) { // Actualizado
        if (nomProd == null || nomProd.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no debe ser null ni estar vacío.");
        }
        if (idProd < 0) {
            throw new IllegalArgumentException("El ID del producto debe ser un valor positivo.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del producto debe ser un valor positivo.");
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

        CjtProductos conjunto = CjtProductos.obtenerInstancia();
        if (conjunto.obtenerProducto(idProd) == null) {
            conjunto.agregarProducto(idProd, nomProd, precio, descripcion, peso, marca);
            System.out.println("Producto agregado correctamente: " + nomProd + " (ID: " + idProd + ").");
        } else {
            throw new IllegalStateException("Ya existe un producto con el mismo ID: " + idProd + ".");
        }
    }

    /**
     * Elimina un producto del conjunto de productos dado su ID.
     * Valida que el ID sea válido y que el producto exista en el conjunto antes de eliminarlo.
     *
     * @param idProd El ID del producto a eliminar. Debe ser un valor positivo.
     * @throws IllegalArgumentException Si el ID del producto es negativo.
     * @throws IllegalStateException Si el producto con el ID especificado no existe en el conjunto.
     */
    public void eliminarProducto(int idProd) {
        if (idProd < 0) {
            throw new IllegalArgumentException("El ID del producto debe ser un valor positivo.");
        }

        CjtProductos conjunto = CjtProductos.obtenerInstancia();
        Producto producto = conjunto.obtenerProducto(idProd);
        if (producto != null) {
            conjunto.eliminarProducto(idProd);
            System.out.println("Producto eliminado correctamente: " + producto.obtenerNombre() + " (ID: " + idProd + ").");
        } else {
            throw new IllegalStateException("El producto con ID " + idProd + " no existe.");
        }
    }

    /**
     * Obtiene el rol del usuario asociado a esta instancia.
     * En este caso, siempre devuelve el rol de GESTOR_SUPERMERCADO.
     *
     * @return El rol del usuario, que es {@link RolUsuario#GESTOR_SUPERMERCADO}.
     */
    public RolUsuario getRol(){
        return RolUsuario.GESTOR_SUPERMERCADO;
    }
}
