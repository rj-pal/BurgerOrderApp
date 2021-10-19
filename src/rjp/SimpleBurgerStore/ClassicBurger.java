package rjp.SimpleBurgerStore;

public class ClassicBurger extends Burger {

    public ClassicBurger() {
        super("Classic Burger", "Sesame");
        this.price = 10.95;
    }

    @Override
    public void checkOut() { // changes addOns at checkout for final print out in checkOut method.
        this.addOns = 4;
        super.checkOut();
    }

    @Override //keeps addOns field at -1 until final checkout
    protected void setAddOns() {
        this.addOns = -1;
    }

    @Override // prints message to remind customer that add-ons are not allowed.
    public void AddOns(int addOns) {
        System.out.println("I am sorry, but extra toppings are not allowed with the Classic Burger.");
    }
}
