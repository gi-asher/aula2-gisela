package fag;
import java.util.Scanner;

public class CalculadoraPlantas {

		static Scanner scan = new Scanner(System.in);
		static double precoTotal = 0;

		public static void main(String[] args) {
			mostrarMenu();
		}

		private static void mostrarMenu() {
			int escolha = 0;
			do {
				System.out.println("\n---------Menu---------");
				System.out.println("1 - Calcular Preço Total");
				System.out.println("2 - Calcular Troco");
				System.out.println("3 - Sair");
				escolha = scan.nextInt();
				scan.nextLine();
				validarEscolha(escolha);
			} while (escolha != 3);
		}

		private static void validarEscolha(int escolha) {
			switch (escolha) {

			case 3:
				System.out.println("Sistema Encerrado!");
				break;
			case 2:
				calcularTroco(precoTotal);
				break;
			case 1:
				precoTotal = calcularPrecoTotal();
				break;

			default:
				System.out.println("Digite uma opção válida!");
				break;
			}
		}

		public static void calcularTroco(double precoTotal) {
			if (precoTotal == 0) {
				System.out.println("Calcule o preço total primeiro!");
				return;
			}
			System.out.println("------ Calculadora de Troco ------");
			System.out.printf("Valor Total: R$ %.2f\n", precoTotal);
			System.out.println("Valor Pago: ");
			double pagamento = scan.nextDouble();

			 while (pagamento < precoTotal) {
			        double falta = precoTotal - pagamento;
			        System.out.printf("Valor insuficiente! Faltam: R$ %.2f\n", falta);

			        System.out.print("Digite novamente o valor pago: ");
			        pagamento = scan.nextDouble();
			    }

			    double troco = pagamento - precoTotal;
			    System.out.printf("Valor a ser devolvido: R$ %.2f\n", troco);
		}

		public static double calcularPrecoTotal() {
			System.out.println("------ Calculadora de Preço - Total ------");
			System.out.printf("Preço: R$");
			double preco = scan.nextDouble();
				while (preco <= 0) {
					System.out.println("Preço inválido! Digite um valor maior que 0.");
					System.out.print("Preço: R$ ");
					preco = scan.nextDouble();
				}

			System.out.printf("Quantidade: ");
			int quantidade = scan.nextInt();
				while (quantidade <= 0) {
					System.out.println("Quantidade inválida! Digite um valor maior que 0.");
					System.out.print("Quantidade: ");
					quantidade = scan.nextInt();
				}

			double precoTotal = preco * quantidade;

			System.out.println("------ Preço Total ------");
			System.out.printf("R$ %.2f\n", precoTotal);
			return precoTotal;

		}
	}


