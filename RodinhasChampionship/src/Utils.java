import java.io.IOException;

public class Utils {

    /**
     * Faz print a um vector de strings.
     *
     * @parm String[]
     */
    public static void printStringVector(String[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(i + ": " + vector[i]);
            System.out.println();
        }
    }

    /**
     * Faz print a um vector de ints.
     *
     * @parm int[]
     */
    public static void printIntVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(i + ": " + vector[i]);
            System.out.println();
        }
    }

    /**
     * Faz print a uma matriz de strings.
     *
     * @parm String[][]
     */
    public static void printStringMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Faz print a uma matriz de ints.
     *
     * @parm int[][]
     */
    public static void printIntMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Faz clear á consola.
     */
    public static void clearConsole() {
        final String operatingSystem = System.getProperty("os.name");
        if (operatingSystem.contains("Windows")) {
            try {
                Runtime.getRuntime().exec("cls");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec("clear");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
