


 class Venda {

        private int quant;
        private double valunid;

    public Venda(int quant, double valunid){
        this.quant = quant;
        this.valunid = valunid;
    }
    public int getQuant(){
        return quant;
    }
    public double getValunid(){
        return valunid;
    }

    public double getValorFinal(){
        double total = valunid*quant;
        return(quant>10) ? total * 0.95 : total;
    }

}



