import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            long[][] matrix1 = {
                    {13, 0, 24},
                    {164, 122, 2},
                    {2, 1, 1}
            };

            long[][] matrix2 = {
                    {39, 82, 4},
                    {2, 1, 1},
                    {2, 2, 0}
            };

            if (!isSameSize(matrix1, matrix2)) {
                throw new IllegalArgumentException("Матриці мають різні розміри.");
            }

            long[][] resultMatrix = multiplyMatrices(matrix1, matrix2);

            System.out.println("Результат множення матриць:");
            printMatrix(resultMatrix);

            long specialSum = calculateSpecialSum(resultMatrix);

            System.out.println("Сума найбільших елементів парних рядків та найменших елементів непарних рядків: " + specialSum);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Невідома помилка: " + e.getMessage());
        }
    }

    private static boolean isSameSize(long[][] matrix1, long[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }

        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }
        }

        return true;
    }

    private static long[][] multiplyMatrices(long[][] matrix1, long[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix2[0].length;
        int commonDim = matrix1[0].length;
        long[][] result = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < commonDim; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    private static long calculateSpecialSum(long[][] matrix) {
        long sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if ((i + 1) % 2 == 0) {
                long maxElement = Long.MIN_VALUE;
                for (long element : matrix[i]) {
                    if (element > maxElement) {
                        maxElement = element;
                    }
                }
                sum += maxElement;
            } else {
                long minElement = Long.MAX_VALUE;
                for (long element : matrix[i]) {
                    if (element < minElement) {
                        minElement = element;
                    }
                }
                sum += minElement;
            }
        }

        return sum;
    }

    private static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
