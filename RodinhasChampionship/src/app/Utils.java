package app;

import java.util.Calendar;

public class Utils {

    /**
     * Calcula a idade através da data de nascimento.
     */
    public static int calcularIdade(String date) {
        String[] data = date.trim().split("/");
        int carDia = Integer.parseInt(data[0]);
        int carMes = Integer.parseInt(data[1]);
        int carAno = Integer.parseInt(data[2]);
        Calendar currentDate = Calendar.getInstance();
        int nowDia = currentDate.get(Calendar.DAY_OF_MONTH);
        int nowMes = currentDate.get(Calendar.MONTH) + 1;
        int nowAno = currentDate.get(Calendar.YEAR);
        int resultado = 0;
        resultado = nowAno - carAno;
        if(nowMes > carMes) {
            resultado++;
        } else if (nowMes == carMes) {
            if(nowDia >= carDia) {
                resultado++;
            }
        }
        return resultado;
    }

    /**
     * Verifica se existe um sócio repetido em memória.
     *
     * @return boolean
     * @parm int numSocio
     */
    public static boolean verificarSeParticipanteJaExiste(String numSocio, String[][] participantes) {
        boolean jaExiste = false;
        for (int i = 0; i < participantes.length; i++) {
            if (numSocio.equalsIgnoreCase(participantes[i][0])) {
                jaExiste = true;
            }
        }
        return jaExiste;
    }

    /**
     * Verifica a posição em memória de um participante existente.
     *
     * @return int position
     * @parm String numSocio
     */
    public static int getParticipantPositionByNumber(String numSocio, String[][] participantes) {
        int position = -1;
        boolean repetido = verificarSeParticipanteJaExiste(numSocio, participantes);
        if (repetido) {
            for (int i = 0; i < participantes.length; i++) {
                if (numSocio.equals(participantes[i][0])) {
                    position = i;
                }
            }
        }
        return position;
    }

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
     * Faz print a um vector de doubles.
     *
     * @parm double[]
     */
    public static void printDoubleVector(double[] vector) {
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
     * Faz print a uma matriz de doubles.
     *
     * @parm double[][]
     */
    public static void printDoubleMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}