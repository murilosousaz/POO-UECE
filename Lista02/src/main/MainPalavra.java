package main;

import questoes.Palavra;

import java.util.Scanner;

public class MainPalavra {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Digite uma palavra: ");
        String entrada = sc.nextLine();
        Palavra pw = new Palavra(entrada);
 
        int opcao;
        do {
            System.out.println("\n====== MENU PALAVRA ======");
            System.out.println(pw);
            System.out.println("1 - Inverter palavra");
            System.out.println("2 - Quantidade de vogais");
            System.out.println("3 - Concatenar palavra");
            System.out.println("4 - Verificar igualdade");
            System.out.println("5 - Alterar palavra");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
 
            switch (opcao) {
                case 1:
                    System.out.println("Invertida: " + pw.inverterPalavra());
                    break;
                case 2:
                    System.out.println("Vogais: " + pw.quantVogais());
                    break;
                case 3:
                    System.out.print("Palavra a concatenar: ");
                    pw.concatenarPalavra(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Palavra para comparar: ");
                    String comp = sc.nextLine();
                    boolean igual = pw.verificarPalavra(comp);
                    System.out.println(igual ? "São IGUAIS!" : "São DIFERENTES.");
                    break;
                case 5:
                    System.out.print("Nova palavra: ");
                    pw.setPalavra(sc.nextLine());
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
