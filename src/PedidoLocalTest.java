import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PedidoLocalTest {

@Test
public void calculaTaxaDeServico() {
    // Arrange
    PedidoLocal pedido = new PedidoLocal();
    Pizza pizza = new Pizza();

    pedido.adicionarPizza(pizza);

    // Act
    double valor = pedido.precoAPagar();

    // Assert
    assertEquals(pedido.valorPizzas() * 1.1, valor, 0.01);
}


}