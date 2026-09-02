public class Practice {
    public static void main(String[] args) {
        // Challenge- Printing Output
        int age = 23;
        double heightInFeet = 5.7;
        String name = "Paribesh";

        System.out.println("Name: " + name + ", " + "Age: " + age + ", " + "Height: " + heightInFeet);
        System.out.println();
        // Challenge - Operators
        int a = 20;
        int b = 10;
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;
        boolean greater;
        if(a > b){
            greater = true;
        } else {
            greater = false;
        }
        boolean result;
        if (a > b && b > 0){
            result = true;
        } else {
            result = false;
        }
        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + difference);
        System.out.println("Multiplication: " + product);
        System.out.println("Division: " + quotient);
        System.out.println("If a is greater than b? " + greater);
        System.out.println("Is a > b and b > 0? " + result);
        System.out.println();

        // Challenge - Control Flow
        int score = 75;
        char grade = 'B';
        if(score >= 50){
            System.out.println("Passed");
        } else{
            System.out.println("Failed");
        }

        if(grade >= 90){
            System.out.println("Grade: A");
        } 
        else if(grade >= 75 && grade <= 89){
            System.out.println("Grade: B");
        }
        else if(grade >= 60 && grade <= 74){
            System.out.println("Grade: C");
        } else{
            System.out.println("Grade: D");
        }
        System.out.println();

        // Challenge - Loops
        System.out.print("For Loop: ");
        for(int i = 1; i <= 5; i++){
            System.out.print(i);
            if (i < 5) {
                System.out.print(" ");
            }
        }
        System.out.println();

        System.out.print("While Loop: ");
        int j = 1;
        while(j <= 5){
            System.out.print(j);
            if(j < 5){
                System.out.print(" ");
            }
            j++;
        }
        System.out.println();

        System.out.print("Do-While Loop: ");
        int k = 1;
        do{
            System.out.print(k);
            if (k < 5){
                System.out.print(" ");
            }
            k++;
        }while(k <= 5);
        System.out.println();
        System.out.println();

        // Challenge - Calculator
        double num1 = 7;
        double num2 = 3;
        char operator = '+';
        String again = "y";
        double result2;
        while (again.equals("y")) { 
            if(operator == '+'){
                result2 = num1 + num2;
            } else if (operator == '-'){
                result2 = num1 - num2;

            } else if (operator == '/'){
                if (num2 == 0){
                    System.out.println("Cannot divide by zero.");
                    again = "n";
                    continue;
                } else {
                    result2 = num1 / num2;
                }
                result2 = num1 / num2;

            } else if (operator == '*'){
                result2 = num1 * num2;
            } else{
                result2 = 0;
            }
            System.out.println("Result: " + result2);
            again = "n";
        }
        System.out.print("Thank you for using the calculator.");

    }
}