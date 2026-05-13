import java.util.Scanner;

public class CalculadoraLoja {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        int totalPlantasVendidas = 0;
        double valorTotalVendas = 0;
        double totalDescontos = 0;

        while (opcao != 4) {

            System.out.println("=== Loja da Dona Gabrielinha ===");
            System.out.println("[1] Calcular venda");
            System.out.println("[2] Ver registro de vendas");
            System.out.println("[3] Calcular troco");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();

            if (opcao == 1) {

                System.out.print("Quantidade de plantas: ");
                int quantidade = sc.nextInt();

                System.out.print("Preco da planta: ");
                double preco = sc.nextDouble();

                double total = quantidade * preco;
                double desconto = 0;


                if (quantidade > 10) {
                    desconto = total * 0.05;
                    total = total - desconto;
                    System.out.println("Desconto de 5% aplicado!");
                }

                System.out.printf("Total a pagar: R$ %.2f%n", total);


                totalPlantasVendidas += quantidade;
                valorTotalVendas += total;
                totalDescontos += desconto;

                System.out.println();

            } else if (opcao == 2) {


                System.out.println("=== Registro de vendas ===");
                System.out.println("Total de plantas vendidas: " + totalPlantasVendidas);
                System.out.printf("Valor total vendido: R$ %.2f%n", valorTotalVendas);
                System.out.printf("Total de descontos dados: R$ %.2f%n", totalDescontos);
                System.out.println();

            } else if (opcao == 3) {

                System.out.print("Valor pago pelo cliente: ");
                double valorPago = sc.nextDouble();

                System.out.print("Valor da compra: ");
                double valorCompra = sc.nextDouble();

                double troco = valorPago - valorCompra;

                if (troco < 0) {
                    System.out.printf("Valor insuficiente! Faltam R$ %.2f%n", -troco);
                } else {
                    System.out.printf("Troco: R$ %.2f%n", troco);
                }

                System.out.println();

            } else if (opcao == 4) {

                System.out.println("Encerrando sistema...");

            } else {

                System.out.println("Opcao invalida!");
                System.out.println();
            }
        }

        sc.close();
    }
}