package calculadora;

import java.util.Scanner;
import calculadora.Venda;
import java.util.List;
import java.util.ArrayList;

public class main {

	static Scanner scan = new Scanner(System.in);
	static List<Venda> Venda = new ArrayList<>();
	
	public static void main(String[] args) {
		Menu();
	}
	
	public static void Menu() {
		int opt = 0;
		while (opt!=4) {
			System.out.println("Entre com a opção desejada");
			System.out.println("1-Calcular Preço Total");
			System.out.println("2-Calcular Troco");
			System.out.println("3-Listagem de Vendas");
			System.out.println("4-Sair");
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
				Listagem();
				break;
			case 4:
				break;
			default:
				System.out.println("Opção Invalida, porfavor tente novamente");
			}
		}
	}
	
	private static void Listagem() {
		System.out.println("    ||  ||    ");
		for (int i=0; i < Venda.size(); i++) {
			Venda.get(i).resumo();
		}
	}

	public static void CalcularPreco() {
		Venda venda = new Venda();
		System.out.println("Entre com o valor da Planta:");
		venda.setValorUni(scan.nextFloat());
		scan.nextLine();
		System.out.println("Entre com a quantidade de Plantas:");
		venda.setQtd(scan.nextInt());
		scan.nextLine();
		Venda.add(venda);
		System.out.println("O Valor Total da Compra de Plantas é: " + venda.vlTotal());		
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
