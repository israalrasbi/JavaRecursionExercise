import java.util.Scanner;

public class LargestSubstringFinder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("Enter a substring: ");
        String sub = sc.nextLine();
        System.out.println("Result: "+strDist(str,sub));
    }

    public static Integer strDist(String str, String sub){
        //base case is when the start is ( and end is )
        if(!str.startsWith(sub) && !str.endsWith(sub) && !str.contains(sub)){
            return 0;
        }
        //check if the string start with the substring
        if(!str.startsWith(sub)){
            return strDist(str.substring(1), sub);
        }
        //check if the string end with the substring
        if(!str.endsWith(sub)){
            return strDist(str.substring(0,str.length()-1),sub);
        }
        return str.length();
    }
}
