package hiyen;

public class NameAndPriceGenerator implements DrinkGenerator {
    private final String name;
    private final int price;

    public NameAndPriceGenerator(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Drink generate() {
        return new Drink(name, price) {
            @Override
            public String drink() {
                return "This is " + name;
            }
        };
    }
}
