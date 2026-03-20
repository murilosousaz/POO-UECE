package main;

import questoes.Elevador;

import java.util.Scanner;

public class MainElevador {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Quantos andares tem o prédio (excluindo térreo)? ");
        int andares = sc.nextInt();
 
        Elevador elevador = new Elevador(andares);
 
        int opcao;
        do {
            elevador.status();
            System.out.println("====== MENU DO ELEVADOR ======");
            System.out.println("1 - Entrar no elevador");
            System.out.println("2 - Sair do elevador");
            System.out.println("3 - Subir 1 andar");
            System.out.println("4 - Subir até andar específico");
            System.out.println("5 - Descer 1 andar");
            System.out.println("6 - Descer até andar específico");
            System.out.println("7 - Verificar se pode entrar");
            System.out.println("0 - Sair do programa");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
 
            switch (opcao) {
                case 1: elevador.entra(); break;
                case 2: elevador.sai();   break;
                case 3: elevador.sobe();  break;
                case 4:
                    System.out.print("Subir até qual andar? ");
                    elevador.sobe(sc.nextInt());
                    break;
                case 5: elevador.desce(); break;
                case 6:
                    System.out.print("Descer até qual andar (0 = térreo)? ");
                    elevador.desce(sc.nextInt());
                    break;
                case 7:
                    System.out.println(elevador.podeEntrar()
                        ? "Há espaço! Pode entrar."
                        : "Elevador cheio!");
                    break;
                case 0:
                    System.out.println("Encerrando simulação.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
 
        sc.close();

	}

}
