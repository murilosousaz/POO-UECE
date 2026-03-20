package questoes;

public class Palavra {
	private String palavra;
	
	public Palavra(String palavra) {
		this.palavra = palavra;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	public String inverterPalavra() {
		StringBuilder sb = new StringBuilder(palavra);
		return sb.reverse().toString();
	}
	
	public int quantVogais() {
        int conta = 0;
        String vogais = "aeiouAEIOUáéíóúÁÉÍÓÚãõÃÕâêîôûÂÊÎÔÛ";
        for (int i = 0; i < palavra.length(); i++) {
            if (vogais.indexOf(palavra.charAt(i)) != -1) {
                conta++;
            }
        }
        return conta;
    }
	
	public void concatenarPalavra(String outra) {
        this.palavra = this.palavra + outra;
        System.out.println("Palavra após concatenar: " + this.palavra);
    }
	
	public boolean verificarPalavra(String outra) {
        return this.palavra.equalsIgnoreCase(outra);
    }
	
	@Override
    public String toString() {
        return "Palavra atual: \"" + palavra + "\"";
    }

}
