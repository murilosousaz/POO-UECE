package main;

import java.util.Scanner;

import questoes.Aluno;
import questoes.Disciplina;

public class MainDisciplina {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Disciplina disc = new Disciplina("POO001", "Prog. Orientada a Objetos", 30);
 
        disc.matricularAluno(new Aluno("Alice Mendes","2024001"));
        disc.matricularAluno(new Aluno("Bruno Costa", "2024002"));
        disc.matricularAluno(new Aluno("Carla Dias", "2024003"));
        disc.matricularAluno(new Aluno("Daniel Faria", "2024004"));
        disc.matricularAluno(new Aluno("Eduarda Ramos","2024005"));
 
        int opcao;
        do {
            System.out.println("\n===== MENU PROFESSOR — " + disc.getNome() + " =====");
            System.out.println("1 - Matricular aluno");
            System.out.println("2 - Atribuir notas");
            System.out.println("3 - Alterar notas");
            System.out.println("4 - Estatísticas da turma");
            System.out.println("5 - Lista alfabética");
            System.out.println("6 - Lista por média (decrescente)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();
 
            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");String nome = sc.nextLine();
                    System.out.print("Matrícula: ");String mat  = sc.nextLine();
                    disc.matricularAluno(new Aluno(nome, mat));
                    break;
                case 2:
                case 3:
                    System.out.print("Matrícula do aluno: "); String m = sc.nextLine();
                    System.out.print("Nota 1 (0-10): "); double n1 = sc.nextDouble();
                    System.out.print("Nota 2 (0-10): "); double n2 = sc.nextDouble(); sc.nextLine();
                    if (opcao == 2) disc.atribuirNotas(m, n1, n2);
                    else disc.alterarNotas(m, n1, n2);
                    break;
                case 4: disc.gerarEstatisticas(); break;
                case 5: disc.listarPorOrdemAlfabetica(); break;
                case 6: disc.listarPorMediaDecrescente(); break;
                case 0: System.out.println("Encerrando."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();

	}

}
