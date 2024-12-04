import java.util.Scanner;

public class Main {
    static Food ChickenSandwich = new Food(750, "Chicken Sandwich", 20.99, 3, "Our signature sandwich, with grilled chicken and premium ingredients");
    static Food ChickenButter = new Food(1130, "Chicken Butter", 30.99, 2, "An awesome curry with chicken which comes with a side of rice");
    static Food FriedChicken = new Food(400, "Fried Chicken", 13.99, 2, "I love fried chicken");
    static Food ChickenKebab = new Food(1680, "Chicken Kebab", 27.99, 4, "Slow roasted with Mediterranean sides, feeds multiple people");
    static Food ChickenBalls = new Food(300, "Chicken Balls", 6.99, 4, "Chicken nuggets but they're balls");
    static Food ChickenSoup = new Food(700, "Chicken Noodle Soup", 9.99, 3, "A very hearty stew, comes with sourdough bread and oyster crackers");
    static Food ChickenPasta = new Food(1100, "Chicken Fettuccine Alfredo", 24.99, 2, "Our famous creamy garlic alfredo with premium pasta and grilled chicken");

    static Drinks Coke = new Drinks("Coke", 2.99, "Medium", "A classic fizzy drink.");
    static Drinks Lemonade = new Drinks("Lemonade", 3.49, "Medium", "Freshly squeezed lemons with a hint of sweetness.");
    static Drinks Coffee = new Drinks("Coffee", 4.99, "Large", "Hot brewed coffee, perfect to start your day.");
    static Drinks IcedTea = new Drinks("Iced Tea", 3.99, "Medium", "Refreshing iced tea, sweetened or unsweetened.");
    static Drinks Milkshake = new Drinks("Milkshake", 5.49, "Large", "Rich, creamy milkshake with your choice of flavors.");

    static Food[] foodMenu = {ChickenSandwich, ChickenButter, ChickenKebab, ChickenPasta};
    static Food[] appetizerMenu = {ChickenBalls, ChickenSoup, FriedChicken};
    static Drinks[] drinksMenu = {Coke, Lemonade, Coffee, IcedTea, Milkshake};

    static Bathroom menBathroom = new Bathroom("Men's");
    static Bathroom womenBathroom = new Bathroom("Women's");

    static Food[] foodOrder = new Food[0];
    static Drinks[] drinkOrder = new Drinks[0];

