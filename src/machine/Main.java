package machine;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    // constants
    static final int INITIAL_WATER = 400; // ml
    static final int INITIAL_MILK = 540; // ml
    static final int INITIAL_COFFEE_BEANS = 120; // grams
    static final int INITIAL_CUPS = 9; // ml
    static final int INITIAL_MONEY = 550; // dollars
    static final String ACTION_BUY = "buy";
    static final String ACTION_FILL = "fill";
    static final String ACTION_TAKE = "take";
    static final String ACTION_REMAINING = "remaining";
    static final String ACTION_EXIT = "exit";
    static final String ACTION_BACK = "back";
    static final String COFFEE_ESPRESSO = "1";
    static final String COFFEE_LATTE = "2";
    static final String COFFEE_CAPPUCCINO = "3";
    static final String SORRY_NOT_ENOUGH = "Sorry, not enough ";

    // variables
    static int water; // ml
    static int milk; // ml
    static int beans; // grams
    static int cups;
    static int money; // dollars

    public static void main(String[] args) {
        initContents();

        boolean stopActions = false;
        while (!stopActions) {
            String action = getAction();
            if (ACTION_EXIT.equals(action)) {
                stopActions = true;
            } else {
                performAction(action);
                System.out.println();
            }
        }
    }

    // initialize machine with default values
    private static void initContents() {
        water = INITIAL_WATER;
        milk = INITIAL_MILK;
        beans = INITIAL_COFFEE_BEANS;
        cups = INITIAL_CUPS;
        money = INITIAL_MONEY;
    }

    private static String getAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return scanner.next().trim().toLowerCase();
    }

    private static void performAction(String action) {
        switch (action) {
            case ACTION_BUY:
                buyCoffee();
                break;
            case ACTION_FILL:
                fillContents();
                break;
            case ACTION_TAKE:
                takeMoney();
                break;
            case ACTION_REMAINING:
                printContents();
                break;
            default:
                System.out.println("Invalid action");
                break;
        }
    }

    private static void buyCoffee() {
        boolean invalidChoice;

        do {
            System.out.println();
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String coffeeType = scanner.next().trim().toLowerCase();
            invalidChoice = false;

            switch (coffeeType) {
                case COFFEE_ESPRESSO:
                    // Espresso => 250ml water, no milk, 16g beans, and $4
                    makeCoffee(250, 0, 16, 4);
                    break;
                case COFFEE_LATTE:
                    // Latte => 350ml water, 75ml milk, 16g beans, and $7
                    makeCoffee(350, 75, 20, 7);
                    break;
                case COFFEE_CAPPUCCINO:
                    // Cappuccino => 200ml water, 100ml milk, 12g beans, and $6
                    makeCoffee(200, 100, 12, 6);
                    break;
                case ACTION_BACK:
                    break;
                default:
                    System.out.println("Invalid choice");
                    invalidChoice = true;
                    break;
            }
        } while (invalidChoice);
    }

    private static void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {
        if (water < waterNeeded) {
            System.out.println(SORRY_NOT_ENOUGH.concat("water!"));
        } else if (milk < milkNeeded) {
            System.out.println(SORRY_NOT_ENOUGH.concat("milk!"));
        } else if (beans < beansNeeded) {
            System.out.println(SORRY_NOT_ENOUGH.concat("coffee beans!"));
        } else if (cups < 1) {
            System.out.println(SORRY_NOT_ENOUGH.concat("disposable cups!"));
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;
            cups--; // every coffee type requires a disposable cup
            chargeMoney(price);
        }
    }

    private static void chargeMoney(int coffeePrice) {
        money += coffeePrice;
    }

    private static void fillContents() {
        System.out.println();
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups do you want to add:");
        cups += scanner.nextInt();
    }

    private static void takeMoney() {
        System.out.println();
        System.out.printf("I gave you $%d%n", money);
        money = 0;
    }

    private static void printContents() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n", water);
        System.out.printf("%d of milk%n", milk);
        System.out.printf("%d of coffee beans%n", beans);
        System.out.printf("%d of disposable cups%n", cups);
        System.out.printf("%c%d of money%n", money != 0 ? '$' : Character.MIN_VALUE, money);
    }
}