package domain.algorithms;

import domain.CjtProductos;
import util.Tripleta;
import util.DistanceMatrixGenerator;

public abstract class DistribucionEstanteria {

    protected static int numProductos;
    protected static int numBaldas;
    protected int numColumnas; // Siempre será numProductos/numBaldas
    protected int[] productos;
    protected static int[][] matrizSimilitudes;
    protected int[][] solucion;


    public DistribucionEstanteria(int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
        if (numProductos <= 0) {
            throw new IllegalArgumentException("El número de productos debe ser mayor que cero.");
        }
        if (numBaldas <= 0) {
            throw new IllegalArgumentException("El número de estanterías debe ser mayor que cero.");
        }
        if (productos.length != numProductos) {
            throw new IllegalArgumentException("El arreglo de estanterías debe tener una longitud igual al número de productos.");
        }
        if (matrizSimilitudes.length != numProductos) {
            throw new IllegalArgumentException("La matriz de similitudes debe ser de tamaño numProductos x numProductos.");
        }
        for (int[] fila : matrizSimilitudes) {
            if (fila.length != numProductos) {
                throw new IllegalArgumentException("La matriz de similitudes debe ser de tamaño numProductos x numProductos.");
            }
        }

        // Asignaciones
        this.numProductos = numProductos;
        this.numBaldas = numBaldas;
        this.numColumnas = numProductos / numBaldas;
        this.productos = productos;
        this.matrizSimilitudes = matrizSimilitudes;
        this.solucion = null; // Inicialmente no hay solución

        // Postcondiciones verificadas
    }

