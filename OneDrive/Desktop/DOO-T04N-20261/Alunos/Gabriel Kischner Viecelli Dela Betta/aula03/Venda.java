public class Venda {
    float desc = 0.05f;

    public float calcularPrecoTotal(Produto produto) {

        float resultado = produto.qtd * produto.prcUni;

        if (produto.qtd > 10) {
            float valorDoDesconto = resultado * desc;
            resultado = resultado - valorDoDesconto;

        }
        return resultado;

    }

    public float calcularTroco(float resultado, float entrada) {
        return entrada - resultado;
    }

}
