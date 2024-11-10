# Arrays Easy Problems

<details>
<summary>Q1. Reverse of an Array [array, 2-pointers]</summary>

__Problem Statement:__
````text
Given array ar = [1,2,3,4,5] reverse the array
output: [5,4,3,2,1]
````

__Brute Force:__
````text
Approach-1:
    - Create a new array with same size
    - iterate original array from n-1 -> 0 and add the values to new array from 0 -> n-1
    - TC: O(n) SC: O(n)
````
__Optimization:__
````text
Two-Pointers Approach:
    - start first pointer from i=0 and second pointer from end j=n-1
    - swap(i,j) and do i++; j--;
    - TC: O(n) SC: O(1)
````

__Variations:__
````text
- Reverse part of an array
- Example: [1,2,3,4,5,6,7,8,9,10] reverse from 4 to 8
- Output: [1,2,3,8,7,6,5,4,9,10]
````

</details>

___


<details>
<summary>Q1.Problem Name [Sample Structure]</summary>

__Problem Statement:__


__Brute Force:__

__Optimization:__


__Notes:__

</details>
