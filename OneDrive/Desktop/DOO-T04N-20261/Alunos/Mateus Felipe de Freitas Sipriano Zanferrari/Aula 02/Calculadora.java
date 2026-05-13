
import java.util.Scanner;

<<<<<<< HEAD
public class Calculadora{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int escolha;

        do{
        System.out.println("\nMENU LOJA");
=======
public class Calculadora {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int escolha;

        
        System.out.println("MENU LOJA");
>>>>>>> cf4db27edfe5d6db18f164058770ea8fcf67bd6a
        System.out.println("1- Calcular Preço");
        System.out.println("2- Calcular troco");
        System.out.println("3- Sair");

        escolha = scan.nextInt();

<<<<<<< HEAD
        switch (escolha){
=======
        do{
        switch (escolha) {
>>>>>>> cf4db27edfe5d6db18f164058770ea8fcf67bd6a
            case 1: 
            System.out.println("Digite a quantidade de itens:");
            double a = scan.nextDouble();
            System.out.println("Digite o valor do iten:");
            double b = scan.nextDouble();
            double precototal = calculopreco(a, b);
            System.out.println("Preco total R$" + precototal);
                break;

            case 2: 
            System.out.println("Digite o valor recebido:");
            double c = scan.nextDouble();
            System.out.println("Digite o valor total da compra:");
            double d = scan.nextDouble();
<<<<<<< HEAD
            double troco = calculoTroco(c, d);
            System.out.println("Troco da Compra R$" + troco);
                break;

            case 3: 
            System.out.println("Fechando calculadora!");
                break;
            
        }
        }while (escolha !=3);
        
        scan.close();
    }   
    

    public static double calculopreco (double  a, double b){
           
                return a*b;} 

    public static double calculoTroco (double c, double d){
                return c-d;}

}
=======
            double troco = calculotroco(c, d);
            System.out.println("Troco da Compra R$"" + troco);
            calculotroco();
                break;

            case 3: 

                break;
        }
        while (escolha !=3);
    }
}

public static double calculopreco (double  a, double b){
    return a*b;
}

public static double calculotroco (double c, double d){
    return c-d;
}
>>>>>>> cf4db27edfe5d6db18f164058770ea8fcf67bd6a
