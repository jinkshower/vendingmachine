package hiyen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendingMachineTest {
    private VendingMachine vendingMachine;

    @BeforeEach
    void setup() {
        vendingMachine = new VendingMachine();
    }

    @Test
    void 이름으로_음료수를_반환_받을_수_있다() {
        //given
        String wanted = "Coke";

        //when
        Drink pop = vendingMachine.pop(wanted);

        //then
        pop.drink();
    }
}
