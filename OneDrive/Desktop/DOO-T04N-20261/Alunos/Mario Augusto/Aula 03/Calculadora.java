import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {

    // Classe para registrar cada venda
    static class RegistroVenda {
        int quantidade;
        double valorTotal;
        double desconto;

        RegistroVenda(int quantidade, double valorTotal, double desconto) {
            this.quantidade = quantidade;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
        }
    }

    // Lista para armazenar as vendas
    static List<RegistroVenda> registroVendas = new ArrayList<>();

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularDesconto(int quantidade, double precoTotal) {
        if (quantidade > 10) {
            return precoTotal * 0.05;
        }
        return 0;
    }

    public static double calcularTroco(double valorRecebido, double valorTotal) {
        return valorRecebido - valorTotal;
    }

    public static void registrarVenda(int quantidade, double valorTotal, double desconto) {
        registroVendas.add(new RegistroVenda(quantidade, valorTotal, desconto));
    }

    public static void exibirRegistroVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("\nNenhuma venda registrada ainda.");
            return;
        }

        System.out.println("\n--- REGISTRO DE VENDAS ---");
        int numeroVenda = 1;
        for (RegistroVenda venda : registroVendas) {
            System.out.println("\nVenda #" + numeroVenda++);
            System.out.println("Quantidade de plantas: " + venda.quantidade);
            System.out.printf("Desconto aplicado: R$ %.2f%n", venda.desconto);
            System.out.printf("Valor total: R$ %.2f%n", venda.valorTotal);
        }
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
            System.out.println("[3] - Registro de Vendas");
            System.out.println("[4] - Sair");
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
                    double desconto = calcularDesconto(quantidade, precoTotal);
                    double valorAPagar = precoTotal - desconto;

                    System.out.printf("Preço Total: R$ %.2f%n", precoTotal);
                    if (desconto > 0) {
                        System.out.printf("Desconto (5%%): R$ %.2f%n", desconto);
                    }
                    System.out.printf("Valor a Pagar: R$ %.2f%n", valorAPagar);

                    registrarVenda(quantidade, valorAPagar, desconto);
                    break;

                case 2:
                    System.out.println("\n--- Calcular Troco ---");
                    System.out.print("Digite o valor recebido (R$): ");
                    double valorRecebido = scanner.nextDouble();
                    System.out.print("Digite o valor total da compra (R$): ");
                    double valorTotal = scanner.nextDouble();

                    double troco = calcularTroco(valorRecebido, valorTotal);
                    if (troco < 0) {
                        System.out.printf("Valor insuficiente! Faltam R$ %.2f.%n", Math.abs(troco));
                    } else {
                        System.out.printf("Troco: R$ %.2f%n", troco);
                    }
                    break;

                case 3:
                    exibirRegistroVendas();
                    break;

                case 4:
                    System.out.println("\nObrigado por usar a calculadora da Dona Gabrielinha!");
                    System.out.println("Volte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, escolha entre 1 e 4.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}