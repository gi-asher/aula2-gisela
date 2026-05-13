package loja_gabrielinha;

import java.util.ArrayList;
import java.util.Scanner;
import objetos.Venda;

public class Principal {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Venda> vendas = new ArrayList<>();

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
			System.out.println("[3] - Registrar Venda");
			System.out.println("[0] - Sair");
			escolhaUsuarioMenu = scan.nextInt();
			validarEscolhaMenu(escolhaUsuarioMenu);
		} while (escolhaUsuarioMenu != 0);
	}

	public static void validarEscolhaMenu(int escolhaUsuarioMenu) {
		// Nova forma de input, na maneira que fiz anteriormente não conseguiria reutilizar as funcoes
		switch (escolhaUsuarioMenu) {
			case 1:
				System.out.println("Qual o valor da planta?");
				float valorProduto = scan.nextFloat();

				System.out.println("Quantas unidades dessa planta você deseja comprar?");
				int qtdProduto = scan.nextInt();

				calcularValorTotal(valorProduto, qtdProduto);
				break;
			case 2:
				System.out.println("Qual o valor total da compra?");
				float valorTotal = scan.nextFloat();
				
				System.out.println("Qual o valor recebido pelo cliente?");
				float valorRecebidoCliente = scan.nextFloat();
				
				calcularTroco(valorTotal, valorRecebidoCliente);
				break;
			case 3:
				System.out.println("Qual o valor da planta?");
				float valorPlanta = scan.nextFloat();

				System.out.println("Quantas unidades dessa planta você deseja comprar?");
				int qtd = scan.nextInt();
				
				registrarVenda(valorPlanta, qtd);
				break;
			case 0:
				System.out.println("Encerrando a execução da loja da Gabrielinha. Obrigado por comprar conosco!");
				break;
			default:
				System.out.println("Opção Inválida. Encerrando o programa.");
				break;
		}
	}

	public static void calcularValorTotal(float valorProduto, int qtdProduto) {
		float desconto = 0;
		float discountPercent = 0;

		if (qtdProduto >= 10) {
			System.out.println(
					"Seu pedido ultrapassou a marca de 10 unidades, você acaba de receber um desconto de 10%!");
			desconto = 0.05f;
			discountPercent = 1 - desconto;
		}

		float valorSemDesconto = 0;
		valorSemDesconto = qtdProduto * valorProduto;
		float valorComDesconto = 0;
		valorComDesconto = qtdProduto * (valorProduto * discountPercent);
		float valorDesconto = valorSemDesconto - valorComDesconto;

		System.out.println("O valor total da sua compra foi: " + valorComDesconto);
		System.out.println("Valor sem desconto: " + valorSemDesconto);
		System.out.println("Valor do desconto: " + valorDesconto);
		
	}

	public static void calcularTroco(float valorTotal, float valorRecebidoCliente) {
		String statusTroco = "";

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
	
	public static Venda registrarVenda(float valorProduto, int qtdProduto) {
	    Venda venda = new Venda();
	    
	    float valorTotal = qtdProduto * valorProduto;
	    float desconto = 0;
	    float valorComDesconto = valorTotal;

	    if (qtdProduto > 10) {
	        desconto = valorTotal * 0.05f;
	        valorComDesconto = valorTotal - desconto;
	    }

	    venda.setQuantidade(qtdProduto);
	    venda.setValorUnitario(valorProduto);
	    venda.setValorTotal(valorTotal);
	    venda.setDesconto(desconto);
	    venda.setValorComDesconto(valorComDesconto);

	    listarVendas(vendas);
	    
	    return venda;
	    
	}
	
	public static void listarVendas(ArrayList<Venda> vendas) {
		float somaTotal = 0;
			
		for (int i = 0; i < vendas.size(); i++) {
			Venda venda = vendas.get(i);
			
			System.out.println("Venda " + (i + 1));
			System.out.println("Valor unitário: " + venda.getValorUnitario());
            System.out.println("Valor total: " + venda.getValorTotal());
            System.out.println("Desconto: " + venda.getDesconto());
            System.out.println("Valor com desconto: " + venda.getValorComDesconto());
            
            somaTotal = somaTotal + venda.getValorUnitario();
		}
		
		System.out.println("Vendas: " + vendas.size());
		System.out.println("Valor total: " + somaTotal);
	}
}