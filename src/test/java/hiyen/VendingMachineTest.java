package hiyen;

import static org.junit.jupiter.api.Assertions.*;

import hiyen.product.Drink;
import hiyen.product.Food;
import hiyen.product.Product;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendingMachineTest {
    private VendingMachine vendingMachine;
    private MockConsole console;

    @BeforeEach
    void setup() {
        vendingMachine = new VendingMachine();
        console = new MockConsole();
    }

    @Test
    void 이름으로_상품을_반환_받을_수_있다() {
        //given
        String wanted = "Coke";
        String expected = "This is Coke";

        //when
        Product popped = vendingMachine.pop(wanted);
        String message = popped.consume();
        console.print(message);

        //then
        assertEquals(expected, console.getInputs().get(0));
    }

    @Test
    void 다른_종류의_음료수를_추가할_수_있다() {
        //given
        vendingMachine.add(Drink.from("Pepsi", 100));

        //when
        Map<Product, Integer> store = vendingMachine.getStore();

        //then
        assertEquals(4, store.size());
    }

    @Test
    void 다른_종류의_음식을_추가할_수_있다() {
        //given
        vendingMachine.add(Food.from("Twinkie", 300));

        //when
        Map<Product, Integer> store = vendingMachine.getStore();

        //then
        assertEquals(5, store.size());
    }
}
