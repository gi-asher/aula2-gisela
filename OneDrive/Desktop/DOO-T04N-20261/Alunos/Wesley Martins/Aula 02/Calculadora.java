import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alternativa = 0;

        while (alternativa != 3) {
            System.out.println("    [1] - Calcular Preço Total\r\n" + //
                    "    [2] - Calcular Troco    \r\n" + //
                    "    [3] - Sair ");
            alternativa = sc.nextInt();

            switch (alternativa) {
                case 1:
                    System.out.println("Digite o preço do produto: ");
                    double valor = sc.nextDouble();
                    System.out.println("Digite a quantidade: ");
                    int quantidade = sc.nextInt();
                    double total = valor * quantidade;
                    System.out.println("O preço total é: " + total);
                    break;
                case 2:
                    System.out.println("Digite o valor pago: ");
                    double valorPago = sc.nextDouble();
                    System.out.println("Digite o valor total: ");
                    double valorTotal = sc.nextDouble();
                    double troco = valorPago - valorTotal;
                    System.out.println("O troco é: " + troco);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }
    }
}