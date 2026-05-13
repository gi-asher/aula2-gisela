package loja_gabrielinha;

import java.util.Scanner;

	public class Principal {
		static Scanner scan = new Scanner(System.in);
	
		public static void main(String[] args) {
			chamarMenu();
		}
		
		public static void chamarMenu() {
			int escolhaUsuarioMenu = 0;
			do {
				System.out.println("Seja bem vindo(a) à Loja de plantas da Gabrielinha.");
				System.out.println("Escolha a função que quer executar:");
				System.out.println("[1] - Calcular Preço Total");
				System.out.println("[2] - Calcular Troco");
				System.out.println("[3] - Sair");
				escolhaUsuarioMenu = scan.nextInt();
				validarEscolhaMenu(escolhaUsuarioMenu);
			} while (escolhaUsuarioMenu != 3);
		}

		public static void validarEscolhaMenu(int escolhaUsuarioMenu) {
			switch(escolhaUsuarioMenu) {
				case 1:
					calcularValorTotal();
					break;
				case 2:
					calcularTroco();
					break;
				case 3:
					System.out.println("Encerrando a execução da loja da Gabrielinha. Obrigado por comprar conosco!");
					break;
				default:
					System.out.println("Opção Inválida. Encerrando o programa.");
					break;
			}
		}
		
		public static void calcularValorTotal() {
			int qtdProduto = 0;
			float valorProduto = 0;
			
			System.out.println("Qual o valor da planta?");
			valorProduto = scan.nextFloat();
			
			System.out.println("Quantas unidades dessa planta você deseja comprar?");
			qtdProduto = scan.nextInt();
			
			float valorTotal = 0;
			valorTotal = qtdProduto * valorProduto;
					
			System.out.println("O valor total da sua compra foi: " + valorTotal);
		}
		
		public static void calcularTroco() {
			float valorTotal = 0;
			float valorRecebidoCliente = 0;
			String statusTroco;
			
			System.out.println("Qual o valor total da compra?");
			valorTotal = scan.nextFloat();
			
			System.out.println("Qual o valor recebido pelo cliente?");
			valorRecebidoCliente = scan.nextFloat();
			
			float valorTroco = valorRecebidoCliente - valorTotal;
				
			if (valorTroco < 0) {
			    statusTroco = "Valor insuficiente.";
			} else if (valorTroco == 0) {
			    statusTroco = "Você não tem troco a receber.";
			} else {
			    statusTroco = "Troco a pagar: " + valorTroco;
			}
			
			System.out.printf(statusTroco);
		}
}
