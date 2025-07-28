# Hashing:


Two Data Structures use hashing technique:
        
        1. HashSet
        2. HashMap
__Common Properties:__
- Follows Same hashing technique to store the elements
- Insertion, Deletion, Searching takes O(1) time
- No Order and No Index
- 

### 1. HashSet:
- HashSet stores collection of unique elements


### 2. HashMap:
- Collection of key-value pairs
- To retrieve the value associated with the key takes O(1) time
- Examples:
  - To maintain Hotel Rooms and it's availability: `HashMap<Integer, Boolean>`
  - Countries and it's number of states: `HashMap<String, Integer>`
  - Names of the States in each country: `HashMap<String, List<String>>`

- Java allows Both Primitives and Objects as keys
- Keys must be unique
- Keys won't be stored in any order
- 

__Utility Methods:__

Java API Docs:<<https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html>>

````text
    boolean isEmpty()
    int size();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    V put(K key, V value);
    V remove(Object key)
    default V getOrDefault(K key, V defaultValue)
    // For more methods see above api docs
````


### Problems:

Problem-1. Given N elements and Q queries find the frequency of the element:
__Example:__
````text
      arr = [2, 5, 6, 10, 9, 3, 2, 6, 1, 2, 3]
      queries = [1,2,6,10]
````
__Approach:__
- Iterate over an array and store array element as a key and repetition count as a value in the HashMap
- Iterate over queries and find count in the HashMap
- TC: O(N+Q) SC: O(N)



Problem-2: Given N elements find the first non-repeating elements
__Example:__
````text
      arr = [2, 5, 6, 10, 9, 3, 2, 6, 1, 2, 3]
      ans = 5 is first non-repeating element
````
__Approach:__
- Iterate over an array and store array element as a key and repetition count as a value in the HashMap
- Iterate over an array again and find the first element whose count==1 in the HashMap
- TC: O(N) SC: O(N)



__Problem-3:__ Sub Array Sum equals to Zero
Given an array of N elements check if there exists a sub array with sum is zero.
````text
    arr = [ 2, 2, 1, -3, 4, 3, 1, -2, -3, 2 ]
    output: true
````
__Brute Force:__
- Create Subarrays and find the sum of the sub array is zero or not.
- Iterate over each sub array TC: O(N^2) and Calculating Sum TC: O(N) total TC: O(N^3)

__Code:__
````java
    arr = [ 2, 2, 1, -3, 4, 3, 1, -2, -3, 2 ]
    //start point of the subarrays    
    for(int i=0; i<n;i++){
        //end point of the subarrays
        for(int j=i;j<n;j++){
            int sum =0;
            //i,j defines the subarrays start and end points
            for(int k=i;k<=j;k++){
                sum += arr[k];    
            }
            if(sum ==0)
                return true;
        }    
    }
````
__Brute Force Optimization:__

__Code:__
````java
boolean isSubArrayExistsWithSumZero(){
  int[] arr = { 2, 2, 1, -3, 4, 3, 1, -2, -3, 2 };
  //start point of the subarrays    
  for(int i=0; i<n;i++){
    int sum =0;
    //end point of the subarrays
    for(int j=i;j<n;j++){
      sum += arr[j];
      if(sum ==0)
        return true;
    }
  }
  return false;
}
````

__Optimization-1: Prefix Sum__
__Code:__
````java
boolean isSubArrayExistsWithSumZero(){
  int[] arr = { 2, 2, 1, -3, 4, 3, 1, -2, -3, 2 };
  //calculate prefix Sum array
  int[] pfSum = new int[arr.length];
  pfSum[0] = arr[0];
  for(int i=1; i<arr.length;i++){
    pfSum[i] = pfSum[i-1]+arr[i];
  }
  int sum=0;
  for(int i=0;i<pfSum.length;i++){
      for(int j=i;j<arr.length;j++){
          if(j==0){
              sum += pfSum[j];
          }else {
              //range sum of [L, R] = pfSum[R]-pfSum[L-1] 
              sum += pfSum[j] - pfSum[i-1];
          }
          
          if(sum == 0){
              return true;
          }
      }
  }
  return false;
}
// in the above sum = pfSum[j]-pfSum[i-1] ==0 return true i.e same as pfSum[j] == pfSum[i-1]
// i.e if prefix Sum has i-1th and jth are equals means sum of that subarray [i,j] is zero  
````

__Observation:__

````text
  index =   0, 1, 2, 3,  4, 5, 6, 7,  8,  9
    arr = [ 2, 2, 1, -3, 4, 3, 1, -2, -3, 2 ];
  pfSum = [ 2, 4, 5, 2, 6, 9, 10, 8, 5, 7]
````
- If the pfSum array contains a repeated elements means, sub-array between those two elements has sum is zero
- In the above Example: 
- pfSum[0] == pfSum[3] means sum of [L+1, R] == 0 => [1, 3] = sum of [2, 1, -3] = 0
- pfSum[2] == pfSum[8] means sum of [L+1, R] == 0 => [3, 8] = sum of [-3, 4, 3, 1, -2, -3] = 0
- If we have a element with `0` then that is also a subarray with sum ==0
- Even single element is also a sub array
__Final Optimization:__
- Calculate Prefix Sum array
- If pfSum array contains a zero or if it has a repeated value then the array contains a subarray with sum==0
- How to know if pfSum has a repeated element?
- Iterate over the pfSum array if pfSum[i] == 0 then we found subarray with sum zero or check if pfSum[i] contains in a HashSet, if yes return true, otherwise store pfSum[i] inside the hashset

__Code:__
```java
boolean isSubArrayExistsWithSumZero(){
  int[] arr = { 2, 2, 1, -3, 4, 3, 1, -2, -3, 2 };
  //calculate prefix Sum array
  int[] pfSum = new int[arr.length];
  pfSum[0] = arr[0];
  for(int i=1; i<arr.length;i++){
    pfSum[i] = pfSum[i-1]+arr[i];
  }
  int sum=0;
  HashSet<Integer> duplicates = new HashSet();
    for (int sum : pfSum) {
        if (sum == 0 || duplicates.contains(sum)) {
            return true;
        } else {
            duplicates.add(sum);
        }
    }
  return false;
}
```



