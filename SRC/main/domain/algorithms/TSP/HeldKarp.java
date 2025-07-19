package domain.algorithms.TSP;

import domain.algorithms.DistribucionEstanteria;
import util.Tripleta;

public class HeldKarp extends DistribucionEstanteria {

    private int minCost;
    private long numberSteps;
    private int[] minPath;

    public HeldKarp(int numProductos, int numEstanterias, int[] productos, int[][] matrizSimilitudes) {
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
        // Post: Se inicializa min con el peor valor posible (infinito positivo)
    }

    @Override
    public Tripleta<Integer, Long, int[]> calculaAlgoritmoLateral() {
        this.minCost = Integer.MAX_VALUE;
        this.minPath = new int[numProductos];
        Tripleta<Integer, Long, int[]> t =  HeldKarpAlgorithm(this.matrizSimilitudes);
        this.minCost = t.obtenerPrimero();
        this.numberSteps = t.obtenerSegundo();
        this.minPath = t.obtenerTercero();
        return t;
    }

    /**
     * Held-Karp Algorithm for the TSP
     *
     * This dynamic programming approach works as follows:
     * - We represent subsets of visited cities with an integer mask.
     * - dp[mask][i] stores the minimal cost to reach city i having visited the subset of cities represented by mask.
     * - The goal is dp[fullSet][i] + cost(i->0), minimized over i.
     */
    public Tripleta<Integer, Long, int[]> HeldKarpAlgorithm(int[][] m) {
        int fullSet = fullSet(numProductos);

        // dp[mask][i] = min cost to reach city i with visited set = mask
        int[][] dp = new int[fullSet + 1][numProductos];
        int[][] parent = new int[fullSet + 1][numProductos];

        // Initialize dp arrays
        for (int mask = 0; mask <= fullSet; mask++) {
            for (int i = 0; i < numProductos; i++) {
                dp[mask][i] = Integer.MAX_VALUE;
                parent[mask][i] = -1;
            }
        }

        // Starting city is 0
        dp[addCity(0,0)][0] = 0;

        // Build solutions for all subsets
        for (int mask = 1; mask <= fullSet; mask++) {
            for (int i = 0; i < numProductos; i++) {
                // If city i is in current subset and we have a finite cost
                if (isCityVisited(mask, i) && dp[mask][i] != Integer.MAX_VALUE) {
                    // Try next city j not in mask
                    for (int j = 0; j < numProductos; j++) {
                        numberSteps++; // considering transition from i to j
                        if (!isCityVisited(mask, j) && m[i][j] != Integer.MAX_VALUE) {
                            int nextMask = addCity(mask, j);
                            int newCost = dp[mask][i] + m[i][j];
                            if (newCost < dp[nextMask][j]) {
                                dp[nextMask][j] = newCost;
                                parent[nextMask][j] = i;
                            }
                        }
                    }
                }
            }
        }

        // Find the minimal cost to return to start (0)
        int lastCity = -1;

        // Check all endpoints i for the full visited set
        for (int i = 1; i < numProductos; i++) {
            numberSteps++;

            // checking route back to start
            if (dp[fullSet][i] != Integer.MAX_VALUE && m[i][0] != Integer.MAX_VALUE) {
                int tourCost = dp[fullSet][i] + m[i][0];
                if (tourCost < minCost) {
                    minCost = tourCost;
                    lastCity = i;
                }
            }
        }

        // Reconstruct the path
        minPath = reconstructPath(parent, lastCity, fullSet);
        numberSteps += numProductos; // Counting steps for reconstruction (rough estimate)

        return new Tripleta<>(minCost, numberSteps, minPath);
    }

    /**
     * Reconstructs the tour path from the parent array.
     */
    private int[] reconstructPath(int[][] parent, int lastCity, int mask) {
        int[] tour = new int[numProductos];
        int currCity = lastCity;

        for (int pos = numProductos - 1; pos > 0; pos--) {
            numberSteps++; // reconstructing path step
            if (currCity < 0 || currCity >= numProductos) {
                throw new IllegalStateException("Out of bounds: currCity=" + currCity);
            }
            if (mask < 0 || mask >= parent.length) {
                throw new IllegalStateException("Out of bounds: mask=" + mask);
            }
            tour[pos] = currCity;
            int prevCity = parent[mask][currCity];
            mask = removeCity(mask, currCity); // remove current city from mask
            currCity = prevCity;
        }
        tour[0] = 0; // Start city
        return tour;
    }

    /**
     * Returns a mask with all cities visited.
     * For n=3: 1<<3 = 8, 8-1=7 = binary 111 (cities 0,1,2 all visited)
     */
    private int fullSet(int n) {
        return (1 << n) - 1;
    }

    /**
     * Checks if a given city is visited in the mask.
     * For city i, (1 << i) creates a binary number with only the i-th bit set.
     * (mask & (1 << i)) != 0 means the i-th bit of mask is set, so city i is visited.
     */
    private boolean isCityVisited(int mask, int city) {
        return (mask & (1 << city)) != 0;
    }

    /**
     * Returns a new mask with city i marked as visited.
     * If mask=0101 and city=2, (1<<2)=0100, mask|0100=0101|0100=1101 adds city 2.
     */
    private int addCity(int mask, int city) {
        return mask | (1 << city);
    }

    /**
     * Returns a new mask with city i removed.
     * If we want to remove city i, we AND mask with the complement of (1<<i).
     * e.g. mask=1101 (visited cities {0,2,3}), remove city=2 (0100):
     * ~0100=1011, 1101 & 1011 = 1001 removes city 2.
     */
    private int removeCity(int mask, int city) {
        return mask & ~(1 << city);
    }
}
