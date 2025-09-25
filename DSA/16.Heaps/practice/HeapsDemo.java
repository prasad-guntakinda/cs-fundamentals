import java.util.PriorityQueue;

public class HeapsDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(10);
        heap.offer(30);
        heap.offer(5);
        heap.offer(1);
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        heap.offer(15);
        System.out.println(heap.peek());
    }
}
