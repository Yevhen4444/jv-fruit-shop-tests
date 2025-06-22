package core.basesyntax.strategyimpl;

import core.basesyntax.database.FruitStock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BalanceHandlerTest {
    @Test
    void handle_shouldSetBalanceCorrectly() {
        FruitStock fruitStock = new FruitStock();
        BalanceHandler balanceHandler = new BalanceHandler(fruitStock);
        fruitStock.getStock().put("apple", 0);
        balanceHandler.handle("apple", 50);
        Assertions.assertEquals(50, fruitStock.getQuantity("apple"));
    }

}
