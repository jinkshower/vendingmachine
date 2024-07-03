package hiyen.product;

import java.util.Objects;

public abstract class Food implements Product {

    private final String name;
    private final int price;

    public Food(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public static Food from(final String name, final int price) {
        return new Food(name, price) {
        };
    }

    @Override
    public String consume() {
        return "Yummy " + name;
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
        final Food food = (Food) object;
        return price == food.price && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
