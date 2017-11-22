import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    /**
     * Constantes
     * 5 Provas, 2 Campos (nome, distancia)
     * 20 Participantes, 4 Campos (id, nome, carro, dataNascimento)
     */
    public static final int PROVAS_MAX = 5;
    public static final int PROVAS_CAMPOS = 2;

    public static final int PARTICIPANTES_MAX = 20;
    public static final int PARTICIPANTES_CAMPOS = 4;

    /**
     * Estrutura de Dados e Variáveis Globais
     */
    public static int participantesCarregados = 0;
    public static int provasCarregadas = 0;

    public static String[][] provas = new String[PROVAS_MAX][PROVAS_CAMPOS];
    public static String[][] participantes = new String[PARTICIPANTES_MAX][PARTICIPANTES_CAMPOS];

    public static int[][] temposProvas = new int[PROVAS_MAX][PROVAS_CAMPOS];
    public static double[][] premiosProvas = new double[PROVAS_MAX][PROVAS_CAMPOS];

    public static boolean isSaved = true;

    /**
     * Main
     */
    public static void main(String[] args) {
        Menu.showMenu();
    }

    /**
     * Adicionar um novo participante.
     */
    public static void adicionarParticipante(String[] inputData) {
        boolean repetido = verificarParticipanteRepetido(inputData[0].trim());
        if (!repetido) {
            for (int i = 0; i < PARTICIPANTES_CAMPOS; i++) {
                participantes[participantesCarregados][0] = inputData[i].trim();
            }
            participantesCarregados++;
            System.out.println("O participante " + inputData[1] + " foi carregado em memória com sucesso.");
        } else {
            System.out.println("ERRO: Um participante com o mesmo número de sócio já se encontra em memória.");
        }
    }

    /**
     * Alterar dados de um participante específico.
     */
    public static void updateParticipante(String numSocio) {
        Scanner scanner = new Scanner(System.in);
        String[] inputData = new String[PARTICIPANTES_CAMPOS];
        System.out.println("A alterar os dados do sócio número " + numSocio + "...:");
        System.out.println("Nome:");
        inputData[1] = scanner.nextLine();
        System.out.println("Carro:");
        inputData[2] = scanner.nextLine();
        System.out.println("Data de Nascimento:");
        inputData[3] = scanner.nextLine();

        // TODO: Falta acabar

    }

    /**
     * Apagar todos os dados de um participante.
     */
    public static void deleteParticipante() {

    }

    /**
     * Ver detalhes de um participante.
     */
    public static void verDetalhesParticipante() {

    }

    /**
     * Ver detalhes de uma prova.
     */
    public static void verDetalhesProva() {

    }

    /**
     * Lista todos os participantes em memória.
     */
    public static void showParticipantes() {
        Utils.printStringMatrix(participantes);
    }

    /**
     * Fáz o cálculo dos premios com os dados carregados em memória.
     */
    public static void calcularPremios() {

    }

    /**
     * Fáz o cálculo dos tempos com os dados carregados em memória.
     */
    public static void calcularTempos() {

    }

    /**
     * Lista todas as provas em memória.
     */
    public static void showProvas() {
        Utils.printStringMatrix(provas);
    }

    /**
     * Lista todos os tempos em memória.
     */
    public static void showTempos() {
        Utils.printIntMatrix(temposProvas);
    }

    /**
     * Lista todos os prémios em memória.
     */
    public static void showPremios() {

    }


    /**
     * Verifica se existe um sócio repetido em memória.
     *
     * @return boolean
     * @parm numSocio
     */
    public static boolean verificarParticipanteRepetido(String numSocio) {
        boolean repetido = false;
        for (int i = 0; i < participantes.length; i++) {
            if (numSocio.equals(participantes[i][0])) {
                repetido = true;
            }
        }
        return repetido;
    }

    /**
     * Carrega o ficheiro com a info dos participantes em memória.
     */
    public static void carregarFileParticipantes() {
        File file = new File("./src/database/Participantes.txt");
        try {
            Scanner scannerFile = new Scanner(file);
            while (scannerFile.hasNextLine() && participantesCarregados < PARTICIPANTES_MAX) {
                String[] lineData = scannerFile.nextLine().split(";");
                boolean repetido = verificarParticipanteRepetido(lineData[0].trim());
                if (!repetido) {
                    for (int i = 0; i < PARTICIPANTES_CAMPOS; i++) {
                        participantes[participantesCarregados][i] = lineData[i].trim();
                    }
                    participantesCarregados++;
                }
            }
            scannerFile.close();
            System.out.println("O ficheiro Participantes.txt foi carregado em memória com sucesso.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega o ficheiro com a info das provas em memória.
     */
    public static void carregarFromFileProvas() {
        File file = new File("./src/database/Provas.txt");
        try {
            Scanner scannerFile = new Scanner(file);
            while (scannerFile.hasNextLine() && provasCarregadas < PROVAS_MAX) {
                String[] lineData = scannerFile.nextLine().split(";");
                for (int i = 0; i < PROVAS_CAMPOS; i++) {
                    provas[provasCarregadas][i] = lineData[i].trim();
                }
                provasCarregadas++;
            }
            scannerFile.close();
            System.out.println("O ficheiro Provas.txt foi carregado em memória com sucesso.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega o ficheiro com a info dos tempos em memória.
     */
    public static void carregarFileTempos() {


    }

    /**
     * Escreve o que está em memória para o ficheiro dos participantes.
     */
    public static void writeToFileParticipantes() {


    }

    /**
     * Escreve o que está em memória para o ficheiro das provas.
     */
    public static void writeToFileProvas() {


    }

    /**
     * Escreve o que está em memória para o ficheiro dos tempos.
     */
    public static void writeToFileTempos() {


    }


}
