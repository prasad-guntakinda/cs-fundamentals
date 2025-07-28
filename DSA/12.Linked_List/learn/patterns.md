# Linked List Patterns

<details>
<summary>Two-Pointer Fast-Slow Pointer/Runner Technique</summary>

## Two-Pointer Runner Technique

The **two-pointer runner technique** is a common algorithmic approach used to solve problems efficiently by using two pointers that traverse a data structure (usually a linked list or an array) at different speeds or positions. This technique is particularly useful for problems involving cycles, partitions, or finding specific elements.

---

### Key Idea
- Use two pointers, typically called `slow` and `fast`.
- The `slow` pointer moves one step at a time, while the `fast` pointer moves two steps (or more) at a time.
- The difference in speed or position helps identify patterns or solve problems efficiently.

---

### Example 1: Detecting a Cycle in a Linked List
**Problem**: Determine if a linked list contains a cycle.

**Algorithm:**
1. Initialize two pointers, `slow` and `fast`, both starting at the head of the linked list.
2. Move `slow` one step and `fast` two steps in each iteration.
3. If `fast` meets `slow`, a cycle exists.
4. If `fast` or `fast.next` becomes `null`, the list has no cycle.

**Code:**
```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            return true; // Cycle detected
        }
    }
    return false; // No cycle
}
```

---

### Example 2: Finding the Middle of a Linked List
**Problem**: Find the middle node of a linked list.

**Algorithm:**
1. Use two pointers, `slow` and `fast`.
2. Move `slow` one step and `fast` two steps in each iteration.
3. When `fast` reaches the end, `slow` will be at the middle.

**Code:**
```java
public ListNode findMiddle(ListNode head) {
    if (head == null) return null;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow; // Middle node
}
```

---

### Example 3: Merging Two Sorted Arrays
**Problem**: Merge two sorted arrays into one sorted array.

**Algorithm:**
1. Use two pointers, `i` and `j`, to traverse the two arrays.
2. Compare elements at `i` and `j` and add the smaller one to the result.
3. Move the pointer of the array from which the element was added.
4. Continue until one array is exhausted, then add the remaining elements of the other array.

**Code:**
```java
public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
    int i = 0, j = 0, k = 0;
    int[] result = new int[arr1.length + arr2.length];

    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
            result[k++] = arr1[i++];
        } else {
            result[k++] = arr2[j++];
        }
    }

    while (i < arr1.length) {
        result[k++] = arr1[i++];
    }

    while (j < arr2.length) {
        result[k++] = arr2[j++];
    }

    return result;
}
```

---

### Example 4: Partitioning an Array
**Problem**: Rearrange an array so that all negative numbers appear before positive numbers.

**Algorithm:**
1. Use two pointers, `left` and `right`.
2. Start `left` at the beginning and `right` at the end of the array.
3. Swap elements if `arr[left]` is positive and `arr[right]` is negative.
4. Move `left` and `right` pointers inward until they meet.

**Code:**
```java
public void partitionArray(int[] arr) {
    int left = 0, right = arr.length - 1;

    while (left < right) {
        if (arr[left] < 0) {
            left++;
        } else if (arr[right] > 0) {
            right--;
        } else {
            // Swap
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
```


---

## Fast-Slow Pointer vs Runner Technique

The terms **fast-slow pointer** and **runner technique** refer to the same underlying approach in algorithm design. Both involve using two pointers that traverse a data structure (like a linked list or array) at different speeds or positions.

#### Fast-Slow Pointer Technique
- Uses two pointers: one moves faster (e.g., two steps), the other slower (e.g., one step).
- Commonly used for cycle detection, finding the middle, etc.
- Example: Floyd’s Cycle Detection (Tortoise and Hare).

#### Runner Technique
- Another name for the fast-slow pointer method.
- "Runner" refers to the faster pointer, while the other is the slower "walker."
- Used in the same scenarios and with the same logic.

#### Summary
There is no practical difference; "runner technique" is just an alternative name for the "fast-slow pointer" approach. Both are interchangeable and mean using two pointers at different speeds to solve problems efficiently.


---

