import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PedidoTest {

@Test
public void naoAdicionaPizzaEmPedidoFechado() {
    // Arrange
    Pedido pedido = new PedidoLocal();
    pedido.adicionarPizza(new Pizza());
    pedido.fecharPedido();

    // Act
    int quantidade = pedido.adicionarPizza(new Pizza());

    // Assert
    assertEquals(1, quantidade);
}


}