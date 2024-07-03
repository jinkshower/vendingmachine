package hiyen;

public class Coke extends Drink {
    public Coke(final String name, final int price) {
        super(name, price);
    }

    @Override
    public String drink() {
        return "This is Coke";
    }
}
