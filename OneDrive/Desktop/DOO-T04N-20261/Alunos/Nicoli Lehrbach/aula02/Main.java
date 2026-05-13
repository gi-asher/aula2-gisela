import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("=== Calculadora da Loja de Plantas da Dona Gabrielinha ===");
            System.out.println("[1] - Calcular o preco total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            if (opcao == 1) {
                System.out.print("Digite a quantidade da planta escolhida: ");
                int quantidade = sc.nextInt();
                System.out.print("Digite o preco da planta: ");
                double preco = sc.nextDouble();
                double total = quantidade * preco;
                System.out.println("Preco total da venda: R$ %.2f%n", total);
                System.out.println();
            } else if (opcao == 2) {
                System.out.print("Digite o valor pago pelo cliente: ");
                double valorPago = sc.nextDouble();
                System.out.print("Digite o valor total da compra: ");
                double totalCompra = sc.nextDouble();
                double troco = valorPago - totalCompra;
                if (troco < 0) {
                    System.out.println("Valor insuficiente! Faltam R$ " + (-troco));
                } else {
                    System.out.println("Troco: R$ %.2f%n ", troco);
                }
                System.out.println();
            } else if (opcao == 3) {
                System.out.println("Encerrando o sistema...");
            } else {
                System.out.println("Opcao invalida!");
                System.out.println();
            }
        }
        sc.close();
    }
}