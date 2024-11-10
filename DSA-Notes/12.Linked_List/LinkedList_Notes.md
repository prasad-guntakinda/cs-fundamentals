# Linked List Data Structure

- A linked list is a linear data structure that consists of a series of nodes connected by pointers. 
- Each node contains **data** and **a reference** to the next node in the list. 
- Unlike arrays, linked lists allow for efficient **insertion or removal** of elements from any position in the list, as the nodes are not stored contiguously in memory.

### Types of Linked Lists:
    
        1. Singly Linked List(SLL): data + one pointer to the next node
        2. Doubly Linked List(DLL): data + two pointers one for next node and another for previous node
        3. Circular Linked List(CLL): SLL + last node pointer points to the first node to make a circular

### Structure of Singly Linked List:

```java
public class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
```

### Operations on Linked List:

- Most of the operations first/head node of the Linked List will be given.

__1.Traverse SLL:__

````java
public static void traverse(ListNode head){
        var temp = head;
        while(temp != null){
            System.out.print(temp.val+" --> ");
            temp = temp.next;
        }
        System.out.println();
}
````

__2.Insertion:__

```java
    import java.util.Objects;

    public  static ListNode insertAtStart(ListNode head, ListNode new_node){
        if(head == null)
            return new_node;

        new_node.next = head;
        head = new_node;
        return head;
    }

    public  static ListNode insertAtEnd(ListNode head, ListNode new_node){
        if(head == null)
            return new_node;

        var temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new_node;
        return head;
    }
    //Assumption: index starts from 0
    public  static ListNode insertAtK(ListNode head, ListNode new_node, int pos){
        if(pos == 0)
            return  insertAtStart(head,new_node);
        var temp = head;

        while(temp != null && (pos-1)>0){
            temp = temp.next;
            pos--;
        }
        if(pos <0){
            throw new IllegalArgumentException("Invalid Position has given");
        }
        var next_node = Objects.requireNonNull(temp).next;
        temp.next = new_node;
        new_node.next = next_node;
        return head;
    }
```

__3.Deletion:__

````java
    public static ListNode deleteAtStart(ListNode head){
        if(head !=null){
            return head.next;
        }

        return head;
    }

    public static ListNode deleteAtEnd(ListNode head){
        if(head == null || head.next ==null)
            return null;

        var temp = head;

        while(temp.next != null && temp.next.next !=null){
            temp = temp.next;
        }

        temp.next = null;
        return head;

    }

    public  static ListNode deleteAtK(ListNode head, int pos){
        if(pos == 0)
            return deleteAtStart(head);
        var temp = head;
        while(temp != null && (pos-1)>0){
            temp = temp.next;
            pos--;
        }
        if(pos < 0){
            throw  new IllegalArgumentException("Invalid Position has given");
        }

        var del_node = temp.next;
        temp.next = temp.next.next;
        del_node.next = null;
        return  head;
    }
````


__Examples__

1. 

__Visualization:__

https://pythontutor.com/render.html#mode=display




    


