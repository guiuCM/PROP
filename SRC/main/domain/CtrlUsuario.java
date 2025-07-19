package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import util.*;

/**
 * La clase {@code CtrlUsuario} es un controlador encargado de gestionar las operaciones relacionadas con los usuarios
 * en el sistema. Esta clase maneja la autenticación de los usuarios, su inicio y cierre de sesión, así como la modificación
 * de sus datos y la gestión de productos y distribuciones asociadas a su cuenta.
 *
 * <p>La clase incluye los siguientes atributos importantes:</p>
 * <ul>
 *     <li>{@code usuarioActivo}: El usuario que se encuentra actualmente autenticado en el sistema.</li>
 * </ul>
 *
 * <p>Principales responsabilidades:</p>
 * <ul>
 *     <li>Gestionar la autenticación de usuarios mediante el inicio y cierre de sesión.</li>
 *     <li>Permitir la modificación de la contraseña del usuario activo.</li>
 *     <li>Realizar operaciones sobre los productos, como agregar o eliminar productos, y gestionar afinidades entre productos.</li>
 *     <li>Imprimir y gestionar distribuciones de productos para el usuario activo.</li>
 * </ul>
 *
 * <p>Esta clase está diseñada para actuar como un intermediario entre las acciones que un usuario puede realizar dentro
 * del sistema y los objetos que representan a los usuarios, productos y distribuciones.</p>
 *
 * <p>Principales métodos:</p>
 * <ul>
 *     <li>{@code iniciarSesion}: Inicia sesión para un usuario con un nombre, contraseña y rol determinado.</li>
 *     <li>{@code cerrarSesion}: Cierra la sesión del usuario activo.</li>
 *     <li>{@code cambiarContrasena}: Cambia la contraseña del usuario activo.</li>
 *     <li>{@code agregarProducto}: Agrega un nuevo producto al sistema.</li>
 *     <li>{@code eliminarProducto}: Elimina un producto del sistema.</li>
 *     <li>{@code modificarAfinidad}: Modifica la afinidad entre dos productos.</li>
 *     <li>{@code mostrarProductos}: Muestra todos los productos disponibles en el sistema.</li>
 *     <li>{@code mostrarProductosSelecionados}: Muestra todos los productos seleccionados en el sistema.</li>
 *     <li>{@code imprimirDistribucion}: Imprime una distribución específica.</li>
 *     <li>{@code agregarEstanteriaPriorizandoProximidadLateral}: Agrega una estantería priorizando la proximidad lateral entre los productos.</li>
 *     <li>{@code agregarEstanteriaPriorizandoProximidadVecina}: Agrega una estantería priorizando la proximidad vecina entre los productos.</li>
 *     <li>{@code swapDosProductosDistribucion}: Intercambia dos productos dentro de una distribución.</li>
 *     <li>{@code cambiarMetodoCalculo}: Cambia el método de cálculo utilizado para las distribuciones.</li>
 *     <li>{@code printAllDistributions}: Imprime todas las distribuciones disponibles.</li>
 *     <li>{@code obtenerDistribuciones}: Obtiene las distribuciones disponibles gestionadas por el usuario activo.</li>
 *     <li>{@code borrarDistribucionesActivas}: Elimina todas las distribuciones activas del usuario actual.</li>
 *     <li>{@code comprobarContraseña}: Compara la contraseña actual del usuario activo con la proporcionada.</li>
 * </ul>
 *
 * @see Usuario
 * @see UsuarioEstandar
 * @see Analista
 * @see GestorSupermercado
 */
public class CtrlUsuario {

    /**
     * El usuario actualmente activo en el sistema. Este atributo mantiene una referencia al objeto {@link Usuario}
     * que representa al usuario que ha iniciado sesión en el sistema. A través de este objeto, se pueden realizar
     * operaciones relacionadas con el usuario activo, como obtener sus datos, cambiar su contraseña o realizar
     * acciones específicas según su rol.
     *
     * <p>Este atributo se asigna cuando un usuario inicia sesión correctamente y puede ser utilizado durante toda
     * la sesión para identificar al usuario y realizar las operaciones correspondientes a sus permisos.</p>
     */
    private Usuario usuarioActivo;

    /**
     * Constructor de la clase {@code CtrlUsuario}.
     *
     * <p>Este constructor inicializa el objeto {@code CtrlUsuario} y establece que no hay un usuario activo
     * al principio, asignando {@code null} al atributo {@code usuarioActivo}. Este es el valor inicial cuando
     * el controlador de usuario se crea, indicando que no hay ningún usuario autenticado en el sistema.</p>
     */
    public CtrlUsuario() {
        usuarioActivo = null;
    }

