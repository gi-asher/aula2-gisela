import java.util.Scanner;
public class calculadora {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------------------");
        System.out.println("     Loja de plantas da Dona Gabrielinha    ");
        System.out.println("---------------------------------------------");

        double precoTotal = 0, troco, dinheiroPago;
        int quantidadeDePlantas;
        int console = 0;

        while (console != 3) {
            System.out.println("\nEscolha uma das opções:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            console = scanner.nextInt();

            switch (console) {

                case 1:
                    System.out.println("Qual é a quantidade de plantas desejadas?");
                    System.out.println("O valor de cada planta é R$3.99");
                    quantidadeDePlantas = scanner.nextInt();
                    precoTotal = quantidadeDePlantas * 3.99;
                    System.out.println("O preço total é: R$ " + precoTotal);
                    break;

                case 2:
                    System.out.println("Quantos reais o cliente pagou?");
                    dinheiroPago = scanner.nextDouble();
                    if(dinheiroPago < precoTotal){
                         System.out.println("O valor não é suficiente!");
                    } else {
                    troco = dinheiroPago - precoTotal;
                    System.out.println("O troco é: R$ " + troco);
                    }
                    break;

                case 3:
                    System.out.println("Você encerrou o sistema!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}