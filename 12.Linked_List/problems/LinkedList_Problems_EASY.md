# Linked List Easy Problems Set



<details>
<summary>Q1.Reverse a Linked List:</summary>

__problem statement:__
````text
Given a Head Node reverse the Linked List

````

__Approach:__
- Maintain Two Pointer one for prev and another for navigation
- While moving towards end prev pointer will become head

__code:__
````java
public  static ListNode reverse(ListNode head){
    ListNode prev = null;
    var curr = head;
    while(curr !=null){
        var temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
    }

    head = prev;
    return head;
}
````

</details>

___

<details>
<summary>Q2.Find the Middle of Linked List:</summary>

__problem statement:__
```text
Given a Head Node return whether given Linked List is a Palindrome or not

```
__Approaches:__

- If Linked List length is **Odd** then only one node is middle node, otherwise two middle nodes

__1. Finding Length and Dividing (Double-Traversal):__

- Find the length of the linked list
- Diving by 2 to get the middle element 
- Navigate until (len-1)/2 why not len/2 ? For even len we want mid to point for the first middle, if we make (len-1)/2 it works for both use cases.
 
 
![find_middle_double_traversal.png](../images/find_middle_double_traversal.png)


__2.Two-Pointers: Fast & Slow Pointer Approach__
 
- The efficient approach is to traverse through the linked list using two-pointers i.e slow pointer and fast pointer. 
- Increment **slow_ptr** by 1 step and **fast_ptr** by 2 steps, As a result, the fast pointer will travel double than that of the slow pointer. 
- So When the fast pointer will reach to the end of the linked list, slow point would still be at the middle of the linked list.

![fast_slow_mid_1.png](../images/fast_slow_mid_1.png)


        - Initialize two pointers slow_ptr and fast_ptr and point both of them to the head node.
        - Until fast_ptr is NULL or the next of fast_ptr is NULL, move slow_ptr by one step and fast_ptr by two steps at the same time.
        - As we can see slow_ptr is pointing towards the middle of the Linked List. Hence return the slow_ptr.
__CODE:__


![fast_slow_mid_code.png](../images/fast_slow_mid_code.png)


</details>

___

<details>
<summary>Q3.Palindrome:</summary>

__problem statement:__
```text
Given a Head Node return whether given Linked List is a Palindrome or not

```

__Approaches:__

__1. Brute Force:__
- Create a deep copy
- Reverse copied Linked List
- Navigate both linked lists and verify whether all the nodes are same or not.
- TC: O(N) SC: O(N) to hold the deep copy LL

__2. Optimized:__

- Divide the LL into two parts
- Reverse the second part
- compare both the linked lists
- TC: O(N) SC: O(1) No extra space

````java
public static boolean isListPalindrome(ListNode head){
    //find the middle node
    var mid = findMid(head);
    //divide into 2 parts
    var h2 = mid.next;
    mid.next = null;
    //reverse part-2
    h2 = reverse(h2);
    //compare both the parts
    while(h2 != null && head.val == h2.val){
        head = head.next;
        h2 = h2.next;
    }

    return h2 == null;

}
````

</details>

___

<details>
<summary>Q4.Intersection of Two Linked Lists:</summary>

__Problem Statement:__
````text
Given two Linked Lists with sizes M and N.
Check whether two LLs are intersected
````
![linked_list_intersection.png](../images/linked_list_intersection.png)


__Brute Force: HashSet__
- Iterate over first LL and store all nodes in a Hashset
- While Iterating second LL check for each node if it exists in HashSet or not.
- If Yes, there is an intersection. 
- TC: O(M+N) SC: O(M) or O(N) sizes of the LL which stored in HashSet

__Optimization: Two Pointers__
- Find the lengths of both LLs ( M, N)
- Whichever LL length is more move large LL pointer with difference(M-N) if M>N
- For Example, M=6 and N=4 then move M length LL pointer to 2 nodes then both LLs are at same length
- Now iterate both the pointers together and check both ponters are same or not

````java
public static  boolean isLLsIntersected(ListNode h1, ListNode h2){
    if(h1 == null || h2 == null)
        return false;

    var h1Len = findLength(h1);
    var h2Len = findLength(h2);

    if(h1Len > h2Len){
        var diff = h1Len-h2Len;
        while (diff>0){
            h1 = h1.next;
            diff--;
        }
    }else if(h2Len > h1Len){
        var diff = h2Len-h1Len;
        while (diff>0){
            h2 = h2.next;
            diff--;
        }
    }

    while(h1 != null && h2 != null){
        if(h1 == h2){
            System.out.println("Lists Intersected at: "+h1.val);
            return true;
        }
        h1 = h1.next;
        h2 = h2.next;
    }
    return false;
}

private static int findLength(ListNode h1) {
    var temp = h1;
    var len = 0;
    while (temp != null){
        len++;
        temp = temp.next;
    }
    return len;
}
````

__Q4.1 Intersection of Two Linked Lists:__

__Problem Statement:__
````text
If we know intersection is already present then finding intersection point
````

![intersection_LLs_problem_2.png](../images/intersection_LLs_problem_2.png)

__Approach:__

![intersection_LLs_problem_2.png](../images/intersection_LLs_problem_2_sol.png)



</details>

___


<details>
<summary>QX.Problem Name [Sample Structure]</summary>

__Problem Statement:__


__Brute Force:__

__Optimization:__


__Notes:__

</details>

___

