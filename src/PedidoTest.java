import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;
    Pizza pizzaVazia;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedido.adicionarPizza(pizzaVazia);
    }

    @Test
    public void adicionaVariasPizzasCorretamente() {
        // Arrange
        Pedido pedido = new Pedido();

        // Act
        pedido.adicionarPizza(new Pizza());
        int quantidade = pedido.adicionarPizza(new Pizza());

        // Assert
        assertEquals(2, quantidade);
    }

    @Test
    public void naoAdicionaPizzaEmPedidoFechado() {
        // Arrange
        pedido.fecharPedido();

        // Act
        int quantidade = pedido.adicionarPizza(new Pizza());

        // Assert
        assertEquals(1, quantidade);
    }

    @Test
    public void calcularValorPedidoCorretamente() {
        //Act
        double preco = pedido.precoAPagar();
        //
        assertEquals(29d, preco, 0.01);
    }

    @Test
    public void calcularPrecoDePedidoComVariasPizzas(){
        //Arrange
        Pizza pizza2Ingrediente = new Pizza(2);
        pedido.adicionarPizza(pizza2Ingrediente);
        //Act
        double preco = pedido.precoAPagar();
        //Assert 
        assertEquals(68d, preco, 0.01);
    }

    @Test
    public void gerarRelatorioPedido(){
        //Act
        String cupom = pedido.relatorio();
        //Assert 
        assertTrue(
            cupom.contains("29,00") &&
            cupom.contains("1 pizza") &&
            cupom.contains("aberto") 
        );
    }
}
