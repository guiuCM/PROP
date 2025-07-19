package util;

/**
 * La clase {@code Tripleta} representa una tripleta de objetos que consiste en tres elementos.
 *
 * @param <A> el tipo del primer elemento
 * @param <B> el tipo del segundo elemento
 * @param <C> el tipo del tercer elemento
 *
 * <p>Esta clase es útil para almacenar tríos de elementos relacionados y proporciona métodos
 * para acceder y modificar estos elementos de manera segura.</p>
 */
public class Tripleta<A, B, C> {
    /**
     * El primer elemento de la tripleta.
     */
    private A primero;

    /**
     * El segundo elemento de la tripleta.
     */
    private B segundo;

    /**
     * El tercer elemento de la tripleta.
     */
    private C tercero;

    /**
     * Construye una nueva instancia de {@code Tripleta} con los elementos especificados.
     *
     * @param primero  el primer elemento de la tripleta
     * @param segundo  el segundo elemento de la tripleta
     * @param tercero  el tercer elemento de la tripleta
     * @throws IllegalArgumentException si alguno de los elementos es {@code null}
     */
    public Tripleta(A primero, B segundo, C tercero) {
        if (primero == null || segundo == null || tercero == null) {
            throw new IllegalArgumentException("Ninguno de los elementos de la tripleta puede ser null.");
        }
        this.primero = primero;
        this.segundo = segundo;
        this.tercero = tercero;
    }

    /**
     * Obtiene el primer elemento de la tripleta.
     *
     * @return el primer elemento de la tripleta
     */
    public A obtenerPrimero() {
        return primero;
    }

    /**
     * Obtiene el segundo elemento de la tripleta.
     *
     * @return el segundo elemento de la tripleta
     */
    public B obtenerSegundo() {
        return segundo;
    }

    /**
     * Obtiene el tercer elemento de la tripleta.
     *
     * @return el tercer elemento de la tripleta
     */
    public C obtenerTercero() {
        return tercero;
    }

    /**
     * Crea una nueva instancia de {@code Tripleta} utilizando un método de fábrica estático.
     *
     * @param primero  el primer elemento de la nueva tripleta
     * @param segundo  el segundo elemento de la nueva tripleta
     * @param tercero  el tercer elemento de la nueva tripleta
     * @param <A>      el tipo del primer elemento
     * @param <B>      el tipo del segundo elemento
     * @param <C>      el tipo del tercer elemento
     * @return una nueva instancia de {@code Tripleta<A, B, C>} con los elementos proporcionados
     * @throws IllegalArgumentException si alguno de los elementos es {@code null}
     */
    public static <A, B, C> Tripleta<A, B, C> de(A primero, B segundo, C tercero) {
        return new Tripleta<>(primero, segundo, tercero);
    }

    /**
     * Devuelve una representación en cadena de la tripleta.
     *
     * @return una cadena que representa la tripleta en el formato
     *         {@code "Tripleta{primero=primero, segundo=segundo, tercero=tercero}"}
     */
    @Override
    public String toString() {
        return "Tripleta{" +
                "primero=" + primero +
                ", segundo=" + segundo +
                ", tercero=" + tercero +
                '}';
    }

    /**
     * Determina si esta tripleta es igual a otro objeto.
     * Dos tripletas son iguales si sus primeros, segundos y terceros elementos son iguales.
     *
     * @param o el objeto con el que se compara esta tripleta
     * @return {@code true} si el objeto es una instancia de {@code Tripleta} y tiene los mismos elementos;
     *         {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tripleta<?, ?, ?> tripleta = (Tripleta<?, ?, ?>) o;

        if (!primero.equals(tripleta.primero)) return false;
        if (!segundo.equals(tripleta.segundo)) return false;
        return tercero.equals(tripleta.tercero);
    }

    /**
     * Devuelve un valor hash para esta tripleta.
     *
     * @return el valor hash calculado a partir de los tres elementos
     */
    @Override
    public int hashCode() {
        int resultado = primero.hashCode();
        resultado = 31 * resultado + segundo.hashCode();
        resultado = 31 * resultado + tercero.hashCode();
        return resultado;
    }
}
