package fag.objetos;

public class Vendas {

	private int quantidade;
	private double preco;
	private double precoTotal;
	private double desconto;
	private double valorFinal;
	
	private static final double taxaDesconto = 0.05;

	public Vendas() {
	}

	public Vendas(int quantidade, double preco) {
		setQuantidade(quantidade);
		setPreco(preco);
		calcularValorFinal();
	}

// getters:

	public int getQuantidade() {
		return quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public double getDesconto() {
		return desconto;
	}

	public double getValorFinal() {
		return valorFinal;
	}

//setters:

	public void setQuantidade(int quantidade) {
		if (quantidade > 0) {
			this.quantidade = quantidade;
		} else {
			System.out.println("Quantidade inválida!");
		}
	}

	public void setPreco(double preco) {
		if (preco > 0) {
			this.preco = preco;
		} else {
			System.out.println("Preço inválido!");
		}
	}

	public void calcularValorFinal() {
		this.precoTotal = quantidade * preco;

		if (quantidade >= 10) {
			this.desconto = precoTotal * taxaDesconto;
		} else {
			this.desconto = 0;
		}

		this.valorFinal = precoTotal - desconto;
	}

	public void mostrarDetalhes() {
		System.out.printf(
				"Quantidade: %d | Preço Unitário: R$ %.2f | Total: R$ %.2f | Desconto: R$ %.2f | Valor Final: R$ %.2f | \n",
				quantidade, preco, precoTotal, desconto, valorFinal);

	}

}