### Benefits of the Two-Pointer Technique
- **Efficiency**: Reduces time complexity by avoiding nested loops.
- **Simplicity**: Easy to implement and understand.
- **Versatility**: Works for arrays, linked lists, and other data structures.

</details>


---

<details>
<summary>Recursion for List Manipulation Pattern</summary>

## Recursion for List Manipulation Pattern

Recursion is a powerful technique for solving problems involving linked lists. It simplifies the logic by breaking the problem into smaller subproblems, often aligning naturally with the structure of a linked list. Each recursive call processes one node, and the base case handles the termination condition.

---

### Key Idea
- A linked list is inherently recursive because each node points to the next node, forming a chain.
- Recursive functions process one node at a time and delegate the rest of the work to the recursive call.
- Base cases typically involve reaching the end of the list (`null`).

---

### Example 1: Reverse a Linked List
**Problem**: Reverse a singly linked list using recursion.

**Algorithm:**
1. Base case: If the list is empty or has one node, return the head.
2. Recursive case: Reverse the rest of the list and adjust the pointers.

**Code:**
```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head; // Base case
    }

    ListNode reversedList = reverseList(head.next); // Recursive call
    head.next.next = head; // Adjust pointers
    head.next = null; // Set the current node's next to null

    return reversedList; // Return the new head
}
```

---

### Example 2: Check if a Linked List is a Palindrome
**Problem**: Determine if a linked list is a palindrome using recursion.

**Algorithm:**
1. Use a helper function with two pointers: one moves forward recursively, and the other moves backward using the call stack.
2. Compare the values of the nodes as the recursion unwinds.

**Code:**
```java
public boolean isPalindrome(ListNode head) {
    return checkPalindrome(head, head);
}

private boolean checkPalindrome(ListNode forward, ListNode backward) {
    if (backward == null) {
        return true; // Base case
    }

    boolean isPal = checkPalindrome(forward, backward.next) && (forward.val == backward.val);
    forward = forward.next; // Move forward pointer
    return isPal;
}
```

---

### Example 3: Merge Two Sorted Linked Lists
**Problem**: Merge two sorted linked lists into one sorted list using recursion.

**Algorithm:**
1. Base case: If one list is empty, return the other list.
2. Recursive case: Compare the heads of the two lists and merge the smaller one with the result of the recursive call.

