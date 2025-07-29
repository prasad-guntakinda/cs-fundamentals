package SLL;

public class KthNodeFromEnd {
    /**
     * Find the kth node from the end of a singly linked list using two pointers.
     * The fast pointer moves k steps ahead, then both pointers move together until the fast pointer
     * reaches the end of the list.
     * The slow pointer will then be at the kth node from the end.  
     * Edge cases:
     * - If the list is empty or k is not positive, throw an exception.
     * - If k is larger than the size of the list, throw an exception.
     * @throws IllegalArgumentException if the list is empty or k is not positive, or if k is larger than the size of the list.
     * 
     * @param head
     * @param k
     * @return
     */
    public int findKthFromEnd(SLLNode head, int k) {
        if (head == null || k <= 0) {
            throw new IllegalArgumentException("Invalid input: List is empty or k is not positive.");
        }

        SLLNode slow = head;
        SLLNode fast = head;

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("k is larger than the size of the list.");
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data; // slow is now at the kth node from the end
    }

    /**
     * Find the kth node from the end of a singly linked list using brute force.
     * This method first calculates the length of the list, then traverses it again to find the kth node from the end.
     * @param head
     * @param k
     * @return
     */
    public int findKthFromEndBruteForce(SLLNode head, int k) {
        if (head == null || k <= 0) {
            throw new IllegalArgumentException("Invalid input: List is empty or k is not positive.");
        }

        // Calculate the length of the list
        int length = 0;
        SLLNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        if (k > length) {
            throw new IllegalArgumentException("k is larger than the size of the list.");
        }

        // Find the kth node from the end
        curr = head;
        for (int i = 0; i < length - k; i++) {
            curr = curr.next;
        }

        return curr.data; // curr is now at the kth node from the end

    }

    
    /**
     * Remove the kth node from the end of a singly linked list.
     * This method uses the two-pointer technique to find the kth node from the end and removes it.
     * Edge cases:
     * - If the list is empty or k is not positive, throw an exception. 
     * - If k is larger than the size of the list, throw an exception.
     * * @throws IllegalArgumentException if the list is empty or k is not positive, or if k is larger than the size of the list.
     * Why dummy node?
     * A dummy node is used to handle edge cases, such as when the head node needs to be removed.
     * This simplifies the logic for removing nodes, especially when the node to be removed is the head node.
     * 
     * @param head
     * @param k
     * @return
     */
    public SLLNode removeKthFromEnd(SLLNode head, int k) {
        if (head == null || k <= 0) {
            throw new IllegalArgumentException("Invalid input: List is empty or k is not positive.");
        }

        SLLNode dummy = new SLLNode(0); // Dummy node to handle edge cases
        dummy.next = head;
        SLLNode slow = dummy;
        SLLNode fast = dummy;

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast.next == null) {
                throw new IllegalArgumentException("k is larger than the size of the list.");
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the kth node from the end
        slow.next = slow.next.next;

        return dummy.next; // Return the modified list
    }
}
