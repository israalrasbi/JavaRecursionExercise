import java.util.Scanner;

public class ContentsExtractor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Result: "+parenBit(input));
    }

    public static String parenBit(String str){
        //base case is when the start is ( and end is )
        if(str.startsWith("(") && str.endsWith(")")){
            return str;
        }
        //check if the string start with opening parenthesis
        if(!str.startsWith("(")){
            return parenBit(str.substring(1));
        }

        //check if the string end with closing parenthesis
        if(!str.startsWith(")")){
            return parenBit(str.substring(0,str.length()-1));
        }
        return str;
    }
}
