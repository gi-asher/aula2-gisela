
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Venda> vendas = new ArrayList<>();

        boolean sair = false;

        while (!sair) {

            System.out.println("\n===== MENU DE OPCOES =====\n");
            System.out.println("[1] - Vender\n");
            System.out.println("[2] - Calcular Troco\n");
            System.out.println("[3] - Ver Relatorio\n");
            System.out.println("[4] - Sair\n");
            System.out.println("===== ===== ===== =====\n");
            System.out.println("Escolha uma opcao: ");

            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1:

                    System.out.print("Informe a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Informe o preco unitario da planta: ");
                    float valorUn = scanner.nextFloat();

                    Venda venda = new Venda(quantidade, valorUn);
                    vendas.add(venda);

                    System.out.printf("Preco total da venda: %.2f\n", venda.getTotal());
                    System.out.printf("Desconto concedido: %.2f\n", venda.getDesconto());

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

                    int totalPlantas = 0;
                    float totalVendas = 0;
                    float totalDescontos = 0;

                    for (Venda v : vendas) {
                        totalPlantas += v.getQuantidade();
                        totalVendas += v.getTotal();
                        totalDescontos += v.getDesconto();
                    }

                    System.out.println("\n===== RELATORIO =====");
                    System.out.println("Quantidade de vendas: " + vendas.size());
                    System.out.println("Total de plantas: " + totalPlantas);
                    System.out.printf("Total vendido: %.2f\n", totalVendas);
                    System.out.printf("Total descontos: %.2f\n", totalDescontos);

                    break;

                case 4:
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