**Code:**
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2; // Base case
    if (l2 == null) return l1; // Base case

    if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2); // Recursive call
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next); // Recursive call
        return l2;
    }
}
```

---

### Example 4: Remove Nodes with a Specific Value
**Problem**: Remove all nodes with a specific value from a linked list using recursion.

**Algorithm:**
1. Base case: If the list is empty, return `null`.
2. Recursive case: Check the current node's value and decide whether to include it in the result.

**Code:**
```java
public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
        return null; // Base case
    }

    head.next = removeElements(head.next, val); // Recursive call
    return head.val == val ? head.next : head; // Include or exclude the current node
}
```

---

### When to Use Recursion for List Manipulation
1. **Natural Fit**: When the problem can be broken into smaller subproblems that align with the structure of a linked list.
2. **Simpler Logic**: When recursion simplifies the code compared to iterative solutions.
3. **Divide and Conquer**: For problems like reversing, merging, or splitting lists.
4. **Backtracking**: For problems like checking palindromes or finding specific patterns.

---

### Summary
- **Advantages**: Simplifies logic, aligns with the recursive nature of linked lists.
- **Disadvantages**: May lead to stack overflow for very large lists.
- **Best Use Cases**: Reversing, merging, removing elements, and solving problems with backtracking.

</details>

---


<details>
<summary>Dummy Node Technique</summary>

## Dummy Node Technique

The **dummy node technique** is a pattern used to simplify linked list operations, especially when modifying the head node or handling edge cases. A dummy node is an extra node (often with a default value) placed before the actual head of the list. It helps avoid special-case logic for the head and makes code cleaner and less error-prone.

---

### Key Idea
- Create a new node (dummy) before the head of the list.
- Perform operations starting from the dummy node.
- At the end, return `dummy.next` as the new head.

---

### Example 1: Remove Elements from a Linked List
**Problem:** Remove all nodes with a specific value from a linked list.

**Algorithm:**
1. Create a dummy node and point its `next` to the head.
2. Use a pointer (`current`) to traverse the list starting from the dummy.
3. If `current.next.val` matches the target, remove the node.
4. Return `dummy.next` as the new head.

**Code:**
```java
public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;

    while (current.next != null) {
        if (current.next.val == val) {
            current.next = current.next.next; // Remove node
        } else {
            current = current.next;
        }
    }
    return dummy.next;
}
```

---

### Example 2: Merge Two Sorted Linked Lists
**Problem:** Merge two sorted linked lists into one sorted list.

**Algorithm:**
1. Create a dummy node to start the merged list.
2. Use a pointer (`tail`) to build the new list.
3. Compare nodes from both lists and attach the smaller one to `tail`.
4. Return `dummy.next` as the merged list head.

**Code:**
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            tail.next = l1;
            l1 = l1.next;
        } else {
            tail.next = l2;
            l2 = l2.next;
        }
        tail = tail.next;
    }
    tail.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

---

### Example 3: Reverse Nodes in k-Group
**Problem:** Reverse nodes of a linked list in groups of k.

**Algorithm:**
1. Use a dummy node to simplify head manipulation.
2. Use pointers to reverse each group and connect them.
3. Return `dummy.next` as the new head.

**Code:**
```java
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prevGroupEnd = dummy;

    while (true) {
        ListNode kth = prevGroupEnd;
        for (int i = 0; i < k && kth != null; i++) {
            kth = kth.next;
        }
        if (kth == null) break;

        ListNode groupStart = prevGroupEnd.next;
        ListNode nextGroupStart = kth.next;

        // Reverse group
        ListNode prev = nextGroupStart, curr = groupStart;
        while (curr != nextGroupStart) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        prevGroupEnd.next = kth;
        prevGroupEnd = groupStart;
    }
    return dummy.next;
}
```

---

### When to Use Dummy Node Technique

1. **Head Modification:** When the head node might be changed or removed.
2. **Edge Cases:** To avoid special-case logic for the first node.
3. **Insertion/Deletion:** When inserting or deleting nodes at the beginning or in the middle of the list.
4. **Simplifying Code:** To make code cleaner and easier to maintain.

---

### Summary
- **Advantages:** Simplifies code, handles edge cases uniformly, avoids special logic for head node.
- **Disadvantages:** Slightly increases memory usage (one extra node).
- **Best Use Cases:** Removing elements, merging lists, reversing groups, and any operation where the head might change.

</details>

---

<details>
<summary>In-place Reversal and Modification Technique</summary>

## In-place Reversal and Modification Technique

The **in-place reversal and modification technique** involves changing the structure or order of a linked list directly, without using extra space for another list or array. This is efficient in terms of space and is commonly used for reversing lists, reversing sublists, or modifying the list structure.

---

### Key Idea
- Rearrange the pointers of the nodes within the original list.
- No additional data structures are used (O(1) extra space).
- The original list is modified directly.

---

### Example 1: Reverse a Linked List In-place
**Problem:** Reverse a singly linked list in-place.

**Algorithm:**
1. Initialize three pointers: `prev` (null), `curr` (head), and `next` (null).
2. Iterate through the list, reversing the `next` pointer of each node.
3. At the end, `prev` will be the new head.

**Code:**
```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode next = curr.next; // Store next node
        curr.next = prev;          // Reverse pointer
        prev = curr;               // Move prev forward
        curr = next;               // Move curr forward
    }
    return prev; // New head
}
```

---

### Example 2: Reverse a Sublist (Between Positions m and n)
**Problem:** Reverse a portion of the list from position m to n in-place.

**Algorithm:**
1. Use a dummy node to simplify edge cases.
2. Move pointers to the start of the sublist.
3. Reverse the sublist using the standard reversal logic.
4. Reconnect the reversed sublist to the rest of the list.

**Code:**
```java
public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null) return null;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    for (int i = 1; i < m; i++) {
        prev = prev.next;
    }

    ListNode start = prev.next;
    ListNode then = start.next;

    for (int i = 0; i < n - m; i++) {
        start.next = then.next;
        then.next = prev.next;
        prev.next = then;
        then = start.next;
    }
    return dummy.next;
}
```

---

### Example 3: Reverse Nodes in k-Group
**Problem:** Reverse nodes of a linked list in groups of k in-place.

**Algorithm:**
1. Use a dummy node and pointers to identify each group.
2. Reverse each group using the in-place reversal logic.
3. Connect the reversed groups.

**Code:**
```java
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prevGroupEnd = dummy;

    while (true) {
        ListNode kth = prevGroupEnd;
        for (int i = 0; i < k && kth != null; i++) {
            kth = kth.next;
        }
        if (kth == null) break;

        ListNode groupStart = prevGroupEnd.next;
        ListNode nextGroupStart = kth.next;

        // Reverse group
        ListNode prev = nextGroupStart, curr = groupStart;
        while (curr != nextGroupStart) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        prevGroupEnd.next = kth;
        prevGroupEnd = groupStart;
    }
    return dummy.next;
}
```

---

### When to Use In-place Reversal and Modification

1. **Space Efficiency:** When you need to avoid extra space and modify the list directly.
2. **Performance:** When you want O(1) space and O(n) time.
3. **Reordering:** For reversing the entire list, sublists, or groups.
4. **Interview Problems:** Commonly asked in technical interviews for SDE roles.

---

### Summary
- **Advantages:** Saves space, efficient, modifies the original list.
- **Disadvantages:** Original list is changed; careful pointer manipulation required.
- **Best Use Cases:** Reversing lists, reversing sublists, reversing in groups, and any problem requiring in-place modification.

</details>

---

<details>
<summary>Cycle Detection and Removal Technique</summary>

## Cycle Detection and Removal Technique

Cycle detection and removal is a crucial pattern for linked lists, especially when dealing with problems where a list may unintentionally form a loop. Detecting cycles prevents infinite loops and memory leaks, and removing them restores the list to a proper linear structure.

---

### Key Idea
- Use two pointers (slow and fast) to detect a cycle (Floyd’s Tortoise and Hare algorithm).
- If a cycle is detected, find the starting node of the cycle.
- Remove the cycle by setting the last node’s next pointer to null.

---

### Example 1: Detect a Cycle in a Linked List
**Problem:** Determine if a linked list contains a cycle.

**Algorithm:**
1. Initialize two pointers, `slow` and `fast`, at the head.
2. Move `slow` one step and `fast` two steps in each iteration.
3. If `slow` and `fast` meet, a cycle exists.
4. If `fast` or `fast.next` becomes null, no cycle exists.

**Code:**
```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

