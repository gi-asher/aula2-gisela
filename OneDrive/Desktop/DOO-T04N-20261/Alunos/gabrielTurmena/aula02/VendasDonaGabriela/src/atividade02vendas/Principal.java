package atividade02vendas;
import java.util.Scanner;
public class Principal {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int resposta = 0;
while(resposta!= 3) {
	System.out.println(" Seja bem vindo a Venda da Dona Gabriela!");
	System.out.println("PARA:");
	System.out.println("CALCULAR PREÇO TOTAL - 1");
	System.out.println("CALCULAR TROCO DE VENDA - 2");
    System.out.println("Sair - 3 ");
    resposta = sc.nextInt();
sc.nextLine();
switch (resposta) {
case 1:
	System.out.println("Digite o número de unidades vendidas");
	int unidades = sc.nextInt();
	sc.nextLine();
	System.out.println("Digite o valor das unidades");
	double valor = sc.nextDouble();
	sc.nextLine();
	new CalcularVendas(unidades, valor);
	break;
case 2:
	System.out.println("Digite o valor pago");
	double ValorPago = sc.nextDouble();
	sc.nextLine();
	System.out.println("Digite o valor do Produto");
	double ValorProduto = sc.nextDouble();
	sc.nextLine();
	new Troco(ValorPago, ValorProduto);
	break;
case 3:
	System.out.println("Até mais!");
	break;
default:
    System.out.println("Opção inválida!"); 
    break;

				}

		}
sc.close();
	}
}
