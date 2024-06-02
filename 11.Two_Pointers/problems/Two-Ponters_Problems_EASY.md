# Two-Pointer Problems Easy

<details>
<summary>1.Reverse an Array or Part of an Array</summary>

__problem statement:__
````text
Given an Array of integers arr, reverse the array.
arr = [1, 2, 3, 4, 5, 6] output: [6, 5, 4, 3, 2, 1]

````
__code:__
````java

````
__Notes:__
</details>

<details>
<summary>2.Valid Palindrome</summary>

__problem statement:__
````text
- A palindrome is a word, phrase, number, or other sequence of symbols that reads the same backwards as forwards
- Examples:

            - Words: "Level", "madam", "racecar"
            - Numbers: 22, 1234321, 2002
            - Dates and times: 12/21/33 12:21
            - Sentences: "Adam, I'm Ada!", "Ma is as selfless as I am", "Poor Dan is in a droop", "Leon sees Noel"

````
**Approaches:**
1. **Brute-force:**
    - Convert current string to char array
    - iterate over each char and store it int the new array
    - compare each index char is same or not. it all indexes are same then it is `palindrome`
2. **Optimization:**
- use two-pointer approach first pointer start from `i=0` and another from `j=n-1` move towards opposite direction
- compare `str.charAt(i) == str.charAt(j)` if both chars are same then `i++` and `j--`, otherwise return given string is not palindrome

```java
//    str = 'abcdedcba';
public static boolean isPalindrome(String str){
    int n=str.length();
    int i=0;
    int j=n-1;
    while(i<j){
        if(str.charAt(i) == str.charAt(j)){
            i++;
            j--;
        }else {
            return false;
        }
    }
    return true;
}
```
</details>
