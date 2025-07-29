public class LinkedListMidFinder {
    
    public int findMiddle(SLLNode head){
        
        var result = bruteForceMid(head);
        //result =  fastSlowPonters(head);
        return result;
    }

/**
 * Use two pointers, slow and fast.
 * Move slow one step and fast two steps in each iteration.
 * When fast reaches the end, slow will be at the middle.
 * @param head
 * @return
 */
    private int fastSlowPonters(SLLNode head) {
        if(head == null){
            throw new RuntimeException("List is Empty.");
        }
        
        var slow = head;
        var fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    /**
     * Brute-force approach:
     * find the size of list
     * return (size-1)/2 as a mid element
     * @param head
     * @return
     */
    private int bruteForceMid(SLLNode head){
        if(head == null){
            throw new RuntimeException("List is Empty.");
        }
        
        int length = 0 ;
        var curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        System.out.println("Length of LL: "+ length);
        int mid = (length-1)/2;
        curr = head;
        for(int i=0;i<mid;i++){
            curr = curr.next;
        }
        return curr.data;
    }
}
