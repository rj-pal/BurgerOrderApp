package rjp.SimpleBurgerStore;

import java.util.ArrayList;
import java.util.Collections;

public class Burger {
    // private fields used in constructor. protected fields used in child classes.
    private final String name;
    private final String rollType;
    private boolean meat = true;

    protected double price = 8.95;
    protected int nullCount; // field is used to determine the number of add-on toppings for the Extras Class.
    protected int addOns = -1; // default -1 for initial selection before user selects their add-ons.
    protected boolean combo = false;
    protected boolean salad = false;

    // topping fields for add-ons to the burger which are used by Extras Class or pre-set in other classes.
    protected String E1;
    protected String E2;
    protected String E3;
    protected String E4;
    protected String E5;
    protected String E6;

    public final String toppingsList = "cheese, avocado, kale, carrot, tomato, lettuce, onion, ketchup, mustard, " +
            "pickles, jalapenos, beets, and olives.";

    public Burger() {
        this("Basic Burger", "Sesame");
    }

    public Burger(String name, String rollType) { // used in DeluxeBurger and ClassicBurger child class.
        this.name = name;
        this.rollType = rollType;
    }

    public Burger(String name, String rollType, boolean meat) { // used in HealthyBurger child class.
        this.name = name;
        this.rollType = rollType;
        this.meat = meat;
    }

    public int getAddOns() { // used to check if valid number of add-ons was entered. Default -1 for no add-ons.
        return addOns;
    }

    // method used to print a burger made from order before checkout and combo upgrade. burger status printout.
    public void myBurger() {
        System.out.print("\nYou ordered a ");
        if (meat) {
            System.out.print("beef ");
        } else {
            System.out.print("meatless ");
        }
        System.out.print(this.name + " on a " + this.rollType + " roll with");

        if (nullCount == -1) { // null count is only -1 after the AddOns method is called.
            String addOns = (this.addOns == 1) ? this.addOns + " topping" : this.addOns + " toppings";
            System.out.println(" no selected toppings yet.\n\nThe total so far is " + price + ". Please continue " +
                    "with your order.\n\nPlease select " + addOns + " from the list:\n" +
                    toppingsList + "\n");
            return;
        }

        if (addOns == -1) {
            System.out.print(" no extra toppings");
            if ((this.price == 8.95)) {
                System.out.print(". It is Plain Jane");
            } else
                System.out.print(". It has");
        } else if (addOns == 0) {
            System.out.print(" no toppings");
        }

        if (E1 != null) System.out.print(" " + E1);
        if (E2 != null) System.out.print(" and " + E2);
        if (E3 != null) System.out.print(" and " + E3);
        if (E4 != null) System.out.print(" and " + E4);
        if (E5 != null) System.out.print(" and " + E5);
        if (E6 != null) System.out.print(" and " + E6);
        if (combo) System.out.print(".\nIt's a combo and comes with chips and a drink");
        else if (salad) System.out.print(". \nIt comes with a salad");
        else System.out.print(". \nIt comes with a small side order");


        System.out.print(".\n\nThe total so far is " + price + ". Please continue with your order.\n");

    }

    public void checkOut() { // method to finish the order.
        System.out.println("\n***Order Summary***");
        System.out.print("\nYour " + this.name);
        if (isMeat())
            System.out.println(" is 100% Angus Beef.");
        else
            System.out.println(" is meatless.");

        if (addOns == 0) {
            System.out.print("Your burger is Plain Jane");
        } else {
            System.out.print("Your burger has");
            if (E1 != null) System.out.print(" " + E1);
            if (E2 != null) System.out.print(" and " + E2);
            if (E3 != null) System.out.print(" and " + E3);
            if (E4 != null) System.out.print(" and " + E4);
            if (E5 != null) System.out.print(" and " + E5);
            if (E6 != null) System.out.print(" and " + E6);
        }
        System.out.print(". Your burger is on a " + rollType + " roll.\n");

        if (combo)
            System.out.println("Your order includes a Combo with Pickle Chips and Cola. Sorry no substitutions!");
        else
            if (this.salad) {
                System.out.println("Your order includes a house salad and pickles.");

            } else
                System.out.println("Your order includes a small side order of crisps and pickles.");

        System.out.println("\n**** The final total for your order is " + price + " + any applicable taxes. ****");
    }

    /*
    This method sets the number of add-ons to customer's preference if they select Yes in Order Method.
    Field addons remains at -1 otherwise. -1 means no add-on toppings selected by the user, or Deluxe Burger child.
     */
    public void AddOns(int addOns) { // overridden in both Healthy and Deluxe Burger classes.
        this.addOns = (addOns > 0 && addOns <= 4) ? addOns : -1;
        setPrice();
        this.nullCount = -1; //initialize null count for order validation and my burger order update.
        if (this.addOns == -1)
            System.out.println("You cannot choose any extra toppings. Your desired number of " +
                    "toppings is invalid.\nPlease choose between 1 and 4 toppings for a Basic Burger, or up to 6 " +
                    "toppings for a Healthy Burger.");
        else if (this.addOns == 1)
            System.out.println("You can choose " + addOns + " topping.");
        else
            System.out.println("You can choose " + addOns + " toppings.");
    }

    /*
    This method keeps null value in the toppings field if the topping entered by the user is not found in Extras Class.
     */

    public void addExtras(Extras extras) { // setter for each topping.
        this.E1 = (extras.getTopping1());
        this.E2 = (extras.getTopping2());
        this.E3 = (extras.getTopping3());
        this.E4 = (extras.getTopping4());
        this.E5 = (extras.getTopping5());
        this.E6 = (extras.getTopping6());
    }

    /*
    This method counts the number of nulls in the toppings field. Nulls are either a non- selected topping (null by
    default) or kept null when the Extras.getTopping method returns a null value (not a match on the toppings list).
    */
    protected boolean orderValidation() {
        ArrayList<String> extraValidation = new ArrayList<>();
        extraValidation.add(E1);
        extraValidation.add(E2);
        extraValidation.add(E3);
        extraValidation.add(E4);
        extraValidation.add(E5);
        extraValidation.add(E6);

        // checks if the number of valid toppings matches the user's selection by subtracting total nulls from 6.

        nullCount = Collections.frequency(extraValidation, null);
        if (6 - nullCount == addOns) {
            return true;
        }

        System.out.println("Please select " + addOns + " toppings from the list:\n" + toppingsList + "\n");
        return false;
    }


    // not currently used. just for now, keep the roll type set and unchangeable.
    /*
    public void changeRollType(String rollType) {
        this.rollType = rollType;
    }
     */

    public void changeMeat(boolean meat) { // setter to change the boolean meat value for meatless Basic Burger option.
        this.meat = meat;
    }

    protected boolean isMeat() {
        return this.meat;
    }

    protected double getPrice() {
        return this.price;
    }

    protected void addCombo() {
        this.combo = true;
        this.price += 3.50;
    }

    protected void setAddOns() { // sets addOn variable to zero after user selects No for additional toppings.
        this.addOns = 0;
    }

    protected void setPrice() { // note: overridden in Healthy Burger class. Not used for Deluxe Burger.
        switch (addOns) {
            case 1:
                this.price = 9.45;
                break;
            case 2:
                this.price = 9.95;
                break;
            case 3:
                this.price = 10.45;
                break;
            case 4:
            case 5:
            case 6:
                this.price = 10.95;
                break;
            default:
                this.price = 8.95;
        }
    }
}

