package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scan.nextInt();
        System.out.printf("""
                For %d cups of coffee you will need:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                """, cups, cups * 200, cups * 50, cups * 15);
    }
}
