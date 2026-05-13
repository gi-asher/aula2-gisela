import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Venda {
    int quantidade;
    double valorVenda;
    double desconto;

    public Venda(int quantidade, double valorVenda, double desconto) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "\r\nQuantidade: " + quantidade + "\r\nValor de Venda: " + valorVenda + " \r\nDesconto Aplicado:" + desconto + "\r\n";
    }
}

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alternativa = 0;
        List<Venda> vendas = new ArrayList<>();

        while (alternativa != 4) {
            System.out.println("    [1] - Calcular Preço Total\r\n" + //
                    "    [2] - Calcular Troco    \r\n" + //
                    "    [3] - Ver Registro de Vendas\r\n" + //
                    "    [4] - Sair ");
            alternativa = sc.nextInt();

            switch (alternativa) {
                case 1:
                    System.out.println("Digite o preço do produto: ");
                    double valor = sc.nextDouble();
                    System.out.println("Digite a quantidade: ");
                    int quantidade = sc.nextInt();
                    double total = valor * quantidade;
                    double desconto = 0;
                    if (quantidade > 10) {
                        System.out.println("Você ganhou um desconto de 5%!");
                        desconto = total * 0.05;
                        double valorComDesconto = total - desconto;
                        System.out.println("O preço com desconto é: " + valorComDesconto);
                        vendas.add(new Venda(quantidade, valorComDesconto, desconto));
                    } else {
                        System.out.println("O preço total é: " + total);
                        vendas.add(new Venda(quantidade, total, desconto));
                    }
                    break;
                case 2:
                    System.out.println("Digite o valor pago: ");
                    double valorPago = sc.nextDouble();
                    System.out.println("Digite o valor total: ");
                    double valorTotal = sc.nextDouble();
                    double troco = valorPago - valorTotal;
                    System.out.println("O troco é: " + troco);
                    break;
                case 3:
                    System.out.println("\r\nRegistro de Vendas:\r\n");
                    if (vendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (int i = 0; i < vendas.size(); i++) {
                            System.out.println("Venda " + (i + 1) + ": " + vendas.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }
    }
}   