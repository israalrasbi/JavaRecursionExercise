import java.util.Scanner;

public class RecursivePowerCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base: ");
        int base = sc.nextInt();
        System.out.print("Enter the exponent: ");
        int exponent = sc.nextInt();
        System.out.print("Result: "+ powerN(base,exponent));

    }

    public static Integer powerN(int base, int exponent){
        //base case
        if(exponent == 1){
            return base;
        }
        return base * powerN(base, exponent -1);
    }
}
