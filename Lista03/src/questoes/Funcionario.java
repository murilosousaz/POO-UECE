package questoes;

public class Funcionario {
	private String nome;
	private String cargo;
	private double salario;
	
	public Funcionario(String nome, String cargo, double salario) {
		if(salario <= 0) {
			throw new IllegalArgumentException(
					"Salário inválido! Deve ser maior que zero. Recebido: " + salario
			);
		}
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}

	public Funcionario(String nome, String cargo) {
		this(nome, cargo, 1509.00);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if (salario > 0) this.salario = salario;
        else System.out.println("Salário inválido!");
	}
	
    @Override
    public String toString() {
        return String.format("%-20s | %-20s | R$ %,.2f", nome, cargo, salario);
    }
	
}
