# Linked List Data Structure

---
## Linked List Concepts for Beginners

A **linked list** is a linear data structure where elements (nodes) are connected using pointers. Each node contains data and a reference to the next node. Linked lists are dynamic and allow efficient insertion and deletion.

### Types of Linked Lists
1. **Singly Linked List (SLL):**
   - Each node points to the next node.
   - Simple and memory efficient.
   - Use when you only need forward traversal.
2. **Doubly Linked List (DLL):**
   - Each node points to both the next and previous nodes.
   - Allows forward and backward traversal.
   - Use when you need to traverse in both directions or delete nodes efficiently.
3. **Circular Linked List (CLL):**
   - Last node points back to the first node.
   - Can be singly or doubly circular.
   - Use for applications that require cycling through elements (e.g., round-robin scheduling).

### When to Use Each Type
- **SLL:** Simple lists, stacks, queues, when memory is a concern.
- **DLL:** When you need bidirectional traversal or frequent deletions.
- **CLL:** When you need to loop through the list repeatedly.

### Key Operations
- **Traversal:** Visit each node in the list.
- **Insertion:** Add a node at the beginning, end, or any position.
- **Deletion:** Remove a node from the beginning, end, or any position.
- **Searching:** Find a node with a specific value.
- **Reversal:** Reverse the order of nodes.

### Node Structures

- **Singly Linked List Node:**
  ```java
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }
  ```
- **Doubly Linked List Node:**
  ```java
  public class DoublyListNode {
      int val;
      DoublyListNode next, prev;
      DoublyListNode(int val) {
          this.val = val;
      }
      DoublyListNode(int val, DoublyListNode next, DoublyListNode prev) {
          this.val = val;
          this.next = next;
          this.prev = prev;
      }
  }
  ```
- **Circular Linked List Node:**
  - Structure is same as SLL or DLL, but the last node's `next` (or `prev` for DLL) points to the first node.

### Sample Projects to Build with Linked Lists

1. **Custom Stack and Queue Implementations**
   - Build stack and queue data structures using singly and doubly linked lists.
2. **LRU (Least Recently Used) Cache**
   - Implement an efficient cache using a doubly linked list and a hash map.
3. **Text Editor Undo/Redo Functionality**
   - Use doubly linked lists to manage undo/redo operations.
4. **Music Playlist Manager**
   - Create a playlist app using circular linked lists to cycle through songs.
5. **Polynomial Arithmetic**
   - Represent polynomials as linked lists and implement addition, subtraction, and multiplication.
6. **Browser History Navigation**
   - Use doubly linked lists to navigate back and forth in browser history.
7. **Snake Game**
   - Model the snake’s body as a linked list for easy growth and movement.
8. **Sparse Matrix Representation**
   - Store non-zero elements of a matrix using linked lists for efficient memory usage.
9. **Implementing Hash Table with Chaining**
   - Use linked lists to handle collisions in hash tables.
10. **Memory Management Simulator**
    - Simulate memory allocation and deallocation using linked lists.

### Project Details

1. **Custom Stack and Queue Implementations**
   - Implement stack (LIFO) and queue (FIFO) using linked lists.
   - Practice push, pop, enqueue, dequeue, and peek operations.
   - Learn about time complexity and edge cases.

2. **LRU (Least Recently Used) Cache**
   - Build a cache that evicts the least recently used item when full.
   - Use a doubly linked list for ordering and a hash map for fast access.
   - Practice efficient insert, delete, and update operations.

3. **Text Editor Undo/Redo Functionality**
   - Use a doubly linked list to store states or actions.
   - Implement undo (move to previous) and redo (move to next) features.
   - Learn about bidirectional traversal and state management.

4. **Music Playlist Manager**
   - Model a playlist as a circular linked list.
   - Implement play next, play previous, add, and remove song features.
   - Practice circular traversal and dynamic updates.

5. **Polynomial Arithmetic**
   - Represent each term of a polynomial as a node in a linked list.
   - Implement addition, subtraction, and multiplication of polynomials.
   - Learn about node manipulation and mathematical operations.

6. **Browser History Navigation**
   - Use a doubly linked list to store visited URLs.
   - Implement back and forward navigation.
   - Practice bidirectional traversal and node updates.

7. **Snake Game**
   - Model the snake’s body as a linked list, where each node is a segment.
   - Implement movement, growth, and collision detection.
   - Learn about dynamic updates and real-time manipulation.

8. **Sparse Matrix Representation**
   - Store only non-zero elements of a matrix in a linked list.
   - Implement efficient storage and retrieval.
   - Practice memory optimization and traversal.

9. **Implementing Hash Table with Chaining**
   - Use linked lists to handle collisions in hash tables.
   - Implement insert, search, and delete operations.
   - Learn about hashing and collision resolution.

10. **Memory Management Simulator**
    - Simulate allocation and deallocation of memory blocks using linked lists.
    - Implement free list management and block merging.
    - Practice real-world memory management concepts.

### Implementation Guidance for Sample Projects

1. **Custom Stack and Queue Implementations**
   - Define node and list classes.
   - For stack: implement push, pop, peek using SLL.
   - For queue: implement enqueue, dequeue, peek using SLL or DLL.
   - Write test cases for edge conditions (empty, single element).

2. **LRU Cache**
   - Use a DLL for ordering and a HashMap for O(1) access.
   - Implement get(key) and put(key, value) methods.
   - Move accessed nodes to the front; remove least recently used from the end.

3. **Text Editor Undo/Redo**
   - Use DLL nodes to store editor states or actions.
   - Implement undo by moving to prev, redo by moving to next.
   - Maintain a current pointer for the active state.

4. **Music Playlist Manager**
   - Use a circular linked list for songs.
   - Implement addSong, removeSong, playNext, playPrevious methods.
   - Handle edge cases for single song and empty playlist.

5. **Polynomial Arithmetic**
   - Define a node for each term (coefficient, exponent).
   - Implement add, subtract, multiply by traversing and manipulating nodes.
   - Sort terms by exponent for easier operations.

6. **Browser History Navigation**
   - Use DLL nodes for URLs.
   - Implement visit, back, forward methods.
   - Maintain a current pointer for navigation.

7. **Snake Game**
   - Use SLL or DLL for snake segments.
   - Implement move, grow, and collision detection.
   - Update head and tail pointers as the snake moves.

8. **Sparse Matrix Representation**
   - Define node for non-zero elements (row, col, value).
   - Implement insert, delete, search for elements.
   - Traverse list to access matrix elements.

9. **Hash Table with Chaining**
   - Use array of linked lists for buckets.
   - Implement insert, search, delete in each bucket.
   - Handle collisions by adding to the linked list.

10. **Memory Management Simulator**
    - Use linked list nodes for memory blocks (size, address).
    - Implement allocate, free, merge operations.
    - Traverse and update the free list as needed.

---

__Visualization:__

https://pythontutor.com/render.html#mode=display
