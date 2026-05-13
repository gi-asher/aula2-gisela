import java.util.Scanner;

public class CalculadoraDonaGabrielinha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao =0;

        while (opcao!=3){
            System.out.println("\n Loja de Plantas da Dona Gabrielinha  ");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite a quantidade de plantas");
                    int quantidade = scanner.nextInt();

                    System.out.println("Digite o preco da planta");
                    double preco = scanner.nextDouble();

                    double total = preco * quantidade;

                    System.out.println("Preco total da compra: R$ " + total);

                case 2:
                    System.out.println("Digite o valor pago pelos clientes");
                    double pago = scanner.nextDouble();

                    System.out.println("Digite o valor total da compra");
                    double valorCompra = scanner.nextDouble();

                    double troco = pago - valorCompra;

                    System.out.println("Valor total do troco: R$ " + troco);

                case 3:
                    System.out.println("Encerrando Sistema. OBRIGADO");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }
        scanner.close();
    }

}