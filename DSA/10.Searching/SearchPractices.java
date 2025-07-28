import java.util.*;
public  class SearchPractices {
    public static void main(String[] args) {
        //int[] arr = {3, 6, 9, 10, 12, 17, 20, 22, 25, 35};
        //System.out.println("K found at : "+searchKThIndex(arr, 2));

        //int[] arr2={-5, -5, 3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 5, 8, 10, 10, 15, 15 };
        //int k=10;
        //System.out.println("First Occurence of K is:  "+findFirstOccurrenceOfK(arr2, k));

        //int[] arr3 = {8,8,6,6,5,5,2,9,9};//ans=6
        //System.out.println("Unique Element: "+findUniqueElement(arr3));

       // int[] arr4 = {1,3,5, 15, 20,2,1};//ans=5
       // System.out.println("Peak Element: "+findPeakElement(arr4));

        int[] arr5 = {5,2,1, -1,3,6};
        System.out.println("arr = "+Arrays.toString(arr5));
        System.out.println("Local Minima: "+findLocalMinima(arr5));
    }


    static int searchKThIndex(int[] arr, int k){
        System.out.println("Given Array: "+Arrays.toString(arr));
        System.out.println("Searching for an element: "+k);
        int left = 0, right = arr.length-1;

        while(left <= right){
            int mid = (left+right)/2; //or left+(right-left)/2 to avoid overflow issues
            System.out.println("mid: "+mid +"left: "+left+" right:"+right);
            if(arr[mid] == k){
                System.out.println("Element found at: "+mid);
                return mid; //target found at index=mid
            }
            if(arr[mid] > k){
                right = mid-1;
            }else {
                left = mid+1;
            }

        }
        System.out.println("Element Not found.");
        return -1;
    }

    static  int findFirstOccurrenceOfK(int[] arr, int k){
        int left=0, right=arr.length;
        int ans = -1;
        while (left <=right){
            int mid = left+(right-left)/2;
            if(arr[mid] == k){
                ans = mid;
                right = mid-1;
            }else if(arr[mid] > k){
                right = mid-1;
            }else {
                left = mid+1;
            }

        }
        return ans;
    }

    static int findUniqueElement(int[] arr){
        int left=0, right=arr.length-1;
        if(arr.length == 1){
            return arr[0];
        }
        //check if the unique element exists at index=0
        if(arr[0] != arr[1]){
            return arr[0];
        }
        //check if the unique element exists at index=N-1
        if(arr[arr.length-1] != arr[arr.length-2]){
            return arr[arr.length-1];
        }

        while(left <=right){
            int mid = left+(right-left)/2;
            //check arr[mid] is the unique element
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            //find the first occurence index of the duplicate number
            int firstOccurence;
            //element not found

            if(arr[mid] == arr[mid+1]){
                firstOccurence = mid;
            }else {
                firstOccurence = mid-1;
            }

            if(firstOccurence%2 ==0){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }

    static  int findPeakElement(int[] arr){
        int left=0, right=arr.length-1;
        while(left <= right){
            int mid = left+ (right-left)/2;
            if(arr[mid]> arr[mid-1] && arr[mid]> arr[mid+1]){
                return arr[mid];
            }
            //is mid on increasing slope?
            if(arr[mid]> arr[mid-1] && arr[mid]<arr[mid+1]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return Integer.MIN_VALUE;
    }

  static int findLocalMinima(int[] arr){
        if(arr.length == 1)
            return arr[0];

        if(arr[0]<arr[1])
            return arr[0];

        if(arr[arr.length-1]<arr[arr.length-2])
            return arr[arr.length-1];

        int left =0, right=arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            //check whether mid is the local minima or not
            if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
                return arr[mid];
            }
            // mid is greater than next element means local minima will be on the right array
            if(arr[mid] > arr[mid+1]){
                left = mid+1;
            }else {
                right = mid-1;
            }

        }
        return -1;
  }
}