import java.util.Scanner;

public class StringModifier {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Modified string: "+allStar(input));
    }

    public static String allStar(String str){
        //base case
        if(str.length() == 0 || str.length() == 1){
            return str;
        }
        return str.substring(0,1) + "*" + allStar(str.substring(1));
    }
}
