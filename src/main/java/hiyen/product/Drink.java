package hiyen.product;

import java.util.Objects;

public abstract class Drink implements Product {

    private final String name;
    private final int price;

    public Drink(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public static Drink from(final String name, final int price) {
        return new Drink(name, price) {
        };
    }

    @Override
    public String consume() {
        return "This is " + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Drink drink = (Drink) object;
        return price == drink.price && Objects.equals(name, drink.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
