import java.util.ArrayList;

public class RegistroVenda {
    ArrayList<Float> registros = new ArrayList<>();
    
    public void registrarVenda(float valor){
        registros.add(valor);


    }

    public void exibirRegistros() {
    System.out.println("--- Histórico de Vendas ---");
    for (int i = 0; i < registros.size(); i++) {
        System.out.println("Venda " + (i + 1) + ": R$ " + registros.get(i));
    }
}


    
}

