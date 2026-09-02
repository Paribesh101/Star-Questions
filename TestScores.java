// Challenge - CALCULATE 5 TEST SCORES
import java.util.Scanner;


public class TestScores {
    

    public static void main(String[] args) {
        int total = 0;
        double average;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        System.out.println("Enter 5 test scores to calculate the total, average, highest, and lowest: ");
        int[] array = new int[5];
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("[,\\s]+");
        for(int i = 0; i < array.length; i++){
            array[i] = scan.nextInt();
            total += array[i];
            if(highest < array[i]){
                highest = array[i];
            }
            if(lowest > array[i]){
                lowest = array[i];
            }
        }
        scan.close();
        average = total / array.length;
        System.out.println("Total " + total);
        System.out.println("Average " + average);
        System.out.println("Highest " + highest);
        System.out.println("Lowest " + lowest);
    }
}
