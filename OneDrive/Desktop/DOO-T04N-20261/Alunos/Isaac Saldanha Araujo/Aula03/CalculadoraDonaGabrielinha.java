import java.util.Scanner;

public class CalculadoraDonaGabrielinha {

    static int totalPlantasVendidas = 0;
    static double totalVendas = 0;
    static double totalDescontos = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n Loja de Plantas da Dona Gabrielinha");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Mostrar Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Digite a quantidade de plantas:");
                    int quantidade = scanner.nextInt();

                    System.out.println("Digite o preço da planta:");
                    double preco = scanner.nextDouble();

                    double total = preco * quantidade;
                    double desconto = 0;

                
                    if (quantidade > 10) {
                        desconto = total * 0.05;
                        total -= desconto;
                    }

                  
                    totalPlantasVendidas += quantidade;
                    totalVendas += total;
                    totalDescontos += desconto;

                    System.out.println("Preço total da compra: R$ " + total);
                    System.out.println("Desconto aplicado: R$ " + desconto);
                    break;

                case 2:
                    System.out.println("Digite o valor pago pelo cliente:");
                    double pago = scanner.nextDouble();

                    System.out.println("Digite o valor total da compra:");
                    double valorCompra = scanner.nextDouble();

                    double troco = pago - valorCompra;

                    System.out.println("Valor do troco: R$ " + troco);
                    break;

                case 3:
                    System.out.println("\n=== REGISTRO DE VENDAS ===");
                    System.out.println("Total de plantas vendidas: " + totalPlantasVendidas);
                    System.out.println("Total em vendas: R$ " + totalVendas);
                    System.out.println("Total de descontos: R$ " + totalDescontos);
                    break;

                case 4:
                    System.out.println("Encerrando Sistema. Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}