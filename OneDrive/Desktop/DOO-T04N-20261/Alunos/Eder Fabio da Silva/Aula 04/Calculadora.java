
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {
    // Lista para armazenar o registro de vendas

    private static List<Venda> registroVendas = new ArrayList<>();
    // Formatador de data para exibição no relatório
    private static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        // Loop para exibir o menu e processar as opções do usuário
        do {
            // Exibe o menu
            System.out.println("MENU DA CALCULADORA V3.0");
            System.out.println("[1] Calcular Preco Total");
            System.out.println("[2] Calcular Troco");
            System.out.println("[3] Relatorio de Vendas");
            System.out.println("[4] Busca Total por data (dd/MM/aaaa)");
            System.out.println("[5] Sair");
            // Lê a opção do usuário       
            opcao = scanner.nextInt();
            // Processa a opção escolhida    
            switch (opcao) {
                // Opção 1: Calcular Preço Total
                case 1:
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preco unitario R$ ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(precoUnitario, quantidade);
                    // Aplica desconto de 5% se a quantidade for maior que 10
                    if (quantidade > 10) {
                        System.out.println("Preco total R$ " + precoTotal * 0.95);
                    } else {
                        System.out.println("Preco total R$ " + precoTotal);
                    }
                    // Registra a venda no histórico
                    registroVendas.add(new Venda(precoUnitario, quantidade));
                    // Exibe mensagem de sucesso
                    System.out.println("Venda registrada com sucesso!");
                    break;
                // Opção 2: Calcular Troco    
                case 2:
                    System.out.print("Digite o valor recebido R$ ");
                    double valorPago = scanner.nextDouble();
                    System.out.print("Digite o valor total da compra R$ ");
                    double precoTotal2 = scanner.nextDouble();
                    double troco = calcularTroco(valorPago, precoTotal2);
                    System.out.println("Troco R$ " + troco);
                    break;
                // Opção 3: Relatório de Vendas
                case 3:
                    System.out.println("\n -------HISTORICO DE VENDAS-------");
                    // Verifica se há vendas registradas e exibe o relatório
                    if (registroVendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (Venda venda : registroVendas) {
                            System.out.println("Data da Venda: "
                                    + venda.getDataVenda().format(formatador)
                                    + ", Quantidade: " + venda.getQuantidade()
                                    + ", Preco Unitario: R$ " + venda.getPrecoUnitario()
                                    + ", Valor Final: R$ " + venda.getValorFinal());
                        }

                    }

                    break;
                // Opção 4: Busca Total por data (dd/MM/aaaa)   
                case 4:
                    System.out.print("Digite a data para busca (dd/MM/yyyy): ");
                    String dataBusca = scanner.next();
                    // Converte a string de entrada para LocalDate
                    try {
                        LocalDate dataBuscaFormatada = LocalDate.parse(dataBusca, formatador);
                        System.out.println("\n -------VENDAS NA DATA " + dataBusca + "-------");
                        boolean encontrouVendas = false;
                        double faturamentoDia = 0.0;

                        // Percorre o registro de vendas e exibe as vendas que correspondem à data buscada
                        for (Venda venda : registroVendas) {
                            if (venda.getDataVenda().equals(dataBuscaFormatada)) {
                                System.out.println("Quantidade: " + venda.getQuantidade()
                                        + ", Preco Unitario: R$ " + venda.getPrecoUnitario()
                                        + ", Valor Final: R$ " + venda.getValorFinal());
                                faturamentoDia += venda.getValorFinal();
                                encontrouVendas = true;
                            }
                            // Exibe mensagem caso nenhuma venda seja encontrada para a data buscada
                        }
                        if (!encontrouVendas) {
                            System.out.println("Nenhuma venda encontrada para esta data.");
                        } else {
                            System.err.println("Faturamento total do dia R$ " + faturamentoDia);
                        }
                        // Trata exceção caso a data seja inválida    
                    } catch (Exception e) {
                        System.out.println("Data invalida! Use o formato dd/MM/yyyy.");
                    }
                    break;
                // Opção 5: Sair do programa
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

            // Continua exibindo o menu até o usuário escolher sair (opção 4)
        } while (opcao != 5);
        // Fecha o scanner
        scanner.close();
    }

    // Método para calcular o preço total.
    public static double calcularPrecoTotal(double precoUnitario, int quantidade) {
        return precoUnitario * quantidade;
    }

    // Método para calcular o troco.
    public static double calcularTroco(double valorPago, double precoTotal2) {
        return valorPago - precoTotal2;
    }

}
