package calculadora;

import java.util.Scanner;

public class main {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Menu();
	}
	
	public static void Menu() {
		int opt = 0;
		while (opt!=3) {
			System.out.println("Entre com a opção desejada");
			System.out.println("1-Calcular Preço Total");
			System.out.println("2-Calcular Troco");
			System.out.println("3-Sair");
			opt = scan.nextInt();
			scan.nextLine();
			switch(opt) {
			case 1:
				CalcularPreco();
				break;
			case 2:
				CalcularTroco();
				break;
			case 3:
				break;
			default:
				System.out.println("Opção Invalida, porfavor tente novamente");
			}
		}
	}
	
	public static void CalcularPreco() {
		System.out.println("Entre com o valor da Planta:");
		float vl = scan.nextFloat();
		scan.nextLine();
		System.out.println("Entre com a quantidade de Plantas:");
		int qtd = scan.nextInt();
		scan.nextLine();
		float vlt = vl * qtd;
		System.out.println("O Valor Total da Compra de Plantas é: " + vlt);		
	}
	
	public static void CalcularTroco() {
		 System.out.println("Entre com o Valor Recebido:");
		 float vlr = scan.nextFloat();
		 System.out.println("Entre com o Preço da Compra de Plantas");
		 float vlt = scan.nextFloat();
		 float vltr = vlr - vlt;
		 System.out.println("O Valor do Troco é: " + vltr);
	}
}
