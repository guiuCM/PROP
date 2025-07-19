package domain;

/**
 * La clase {@code Analista} representa a un usuario con privilegios especiales para gestionar y analizar
 * la afinidad entre productos en el sistema. Extiende la clase base {@link Usuario} y añade funcionalidades
 * específicas para un analista.
 *
 * <p>Principales responsabilidades:
 * <ul>
 *     <li>Modificar la afinidad entre dos productos, ajustando su relación en el conjunto de productos.</li>
 *     <li>Proporcionar el rol específico de ANALISTA.</li>
 * </ul>
 *
 * <p>Atributos y métodos destacados:
 * <ul>
 *     <li>Constructor para inicializar un analista con validación de nombre y contraseña.</li>
 *     <li>Método para modificar afinidades entre productos.</li>
 *     <li>Método para obtener el rol asociado.</li>
 * </ul>
 *
 * <p>Este tipo de usuario está diseñado para tareas avanzadas relacionadas con la gestión de productos y su interacción.
 *
 * @see Usuario
 * @see RolUsuario
 * @see CjtProductos
 */
public class Analista extends Usuario {

    /**
     * Constructor para la clase Analista.
     * Inicializa un analista con un nombre y una contraseña, validando que ambos no sean nulos ni vacíos.
     *
     * @param nombre El nombre del analista. No debe ser nulo ni estar vacío.
     * @param contrasena La contraseña del analista. No debe ser nula ni estar vacía.
     * @throws IllegalArgumentException Si el nombre o la contraseña son nulos o están vacíos.
     */
    public Analista(String nombre, String contrasena) {
        super(nombre, contrasena);
        if (nombre == null || nombre.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            throw new IllegalArgumentException("Nombre y contraseña no deben ser null ni estar vacíos.");
        }
    }

    /**
     * Modifica la afinidad entre dos productos dados sus IDs y un valor.
     * La afinidad representa una relación entre dos productos y debe ser válida.
     *
     * @param id1 El ID del primer producto. Debe ser mayor o igual a 0.
     * @param id2 El ID del segundo producto. Debe ser mayor o igual a 0 y diferente de id1.
     * @param valor El valor de la afinidad a establecer entre los dos productos.
     * @throws IllegalArgumentException Si los IDs de los productos son negativos o si id1 es igual a id2.
     * @throws IllegalStateException Si uno o ambos productos no existen en el conjunto.
     */
    public void modificarAfinidad(int id1, int id2, int valor) {
        if (id1 < 0 || id2 < 0) {
            throw new IllegalArgumentException("Los IDs de los productos no pueden ser negativos.");
        }
        if (id1 == id2) {
            throw new IllegalArgumentException("No se puede modificar afinidad de un producto consigo mismo.");
        }

        CjtProductos conjunto = CjtProductos.obtenerInstancia();
        if (conjunto.obtenerProducto(id1) != null && conjunto.obtenerProducto(id2) != null) {
            conjunto.agregarAfinidadEntreDosProductos(id1, id2, valor);
        } else {
            throw new IllegalStateException("Uno o ambos productos no existen en el conjunto.");
        }
    }

    /**
     * Obtiene el rol del usuario asociado a esta instancia.
     * En este caso, siempre devuelve el rol de ANALISTA.
     *
     * @return El rol del usuario, que es {@link RolUsuario#ANALISTA}.
     */
    public RolUsuario getRol(){
        return RolUsuario.ANALISTA;
    }
}
