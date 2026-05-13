package atividade02vendas;

public class Troco {
	public double ValorPago;
	public double valorProduto;
public  Troco(double ValorPago, double valorProduto) {
	if(ValorPago >= valorProduto) {
		double resposta = (ValorPago - valorProduto);
		System.out.println("O valor é: ");
		System.out.println(resposta);
	}
	else {
		System.out.println("O valor é menor que o pago");
		double resposta = ( valorProduto - ValorPago);
		System.out.println("O valor é menor que o pago devendo ser completado em:");
		System.out.println(resposta);
	}
}
}
