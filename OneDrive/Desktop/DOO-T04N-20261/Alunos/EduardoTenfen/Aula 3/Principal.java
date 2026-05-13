package Aula2;

import java.util.Scanner;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static double Total;
	static double descontoAplicado;
	static double valorBruto;
	static double quantidadeVendida;

	public static void main(String[] args) {
		Menu();

	}

	private static void Menu() {
		System.out.println("Escolha uma opçao abaixo");
		System.out.println("1 - Preço Total:");
		System.out.println("2 - Troco:");
		System.out.println("3 - Registro de venda:");
		System.out.println("4 - Sair");
		int escolha = scan.nextInt();

		switch (escolha) {
		case 1:
			calculoPT();
			System.out.println();
			Menu();
			break;
		case 2:
			Troco();
			System.out.println();
			Menu();
			break;
		case 3:
			registroDeVenda();
			System.out.println();
			Menu();
			break;
		case 4:

			System.out.println("Saindo do sistema!!");
			return;

		default:
			System.out.println("Opcao inválida!!");
			break;
		}
	}

	public static void registroDeVenda() {
		if (Total == 0) {
			System.out.println("Nenhuma venda registrada");
			return;
		}
		System.out.println("Quantidade vendida: " + quantidadeVendida);
		System.out.println("Valor bruto: " + valorBruto);
		System.out.println("Desconto aplicado: " + descontoAplicado);
		System.out.println("Valor final da venda: " + Total);

	}

	public static void Troco() {
		if (Total == 0) {
			System.out.println("Voce ainda não definiu sua compra.");
			return;
		}
		System.out.println("Valor recebido do cliente:");
		double vCliente = scan.nextDouble();
		if (vCliente < Total) {
			System.out.println("Falta um pouco de dinheiro!!");
		} else {
			System.out.println("Seu Troco é " + (vCliente - Total));
		}
	}

	public static void calculoPT() {
		System.out.println("Quantas unidades voce deseja ?");
		int Unid = scan.nextInt();

		if (Unid <= 0) {
			System.out.println("Numero 0 ou negativo não válido");
			return;
		}
		System.out.println("Valor da Unidade da planta:");
		double Valor = scan.nextDouble();

		if (Valor <= 0) {
			System.out.println("Numero 0 ou negativo não válido");
			return;
		}
		valorBruto = Unid * Valor;
		descontoAplicado = 0;

		if (Unid > 10) {
			descontoAplicado = valorBruto * 0.05;
		}
		Total = valorBruto - descontoAplicado;
		quantidadeVendida = Unid;
		if (Unid > 10) {
			System.out.println("Desconto aplicado: " + descontoAplicado);
		}

		System.out.println("VALOR TOTAL: " + Total);
	}

}
