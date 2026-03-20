package questoes;

public class Loja {
	
	private String nome;
	private Produto[] itensDeVenda;
	private Produto[] carrinhoDeCompras;
	private int totalItens;
	private int totalCarrinho;
	
	public Loja(String nome, int capacidadeCatalogo) {
		this.nome = nome;
		this.itensDeVenda = new Produto[capacidadeCatalogo];
		this.carrinhoDeCompras = new Produto[capacidadeCatalogo];
		this.totalItens = 0;
		this.totalCarrinho = 0;
	}
	
	public void adicionarProduto(Produto p) {
		if(totalItens < itensDeVenda.length) {
			itensDeVenda[totalItens++] = p;
		}else {
			System.out.println("Catálogo cheio!");
		}
	}
	
	public void mostrarCatalogo() {
		if(totalItens == 0) {
			System.out.println("Nenhum produto disponível.");
			return;
		}
        System.out.println("\n===== Produtos disponíveis em " + nome + " =====");
        System.out.printf("%-4s %-15s %-25s %-10s%n", "Nº", "Nome", "Descrição", "Preço");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < totalItens; i++) {
            System.out.printf("%-4d %s%n", (i + 1), itensDeVenda[i]);
        }
        System.out.println();
	}
	
    public void adicionarAoCarrinho(int indice) {
        if (indice < 0 || indice >= totalItens) {
            System.out.println("Produto inválido!");
            return;
        }
        carrinhoDeCompras[totalCarrinho++] = itensDeVenda[indice];
        System.out.println("'" + itensDeVenda[indice].getNome() + "' adicionado ao carrinho!");
    }
    
    public double vender() {
        double total = 0;
        for (int i = 0; i < totalCarrinho; i++) {
            total += carrinhoDeCompras[i].getPreco();
        }
        return total;
    }
    
    public void mostrarCarrinho() {
        if (totalCarrinho == 0) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("\n===== Carrinho de Compras =====");
        for (int i = 0; i < totalCarrinho; i++) {
            System.out.printf("%d. %s%n", (i + 1), carrinhoDeCompras[i]);
        }
        System.out.printf("TOTAL: R$ %.2f%n%n", vender());
    }
    
    public void gerarNotaFiscal() {
        if (totalCarrinho == 0) {
            System.out.println("Nenhuma compra realizada.");
            return;
        }
        System.out.println("\n========================================");
        System.out.println("           NOTA FISCAL");
        System.out.println("  Loja: " + nome);
        System.out.println("========================================");
        System.out.printf("%-15s %-25s%n", "Produto", "Descrição");
        System.out.println("----------------------------------------");
        for (int i = 0; i < totalCarrinho; i++) {
            System.out.printf("%-15s %-25s%n",
                carrinhoDeCompras[i].getNome(),
                carrinhoDeCompras[i].getDescricao());
        }
        System.out.println("----------------------------------------");
        System.out.printf("TOTAL: R$ %.2f%n", vender());
        System.out.println("========================================\n");
 
        totalCarrinho = 0;

    }
}