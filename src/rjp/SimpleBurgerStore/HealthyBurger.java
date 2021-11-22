package rjp.SimpleBurgerStore;

public class HealthyBurger extends Burger {

    public HealthyBurger() {
        super("Healthy Veggie Burger", "Brown Rye", false);
        this.salad = true;
    }

    @ Override // allows for an extra two toppings to be selected in this child class only.
    public void AddOns(int addOns) {
        if (addOns == 5) {
            this.addOns = 5;
            setPrice();
            this.nullCount = -1;
            System.out.println("You can choose " + addOns + " toppings.");
        } else if (addOns == 6) {
            this.addOns = 6;
            setPrice();
            this.nullCount = -1;
            System.out.println("You can choose " + addOns + " toppings.");
        } else super.AddOns(addOns);
    }

    @Override // adds to price in this class only for the extra two toppings.
    protected void setPrice() {
        if (this.addOns == 5) {
            super.setPrice();
            this.price = super.getPrice() + 0.5;
        } else if (addOns == 6) {
            super.setPrice();
            this.price = super.getPrice() + 1;
        } else super.setPrice();
    }
}
