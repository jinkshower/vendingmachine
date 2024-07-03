package hiyen.product;

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
}
