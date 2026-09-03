import java.util.Scanner;

public class WordAnalyzer {

    public static void main(String[] args) {
        System.out.print("Enter a word to analyze: ");
        String word;
        Scanner scan = new Scanner(System.in);
        word = scan.nextLine();
        word = word.toLowerCase();
        int characterCount = word.length();
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;
        for(int i = 0; i < word.length(); i++){
            char current = word.charAt(i);
            if (Character.isLetter(current)) {
                if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
            if(current == ' '){
                spaces++;
            }
            if(Character.isDigit(current)){
                digits++;
            }
        }
        System.out.println("Characters: " + characterCount);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
    }
    
}
