package main;

import java.util.Scanner;

import questoes.Concessionaria;
import questoes.Veiculo;

public class MainConcessionaria {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Concessionaria loja = new Concessionaria("AutoJava Motors", 20);
 
        try {
            loja.adicionarVeiculo(new Veiculo("Honda CB 500",   18000.00, 0));
            loja.adicionarVeiculo(new Veiculo("Scania R450",   350000.00, 2));
            loja.adicionarVeiculo(new Veiculo("Toyota Corolla", 120000.00, 4));
            loja.adicionarVeiculo(new Veiculo("Fiat Argo",      75000.00, 4));
            loja.adicionarVeiculo(new Veiculo("Yamaha Fazer",   15000.00, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar veículo: " + e.getMessage());
        }
 
        int opcao;
        do {
            System.out.println("\n===== MENU CONCESSIONÁRIA =====");
            System.out.println("1 - Ver estoque");
            System.out.println("2 - Realizar venda");
            System.out.println("3 - Extrato de vendas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();
 
            switch (opcao) {
                case 1: loja.mostrarEstoque();        break;
                case 2: loja.venderVeiculo(sc);       break;
                case 3: loja.gerarExtratoDeVendas();  break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();

	}

}
