package hiyen;

public class DoctorPepper extends Drink {
    public DoctorPepper(final String name, final int price) {
        super(name, price);
    }

    @Override
    public String drink() {
        return "This is Doctor Pepper";
    }
}
