package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int[] supplies = {400,540,120,9,550};
        boolean terminated = false;

        while (!terminated) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
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
                case "remaining":
                    displaySupplies(supplies);
                    break;
                case "exit":
                    terminated = true;
                    break;
            }
        }
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
        String order = scan.next();
        switch (order) {
            case "1": //espresso
                if (hasEnoughSupplies(supplies, 250,16)) {
                    supplies[0] -= 250;
                    supplies[2] -= 16;
                    supplies[3]--;
                    supplies[4] += 4;
                }
                break;
            case "2": //latte
                if (hasEnoughSupplies(supplies, 350, 75,20)) {
                    supplies[0] -= 350;
                    supplies[1] -= 75;
                    supplies[2] -= 20;
                    supplies[3]--;
                    supplies[4] += 7;
                }
                break;
            case "3": //cappuccino
                if (hasEnoughSupplies(supplies, 200, 100,12)) {
                    supplies[0] -= 200;
                    supplies[1] -= 100;
                    supplies[2] -= 12;
                    supplies[3]--;
                    supplies[4] += 6;
                }
                break;
            case "back": //cappuccino
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
    public static boolean hasEnoughSupplies(int[] supplies, int water, int milk, int coffee) {
        boolean canMakeCoffee = false;
        if (supplies[0] / water < 1){
            System.out.println("Sorry, not enough water!");
        } else if (supplies[1] / milk < 1) {
            System.out.println("Sorry, not enough milk!");
        } else if (supplies[2] / coffee < 1) {
            System.out.println("Sorry, not enough coffee!");
        } else if (supplies[3] < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            canMakeCoffee = true;
        }
        return canMakeCoffee;
    }
    public static boolean hasEnoughSupplies(int[] supplies, int water, int coffee) {
        boolean canMakeCoffee = false;
        if (supplies[0] / water < 1){
            System.out.println("Sorry, not enough water!");
        } else if (supplies[2] / coffee < 1) {
            System.out.println("Sorry, not enough coffee!");
        } else if (supplies[3] < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            canMakeCoffee = true;
        }
        return canMakeCoffee;
    }
}

