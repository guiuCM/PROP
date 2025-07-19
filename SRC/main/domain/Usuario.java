package domain;

import util.AlgoritmosQAP;
import util.AlgoritmosTSP;
import util.Par;
import util.Tripleta;

import java.util.Map;
import java.util.List;

/**
 * La clase abstracta {@code Usuario} define los atributos y comportamientos comunes para todos los tipos de usuarios
 * dentro del sistema. Proporciona una base para las clases específicas como {@code Analista}, {@code GestorSupermercado},
 * y otros roles definidos en la aplicación.
 *
 * <p>Principales responsabilidades:
 * <ul>
 *     <li>Gestionar la información básica del usuario, como nombre, contraseña, email y estado de sesión.</li>
 *     <li>Proporcionar métodos para operaciones comunes, como cerrar sesión y cambiar contraseña.</li>
 *     <li>Definir métodos abstractos o lanzar excepciones para funcionalidades específicas no permitidas en esta clase base.</li>
 * </ul>
 *
 * <p>Atributos principales:
 * <ul>
 *     <li>{@code nombre}: Identifica al usuario dentro del sistema.</li>
 *     <li>{@code contrasena}: Almacena la contraseña para autenticación.</li>
 *     <li>{@code email}: Dirección de correo asociada al usuario.</li>
 *     <li>{@code sesionActiva}: Estado de la sesión actual del usuario.</li>
 * </ul>
 *
 * <p>Métodos destacados:
 * <ul>
 *     <li>Gestión de sesión: {@code cerrarSesion}, {@code obtenerSesionActiva}.</li>
 *     <li>Modificación de atributos: {@code cambiarContrasena}.</li>
 *     <li>Restricciones por permisos: Métodos que lanzan excepciones indicando falta de permisos.</li>
 * </ul>
 *
 * <p>Esta clase es abstracta y no debe ser instanciada directamente. En su lugar, debe ser extendida por clases específicas
 * que implementen funcionalidades concretas para diferentes roles de usuario.
 *
 * @see Analista
 * @see GestorSupermercado
 */
public abstract class Usuario {
    /**
     * El nombre asociado al usuario.
     * Este atributo identifica al usuario en el sistema y no debe ser nulo ni estar vacío.
     */
    private String nombre;

    /**
     * La contraseña asociada al usuario.
     * Este atributo se utiliza para autenticar al usuario en el sistema y debe ser segura.
     * No debe ser nula ni estar vacía.
     */
    private String contrasena;

    /**
     * La dirección de correo electrónico asociada al usuario.
     * Este atributo se utiliza para identificar al usuario de manera única en el sistema y
     * puede ser empleado para notificaciones o recuperación de contraseñas.
     * No debe ser nulo ni estar vacío y debe tener un formato válido.
     */
    private String email;

    /**
     * Indica si el usuario tiene una sesión activa en el sistema.
     * Este atributo se utiliza para gestionar el estado de autenticación del usuario.
     *
     * <p>Valores posibles:
     * <ul>
     *     <li>{@code true}: El usuario tiene una sesión activa.</li>
     *     <li>{@code false}: El usuario no tiene una sesión activa.</li>
     * </ul>
     */
    private boolean sesionActiva;

    /**
     * Constructor para la clase {@code Usuario}.
     * Inicializa un usuario con un nombre y una contraseña, validando que ambos no sean nulos ni estén vacíos.
     * La dirección de correo electrónico se inicializa como una cadena vacía y la sesión se marca como activa.
     *
     * @param nombre El nombre del usuario. No debe ser nulo ni estar vacío.
     * @param contrasena La contraseña del usuario. No debe ser nula ni estar vacía.
     * @throws IllegalArgumentException Si el nombre o la contraseña son nulos o están vacíos.
     */
    public Usuario(String nombre, String contrasena) {
        if (nombre == null || nombre.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            throw new IllegalArgumentException("Nombre y contraseña no deben ser null ni estar vacíos.");
        }
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = "";
        this.sesionActiva = true;
    }

    /**
     * Cierra la sesión del usuario si hay una sesión activa.
     * Si no hay una sesión activa, muestra un mensaje indicando la situación.
     */
    public void cerrarSesion() {
        if (sesionActiva) {
            sesionActiva = false;
        } else {
            System.out.println("No hay una sesión activa.");
        }
    }

