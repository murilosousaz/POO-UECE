package questoes;

import java.util.Scanner;

public class Questao04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Valor em caixa (R$): ");
		double caixa = sc.nextDouble();
		
		System.out.println("Quantidade de produtos: ");
		int qtd = sc.nextInt();
		
		System.out.print("Preco por unidade (R$): ");
		double preco = sc.nextDouble();
		
		double totalCompra = qtd * preco;
		double limiteCaixa = caixa * 0.80;
		
		System.out.printf("%nValor total da compra: R$ %.2f%n", totalCompra);
		if(totalCompra > limiteCaixa) {
			double totalComJuros = totalCompra * 1.10;
			double parcela = totalComJuros / 3;
			System.out.println("Forma de pagamento: A PRAZO (3x)");
			System.out.printf("Total com juros (10%%): R$ %.2f%n",totalComJuros);
			System.out.printf("Valor de cada parcela: R$ %.2f%n", parcela);
		}else {
			double totalComDesconto = totalCompra * 0.95;
			System.out.println("Forma de pagamento: A VISTA");
			System.out.printf("Total com desconto (5%%): R$ %.2f%n",
					totalComDesconto);
		}
		sc.close();

	}

}
