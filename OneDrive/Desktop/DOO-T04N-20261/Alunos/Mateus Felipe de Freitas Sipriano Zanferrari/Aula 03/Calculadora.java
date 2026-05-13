
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {

    public static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nMENU LOJA");
            System.out.println("1- Calcular Preço");
            System.out.println("2- Calcular Troco");
            System.out.println("3- Registro de Vendas");
            System.out.println("4- Sair");

            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite a quantidade de itens:");
                    int quant = scan.nextInt();
                    System.out.println("Digite o valor do iten:");
                    double valunid = scan.nextDouble();
                    double precototal = calculopreco(quant, valunid);
                    if (quant > 10) {
                        System.out.println("Preco total R$" + precototal * 0.95);
                    } else {
                        System.out.println("Preco total R$" + precototal);
                    }
                    registroVendas.add(new Venda(quant, valunid));

                    System.out.println("Venda Registrada!");
                    break;

                case 2:
                    System.out.println("Digite o valor recebido:");
                    double valrecebido = scan.nextDouble();
                    System.out.println("Digite o valor total da compra:");
                    double valcompra = scan.nextDouble();
                    double troco = calculoTroco(valrecebido, valcompra);
                    System.out.println("Troco da Compra R$" + troco);
                    break;

                case 3:
                    System.out.println("\n ---  REGISTRO DE VENDAS  ---");
                    if (registroVendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada!");
                    } else {
                        for (Venda venda : registroVendas) {
                            System.out.println("Quantidade: " + venda.getQuant()
                                    + ", Preco Unitario: R$ " + venda.getValunid()
                                    + ", Valor Final: R$ " + venda.getValorFinal());
                        }

                    }
                    break;

                case 4:
                    System.out.println("Fechando calculadora!");
                    break;

            }
        } while (escolha != 4);

        scan.close();
    }

    public static double calculopreco(int quant, double valunid) {
        return quant * valunid;
    }

    public static double calculoTroco(double valrecebido, double valcompra) {
        return valrecebido - valcompra;
    }

}
