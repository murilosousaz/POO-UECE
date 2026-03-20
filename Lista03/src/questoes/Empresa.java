package questoes;

public class Empresa {
	
	private String nome;
	private Funcionario[] funcionarios;
	private int totalFuncionarios;
	
	public Empresa(String nome, int capacidade) {
        this.nome              = nome;
        this.funcionarios      = new Funcionario[capacidade];
        this.totalFuncionarios = 0;
    }
	
	private int buscarIndice(String nome) {
        for (int i = 0; i < totalFuncionarios; i++) {
            if (funcionarios[i].getNome().equalsIgnoreCase(nome)) return i;
        }
        return -1;
    }
	
	public void registrarNovoFuncionario(String nome, String cargo) {
        if (totalFuncionarios >= funcionarios.length) {
            System.out.println("Empresa cheia! Não é possível contratar.");
            return;
        }
        funcionarios[totalFuncionarios++] = new Funcionario(nome, cargo);
        System.out.println("Funcionário '" + nome + "' registrado com salário mínimo (R$ 1509,00).");
    }
	
	public void registrarFuncionarioTransferido(String nome, String cargo, double salario) {
        if (totalFuncionarios >= funcionarios.length) {
            System.out.println("Empresa cheia!");
            return;
        }
        try {
            funcionarios[totalFuncionarios++] = new Funcionario(nome, cargo, salario);
            System.out.println("Funcionário '" + nome + "' transferido registrado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void darAumento(String nome, double percentual) {
        int i = buscarIndice(nome);
        if (i == -1) { System.out.println("Funcionário não encontrado."); return; }
 
        double novoSalario = funcionarios[i].getSalario() * (1 + percentual / 100.0);
        funcionarios[i].setSalario(novoSalario);
        System.out.printf("Aumento de %.1f%% aplicado. Novo salário: R$ %,.2f%n",
            percentual, novoSalario);
    }
    
    public void demitirFuncionario(String nome) {
        int i = buscarIndice(nome);
        if (i == -1) { System.out.println("Funcionário não encontrado."); return; }
 
        String demitido = funcionarios[i].getNome();
        for (int j = i; j < totalFuncionarios - 1; j++) {
            funcionarios[j] = funcionarios[j + 1];
        }
        funcionarios[--totalFuncionarios] = null; // limpa última referência
        System.out.println("Funcionário '" + demitido + "' demitido.");
    }
    
    public void promoverFuncionario(String nome, String novoCargo, double aumentoPercentual) {
        int i = buscarIndice(nome);
        if (i == -1) { System.out.println("Funcionário não encontrado."); return; }
 
        funcionarios[i].setCargo(novoCargo);
        double novoSalario = funcionarios[i].getSalario() * (1 + aumentoPercentual / 100.0);
        funcionarios[i].setSalario(novoSalario);
        System.out.printf("'%s' promovido a '%s'. Novo salário: R$ %,.2f%n",
            nome, novoCargo, novoSalario);
    }
    
    public void mostrarListaDeFuncionarios() {
        if (totalFuncionarios == 0) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        System.out.println("\n===== Funcionários de " + nome + " =====");
        System.out.printf("%-20s | %-20s | %s%n", "Nome", "Cargo", "Salário");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < totalFuncionarios; i++) {
            System.out.println(funcionarios[i]);
        }
        System.out.println("==========================================================\n");
    }
}
