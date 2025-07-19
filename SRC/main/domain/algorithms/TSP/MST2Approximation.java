package domain.algorithms.TSP;

import domain.algorithms.DistribucionEstanteria;
import util.Tripleta;
import java.util.*;

public class MST2Approximation extends DistribucionEstanteria {
    private int minCost;
    private long numberSteps;
    private int[] minPath;

    public MST2Approximation(int numProductos, int numEstanterias, int[] productos, int[][] matrizSimilitudes) {
        super(numProductos, numEstanterias, productos, matrizSimilitudes);
        if (numEstanterias <= 0 || numProductos <= 0) {
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
        this.minPath = new int[numProductos];
        // Post: Se inicializa min con el peor valor posible (infinito positivo)
    }

    @Override
    public Tripleta<Integer, Long, int[]> calculaAlgoritmoLateral() {
        // Reset class variables before computation
        this.minCost = Integer.MAX_VALUE;
        this.numberSteps = 0;
        this.minPath = new int[numProductos];

        // Execute the algorithm, which will update class variables directly
        MST2ApproximationAlgorithm(this.matrizSimilitudes);

        // Construct the Tripleta using the updated class variables
        return new Tripleta<>(this.minCost, this.numberSteps, this.minPath);
    }

    public void MST2ApproximationAlgorithm(int[][] m) {
        // Initialize structures for Prim's MST
        int[] key = new int[numProductos];
        int[] parent = new int[numProductos];
        boolean[] mstSet = new boolean[numProductos];
        initializePrimStructures(key, parent, mstSet);

        // Construct MST using Prim's Algorithm
        buildMSTUsingPrim(m, key, parent, mstSet);

        // Build adjacency list from MST
        List<Integer>[] mstAdj = buildMSTAdjList(parent);

        // Preorder traversal of the MST
        List<Integer> preorderList = performPreorderTraversal(mstAdj);

        // Compute TSP path and cost from MST preorder traversal
        computeTSPPathAndCost(m, preorderList);
    }

    // Helper method to initialize Prim's algorithm data structures
    private void initializePrimStructures(int[] key, int[] parent, boolean[] mstSet) {
        for (int i = 0; i < numProductos; i++) {
            ++numberSteps;
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
            parent[i] = -1;
        }
        // Start from vertex 0
        key[0] = 0;
    }

    // Helper method to build MST using Prim's algorithm
    private void buildMSTUsingPrim(int[][] m, int[] key, int[] parent, boolean[] mstSet) {
        for (int count = 0; count < numProductos - 1; count++) {
            // Pick the minimum key vertex from those not in MST
            int u = -1;
            int minKey = Integer.MAX_VALUE;

            for (int v = 0; v < numProductos; v++) {
                this.numberSteps++; // counting comparison steps
                if (!mstSet[v] && key[v] < minKey) {
                    minKey = key[v];
                    u = v;
                }
            }

            // Add the chosen vertex to MST set
            mstSet[u] = true;

            // Update key and parent for adjacent vertices
            for (int v = 0; v < numProductos; v++) {
                this.numberSteps++; // counting edge relaxation attempts
                if (m[u][v] >= 0 && u != v && !mstSet[v] && m[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = m[u][v];
                }
            }
        }
    }

    // Helper method to build adjacency list from the MST parent array
    private List<Integer>[] buildMSTAdjList(int[] parent) {
        List<Integer>[] mstAdj = new ArrayList[numProductos];
        for (int i = 0; i < numProductos; i++) {
            ++numberSteps;
            mstAdj[i] = new ArrayList<>();
        }
        for (int i = 1; i < numProductos; i++) {
            ++numberSteps;
            mstAdj[parent[i]].add(i);
            mstAdj[i].add(parent[i]);
        }
        return mstAdj;
    }

    // Helper method to perform a preorder traversal on the MST
    private List<Integer> performPreorderTraversal(List<Integer>[] mstAdj) {
        int numProductos = mstAdj.length;
        List<Integer> preorderList = new ArrayList<>();
        boolean[] visited = new boolean[numProductos];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                preorderList.add(curr);

                // Add children in reverse order so that the smallest is visited first
                for (int i = mstAdj[curr].size() - 1; i >= 0; i--) {
                    this.numberSteps++; // considering next child
                    int nxt = mstAdj[curr].get(i);
                    if (!visited[nxt]) {
                        stack.push(nxt);
                    }
                }
            }
        }

        // Add the starting node again at the end to form a cycle
        preorderList.add(0);
        this.numberSteps++; // for the final add

        return preorderList;
    }

    // Helper method to compute the TSP path and its cost from the preorder traversal
    private void computeTSPPathAndCost(int[][] m, List<Integer> preorderList) {
        int[] tspPath = new int[preorderList.size()];
        for (int i = 0; i < tspPath.length; i++) {
            ++numberSteps;
            tspPath[i] = preorderList.get(i);
        }

        int totalCost = 0;
        for (int i = 0; i < tspPath.length - 1; i++) {
            totalCost += m[tspPath[i]][tspPath[i + 1]];
            numberSteps++; // counting each cost addition as a step
        }

        // Assign the computed total cost to minCost
        this.minCost = totalCost;

        // Assign the path excluding the repeated last city to minPath
        this.minPath = Arrays.copyOf(tspPath, tspPath.length - 1);
    }
}
