package calculadora.model;

public class Venda {

    private int quantidade;
    private double preco;
    private double desconto;
    private double valorTotal;

    public Venda(int quantidade, double preco) {
        this.quantidade = quantidade;
        this.preco = preco;

        if (quantidade > 10) {
            this.desconto = preco * quantidade * 0.05;
        } else {
            this.desconto = 0;
        }

        this.valorTotal = (preco * quantidade) - desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}