package hiyen;

import static org.junit.jupiter.api.Assertions.*;

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
}
