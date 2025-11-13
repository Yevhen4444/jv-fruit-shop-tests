package core.basesyntax.serviceimpltest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.database.FruitStock;
import core.basesyntax.serviceimpl.ReportGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportGeneratorTest {

    @AfterEach
    void setUp() {
        FruitStock.stock.clear();
    }

    @Test
    void generateReport_validStock_shouldReturnCorrectReport() {
        FruitStock fruitStock = new FruitStock();
        fruitStock.add("apple", 10);
        fruitStock.add("banana", 5);
        ReportGenerator reportGenerator = new ReportGenerator(fruitStock);
        String report = reportGenerator.generateReport();
        assertTrue(report.startsWith("fruit,quantity"), "Report should start with header");
        assertTrue(report.contains("apple,10"), "Report should contain apple with correct quantity");
        assertTrue(report.contains("banana,5"), "Report should contain banana with correct quantity");
    }

    @Test
    void generateReport_emptyStock_shouldReturnOnlyHeader() {
        FruitStock fruitStock = new FruitStock();
        ReportGenerator reportGenerator = new ReportGenerator(fruitStock);
        String report = reportGenerator.generateReport();
        assertEquals("fruit,quantity" + System.lineSeparator(), report);
    }
}
