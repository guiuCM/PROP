package util;

/**
 * La clase {@code Par} representa una pareja de objetos que consiste en una clave y un valor.
 *
 * @param <K> el tipo de la clave
 * @param <V> el tipo del valor
 *
 * <p>Esta clase es útil para almacenar pares de elementos relacionados, como claves y valores,
 * y proporciona métodos para acceder y modificar estos elementos de manera segura.</p>
 */
public class Par<K, V> {
    /**
     * La clave de la pareja.
     */
    private K clave;

    /**
     * El valor de la pareja.
     */
    private V valor;

    /**
     * Construye una nueva instancia de {@code Par} con la clave y el valor especificados.
     *
     * @param clave la clave de la pareja
     * @param valor el valor de la pareja
     * @throws IllegalArgumentException si {@code clave} o {@code valor} son {@code null}
     */
    public Par(K clave, V valor) {
        if (clave == null || valor == null) {
            throw new IllegalArgumentException("La clave y el valor no deben ser null.");
        }
        this.clave = clave;
        this.valor = valor;
    }

    /**
     * Obtiene el primer elemento de la pareja, que corresponde a la clave.
     *
     * @return la clave de la pareja
     */
    public K obtenerPrimero() {
        return clave;
    }

    /**
     * Obtiene el segundo elemento de la pareja, que corresponde al valor.
     *
     * @return el valor de la pareja
     */
    public V obtenerSegundo() {
        return valor;
    }


    /**
     * Crea una nueva instancia de {@code Par} utilizando un método de fábrica estático.
     *
     * @param clave la clave de la nueva pareja
     * @param valor el valor de la nueva pareja
     * @param <K>   el tipo de la clave
     * @param <V>   el tipo del valor
     * @return una nueva instancia de {@code Par<K, V>} con la clave y el valor proporcionados
     * @throws IllegalArgumentException si {@code clave} o {@code valor} son {@code null}
     */
    public static <K, V> Par<K, V> de(K clave, V valor) {
        return new Par<>(clave, valor);
    }

    /**
     * Devuelve una representación en cadena de la pareja.
     *
     * @return una cadena que representa la pareja en el formato {@code "Par{clave=clave, valor=valor}"}
     */
    @Override
    public String toString() {
        return "Par{" +
                "clave=" + clave +
                ", valor=" + valor +
                '}';
    }

    /**
     * Determina si esta pareja es igual a otro objeto.
     * Dos parejas son iguales si sus claves y valores son iguales.
     *
     * @param o el objeto con el que se compara esta pareja
     * @return {@code true} si el objeto es una instancia de {@code Par} y tiene la misma clave y valor; {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Par<?, ?> par = (Par<?, ?>) o;

        if (!clave.equals(par.clave)) return false;
        return valor.equals(par.valor);
    }

    /**
     * Devuelve un valor hash para esta pareja.
     *
     * @return el valor hash calculado a partir de la clave y el valor
     */
    @Override
    public int hashCode() {
        int resultado = clave.hashCode();
        resultado = 31 * resultado + valor.hashCode();
        return resultado;
    }
}
