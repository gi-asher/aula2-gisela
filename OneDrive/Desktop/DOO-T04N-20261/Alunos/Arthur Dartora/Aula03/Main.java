package fag;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> vendas = new ArrayList<>();
		
		int opcao = 0;
		
		while(opcao != 4) {
			System.out.println("Calculadora dona Gabrielinha");
			System.out.println("1 Calcular preço total");
			System.out.println("2 Calcular troco");
			System.out.println("3 Ver registro de vendas");
			System.out.println("4 Sair");
			System.out.println("Escolha uma opcao");
			
			opcao = scan.nextInt();
			
			switch (opcao) {
			
			case 1: {
				
				System.out.println("Digite a quantidade de plantas: ");
				int qtd = scan.nextInt();
				
				System.out.println("Digite o preco da planta: ");
				double preco = scan.nextDouble();
				
				double total = qtd * preco;
				double desconto = 0;
				
				if(qtd > 10) {
					desconto = total * 0.05;
					total = total - desconto;
				}
				
				System.out.println("Total: R$ " + total);
				System.out.println("Desconto: R$ " + desconto);
				
				String registro = "Qtd: " + qtd + " | Preco: " + preco + " | Desconto: " + desconto + " | Total: " + total;
				vendas.add(registro);
				
				break;
			}
			
			case 2: {
				
				System.out.println("Digite o valor pago: ");
				double pago = scan.nextDouble();
				
				System.out.println("Digite o valor total: ");
				double compra = scan.nextDouble();
				
				double troco = pago - compra;
				
				System.out.println("Troco R$ " + troco);
				break;
				
			}
			
			case 3: {
				
				System.out.println("Registro de vendas:");
				
				if(vendas.isEmpty()) {
					System.out.println("Nenhuma venda registrada.");
				}else {
					for(String venda : vendas) {
						System.out.println(venda);
					}
				}
				
				break;
			}
			
			case 4: 
				System.out.println("Saindo...");
				break;
				
			default:
				System.out.println("Opção invalida");
			}
			
			System.out.println();
		}
		scan.close();
	}

}