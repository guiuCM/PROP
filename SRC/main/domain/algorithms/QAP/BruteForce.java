package domain.algorithms.QAP;

import domain.algorithms.DistribucionEstanteria;
import util.Tripleta;
import util.DistanceMatrixGenerator;

public class BruteForce extends DistribucionEstanteria {

    private int minCost;
    private long numberSteps;
    private int[][] minDistribution;

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
        this.minDistribution = new int[numBaldas][numProductos / numBaldas];
    }

    @Override
    public Tripleta<Integer, Long, int[][]> calculaAlgoritmoVecinos() {
        this.minCost = Integer.MAX_VALUE;
        this.minDistribution = new int[numBaldas][numProductos / numBaldas];
        int[][] distanceMatrix = DistanceMatrixGenerator.generateDistanceMatrix(numProductos, numBaldas);
        Tripleta<Integer, Long, int[][]> t = bruteForceAlgorithmQAP(this.matrizSimilitudes, distanceMatrix);
        this.minCost = t.obtenerPrimero();
        this.numberSteps = t.obtenerSegundo();
        this.minDistribution = t.obtenerTercero();
        return t;
    }

    public Tripleta<Integer, Long, int[][]> bruteForceAlgorithmQAP(int[][] flowMatrix, int[][] distanceMatrix) {
        int n = flowMatrix.length;
        int[] assignment = new int[n];
        for (int i = 0; i < n; i++) {
            numberSteps++;
            assignment[i] = i;
        }

        int[] minDistributionArr = new int[n];
        this.minCost = Integer.MAX_VALUE;

        // Evaluate the INITIAL permutation (assignment is [0,1,2,...,n-1]):
        int initialCost = calculateTotalCost(flowMatrix, distanceMatrix, assignment);
        if (initialCost < minCost) {
            minCost = initialCost;
            System.arraycopy(assignment, 0, minDistributionArr, 0, n);
        }

        // Standard nextPermutation loop:
        while (nextPermutation(assignment)) {
            numberSteps++;

            // Skip reversed permutations
            if (shouldSkip(assignment)) {
                continue;
            }

            int cost = calculateTotalCost(flowMatrix, distanceMatrix, assignment);
            if (cost < minCost) {
                minCost = cost;
                System.arraycopy(assignment, 0, minDistributionArr, 0, n);
            }
        }

        // Rebuild the 2D minDistribution from minDistributionArr
        int cnt = 0;
        for (int i = 0; i < numBaldas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                numberSteps++;
                this.minDistribution[i][j] = minDistributionArr[cnt++];
            }
        }

        return new Tripleta<>(minCost, numberSteps, this.minDistribution);
    }

    private boolean shouldSkip(int[] assignment) {
        int n = assignment.length;
        for (int k = 0; k < n; k++) {
            ++numberSteps;
            if (assignment[k] < assignment[n - 1 - k]) {
                // assignment is lexicographically smaller than its reverse
                return false;  // Don't skip
            } else if (assignment[k] > assignment[n - 1 - k]) {
                // assignment is bigger than its reverse
                return true;   // Skip!
            }
        }
        // If assignment == reverse(assignment), no harm in counting it once
        return false;
    }

    private int calculateTotalCost(int[][] flowMatrix, int[][] distanceMatrix, int[] assignment) {
        int totalCost = 0;
        int n = flowMatrix.length;

        // Only sum over i < j, counting each pair exactly once
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                numberSteps++;
                int facility1 = assignment[i];
                int facility2 = assignment[j];

                // Since it's symmetrical, adding just once is enough
                totalCost += flowMatrix[facility1][facility2] * distanceMatrix[i][j];
                // since it's the same value due to symmetry.
            }
        }

        return totalCost;
    }

    private boolean nextPermutation(int[] arr) {
        // Standard next_permutation implementation
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            numberSteps++;
            i--;
        }
        if (i < 0) {
            return false;
        }

        int j = n - 1;
        while (arr[j] <= arr[i]) {
            numberSteps++;
            j--;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        int start = i + 1;
        int end = n - 1;
        while (start < end) {
            numberSteps++;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return true;
    }

}