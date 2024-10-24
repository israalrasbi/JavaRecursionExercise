import java.util.Scanner;

public class TriangleBlockCounter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int num = sc.nextInt();
        System.out.println("Total number of blocks: " + triangle(num));
    }
    public static Integer triangle(int numberOfRows){
        //base case
        if(numberOfRows ==0){
            return 0;
        }
        return numberOfRows+triangle(numberOfRows-1);
    }
}
