package rjp.SimpleBurgerStore;

public class DeluxeBurger extends Burger { // note: default beef burger combo with no add-on toppings permitted.
    public DeluxeBurger() {
        super("Deluxe Burger", "Pumpernickel");
        this.price = 12.95;
        this.combo = true;
    }


    @Override
    public void checkOut() { // changes addOns at checkout for final print out in checkOut method.
        this.addOns = 2;
        super.checkOut();
    }

    @Override //keeps addOns field at -1 until final checkout
    protected void setAddOns() {
        this.addOns = -1;
    }

    @Override // prints message to remind customer that add-ons are not allowed.
    public void AddOns(int addOns) {
        System.out.println("I am sorry, but extra toppings are not allowed with the Deluxe Burger.");
    }

}
