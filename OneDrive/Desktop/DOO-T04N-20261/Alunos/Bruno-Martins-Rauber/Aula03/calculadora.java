package metodos;
import java.util.Scanner;

public class calculadora {

	public static void main(String[] args) {
		Scanner Compra = new Scanner(System.in);
		int Op = 0;
		double resultado = 0;
		int Quantidade = 0;
		double Desconto = 5.0 / 100.0;
		double pago = 0;
		double total = 0;

		while (Op != 3) {
			System.out.println("1- Calcular Preço total");
			System.out.println("2- Calcular Troco");
			System.out.println("3- Sair");
			System.out.print("Escolha: ");

			Op = Compra.nextInt();

			if (Op == 1) {
				System.out.println("Quantidade de plantas");
				Quantidade = Compra.nextInt();

				System.out.println("Preço unidade: ");
				double preco = Compra.nextDouble();

				resultado = Quantidade * preco;
				System.out.println("Total da venda: R$ " + resultado);

			} else if (Op == 2) {
				
				if (Quantidade >= 10) {
					total = resultado - (resultado * Desconto);
					System.out.println("Valor com desconto: R$ " + total);
				} else {
					total = resultado;
					System.out.println("Valor total: R$ " + total);
				}

				
				System.out.print("Valor pago pelo cliente: ");
				pago = Compra.nextDouble();

				while (pago < total) {
					System.out.println("Valor insuficiente! O total é R$ " + total);
					System.out.print("Por favor, informe um valor maior ou igual ao total: ");
					pago = Compra.nextDouble();
				}

				double troco = pago - total;
				System.out.println("Troco a devolver: R$ " + troco);
				System.out.println("\n");

			} else if (Op == 3) {
				System.out.println("Sistema encerrado. Boas vendas!");
			} else {
				System.out.println("Opção inválida!");
			}
		}
		Compra.close();
	}
}