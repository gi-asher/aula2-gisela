import java.util.Scanner;

public class CalculadoraLoja {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while(opcao != 3){

            System.out.println("===== Loja da Dona Gabrielinha =====");
            System.out.println("1 - Calcular Preço Total");
            System.out.println("2 - Calcular Troco");
            System.out.println("3 - Sair");

            opcao = scanner.nextInt();

            if(opcao == 1){

                System.out.println("Digite a quantidade:");
                int quantidade = scanner.nextInt();

                System.out.println("Digite o preço da planta:");
                double preco = scanner.nextDouble();

                double total = quantidade * preco;

                System.out.println("Preço total: " + total);

            }

            else if(opcao == 2){

                System.out.println("Digite o valor pago:");
                double valorPago = scanner.nextDouble();

                System.out.println("Digite o valor da compra:");
                double valorCompra = scanner.nextDouble();

                double troco = valorPago - valorCompra;

                System.out.println("Troco: " + troco);

            }

            else if(opcao == 3){

                System.out.println("Obrigado por usar a calculadora!");

            }

        }

    }