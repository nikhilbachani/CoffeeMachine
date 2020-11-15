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
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();

        System.out.printf("For %d cups of coffee you will need:%n", cupsOfCoffee);
        System.out.printf("%d ml of water%n", cupsOfCoffee * WATER_PER_CUP_ML);
        System.out.printf("%d ml of milk%n", cupsOfCoffee * MILK_PER_CUP_ML);
        System.out.printf("%d g of coffee beans%n", cupsOfCoffee * BEANS_PER_CUP_G);
    }
}
