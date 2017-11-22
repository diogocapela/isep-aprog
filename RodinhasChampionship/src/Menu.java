import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Menu {

    /**
     * Mostra o menu inicial.
     */
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String date = new SimpleDateFormat("mm:ss dd/MM/yyyy").format(Calendar.getInstance().getTime());
        System.out.println("----------------------------------------------------");
        System.out.println("      Rodinhas Championship | " + date);
        System.out.println("----------------------------------------------------");
        System.out.println("1: Adicionar um Participante");
        System.out.println("2: Alterar os Dados de um Participante");
        System.out.println("3: Apagar um Participante");
        System.out.println("----------------------------------------------------");
        System.out.println("4: Ver Detalhes de um Participante");
        System.out.println("5: Ver Detalhes de uma Prova");
        System.out.println("6: Calcular os Tempos");
        System.out.println("7: Calcular os Prémios");
        System.out.println("----------------------------------------------------");
        System.out.println("8: Listar Participantes");
        System.out.println("9: Listar Provas");
        System.out.println("10: Listar Tempos");
        System.out.println("11: Listar Prémios");
        System.out.println("----------------------------------------------------");
        System.out.println("12: Carregar em Memória tudos os ficheiros.");
        System.out.println("13: Carregar em Memória o Ficheiro Backup.txt");
        System.out.println("14: Carregar em Memória o Ficheiro Participantes.txt");
        System.out.println("15: Carregar em Memória o Ficheiro Provas.txt");
        System.out.println("----------------------------------------------------");
        System.out.println("16: Print Error Log");
        System.out.println("17: Gravar Backup");
        System.out.println("----------------------------------------------------");
        System.out.println("0: Sair");
        System.out.println("----------------------------------------------------");
        System.out.println("Escolha uma opção para continuar...");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                String[] participanteData = new String[Main.PARTICIPANTES_CAMPOS];
                System.out.println("A adicionar novo participante...:");
                System.out.println("Número de Sócio:");
                participanteData[0] = scanner.nextLine();
                System.out.println("Nome:");
                participanteData[1] = scanner.nextLine();
                System.out.println("Carro:");
                participanteData[2] = scanner.nextLine();
                System.out.println("Data de Nascimento:");
                participanteData[3] = scanner.nextLine();
                Main.adicionarParticipante(participanteData);
                break;
            case 2:
                System.out.println("Qual o número de sócio do participante a alterar os dados?");
                String numSocio = scanner.nextLine();
                Main.updateParticipante(numSocio);
                break;
            case 3:
                Main.deleteParticipante();
                break;
            case 4:
                Main.verDetalhesParticipante();
                break;
            case 5:
                Main.verDetalhesProva();
                break;
            case 6:
                Main.calcularTempos();
                break;
            case 7:
                Main.calcularPremios();
                break;
            case 8:
                Main.showParticipantes();
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                Main.carregarFileParticipantes();
                break;
            case 15:
                Main.carregarFromFileProvas();
                break;
            case 16:
                break;
            case 17:
                break;
            case 0:
                break;
            default:
                showMenu();
        }
    }
}
