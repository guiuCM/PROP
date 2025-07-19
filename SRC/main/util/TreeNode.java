package util;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase {@code TreeNode} representa un nodo en un árbol genérico.
 *
 * @param <T> el tipo de valor almacenado en el nodo
 *
 * <p>Esta clase es fundamental para estructuras de datos arborescentes, permitiendo
 * la creación y manipulación de nodos que pueden tener múltiples hijos. Es útil en
 * algoritmos que requieren una representación jerárquica de datos.</p>
 */
public class TreeNode<T> {
    /**
     * El valor almacenado en el nodo.
     */
    private T value;

    /**
     * Lista de nodos hijos de este nodo.
     */
    private List<TreeNode<T>> children;

    /**
     * Construye una nueva instancia de {@code TreeNode} con el valor especificado.
     *
     * @param value el valor a almacenar en el nodo
     * @throws IllegalArgumentException si {@code value} es {@code null}
     *
     * @implNote
     * <p>Inicializa la lista de hijos como una lista vacía para permitir la adición posterior
     * de nodos hijos.</p>
     *
     * @post El nodo contiene el valor proporcionado y una lista vacía de hijos
     */
    public TreeNode(T value) {
        if (value == null) {
            throw new IllegalArgumentException("El valor no debe ser null.");
        }
        this.value = value;
        this.children = new ArrayList<>();
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     *
     * @return el valor del nodo
     */
    public T obtenerValor() {
        return value;
    }


    /**
     * Devuelve una representación en cadena del nodo, incluyendo su valor y el número de hijos.
     *
     * @return una cadena que representa al nodo en el formato {@code "TreeNode{value=valor, numeroDeHijos=n}"}
     */
    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", numeroDeHijos=" + children.size() +
                '}';
    }

    /**
     * Determina si este nodo es igual a otro objeto.
     * Dos nodos son iguales si sus valores son iguales y tienen la misma estructura de hijos.
     *
     * @param o el objeto con el que se compara este nodo
     * @return {@code true} si el objeto es una instancia de {@code TreeNode} y tiene el mismo valor y estructura de hijos; {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode<?> treeNode = (TreeNode<?>) o;

        if (!value.equals(treeNode.value)) return false;
        return children.equals(treeNode.children);
    }

    /**
     * Devuelve un valor hash para este nodo.
     *
     * @return el valor hash calculado a partir del valor y la lista de hijos
     */
    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + children.hashCode();
        return result;
    }
}
