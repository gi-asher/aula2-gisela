public class Venda {

    private int quantidade;
    private float valorUn;
    private float desconto;
    private float total;

    public Venda(int quantidade, float valorUn) {
        this.quantidade = quantidade;
        this.valorUn = valorUn;
        calcularTotal();
    }

    private void calcularTotal() {
        total = quantidade * valorUn;

        if (quantidade > 10) {
            desconto = total * 0.05f;
            total -= desconto;
        } else {
            desconto = 0;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getDesconto() {
        return desconto;
    }

    public float getTotal() {
        return total;
    }
}