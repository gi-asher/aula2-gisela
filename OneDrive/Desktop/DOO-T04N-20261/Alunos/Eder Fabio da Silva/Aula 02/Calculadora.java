
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do{          
        
        System.out.println("MENU DA CALCULADORA");
        System.out.println("[1] Calcular Preco Total");
        System.out.println("[2] Calcular Troco");
        System.out.println("[3] Sair");
        
        opcao = scanner.nextInt();       
            
        switch (opcao) {

            case 1:
                System.out.print("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                System.out.print("Digite o preco unitario R$ ");
                double precoUnitario = scanner.nextDouble();
                double precoTotal = calcularPrecoTotal(precoUnitario, quantidade);
                System.out.println("Preco total R$ " + precoTotal);
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
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }


    }while (opcao != 3);

        scanner.close();
    }
    

    public static double calcularPrecoTotal(double precoUnitario, int quantidade) {
        return precoUnitario * quantidade;
    }     

    public static double calcularTroco(double valorPago, double precoTotal2) {
        return valorPago - precoTotal2;
    }
    
}
