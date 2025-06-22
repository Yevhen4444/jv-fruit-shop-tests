package core.basesyntax.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FruitTransactionTest {

    @Test
    void constructorAndGetters_shouldInitializeCorrectly() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.BALANCE, "apple", 100);
        Assertions.assertEquals(Operation.BALANCE, fruitTransaction.getOperation());
        Assertions.assertEquals("apple", fruitTransaction.getFruit());
        Assertions.assertEquals(100, fruitTransaction.getQuantity());

    }

    @Test
    void toString_shouldReturnCorrectFormat() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.SUPPLY, "banana", 50);
        String expected = "FruitTransaction{operation=SUPPLY, fruit='banana', quantity=50}";
        String actual = fruitTransaction.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void fromCode_b_shouldReturnSupply() {
        Operation operation = Operation.fromCode("b");
        Assertions.assertEquals(Operation.BALANCE, operation);

    }

    @Test
    void fromCode_s_shouldReturnSupply() {
        Operation operation = Operation.fromCode("s");
        Assertions.assertEquals(Operation.SUPPLY, operation);
    }

    @Test
    void fromCode_p_shouldReturnSupply() {
        Operation operation = Operation.fromCode("p");
        Assertions.assertEquals(Operation.PURCHASE, operation);
    }

    @Test
    void fromCode_r_shouldReturnSupply() {
        Operation operation = Operation.fromCode("r");
        Assertions.assertEquals(Operation.RETURN, operation);
    }

    @Test
    void fromCode_invalidCode_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Operation.fromCode("x"));
    }
}
