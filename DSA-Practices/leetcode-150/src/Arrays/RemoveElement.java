package Arrays;

//https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
import java.util.Arrays;
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println("Before Removing Element:2 Array: "+Arrays.toString(nums));
        int res = removeElement(nums, 2);
        System.out.println("MisMatched Count: "+res);
        System.out.println("After Removing Element:2 Array: "+Arrays.toString(Arrays.copyOfRange(nums, 0,res)));
    }

    public static int removeElement(int[] nums, int val){
        int insertionIndex=0;
        for(int i=0;i<nums.length;i++){
            if(val != nums[i]){
                nums[insertionIndex] = nums[i];
                insertionIndex++;
            }
        }
        return insertionIndex;
    }
}
