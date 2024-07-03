package hiyen;

import static org.junit.jupiter.api.Assertions.*;

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
    void 이름으로_음료수를_반환_받을_수_있다() {
        //given
        String wanted = "Coke";
        String expected = "This is Coke";

        //when
        Drink pop = vendingMachine.pop(wanted);
        String message = pop.drink();
        console.print(message);

        //then
        assertEquals(expected, console.getInputs().get(0));
    }

    @Test
    void 다른_종류의_음료수를_추가할_수_있다() {
        //given
        vendingMachine.add(new Drink("Lemonade", 800) {
            @Override
            public String drink() {
                return "This is Lemonade";
            }
        });

        //when
        Map<Drink, Integer> store = vendingMachine.getStore();

        //then
        assertEquals(4, store.size());
    }
}
