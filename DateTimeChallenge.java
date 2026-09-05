import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;



public class DateTimeChallenge {
    public static void main(String[] args){
        LocalDate today = LocalDate.now();

        // Part 1: print date and compoenents
        System.out.println("Date: " + today);
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day: " + today.getDayOfMonth());
        // TODO

        // Part 2 & 3: read birthdate
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birth date: ");
        String birthInput = scanner.nextLine().trim();
        LocalDate birthday = LocalDate.parse(birthInput);

        int age = Period.between(birthday, today).getYears();
        System.out.println("You are " + age + " years old.");

        // Part 3: days until next birthday
        LocalDate nextBirthday = birthday.withYear(today.getYear());
        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)){
            nextBirthday = nextBirthday.plusYears(1);
        }
        long days = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println("Days until your next birthday: " + days);

    }
    
}
