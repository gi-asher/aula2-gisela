package calculadora.service;

import java.util.ArrayList;
import java.util.Scanner;
import calculadora.model.Venda;

public class CalculadoraService {

    Scanner scan = new Scanner(System.in);
    ArrayList<Venda> vendas = new ArrayList<>();

    public void registrarVenda() {
        System.out.println("Digite a quantidade de itens vendidos:");
        int quantidadeItens = scan.nextInt();

        System.out.println("Digite o valor do item:");
        double valorPorItem = scan.nextDouble();

        Venda venda = new Venda(quantidadeItens, valorPorItem);

        vendas.add(venda);

        System.out.println("Venda registrada com sucesso!");
        System.out.println("Desconto aplicado: R$ " + venda.getDesconto());
        System.out.println("Valor total: R$ " + venda.getValorTotal());
    }

    public void CalcularPrecoTotal() {

        System.out.println("Digite a quantidade de itens vendidos: ");
        int quantidadeItens = scan.nextInt();

        System.out.println("Digite o valor do item: ");
        double valorPorItem = scan.nextDouble();

        double valorFinal = 0;

        if (quantidadeItens > 10) {
            valorFinal = (quantidadeItens * (valorPorItem * 0.95));
            System.out.println("O valor total é de: R$" + valorFinal);
        } else {
            valorFinal = (quantidadeItens * valorPorItem);
            System.out.println("O valor total é de: R$" + valorFinal);
        }
    }

    public void calcularTroco() {

        System.out.println("Digite o valor recebido:");
        double valorRecebido = scan.nextDouble();

        System.out.println("Digite o valor total da compra:");
        double valorTotalCompra = scan.nextDouble();

        if (valorRecebido < valorTotalCompra) {
            System.out.println("Ainda faltam receber: R$ " + (valorTotalCompra - valorRecebido));
            return;
        }

        if (valorRecebido == valorTotalCompra) {
            System.out.println("Não há necessidade de troco.");
        } else {
            System.out.println("Troco: R$ " + (valorRecebido - valorTotalCompra));
        }
    }

    public void listarVendas() {

        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }

        for (int i = 0; i < vendas.size(); i++) {

            Venda v = vendas.get(i);

            System.out.println("\nVenda " + (i + 1));
            System.out.println("Quantidade: " + v.getQuantidade());
            System.out.println("Preço unitário: R$ " + v.getPreco());
            System.out.println("Desconto: R$ " + v.getDesconto());
            System.out.println("Valor total: R$ " + v.getValorTotal());
        }
    }
}