    /**
     * Obtiene el estado actual de la sesión del usuario.
     *
     * @return {@code true} si el usuario tiene una sesión activa; {@code false} en caso contrario.
     */
    public boolean obtenerSesionActiva() { // Renombrado desde isSesionActiva
        return sesionActiva;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario como una cadena de texto.
     */
    public String obtenerNombre() { // Renombrado desde getNombre
        return nombre;
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para agregar una estantería.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param a El algoritmo TSP que sería utilizado para la optimización (no utilizado en este caso).
     * @param numeroBaldas El número de baldas de la estantería (no utilizado en este caso).
     * @param productosArray La lista de productos a organizar en la estantería (no utilizado en este caso).
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public void agregarEstanteriaPriorizandoProximidadLateral(AlgoritmosTSP a, int numeroBaldas, List<Producto> productosArray){
        throw new IllegalArgumentException("Este usuario no tiene permisos para añadir una estantería.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para agregar una estantería
     * priorizando la proximidad lateral utilizando un algoritmo TSP.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param a El algoritmo TSP que sería utilizado para la optimización (no utilizado en este caso).
     * @param numeroBaldas El número de baldas de la estantería (no utilizado en este caso).
     * @param productosArray La lista de productos a organizar en la estantería (no utilizado en este caso).
     * @return No devuelve nada, ya que siempre lanza una excepción.
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public Par<Integer, Tripleta<Integer, Long, int[][]>> agregarEstanteriaPriorizandoProximidadLateralR(AlgoritmosTSP a, int numeroBaldas, List<Producto> productosArray){
        throw new IllegalArgumentException("Este usuario no tiene permisos para añadir una estantería.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para agregar una estantería
     * priorizando la proximidad vecina utilizando un algoritmo QAP.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param a El algoritmo QAP que sería utilizado para la optimización (no utilizado en este caso).
     * @param numeroBaldas El número de baldas de la estantería (no utilizado en este caso).
     * @param productosArray La lista de productos a organizar en la estantería (no utilizado en este caso).
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public void agregarEstanteriaPriorizandoProximidadVecina(AlgoritmosQAP a, int numeroBaldas, List<Producto> productosArray) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para añadir una estantería.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para agregar una estantería
     * priorizando la proximidad vecina utilizando un algoritmo QAP.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param a El algoritmo QAP que sería utilizado para la optimización (no utilizado en este caso).
     * @param numeroBaldas El número de baldas de la estantería (no utilizado en este caso).
     * @param productosArray La lista de productos a organizar en la estantería (no utilizado en este caso).
     * @return No devuelve nada, ya que siempre lanza una excepción.
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public Par<Integer, Tripleta<Integer, Long, int[][]>> agregarEstanteriaPriorizandoProximidadVecinaR(AlgoritmosQAP a, int numeroBaldas, List<Producto> productosArray) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para añadir una estantería.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para cambiar el método de cálculo
     * utilizado para distribuciones.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param nuevoMetodo El nuevo método de cálculo que se intentaría asignar (no utilizado en este caso).
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public void cambiarMetodoCalculo(AlgoritmosTSP nuevoMetodo) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para calcular distribuciones.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para mostrar las distribuciones existentes.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public void printAllDistributions() {
        throw new IllegalArgumentException("Este usuario no tiene permisos para mostrar las distribuciones.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para intercambiar productos
     * en una distribución específica.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param idDist El ID de la distribución donde se intentaría realizar el intercambio (no utilizado en este caso).
     * @param id1 El ID del primer producto a intercambiar (no utilizado en este caso).
     * @param id2 El ID del segundo producto a intercambiar (no utilizado en este caso).
     * @return No devuelve nada, ya que siempre lanza una excepción.
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public Par<int[][], String> swapDosProductosDistribucion(int idDist, int id1, int id2){
        throw new IllegalArgumentException("Este usuario no tiene permisos para cambiar productos de la distribución.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para mostrar una distribución específica.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param numero El ID de la distribución que se intentaría mostrar (no utilizado en este caso).
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public void imprimirDistribucion(int numero) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para mostrar la distribución " + numero + ".");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para mostrar una distribución específica
     * identificada por su ID.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param numero El ID de la distribución que se intentaría mostrar (no utilizado en este caso).
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public void imprimirDistribucionID(int numero) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para mostrar la distribución " + numero + ".");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para modificar afinidades entre productos.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param id1 El ID del primer producto cuya afinidad se intentaría modificar (no utilizado en este caso).
     * @param id2 El ID del segundo producto cuya afinidad se intentaría modificar (no utilizado en este caso).
     * @param valor El valor de la nueva afinidad que se intentaría establecer (no utilizado en este caso).
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public void modificarAfinidad(int id1, int id2, int valor) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para modificar afinidades.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para agregar productos al sistema.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param idProd El ID del producto que se intentaría agregar (no utilizado en este caso).
     * @param nombreProd El nombre del producto que se intentaría agregar (no utilizado en este caso).
     * @param precio El precio del producto que se intentaría agregar (no utilizado en este caso).
     * @param descripcion La descripción del producto que se intentaría agregar (no utilizado en este caso).
     * @param peso El peso del producto que se intentaría agregar (no utilizado en este caso).
     * @param marca La marca del producto que se intentaría agregar (no utilizado en este caso).
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public void agregarProducto(int idProd, String nombreProd, double precio, String descripcion, double peso, String marca) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para eliminar Productos.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para eliminar productos del sistema.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @param idProd El ID del producto que se intentaría eliminar (no utilizado en este caso).
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public void eliminarProducto(int idProd) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para eliminar Productos.");
    }

    /**
     * Lanza una excepción indicando que este usuario no tiene permisos para obtener las distribuciones.
     * Este método está presente para garantizar la coherencia en la jerarquía de usuarios,
     * pero no permite la operación para este tipo de usuario.
     *
     * @return No devuelve nada, ya que siempre lanza una excepción.
     * @throws IllegalArgumentException Siempre, indicando que el usuario no tiene permisos para esta operación.
     */
    public Map<Integer, Par<int[][], String>> obtenerDistribuciones() {
        throw new IllegalArgumentException("Este usuario no tiene permisos para obtener Distribuciones");
    }

    /**
     * Cambia la contraseña del usuario.
     *
     * @param newpassword La nueva contraseña a asignar. Puede ser cualquier cadena no nula.
     */
    public void cambiarContrasena(String newpassword) {
        this.contrasena = newpassword;
    }

    public void borrarDistribuciones() {}

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña actual del usuario como una cadena de texto.
     */
    public String getContraseña(){
        return contrasena;
    }

    public Integer obtenerCoste(int idDist) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para obtener el coste.");
    }

    public Long obtenerPasos(int idDist) {
        throw new IllegalArgumentException("Este usuario no tiene permisos para obtener los pasos.");
    }
}
