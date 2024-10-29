import java.util.*;

public class GroupSumWithConstraints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index: ");
        int index = sc.nextInt();

        //get the input for the array using getInputArray
        int[] arr = getInputArray();

        //if the array is empty, exit
        if (arr.length == 0) {
            System.out.println("No valid elements were entered");
            return;
        }

        System.out.println("Enter the target: ");
        int target = sc.nextInt();

        //print the result
        System.out.println("Can the array be grouped? " + groupSum5(index, arr, target));

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

    public static Boolean groupSum5(int index, int[] nums, int target) {
        //base case is when the target is 0
        if (index >= nums.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        int currentElement = nums[index];
        //check if it's multiple of 5
        if (currentElement % 5 == 0) {
            //check if the next number is followed by 1
            if (index < nums.length - 1 && nums[index + 1] == 1) {
                //start searching after the number 1
                return groupSum5(index + 2, nums, target - currentElement);
            }
            //otherwise, start searching from the next number
            return groupSum5(index + 1, nums, target - currentElement);
        }
        //check if there is no multiple of 5
        //check if the sum can be reached including the current number
        if (groupSum5(index + 1, nums, target - currentElement)) {
            return true;
        }
        //check if the sum can be reached excluding the current number
        return groupSum5(index+1, nums, target);
    }

}
