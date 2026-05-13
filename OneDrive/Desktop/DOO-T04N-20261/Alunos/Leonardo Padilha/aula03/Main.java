package calculadora;
import calculadora.service.MenuService;

public class Main {
    public static void main(String[] args) {
        MenuService menu = new MenuService();
        menu.exibirMenu();
    }
}
