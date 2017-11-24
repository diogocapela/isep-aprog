import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    /**
     * Constantes
     * 5 Provas, 2 Campos (nome, distancia)
     * 20 Participantes, 4 Campos (id, nome, marcaCarro, dataCarro)
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

    // TODO: Todos os sócios que alguma vez estiveram inscritos (para n dar conflito com os tempos e prémios)
    public static String[][] socios;

    public static String[][] participantes = new String[PARTICIPANTES_MAX][PARTICIPANTES_CAMPOS];
    public static String[][] provas = new String[PROVAS_MAX][PROVAS_CAMPOS];

    public int provaActual = 0;


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
     * Adicionar um novo participante em memória.
     */
    public static void adicionarParticipante(String numSocio, String nome, String marcaCarro, String dataCarro) {
        boolean repetido = verificarSeParticipanteJaExiste(numSocio);
        if(repetido) {
            System.out.println("ERRO: Um participante com o mesmo número de sócio já se encontra em memória.");
        } else if (participantesCarregados >= PARTICIPANTES_MAX) {
            System.out.println("ERRO: O número máximo de participantes foi atingido.");
        } else {
            participantes[participantesCarregados][0] = numSocio;
            participantes[participantesCarregados][1] = nome;
            participantes[participantesCarregados][2] = marcaCarro;
            participantes[participantesCarregados][3] = dataCarro;
            participantesCarregados++;
            System.out.println("O participante " + nome + " foi carregado em memória com sucesso.");
        }
    }

    /**
     * Apagar os dados de um participante em memória.
     */
    public static void deleteParticipante(String numSocio) {
        boolean repetido = verificarSeParticipanteJaExiste(numSocio);
        int participanteArrayPosition = getParticipantPositionByNumber(numSocio);
        if (repetido) {
            for (int i = participanteArrayPosition; i < PARTICIPANTES_MAX - 1; i++) {
                participantes[i] = participantes[i + 1];
            }
            for (int i = 0; i < PARTICIPANTES_CAMPOS; i++) {
                // TODO: Como apagar???
                participantes[PARTICIPANTES_MAX - 1][i] = null;
            }
            participantesCarregados--;
            System.out.println("O participante com o número de sócio " + numSocio + " foi apagado com sucesso.");
        } else {
            System.out.println("O participante com o número de sócio " + numSocio + " não existe em memória.");
        }
    }

    /**
     * Alterar os dados de um participante específico em memória.
     */
    public static void updateParticipante(String numSocio) {
        boolean repetido = verificarSeParticipanteJaExiste(numSocio);
        if (repetido) {
            Scanner scanner = new Scanner(System.in);
            String[] inputData = new String[PARTICIPANTES_CAMPOS];
            System.out.println("A alterar os dados do sócio número " + numSocio + "...:");
            inputData[0] = numSocio;
            System.out.println("Nome:");
            inputData[1] = scanner.next();
            System.out.println("Carro:");
            inputData[2] = scanner.next();
            System.out.println("Data de Nascimento:");
            inputData[3] = scanner.next();
            int participantePosition = getParticipantPositionByNumber(numSocio);
            for (int i = 0; i < PARTICIPANTES_CAMPOS; i++) {
                participantes[participantePosition][i] = inputData[i];
            }
            System.out.println("O os dados do sócio número " + numSocio + " foram alterados com sucesso.");
        } else {
            System.out.println("O participante com o número de sócio " + numSocio + " não existe em memória.");
        }
    }

    /**
     * Ver detalhes de um participante em memória.
     */
    public static void verDetalhesParticipante(String numSocio) {
        boolean repetido = verificarSeParticipanteJaExiste(numSocio);
        int participantePosition = getParticipantPositionByNumber(numSocio);
        if (repetido) {
            System.out.println("A listar detalhes do sócio com o número " + numSocio + ":");
            for(int i = 0; i < PARTICIPANTES_CAMPOS; i++) {
                System.out.println(participantes[participantePosition][i]);
            }
        } else {
            System.out.println("O participante com o número de sócio " + numSocio + " não existe em memória.");
        }
    }

    /**
     * Lista todos os participantes em memória.
     */
    public static void showParticipantes() {

        for (int i = 0; i < participantesCarregados; i++) {
            for (int j = 0; j < PARTICIPANTES_CAMPOS; j++) {
                if (j == 0) {
                    System.out.printf("%30s", participantes[i][j]);
                } else if (j == 1) {
                    System.out.printf("%10s", participantes[i][j]);
                } else {
                    System.out.printf("%50s", participantes[i][j]);
                }
            }
            System.out.println();
        }
    }

    /**
     * Ver detalhes de uma prova em memória.
     */
    public static void verDetalhesProva() {

    }

    /**
     * Calcula a idade do carro.
     */
    public static void calcularIdadeCarro() {


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
     * @parm int numSocio
     */
    public static boolean verificarSeParticipanteJaExiste(String numSocio) {
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
    public static int getParticipantPositionByNumber(String numSocio) {
        int position = -1;
        boolean repetido = verificarSeParticipanteJaExiste(numSocio);
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
     * Carrega o ficheiro com a info dos participantes em memória.
     */
    public static void carregarFileParticipantes() {
        try {
            Scanner file = new Scanner(new File("./src/database/Participantes.txt"));
            while (file.hasNextLine() && participantesCarregados < PARTICIPANTES_MAX) {
                String[] lineData = file.nextLine().split(";");
                boolean repetido = verificarSeParticipanteJaExiste(lineData[0].trim());
                if (!repetido) {
                    for (int i = 0; i < PARTICIPANTES_CAMPOS; i++) {
                        participantes[participantesCarregados][i] = lineData[i].trim();
                    }
                    participantesCarregados++;
                }
            }
            file.close();
            System.out.println("O ficheiro Participantes.txt foi carregado em memória com sucesso.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega o ficheiro com a info das provas em memória.
     */
    public static void carregarFromFileProvas() {
        try {
            Scanner file = new Scanner(new File("./src/database/Provas.txt"));
            while (file.hasNextLine() && provasCarregadas < PROVAS_MAX) {
                String[] lineData = file.nextLine().split(";");
                for (int i = 0; i < PROVAS_CAMPOS; i++) {
                    provas[provasCarregadas][i] = lineData[i].trim();
                }
                provasCarregadas++;
            }
            file.close();
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