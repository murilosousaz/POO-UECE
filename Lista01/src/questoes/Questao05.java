package questoes;

import java.util.Scanner;
import java.util.Locale;

public class Questao05 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Hora de entrada (HH): ");
		int he = sc.nextInt();
		System.out.print("Minuto de entrada (MM): ");
		int me = sc.nextInt();
		System.out.print("Hora de saida (HH): ");
		int hs = sc.nextInt();
		System.out.print("Minuto de saida (MM): ");
		
		int ms = sc.nextInt();
		int entradaMin = he * 60 + me;
		int saidaMin = hs * 60 + ms;
		int totalMin = saidaMin - entradaMin;
		int horasInteiras;
		
		if(totalMin % 60 == 0) {
			horasInteiras = totalMin / 60;
		}else {
			horasInteiras = (totalMin / 60) + 1;
		}
		double pag;
		
		if(horasInteiras <= 0) {
			pag = 0;
		}else if (horasInteiras == 1){
			pag = 5.00;
		}else if(horasInteiras == 2) {
			pag = 8.00;
		}else {
			pag = 8.00 + (horasInteiras - 2) * 2.00;
		}
		
		System.out.printf("%nTempo de permanencia: %d minuto(s) = %d hora(s)cobrada(s)%n", totalMin, horasInteiras);
		System.out.printf("Valor a pagar: R$ %.2f%n", pag);
		
		sc.close();
		}

}
