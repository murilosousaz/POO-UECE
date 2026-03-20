package main;

import java.util.Scanner;

import questoes.Animal;

public class MainFazenda {
	public static void main(String[] args) {
		Scanner sc      = new Scanner(System.in);
        Animal[] lotes  = new Animal[50];
        int totalLotes  = 0;
 
        int opcao;
        do {
            System.out.println("\n===== SISTEMA DE LOTES =====");
            System.out.println("1 - Registrar lote de Galinhas");
            System.out.println("2 - Registrar lote de Patos ou Gansos");
            System.out.println("3 - Registrar lote de Vacas ou Porcos");
            System.out.println("4 - Ver todos os lotes registrados");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();
 
            try {
                switch (opcao) {
                    case 1:
                        lotes[totalLotes++] = new Animal();
                        System.out.println("Lote de galinhas registrado!");
                        break;
 
                    case 2:
                        System.out.print("Nome (Patos/Gansos): ");
                        String nomeAve = sc.nextLine();
                        lotes[totalLotes++] = new Animal(nomeAve);
                        System.out.println("Lote registrado!");
                        break;
 
                    case 3:
                        System.out.print("Nome (Vacas/Porcos): ");
                        String nomeGrande = sc.nextLine();
                        System.out.print("Peso médio por animal (Kg): ");
                        double peso = sc.nextDouble(); sc.nextLine();
                        lotes[totalLotes++] = new Animal(nomeGrande, peso);
                        System.out.println("Lote registrado!");
                        break;
 
                    case 4:
                        if (totalLotes == 0) {
                            System.out.println("Nenhum lote registrado.");
                        } else {
                            System.out.println("\n===== Todos os Lotes =====");
                            double totalFazenda = 0;
                            for (int i = 0; i < totalLotes; i++) {
                                System.out.println((i+1) + ". " + lotes[i]);
                                totalFazenda += lotes[i].getValor();
                            }
                            System.out.printf("%nPATRIMÔNIO TOTAL: R$ %,.2f%n", totalFazenda);
                        }
                        break;
 
                    case 0:
                        System.out.println("Encerrando sistema.");
                        break;
 
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
 
        } while (opcao != 0);
        sc.close();
		
	}

}
