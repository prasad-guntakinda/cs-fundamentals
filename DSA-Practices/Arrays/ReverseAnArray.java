package Arrays;

import java.util.Arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        var input = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Input Array: "+ Arrays.toString(input));
        reverseArray(input, 0,input.length-1);
        System.out.println("All Elements Reversed Array: "+ Arrays.toString(input));
        reverseArray(input, 2,4);
        System.out.println("[2-4] Elements Reversed Array: "+ Arrays.toString(input));

    }

    public static void reverseArray(int[] ar, int startIndex, int endIndex){
        while(startIndex < endIndex){
            var temp = ar[startIndex];
            ar[startIndex] = ar[endIndex];
            ar[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
