package hiyen;

public abstract class Drink {
    private final String name;
    private final int price;

    public Drink(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public abstract String drink();

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
