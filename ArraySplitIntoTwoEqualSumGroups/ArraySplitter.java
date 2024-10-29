import java.util.*;

public class ArraySplitter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //get the input for the array using getInputArray
        int[] arr = getInputArray();

        //if the array is empty, exit
        if (arr.length == 0) {
            System.out.println("No valid elements were entered");
            return;
        }

        //print the result
        System.out.println("Can the array be split? " + splitArray(arr));

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

    public static Boolean splitArray(int[] nums) {
        return split(0, nums, 0, 0);
    }

    public static Boolean split(int index, int[] arr, int sum1, int sum2) {
        //base case when I reach the end of the array
        if (index == arr.length) {
            return sum1 == sum2;
        }

        int currentElement = arr[index];
        return split(index + 1, arr, sum1 + currentElement, sum2) ||
                split(index + 1, arr, sum1, sum2 + currentElement);
    }


}
