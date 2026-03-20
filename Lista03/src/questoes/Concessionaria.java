package questoes;

import java.util.Scanner;

public class Concessionaria {
	private String   nome;
    private Veiculo[] carrosAVenda;
    private String[]  vendas;
    private int totalVeiculos;
    private int totalVendas;
 
    public Concessionaria(String nome, int capacidade) {
        this.nome          = nome;
        this.carrosAVenda  = new Veiculo[capacidade];
        this.vendas        = new String[capacidade * 10];
        this.totalVeiculos = 0;
        this.totalVendas   = 0;
    }
 
    public void adicionarVeiculo(Veiculo v) {
        if (totalVeiculos < carrosAVenda.length) {
            carrosAVenda[totalVeiculos++] = v;
        } else {
            System.out.println("Estoque cheio!");
        }
    }
 
    public void mostrarEstoque() {
        if (totalVeiculos == 0) { System.out.println("Sem veículos em estoque."); return; }
        System.out.println("\n===== Estoque: " + nome + " =====");
        for (int i = 0; i < totalVeiculos; i++) {
            System.out.println((i + 1) + ". " + carrosAVenda[i]);
        }
        System.out.println();
    }
 
    public void venderVeiculo(Scanner sc) {
        mostrarEstoque();
        if (totalVeiculos == 0) return;
 
        System.out.print("Número do veículo desejado: ");
        int idx = sc.nextInt() - 1; sc.nextLine();
 
        if (idx < 0 || idx >= totalVeiculos) {
            System.out.println("Veículo inválido!");
            return;
        }
 
        Veiculo v = carrosAVenda[idx];
 
        System.out.println("Forma de pagamento:");
        System.out.println("1 - À vista");
        System.out.println("2 - Parcelado");
        System.out.print("Escolha: ");
        int pagamento = sc.nextInt(); sc.nextLine();
 
        if (pagamento == 1) {
            gerarCupomFiscal(v, "À vista", 1, v.getPrecoAVista());
        } else if (pagamento == 2) {
            System.out.print("Quantidade de parcelas: ");
            int parcelas = sc.nextInt(); sc.nextLine();
            double valorParcela = v.getPrecoTotalParcelado() / parcelas;
            gerarCupomFiscal(v, "Parcelado", parcelas, valorParcela);
        } else {
            System.out.println("Forma de pagamento inválida!");
        }
    }
 
    public void gerarCupomFiscal(Veiculo v, String formaPag, int parcelas, double valorParcela) {
        StringBuilder cupom = new StringBuilder();
        cupom.append("\n╔══════════════════════════════════╗\n");
        cupom.append("       CUPOM FISCAL — ").append(nome).append("\n");
        cupom.append("╠══════════════════════════════════╣\n");
        cupom.append(String.format(" Veículo : %s (%s)%n", v.getNome(), v.getTipo()));
        cupom.append(String.format(" Portas  : %d%n", v.getQuantidadeDePortas()));
        cupom.append("╠══════════════════════════════════╣\n");
        cupom.append(String.format(" Pagamento: %s%n", formaPag));
 
        if (parcelas == 1) {
            cupom.append(String.format(" Total   : R$ %,.2f%n", valorParcela));
        } else {
            cupom.append(String.format(" Parcelas: %dx de R$ %,.2f%n", parcelas, valorParcela));
            cupom.append(String.format(" Total   : R$ %,.2f%n", v.getPrecoTotalParcelado()));
        }
        cupom.append("╚══════════════════════════════════╝\n");
 
        System.out.println(cupom);
 
        if (totalVendas < vendas.length) {
            vendas[totalVendas++] = cupom.toString();
        }
    }
 
    public void gerarExtratoDeVendas() {
        if (totalVendas == 0) { System.out.println("Nenhuma venda realizada."); return; }
        System.out.println("\n===== EXTRATO DE VENDAS — " + nome + " =====");
        for (int i = 0; i < totalVendas; i++) {
            System.out.println("Venda #" + (i + 1));
            System.out.println(vendas[i]);
        }
    }

}
