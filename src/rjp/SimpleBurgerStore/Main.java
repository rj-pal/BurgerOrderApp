package rjp.SimpleBurgerStore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static boolean order() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Burger burger = new Burger(); // creates the customer's initial Burger Object and prints menu.
        System.out.println(" Burger Menu- Our delicious home-made burger paddies come Plain Jane. Add-ons only $0.50!" +
                "\n-----------------------------------------------------------------------------------------------" +
                "\n\t1. Basic Burger on a Sesame roll. You can add up to 4 toppings." +
                "\n\t  $8.95 + $0.50 for each additional topping. Comes with a small side of crisps and pickles.\n" +
                "\n\t2. Healthy Veggie Burger on a Brown Rye roll. You can add up to 6 toppings." +
                "\n\t  $8.95 + $0.50 for each additional topping. Comes with a house salad and pickles.\n" +
                "\n\t3. Classic Beef Burger on a Sesame roll with cheese, ketchup, lettuce, and tomato." +
                "\n\t  $10.95. No additional toppings are allowed. Comes with a small side of crisps and pickles.\n" +
                "\n\t4. Delicious Deluxe Beef Burger Combo on a Pumpernickel roll with Chips and a Drink." +
                "\n\t  $12.95. No additional toppings are allowed with the combo. Comes with ketchup and mustard." +
                "\n\n\t*Upgrade your side order on any of the first three options to a Combo for just $3.50!*" +
                "\n_______________________________________________________________________________________________" +
                "\n **Deluxe Burger Combo and Combo Upgrades come with our famous Pickle Chips and house-made Cola!" +
                "\n **Meatless burger substitution is free of charge on a Basic Burger. Other paddies cannot " +
                "be changed." +
                "\n ****Sorry, no substitutions for our specialty burger or special Pickle Chips and Cola!\n" +
                "\nPress 1 for a Basic Burger.\t\t\tPress 2 for a Healthy Burger.\nPress 3 for a Classic Burger." +
                "\t\tPress 4 for a Deluxe Burger." +
                "\n\nEnter your choice: ");
        try {
            int a = scanner.nextInt(); // three options. restarts or terminates if there is invalid selection.
            if (a == 1) {
                scanner.nextLine();
                while (true) {
                    System.out.println("Would you like to make your Basic Burger meatless? Y or N?");
                    String selection = scanner.nextLine();
                    if (selection.toLowerCase().equals("y") || selection.toLowerCase().equals("yes")) {
                        burger.changeMeat(false);
                        break;
                    } else if (selection.toLowerCase().equals("n") || selection.toLowerCase().equals("no")) {
                        break;
                    } else
                        System.out.println("You entered an incorrect response.\n"); // asks the user again for input.
                }

            } else if (a == 2) {
                scanner.nextLine();
                burger = new HealthyBurger();

            } else if (a == 3) {
                scanner.nextLine();
                burger = new ClassicBurger();
                burger.addExtras(new Extras()); // uses default Extras constructor.

            } else if (a == 4) {
                scanner.nextLine();
                burger = new DeluxeBurger();
                burger.addExtras(new Extras("ketchup", "mustard"));

            } else {
                scanner.nextLine();
                System.out.println("Your selection was invalid. Select 1, 2, 3, or 4 only.");
                return false; // restarts the order from the start.
            }
        } catch (InputMismatchException e) { // just added a System Exit for practice.
            System.out.println("Invalid input. System error. Program is terminated.");
            System.exit(1); // ends program with error if user enters non-integer value, instead of asking again.
        }

        boolean stop = false;
        while (!stop) {
            System.out.println("Would you like any toppings? Y or N?"); // loops if invalid input is received.
            String selection = scanner.nextLine();

            if (selection.toLowerCase().equals("y") || selection.toLowerCase().equals("yes")) {
                int extras;
                System.out.println("Please enter the number of toppings: ");
                try {
                    extras = scanner.nextInt();
                    scanner.nextLine();

                    burger.AddOns(extras);

                    // this check is for if Deluxe or Classic customer choose Y or invalid number was entered.
                    if (burger.getAddOns() == -1) { // resets the order from start.
                        System.out.println("\nSomething went wrong.\n");
                        return false;
                    } else {
                        burger.myBurger();
                        boolean quit = false;
                        while (!quit) {
                            System.out.println("Please enter your toppings one at a time and press enter after each" +
                                    ", or please enter all of them on one line with just one space between each: ");
                            switch (extras) {
                                case 1:
                                    String topping1 = scanner.next().toLowerCase();
                                    burger.addExtras(new Extras(topping1));
                                    break;
                                case 2:
                                    topping1 = scanner.next().toLowerCase();
                                    String topping2 = scanner.next().toLowerCase();
                                    burger.addExtras(new Extras(topping1, topping2));
                                    break;
                                case 3:
                                    topping1 = scanner.next().toLowerCase();
                                    topping2 = scanner.next().toLowerCase();
                                    String topping3 = scanner.next().toLowerCase();
                                    burger.addExtras(new Extras(topping1, topping2, topping3));
                                    break;
                                case 4:
                                    topping1 = scanner.next().toLowerCase();
                                    topping2 = scanner.next().toLowerCase();
                                    topping3 = scanner.next().toLowerCase();
                                    String topping4 = scanner.next().toLowerCase();
                                    burger.addExtras(new Extras(topping1, topping2, topping3, topping4));
                                    break;
                                case 5:
                                    if (!(burger instanceof HealthyBurger)) {
                                        System.out.println("Sorry, you are only allowed up to 4 toppings.");
                                        break;
                                    }
                                    topping1 = scanner.next().toLowerCase();
                                    topping2 = scanner.next().toLowerCase();
                                    topping3 = scanner.next().toLowerCase();
                                    topping4 = scanner.next().toLowerCase();
                                    String topping5 = scanner.next().toLowerCase();
                                    burger.addExtras(new Extras(topping1, topping2, topping3, topping4, topping5));
                                    break;
                                case 6:
                                    if (!(burger instanceof HealthyBurger)) {
                                        System.out.println("Sorry, you are only allowed up to 4 toppings.");
                                        break;
                                    }
                                    topping1 = scanner.next().toLowerCase();
                                    topping2 = scanner.next().toLowerCase();
                                    topping3 = scanner.next().toLowerCase();
                                    topping4 = scanner.next().toLowerCase();
                                    topping5 = scanner.next().toLowerCase();
                                    String topping6 = scanner.next().toLowerCase();
                                    burger.addExtras(new Extras(topping1, topping2, topping3, topping4, topping5, topping6));
                                    break;
                            }
                            scanner.nextLine();
                            if (burger.orderValidation()) {
                                quit = true;
                                stop = true;
                            } else {
                                int addOn = burger.getAddOns(); // conditional to control for grammar singular/plural.
                                String addOns = (burger.getAddOns() == 1) ? addOn + " topping" : addOn + " toppings";
                                System.out.println("Invalid Burger.\nThere is an error the topping selection, or, " +
                                        "you may have made a spelling error. Check the list carefully and try again.\n" +
                                        "\nPlease select " + addOns + " from the list:\n" + burger.toppingsList + "\n");
                                System.out.println("Just a moment please.\n");
                                Thread.sleep(5000);
                            }
                        }
                    }

                } catch (InputMismatchException e) { // asks the user again for input from top of stop while loop.
                    System.out.println("Invalid input. Please select Y or N again if you would like any toppings " +
                            "followed by a valid number of additional toppings. \n");
                    scanner.nextLine();
                }

            } else if (selection.toLowerCase().equals("n") || selection.toLowerCase().equals("no")) {
                burger.setAddOns();
                stop = true;
            } else
                System.out.println("You entered an incorrect response.\n"); // asks the user again for input.
        }

        if (burger instanceof DeluxeBurger) {
            assert true; // just pass through to checkout since Deluxe Burger is already a combo.
        } else {
            burger.myBurger();

            while (true) {
                System.out.println("\nTry our famous Pickle Chips and house-made Cola for only $3.50 more! " +
                        "Would you like to upgrade your side to a Combo? Y or N?");
                String selection = scanner.nextLine();
                if (selection.toLowerCase().equals("y") || selection.toLowerCase().equals("yes")) {
                    burger.addCombo();
                    System.out.println("Your order has been upgraded! Enjoy!");
                    break;
                } else if (selection.toLowerCase().equals("n") || selection.toLowerCase().equals("no")) {
                    break;
                } else
                    System.out.println("You entered an incorrect response.");
            }
        }
        burger.myBurger(); // display order summary
        System.out.print("\nIt is ready for checkout. Saying No will cancel your order. ");

        while (true) { // responding no will terminate the program with no errors.
            System.out.println("Are you sure you want to checkout? Y or N?");
            String selection = scanner.nextLine();
            if (selection.toLowerCase().equals("y") || selection.toLowerCase().equals("yes")) {
                break;
            } else if (selection.toLowerCase().equals("n") || selection.toLowerCase().equals("no")) {
                System.out.println("Your order has been cancelled. We hope you visit again soon.");
                System.exit(0);
            } else
                System.out.println("You entered an incorrect response.");
        }
        System.out.println("Moving on to checkout"); // mimics processing time wait for user.
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        burger.checkOut();
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        boolean quit = false;
        while (!quit) {
            if (order()) {
                System.out.println("\n** Thanks for order! Please follow us on Instagram! **");
                quit = true;
            } else {
                System.out.println("Please try your order again from the start. Please only enter a valid response" +
                        " to the question that is asked.\nYour order will be redirected momentarily. Please wait.");
                Thread.sleep(6000); // mimics processing time wait for user. gives user time to read the screen.
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.println("\n\n\n");
            }
        }
    }
}
