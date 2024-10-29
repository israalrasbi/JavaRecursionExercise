import java.util.*;

public class IdenticalValuesGroupSum {
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
        System.out.println("Can the array be grouped? " + groupSumClump(index, arr, target));

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

    public static Boolean groupSumClump(int index, int[] nums, int target) {
        //base case is when the target is 0
        if (index >= nums.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        int currentElement = nums[index];
        int i = index + 1;
        //loop through the list to see if there is any clumps
        for (; i < nums.length && nums[i] == nums[index]; i++) {
            //if yes, then calculate the sum of the clumps
            currentElement += nums[i];
        }
        //include the clump
        if (groupSumClump(i, nums, target - currentElement)) {
            return true;
        }
        //exclude the clump
        return groupSumClump(i, nums, target);
    }
}
