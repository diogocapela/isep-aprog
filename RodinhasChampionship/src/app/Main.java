package app;


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    // 20 Participantes c/ 4 Campos (id, nome, marcaCarro, dataCarro)
    // 5 Provas
    public static final int PARTICIPANTES_MAX = 20;
    public static final int PARTICIPANTES_CAMPOS = 4;
    public static final int PROVAS_MAX = 5;

    public static int participantesCarregados = 0;
    public static int provasCarregadas = 0;

    public static void main(String[] args) throws FileNotFoundException {

        // Estrutura de Dados
        String[][] participantes = new String[PARTICIPANTES_MAX][PARTICIPANTES_CAMPOS];
        String[] provas = new String[PROVAS_MAX];
        int[][] tempos = new int[PARTICIPANTES_MAX][PROVAS_MAX];
        double[][] premios = new double[PARTICIPANTES_MAX][PROVAS_MAX];

        Menu.showMenu(participantes, provas, tempos, premios);

    }

    /**
     * 1. Adicionar um novo participante em memória.
     */
    public static void adicionarParticipante(String numSocio, String nome, String marcaCarro, String dataCarro, String[][] participantes) {
        boolean repetido = Utils.verificarSeParticipanteJaExiste(numSocio, participantes);
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
     * 2. Alterar os dados de um participante específico em memória.
     */
    public static void updateParticipante(String numSocio, String[][] participantes) {
        boolean repetido = Utils.verificarSeParticipanteJaExiste(numSocio, participantes);
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
            int participantePosition = Utils.getParticipantPositionByNumber(numSocio, participantes);
            for (int i = 0; i < PARTICIPANTES_CAMPOS; i++) {
                participantes[participantePosition][i] = inputData[i];
            }
            System.out.println("O os dados do sócio número " + numSocio + " foram alterados com sucesso.");
        } else {
            System.out.println("O participante com o número de sócio " + numSocio + " não existe em memória.");
        }
    }

    /**
     * 3. Apagar os dados de um participante em memória.
     */
    public static void deleteParticipante(String numSocio, String[][] participantes) {
        boolean repetido = Utils.verificarSeParticipanteJaExiste(numSocio, participantes);
        int participanteArrayPosition = Utils.getParticipantPositionByNumber(numSocio, participantes);
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
     * 4. Ver detalhes de um participante em memória.
     */
    public static void verDetalhesParticipante(String numSocio, String[][] participantes) {
        boolean repetido = Utils.verificarSeParticipanteJaExiste(numSocio, participantes);
        int participantePosition = Utils.getParticipantPositionByNumber(numSocio, participantes);
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
     * 5. Ver detalhes de uma prova em memória.
     */
    public static void verDetalhesProva() {

    }

    /**
     * 6. Fáz o cálculo dos premios com os dados carregados em memória.
     */
    public static void calcularPremios(String[][] participantes, String[] provas, int[][] tempos, double[][] premios) {
        for(int i = 0; i < participantesCarregados; i++) {
            int idadeAutomovel = Utils.calcularIdade(participantes[i][3]);
            for(int k = 0; k < PROVAS_MAX; k++) {
                String kmDaProvaString = provas[k].split(":")[1].trim();
                int kmDaProva = Integer.parseInt(kmDaProvaString.substring(0, kmDaProvaString.length() - 2));
                int tempoNaProva = tempos[i][k];
                if(tempoNaProva > 0) {
                    premios[i][k] = (idadeAutomovel / 20) * kmDaProva * 2;
                }
            }
        }
    }

    /**
     * 7. Lista todos os participantes em memória.
     */
    public static void showParticipantes(String[][] participantes) {

        for (int p = 0; p < participantesCarregados; p++) {
            for (int c = 0; c < PARTICIPANTES_CAMPOS; c++) {
                if (c == 0) {
                    System.out.printf("%-5s", participantes[p][c]);
                } else if (c == 1) {
                    System.out.printf("%-25s", participantes[p][c]);
                } else if (c == 2) {
                    System.out.printf("%-15s", participantes[p][c]);
                } else {
                    System.out.printf("%-15s", participantes[p][c]);
                }

            }
            System.out.println();
        }
    }

    /**
     * 8. Lista todas as provas em memória.
     */
    public static void showProvas(String[] provas) {
        Utils.printStringVector(provas);
    }

    /**
     * 9. Lista todos os tempos em memória.
     */
    public static void showTempos(int[][] tempos) {
        Utils.printIntMatrix(tempos);
    }

    /**
     * 10. Lista todos os prémios em memória.
     */
    public static void showPremios(double[][] premios) {
        Utils.printDoubleMatrix(premios);
    }

    /**
     * 12. Carrega o ficheiro com a info dos participantes em memória.
     */
    public static void carregarFicheiroParticipantes(String[][] participantes) throws FileNotFoundException {
        Scanner scannerFile = new Scanner(new File("./src/database/Participantes.txt"));
        while (scannerFile.hasNextLine() && participantesCarregados < PARTICIPANTES_MAX) {
            String[] lineData = scannerFile.nextLine().split(";");
            boolean repetido = Utils.verificarSeParticipanteJaExiste(lineData[0].trim(), participantes);
            if (!repetido) {
                for (int i = 0; i < PARTICIPANTES_CAMPOS; i++) {
                    participantes[participantesCarregados][i] = lineData[i].trim();
                }
                participantesCarregados++;
            }
        }
        scannerFile.close();
        System.out.println("O ficheiro ./src/database/Participantes.txt foi carregado em memória com sucesso.");
    }

    /**
     * 13. Carrega o ficheiro com a info das provas em memória.
     */
    public static void carregarFicheiroProvas(String[] provas) throws FileNotFoundException {
        Scanner scannerFile = new Scanner(new File("./src/database/Provas.txt"));
        while (scannerFile.hasNextLine() && provasCarregadas < PROVAS_MAX) {
            String[] data = scannerFile.nextLine().split(";");
            for (int i = 0; i < PROVAS_MAX; i++) {
                provas[provasCarregadas] = data[i].trim();
                provasCarregadas++;
            }
        }
        scannerFile.close();
        System.out.println("O ficheiro ./src/database/Provas.txt foi carregado em memória com sucesso.");
    }

    /**
     * 14. Carrega os ficheiros com a info dos tempos em memória.
     */
    public static void carregarFicheirosTempos(String[] provas, String[][] participantes, int[][] tempos) throws FileNotFoundException {
        String[] nomesDasProvasFormatted = new String[PROVAS_MAX];
        for (int i = 0; i < PROVAS_MAX; i++) {
            String[] dadosDaProva = provas[i].split(":");
            nomesDasProvasFormatted[i] = dadosDaProva[0].trim().toLowerCase().replaceAll(" ", "-");
        }
        for (int i = 0; i < PROVAS_MAX; i++) {
            int contadorParticipantes = 0;
            Scanner scannerFile = new Scanner(new File("./src/database/tempos/" + nomesDasProvasFormatted[i] + ".txt"));
            while (scannerFile.hasNextLine() && contadorParticipantes < PARTICIPANTES_MAX) {
                String[] data = scannerFile.nextLine().split("/");
                String numSocio = data[0].trim();
                String tempo = data[1].trim();
                if (!participantes[contadorParticipantes][0].equals(numSocio)) {
                    String[] infoTempo = tempo.split(":");
                    int tempoSegundos = Integer.parseInt(infoTempo[0]) * 60 + Integer.parseInt(infoTempo[1]);
                    tempos[contadorParticipantes][i] = tempoSegundos;
                    contadorParticipantes++;
                }
            }
            scannerFile.close();
            System.out.println("O ficheiro ./src/database/tempos/" + nomesDasProvasFormatted[i] + ".txt foi carregado em memória com sucesso.");
        }
    }

    /**
     * 15. Gravar backup.
     */
    public static void saveBackup() {


    }

}