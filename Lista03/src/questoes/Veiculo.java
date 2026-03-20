package questoes;

public class Veiculo {
	
	private String nome;
    private String tipo;
    private double precoAVista;
    private double precoTotalParcelado;
    private int    quantidadeDePortas;

    public Veiculo(String nome, double precoAVista, int quantidadeDePortas) {
    	 
        if (quantidadeDePortas == 0) {
            this.tipo = "Moto";
        } else if (quantidadeDePortas == 2) {
            this.tipo = "Caminhao";
        } else if (quantidadeDePortas == 4) {
            this.tipo = "Carro";
        } else {
            throw new IllegalArgumentException(
                "Quantidade de portas inválida: " + quantidadeDePortas +
                ". Aceito: 0 (Moto), 2 (Caminhao) ou 4 (Carro)."
            );
        }
        this.nome               = nome;
        this.precoAVista        = precoAVista;
        this.quantidadeDePortas = quantidadeDePortas;
        this.precoTotalParcelado = precoAVista + (precoAVista * 0.50);
    }

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public double getPrecoAVista() {
		return precoAVista;
	}

	public double getPrecoTotalParcelado() {
		return precoTotalParcelado;
	}

	public int getQuantidadeDePortas() {
		return quantidadeDePortas;
	}
    
	@Override
    public String toString() {
        return String.format(
            "[%s] %s | À vista: R$ %,.2f | Parcelado: R$ %,.2f | Portas: %d",
            tipo, nome, precoAVista, precoTotalParcelado, quantidadeDePortas
        );
    }
    
}