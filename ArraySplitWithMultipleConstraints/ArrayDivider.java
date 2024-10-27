import java.util.*;

public class ArrayDivider {
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
        System.out.println("Can the array be split? " + split53(arr));

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

    public static boolean split53(int[] nums) {
        //call helper function, and put the initial parameters
        return split2(0, nums, 0, 0);
    }

    public static boolean split2(int index, int[] arr, int sum1, int sum2) {
        //base case is when I reach the end of the array, so all the elements are processed
        if (index == arr.length) {
            return sum1 == sum2;
        }

        //get the current element
        int currentElement = arr[index];

        //check if the current number is a multiple of 5
        if (currentElement % 5 == 0) {
            //add the current element to the first group
            return split2(index + 1, arr, sum1 + currentElement, sum2);
        }

        //check if the current number is a multiple of 3
        if (currentElement % 3 == 0) {
            //add the current element to the second group
            return split2(index + 1, arr, sum1, sum2 + currentElement);
        }

        //otherwise, add the current element to either group
        return split2(index + 1, arr, sum1 + currentElement, sum2) ||
                split2(index + 1, arr, sum1, sum2 + currentElement);
    }


}
