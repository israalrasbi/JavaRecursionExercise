import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //get the input for the array using getInputArray
        int[] arr = getInputArray();

        //if the array is empty, exit
        if (arr.length == 0) {
            System.out.println("No valid elements were entered");
            return;
        }

        System.out.print("Enter the index: ");
        int index = sc.nextInt();

        //print the result
        System.out.println("Is number followed by multiple of ten? " + array220(arr, index));

    }

    public static boolean array220(int[] numArray, int index) {
        //base case
        //check if the array has fewer than 2 elements remaining from the current index
        if (index >= numArray.length - 1) {
            return false;
        }
        //check if next element is current element multiple of ten
        if (numArray[index + 1] == numArray[index] * 10) {
            return true;
        }
        //if not, recursive call
        return array220(numArray, index + 1);

    }

    public static int[] getInputArray() {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        String input = ""; // initialize the input variable
        System.out.println("Enter the elements of the array (integers), when finished enter -q:");

        //keep looping until the user enters -q
        while (!input.equalsIgnoreCase("-q")) {
            input = sc.nextLine();

            //if not empty, and not -q, then add the elements to the list
            if (!input.trim().isEmpty() && !input.equalsIgnoreCase("-q")) {
                try {
                    int num = Integer.parseInt(input);  // convert string to integer
                    inputList.add(num);  // add the integer to the list
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                }
            } else if (input.trim().isEmpty()) {
                System.out.println("Invalid input! Please enter a non-empty string.");
            }
        }

        //convert the list to an int array
        int[] arr = new int[inputList.size()];
        for (int i = 0; i < inputList.size(); i++) {
            arr[i] = inputList.get(i);
        }
        return arr;
    }
}
