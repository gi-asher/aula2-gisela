
import java.time.LocalDate;

class Venda {
    private double precoUnitario;
    private int quantidade;
    private LocalDate dataVenda;

    public Venda(double precoUnitario, int quantidade) {
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.dataVenda = LocalDate.now(); // Registra a data da venda
    }

    // Métodos Getters (Essenciais para o relatório ler os dados)
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    // Método para calcular o valor com desconto para o relatório
    public double getValorFinal() {
        double total = precoUnitario * quantidade;
        return (quantidade > 10) ? total * 0.95 : total;
    }
}
