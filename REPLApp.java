import java.util.Random;
import java.util.Scanner;

public class REPLApp{
    public static void main(String[] args) {
        System.out.println("Welcome to my REPL App!\n");
        System.out.println("""
                        Available commands:
    
                            add
                            subtract
                            multiply
                            divide
                            random
                            reverse
                            quit
                            """);
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;
        int a;
        int b;


        while(running){
            System.out.print("> ");
            String choice = scan.nextLine();

            switch (choice) {
                case "help":
                    System.out.println("""
                        Available commands:
    
                            add
                            subtract
                            multiply
                            divide
                            random
                            reverse
                            quit
                            """);
                    break;
    
                case "add":
                    System.out.print("First Number: ");
                    a = scan.nextInt();
                    System.out.println();
                    System.out.print("Second Number: ");
                    b = scan.nextInt();
                    scan.nextLine();  
                    System.out.println("Result: " + (a + b));
                    break;
                case "subtract":
                    System.out.print("First Number: ");
                    a = scan.nextInt();
                    System.out.println();
                    System.out.print("Second Number: ");
                    b = scan.nextInt();
                    scan.nextLine();  
                    System.out.println("Result: " + (a - b));
                    break;
                case "multiply":
                    System.out.print("First Number: ");
                    a = scan.nextInt();
                    System.out.println();
                    System.out.print("Second Number: ");
                    b = scan.nextInt();
                    scan.nextLine();  
                    System.out.println("Result: " + (a * b));
                    break;
                case "divide":
                    System.out.print("First Number: ");
                    double divA = scan.nextDouble();
                    System.out.println();
                    System.out.print("Second Number: ");
                    double divB = scan.nextDouble();
                    scan.nextLine();  
                    if(divB == 0){
                        System.out.println("Error: Cannot divide by zero.");
                    } else {
                        System.out.println();
                        System.out.println("Result: " + (divA / divB));
                    }
                    break;
                case "random":
                    System.out.print("Enter minimum value: ");
                    a = scan.nextInt();
                    System.out.print("Enter maximum value: ");
                    b = scan.nextInt();
                    scan.nextLine();  
                    if (a > b){
                        System.out.println("Error: Minimum must be less than or equal to maximum.");
                    } else {
                        int randomNum = rand.nextInt((b - a) + 1) + a;
                        System.out.println("Random number: " + randomNum);
                    }
                    break;
                case "reverse":
                    System.out.print("Enter text to reverse: ");
                    String text = scan.nextLine();
                    String reversed = new StringBuilder(text).reverse().toString();
                    System.out.println("Result: " + reversed);
                    break;
                case "quit":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default: // Executed if no cases match
                    System.out.println("Invalid command. Type 'help' to see available commands.");
                    break;
                
            }
        }
        scan.close();

    }


}