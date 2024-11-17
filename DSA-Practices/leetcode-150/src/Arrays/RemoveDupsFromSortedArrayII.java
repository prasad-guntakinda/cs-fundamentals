package Arrays;

import java.util.Arrays;

public class RemoveDupsFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1,1,2,2,3};
        System.out.println("Before Removing Dups Array: "+ Arrays.toString(nums));
        int res = removeDups(nums);
        System.out.println("Unique Count: "+res);
        System.out.println("After Removing Dups Array: "+Arrays.toString(Arrays.copyOfRange(nums, 0,res)));
    }
    public static int removeDups(int[] nums) {

        int insertionIndex=0, count=1;

        for(int j=1;j<nums.length;j++){
            if(nums[j] == nums[j-1]){
                count++;
            }else {
                insertionIndex = insertByCount(nums,insertionIndex,count,nums[j-1]);
                insertionIndex++;
                count=1;
            }
            if(j == nums.length-1){
                insertionIndex = insertByCount(nums,insertionIndex,count,nums[j]);
                insertionIndex++;
            }
        }

        return insertionIndex;

    }

    private static int insertByCount(int[] nums, int index, int count, int val){
        if(count == 1){
            nums[index] = val;
        }else if(count>=2){
            nums[index] = val;
            nums[++index] = val;
        }
        return index;

    }
}
