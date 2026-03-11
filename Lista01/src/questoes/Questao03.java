package questoes;

import java.util.Scanner;
import java.util.Locale;

public class Questao03 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int[] vetor = new int[10];
		System.out.println("Digite 10 numeros inteiros: ");
		for(int i = 0; i < 10; i++) {
			System.out.print("Posicao [" + i + "]: ");
			vetor[i] = sc.nextInt();
		}
		
		System.out.println("Numeros repetidos: ");
		boolean temRepetido = false;
		for(int i = 0; i < 10; i++) {
			for(int j = i + 1; j < 10; j++) {
				if(vetor[i] == vetor[j]) {
					System.out.println("Numero repetido: " + vetor[i]);
					temRepetido = true;
				}
			}
		}
		if(!temRepetido) {
		System.out.println("Nenhum numero repetido.");
		}
		int contNeg = 0;
			for(int i = 0; i < 10; i++) {
				if(vetor[i] < 0) {
					contNeg++;
				}
		}
		
		System.out.println("Negativos: " + contNeg);
		int soma = 0;
		for(int i = 0; i < 10; i++) {
			soma += vetor[i];
		}
		
		System.out.println("Soma: " + soma);
		System.out.println("Ordem inversa: ");
		for(int i = 9; i >= 0; i--) {
			System.out.println(vetor[i] + " ");
		}
		System.out.println("Ordenado (crescente): ");
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 9; j++) {
				if(vetor[j] > vetor[j + 1]) {
					int temp = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = temp;
				}
			}
		}
			
		for(int v : vetor) {
			System.out.print(v + " ");
		}
			
			sc.close();

	}

}
