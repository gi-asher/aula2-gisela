package fag;

import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import fag.Objetos.VendaPlanta;

public class Principal {
	private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
	static ArrayList<VendaPlanta> vendas = new ArrayList<>();

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		boolean sair = false;

		while (sair == false) {
			System.out.println("Bem vindo a calculadora capaz de realizar as seguintes operações");

			System.out.println("[1] - Visualizar as vendas");
			System.out.println("[2] - Calcular Venda");
			System.out.println("[3] - Sair");
			final int opcao = scanner.nextInt();

			if (opcao == 3) {
				sair = true;
			}

			validarOpcaoEscolhida(opcao);
		}
	}

	private static void validarOpcaoEscolhida(int opcao) {
		switch (opcao) {
			case 1:
				mostraVendas();
				break;
			case 2:
				cadastrarVenda();
				break;
			case 3:
				System.out.println("Volte sempre!");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
	}

	private static void cadastrarVenda() {
		int percentualDesconto = 5;
		boolean temDesconto = false;
		float desconto = 0;
		float troco = 0;

		System.out.println("Informe a quantidade de planta: ");
		final int quantidadePlanta = scanner.nextInt();

		System.out.println("Informe o valor unitário da planta: ");
		final float valorPlantaUnitario = scanner.nextFloat();

		float resultadoCalculoPrecoTotal = calculoPrecoTotal(quantidadePlanta, valorPlantaUnitario);

		if (quantidadePlanta > 10) {
			desconto = resultadoCalculoPrecoTotal / percentualDesconto;
			temDesconto = true;
		}

		resultadoCalculoPrecoTotal -= desconto;

		System.out.printf("O valor total é de: %.2f\n\n", resultadoCalculoPrecoTotal);

		System.out.println("Precisa de troco? (1 -> Sim) (2 -> Não)");
		final int opcao = scanner.nextInt();

		if (opcao == 1) {
			System.out.println("Informe o valor recebido pelo cliente: ");
			final float valorRecebidoCliente = scanner.nextFloat();

			System.out.printf("O valor da compra é: ", resultadoCalculoPrecoTotal);

			final float resultadoTroco = calculoTroco(valorRecebidoCliente, resultadoCalculoPrecoTotal);

			if (resultadoTroco > 0) {
				System.out.printf("O valor do troco é de: %.2f\n\n", resultadoTroco);
				troco = resultadoTroco;
			} else if (resultadoTroco == 0) {
				System.out.println("Não é necessário dar troco de volta!");
			} else {
				System.out.println("Valor Insuficiente da parte do cliente.");
				System.out.printf("Valor faltante: %.2f\n\n", Math.abs(resultadoTroco));
			}
		}

		vendas.add(new VendaPlanta(quantidadePlanta, resultadoCalculoPrecoTotal, desconto, temDesconto,
				troco));
	}

	private static void mostraVendas() {
		System.out.println();

		for (VendaPlanta venda : vendas) {
			venda.mostrarRegistroVendas();
			System.out.println();
		}
	}

	private static float calculoPrecoTotal(int quantidadePlanta, float precoPlanta) {
		float total = 0;

		total = precoPlanta * quantidadePlanta;

		return total;
	}

	private static float calculoTroco(float valorCliente, float valorTotalCompra) {
		float total = 0;

		total = valorCliente - valorTotalCompra;

		return total;
	}

}
