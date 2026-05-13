import java.util.Scanner;

public class CalculadoraPlantas {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int opcao = 0;
        double total = 0;
        int[] quantidades = new int[100];
        double[] valores = new double[100];
        double[] descontos = new double[100];
        int contadorVendas = 0;

        while (opcao != 4) {
            System.out.println("----------------------------------------");
            System.out.println("Calculadora da loja da Dona Gabrielinha");
            System.out.println("[1] - Calcular preço total");
            System.out.println("[2] - Registro de vendas");
            System.out.println("[3] - Calcular troco");
            System.out.println("[4] - sair");
            System.out.println("----------------------------------------");
            System.out.println("Escolha umas da opção : ");

            opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.println("Digite a quantidade de plantas :");
                int quantidade = scan.nextInt();

                System.out.println("Digite o valor das plantas : ");
                double valor = scan.nextDouble();

                double subtotal = quantidade * valor;
                double desconto = 0;

                if (quantidade > 10) {
                    desconto = subtotal * 0.05;
                }

                total = subtotal - desconto;

                quantidades[contadorVendas] = quantidade;
                valores[contadorVendas] = total;
                descontos[contadorVendas] = desconto;

                contadorVendas++;

                System.out.println("----------------------------------------");
                System.out.println("Subtotal: R$ " + subtotal);
                System.out.println("Desconto: R$ " + desconto);
                System.out.println("Total a pagar: R$ " + total);
                System.out.println("----------------------------------------");

            }else if (opcao == 2) {

                if (contadorVendas == 0) {
                    System.out.println("Nenhuma venda registrada.");
                } else {
                    int totalPlantas = 0;
                    double totalValor = 0;
                    double totalDesconto = 0;
                    for (int i = 0; i < contadorVendas; i++) {

                        System.out.println("----------------------------------------");
                        System.out.println("Venda " + (i + 1));
                        System.out.println("Quantidade: " + quantidades[i]);
                        System.out.println("Valor final: R$ " + valores[i]);
                        System.out.println("Desconto: R$ " + descontos[i]);
                        System.out.println("----------------------------------------");

                        totalPlantas += quantidades[i];
                        totalValor += valores[i];
                        totalDesconto += descontos[i];
                    }
                    System.out.println("----------------------------------------");
                    System.out.println("RESUMO DAS VENDAS");
                    System.out.println("Total de plantas vendidas: " + totalPlantas);
                    System.out.println("Total arrecadado: R$ " + totalValor);
                    System.out.println("Total de descontos: R$ " + totalDesconto);
                    System.out.println("----------------------------------------");
                }
            }else if (opcao == 3) {
                System.out.println("Digite o valor pago pelo cliente : ");
                double pago = scan.nextDouble();

                double troco = pago - total;

                System.out.println("----------------------------------------");
                System.out.println("Troco: R$ " + troco);
                System.out.println("----------------------------------------");

            }else if (opcao == 4) {
                System.out.println("-Saindo do sistema-");
            }else {
                System.out.println("----------------------------------------");
                System.out.println("Opção inválida!");
                System.out.println("----------------------------------------");
            }
        }
        scan.close();
    }
}