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
        int totalVendas = 0;
        int totalPlantasVendidas = 0;
        double valorTotalArrecadado = 0;
        double totalDescontos = 0;

        while (console != 4) {
            System.out.println("\nEscolha uma das opções:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registro de Vendas");
            System.out.println("[4] - Sair");
            console = scanner.nextInt();

            switch (console) {
                case 1:
                    System.out.println("Qual é a quantidade de plantas desejadas?");
                    System.out.println("O valor de cada planta é R$3.99");
                    quantidadeDePlantas = scanner.nextInt();
                    double precoSemDesconto = quantidadeDePlantas * 3.99;
                    double desconto = 0;
                    if (quantidadeDePlantas > 10) {
                        desconto = precoSemDesconto * 0.05;
                        precoTotal = precoSemDesconto - desconto;

                        System.out.println("Desconto aplicado: R$ " + desconto);
                        System.out.println("O preço total com 5% de desconto é: R$ " + precoTotal);
                    } else {
                        precoTotal = precoSemDesconto;
                        System.out.println("O preço total é: R$ " + precoTotal);
                    }

                    totalDescontos += desconto;
                    totalVendas++;
                    totalPlantasVendidas += quantidadeDePlantas;
                    valorTotalArrecadado += precoTotal;

                    break;

                case 2:
                    System.out.println("Quantos reais o cliente pagou?");
                    dinheiroPago = scanner.nextDouble();
                    if (dinheiroPago < precoTotal) {
                        System.out.println("O valor não é suficiente!");
                    } else {
                        troco = dinheiroPago - precoTotal;
                        System.out.println("O troco é: R$ " + troco);
                    }
                    break;

                case 3:
                    System.out.println("REGISTRO DE VENDAS");
                    System.out.println("Total de vendas: " + totalVendas);
                    System.out.println("Total de plantas vendidas: " + totalPlantasVendidas);
                    System.out.println("Valor total arrecadado: R$ " + valorTotalArrecadado);
                    System.out.println("Total de descontos concedidos: R$ " + totalDescontos);
                    break;

                case 4:
                    System.out.println("Você encerrou o sistema!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}