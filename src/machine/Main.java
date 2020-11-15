package machine;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
//    static final int WATER_PER_CUP_ML = 200;
//    static final int MILK_PER_CUP_ML = 50;
//    static final int BEANS_PER_CUP_G = 15;
    // initialize defaults
    static int water = 0; // ml
    static int milk = 0; // ml
    static int beans = 0; // g
    static int cups = 0;
    static int money = 0; // dollars

    public static void main(String[] args) {
        /* Stage 1: Hello, coffee! */
//        System.out.println("Starting to make a coffee");
//        System.out.println("Grinding coffee beans");
//        System.out.println("Boiling water");
//        System.out.println("Mixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup");
//        System.out.println("Pouring some milk into the cup");
//        System.out.println("Coffee is ready!");

        /* Stage 2: Machines have needs */
//        System.out.println("Write how many cups of coffee you will need:");
//        int cupsOfCoffee = scanner.nextInt();
//
//        System.out.printf("For %d cups of coffee you will need:%n", cupsOfCoffee);
//        System.out.printf("%d ml of water%n", cupsOfCoffee * WATER_PER_CUP_ML);
//        System.out.printf("%d ml of milk%n", cupsOfCoffee * MILK_PER_CUP_ML);
//        System.out.printf("%d g of coffee beans%n", cupsOfCoffee * BEANS_PER_CUP_G);

        /* Stage 3: Enough coffee for everyone */
//        System.out.println("Write how many ml of water the coffee machine has:");
//        int waterInMachine = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milkInMachine = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int beansInMachine = scanner.nextInt();
//
//        System.out.println("Write how many cups of coffee you will need:");
//        int cupsNeeded = scanner.nextInt();
//        int cupsPossible = Math.min(waterInMachine / WATER_PER_CUP_ML, Math.min(milkInMachine / MILK_PER_CUP_ML, beansInMachine / BEANS_PER_CUP_G));
//
//        if (cupsNeeded == cupsPossible) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (cupsNeeded < cupsPossible) {
//            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", cupsPossible - cupsNeeded);
//        } else {
//            System.out.printf("No, I can make only %d cup(s) of coffee%n", cupsPossible);
//        }
        initContents();
        printContents();
        System.out.println();
        System.out.println("Write action (buy, fill, take):");
        String action = scanner.next();
        performAction(action);
        System.out.println();
        printContents();
    }

    private static void initContents() {
        water = 400;
        milk = 540;
        beans = 120;
        cups = 9;
        money = 550;
    }

    private static void printContents() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n", water);
        System.out.printf("%d of milk%n", milk);
        System.out.printf("%d of coffee beans%n", beans);
        System.out.printf("%d of disposable cups%n", cups);
        System.out.printf("%d of money%n", money);
    }

    private static void performAction(String action) {
        switch (action) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
            default:
                System.out.println("Invalid action");
                break;
        }
    }

    private static void takeMoney() {
        System.out.printf("I gave you $%d%n", money);
        money = 0;
    }

    private static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
    }

    private static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int coffeeType = scanner.nextInt();

        switch (coffeeType) {
            case 1:
                water -= 250;
                beans -= 16;
                money += 4;
                break;
            case 2:
                water -= 350;
                milk -= 75;
                beans -= 20;
                money += 7;
                break;
            case 3:
                water -= 200;
                milk -= 100;
                beans -= 12;
                money += 6;
                break;
            default:
                break;
        }

        cups--;
    }
}
