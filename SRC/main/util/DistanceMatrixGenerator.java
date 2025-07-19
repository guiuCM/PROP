package util;


import java.util.Arrays;

public class DistanceMatrixGenerator {

    /**
     * Generates the distance (adjacency) matrix for a grid layout.
     *
     * @param n     Total number of products/locations.
     * @param rows  Number of rows in the grid.
     * @return      An n x n distance matrix with 1s for adjacent locations.
     * @throws IllegalArgumentException if n is not divisible by rows.
     */
    public static int[][] generateDistanceMatrix(int n, int rows) {
        if (n % rows != 0) {
            throw new IllegalArgumentException("Total number of products (n) must be divisible by the number of rows.");
        }

        int cols = n / rows;
        int[][] distanceMatrix = new int[n][n];

        // Initialize the distance matrix with 0s
        for (int[] row : distanceMatrix) {
            Arrays.fill(row, 0);
        }

        // Add adjacence = 1 for first and last values.
        distanceMatrix[0][n-1] = 1;
        distanceMatrix[n-1][0] = 1;

        // Iterate over each location to determine its neighbors
        for (int location = 0; location < n; location++) {
            int row = location / cols;
            int col = location % cols;

            // Up Neighbor
            if (row > 0) {
                int up = (row - 1) * cols + col;
                distanceMatrix[location][up] = 1;
                distanceMatrix[up][location] = 1; // Ensure symmetry
            }

            // Down Neighbor
            if (row < rows - 1) {
                int down = (row + 1) * cols + col;
                distanceMatrix[location][down] = 1;
                distanceMatrix[down][location] = 1; // Ensure symmetry
            }

            // Left Neighbor
            if (col > 0) {
                int left = row * cols + (col - 1);
                distanceMatrix[location][left] = 1;
                distanceMatrix[left][location] = 1; // Ensure symmetry
            }

            // Right Neighbor
            if (col < cols - 1) {
                int right = row * cols + (col + 1);
                distanceMatrix[location][right] = 1;
                distanceMatrix[right][location] = 1; // Ensure symmetry
            }
        }

        return distanceMatrix;
    }



    public static void main(String[] args) {
        int n = 8; // Total products
        int rows = 2; // Number of rows

        try {
            int[][] distanceMatrix = generateDistanceMatrix(n, rows);

            System.out.println("Distance (Adjacency) Matrix:");
            for (int[] row : distanceMatrix) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
