package util;

import java.util.*;

/**
 * Representa un nodo en el algoritmo A* utilizado para la distribución de estanterías.
 * Cada nodo mantiene el camino recorrido, los productos no visitados, y los costos asociados
 * para determinar la mejor ruta basada en la heurística.
 *
 * @author
 * @version 1.0
 */
public class Nodo implements Comparable<Nodo> {

    /**
     * Camino recorrido hasta este nodo.
     */
    public List<Integer> camino;

    /**
     * Productos que aún no han sido visitados.
     */
    public Set<Integer> noVisitados;

    /**
     * Último producto visitado en el camino.
     */
    public int ultimoProducto;

    /**
     * Costo acumulado desde el nodo inicial hasta este nodo.
     */
    public double g;

    /**
     * Valor de la heurística calculada para este nodo.
     */
    public double h;

    /**
     * Valor total utilizado para ordenar los nodos en la cola de prioridad (f = g + h).
     */
    public double f;

    /**
     * Matriz de similitudes entre productos.
     */
    private int[][] matrizSimilitudes;

    /**
     * Máxima similitud entre productos.
     */
    private double S_max;

    /**
     * Constructor para crear un nuevo nodo con los datos iniciales proporcionados.
     *
     * @param camino             Camino recorrido hasta este nodo.
     * @param noVisitados        Productos que aún no han sido visitados.
     * @param ultimoProducto     Último producto visitado.
     * @param g                  Costo acumulado hasta este nodo.
     * @param matrizSimilitudes  Matriz de similitudes entre productos.
     * @param S_max              Máxima similitud entre productos.
     */
    public Nodo(List<Integer> camino, Set<Integer> noVisitados, int ultimoProducto, double g, int[][] matrizSimilitudes, double S_max) {
        // Pre: Recibe datos iniciales para crear un nodo
        this.camino = camino;
        this.noVisitados = noVisitados;
        this.ultimoProducto = ultimoProducto;
        this.g = g;
        this.matrizSimilitudes = matrizSimilitudes;
        this.S_max = S_max;
        this.h = calcularHeuristica(); // Calcula la heurística
        this.f = g + h; // Calcula el valor total f
        // Post: Nodo creado con todos sus valores inicializados
    }

    /**
     * Calcula el valor de la heurística para este nodo basado en los productos no visitados.
     * La heurística es la suma negativa de las similitudes entre el último producto visitado
     * y cada uno de los productos restantes por visitar.
     *
     * @return El valor de la heurística calculada.
     */
    private double calcularHeuristica() {
        // Pre: Calcula una estimación basada en productos no visitados
        double valorHeuristica = 0.0;
        if (!camino.isEmpty()) {
            int productoActual = camino.get(camino.size() - 1);
            for (int siguienteProducto : noVisitados) {
                valorHeuristica += matrizSimilitudes[productoActual][siguienteProducto];
            }
        }
        return -valorHeuristica; // Retorna una heurística negativa proporcional a las similitudes de los productos restantes
        // Post: Retorna el sumatorio de las similitudes a distancia 1 de cada producto en la solución
    }

    /**
     * Compara este nodo con otro nodo basado en el valor total 'f' para ordenar en una cola de prioridad.
     *
     * @param otroNodo El otro nodo con el que se comparará.
     * @return Un entero negativo, cero o positivo si este nodo es menor, igual o mayor que el otro nodo.
     */
    @Override
    public int compareTo(Nodo otroNodo) {
        // Pre: Compara dos nodos según su valor f
        return Double.compare(this.f, otroNodo.f);
        // Post: Permite ordenar nodos en la PriorityQueue
    }
}
