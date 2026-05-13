package aula02java;

import java.util.Scanner;

public class Aula02 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n== Loja de Plantas da Dona Gabrielinha ==");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            
            switch (opcao) {
                case 1:
                    calcularPrecoTotal(entrada);
                    break;
                case 2:
                    calcularTroco(entrada);
                    break;
                case 3:
                    System.out.println("Encerrando a calculadora. Obrigada pela visita!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 3);
        
        entrada.close();
    }
    
    private static void calcularPrecoTotal(Scanner entrada) {
        System.out.print("Quantidade vendida: ");
        double quantidade = entrada.nextDouble();
        System.out.print("Preço unitário: R$ ");
        double preco = entrada.nextDouble();
        double total = quantidade * preco;
        System.out.printf("Preço total da venda: R$ %.2f\n", total);
    }
    
    private static void calcularTroco(Scanner entrada) {
        System.out.print("Valor recebido do cliente: R$ ");
        double recebido = entrada.nextDouble();
        System.out.print("Valor total da compra: R$ ");
        double total = entrada.nextDouble();
        double troco = recebido - total;
        System.out.printf("Troco a ser devolvido: R$ %.2f\n", troco);
    }
}