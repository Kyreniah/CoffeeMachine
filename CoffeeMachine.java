package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scan.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scan.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scan.nextInt();
        int possibleCups = amountOfCoffee(cups, water, milk, coffee);

        if (cups == possibleCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cups > possibleCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee", possibleCups);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", possibleCups - cups);
        }
    }
    public static int amountOfCoffee(int cups, int water, int milk, int coffee) {
        int possibleCups = water / 200;
        if (milk / 50 < possibleCups) {
            possibleCups = milk / 50;
        }
        if (coffee / 15 < possibleCups) {
            possibleCups = coffee / 15;
        }
        return possibleCups;
    }
}

