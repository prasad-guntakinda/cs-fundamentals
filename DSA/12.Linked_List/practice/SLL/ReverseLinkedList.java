public class ReverseLinkedList {
    
/**
 * Reverses a singly linked list using an iterative approach.
 * This method modifies the list in place and returns the new head of the reversed list.
 * @param head
 * @return
 */
    public SLLNode reverse(SLLNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: empty list or single node
        }

        SLLNode prev = null;
        SLLNode curr = head;

        while (curr != null) {
            SLLNode next = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev to current
            curr = next; // Move to next node
        }

        return prev; // New head of the reversed list
    }

/** * Reverses a singly linked list using recursion.
 * This method modifies the list in place and returns the new head of the reversed list.
 * @param head  
 * @return
 */
    public SLLNode reverseRecursively(SLLNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: empty list or single node
        }

        SLLNode newHead = reverseRecursively(head.next); // Reverse the rest of the list
        head.next.next = head; // Make the next node point to the current node
        head.next = null; // Set the current node's next to null

        return newHead; // Return the new head of the reversed list
    }
}
