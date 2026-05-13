import java.util.Scanner;

public class Calculadora {

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularTroco(double valorRecebido, double valorTotal) {
        return valorRecebido - valorTotal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("============================================");
        System.out.println("  Bem-vindo à Calculadora da Dona Gabrielinha!");
        System.out.println("        Loja de Plantas Exóticas ");
        System.out.println("============================================");

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\n--- Calcular Preço Total ---");
                    System.out.print("Digite a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Digite o preço unitário (R$): ");
                    double precoUnitario = scanner.nextDouble();

                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);

                    System.out.printf("Preço Total: R$ %.2f%n", precoTotal);
                    break;

                case 2:
                    System.out.println("\n--- Calcular Troco ---");

                    System.out.print("Digite o valor recebido (R$): ");
                    double valorRecebido = scanner.nextDouble();

                    System.out.print("Digite o valor total da compra (R$): ");
                    double valorTotal = scanner.nextDouble();

                    double troco = calcularTroco(valorRecebido, valorTotal);

                    if (troco < 0) {
                        System.out.printf("Valor insuficiente! Faltam R$ %.2f%n", Math.abs(troco));
                    } else {
                        System.out.printf("Troco: R$ %.2f%n", troco);
                    }
                    break;

                case 3:
                    System.out.println("\nObrigado por usar a calculadora da Dona Gabrielinha!");
                    System.out.println("Volte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}