package domain.algorithms.TSP;

import domain.algorithms.DistribucionEstanteria;
import util.Tripleta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Christofides extends DistribucionEstanteria {
    private int minCost;
    private long numberSteps;
    private int[] minPath;

    public Christofides(int numProductos, int numEstanterias, int[] productos, int[][] matrizSimilitudes) {
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
        // Post: minCost y numberSteps inicializados
    }

    @Override
    public Tripleta<Integer, Long, int[]> calculaAlgoritmoLateral() {
        // Reset class variables before computation
        this.minCost = Integer.MAX_VALUE;
        this.numberSteps = 0;
        this.minPath = new int[numProductos];

        // Execute the algorithm, which will update class variables directly
        christofidesAlgorithm(this.matrizSimilitudes);

        // Construct the Tripleta using the updated class variables
        return new Tripleta<>(this.minCost, this.numberSteps, this.minPath);
    }

    public void christofidesAlgorithm(int[][] m) {
        // Step 1: Construct Minimum Spanning Tree (MST) T
        // Using Prim's Algorithm for MST
        int[] parent = getMST(m);

        // Step 2: Find the set O of vertices with odd degree in T
        List<Integer> oddVertices = getOddDegreeVertices(parent);

        // Step 3: Find a minimum-weight perfect matching in the subgraph induced by O
        int[][] subgraphO = inducedSubgraph(m, oddVertices);
        List<int[]> perfectMatching = minimumWeightPerfectMatching(subgraphO, oddVertices);

        // Step 4: Combine the edges of T and M to form a connected multigraph H with all even degrees
        List<int[]> mstEdges = mstEdgesFromParent(parent, m);
        List<int[]> combinedEdges = new ArrayList<>(mstEdges);
        combinedEdges.addAll(perfectMatching);

        // Step 5: Find Eulerian Circuit in H
        List<Integer> eulerianCircuit = findEulerianCircuit(combinedEdges);

        // Step 6: Shortcut the Eulerian circuit to form the Hamiltonian circuit (TSP tour)
        List<Integer> hamiltonianCycle = shortcutEulerianCircuit(eulerianCircuit);

        // Compute cost of the TSP tour
        int cost = 0;
        for (int i = 0; i < hamiltonianCycle.size(); i++) {
            int u = hamiltonianCycle.get(i);
            int w = hamiltonianCycle.get((i + 1) % hamiltonianCycle.size());
            cost += m[u][w];
            numberSteps++; // Counting each cost addition as a step
        }

        // Assign the computed total cost to minCost
        minCost = cost;

        // Assign the path excluding the repeated last city to minPath
        minPath = new int[hamiltonianCycle.size() - 1];
        for (int i = 0; i < hamiltonianCycle.size() - 1; i++) {
            minPath[i] = hamiltonianCycle.get(i);
            // Counting each assignment as a step
            numberSteps++;
        }
    }


    private int[] getMST(int[][] m) {
        int[] parent = new int[numProductos];
        int[] key = new int[numProductos];
        boolean[] inMST = new boolean[numProductos];

        // Initialize keys
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < numProductos - 1; count++) {
            // Pick min key vertex not in MST
            int u = -1;
            int minVal = Integer.MAX_VALUE;
            for (int v = 0; v < numProductos; v++) {
                numberSteps++; // Counting comparison steps
                if (!inMST[v] && key[v] < minVal) {
                    minVal = key[v];
                    u = v;
                }
            }

            inMST[u] = true;

            // Update keys
            for (int w = 0; w < numProductos; w++) {
                numberSteps++; // Counting edge relaxation attempts
                if (m[u][w] < Integer.MAX_VALUE && !inMST[w] && m[u][w] < key[w]) {
                    parent[w] = u;
                    key[w] = m[u][w];
                }
            }
        }

        return parent;
    }


    private List<Integer> getOddDegreeVertices(int[] parent) {
        int[] degree = new int[numProductos];
        for (int i = 1; i < numProductos; i++) {
            numberSteps++; // Counting step
            degree[i]++;
            degree[parent[i]]++;
        }
        List<Integer> oddVertices = new ArrayList<>();
        for (int i = 0; i < numProductos; i++) {
            numberSteps++; // Counting step
            if (degree[i] % 2 != 0) {
                oddVertices.add(i);
            }
        }
        return oddVertices;
    }


    private List<int[]> mstEdgesFromParent(int[] parent, int[][] m) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 1; i < parent.length; i++) {
            numberSteps++; // Counting step
            edges.add(new int[]{parent[i], i});
        }
        return edges;
    }


    private int[][] inducedSubgraph(int[][] m, List<Integer> O) {
        int size = O.size();
        int[][] sub = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                numberSteps++; // Counting step
                sub[i][j] = m[O.get(i)][O.get(j)];
            }
        }
        return sub;
    }


    private List<int[]> minimumWeightPerfectMatching(int[][] subgraph, List<Integer> O) {
        // If no odd vertices, no matching needed
        ++numberSteps;
        if (O.isEmpty()) return new ArrayList<>();

        // A brute force approach to try all matchings:
        // We will use a recursive helper to generate perfect matchings.
        List<int[]> bestMatching = new ArrayList<>();
        int[] bestCost = {Integer.MAX_VALUE};
        boolean[] used = new boolean[O.size()];
        perfectMatchingHelper(subgraph, O, used, new ArrayList<>(), 0, bestMatching, bestCost);
        return bestMatching;
    }


    private void perfectMatchingHelper(int[][] subgraph, List<Integer> O, boolean[] used, List<int[]> currentMatching, int currentCost, List<int[]> bestMatching, int[] bestCost) {
        int numProductos = O.size();
        int start = -1;
        for (int i = 0; i < numProductos; i++) {
            numberSteps++; // Counting step
            if (!used[i]) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            // All used, check if better
            if (currentCost < bestCost[0]) {
                bestCost[0] = currentCost;
                bestMatching.clear();
                bestMatching.addAll(currentMatching);
            }
            return;
        }

        used[start] = true;
        for (int j = start + 1; j < numProductos; j++) {
            numberSteps++; // Counting step
            if (!used[j]) {
                used[j] = true;
                int cost = subgraph[start][j];
                currentMatching.add(new int[]{O.get(start), O.get(j)});
                perfectMatchingHelper(subgraph, O, used, currentMatching, currentCost + cost, bestMatching, bestCost);
                currentMatching.remove(currentMatching.size() - 1);
                used[j] = false;
            }
        }
        used[start] = false;
    }


    private List<Integer> findEulerianCircuit(List<int[]> edges) {
        // Convert edge list to adjacency list with duplicate edges (since multigraph)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numProductos; i++) {
            numberSteps++; // Counting step
            adj.add(new ArrayList<>());
        }

        int[][] edgeCount = new int[numProductos][numProductos];
        for (int[] e : edges) {
            numberSteps++; // Counting step
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            edgeCount[e[0]][e[1]]++;
            edgeCount[e[1]][e[0]]++;
        }

        // Hierholzer's algorithm for Eulerian circuit
        List<Integer> circuit = new ArrayList<>();
        Stack<Integer> pathStack = new Stack<>();
        pathStack.push(0); // start at vertex 0
        int current = 0;

        while (!pathStack.isEmpty()) {
            if (hasAvailableEdge(current, edgeCount)) {
                pathStack.push(current);
                // Find next edge
                for (int next : adj.get(current)) {
                    numberSteps++; // Counting step
                    if (edgeCount[current][next] > 0) {
                        // use this edge
                        edgeCount[current][next]--;
                        edgeCount[next][current]--;
                        current = next;
                        break;
                    }
                }
            } else {
                // no more edges from current
                circuit.add(current);
                current = pathStack.pop();
            }
        }
        return circuit;
    }


    private boolean hasAvailableEdge(int v, int[][] edgeCount) {
        for (int w = 0; w < edgeCount.length; w++) {
            numberSteps++; // Counting step
            if (edgeCount[v][w] > 0) return true;
        }
        return false;
    }


    private List<Integer> shortcutEulerianCircuit(List<Integer> eulerianCircuit) {
        boolean[] visited = new boolean[eulerianCircuit.size()];
        List<Integer> cycle = new ArrayList<>();
        for (int v : eulerianCircuit) {
            numberSteps++; // Counting step
            if (!visited[v]) {
                cycle.add(v);
                visited[v] = true;
            }
        }
        // Ensure it's a cycle: last vertex should be the first
        if (cycle.get(cycle.size() - 1) != cycle.get(0)) {
            cycle.add(cycle.get(0));
            numberSteps++; // Counting step
        }
        return cycle;
    }
}
