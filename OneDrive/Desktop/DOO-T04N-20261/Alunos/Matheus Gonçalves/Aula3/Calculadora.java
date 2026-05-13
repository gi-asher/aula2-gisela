package fag;

import java.util.Scanner;

public class Calculadora {
	static Scanner scan = new Scanner(System.in); 
	
	static String[] RegistroVendas = new String[100];
	static int ContadorRegistros;
	
	public static void main(String args[]) {
		Menu();
	}
	
	public static void Menu() {
		System.out.println("-----------------------------------");
		System.out.println("Escolha a Operação");
		System.out.println("[1] - Calcular Preço Total");
		System.out.println("[2] - Calcular Troco");
		System.out.println("[3] - Registro de Vendas");
		System.out.println("[4] - Sair");
		int escolha = scan.nextInt();
		
		switch (escolha) {
			case 1:
				PrecoTotal();
			break;
			
			case 2:
				Troco();
			break;
			
			case 3: 
				Registro();
			break;

			case 4:
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
		
		double desconto = 0.0;
		double total = qtd * vlrunt;
		if (qtd >= 10) {
			System.out.println("Desconto especial aplicado para mais de 10 itens: 5%");
			desconto = total * 0.05;
			total = total - desconto;
		}
		
		System.out.println("o Total é " + total);
		
		RegistroVendas[ContadorRegistros] = "Qtd: " + qtd + " | Valor Unit: " + vlrunt + " | Desconto: " + desconto + " | Total: " + total;
		ContadorRegistros ++;
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
		} else {
			System.out.println("o Troco é de R$" + troco);
		}
	}
	
	public static void Registro() {
		for (int i = 0; i < ContadorRegistros; i++) {
			System.out.println("[" + ContadorRegistros + "] " + RegistroVendas[i]);
		}
	}
}
