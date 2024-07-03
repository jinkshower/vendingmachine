package hiyen;

import hiyen.product.Cider;
import hiyen.product.Coke;
import hiyen.product.DoctorPepper;
import hiyen.product.Product;
import hiyen.product.Twix;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private final Map<Product, Integer> store = new HashMap<>();

    public void initialize() {
        store.put(new DoctorPepper("Doctor Pepper", 600), 5);
        store.put(new Coke("Coke", 400), 5);
        store.put(new Cider("Cider", 500), 5);
        store.put(new Twix("Twix", 300), 5);
    }

    public Product pop(final String name) {
        Product found = store.keySet().stream()
            .filter(it -> it.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("보유 하지 않은 음료수 입니다."));

        store.put(found, store.get(found) - 1);
        return found;
    }

    public void add(final Product product) {
        store.put(product, store.getOrDefault(product, 0) + 1);
    }

    public Map<Product, Integer> getStore() {
        return Collections.unmodifiableMap(store);
    }
}
