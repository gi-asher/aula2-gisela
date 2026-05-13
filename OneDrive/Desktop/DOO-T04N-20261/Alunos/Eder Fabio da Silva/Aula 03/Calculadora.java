import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculadora {
   
    private static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{          
        
        System.out.println("MENU DA CALCULADORA");
        System.out.println("[1] Calcular Preco Total");
        System.out.println("[2] Calcular Troco");
        System.out.println("[3] Relatorio de Vendas");
        System.out.println("[4] Sair");
        
        opcao = scanner.nextInt();       
            
        switch (opcao) {

            case 1:
                System.out.print("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                System.out.print("Digite o preco unitario R$ ");
                double precoUnitario = scanner.nextDouble();
                double precoTotal = calcularPrecoTotal(precoUnitario, quantidade);
                if (quantidade > 10) {
                    System.out.println("Preco total R$ " + precoTotal * 0.95);
                } else {
                    System.out.println("Preco total R$ " + precoTotal);
                }
                registroVendas.add(new Venda(precoUnitario, quantidade));

                System.out.println("Venda registrada com sucesso!");
                break;
            case 2:
                System.out.print("Digite o valor recebido R$ ");
                double valorPago = scanner.nextDouble();
                System.out.print("Digite o valor total da compra R$ ");
                double precoTotal2 = scanner.nextDouble();
                double troco = calcularTroco(valorPago, precoTotal2);
                System.out.println("Troco R$ " + troco);
                break;
            case 3:
                System.out.println("\n -------HISTORICO DE VENDAS-------");
                if (registroVendas.isEmpty()) {
                    System.out.println("Nenhuma venda registrada.");
                } else {
                    for (Venda venda : registroVendas) {
                        System.out.println("Quantidade: " + venda.getQuantidade() +
                        ", Preco Unitario: R$ " + venda.getPrecoUnitario() +
                        ", Valor Final: R$ " + venda.getValorFinal());
                    }
                    
                }
                
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }


    }while (opcao != 4);

        scanner.close();
    }
    

    public static double calcularPrecoTotal(double precoUnitario, int quantidade) {
        return precoUnitario * quantidade;
    }     

    public static double calcularTroco(double valorPago, double precoTotal2) {
        return valorPago - precoTotal2;
    }
    
}
