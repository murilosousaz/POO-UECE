package questoes;

public class Animal {
	
	private String nome;
	private double peso;
	private int quantidade;
	private double valor;
	
	public Animal(String nome, double peso, int quantidade, double valor) {
		this.nome = "Galinhas";
		this.peso = 1.5;
		this.quantidade = 500;
		this.valor = calcularValor();
	}
	
	public Animal(String nome) {
        nome = nome.trim();
        if (!nome.equalsIgnoreCase("Patos") && !nome.equalsIgnoreCase("Gansos")) {
            throw new IllegalArgumentException(
                "Animal '" + nome + "' não aceito neste construtor. " +
                "Use: Patos ou Gansos."
            );
        }
        this.nome = nome;
        this.peso = 2.0;
        this.quantidade = 100;
        this.valor = calcularValor();
    }
	
    public Animal(String nome, double peso) {
        nome = nome.trim();
        if (!nome.equalsIgnoreCase("Vacas") && !nome.equalsIgnoreCase("Porcos")) {
            throw new IllegalArgumentException(
                "Animal '" + nome + "' não aceito neste construtor. " +
                "Use: Vacas ou Porcos."
            );
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser positivo!");
        }
        this.nome = nome;
        this.peso = peso;
        this.quantidade = 50;
        this.valor = calcularValor();
    }
	
    private double calcularValor() {
        String n = this.nome.toLowerCase();
 
        if (n.equals("galinhas")) {
            return this.quantidade * 2.00;
        }
 
        if (n.equals("patos")) {
            return this.quantidade * 50.00;
        }
 
        if (n.equals("gansos")) {
            return this.quantidade * 100.00;
        }
 
        double valorUnitario;
        double kgExcedente = Math.max(0, this.peso - 5.0);
        double adicionalPorKg = kgExcedente * 50.00;
 
        if (n.equals("vacas")) {
            valorUnitario = 1500.00 + adicionalPorKg;
        } else { 
            valorUnitario = 500.00 + adicionalPorKg;
        }
 
        return this.quantidade * valorUnitario;
    }

    public void gerarRelatorio() {
        System.out.println("\n===== Relatório do Lote =====");
        System.out.printf("Animal     : %s%n", nome);
        System.out.printf("Quantidade : %d unidades%n", quantidade);
        System.out.printf("Peso (unit): %.1f Kg%n", peso);
        System.out.printf("Valor total: R$ %,.2f%n", valor);
        System.out.println("=============================\n");
    }

	public String getNome() {
		return nome;
	}

	public double getPeso() {
		return peso;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValor() {
		return valor;
	}
    
	@Override
    public String toString() {
        return String.format("%-10s | %4d un. | %4.1f Kg/un | R$ %,.2f total",
            nome, quantidade, peso, valor);
    }
	
}
