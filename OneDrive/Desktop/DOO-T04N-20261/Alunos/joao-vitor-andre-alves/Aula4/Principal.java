package loja_gabrielinha;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import objetos.Venda;

public class Principal {
	LocalDate localDate = LocalDate.now();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
			System.out.println("[3] - Registrar Venda (Data de agora)");
			System.out.println("[4] - Registrar Venda em determinado dia");
			System.out.println("[5] - Buscar venda por dia");
			System.out.println("[6] - Buscar venda por mês");
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
				
				registrarVenda(valorPlanta, qtd, LocalDate.now());
				break;

			case 4:
				System.out.println("Qual o valor da planta?");
				float valorPlantaData = scan.nextFloat();

				System.out.println("Quantas unidades dessa planta você deseja comprar?");
				int qtdData = scan.nextInt();
				scan.nextLine();

                System.out.println("Informe a data da venda (dd/MM/yyyy):");
                String dataTexto = scan.nextLine();
				// futuramente adicionar limpeza no input do usuario		

                LocalDate dataInformada = LocalDate.parse(dataTexto, formatter);
				// transforma string para date usando 'parse'

				registrarVenda(valorPlantaData, qtdData, dataInformada);
				break;
			case 5: 
				buscarVendaPorDia();
				// nao usei parametros pq nao vou reutilizar essa funcao
				break;
			case 6:
				buscarVendaPorMes();
				// nao usei parametros pq nao vou reutilizar essa funcao
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
		float discountPercent = 1;

		if (qtdProduto > 10) {
			System.out.println(
					"Seu pedido ultrapassou a marca de 10 unidades, você acaba de receber um desconto de 5%!");
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

		float valorTroco = valorRecebidoCliente - valorTotal;

		if (valorTroco < 0) {
			statusTroco = "Valor insuficiente.";
		} else if (valorTroco == 0) {
			statusTroco = "Você não tem troco a receber.";
		} else {
			statusTroco = "Troco a pagar: " + valorTroco;
		}

		System.out.println(statusTroco);
	}
	
	public static Venda registrarVenda(float valorProduto, int qtdProduto, LocalDate dataVenda) {
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
		venda.setDataVenda(dataVenda);

		vendas.add(venda);
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
            
            somaTotal = somaTotal + venda.getValorComDesconto();
		}
		
		System.out.println("Vendas: " + vendas.size());
		System.out.println("Valor total: " + somaTotal);
	}
			
	public static void buscarVendaPorDia() {
		scan.nextLine(); // Só pra segurar no caso que for usar essa função após usar o case 4
		System.out.println("Informe a data para busca (dd/MM/yyyy):");
		String dataTexto = scan.nextLine();
	
		LocalDate dataBusca = LocalDate.parse(dataTexto, formatter);
		int quantidadeVendas = 0;
		float totalVendido = 0;
	
		for (Venda venda : vendas) {
			if (venda.getDataVenda().equals(dataBusca)) {
				quantidadeVendas++;
				totalVendido += venda.getValorComDesconto();

				// busca na data completa 2025-01-01
			}
		}
	
		System.out.println("Data pesquisada: " + dataBusca.format(formatter));
		System.out.println("Quantidade de vendas: " + quantidadeVendas);
		System.out.println("Total vendido no dia: " + totalVendido);
	}

	public static void buscarVendaPorMes() {
		scan.nextLine();
		System.out.println("Informe o ano em que quer buscar (Apenas o número [xxxx]):");
		int ano = scan.nextInt();

		System.out.println("Informe o mês que quer buscar (Apenas o número [xx]): ");
		int mes = scan.nextInt();

		int quantidadeDeVendas = 0;
		float totalVendido = 0;

		for (Venda venda : vendas) {
			if (venda.getDataVenda().getMonthValue() == mes && venda.getDataVenda().getYear() == ano) {
				quantidadeDeVendas++;
				totalVendido += venda.getValorComDesconto();
			}

			// busca na data quebrada, só mes e só ano, os usando como condição pro filtro
		}

		System.out.printf("Data pesquisada: %02d/%d%n", mes, ano);
		System.out.println("Total de vendas feita nesse período: " + quantidadeDeVendas);
		System.out.println("Total vendido nesse período: " + totalVendido);
	}
}
