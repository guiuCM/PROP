package domain;

/**
 * La enumeración {@code RolUsuario} define los diferentes roles de usuario dentro del sistema.
 * Cada rol representa un conjunto de permisos y capacidades asociados a un tipo específico de usuario.
 * Los roles disponibles son:
 * <ul>
 *     <li>{@link #ESTANDAR}: Representa a un usuario estándar con permisos limitados.</li>
 *     <li>{@link #ANALISTA}: Representa a un usuario con privilegios especiales para modificar afinidades entre productos y analizar datos.</li>
 *     <li>{@link #GESTOR_SUPERMERCADO}: Representa a un usuario con permisos para gestionar productos y realizar tareas administrativas en el sistema.</li>
 * </ul>
 *
 * <p>Este tipo de enumeración es útil para gestionar los permisos y comportamientos del sistema basados en el rol
 * de cada usuario, asegurando que las operaciones solo sean ejecutadas por usuarios autorizados.</p>
 *
 * @see Usuario
 */
public enum RolUsuario {
    ESTANDAR,
    ANALISTA,
    GESTOR_SUPERMERCADO
}
