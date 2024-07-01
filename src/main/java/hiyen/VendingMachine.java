package hiyen;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private static final Map<Drink, Integer> store = new HashMap<>();

    static {
        store.put(new DoctorPepper("Doctor Pepper", 600), 5);
        store.put(new Coke("Coke",400), 5);
        store.put(new Cider("Cider",500), 5);
    }

    public Drink pop(final String drink) {
        Drink found = store.keySet().stream()
            .filter(it -> it.getName().equals(drink))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("보유 하지 않은 음료수 입니다."));

         store.put(found, store.get(found) - 1);
         return found;
    }
}
