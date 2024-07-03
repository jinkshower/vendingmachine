package hiyen;

public class Cider extends Drink {
    public Cider(final String name, final int price) {
        super(name, price);
    }

    @Override
    public String drink() {
        return "This is Cider";
    }
}
