package questoes;

public class Aluno {
	
    private String nome;
    private String matricula;
    private double nota1;
    private double nota2;
    
    public Aluno(String nome, String matricula) {
        this.nome      = nome;
        this.matricula = matricula;
        this.nota1     = -1;
        this.nota2     = -1;
    }

    public double calcularMedia() {
        if (nota1 < 0 || nota2 < 0) return -1;
        return (nota1 + nota2) / 2.0;
    }
 
    public boolean notasAtribuidas() {
        return nota1 >= 0 && nota2 >= 0;
    }

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public double getNota1() {
		return nota1;
	}

	public double getNota2() {
		return nota2;
	}
    
	public void setNotas(double nota1, double nota2) {
        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
            System.out.println("Notas devem estar entre 0 e 10!");
            return;
        }
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
 
    public String situacao() {
        double m = calcularMedia();
        if (m < 0) return "Sem notas";
        return m >= 7.0 ? "APROVADO" : "REPROVADO";
    }
 
    @Override
    public String toString() {
        if (!notasAtribuidas()) {
            return String.format("%-20s | Mat: %s | Notas: ---  | Média: --- | %s",
                nome, matricula, situacao());
        }
        return String.format("%-20s | Mat: %s | N1: %4.1f | N2: %4.1f | Média: %4.1f | %s",
            nome, matricula, nota1, nota2, calcularMedia(), situacao());
    }
}
