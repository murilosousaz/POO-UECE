package questoes;

public class Disciplina {
	
    private String codigo;
    private String nome;
    private int maxAlunos;
    private Aluno[] alunos;
    private int totalAlunos;
 
    public Disciplina(String codigo, String nome, int maxAlunos) {
        this.codigo = codigo;
        this.nome = nome;
        this.maxAlunos = maxAlunos;
        this.alunos = new Aluno[maxAlunos];
        this.totalAlunos = 0;
    }
    
    private int buscarPorMatricula(String matricula) {
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].getMatricula().equals(matricula)) return i;
        }
        return -1;
    }
    
    public void matricularAluno(Aluno a) {
        if (totalAlunos >= maxAlunos) {
            System.out.println("Turma cheia! Máximo: " + maxAlunos + " alunos.");
            return;
        }
        alunos[totalAlunos++] = a;
        System.out.println("Aluno '" + a.getNome() + "' matriculado com sucesso!");
    }

    public void atribuirNotas(String matricula, double n1, double n2) {
        int i = buscarPorMatricula(matricula);
        if (i == -1) { System.out.println("Aluno não encontrado."); return; }
        alunos[i].setNotas(n1, n2);
        System.out.println("Notas atribuídas a " + alunos[i].getNome());
    }
    
    public void alterarNotas(String matricula, double n1, double n2) {
        atribuirNotas(matricula, n1, n2); // mesma lógica
        System.out.println("Notas alteradas.");
    }
    
    public void gerarEstatisticas() {
        if (totalAlunos == 0) { System.out.println("Nenhum aluno matriculado."); return; }
 
        int aprovados = 0, reprovados = 0, semNota = 0;
        double somaMedias = 0;
        double maiorMedia = -1;
        String melhorAluno = "";
 
        for (int i = 0; i < totalAlunos; i++) {
            double m = alunos[i].calcularMedia();
            if (m < 0) { semNota++; continue; }
            somaMedias += m;
            if (m >= 7.0) aprovados++; else reprovados++;
            if (m > maiorMedia) { maiorMedia = m; melhorAluno = alunos[i].getNome(); }
        }
 
        int comNota = totalAlunos - semNota;
        System.out.println("\n===== ESTATÍSTICAS — " + nome + " =====");
        System.out.println("Total matriculados : " + totalAlunos);
        System.out.println("Com notas lançadas : " + comNota);
        System.out.println("Aprovados (>=7)    : " + aprovados);
        System.out.println("Reprovados (<7)    : " + reprovados);
        if (comNota > 0) {
            System.out.printf("Média geral da turma: %.2f%n", somaMedias / comNota);
            System.out.println("Melhor aluno       : " + melhorAluno +
                               String.format(" (%.1f)", maiorMedia));
        }
        System.out.println("=========================================\n");
    }
    
    public void listarPorOrdemAlfabetica() {
        Aluno[] copia = copiarArray();
        for (int i = 0; i < totalAlunos - 1; i++) {
            for (int j = 0; j < totalAlunos - 1 - i; j++) {
                if (copia[j].getNome().compareToIgnoreCase(copia[j+1].getNome()) > 0) {
                    Aluno tmp = copia[j]; copia[j] = copia[j+1]; copia[j+1] = tmp;
                }
            }
        }
        System.out.println("\n===== Lista Alfabética =====");
        for (int i = 0; i < totalAlunos; i++) System.out.println(copia[i]);
        System.out.println();
    }
 
    public void listarPorMediaDecrescente() {
        Aluno[] copia = copiarArray();
        for (int i = 0; i < totalAlunos - 1; i++) {
            for (int j = 0; j < totalAlunos - 1 - i; j++) {
                if (copia[j].calcularMedia() < copia[j+1].calcularMedia()) {
                    Aluno tmp = copia[j]; copia[j] = copia[j+1]; copia[j+1] = tmp;
                }
            }
        }
        System.out.println("\n===== Lista por Média (decrescente) =====");
        for (int i = 0; i < totalAlunos; i++) System.out.println(copia[i]);
        System.out.println();
    }
 
    private Aluno[] copiarArray() {
        Aluno[] copia = new Aluno[totalAlunos];
        for (int i = 0; i < totalAlunos; i++) copia[i] = alunos[i];
        return copia;
    }

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
    
}
