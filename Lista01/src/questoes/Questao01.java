package questoes;

import java.util.Scanner;

public class Questao01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de macas: ");
		int quantidade = sc.nextInt();
		
		double precoUnitario;
		double total;
		
		if(quantidade >= 12) {
		precoUnitario = 1.00;
		}else {
		precoUnitario = 1.30;
		}
		
		total = quantidade * precoUnitario;
		
		System.out.printf("Preco Unitario: R$ %.2f%n", precoUnitario);
		System.out.printf("Custo total: R$ %.2f%n", total);
		
		sc.close();

	}

}
