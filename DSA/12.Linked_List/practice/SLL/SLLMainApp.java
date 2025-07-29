public class SLLMainApp {
    public static void main(String[] args) {
        var midFinder = new LinkedListMidFinder();
        var sll = new SinglyLinkedList();
        sll.insert(10);
        sll.insert(20);
        sll.insert(30);
        sll.insert(40);
        sll.display();
        System.out.println("Mid of the element: "+ midFinder.findMiddle(sll.getHead()));
        System.out.println("Insert 111 at pos: 2");
        sll.insertAtIndex(111, 2);
         sll.display();
         System.out.println("Insert 333 at pos: 5");
        sll.insertAtIndex(333, 5);
        sll.display();
        System.out.println("Insert 999 at pos: 0");
        sll.insertAtIndex(999, 0);
        sll.display();
        System.out.println("Insert 555 at pos: 20");
        try {
            sll.insertAtIndex(555, 20);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println("Mid of the element: "+ midFinder.findMiddle(sll.getHead()));
       
    }
}
