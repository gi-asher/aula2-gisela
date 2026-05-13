import java.util.Scanner;

public class CalculadoraPlantas {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int opcao = 0;
        double total = 0;

        while (opcao != 3) {

            System.out.println("Calculadora da loja da Dona Gabrielinha");
            System.out.println("[1] - Calcular preço total");
            System.out.println("[2] - Calcular troco");
            System.out.println("[3] - sair");
            System.out.println("Escolha umas da opção : ");

            opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.println("Digite a quantidade de plantas :");
                int quantidade = scan.nextInt();

                System.out.println("Digite o valor das plantas : ");
                double valor = scan.nextDouble();

                total = quantidade * valor;

                System.out.println("O total a pagar é de R$ " + total);
            } else if (opcao == 2) {
                System.out.println("Digite o valor pago pelo cliente : ");
                double pago = scan.nextDouble();

                double troco = total - pago;

                System.out.println("Troco: R$ " + troco);
            } else if (opcao == 3) {
                System.out.println("-Saindo do sistema-");
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scan.close();
    }
}