    public static void showMenu() {
        System.out.println("\nFood Menu:");
        for (Food item : foodMenu) {
            System.out.print(item.getName() + " . . . . . ");
            System.out.println("$" + item.getPrice());
        }
        System.out.println("\nAppetizer Menu:");
        for (Food item : appetizerMenu) {
            System.out.print(item.getName() + " . . . . . ");
            System.out.println("$" + item.getPrice());
        }
        System.out.println("\nDrinks Menu:");
        for (Drinks drink : drinksMenu) {
            System.out.print(drink.getName() + " (" + drink.getSize() + ") . . . . . ");
            System.out.println("$" + drink.getPrice());
        }
    }
    public static void orderItems(Scanner scanner) {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\nWould you like to order something? (Type the item name to add to your order or 'no' to finish ordering)");
            String input = scanner.nextLine().toLowerCase().trim();
    
            if (input.equals("no")) {
                ordering = false;
                System.out.println("Finished adding items to your order.");
            } else {
                boolean itemFound = false;
    
                // Check food menu
                for (Food item : foodMenu) {
                    if (input.equals(item.getName().toLowerCase())) {
                        foodOrder = java.util.Arrays.copyOf(foodOrder, foodOrder.length + 1);
                        foodOrder[foodOrder.length - 1] = item;
                        System.out.println(item.getName() + " has been added to your order. If you wanna stop ordering, say 'no");
                        itemFound = true;
                        break;
                    }
                }
                if (!itemFound) {
                    for (Food item : appetizerMenu) {
                        if (input.equals(item.getName().toLowerCase())) {
                            foodOrder = java.util.Arrays.copyOf(foodOrder, foodOrder.length + 1);
                            foodOrder[foodOrder.length - 1] = item;
                            System.out.println(item.getName() + " has been added to your order. If you wanna stop ordering, say 'no");
                            itemFound = true;
                            break;
                        }
                    }
                }
                if (!itemFound) {
                    for (Drinks drink : drinksMenu) {
                        if (input.equals(drink.getName().toLowerCase())) {
                            drinkOrder = java.util.Arrays.copyOf(drinkOrder, drinkOrder.length + 1);
                            drinkOrder[drinkOrder.length - 1] = drink;
                            System.out.println(drink.getName() + " has been added to your order. If you wanna stop ordering, say 'no");
                            itemFound = true;
                            break;
                        }
                    }
                }
    
                if (!itemFound) {
                    System.out.println("Sorry, that item is not on the menu. Please try again. If you want to stop ordering, say 'no");
                }
            }
        }
    }
    public static void handleMenuInteraction(Scanner scanner) {
        boolean browsing = true;
        while (browsing) {
            System.out.println("\nType 'menu' to view the menu, 'order' to add items, 'checkout' to finish,'exit' to stop , or 'info' to get more info on items. CLUCK CLUCK:");
            String userInput = scanner.nextLine().toLowerCase().trim();
    
            if (userInput.equals("menu")) {
                showMenu();
            } else if (userInput.equals("order")) {
                orderItems(scanner);
            } else if (userInput.equals("checkout")) {
                checkout(scanner);
                browsing = false;
            } 
            else if(userInput.equals("info")||userInput.equals("information")){
                handleItemInfo(userInput, scanner);
            }
            else if (userInput.equals("exit")) {
                System.out.println("Thank you for visiting! Goodbye!");
                browsing = false;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public static void checkout(Scanner scanner) {
        double total = 0;
        System.out.println("\nYour Order:");
        System.out.println("Food Items:");
        for (Food item : foodOrder) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("Drinks:");
        for (Drinks drink : drinkOrder) {
            System.out.println(drink.getName() + " (" + drink.getSize() + ") - $" + drink.getPrice());
            total += drink.getPrice();
        }
        System.out.println("Subtotal: $" + total);
    
        // Ask for coupon
        System.out.println("\nDo you have a coupon code? (Type 'no' if not)");
        String coupon = scanner.nextLine().trim();
        if (coupon.equalsIgnoreCase("SAVE10")) {
            total *= 0.90;
            System.out.println("Coupon applied! You saved 10%.");
        } else if (!coupon.equalsIgnoreCase("no")) {
            System.out.println("Invalid coupon code. No discount applied.");
        }
    
        System.out.println("Total: $" + total);
        System.out.println("Thank you for your order!");
    }

    public static void handleItemInfo(String userInput, Scanner in) {
        System.out.println("Which item do you want more information on?");
        String itemName = in.nextLine().toLowerCase();
        boolean itemFound = false;

        for (Food item : foodMenu) {
            if (itemName.contains(item.getName().toLowerCase())) {
                System.out.println("Info on " + item.getName() + ": " + item.getInfo());
                itemFound = true;
                break;
            }
        }

        for (Drinks drink : drinksMenu) {
            if (itemName.contains(drink.getName().toLowerCase())) {
                System.out.println("Info on " + drink.getName() + ": " + drink.getInfo());
                itemFound = true;
                break;
            }
        }

        if (!itemFound) {
            System.out.println("Sorry, we couldn't find that item. Please try again.");
        }
    }

    public static void modifySpiciness(String userInput, Scanner in) {
        System.out.println("Which food item would you like to adjust?");
        String foodName = in.nextLine().toLowerCase();
        Food selectedFood = null;
        for (Food item : foodMenu) {
            if (foodName.contains(item.getName().toLowerCase())) {
                selectedFood = item;
                break;
            }
        }
        if (selectedFood != null) {
            System.out.println("Enter a spiciness level (1 = mild, 5 = very spicy):");
            int level = in.nextInt();
            in.nextLine(); // Consume newline
            if (level < 1 || level > 5) {
                System.out.println("Invalid spiciness level! Please select between 1 and 5.");
            } else {
                selectedFood.ChangeSpiciness(level);
                System.out.println(selectedFood.getName() + " spiciness is now set to level " + level + ".");
            }
        } else {
            System.out.println("Food item not found. Please try again.");
        }
    }

    public static void modifySize(String userInput, Scanner in) {
        System.out.println("Which drink would you like to adjust?");
        String drinkName = in.nextLine().toLowerCase();
        Drinks selectedDrink = null;
        for (Drinks drink : drinksMenu) {
            if (drinkName.contains(drink.getName().toLowerCase())) {
                selectedDrink = drink;
                break;
            }
        }
        if (selectedDrink != null) {
            System.out.println("Enter a new size (Small, Medium, Large):");
            String newSize = in.nextLine();
            if (!(newSize.equalsIgnoreCase("small") || newSize.equalsIgnoreCase("medium") || newSize.equalsIgnoreCase("large"))) {
                System.out.println("Invalid size! Please choose between Small, Medium, or Large.");
            } else {
                selectedDrink.changeSize(newSize);
                System.out.println(selectedDrink.getName() + " size is now set to " + newSize + ".");
            }
        } else {
            System.out.println("Drink item not found. Please try again.");
        }
    }

    public static void handleBathroomRequest(String userInput) {
        if (userInput.contains("men")) {
            System.out.println(menBathroom.getStatus());
        } else if (userInput.contains("women")) {
            System.out.println(womenBathroom.getStatus());
        } else {
            System.out.println("Which bathroom? (Men's or Women's)");

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean noBye = true;
        System.out.println("Hi, I am Bob the Chatbot. Welcome to my restaurant. Gobble Gobble. I can help you craft an order, adjust food options, or answer menu-related questions. To stop chatting, type 'bye'. What would you like to do? - we recommend checking out out menu first.");

        while (noBye) {
            System.out.println("\nType your request:");
            String userInput = in.nextLine().toLowerCase().trim();

            if (userInput.equals("bye")) {
                System.out.println("Goodbye! See you next time.");
                noBye = false;
            } else if (userInput.equals("hi") || userInput.equals("hello")) {
                System.out.println("Hi! What do you want today?");
            } else if (userInput.contains("menu")||userInput.contains("food")) {
                showMenu();
                handleMenuInteraction(in);
            } else if (userInput.contains("info")||userInput.contains("information")) {
                handleItemInfo(userInput, in);
            } else if (userInput.contains("bathroom")) {
                handleBathroomRequest(userInput);
            } else if (userInput.contains("spiciness")||userInput.contains("spicy")||userInput.contains("spice")) {
                modifySpiciness(userInput, in);
            } else if (userInput.contains("size")||userInput.contains("big")||userInput.contains("small")) {
                modifySize(userInput, in);
            } else {
                System.out.println("GOBBLE GOBBLE. WHAT DO YOU MEAN??? Please try typing that again.");
            }
        }
        in.close();
    }
}