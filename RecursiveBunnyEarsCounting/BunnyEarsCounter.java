import java.util.Scanner;

public class BunnyEarsCounter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bunnies: ");
        int num = sc.nextInt();
        System.out.println("Total number of ears: " + bunnyEars2(num));
    }

    public static Integer bunnyEars2(int numberOfBunnies){
        //base case
        if(numberOfBunnies == 0){
            return 0;
        }

        //check if the numberOfBunnies is odd or even
        //if even
        if(numberOfBunnies%2 == 0){
            return 3+bunnyEars2(numberOfBunnies-1);
        }
        //if odd
        else {
            return 2+bunnyEars2(numberOfBunnies-1);
        }
    }
}
