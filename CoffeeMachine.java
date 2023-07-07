package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int water = 400;
        int milk = 540;
        int coffee = 120;
        int cups = 9;
        int dollars = 550;
        displaySupplies(water, milk, coffee, cups, dollars);
        int[] supplies = {400,540,120,9,550};

        System.out.println("Write action (buy, fill, take): ");
        Scanner scan = new Scanner(System.in);
        String action = scan.next();
        switch (action) {
            case "buy":
                buy(supplies);
                break;
            case "fill":
                fill(supplies);
                break;
            case "take":
                take(supplies);
                break;
        }
        displaySupplies(supplies);
    }
    public static void displaySupplies(int water, int milk, int coffee, int cups, int dollars){
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, water, milk, coffee, cups, dollars);
    }
    public static void displaySupplies(int[] supplies){
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, supplies[0], supplies[1], supplies[2], supplies[3], supplies[4]);
    }
    public static int[] buy(int[] supplies) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        Scanner scan = new Scanner(System.in);
        int order = scan.nextInt();
        switch (order) {
            case 1: //espresso
                supplies[0] -= 250;
                supplies[2] -= 16;
                supplies[3]--;
                supplies[4] += 4;
                break;
            case 2: //latte
                supplies[0] -= 350;
                supplies[1] -= 75;
                supplies[2] -= 20;
                supplies[3]--;
                supplies[4] += 7;
                break;
            case 3: //cappuccino
                supplies[0] -= 200;
                supplies[1] -= 100;
                supplies[2] -= 12;
                supplies[3]--;
                supplies[4] += 6;
                break;
        }
        return supplies;
    }
    public static int[] fill(int[] supplies) {
        int[] addedAmounts = new int[4];
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        addedAmounts[0] = scan.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        addedAmounts[1] = scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        addedAmounts[2] = scan.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        addedAmounts[3] = scan.nextInt();
        for (int i = 0; i < 4; i++) {
            supplies[i] += addedAmounts[i];
        }
        return supplies;
    }
    public static void take(int[] supplies) {
        supplies[4] = 0;
    }
}

