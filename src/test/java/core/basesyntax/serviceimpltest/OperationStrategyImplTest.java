package core.basesyntax.serviceimpltest;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategyimpl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class OperationStrategyImplTest {

    @Test
    void executeOperation_validOperation_shouldCallHandler() {
        OperationHandler operationHandler = mock(OperationHandler.class);
        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.SUPPLY, operationHandler);
        OperationStrategyImpl strategy = new OperationStrategyImpl(handlers);
        FruitTransaction transaction = new FruitTransaction(Operation.SUPPLY, "apple", 10);
        strategy.executeOperation(transaction, new HashMap<>());
        verify(operationHandler, times(1)).handle("apple", 10);
    }

    @Test
    void executeOperation_unsupportedOperation_shouldThrowException() {
        Map<Operation, OperationHandler> handlers = new HashMap<>();
        OperationStrategyImpl strategy = new OperationStrategyImpl(handlers);
        FruitTransaction transaction = new FruitTransaction(Operation.PURCHASE, "apple", 10);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            strategy.executeOperation(transaction, new HashMap<>());
        });
    }
}
