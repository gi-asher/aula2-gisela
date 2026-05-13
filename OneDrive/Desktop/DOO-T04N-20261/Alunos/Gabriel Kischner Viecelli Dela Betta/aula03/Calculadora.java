import java.util.Scanner;

public class Calculadora {
    public static Scanner abobora = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha = 0;

        Venda venda = new Venda();
        RegistroVenda meuRegis = new RegistroVenda();

        while (escolha != 4) {
            System.out.println("Escolha uma operaçao ");
            System.out.println("  [1] - Calcular Preço Total");
            System.out.println("  [2] - Calcular Troco");
            System.out.println("  [3] - Registro de Vendas");
            System.out.println("  [4] - Sair");

            System.out.print("Qual sua escolha ");
            escolha = abobora.nextInt();

            if (escolha == 1) {
                System.out.print("Quantidade do produto  ");
                float qtd = abobora.nextFloat();
                System.out.print("Digite o preço unitario  ");
                float prcUni = abobora.nextFloat();

                Produto produto = new Produto(qtd, prcUni);

                float resultado = venda.calcularPrecoTotal(produto);

                System.out.println("O valor total da compra e " + resultado);

                meuRegis.registrarVenda(resultado);

            }

            if (escolha == 2) {
                System.out.print("Qual o valor de Entrada  ");
                float entrada = abobora.nextFloat();

                System.out.print("Valor da compra: ");
                float resultado = abobora.nextFloat();

                float troco = venda.calcularTroco(resultado, entrada);

                System.out.println("Seu troco e de " + troco);
            }

            if (escolha == 3) {
                System.out.println("--- Histórico de Vendas ---");
                
                for (Float  i: meuRegis.registros) {
                    System.out.println("Venda: R$ " + i);
                }

            }

        }

    }

}
