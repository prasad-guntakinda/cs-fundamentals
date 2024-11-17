package Arrays;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDupsFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {-20,-10,-10,0,0,0,0,1,1,2,2,2,2,3};
        System.out.println("Before Removing Dups Array: "+ Arrays.toString(nums));
        int res = removeDups(nums);
        System.out.println("Unique Count: "+res);
        System.out.println("After Removing Dups Array: "+Arrays.toString(Arrays.copyOfRange(nums, 0,res)));
    }

    private static int removeDups(int[] nums) {
        int insertionIndex = 1;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[j-1]){
                nums[insertionIndex] = nums[j];
                insertionIndex++;
            }
        }
        return insertionIndex;
    }
}
