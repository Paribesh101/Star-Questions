
import java.util.Scanner;

// Challenge - REPL

public class Bank {

    // we need a scanner, that keeps scanning until you hit exit
    // need fields or instance variables
    private static double balance = 0;
    

    public static void main(String[] args) {
        int choice;
        double amount;
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        while(choice != 4){
            if(choice == 1){
                System.out.println("Balance: " + balance);
            } else if(choice == 2){
                scan = new Scanner(System.in);
                System.out.println("Deposit amount: ");
                amount = scan.nextDouble();
                balance += amount;
            } else if(choice == 3){
                scan = new Scanner(System.in);
                System.out.println("Withdraw amount: ");
                amount = scan.nextDouble();
                balance -= amount;
            }
            choice = scan.nextInt();
        }
        scan.close();

    }
}
