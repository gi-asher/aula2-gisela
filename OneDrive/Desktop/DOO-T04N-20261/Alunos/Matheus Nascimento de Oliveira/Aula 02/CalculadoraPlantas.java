import java.util.Scanner;

public class CalculadoraPlantas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n--- Loja da Dona Gabrielinha ---");
            System.out.println("1 - Calcular Preço Total");
            System.out.println("2 - Calcular Troco");
            System.out.println("3- Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a quantidade de plantas: ");
                int quantidade = scanner.nextInt();
                System.out.print("Digite o preço unitário: ");
                double preco = scanner.nextDouble();
                double total = quantidade * preco;
                System.out.println("O preço total é: R$ " + total);
            } else if (opcao == 2) {
                System.out.print("Digite o valor recebido pelo cliente: ");
                double valorRecebido = scanner.nextDouble();
                System.out.print("Digite o valor total da compra: ");
                double valorCompra = scanner.nextDouble();
                double troco = valorRecebido - valorCompra;
                System.out.println("O troco a ser dado é: R$ " + troco);
            } else if (opcao == 3) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida");
            }
        }
        scanner.close();
    }
}
