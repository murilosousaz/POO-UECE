package questoes;

public class Elevador {
	
	private int andarAtual;
	private int totalAndares;
	private int capacidade;
	private int pessoasDentro;
	
	public Elevador(int andarAtual, int totalAndares, int capacidade, int pessoasDentro) {
		this.andarAtual = 0;
		this.totalAndares = totalAndares;
		this.capacidade = 5;
		this.pessoasDentro = 0;
	}

	public Elevador(int totalAndares, int capacidade) {
		this.totalAndares = totalAndares;
		this.capacidade = capacidade;
	}
	
	public void entra() {
        if (podeEntrar()) {
            pessoasDentro++;
            System.out.println("Pessoa entrou. Ocupação: " + pessoasDentro + "/" + capacidade);
        } else {
            System.out.println("Elevador CHEIO! Não é possível entrar.");
        }
    }
	
	public void sai() {
        if (pessoasDentro > 0) {
            pessoasDentro--;
            System.out.println("Pessoa saiu. Ocupação: " + pessoasDentro + "/" + capacidade);
        } else {
            System.out.println("Elevador VAZIO! Ninguém para sair.");
        }
	}

	public void sobe() {
        if (andarAtual < totalAndares) {
            andarAtual++;
            System.out.println("Subindo... Andar atual: " + andarAtual);
        } else {
            System.out.println("Já estou no último andar (" + totalAndares + ")!");
        }
    }
	
	public void sobe(int andar) {
        if (andar <= andarAtual) {
            System.out.println("Andar inválido! Já estou no " + andarAtual + "º andar.");
        } else if (andar > totalAndares) {
            System.out.println("Andar " + andar + " não existe! Máximo: " + totalAndares);
        } else {
            andarAtual = andar;
            System.out.println("Subindo para o andar " + andarAtual + ".");
        }
    }
	
	public void desce() {
        if (andarAtual > 0) {
            andarAtual--;
            System.out.println("Descendo... Andar atual: " + (andarAtual == 0 ? "Térreo" : andarAtual));
        } else {
            System.out.println("Já estou no térreo!");
        }
    }
	
	public void desce(int andar) {
        if (andar >= andarAtual) {
            System.out.println("Andar inválido! Já estou no " + andarAtual + "º andar.");
        } else if (andar < 0) {
            System.out.println("Andar não pode ser negativo!");
        } else {
            andarAtual = andar;
            System.out.println("Descendo para o " + (andarAtual == 0 ? "térreo" : andarAtual + "º andar") + ".");
        }
    }
	
	public boolean podeEntrar() {
        return pessoasDentro < capacidade;
    }
	
	public void status() {
        System.out.println("\n--- Status do Elevador ---");
        System.out.println("Andar atual : " + (andarAtual == 0 ? "Térreo" : andarAtual + "º"));
        System.out.println("Total andares: " + totalAndares);
        System.out.println("Pessoas     : " + pessoasDentro + "/" + capacidade);
        System.out.println("Pode entrar : " + (podeEntrar() ? "Sim" : "Não (cheio)"));
        System.out.println("--------------------------\n");
    }
	
}
