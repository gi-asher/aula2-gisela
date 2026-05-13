package calculadora.service;

import java.util.Scanner;

public class MenuService {

    Scanner scan = new Scanner(System.in);
    CalculadoraService calculadora = new CalculadoraService();

    public void exibirMenu() {

        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n===== SISTEMA DA FLORICULTURA =====");
            System.out.println("[1] - Registrar Venda");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Listar Vendas");
            System.out.println("[4] - Sair");

            opcao = scan.nextInt();

            switch (opcao) {

                case 1:
                    calculadora.registrarVenda();
                    break;

                case 2:
                    calculadora.calcularTroco();
                    break;

                case 3:
                    calculadora.listarVendas();
                    break;

                case 4:
                    System.out.println("Sistema encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}