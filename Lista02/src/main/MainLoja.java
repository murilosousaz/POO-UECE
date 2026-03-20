package main;

import questoes.Loja;
import questoes.Produto;

import java.util.Scanner;

public class MainLoja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Loja loja = new Loja("JavaStore", 20);

        loja.adicionarProduto(new Produto("Teclado",   "Mecânico RGB",       250.00));
        loja.adicionarProduto(new Produto("Mouse",     "Sem fio ergonômico",  120.00));
        loja.adicionarProduto(new Produto("Monitor",   "24\" Full HD",        900.00));
        loja.adicionarProduto(new Produto("Headset",   "7.1 Surround",        180.00));
        loja.adicionarProduto(new Produto("Mousepad",  "Gamer XL",             45.00));

        int opcao;
        do {
            System.out.println("======= MENU DA LOJA =======");
            System.out.println("1 - Ver catálogo");
            System.out.println("2 - Adicionar ao carrinho");
            System.out.println("3 - Ver carrinho");
            System.out.println("4 - Gerar nota fiscal");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    loja.mostrarCatalogo();
                    break;
                case 2:
                    loja.mostrarCatalogo();
                    System.out.print("Número do produto: ");
                    int num = sc.nextInt() - 1; // converte para índice base 0
                    loja.adicionarAoCarrinho(num);
                    break;
                case 3:
                    loja.mostrarCarrinho();
                    break;
                case 4:
                    loja.gerarNotaFiscal();
                    break;
                case 0:
                    System.out.println("Obrigado pela visita!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}