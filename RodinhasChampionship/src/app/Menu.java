package app;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Menu {

    /**
     * Mostra o menu e espera pela escolha do user.
     */
    public static void showMenu(String[][] participantes, String[] provas, int[][] tempos, double[][] premios) throws FileNotFoundException{

        String numSocio;
        String nome;
        String marcaCarro;
        String dataCarro;

        Scanner scanner = new Scanner(System.in);
        String date = new SimpleDateFormat("mm:ss dd/MM/yyyy").format(Calendar.getInstance().getTime());

        System.out.println("|-------------------------------------------------------");
        System.out.println("|       Rodinhas Championship | " + date + "|");
        System.out.println("|-------------------------------------------------------");
        System.out.println("| 1: Adicionar um Participante");
        System.out.println("| 2: Alterar os Dados de um Participante");
        System.out.println("| 3: Apagar um Participante");
        System.out.println("|-------------------------------------------------------");
        System.out.println("| 4: Ver Detalhes de um Participante");
        System.out.println("| 5: Ver Detalhes de uma Prova");
        System.out.println("|-------------------------------------------------------");
        System.out.println("| 6: Calcular os Prémios");
        System.out.println("|-------------------------------------------------------");
        System.out.println("| 7: Listar Participantes");
        System.out.println("| 8: Listar Provas");
        System.out.println("| 9: Listar Tempos");
        System.out.println("| 10: Listar Prémios");
        System.out.println("|-------------------------------------------------------");
        System.out.println("| 11: Carregar em Memória Todos os Ficheiros");
        System.out.println("| 12: Carregar em Memória o Ficheiro dos Participantes");
        System.out.println("| 13: Carregar em Memória o Ficheiro das Provas");
        System.out.println("| 14: Carregar em Memória os Ficheiros dos Tempos");
        System.out.println("|-------------------------------------------------------");
        System.out.println("| 15: Gravar Backup");
        System.out.println("|-------------------------------------------------------");
        System.out.println("16-teste");
        System.out.println("| 0: Sair");
        System.out.println("|-------------------------------------------------------");
        System.out.println("| Participantes carregados: " + Main.participantesCarregados);
        System.out.println("| Provas carregadas: " + Main.provasCarregadas);
        System.out.println("|-------------------------------------------------------");
        System.out.println("| Escolha uma opção para continuar...");
        System.out.println("|-------------------------------------------------------");

        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                // 1: Adicionar um Participante
                System.out.println("A adicionar novo participante...:");
                System.out.println("Número de Sócio:");
                numSocio = scanner.next();
                System.out.println("Nome:");
                nome = scanner.next();
                System.out.println("Carro:");
                marcaCarro = scanner.next();
                System.out.println("Data de Nascimento:");
                dataCarro = scanner.next();
                Main.adicionarParticipante(numSocio, nome, marcaCarro, dataCarro, participantes);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 2:
                // 2: Alterar os Dados de um Participante
                System.out.println("Qual o número de sócio do participante a alterar os dados?");
                Main.updateParticipante(scanner.next(), participantes);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 3:
                // 3: Apagar um Participante
                System.out.println("Qual o número de sócio do participante que deseja apagar?");
                Main.deleteParticipante(scanner.next(), participantes);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 4:
                // 4: Ver Detalhes de um Participante
                System.out.println("Qual o número de sócio do participante?");
                Main.verDetalhesParticipante(scanner.next(), participantes);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 5:
                // 5: Ver Detalhes de uma Prova
                Main.verDetalhesProva();
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 6:
                // 6: Calcular os Prémios
                Main.calcularPremios(participantes, provas, tempos, premios);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 7:
                // 7: Listar Participantes
                Main.showParticipantes(participantes);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 8:
                // 8: Listar Provas
                Main.showProvas(provas);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 9:
                // 9: Listar Tempos
                Main.showTempos(tempos);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 10:
                // 10: Listar Prémios
                Main.showPremios(premios);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 11:
                // 11: Carregar em Memória Todos os Ficheiros
                Main.carregarFicheiroParticipantes(participantes);
                Main.carregarFicheiroProvas(provas);
                Main.carregarFicheirosTempos(provas, participantes, tempos);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 12:
                // 12: Carregar em Memória o Ficheiro dos Participantes
                Main.carregarFicheiroParticipantes(participantes);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 13:
                // 13: Carregar em Memória o Ficheiro das Provas
                Main.carregarFicheiroProvas(provas);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 14:
                // 14: Carregar em Memória os Ficheiros dos Tempos
                Main.carregarFicheirosTempos(provas, participantes, tempos);
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 15:
                // 15: Gravar Backup
                // TODO: falta aqui
                pausarMenu();
                showMenu(participantes, provas, tempos, premios);
                break;
            case 16:
                Utils.calcularIdade("05/19/1989");
                break;
            case 0:
                break;
            default:
                showMenu(participantes, provas, tempos, premios);
        }
    }

    /**
     * Pausa o menu até existir user input.
     */
    private static void pausarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para continuar digite ENTER...");
        scanner.nextLine();
    }

}