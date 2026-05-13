import java.util.Scanner;

public class CalculadoraLojaMelhorada {

    static int totalVendas = 0;
    static int totalPlantasVendidas = 0;
    static double totalDescontos = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {

            System.out.println("=== Calculadora Loja da Dona Gabrielinha ===");
            System.out.println("[1] - Realizar venda");
            System.out.println("[2] - Ver registro de vendas");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao == 1) {

                System.out.print("Digite a quantidade de plantas: ");
                int quantidade = scanner.nextInt();

                System.out.print("Digite o preço da planta: ");
                double preco = scanner.nextDouble();

                double total = quantidade * preco;
                double desconto = 0;

                if (quantidade > 10) {
                    desconto = total * 0.05;
                    total = total - desconto;
                }

                System.out.println("Valor total da compra: R$ " + total);
                System.out.println("Desconto aplicado: R$ " + desconto);

                totalVendas++;
                totalPlantasVendidas += quantidade;
                totalDescontos += desconto;

            }

            else if (opcao == 2) {

                System.out.println("=== Registro de vendas ===");
                System.out.println("Total de vendas realizadas: " + totalVendas);
                System.out.println("Total de plantas vendidas: " + totalPlantasVendidas);
                System.out.println("Total de descontos aplicados: R$ " + totalDescontos);

            }

            else if (opcao == 3) {
                System.out.println("Saindo do sistema...");
            }

            else {
                System.out.println("Opção inválida!");
            }

            System.out.println();
        }

        scanner.close();
    }
}