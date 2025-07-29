public class SinglyLinkedList {
    private SLLNode head;

    public void insert(int data){
        var newNode = new SLLNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertAtIndex(int data, int index){
        
        if(index == 0){
            insert(data);
            return;
        }
            
        var newNode = new SLLNode(data);
        if(head == null){
            if(index == 0){
                head = newNode;
                return;
            }else{
                throw new IllegalArgumentException("Invalid Index: "+index);
            }
        }
        var curr = head;
        for(int i=0;i<index-1;i++){
            curr = curr.next;
            if(curr == null){
                throw new IllegalArgumentException("Invalid Index: "+index);
            }
        }
        newNode.next = curr.next;
        curr.next = newNode;

    }

    public void deleteAtIndex(int data, int index){
        if(head == null){
            throw new IllegalArgumentException("List is Empty.Invalid Index");
        }
        if(index == 0){
            head = head.next;   
            return;
        }
        var curr = head;
        for(int i=0;i<index-1;i++){
            curr = curr.next;
        }       

    }

    public void display(){
        System.out.print("[");
        var curr = head;
        while (curr != null) {
            System.out.print(+curr.data+ " , ");
            curr = curr.next;
        }
        System.out.println("]");
    }

     public SLLNode getHead(){
        return head;
     }
}
