package hiyen;

public abstract class Food implements Product {
    private final String name;
    private final int price;

    public Food(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public static Food from(final String name, final int price) {
        return new Food(name, price) {};
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
}
