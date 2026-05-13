package doo;

import java.util.Scanner;
import java.util.ArrayList;


public class Principal {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> historicoVendas = new ArrayList<>();
	
	public static void main(String[] args) {

		int menu = 0;
		while (menu != 4) {

			System.out.println("\n1 - Calcular Preço Total");
			System.out.println("2 - Calcular Troco");
			System.out.println("3 - Ver registros de venda");
			System.out.println("4 - Sair");

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
				exibirHistorico();
				break;
			case 4:
				System.out.println("fim");
				break;

			default:
				System.out.println("Opção inválida\n");
			} 
		}
	}



	public static void precoTotal() {
		System.out.println("informe a quantidade da planta ");
		float quantidade = scanner.nextFloat();

		System.out.println("informe o valor da planta");
		float precoUnitario = scanner.nextFloat();

		float precoTotal = quantidade * precoUnitario;
		float desconto = 0;
		
		if (quantidade>10) {
			    desconto = precoTotal * 0.05f;
			    precoTotal = precoTotal - desconto;
		
			    System.out.println("\nrecebeu 5% de desconto ao comprar acima de dez unidades");
		}
		
		System.out.println("\no valor total da compra ficou: " + precoTotal);

	    String venda = "Quantidade: " + quantidade +
                " | Preço unitário: " + precoUnitario +
                " | Desconto: " + desconto +
                " | Total pago: " + precoTotal;

	    historicoVendas.add(venda);
	}

	public static void troco() {
		System.out.println("informe o valor entregue pelo cliente");
		float valorDoCliente = scanner.nextFloat();

		System.out.println("informe o valor total da compra");
		float valorCompra = scanner.nextFloat();

		float troco = valorDoCliente - valorCompra;

		System.out.println("\nValor do troco: " + troco);
	
		
	}
	
	  public static void exibirHistorico() {

	        if (historicoVendas.isEmpty()) {
	            System.out.println("Sem vendas registradas ainda.");
	        } else {

	            System.out.println("\n      HISTÓRICO DE VENDAS     ");

	            for (String venda : historicoVendas) {
	                System.out.println(venda);
	            }
	        }
	    

	}
}

	


