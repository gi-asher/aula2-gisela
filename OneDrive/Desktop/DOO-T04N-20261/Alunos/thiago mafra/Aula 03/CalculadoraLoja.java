package Aulas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraLoja {

    static class Venda {
        int quantidade;
        double precoUnitario;
        double valorTotal;
        double desconto;

        Venda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
        }

        @Override
        public String toString() {
            return "Quantidade: " + quantidade +
                   ", Preço Unitário: R$ " + precoUnitario +
                   ", Valor Total: R$ " + valorTotal +
                   ", Desconto Aplicado: R$ " + desconto;
        }
    }

    private static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Calculadora da Dona Gabrielinha ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Ver Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    mostrarRegistroVendas();
                    break;
                case 4:
                    System.out.println("Encerrando a calculadora. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double valorBruto = quantidade * precoUnitario;
        double desconto = 0;

        if (quantidade > 10) {
            desconto = valorBruto * 0.05;
        }

        double valorFinal = valorBruto - desconto;

        System.out.println("Valor bruto da compra: R$ " + valorBruto);
        if (desconto > 0) {
            System.out.println("Desconto especial aplicado: R$ " + desconto);
        }
        System.out.println("Preço final da compra: R$ " + valorFinal);

        registroVendas.add(new Venda(quantidade, precoUnitario, valorFinal, desconto));
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();

        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scanner.nextDouble();

        double troco = valorRecebido - valorCompra;

        if (troco < 0) {
            System.out.println("Valor insuficiente! Faltam R$ " + (-troco));
        } else {
            System.out.println("Troco a ser dado: R$ " + troco);
        }
    }

    public static void mostrarRegistroVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada até o momento.");
        } else {
            System.out.println("\n=== Registro de Vendas ===");
            for (Venda venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }
}