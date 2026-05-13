import java.util.Locale;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro(scanner, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    System.out.println("Saindo da calculadora... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        } while (opcao != 3);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("==== Calculadora da Loja da Dona Gabrielinha ====");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Sair");
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        double quantidade = lerDouble(scanner, "Digite a quantidade da planta: ");
        double precoUnitario = lerDouble(scanner, "Digite o preço unitário da planta: ");

        double total = quantidade * precoUnitario;
        System.out.printf("Preço total da venda: R$ %.2f%n", total);
    }

    private static void calcularTroco(Scanner scanner) {
        double valorRecebido = lerDouble(scanner, "Digite o valor recebido do cliente: ");
        double valorCompra = lerDouble(scanner, "Digite o valor total da compra: ");

        double troco = valorRecebido - valorCompra;
        if (troco < 0) {
            System.out.printf("Valor insuficiente. Faltam R$ %.2f%n", Math.abs(troco));
        } else {
            System.out.printf("Troco a ser devolvido: R$ %.2f%n", troco);
        }
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scanner.nextLine();
        }
    }

    private static double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextDouble()) {
                double valor = scanner.nextDouble();
                scanner.nextLine();
                return valor;
            }
            System.out.println("Entrada inválida. Digite um número válido.");
            scanner.nextLine();
        }
    }
}