package domain.algorithms.TSP;

import domain.algorithms.DistribucionEstanteria;
import util.Tripleta;
import java.util.Arrays;

public class BruteForce extends DistribucionEstanteria {

    private int minCost;
    private long numberSteps;
    private int[] minPath;

    public BruteForce(int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
        super(numProductos, numBaldas, productos, matrizSimilitudes);
        if (numBaldas <= 0 || numProductos <= 0) {
            throw new IllegalArgumentException("El número de filas y productos debe ser mayor que cero.");
        }
        if (productos.length != numProductos) {
            throw new IllegalArgumentException("La longitud de la estantería debe ser igual al número de productos.");
        }
        if (matrizSimilitudes.length != numProductos) {
            throw new IllegalArgumentException("La matriz de similitudes debe ser de tamaño n_prod x n_prod.");
        }
        for (int[] fila : matrizSimilitudes) {
            if (fila.length != numProductos) {
                throw new IllegalArgumentException("La matriz de similitudes debe ser cuadrada.");
            }
        }
        this.minCost = Integer.MAX_VALUE;
        this.numberSteps = 0;
    }

    @Override
    public Tripleta<Integer, Long, int[]> calculaAlgoritmoLateral() {
        this.minCost = Integer.MAX_VALUE;
        this.minPath = new int[numProductos];
        Tripleta<Integer, Long, int[]> t = bruteForceAlgorithm(this.matrizSimilitudes);
        this.minCost = t.obtenerPrimero();
        this.numberSteps = t.obtenerSegundo();
        this.minPath = t.obtenerTercero();
        return t;
    }


    /*
     * BruteForce TSP:
     * Step 1: Calculate the total number of tours (implicit with permutations of numProductos-1 nodes)
     * Step 2: Generate all possible tours
     * Step 3: Calculate the distance of each tour
     * Step 4: Select the shortest tour (optimal solution)
     */
    public Tripleta<Integer, Long, int[]> bruteForceAlgorithm(int[][] m) {
        int[] path = new int[numProductos];
        boolean[] visited = new boolean[numProductos];

        // Empezamos con el producto 0
        path[0] = 0;
        visited[0] = true;

        // Generamos todas las posibles distribuciones
        permute(m, path, visited, 1);

        return new Tripleta<>(minCost, numberSteps, Arrays.copyOf(minPath, numProductos));
    }

    private void permute(int[][] m, int[] path, boolean[] visited, int depth) {
        // Si tenemos todos los productos asignados, aplicamos la condicion (Matriz es simetrica)
        if (depth == numProductos) {
            // Only consider the tour if path[1] < path[numProductos-1]
            // This ensures we count only one permutation out of each mirrored pair
            if (path[1] < path[numProductos - 1]) {
                int cost = computeCost(m, path);
                if (cost < minCost) {
                    minCost = cost;
                    minPath = Arrays.copyOf(path, numProductos);
                }
            }
            return;
        }

        // Try each city that hasn't been visited yet
        for (int i = 1; i < numProductos; i++) {
            numberSteps++;
            if (!visited[i]) {
                visited[i] = true;
                path[depth] = i;
                permute(m, path, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    private int computeCost(int[][] m, int[] path) {
        int cost = 0;
        for (int i = 0; i < numProductos - 1; i++) {
            ++numberSteps;
            cost += m[path[i]][path[i+1]];
        }
        cost += m[path[numProductos-1]][path[0]];
        return cost;
    }
}
