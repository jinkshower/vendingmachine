package hiyen;

public class DoctorPepper extends Drink {
    public DoctorPepper(final String name, final int price) {
        super(name, price);
    }

    @Override
    public void drink() {
        System.out.println("This is Doctor Pepper");
    }
}
