package rjp.SimpleBurgerStore;

import java.util.Arrays;

public class Extras {
    private final String topping1;
    private String topping2;
    private String topping3;
    private String topping4;
    private String topping5;
    private String topping6;

    private final String[] toppingsList = {"cheese", "avocado", "kale", "carrot", "tomato", "lettuce", "onion",
            "ketchup", "mustard", "pickles", "jalapenos", "beets", "olives"};

    public Extras() { // default toppings object, used to make a Classic Burger.
        this("cheese", "ketchup", "lettuce", "tomato");
    }

    // overloaded constructor for Extra object depending on the number of toppings the user selects.

    public Extras(String topping1) {
        this.topping1 = topping1;
    }

    public Extras(String topping1, String topping2) {
        this.topping1 = topping1;
        this.topping2 = topping2;
    }

    public Extras(String topping1, String topping2, String topping3) {
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
    }

    public Extras(String topping1, String topping2, String topping3, String topping4) {
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.topping4 = topping4;
    }

    public Extras(String topping1, String topping2, String topping3, String topping4, String topping5) {
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.topping4 = topping4;
        this.topping5 = topping5;
    }

    public Extras(String topping1, String topping2, String topping3, String topping4, String topping5, String topping6) {
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.topping4 = topping4;
        this.topping5 = topping5;
        this.topping6 = topping6;
    }

    /*
    Overloaded method to validate if each topping entered by customer matches with a topping on the list. It uses
    Arrays.asList to use the Arrays.contains() method rather than use a for loop to valid a match or return a null.
     */

    public String getTopping1() {
        if (Arrays.asList(toppingsList).contains(topping1))
            return this.topping1;
        else return null;
    }

    public String getTopping2() {
        if (Arrays.asList(toppingsList).contains(topping2))
            return this.topping2;
        else return null;
    }

    public String getTopping3() {
        if (Arrays.asList(toppingsList).contains(topping3))
            return this.topping3;
        else return null;
    }

    public String getTopping4() {
        if (Arrays.asList(toppingsList).contains(topping4))
            return this.topping4;
        else return null;
    }

    public String getTopping5() {
        if (Arrays.asList(toppingsList).contains(topping5))
            return this.topping5;
        else return null;
    }

    public String getTopping6() {
        if (Arrays.asList(toppingsList).contains(topping6))
            return this.topping6;
        else return null;
    }

}
