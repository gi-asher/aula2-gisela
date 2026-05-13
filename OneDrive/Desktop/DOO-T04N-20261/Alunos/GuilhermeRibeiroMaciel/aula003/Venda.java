package calculadora;

public class Venda {
	private int qtd;
	private float valorUni;
	
	public Venda() {
		
	}
	
	public Venda(float valorUni, int qtd) {
		setValorUni(valorUni);
		setQtd(qtd);
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		if (qtd > 0 ) {
			this.qtd = qtd;
		}
	}
	
	public float getValorUni() {
		return valorUni;
	}
	
	public void setValorUni(float valorUni) {
		if(valorUni > 0.0f) {
			this.valorUni = valorUni;
		}
	}
	
	public double vlTotal() {
		if (qtd>10) {
			return (valorUni - (valorUni * 0.05)) * qtd;
		}else {
			return valorUni * qtd;
		}
	}
	
	public void resumo() {
		System.out.println(valorUni + "||" + qtd + "||" + vlTotal());
	}
}
