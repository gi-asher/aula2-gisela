package fag;

import java.util.Scanner;
import java.util.Locale;

public class Principal {
	private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		boolean sair = false;

		while (sair == false) {
			System.out.println("Bem vindo a calculadora capaz de realizar as seguintes operações");

			System.out.println("[1] - Calcular Preço Total");
			System.out.println("[2] - Calcular Troco");
			System.out.println("[3] - Sair");
			final int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					System.out.println("Informe a quantidade de planta: ");
					final int quantidadePlanta = scanner.nextInt();

					System.out.println("Informe o valor unitário da planta: ");
					final float valorPlantaUnitario = scanner.nextFloat();

					final float resultadoCalculoPrecoTotal = calculoPrecoTotal(quantidadePlanta, valorPlantaUnitario);

					System.out.printf("O valor total é de: %.2f\n\n", resultadoCalculoPrecoTotal);
					break;
				case 2:
					System.out.println("Informe o valor recebido pelo cliente: ");
					final float valorRecebidoCliente = scanner.nextFloat();

					System.out.println("Informe o valor total da compra: ");
					final float valorTotalCompra = scanner.nextFloat();

					final float resultadoTroco = calculoTroco(valorRecebidoCliente, valorTotalCompra);

					if (resultadoTroco > 0) {
						System.out.printf("O valor do troco é de: %.2f\n\n", resultadoTroco);
					} else if(resultadoTroco == 0) {
						System.out.println("Não é necessário dar troco de volta!");
					} else {
						System.out.println("Valor Insuficiente da parte do cliente.");
						System.out.printf("Valor faltante: %.2f\n\n", Math.abs(resultadoTroco));
					}
					break;
				case 3:
					System.out.println("Volte sempre!");
					sair = true;
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
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
