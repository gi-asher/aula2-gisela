import java.util.Scanner;

public class calculadora {
    public static Scanner abobora = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha = 0;
        float qtd =0f;
        float prcUni = 0f;
        
        

        while (escolha != 3) {
            System.out.println("Escolha uma operaçao ");
            System.out.println("  [1] - Calcular Preço Total");
            System.out.println("  [2] - Calcular Troco");
            System.out.println("  [3] - Sair");

            System.out.print("Qual sua escolha ");
            escolha = abobora.nextInt();

            if (escolha == 1) {
                System.out.print("Quantidade do produto  ");
                qtd = abobora.nextFloat();
                System.out.print("Digite o preço unitario  ");
                prcUni = abobora.nextFloat();

                float resultado = Calcular.calcularPrecoTotal(qtd, prcUni);

                System.out.println("O valor total da compra e "+ resultado);

            }

            if (escolha == 2) {
                System.out.print("Qual o valor de Entrada  ");
                float entrada = abobora.nextFloat();
                
                float resultado = Calcular.calcularPrecoTotal(qtd, prcUni);

                float troco = Calcular.calcularTroco(resultado, entrada);

                System.out.println("Seu troco e de " + troco);
            }

        }

    }

}

class Calcular {
    public static float calcularPrecoTotal(float qtd, float prcUni) {
        float resultado = qtd * prcUni;
        return resultado;
    }

    public static float calcularTroco(float resultado, float entrada) {
        float troco = entrada - resultado;
        return troco;
    }

}