    /**
     * Obtiene el nombre del usuario activo.
     *
     * <p>Este método verifica si hay un usuario actualmente autenticado en el sistema. Si hay un usuario activo,
     * devuelve su nombre; de lo contrario, muestra un mensaje indicando que no hay un usuario activo y retorna {@code null}.</p>
     *
     * @return El nombre del usuario activo, o {@code null} si no hay un usuario activo.
     */
    public String quienSoy() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo.");
            return null;
        }
        return usuarioActivo.obtenerNombre();
    }

    /**
     * Inicia sesión de un usuario con el nombre, contraseña y rol especificados.
     *
     * <p>Este método permite autenticar a un usuario en el sistema, asignando un rol y activando su sesión.
     * Si ya existe un usuario activo, se lanza una excepción {@code IllegalStateException}. Si el nombre o la
     * contraseña son nulos o vacíos, se lanza una excepción {@code IllegalArgumentException}. Dependiendo del rol
     * proporcionado, se crea un objeto de tipo {@link UsuarioEstandar}, {@link Analista} o {@link GestorSupermercado}.</p>
     *
     * @param nombre El nombre del usuario. No debe ser {@code null} ni estar vacío.
     * @param contrasena La contraseña del usuario. No debe ser {@code null} ni estar vacía.
     * @param rol El rol del usuario. Debe ser uno de los valores definidos en {@link RolUsuario}.
     * @param distribuciones Un mapa que contiene las distribuciones del usuario si tiene el rol {@link RolUsuario#ESTANDAR}.
     *
     * @throws IllegalArgumentException Si el nombre, la contraseña son {@code null} o están vacíos, o si el rol es desconocido.
     * @throws IllegalStateException Si ya hay un usuario activo.
     */
    public void iniciarSesion(String nombre, String contrasena, RolUsuario rol, Map<Integer, Par<int[][], String>> distribuciones, Map<Integer, Par<Integer, Long>> distribuciones2) {
        if (nombre == null || nombre.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            throw new IllegalArgumentException("El nombre y la contraseña no deben ser null ni estar vacíos.");
        }

        if (usuarioActivo != null) {
            throw new IllegalStateException("Ya hay un usuario activo.");
        }

        switch (rol) {
            case RolUsuario.ESTANDAR:
                usuarioActivo = new UsuarioEstandar(nombre, contrasena, distribuciones, distribuciones2);
                break;
            case RolUsuario.ANALISTA:
                usuarioActivo = new Analista(nombre, contrasena);
                break;
            case RolUsuario.GESTOR_SUPERMERCADO:
                usuarioActivo = new GestorSupermercado(nombre, contrasena);
                break;
            default:
                throw new IllegalArgumentException("Rol desconocido: " + rol);
        }
    }

    /**
     * Cierra la sesión del usuario activo.
     *
     * <p>Este método permite cerrar la sesión del usuario actualmente activo en el sistema. Si no hay un usuario
     * activo, se lanza una excepción {@code IllegalStateException}. Cuando se cierra la sesión, el usuario activo
     * se establece en {@code null}.</p>
     *
     * @throws IllegalStateException Si no hay un usuario activo para cerrar sesión.
     */
    public void cerrarSesion() {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        usuarioActivo.cerrarSesion();
        usuarioActivo = null;
    }

    /**
     * Cambia la contraseña del usuario activo.
     *
     * <p>Este método permite cambiar la contraseña del usuario que actualmente tiene una sesión activa. Si no hay
     * un usuario activo, se lanza una excepción {@code IllegalStateException}. Una vez validado el usuario activo,
     * se llama al método correspondiente en la clase del usuario para cambiar la contraseña.</p>
     *
     * @param newpass La nueva contraseña que se asignará al usuario. No debe ser nula ni vacía.
     *
     * @throws IllegalStateException Si no hay un usuario activo para cambiar la contraseña.
     * @throws IllegalArgumentException Si la nueva contraseña es nula o está vacía.
     */
    public void cambiarContrasena(String newpass) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }

        usuarioActivo.cambiarContrasena(newpass);
    }

    /**
     * Agrega un nuevo producto al sistema mediante el usuario activo.
     *
     * <p>Este método agrega un producto utilizando los datos proporcionados, delegando la operación al usuario activo.
     * Si no hay un usuario activo, se lanza una excepción {@code IllegalStateException}. El producto se agrega con
     * el identificador, nombre, precio, descripción, peso y marca especificados.</p>
     *
     * @param idProd El ID único del producto a agregar. Debe ser un valor positivo y único.
     * @param nombreProd El nombre del producto. No debe ser nulo ni vacío.
     * @param precio El precio del producto. Debe ser un valor mayor o igual a cero.
     * @param descripcion La descripción del producto. No debe ser nula ni vacía.
     * @param peso El peso del producto. Debe ser mayor que cero.
     * @param marca La marca del producto. No debe ser nula ni vacía.
     *
     * @throws IllegalStateException Si no hay un usuario activo para agregar el producto.
     * @throws IllegalArgumentException Si alguno de los parámetros proporcionados no cumple con las validaciones necesarias.
     */
    public void agregarProducto(int idProd, String nombreProd, double precio, String descripcion, double peso, String marca) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }

        usuarioActivo.agregarProducto(idProd, nombreProd, precio, descripcion, peso, marca);
    }

    /**
     * Elimina un producto del sistema utilizando el usuario activo.
     *
     * <p>Este método elimina un producto del sistema verificando que haya un usuario activo. Si el ID proporcionado
     * es negativo, se lanza una excepción {@code IllegalArgumentException}. La eliminación del producto se delega
     * al usuario activo para ser gestionada según su rol.</p>
     *
     * @param idProd El ID del producto a eliminar. Debe ser un valor positivo.
     *
     * @throws IllegalStateException Si no hay un usuario activo para eliminar el producto.
     * @throws IllegalArgumentException Si el ID del producto es negativo o no válido.
     */
    public void eliminarProducto(int idProd) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        if (idProd < 0) {
            throw new IllegalArgumentException("El ID del producto debe ser un valor positivo.");
        }
        usuarioActivo.eliminarProducto(idProd);
    }

    /**
     * Modifica la afinidad entre dos productos utilizando el usuario activo.
     *
     * <p>Este método permite modificar la afinidad entre dos productos. Primero verifica que haya un usuario activo,
     * y que los IDs de los productos no sean negativos ni coincidan entre sí. Luego, la operación de modificación
     * se delega al usuario activo.</p>
     *
     * @param id1 El ID del primer producto cuya afinidad se desea modificar. No puede ser negativo.
     * @param id2 El ID del segundo producto cuya afinidad se desea modificar. No puede ser negativo y no puede ser igual al ID del primer producto.
     * @param valor El valor de la nueva afinidad entre los dos productos. Debe ser un valor válido.
     *
     * @throws IllegalStateException Si no hay un usuario activo para realizar la operación.
     * @throws IllegalArgumentException Si alguno de los IDs de los productos es negativo, o si ambos IDs son iguales.
     */
    public void modificarAfinidad(int id1, int id2, int valor) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }

        if (id1 < 0 || id2 < 0) {
            throw new IllegalArgumentException("Los IDs de los productos no pueden ser negativos.");
        }
        if (id1 == id2) {
            throw new IllegalArgumentException("No se puede modificar afinidad de un producto consigo mismo.");
        }

        usuarioActivo.modificarAfinidad(id1, id2, valor);
    }

    /**
     * Muestra todos los productos disponibles en el sistema.
     *
     * <p>Este método obtiene una lista de todos los productos gestionados en el sistema a través de la clase
     * {@link CjtProductos}. Si la lista de productos está vacía, se muestra un mensaje indicando que no hay
     * productos disponibles. Si existen productos, se muestra el nombre y el ID de cada uno.</p>
     *
     * @throws IllegalStateException Si ocurre un error al obtener la lista de productos.
     */
    public void mostrarProductos() {
        CjtProductos conjunto = CjtProductos.obtenerInstancia();
        List<Producto> listaProductos = conjunto.obtenerTodosLosProductos();

        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Lista de productos:");
            for (Producto producto : listaProductos) {
                System.out.println("Nombre del producto: " + producto.obtenerNombre() + ", ID: " + producto.obtenerId());
            }
        }
    }

    /**
     * Muestra todos los productos seleccionados en el sistema.
     *
     * <p>Este método obtiene una lista de los productos seleccionados actualmente en el sistema a través de la clase
     * {@link CjtProductos}. Si la lista de productos seleccionados está vacía, se muestra un mensaje indicando que
     * no hay productos seleccionados. Si existen productos seleccionados, se muestra el nombre y el ID de cada uno.</p>
     *
     * @throws IllegalStateException Si ocurre un error al obtener la lista de productos seleccionados.
     */
    public void mostrarProductosSelecionados() {
        CjtProductos conjunto = CjtProductos.obtenerInstancia();
        List<Producto> listaProductosSelecionados = conjunto.obtenerProductosSeleccionados();

        if (listaProductosSelecionados.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Lista de productos seleccionados:");
            for (Producto producto : listaProductosSelecionados) {
                System.out.println("Nombre del producto: " + producto.obtenerNombre() + ", ID: " + producto.obtenerId());
            }
        }
    }

    /**
     * Imprime una distribución específica basada en el número proporcionado.
     *
     * <p>Este método solicita a la clase {@code UsuarioActivo} que imprima la distribución correspondiente al
     * número de distribución proporcionado como argumento. Si no hay un usuario activo, se muestra un mensaje de
     * error y no se realiza ninguna acción.</p>
     *
     * @param numero El número de la distribución a imprimir.
     *               Debe ser un valor positivo que corresponda a una distribución válida.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     */
    public void imprimirDistribucion(int numero) {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo.");
            return;
        }
        usuarioActivo.imprimirDistribucion(numero);
    }

    /**
     * Agrega una estantería priorizando la proximidad lateral utilizando el algoritmo TSP,
     * y devuelve un objeto {@code Par} que contiene el número de baldas y una tripleta
     * con el índice de la estantería, el valor de la afinidad y la matriz resultante.
     *
     * <p>Este método delega la tarea a la clase {@code UsuarioActivo} para agregar una estantería con las
     * características proporcionadas, utilizando el algoritmo {@code TSP} para calcular la proximidad lateral.
     * Si no hay un usuario activo, se lanza una excepción.</p>
     *
     * @param a El algoritmo TSP que se utilizará para calcular la proximidad lateral.
     * @param numeroBaldas El número de baldas que se desean agregar en la estantería.
     * @param l La lista de productos que se organizarán en la estantería.
     *
     * @return Un objeto {@code Par} que contiene el número de baldas y una {@code Tripleta} con el índice de la estantería,
     *         el valor de afinidad y la matriz resultante.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     */
    public Par<Integer, Tripleta<Integer, Long, int[][]>> agregarEstanteriaPriorizandoProximidadLateralR(AlgoritmosTSP a, int numeroBaldas, List<Producto> l) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        return usuarioActivo.agregarEstanteriaPriorizandoProximidadLateralR(a, numeroBaldas, l);
    }

    /**
     * Agrega una estantería priorizando la proximidad lateral entre los productos seleccionados.
     * Este método delega la tarea de agregar la estantería a la implementación correspondiente del usuario activo.
     *
     * <p>Si el usuario activo es un {@code GestorSupermercado} o tiene los permisos adecuados, el algoritmo TSP
     * será utilizado para optimizar la distribución de los productos en la estantería con el número de baldas
     * especificado. Los productos se distribuyen en función de su proximidad lateral.</p>
     *
     * @param a El algoritmo TSP que será utilizado para la optimización de la distribución de los productos en la estantería.
     * @param numeroBaldas El número de baldas de la estantería a agregar.
     * @param l La lista de productos que deben ser distribuidos en la estantería.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     */
    public void agregarEstanteriaPriorizandoProximidadLateral(AlgoritmosTSP a, int numeroBaldas, List<Producto> l) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        usuarioActivo.agregarEstanteriaPriorizandoProximidadLateral(a, numeroBaldas, l);
    }

    /**
     * Agrega una estantería priorizando la proximidad vecina entre los productos seleccionados, utilizando el algoritmo QAP.
     * Este método delega la tarea de agregar la estantería a la implementación correspondiente del usuario activo.
     *
     * <p>Si el usuario activo es un {@code GestorSupermercado} o tiene los permisos adecuados, el algoritmo QAP
     * será utilizado para optimizar la distribución de los productos en la estantería con el número de baldas
     * especificado. Los productos se distribuyen en función de su proximidad vecina.</p>
     *
     * @param a El algoritmo QAP que será utilizado para la optimización de la distribución de los productos en la estantería.
     * @param numeroBaldas El número de baldas de la estantería a agregar.
     * @param l La lista de productos que deben ser distribuidos en la estantería.
     *
     * @return Un objeto {@code Par<Integer, Tripleta<Integer, Long, int[][]>>} que representa los resultados de la operación.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     */
    public Par<Integer, Tripleta<Integer, Long, int[][]>> agregarEstanteriaPriorizandoProximidadVecinaR(AlgoritmosQAP a, int numeroBaldas, List<Producto> l) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        return usuarioActivo.agregarEstanteriaPriorizandoProximidadVecinaR(a, numeroBaldas, l);
    }

    /**
     * Agrega una estantería priorizando la proximidad vecina entre los productos seleccionados, utilizando el algoritmo QAP.
     * Este método delega la tarea de agregar la estantería a la implementación correspondiente del usuario activo.
     *
     * <p>Si el usuario activo es un {@code GestorSupermercado} o tiene los permisos adecuados, el algoritmo QAP
     * será utilizado para optimizar la distribución de los productos en la estantería con el número de baldas
     * especificado. Los productos se distribuyen en función de su proximidad vecina.</p>
     *
     * @param a El algoritmo QAP que será utilizado para la optimización de la distribución de los productos en la estantería.
     * @param numeroBaldas El número de baldas de la estantería a agregar.
     * @param l La lista de productos que deben ser distribuidos en la estantería.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     */
    public void agregarEstanteriaPriorizandoProximidadVecina(AlgoritmosQAP a, int numeroBaldas, List<Producto> l) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        usuarioActivo.agregarEstanteriaPriorizandoProximidadVecina(a, numeroBaldas, l);
    }

    /**
     * Intercambia dos productos dentro de una distribución específica.
     * Este método delega la operación a la clase {@code UsuarioActivo} para realizar el intercambio de los productos
     * con los IDs proporcionados en la distribución identificada por {@code idDist}.
     * Si no hay un usuario activo, se lanza una excepción.
     *
     * @param idDist El ID de la distribución en la que se realizará el intercambio de productos.
     * @param id1 El ID del primer producto a intercambiar.
     * @param id2 El ID del segundo producto a intercambiar.
     *
     * @return Un objeto {@code Par} que contiene la matriz actualizada y un mensaje de estado.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     * @throws IllegalArgumentException Si alguno de los productos no existe o los IDs proporcionados son inválidos.
     */
    public Par<int[][], String> swapDosProductosDistribucion(int idDist, int id1, int id2) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        return usuarioActivo.swapDosProductosDistribucion(idDist, id1, id2);
    }

    /**
     * Cambia el método de cálculo utilizado para las distribuciones.
     * Este método delega la operación a la clase {@code UsuarioActivo} para cambiar el algoritmo
     * utilizado en el cálculo de las distribuciones.
     * Si no hay un usuario activo, se lanza una excepción.
     *
     * @param nuevoMetodo El nuevo algoritmo de cálculo a utilizar, de tipo {@code AlgoritmosTSP}.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     * @throws IllegalArgumentException Si el nuevo método de cálculo proporcionado es inválido.
     */
    public void cambiarMetodoCalculo(AlgoritmosTSP nuevoMetodo) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        usuarioActivo.cambiarMetodoCalculo(nuevoMetodo);
    }

    /**
     * Imprime todas las distribuciones disponibles.
     * Este método delega la operación a la clase {@code UsuarioActivo} para imprimir todas las distribuciones
     * gestionadas por el usuario activo. Si no hay un usuario activo, se lanza una excepción.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     */
    public void printAllDistributions() {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        usuarioActivo.printAllDistributions();
    }

    /**
     * Obtiene las distribuciones disponibles gestionadas por el usuario activo.
     * Este método delega la operación a la clase {@code UsuarioActivo} para recuperar las distribuciones.
     * Si no hay un usuario activo, se lanza una excepción.
     *
     * @return Un mapa de distribuciones, donde la clave es un identificador único de distribución y el valor
     *         es un objeto {@link Par} que contiene la matriz de afinidades y una descripción asociada.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     */
    public Map<Integer, Par<int[][], String>> obtenerDistribuciones() {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        return usuarioActivo.obtenerDistribuciones();
    }

    /**
     * Elimina todas las distribuciones activas del usuario actual.
     * Este método delega la operación a la clase {@code UsuarioActivo} para borrar las distribuciones activas.
     * Si no hay un usuario activo, se lanza una excepción.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     */
    public void borrarDistribucionesActivas() {
        usuarioActivo.borrarDistribuciones();
    }

    /**
     * Compara la contraseña actual del usuario activo con la contraseña proporcionada.
     * Este método verifica si la contraseña proporcionada coincide con la contraseña almacenada
     * para el usuario activo en el sistema.
     *
     * @param oldP La contraseña que se quiere comprobar. No debe ser {@code null}.
     * @return {@code true} si la contraseña proporcionada coincide con la contraseña actual del usuario activo;
     *         {@code false} en caso contrario.
     *
     * @throws IllegalStateException Si no hay un usuario activo en el sistema.
     */
    public boolean comprobarContraseña(String oldP){
        return (usuarioActivo.getContraseña().equals(oldP));
    }

    public Integer obtenerCoste(int idDist) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        return usuarioActivo.obtenerCoste(idDist);
    }

    public Long obtenerPasos(int idDist) {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario activo.");
        }
        return usuarioActivo.obtenerPasos(idDist);
    }

}