    public void parseSolutionMIN(Tripleta<Integer, Long, int[]> sol) {
        System.out.println("Mínimo = " + sol.obtenerPrimero() + ", obtenido con [" + sol.obtenerSegundo() + "] pasos.");
        int[] arr = sol.obtenerTercero();
        for (int i = 0; i < numProductos; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void parseSolutionMINQAP(Tripleta<Integer, Long, int[][]> sol) {
        System.out.println("Mínimo = " + sol.obtenerPrimero() + ", obtenido con [" + sol.obtenerSegundo() + "] pasos.");
        int[][] bestDistribution = sol.obtenerTercero();
        for (int[] ints : bestDistribution) {
            for (int anInt : ints) {
                System.out.print(anInt + 1 + "\t"); // Imprime cada valor con tabulación
            }
            System.out.println(); // Salto de línea después de cada fila
        }


    }

    public void parseSolutionTSP(Tripleta<Integer, Long, int[]> sol, int numBaldas) {
        // Step 1: Retrieve the second element (int array)
        int[] tourArray = sol.obtenerTercero();

        // Step 2: Determine the number of columns and rows
        int numRows = numBaldas;
        int numCols = tourArray.length / numRows;

        // Step 3: Create the 2D matrix with snake-like pattern
        int[][] matrix = new int[numRows][numCols];

        if (numCols == 1) {
            for (int i = 0; i < numRows; i++) {
                matrix[i][0] = tourArray[i];
            }
        }
        else {
            for (int i = 0; i < tourArray.length; i++) {
                int row = i / numCols;
                int col = i % numCols;

                // Determine if the current row should be filled left-to-right or right-to-left
                if (row % 2 == 1) { // Odd row index: fill right-to-left
                    matrix[row][numCols - 1 - col] = tourArray[i];
                } else { // Even row index: fill left-to-right
                    matrix[row][col] = tourArray[i];
                }
            }
        }

        //SOLUTION FOUND
        System.out.println("The number of steps needed to reach this solution is: [" + sol.obtenerSegundo() + "]");

        System.out.println("The minimum tour would be: ");
        for (int[] rowArr : matrix) {
            for (int element : rowArr) {
                System.out.print(element+1 + "\t"); // Tab-separated for better readability
            }
            System.out.println(); // Newline after each row
        }

        // Existing print statement for the minimum tour cost
        System.out.println("And the minimum tour would have cost: " + sol.obtenerPrimero() + "\n");
    }

    public Tripleta<Integer, Long, int[][]> parseSolutionTSP2(Tripleta<Integer, Long, int[]> sol, int numBaldas) {
        // Step 1: Retrieve the second element (int array)
        int[] tourArray = sol.obtenerTercero();

        // Step 2: Determine the number of columns and rows
        int numRows = numBaldas;
        int numCols = tourArray.length / numRows;

        // Step 3: Create the 2D matrix with snake-like pattern
        int[][] matrix = new int[numRows][numCols];

        if (numCols == 1) {
            for (int i = 0; i < numRows; i++) {
                matrix[i][0] = tourArray[i];
            }
        }
        else {
            for (int i = 0; i < tourArray.length; i++) {
                int row = i / numCols;
                int col = i % numCols;

                // Determine if the current row should be filled left-to-right or right-to-left
                if (row % 2 == 1) { // Odd row index: fill right-to-left
                    matrix[row][numCols - 1 - col] = tourArray[i];
                } else { // Even row index: fill left-to-right
                    matrix[row][col] = tourArray[i];
                }
            }
        }
        Tripleta<Integer, Long, int[][]> Tripleta = new Tripleta<>(sol.obtenerPrimero(), sol.obtenerSegundo(), matrix);
        return Tripleta;
    }

    public void parseSolutionQAP(Tripleta<Integer, Long, int[][]> sol) {
        // Step 1: Retrieve the second element (int array)
        int[][] bestDistribution = sol.obtenerTercero();

        //SOLUTION FOUND
        System.out.println("The number of steps needed to reach this solution is: [" + sol.obtenerSegundo() + "]");

        System.out.println("The minimum distribution would be:");
        for (int i = 0; i < bestDistribution.length; i++) {
            for (int j = 0; j < bestDistribution[i].length; j++) {
                System.out.print(bestDistribution[i][j] + 1 + "\t"); // Imprime cada valor con tabulación
            }
            System.out.println(); // Salto de línea después de cada fila
        }


        // Existing print statement for the minimum tour cost
        System.out.println("And the minimum tour would have cost: " + sol.obtenerPrimero() + "\n");
    }


    public static Integer calcularBondadSolucionTSP(int[][] matrizProductos) {
        //tenemos matriz similitudes en this.matrizSimilitudes
        int n = matrizProductos.length * matrizProductos[0].length;

        //paso de matriz productos a path para calcularlo en 1 solo for linealmente
        int[] path = new int[n];
        int aux_Counter = 0;
        for (int i = 0; i < matrizProductos.length; i++) {
            for (int j = 0; j < matrizProductos[0].length; j++) {
                path[aux_Counter] = matrizProductos[i][j];
                ++aux_Counter;
            }
        }

        int solucion = 0;
        for (int i = 0; i < n-1; i++) {
            solucion += matrizSimilitudes[path[i]][path[i+1]];
        }
        solucion += matrizSimilitudes[path[n-1]][path[0]];
        return solucion;
    }

    public static Integer calcularBondadSolucionQAP(int[][] matrizProductos) {
        int[][] distanceMatrix = DistanceMatrixGenerator.generateDistanceMatrix(numProductos, numBaldas);

        int totalCost = 0;
        int n = matrizSimilitudes.length;

        //from matrizProductos to assignment:
        int[] assignment = new int[n];
        int aux_Counter = 0;
        for (int i = 0; i < matrizProductos.length; i++) {
            for (int j = 0; j < matrizProductos[0].length; j++) {
                assignment[aux_Counter] = matrizProductos[i][j];
                ++aux_Counter;
            }
        }
        // Only sum over i < j, counting each pair exactly once
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int facility1 = assignment[i];
                int facility2 = assignment[j];

                // Since it's symmetrical, adding just once is enough
                totalCost += matrizSimilitudes[facility1][facility2] * distanceMatrix[i][j];
                // since it's the same value due to symmetry.
            }
        }

        return totalCost;
    }

    public Tripleta<Integer, Long, int[]> calculaAlgoritmoLateral() {
        throw new UnsupportedOperationException("Algoritmo no implementado.");
    }

    public Tripleta<Integer, Long, int[][]> calculaAlgoritmoVecinos() {
        throw new UnsupportedOperationException("Algoritmo no implementado.");
    }
}
