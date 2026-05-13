package Calculadora;
import java.util.Scanner;

public class Principal {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int menu = 0;
		while (menu != 3) {

			System.out.println("1 - Calcular Preço Total\n2 - Calcular Troco\n3 - Sair");

			menu = scanner.nextInt();

			float precoTotal = 0;

			switch (menu) {

			case 1:
				precoTotal();
				break;

			case 2:
				troco();
				break;

			case 3:
				System.out.println("fim");
				break;

			default:
				System.out.println("Esta opção não é válida, tente novamente!\n");
			} 
		}
	}



	public static void precoTotal() {
		System.out.println("informe a quantidade de plantas:");
		float quantidade = scanner.nextFloat();

		System.out.println("informe o valor da planta:");
		float precoUnitario = scanner.nextFloat();

		float precoTotal = quantidade * precoUnitario;
		System.out.println("o valor total da compra: " + precoTotal);

	}

	public static void troco() {
		System.out.println("informe o valor entregue pelo cliente:");
		float valorDoCliente = scanner.nextFloat();

		System.out.println("informe o valor total da compra:");
		float valorCompra = scanner.nextFloat();

		float troco = valorDoCliente - valorCompra;

		System.out.println(" Valor do troco: " + troco);
		
	}
	}