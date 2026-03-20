package main;

import java.util.Scanner;

import questoes.*;

public class MainEmpresa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa("TechSoluções LTDA", 50);

        empresa.registrarNovoFuncionario("Ana Lima", "Analista");
        empresa.registrarFuncionarioTransferido("Carlos Souza", "Gerente", 8500.00);
        empresa.registrarNovoFuncionario("Maria Silva", "Desenvolvedora");

        int opcao;
        do {
            System.out.println("\n======= MENU RH =======");
            System.out.println("1 - Registrar novo funcionário (salário mínimo)");
            System.out.println("2 - Registrar funcionário transferido (com salário)");
            System.out.println("3 - Dar aumento");
            System.out.println("4 - Demitir funcionário");
            System.out.println("5 - Promover funcionário");
            System.out.println("6 - Listar funcionários");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: "); String n1 = sc.nextLine();
                    System.out.print("Cargo: "); String c1 = sc.nextLine();
                    empresa.registrarNovoFuncionario(n1, c1);
                    break;
                case 2:
                    System.out.print("Nome: ");   String n2 = sc.nextLine();
                    System.out.print("Cargo: ");  String c2 = sc.nextLine();
                    System.out.print("Salário: R$ "); double s2 = sc.nextDouble(); sc.nextLine();
                    empresa.registrarFuncionarioTransferido(n2, c2, s2);
                    break;
                case 3:
                    empresa.mostrarListaDeFuncionarios();
                    System.out.print("Nome do funcionário: "); String n3 = sc.nextLine();
                    System.out.print("Percentual de aumento (%): "); double p3 = sc.nextDouble(); sc.nextLine();
                    empresa.darAumento(n3, p3);
                    break;
                case 4:
                    empresa.mostrarListaDeFuncionarios();
                    System.out.print("Nome do funcionário a demitir: "); String n4 = sc.nextLine();
                    empresa.demitirFuncionario(n4);
                    break;
                case 5:
                    empresa.mostrarListaDeFuncionarios();
                    System.out.print("Nome do funcionário: ");   String n5 = sc.nextLine();
                    System.out.print("Novo cargo: ");            String c5 = sc.nextLine();
                    System.out.print("Aumento de promoção (%): "); double p5 = sc.nextDouble(); sc.nextLine();
                    empresa.promoverFuncionario(n5, c5, p5);
                    break;
                case 6:
                    empresa.mostrarListaDeFuncionarios();
                    break;
                case 0:
                    System.out.println("Encerrando sistema RH.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    }
}