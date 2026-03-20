package main;

import questoes.Calculo;

import java.util.Scanner;

public class MainCalculo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
        System.out.print("Digite o primeiro número (x): ");
        double x = sc.nextDouble();
        System.out.print("Digite o segundo número (y): ");
        double y = sc.nextDouble();
 
        Calculo calc = new Calculo(x, y);
 
        int opcao;
        do {
            System.out.println("====== MENU DE CÁLCULO ======");
            System.out.printf("Números atuais: x=%.2f | y=%.2f%n", calc.getX(), calc.getY());
            System.out.println("1 - Calcular (soma, sub, div, mult, resto)");
            System.out.println("2 - Gerar raiz");
            System.out.println("3 - Gerar potência (x^y)");
            System.out.println("4 - Alterar números");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
 
            switch (opcao) {
                case 1: calc.calcular();      break;
                case 2: calc.gerarRaiz();     break;
                case 3: calc.gerarPotencia(); break;
                case 4:
                    System.out.print("Novo x: ");
                    calc.setX(sc.nextDouble());
                    System.out.print("Novo y: ");
                    calc.setY(sc.nextDouble());
                    System.out.println("Números atualizados!");
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
