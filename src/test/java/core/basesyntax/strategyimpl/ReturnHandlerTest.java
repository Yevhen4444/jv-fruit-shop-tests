package core.basesyntax.strategyimpl;

import core.basesyntax.database.FruitStock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReturnHandlerTest {
    @BeforeEach
    void clearStock() {
        FruitStock.stock.clear();
    }

    @Test
    void handle_shouldIncreaseStock_whenFruitExists() {

        FruitStock fruitStock = new FruitStock();
        ReturnHandler returnHandler = new ReturnHandler(fruitStock);
        fruitStock.add("apple", 10);
        returnHandler.handle("apple", 5);
        Assertions.assertEquals(15, fruitStock.getQuantity("apple"));
    }

    @Test
    void handle_shouldAddFruit_whenFruitNotExists() {
        FruitStock fruitStock = new FruitStock();
        ReturnHandler returnHandler = new ReturnHandler(fruitStock);
        returnHandler.handle("banana", 7);
        Assertions.assertEquals(7, fruitStock.getQuantity("banana"));
    }

    @Test
    void handle_shouldNotChangeStock_whenQuantityIsZero() {
        FruitStock.getAll().clear();
        FruitStock fruitStock = new FruitStock();
        ReturnHandler returnHandler = new ReturnHandler(fruitStock);
        fruitStock.add("apple", 15);
        returnHandler.handle("apple", 0);
        Assertions.assertEquals(15, fruitStock.getQuantity("apple"));
    }

    @Test
    void handle_shouldAddNewFruitToStock_whenFruitNotExists() {
        FruitStock fruitStock = new FruitStock();
        ReturnHandler returnHandler = new ReturnHandler(fruitStock);
        returnHandler.handle("mango", 5);
        Assertions.assertEquals(5, fruitStock.getQuantity("mango"));
    }
}
