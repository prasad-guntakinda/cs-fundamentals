# Hashing Problems List:

####### SCD-32 & 33

Q1. Check Pair Sum:
````text
Given an Array of integers arr, and a target sum K.
Check if there exists a pair (i,j) such that arr[i] + arr[j] = K and i!=j.
````
__code:__
````java
public int solve(int[] arr, int k) {
        HashSet < Integer > set = new HashSet < Integer > ();
        for(int i = 0 ; i < arr.length ; i++){
            if(set.contains(k - arr[i])){
                return 1;
            }
            set.add(arr[i]);
        }
        return 0;
    }
````



