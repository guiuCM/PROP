package domain.exceptions;

/**
 * La clase {@code Excepciones} define excepciones personalizadas para manejar errores específicos en la aplicación.
 * <p>
 * Esta clase contiene excepciones estáticas internas que extienden de {@link RuntimeException}, permitiendo
 * lanzar excepciones específicas que facilitan la identificación y manejo de distintos tipos de errores
 * dentro del sistema.
 * </p>
 *
 * <p>
 * Las excepciones definidas son:
 * <ul>
 *     <li>{@link EntradaInvalidaException}: Indica errores relacionados con entradas o parámetros inválidos.</li>
 *     <li>{@link OperacionNoSoportadaException}: Indica intentos de realizar operaciones no soportadas por el sistema.</li>
 *     <li>{@link EstadoInvalidoException}: Indica estados inválidos o inconsistentes dentro del sistema.</li>
 * </ul>
 * </p>
 *
 * @see RuntimeException
 */
public class Excepciones {

    /**
     * Excepción para errores de entrada inválida.
     * <p>
     * Se lanza cuando se proporcionan parámetros nulos, vacíos o que no cumplen con las condiciones requeridas.
     * </p>
     */
    public static class EntradaInvalidaException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        /**
         * Construye una nueva instancia de {@code EntradaInvalidaException} con el mensaje especificado.
         *
         * @param mensaje el mensaje de detalle de la excepción.
         */
        public EntradaInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    /**
     * Excepción para operaciones no soportadas.
     * <p>
     * Se lanza cuando se intenta realizar una operación que no está permitida o no es válida en el contexto actual.
     * </p>
     */
    public static class OperacionNoSoportadaException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        /**
         * Construye una nueva instancia de {@code OperacionNoSoportadaException} con el mensaje especificado.
         *
         * @param mensaje el mensaje de detalle de la excepción.
         */
        public OperacionNoSoportadaException(String mensaje) {
            super(mensaje);
        }
    }

    /**
     * Excepción para estados inválidos en el sistema.
     * <p>
     * Se lanza cuando el sistema alcanza un estado inconsistente o inválido que impide continuar con la operación.
     * </p>
     */
    public static class EstadoInvalidoException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        /**
         * Construye una nueva instancia de {@code EstadoInvalidoException} con el mensaje especificado.
         *
         * @param mensaje el mensaje de detalle de la excepción.
         */
        public EstadoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }
}
