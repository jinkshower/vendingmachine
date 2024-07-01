package hiyen;

public class Cider extends Drink {
    public Cider(final String name, final int price) {
        super(name, price);
    }

    @Override
    public void drink() {
        System.out.println("This is cider");
    }
}
