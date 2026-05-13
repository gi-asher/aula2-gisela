package fag;

import fag.objetos.Vendas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaLojaGabrielinha {
	static List<Vendas> registroDeVendas = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static double precoTotal = 0;

	public static void main(String[] args) {
		mostrarMenu();
	}

	private static void mostrarMenu() {
		int escolha = 0;
		do {
			System.out.println("\n---------Menu---------");
			System.out.println("1 - Calcular Preço Total");
			System.out.println("2 - Calcular Troco");
			System.out.println("3 - Registro de Vendas");
			System.out.println("0 - Sair");
			escolha = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolha);
		} while (escolha != 0);
	}

	private static void validarEscolha(int escolha) {
		switch (escolha) {

		case 3:
			listarRegistroVendas();
			break;
		case 2:
			calcularTroco(precoTotal);
			break;
		case 1:
			precoTotal = registrarVenda();
			break;
		case 0:
			System.out.println("Sistema Encerrado!");
			break;
		default:
			System.out.println("Digite uma opção válida!");
			break;
		}
	}

	public static double registrarVenda() {
		Vendas venda = criarVenda();
		registroDeVendas.add(venda);

		System.out.println("\n------ Detalhes da Venda: ------");
		venda.mostrarDetalhes();

		return venda.getValorFinal();
	}

	public static Vendas criarVenda() {
		System.out.println("------ Nova Venda ------");

		System.out.print("Preço: R$ ");
		double preco = scan.nextDouble();
		while (preco <= 0) {
			System.out.println("Preço inválido!");
			preco = scan.nextDouble();
		}

		System.out.print("Quantidade: ");
		int quantidade = scan.nextInt();
		while (quantidade <= 0) {
			System.out.println("Quantidade inválida!");
			quantidade = scan.nextInt();
		}

		return new Vendas(quantidade, preco);
	}

	public static void listarRegistroVendas() {
		if (registroDeVendas.isEmpty()) {
			System.out.println("Nenhuma venda registrada!");
			return;
		}

		System.out.println("\n------- Registro de vendas: ------ ");
		for (int i = 0; i < registroDeVendas.size(); i++) {
			System.out.printf("\nVenda %d - ", i + 1);
			registroDeVendas.get(i).mostrarDetalhes();
		}
		System.out.println("\n");
	}

	public static void calcularTroco(double precoTotal) {
		if (precoTotal <= 0) {
			System.out.println("Calcule o preço total primeiro!");
			return;
		}

		System.out.println("------ Calculadora de Troco ------");
		System.out.printf("Valor Total: R$ %.2f\n", precoTotal);

		System.out.print("Valor Pago: ");
		double pagamento = scan.nextDouble();

		while (pagamento < precoTotal) {
			double falta = precoTotal - pagamento;
			System.out.printf("Valor insuficiente! Faltam: R$ %.2f\n", falta);

			System.out.print("Digite novamente o valor pago: ");
			pagamento = scan.nextDouble();
		}

		double troco = pagamento - precoTotal;
		System.out.printf("Valor a ser devolvido: R$ %.2f\n", troco);
	}

}
