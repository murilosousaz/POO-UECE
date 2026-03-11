package questoes;

import java.util.Scanner;

public class Questao02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o lado A: ");
		double a = sc.nextDouble();
		System.out.println("Digite o lado B: ");
		double b = sc.nextDouble();
		System.out.println("Digite o lado C: ");
		double c = sc.nextDouble();
		
		if(a < b + c && b < a + c && c < a + b) {
		System.out.println("Eh um triangulo");
		
		if(a == b && b == c) {
		System.out.println("Tipo: Equilatero(tres lados iguais)");
		}else if(a == b || b == c || a == c) {
		System.out.println("Tipo: Isosceles (dois lados iguais)");
		}else {
		System.out.println("Tipo: Escaleno(todos os lados diferentes)");
		}
		}else {
		System.out.println("Nao eh triangulo");
		}
		
		sc.close();

	}

}
