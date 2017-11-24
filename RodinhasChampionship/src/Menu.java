import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Menu {

    public static String numSocio;
    public static String nome;
    public static String marcaCarro;
    public static String dataCarro;

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
                System.out.println("A adicionar novo participante...:");
                System.out.println("Número de Sócio:");
                numSocio = scanner.next();
                System.out.println("Nome:");
                nome = scanner.next();
                System.out.println("Carro:");
                marcaCarro = scanner.next();
                System.out.println("Data de Nascimento:");
                dataCarro = scanner.next();
                Main.adicionarParticipante(numSocio, nome, marcaCarro, dataCarro);
                pausarMenu();
                showMenu();
                break;
            case 2:
                System.out.println("Qual o número de sócio do participante a alterar os dados?");
                Main.updateParticipante(scanner.next());
                pausarMenu();
                showMenu();
                break;
            case 3:
                System.out.println("Qual o número de sócio do participante que deseja apagar?");
                Main.deleteParticipante(scanner.next());
                pausarMenu();
                showMenu();
                break;
            case 4:
                System.out.println("Qual o número de sócio do participante?");
                Main.verDetalhesParticipante(scanner.next());
                pausarMenu();
                showMenu();
                break;
            case 5:
                Main.verDetalhesProva();
                pausarMenu();
                showMenu();
                break;
            case 6:
                Main.calcularTempos();
                pausarMenu();
                showMenu();
                break;
            case 7:
                Main.calcularPremios();
                pausarMenu();
                showMenu();
                break;
            case 8:
                Main.showParticipantes();
                pausarMenu();
                showMenu();
                break;
            case 9:
                pausarMenu();
                showMenu();
                break;
            case 10:
                pausarMenu();
                showMenu();
                break;
            case 11:
                pausarMenu();
                showMenu();
                break;
            case 12:
                pausarMenu();
                showMenu();
                break;
            case 13:
                pausarMenu();
                showMenu();
                break;
            case 14:
                Main.carregarFileParticipantes();
                pausarMenu();
                showMenu();
                break;
            case 15:
                Main.carregarFromFileProvas();
                pausarMenu();
                showMenu();
                break;
            case 16:
                pausarMenu();
                showMenu();
                break;
            case 17:
                pausarMenu();
                showMenu();
                break;
            case 0:
                break;
            default:
                showMenu();
        }
    }

    private static void pausarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para continuar digite ENTER...");
        scanner.nextLine();
    }

}