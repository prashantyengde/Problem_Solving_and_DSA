package stackproblem;

import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElement {

    public int[] nextGreater(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove smaller elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack empty, no greater element
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push current element
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        NextGreaterElement solution = new NextGreaterElement();

        // Test Case 1
        int[] arr1 = {4, 5, 2, 10};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " +
                Arrays.toString(solution.nextGreater(arr1)));
        System.out.println("Expected: [5, 10, 10, -1]");
        System.out.println();

        // Test Case 2
        int[] arr2 = {3, 7, 1, 7, 8, 4};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " +
                Arrays.toString(solution.nextGreater(arr2)));
        System.out.println("Expected: [7, 8, 7, 8, -1, -1]");
        System.out.println();

        // Test Case 3
        int[] arr3 = {9, 8, 7};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " +
                Arrays.toString(solution.nextGreater(arr3)));
        System.out.println("Expected: [-1, -1, -1]");
        System.out.println();

        // Test Case 4
        int[] arr4 = {1, 2, 3, 4};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " +
                Arrays.toString(solution.nextGreater(arr4)));
        System.out.println("Expected: [2, 3, 4, -1]");
    }
}