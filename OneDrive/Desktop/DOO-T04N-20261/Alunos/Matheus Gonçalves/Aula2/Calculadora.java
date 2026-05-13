package fag;

import java.util.Scanner;

public class Calculadora {
	static Scanner scan = new Scanner(System.in); 
	
	public static void main(String args[]) {
		Menu();
	}
	
	public static void Menu() {
		System.out.println("-----------------------------------");
		System.out.println("Escolha a Operação");
		System.out.println("[1] - Calcular Preço Total");
		System.out.println("[2] - Calcular Troco");
		System.out.println("[3] - Sair");
		int escolha = scan.nextInt();
		
		switch (escolha) {
			case 1:
				PrecoTotal();
			break;
			
			case 2:
				Troco();
			break;

			case 3:
				System.out.println("Você saiu do sistema...");
				return;

			default:
				System.out.println("Input invalido");
			break;
		}
		Menu();
	}
	
	public static void PrecoTotal() {
		System.out.println("Qual a quantidade do item ?");
		double qtd = scan.nextDouble();
		if (qtd <= 0) {
			System.out.println("quantidade invalida");
			return;
		}
		System.out.println("Qual o valor unitario? ");
		double vlrunt = scan.nextDouble();
		if (vlrunt <= 0) {
			System.out.println("valor invalida");
			return;
		}
		
		double total = qtd * vlrunt;
		
		System.out.println("o Total é " + total);
	}
	
	public static void Troco() {
		System.out.println("Qual o valor pago pelo cliente ?");
		double vlrPago = scan.nextDouble();
		if (vlrPago <= 0) {
			System.out.println("valor invalido");
			return;
		}
		System.out.println("Qual o total da compra ?");
		double vlrTotal = scan.nextDouble();
		if (vlrTotal <= 0) {
			System.out.println("valor invalido");
			return;
		}
		
		double troco = vlrPago - vlrTotal;
		if (troco < 0) {
			System.out.println("Faltam " + troco * -1 + " para completar");
		}
		else {
			System.out.println("o Troco é de R$" + troco);
		}
	}
}
