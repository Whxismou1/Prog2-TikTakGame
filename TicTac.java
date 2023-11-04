import java.util.Scanner;

public class TicTac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] matrix = rellenarMatrix(sc);
        sc.close();

        int numX = countNumXMax(matrix);

        if (solveMatrix(matrix, 0, 0, numX)) {
            printMatrix(matrix);
        } else {
            System.out.println("No hay solucion");
        }

    }

    private static int countNumXMax(char[][] matrix) {
        // _X_
        // XOO
        // O__

        int[] numListRowX = new int[matrix.length];
        int[] numListColX = new int[matrix.length];
        int countXRow = 0;
        int countXCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'x') {
                    countXRow++;
                }

                if (matrix[j][i] == 'x') {
                    countXCol++;
                }

            }
            numListRowX[i] = countXRow;
            numListColX[i] = countXCol;
            countXRow = 0;
            countXCol = 0;
        }

        int max = 0;

        for (int i = 0; i < numListRowX.length; i++) {
            if (max < numListRowX[i]) {
                max = numListRowX[i];
            }
        }

        for (int i = 0; i < numListColX.length; i++) {
            if (max < numListColX[i]) {
                max = numListColX[i];
            }
        }

        return max;
    }

    private static char[][] rellenarMatrix(Scanner sc) {
        String[] lines = new String[100];
        int count = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().toLowerCase();
            if (line.isEmpty()) {
                break;
            }
            lines[count] = line;
            count++;
        }

        char[][] matrix = new char[count][count];

        for (int i = 0; i < count; i++) {
            char[] row = lines[i].toCharArray();
            for (int j = 0; j < count; j++) {
                matrix[i][j] = row[j];
            }
        }

        return matrix;
    }

    private static boolean solveMatrix(char[][] matrix, int i, int j, int numX) {
        if (i == matrix.length) {
            return true;
        }

        if (j == matrix.length) {
            return solveMatrix(matrix, i + 1, 0, numX);
        }

        if (matrix[i][j] == '_') {
            for (char value : new char[] { 'x', 'o' }) {
                matrix[i][j] = value;
                if (isValid(matrix, numX)) {
                    if (solveMatrix(matrix, i, j + 1, numX) && isValid(matrix, numX)) {
                        return true;
                    }
                }
                matrix[i][j] = '_';
            }
        } else {
            if (solveMatrix(matrix, i, j + 1, numX)) {
                return true;
            }

        }

        return false;
    }

    private static boolean isValid(char[][] matrix, int numX) {

        int[] numXRow = new int[matrix.length];
        int[] numXCol = new int[matrix.length];
        int countXRow = 0;
        int countXCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'x') {
                    countXRow++;
                }

                if (matrix[j][i] == 'x') {
                    countXCol++;
                }

            }
            numXRow[i] = countXRow;
            numXCol[i] = countXCol;
            countXRow = 0;
            countXCol = 0;
        }

        for (int i = 0; i < numXRow.length; i++) {
            if (numXRow[i] > numX) {
                return false;
            } else if (numXCol[i] > numX) {
                return false;
            }
        }

        return true;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
