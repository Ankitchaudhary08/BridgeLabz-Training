import java.util.LinkedList;
import java.util.Queue;

// Queue for vehicles waiting to enter the roundabout
public class WaitingQueue {

    private Queue<String> queue = new LinkedList<>();
    private final int capacity; // max queue size

    public WaitingQueue(int capacity) {
        this.capacity = capacity;
    }

    // Add vehicle to waiting queue
    public void enqueue(String vehicleNumber) {
        if (queue.size() == capacity) {
            System.out.println("Queue Overflow! Vehicle cannot enter: " + vehicleNumber);
            return;
        }
        queue.offer(vehicleNumber);
    }

    // Remove vehicle from queue
    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }
        return queue.poll();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
