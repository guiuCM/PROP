package domain.algorithms.QAP;

import domain.algorithms.DistribucionEstanteria;
import util.DistanceMatrixGenerator;
import util.Tripleta;
import java.util.*;

public class HillClimbing extends DistribucionEstanteria {

    private int minCost;
    private long numberSteps;
    private int[][] minDistribution;

    public HillClimbing(int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
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
        this.minDistribution = new int[numBaldas][numColumnas];
        int[][] distanceMatrix = DistanceMatrixGenerator.generateDistanceMatrix(numProductos, numBaldas);
        Tripleta<Integer, Long, int[][]> t = hillClimbingAlgorithm(this.matrizSimilitudes, distanceMatrix);
        this.minCost = t.obtenerPrimero();
        this.numberSteps = t.obtenerSegundo();
        this.minDistribution = t.obtenerTercero();
        return t;
    }

    public Tripleta<Integer, Long, int[][]> hillClimbingAlgorithm(int[][] flowMatrix, int[][] distanceMatrix) {
        int maxIterationsWithoutImprovement = 1; // Can be adjusted as needed
        int noImprovementCount = 0; // how many iterations without improvement

        // Generate initial solution (random permutation)
        int[] current = generateInitialSolution(numProductos);
        int currentCost = calculateCost(current, flowMatrix, distanceMatrix);

        // Hill Climbing
        while (noImprovementCount < maxIterationsWithoutImprovement) {
            List<int[]> neighbors = getNeighbors(current);

            int minCost = currentCost;
            int[] bestNeighbor = null;

            for (int[] neighbor : neighbors) {
                ++numberSteps;
                int cost = calculateCost(neighbor, flowMatrix, distanceMatrix);
                if (cost < minCost) {
                    minCost = cost;
                    bestNeighbor = neighbor;
                }
            }

            if (bestNeighbor != null && minCost < currentCost) {
                current = bestNeighbor;
                currentCost = minCost;
                noImprovementCount = 0;
            } else {
                noImprovementCount++;
            }
        }

        // Convert final permutation to the distribution matrix
        minDistribution = permutationToMatrix(current);
        minCost = currentCost;
        return new Tripleta<>(minCost, this.numberSteps, minDistribution);
    }

    private int calculateCost(int[] permutation, int[][] flowMatrix, int[][] distanceMatrix) {
        int totalCost = 0;
        int numProductos = permutation.length;

        for (int i = 0; i < numProductos; i++) {
            for (int j = i + 1; j < numProductos; j++) {
                numberSteps++;
                int facility1 = permutation[i];
                int facility2 = permutation[j];
                totalCost += flowMatrix[facility1][facility2] * distanceMatrix[i][j];
            }
        }

        return totalCost;
    }

    private int[] generateInitialSolution(int numProductos) {
        int[] permutation = new int[numProductos];
        for (int i = 0; i < numProductos; i++) {
            numberSteps++;
            permutation[i] = i;
        }
        shuffleArray(permutation);
        return permutation;
    }

    private void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            numberSteps++;
            int j = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private List<int[]> getNeighbors(int[] permutation) {
        List<int[]> neighbors = new ArrayList<>();
        int numProductos = permutation.length;
        for (int i = 0; i < numProductos; i++) {
            for (int j = i + 1; j < numProductos; j++) {
                numberSteps++;
                int[] neighbor = permutation.clone();
                // swap elements at positions i and j
                int temp = neighbor[i];
                neighbor[i] = neighbor[j];
                neighbor[j] = temp;
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    private int[][] permutationToMatrix(int[] permutation) {
        int[][] distribution = new int[numBaldas][numColumnas];
        int index = 0;
        for (int row = 0; row < numBaldas; row++) {
            for (int col = 0; col < numColumnas; col++) {
                numberSteps++;
                distribution[row][col] = permutation[index++];
            }
        }
        return distribution;
    }


}