package Calculadora;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int opcao = 0;
		
		while(opcao != 3) {
			System.out.println("Calculadora dona Gabrielinha");
			System.out.println("1 Calcular preço total");
			System.out.println("2 Calcular troco");
			System.out.println("3 Sair");
			System.out.println("Escolha uma opcao");
			
			opcao = scan.nextInt();
			
			switch (opcao) {
			case 1: {
				
				System.out.println("Digite a quantidade de plantas: ");
				int qtd = scan.nextInt();
				
				System.out.println("Digite o preco da planta: ");
				double preco = scan.nextDouble();
				
				double total = qtd * preco;
				
				System.out.println("Preco total: R$ " + total);
				break;
				
			}
			
			case 2: {
				
				System.out.println("Digite o valor pago pelo cliente: ");
				double pago = scan.nextDouble();
				
				System.out.println("Digite o valor total: ");
				double compra = scan.nextDouble();
				
				double troco = pago - compra;
				
				System.out.println("Troco R$ " + troco);
				break;
				
			}
			case 3: 
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
