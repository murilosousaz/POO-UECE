package main;

import questoes.Aniversario;

import java.util.Scanner;

public class MainAniversario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Aniversario agenda = new Aniversario();

        int opcao;

        do {
            System.out.println("========= MENU =========");
            System.out.println("1 - Adicionar amigo");
            System.out.println("2 - Atualizar amigo");
            System.out.println("3 - Remover amigo");
            System.out.println("4 - Mostrar lista");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do amigo: ");
                    String nome = sc.nextLine();
                    System.out.print("Data de aniversário (dd/mm): ");
                    String data = sc.nextLine();
                    agenda.adicionarAmigo(nome, data);
                    break;

                case 2:
                    System.out.print("Nome atual do amigo: ");
                    String nomeAtual = sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Nova data (dd/mm): ");
                    String novaData = sc.nextLine();
                    agenda.atualizarAmigo(nomeAtual, novoNome, novaData);
                    break;

                case 3:
                    System.out.print("Nome do amigo a remover: ");
                    String nomeRemover = sc.nextLine();
                    agenda.removerAmigo(nomeRemover);
                    break;

                case 4:
                    agenda.mostrarLista();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}