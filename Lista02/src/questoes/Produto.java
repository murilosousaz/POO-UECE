package questoes;

public class Produto {
	private String nome;
	private String descricao;
	private double preco;
	
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco >= 0) {
			this.preco = preco;
		}else {
			System.out.println("Preço não pode ser negativo!");
		}
	}
	
	@Override
	public String toString() {
		return String.format("-%15s | %-25%s | R$ %.2f", nome, descricao, preco);
	}
	
	

}
