import java.util.Scanner;

public class CalculadoraLoja {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        int[] quantidades = new int[100];
        double[] valoresVenda = new double[100];
        double[] descontos = new double[100];

        int totalVendas = 0;

        while (opcao != 4) {

            System.out.println("\n===== Loja da Dona Gabrielinha =====");
            System.out.println("1 - Calcular Preço Total");
            System.out.println("2 - Calcular Troco");
            System.out.println("3 - Ver Registro de Vendas");
            System.out.println("4 - Sair");

            opcao = scanner.nextInt();

            if (opcao == 1) {

                System.out.println("Digite a quantidade:");
                int quantidade = scanner.nextInt();

                System.out.println("Digite o preço da planta:");
                double preco = scanner.nextDouble();

                double total = quantidade * preco;
                double desconto = 0;

                if (quantidade > 10) {
                    desconto = total * 0.05;
                    total = total - desconto;
                }

                System.out.println("Valor total da compra: " + total);
                System.out.println("Desconto aplicado: " + desconto);

                // Registrar venda
                quantidades[totalVendas] = quantidade;
                valoresVenda[totalVendas] = total;
                descontos[totalVendas] = desconto;

                totalVendas++;

            }

            else if (opcao == 2) {

                System.out.println("Digite o valor pago:");
                double valorPago = scanner.nextDouble();

                System.out.println("Digite o valor da compra:");
                double valorCompra = scanner.nextDouble();

                double troco = valorPago - valorCompra;

                System.out.println("Troco: " + troco);

            }

            else if (opcao == 3) {

                System.out.println("\n===== Registro de Vendas =====");

                for (int i = 0; i < totalVendas; i++) {

                    System.out.println("\nVenda " + (i + 1));
                    System.out.println("Quantidade: " + quantidades[i]);
                    System.out.println("Valor da venda: " + valoresVenda[i]);
                    System.out.println("Desconto aplicado: " + descontos[i]);

                }

                if (totalVendas == 0) {
                    System.out.println("Nenhuma venda registrada.");
                }

            }

            else if (opcao == 4) {

                System.out.println("Obrigado por usar a calculadora!");

            }

            else {

                System.out.println("Opção inválida!");

            }

        }

        scanner.close();
    }
}