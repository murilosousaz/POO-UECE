package questoes;

import java.util.Scanner;

public class Questao06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o tamanho da matriz (N): ");
		
		int n = sc.nextInt();
		int[][] matriz = new int[n][n];
		System.out.println("Digite os elementos da matriz: ");
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.println("[" + i + "] [" + j + "]: ");
				matriz[i][j] = sc.nextInt();
			}
		}
		
		int somaTotal = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				somaTotal += matriz[i][j];
			}
		}
		
		System.out.println("\na) Soma total: " + somaTotal);
		int somaDiag = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				somaDiag += matriz[i][i];
			}
		}
		
		System.out.println("b) Soma da diagonal principal: " + somaDiag);
		boolean isDiagonal = true;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j && matriz[i][j] != 0) {
					isDiagonal = false;
				}
			}
		}
		
		System.out.println("c) Matriz diagonal: " + (isDiagonal ? "SIM" : "NÃO"));
		int maior = matriz[0][0];
		int menor = matriz[0][0];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(matriz[i][j] > maior) {
					maior = matriz[i][j];
		}
				if(matriz[i][j] < menor) {
					menor = matriz[i][j];
				}
			}
		}
		System.out.println("d) Maior elemento: " + maior);
		System.out.println(" Menor elemento: " + menor);
		sc.close();

	}

}