---

### Example 2: Find the Starting Node of the Cycle
**Problem:** Find the node where the cycle begins.

**Algorithm:**
1. After detecting a cycle, reset one pointer to the head.
2. Move both pointers one step at a time; the node where they meet is the start of the cycle.

**Code:**
```java
public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            ListNode entry = head;
            while (entry != slow) {
                entry = entry.next;
                slow = slow.next;
            }
            return entry; // Start of cycle
        }
    }
    return null;
}
```

---

### Example 3: Remove the Cycle from a Linked List
**Problem:** Remove the cycle so the list becomes linear.

**Algorithm:**
1. Detect the cycle and find the starting node.
2. Traverse the cycle to find the node that points back to the start.
3. Set that node’s next pointer to null.

**Code:**
```java
public void removeCycle(ListNode head) {
    ListNode slow = head, fast = head;
    boolean hasCycle = false;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            hasCycle = true;
            break;
        }
    }
    if (!hasCycle) return;
    slow = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    // Now fast/slow is at the start of the cycle
    ListNode prev = fast;
    while (prev.next != fast) {
        prev = prev.next;
    }
    prev.next = null; // Remove cycle
}
```

---

### When to Use Cycle Detection and Removal

1. **Data Integrity:** When you need to ensure the linked list is properly terminated.
2. **Infinite Loop Prevention:** When traversing lists that may have cycles.
3. **Interview Problems:** Common in technical interviews for SDE roles.
4. **Memory Management:** To avoid memory leaks in applications.

---

### Summary
- **Advantages:** Prevents infinite loops, ensures data integrity, and avoids memory leaks.
- **Disadvantages:** Adds a small overhead for cycle checks.
- **Best Use Cases:** Detecting and removing cycles in linked lists, especially in interview and production scenarios.

</details>

---


