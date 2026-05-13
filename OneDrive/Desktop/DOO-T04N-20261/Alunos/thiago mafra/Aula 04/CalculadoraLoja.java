package Aulas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalculadoraLoja {

    static class Venda {
        int quantidade;
        double precoUnitario;
        double valorTotal;
        double desconto;
        LocalDate data;

        Venda(int quantidade, double precoUnitario, double valorTotal, double desconto, LocalDate data) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Data: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                   ", Quantidade: " + quantidade +
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
            System.out.println("[4] - Consultar Vendas por Dia");
            System.out.println("[5] - Consultar Vendas por Mês");
            System.out.println("[6] - Sair");
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
                    consultarVendasPorDia(scanner);
                    break;
                case 5:
                    consultarVendasPorMes(scanner);
                    break;
                case 6:
                    System.out.println("Encerrando a calculadora. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

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

        LocalDate dataVenda = LocalDate.now();
        registroVendas.add(new Venda(quantidade, precoUnitario, valorFinal, desconto, dataVenda));
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

    public static void consultarVendasPorDia(Scanner scanner) {
        System.out.print("Digite a data (dd/MM/yyyy): ");
        scanner.nextLine(); // limpar buffer
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        int total = registroVendas.stream()
                .filter(v -> v.data.equals(data))
                .mapToInt(v -> v.quantidade)
                .sum();

        System.out.println("Total de vendas em " + dataStr + ": " + total);
    }

    public static void consultarVendasPorMes(Scanner scanner) {
        System.out.print("Digite o mês e ano (MM/yyyy): ");
        scanner.nextLine(); // limpar buffer
        String mesAnoStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        LocalDate mesAno = LocalDate.parse("01/" + mesAnoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        int total = registroVendas.stream()
                .filter(v -> v.data.getMonth() == mesAno.getMonth() && v.data.getYear() == mesAno.getYear())
                .mapToInt(v -> v.quantidade)
                .sum();

        System.out.println("Total de vendas em " + mesAnoStr + ": " + total);
    }
}