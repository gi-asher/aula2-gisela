import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aula3 {
   
    static class Venda {
        private double quantidade;
        private double precoUnitario;
        private double desconto;
        private double total;

        public Venda(double quantidade, double precoUnitario, double desconto, double total) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.desconto = desconto;
            this.total = total;
        }

     
        public double getQuantidade() {
            return quantidade;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }

        public double getDesconto() {
            return desconto;
        }

        public double getTotal() {
            return total;
        }
    }

    
    private static List<Venda> registroDeVendas = new ArrayList<>();
  
    private static double ultimoTotalCalculado = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
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
                    exibirRegistroDeVendas();
                    break;
                case 4:
                    System.out.println("Encerrando a calculadora. Obrigada pela visita!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

   
    private static void exibirMenu() {
        System.out.println("\n== Loja de Plantas da Dona Gabrielinha ==");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Ver Registro de Vendas");
        System.out.println("[4] - Sair");
    }

    
    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Quantidade vendida: ");
        double quantidade = scanner.nextDouble();
        System.out.print("Preço unitário: R$ ");
        double precoUnitario = scanner.nextDouble();

        double totalSemDesconto = quantidade * precoUnitario;
        double desconto = 0.0;
        double totalComDesconto = totalSemDesconto;

        if (quantidade > 10) {
            desconto = totalSemDesconto * 0.05;
            totalComDesconto = totalSemDesconto - desconto;
            System.out.printf("Desconto especial aplicado: R$ %.2f\n", desconto);
        }

        System.out.printf("Preço total da venda: R$ %.2f\n", totalComDesconto);

        Venda venda = new Venda(quantidade, precoUnitario, desconto, totalComDesconto);
        registroDeVendas.add(venda);
        ultimoTotalCalculado = totalComDesconto;
    }

  
    private static void calcularTroco(Scanner scanner) {
        System.out.print("Valor recebido do cliente: R$ ");
        double valorRecebido = scanner.nextDouble();

        double valorTotalCompra = ultimoTotalCalculado;
        if (valorTotalCompra == 0.0) {
            System.out.print("Valor total da compra: R$ ");
            valorTotalCompra = scanner.nextDouble();
        }

        double troco = valorRecebido - valorTotalCompra;
        System.out.printf("Troco a ser devolvido: R$ %.2f\n", troco);
    }

    
    private static void exibirRegistroDeVendas() {
        if (registroDeVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada ainda.");
        } else {
            System.out.println("\n== Registro de Vendas ==");
            for (int i = 0; i < registroDeVendas.size(); i++) {
                Venda venda = registroDeVendas.get(i);
                System.out.printf("Venda %d: Quantidade: %.0f, Preço Unitário: R$ %.2f, Desconto: R$ %.2f, Total: R$ %.2f\n",
                        i + 1, venda.getQuantidade(), venda.getPrecoUnitario(), venda.getDesconto(), venda.getTotal());
            }
        }
    }
}
