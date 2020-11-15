package machine;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final int WATER_PER_CUP_ML = 200;
    static final int MILK_PER_CUP_ML = 50;
    static final int BEANS_PER_CUP_G = 15;

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
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterInMachine = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkInMachine = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beansInMachine = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();
        int cupsPossible = Math.min(waterInMachine / WATER_PER_CUP_ML, Math.min(milkInMachine / MILK_PER_CUP_ML, beansInMachine / BEANS_PER_CUP_G));

        if (cupsNeeded == cupsPossible) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsNeeded < cupsPossible) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", cupsPossible - cupsNeeded);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee%n", cupsPossible);
        }
    }
}
