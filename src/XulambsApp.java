import java.util.ArrayList;
import java.util.List;

public class XulambsApp {

    static List<Pizza> pizzas = new ArrayList<>();

    private void cabecalho() {
        IO.println("XULAMBS PIZZA V0.1");
        IO.println("===================");
    }

    private int mensagem(String mensagem){
        return Integer.parseInt(IO.readln(mensagem));
    }

    private int menuprincipal() {
        IO.println("1 - Comprar uma pizza");
        IO.println("2 - Ver pizzas vendidas");
        IO.println("0 - Finalizar");

        return mensagem ("Digite sua opção: ");
    }

    private void comprarPizza() {
        IO.println("1 - Comprando uma pizza");

        int adicionais = escolherIngredientes();

        Pizza novaPizza = new Pizza(adicionais);

        mostrarNota(novaPizza);

        pizzas.add(novaPizza);
    }

    private void mostrarNota(Pizza novaPizza) {
        IO.println("Pizza adicionada!");
        IO.println(novaPizza.gerarCupom());
    }

    private void mostrarPizzas() {
        cabecalho();
        for (Pizza pizza : pizzas) {
            mostrarNota(pizza);
            IO.println();
        }
    }

    private int escolherIngredientes() {
        return mensagem ("Quantos adicionais? ");
    }

    public static void main(String[] args) {
        XulambsApp app = new XulambsApp();

        app.cabecalho();

        int opcao;

        do {
            opcao = app.menuprincipal();

            switch (opcao) {
                case 1 -> app.comprarPizza();
                case 2 -> app.mostrarPizzas();
                case 0 -> IO.println("Encerrando!");
                default -> IO.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}