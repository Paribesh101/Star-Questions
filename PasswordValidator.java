import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordValidator {
    
    public static void main(String[] args){
        System.out.println("Enter a password to validate");
        System.out.println("The password must:");
        System.out.println("Be at least 8 characters");
        System.out.println("Contain at least one uppercase letter");
        System.out.println("Contain at least one lowercase letter");
        System.out.println("Contain at least one number");
        System.out.print("Enter password: ");
        String password;
        Scanner scan = new Scanner(System.in);
        password = scan.nextLine();
        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLowercase = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasNumber = password.matches(".*\\d.*");
        boolean longEnough = password.length() >= 8;
        if (hasUppercase && hasLowercase && hasNumber && longEnough) {
            System.out.println("Password accepted!");
        } else {
            System.out.println("Password rejected:");
        
            if (!hasUppercase) {
                System.out.println("-Must contain an uppercase letter");
            }
        
            if (!hasLowercase) {
                System.out.println("-Must contain a lowercase letter");
            }
        
            if (!hasNumber) {
                System.out.println("-Must contain a number");
            }
        
            if (!longEnough) {
                System.out.println("-Must be at least 8 characters");
            }
        }

    }

}
