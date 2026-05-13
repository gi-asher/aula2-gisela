package Calculadora;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<String> historicoVendas = new ArrayList<>();

    public static void main(String[] args) {

        int menu = 0;

        while (menu != 4) {

            System.out.println("\n1 - Calcular Preço Total");
            System.out.println("2 - Calcular Troco");
            System.out.println("3 - Histórico de Vendas");
            System.out.println("4 - Sair");

            menu = scanner.nextInt();

            switch (menu) {

                case 1:
                    precoTotal();
                    break;

                case 2:
                    troco();
                    break;

                case 3:
                    exibirHistorico();
                    break;

                case 4:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Esta opção não é válida, tente novamente!");
            }
        }
    }

    public static void precoTotal() {

        System.out.println("Informe a quantidade de plantas:");
        int quantidade = scanner.nextInt();

        System.out.println("Informe o valor da planta:");
        float precoUnitario = scanner.nextFloat();

        float precoTotal = quantidade * precoUnitario;
        float desconto = 0;

        if (quantidade > 10) {
            desconto = precoTotal * 0.05f;
            precoTotal = precoTotal - desconto;

            System.out.println("Você ganhou 5% de desconto por comprar mais de 10 plantas!");
        }

        System.out.println("Valor final da compra: " + precoTotal);

        String venda = "Quantidade: " + quantidade +
                       " | Preço unitário: " + precoUnitario +
                       " | Desconto: " + desconto +
                       " | Total pago: " + precoTotal;

        historicoVendas.add(venda);

        System.out.println("Obrigada por nos escolher, volte sempre!");
    }

    public static void troco() {

        System.out.println("Informe o valor entregue pelo cliente:");
        float valorDoCliente = scanner.nextFloat();

        System.out.println("Informe o valor total da compra:");
        float valorCompra = scanner.nextFloat();

        float troco = valorDoCliente - valorCompra;

        System.out.println("Valor do troco: " + troco);
    }

    public static void exibirHistorico() {

        if (historicoVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada ainda.");
        } else {
            System.out.println("\nHISTÓRICO DE VENDAS");

            for (String venda : historicoVendas) {
                System.out.println(venda);
            }
        }
    }
}