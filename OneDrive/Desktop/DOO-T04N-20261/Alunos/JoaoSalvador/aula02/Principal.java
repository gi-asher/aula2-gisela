import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {

            System.out.println("\n===== MENU DE OPCOES =====\n");
            System.out.println("[1] - Calcular Pre�o Total\n");
            System.out.println("[2] - Calcular Troco\n");
            System.out.println("[3] - Sair\n");
            System.out.println("===== ===== ===== =====\n");
            System.out.println("Escolha uma opcao: ");

            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                	
                    System.out.print("Informe a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Informe o preco unitario da planta: ");
                    float valorUn = scanner.nextFloat();

                    float precoTotal = quantidade * valorUn;

                    System.out.printf("\nPreco total da venda: %.2f\n", precoTotal);
                    break;

                case 2:
                	
                    System.out.print("Informe o valor recebido: ");
                    float valorRecebido = scanner.nextFloat();

                    System.out.print("Informe o valor total da compra: ");
                    float valorCompra = scanner.nextFloat();

                    float troco = valorRecebido - valorCompra;

                    System.out.printf("Valor do troco devido: %.2f\n", troco);
                    break;

                case 3:
                    System.out.println("Voce escolheu sair do menu!\n");
                    sair = true;
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }

        scanner.close();
    }
}