package questoes;

public class Aniversario {
	private String[] pessoas;
	private String[] datas;
	private int totalAmigos;
	
	public Aniversario() {
		this.pessoas = new String[100];
		this.datas = new String[100];
		this.totalAmigos = 0;
	}
	
	public void adicionarAmigo(String nome, String data) {
		for (int i = 0; i < totalAmigos; i++) {
			if(pessoas[i].equalsIgnoreCase(nome)) {
				System.out.println("Amigo" + nome + " já está na lista! ");
				return;
			}
		}
		
		if(totalAmigos < pessoas.length) {
			pessoas[totalAmigos] = nome;
			datas[totalAmigos] = data;
			totalAmigos++;
			System.out.println("Amigo " + nome + " adicionado com sucesso! ");
		}else {
			System.out.println("Lista cheia! Não é possível adicionar mais amigos.");
		}
	}
	
	public void atualizarAmigo(String nomeAtual, String novoNome, String novaData) {
		for(int i = 0; i < totalAmigos; i++) {
			if(pessoas[i].equalsIgnoreCase(nomeAtual)) {
				pessoas[i] = novoNome;
				datas[i] = novaData;
				System.out.println("Dados de " + nomeAtual + " atualizados");
				return;
			}
		}
	}
	
	public void removerAmigo(String nome) {
		for(int i = 0; i < totalAmigos; i++) {
			if(pessoas[i].equalsIgnoreCase(nome)) {
				for(int j = 0; j < totalAmigos - 1; j++) {
					pessoas[j] = pessoas[j + 1];
					datas[j] = datas[j + 1];
				}
				totalAmigos--;
				System.out.println("Amigo " + nome + " removido com sucesso");
				return;
			}
		}
		System.out.println("Amigo " + nome + " não encontrado.");
	}
	
	public void mostrarLista() {
		if (totalAmigos == 0) {
			System.out.println("Nenhum amigo cadastrado ainda.");
			return;
		}
		System.out.println("\n===== Lista de Aniversários =====\"");
		for (int i = 0; i < totalAmigos; i ++) {
			System.out.println((i + 1) + ". " + pessoas[i] + "-> " + datas[i]);
		}
		System.out.println("========================\n");
	}
}
