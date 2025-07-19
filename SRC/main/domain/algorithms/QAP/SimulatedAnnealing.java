package domain.algorithms.QAP;

import domain.algorithms.DistribucionEstanteria;
import util.DistanceMatrixGenerator;
import util.Tripleta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Random;

public class SimulatedAnnealing extends DistribucionEstanteria {
    private int minCost;
    private long numberSteps;
    private int[][] minDistribution;

    public SimulatedAnnealing(int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
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

    public void estudioEstadistico(int log) {
        // FIXED parameters
        int maxIterations = 10000;       // fixed
        int maxNoImprovement = 2500;     // fixed

        /*
        double[] temperatures = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        double[] alphas = {0.9, 0.91, 0.92, 0.93, 0.94, 0.95, 0.96, 0.97, 0.98, 0.99};
        double[] minTemperatures = {0.01, 0.009, 0.008, 0.007, 0.006, 0.005, 0.004, 0.003, 0.002, 0.001};
        */

        /*
        double[] temperatures = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        double[] alphas = {0.99, 0.991, 0.992, 0.993, 0.994, 0.995, 0.996, 0.997, 0.998, 0.999};
        double[] minTemperatures = {0.01, 0.009, 0.008, 0.007, 0.006, 0.005, 0.004, 0.003, 0.002, 0.001};



        double[] temperatures = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        double[] alphas = {0.998, 0.99825, 0.9985, 0.99875, 0.999, 0.99925, 0.9995, 0.99975};
        double[] minTemperatures = {0.01, 0.009, 0.008, 0.007, 0.006, 0.005, 0.004, 0.003, 0.002, 0.001};
        */

        double[] temperatures = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        double[] alphas = {0.99, 0.992, 0.994, 0.996, 0.998};
        double[] minTemperatures = {0.01, 0.009, 0.008, 0.007, 0.006, 0.005, 0.004, 0.003, 0.002, 0.001};

        // Define fixed seeds for each replicate
        int q = 1791 * 7294 % 30290;
        int r = 17869 * 892062 % 8290203;
        int s = 893 * 1234 % 250;  // 232
        int t = 8462 * 5678 % 8921; // 2045
        int u = 289 * 1357 % 100;  // 11
        int v = 423 * 7294 % 30290;
        int w = 423 * 892062 % 8290203;
        int x = 423 * 1234 % 250;  // 232
        int y = 423 * 5678 % 8921; // 2045
        int z = 423 * 1357 % 100;  // 11
        int[] replicateSeeds = {q, r, s, t, u, v, w, x, y, z};

        // Number of replicates (seeds)
        int replicates = replicateSeeds.length;

        // Generate distance matrix once (for the given problem instance)
        int[][] distanceMatrix = DistanceMatrixGenerator.generateDistanceMatrix(numProductos, numBaldas);

        // Create a unique directory for results
        File outputDir = new File("src/test/domain/algorithms/Unitarios/EstudioEstadísticoSA/Data");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        // Create a unique CSV file
        File outputFile = new File(outputDir, "sa_estudio_resultados_4_" + log + ".csv");

        try (PrintWriter writer = new PrintWriter(outputFile)) {
            // Print CSV header
            // We'll store the final columns in this order:
            // Temperature, Alpha, MaxIterations (fixed), MinTemperature, MaxNoImprovement (fixed), Run, Cost, NumberSteps
            writer.println("Temperature,Alpha,MaxIterations,MinTemperature,MaxNoImprovement,Run,Cost,NumberSteps");

            // Loop over each seed (replicate)
            for (int run = 1; run <= replicates; run++) {
                long seed = replicateSeeds[run - 1];

                // Print a line indicating which seed we are using
                writer.println("Seed " + run + ":");

                // Now loop over each parameter configuration for this seed
                for (double temp : temperatures) {
                    for (double alpha : alphas) {
                        for (double minTemp : minTemperatures) {
                            // Run Simulated Annealing
                            Tripleta<Integer, Long, int[][]> result = runSimulatedAnnealingWithParams(
                                    matrizSimilitudes,
                                    distanceMatrix,
                                    temp,
                                    alpha,
                                    maxIterations,     // fixed
                                    minTemp,
                                    maxNoImprovement,  // fixed
                                    seed
                            );

                            int cost = result.obtenerPrimero();
                            long steps = result.obtenerSegundo();

                            writer.println(
                                    temp + "," +
                                            alpha + "," +
                                            maxIterations + "," +
                                            minTemp + "," +
                                            maxNoImprovement + "," +
                                            run + "," +
                                            cost + "," +
                                            steps
                            );
                        }
                    }
                }
            }

            System.out.println("Estudio estadístico completado. Resultados guardados en: " + outputFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }

    // Remember to update your generateInitialSolution to use the same Random 'rand' to ensure full reproducibility.
    private Tripleta<Integer, Long, int[][]> runSimulatedAnnealingWithParams(
            int[][] flowMatrix,
            int[][] distanceMatrix,
            double initialTemperature,
            double alpha,
            int maxIterations,
            double minTemperature,
            int maxNoImprovement,
            long seed) {

        this.minCost = Integer.MAX_VALUE;
        this.numberSteps = 0;

        // Use the fixed seed to create the Random object
        Random rand = new Random(seed);

        int n = flowMatrix.length;
        double temperature = initialTemperature;

        // Use the same rand for generating the initial solution
        int[] currentSolution = generateInitialSolution(n, rand);
        int currentCost = calculateCost(currentSolution, flowMatrix, distanceMatrix);

        int[] bestSolution = currentSolution.clone();
        int bestCost = currentCost;

        int noImprovementCounter = 0;

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            // Generate neighbor
            int[] neighbor = currentSolution.clone();
            int i = rand.nextInt(n);
            int j = rand.nextInt(n);
            while (j == i) {
                j = rand.nextInt(n);
                this.numberSteps++;
            }

            // Swap
            int temp = neighbor[i];
            neighbor[i] = neighbor[j];
            neighbor[j] = temp;
            this.numberSteps++;

            int neighborCost = calculateCost(neighbor, flowMatrix, distanceMatrix);
            int delta = neighborCost - currentCost;

            // Acceptance condition
            if (delta < 0) {
                currentSolution = neighbor;
                currentCost = neighborCost;
                noImprovementCounter = 0;
            } else {
                double acceptanceProb = Math.exp(-delta / temperature);
                if (acceptanceProb > rand.nextDouble()) {
                    currentSolution = neighbor;
                    currentCost = neighborCost;
                } else {
                    noImprovementCounter++;
                }
            }

            // Update best
            if (currentCost < bestCost) {
                bestCost = currentCost;
                bestSolution = currentSolution.clone();
                noImprovementCounter = 0;
            }

            // Cool down
            temperature *= alpha;

            // Stopping criteria
            if (temperature < minTemperature || noImprovementCounter > maxNoImprovement) {
                break;
            }
        }

        this.minDistribution = permutationToMatrix(bestSolution);
        this.minCost = bestCost;

        return new Tripleta<>(this.minCost, this.numberSteps, this.minDistribution);
    }


    private int[] generateInitialSolution(int n, Random rand) {
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
            this.numberSteps++;
        }
        shuffleArray(permutation, rand);
        return permutation;
    }

    private void shuffleArray(int[] array, Random rand) {
        for (int i = array.length - 1; i > 0; i--) {
            this.numberSteps++;
            int j = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }


    @Override
    public Tripleta<Integer, Long, int[][]> calculaAlgoritmoVecinos() {
        // Reset class-level variables before starting the algorithm
        this.minCost = Integer.MAX_VALUE;
        this.numberSteps = 0;
        this.minDistribution = new int[numBaldas][numProductos / numBaldas];

        // Generate distance matrix
        int[][] distanceMatrix = DistanceMatrixGenerator.generateDistanceMatrix(numProductos, numBaldas);

        // Execute the Simulated Annealing algorithm
        Tripleta<Integer, Long, int[][]> result = simulatedAnnealingAlgorithm(this.matrizSimilitudes, distanceMatrix);

        // Update class-level variables with the results
        this.minCost = result.obtenerPrimero();
        this.numberSteps = result.obtenerSegundo();
        this.minDistribution = result.obtenerTercero();

        return result;
    }

    public Tripleta<Integer, Long, int[][]> simulatedAnnealingAlgorithm(int[][] flowMatrix, int[][] distanceMatrix) {
        int n = flowMatrix.length;

        // Parameters for Simulated Annealing
        double temperature = 5000;
        final double alpha = 0.9985;
        final int maxIterations = 10000;

        // Stopping criterion thresholds (adjust as needed)
        final double minTemperature = 0.0075;
        final int maxNoImprovement = 2500;  // If we go too long without improvement

        // Generate initial solution
        int[] currentSolution = generateInitialSolution(n);
        int currentCost = calculateCost(currentSolution, flowMatrix, distanceMatrix);

        // Initialize best solution
        int[] bestSolution = currentSolution.clone();
        int bestCost = currentCost;

        java.util.Random rand = new java.util.Random();

        // Track iterations without improvement
        int noImprovementCounter = 0;

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            // Generate a neighbor solution by swapping two random facilities
            int[] neighbor = currentSolution.clone();
            int i = rand.nextInt(n);
            int j = rand.nextInt(n);
            while (j == i) {
                j = rand.nextInt(n);
                this.numberSteps++;
            }

            // Swap
            int temp = neighbor[i];
            neighbor[i] = neighbor[j];
            neighbor[j] = temp;
            this.numberSteps++;

            // Compute neighbor cost
            int neighborCost = calculateCost(neighbor, flowMatrix, distanceMatrix);

            int delta = neighborCost - currentCost;

            // Acceptance probability
            if (delta < 0) {
                // Better solution, accept immediately
                currentSolution = neighbor;
                currentCost = neighborCost;
                noImprovementCounter = 0; // reset since we found an improvement
            } else {
                // Worse solution, accept with probability exp(-delta/T)
                double acceptanceProb = Math.exp(-delta / temperature);
                if (acceptanceProb > rand.nextDouble()) {
                    currentSolution = neighbor;
                    currentCost = neighborCost;
                } else {
                    noImprovementCounter++;
                }
            }

            // Update best solution found so far
            if (currentCost < bestCost) {
                bestCost = currentCost;
                bestSolution = currentSolution.clone();
                noImprovementCounter = 0; // improvement found
            }

            // Cool down the temperature
            temperature *= alpha;

            // Optional: Add a stopping criterion based on low temperature or no improvement
            if (temperature < minTemperature || noImprovementCounter > maxNoImprovement) {
                break;
            }
        }

        this.minDistribution = permutationToMatrix(bestSolution);
        this.minCost = bestCost;

        return new Tripleta<>(minCost, this.numberSteps, this.minDistribution);
    }

    /**
     * Generates an initial random permutation of size n.
     */
    private int[] generateInitialSolution(int n) {
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
            this.numberSteps++;
        }
        shuffleArray(permutation);
        return permutation;
    }

