//calculadora plantas da gabriela
import java.util.Scanner;

public class CalculadoraPlantas {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção");
            System.out.println("CALCULADORA DA DONA GABRIELA");
            System.out.println("[1] Calcular total");
            System.out.println("[2] Calcular troco");
            System.out.println("[3] Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Insira a quantidade de plantas: ");
                    int qntd = sc.nextInt();
                    System.out.println("Insira o valor da unidade: ");
                    double prcouni = sc.nextDouble();
                    double ttl = qntd*prcouni;
                    System.out.println("Preço total da compra: R$ "+ ttl);
                    break;

                case 2:
                    System.out.println("Valor pago: ");
                    double recebido = sc.nextDouble();
                    System.out.println("Insira valor da compra: ");
                    double vlrcmpr = sc.nextDouble();
                    double trc = recebido - vlrcmpr;
                    if (trc< 0){
                        System.out.println("Valor insuficiente! Faltam R$ " + (-trc));
                    } else {
                        System.out.println("Troco a ser devolvido: R$ " + trc);
                    }
                    break;

                case 3:
                    System.out.println("Obrigado por utilizar! Até logo! ");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente!");
            }
        }while (opcao != 3);
        sc.close();
    }
}