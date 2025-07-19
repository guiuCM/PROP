package util;

/**
 * La clase {@code MatrixUtil} proporciona utilidades para manipular matrices, específicamente
 * para convertir matrices de similitud máxima a matrices de costo mínimas, adecuadas para algoritmos
 * como el Travelling Salesman Problem (TSP).
 *
 * <p>Esta clase es útil en contextos donde se requiere transformar una matriz que representa
 * similitudes entre elementos en una matriz de costos que puede ser utilizada por algoritmos
 * de optimización y búsqueda de rutas.</p>
 */
public class MatrixUtil {

    /**
     * Verifica si la matriz dada está en forma de similitud máxima.
     * Si lo está, la convierte a forma de costo mínimo aplicando la fórmula:
     * <pre>
     * costo = 100 - similitud
     * </pre>
     *
     * @param matrix La matriz de entrada que representa los coeficientes de similitud.
     * @return La matriz de costos convertida, adecuada para algoritmos TSP.
     * @throws IllegalArgumentException si {@code matrix} es {@code null} o no es una matriz cuadrada.
     *
     * @implNote
     * <p>Se asume que una matriz de similitud máxima tiene todos los valores de similitud
     * mayores que cero en posiciones no diagonales. La conversión a costo mínimo se realiza
     * restando cada valor de similitud de 100, manteniendo los valores diagonales en 0.</p>
     */
    public static int[][] convertMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("La matriz no debe ser null.");
        }

        int n = matrix.length;

        // Verificar que la matriz sea cuadrada
        for (int i = 0; i < n; i++) {
            if (matrix[i].length != n) {
                throw new IllegalArgumentException("La matriz debe ser cuadrada (n x n).");
            }
        }

        // Verificar si la matriz está en forma de similitud máxima
        // Se asume que una matriz de similitud máxima tiene valores mayores a 0 en posiciones no diagonales
        boolean isMaximumMatrix = (matrix[0][0] == 100);

        // Si está en forma de similitud máxima, convertirla a forma de costo mínimo
        if (isMaximumMatrix) {
            int[][] convertedMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        convertedMatrix[i][j] = 0;
                    } else {
                        convertedMatrix[i][j] = 100 - matrix[i][j];
                    }
                }
            }
            return convertedMatrix;
        } else {
            // La matriz ya está en forma de costo; devolverla tal cual
            return matrix;
        }
    }
}