    /**
     * Shuffle array using Fisher–Yates.
     */
    private void shuffleArray(int[] array) {
        java.util.Random rand = new java.util.Random();
        for (int i = array.length - 1; i > 0; i--) {
            this.numberSteps++;
            int j = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * Calculates the cost of a given permutation for the QAP.
     * Only sum over j > i to avoid double counting.
     */
    private int calculateCost(int[] permutation, int[][] flowMatrix, int[][] distanceMatrix) {
        int totalCost = 0;
        int n = permutation.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                this.numberSteps++;
                int facility1 = permutation[i];
                int facility2 = permutation[j];

                totalCost += flowMatrix[facility1][facility2] * distanceMatrix[i][j];
                // If symmetrical, no need to add reverse since it's the same.
            }
        }

        return totalCost;
    }

    /**
     * Converts a 1D permutation into a 2D distribution matrix: numBaldas rows, (numProductos/numBaldas) columns.
     */
    private int[][] permutationToMatrix(int[] permutation) {
        int cols = numProductos / numBaldas;
        int[][] distribution = new int[numBaldas][cols];
        int index = 0;
        for (int row = 0; row < numBaldas; row++) {
            for (int col = 0; col < cols; col++) {
                this.numberSteps++;
                distribution[row][col] = permutation[index++];

            }
        }
        return distribution;
    }
}
