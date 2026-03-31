// Circular Linked List Node for Process
class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;

    int waitingTime;
    int turnaroundTime;

    ProcessNode next;

    ProcessNode(int pid, int bt, int priority) {
        this.processId = pid;
        this.burstTime = bt;
        this.remainingTime = bt;
        this.priority = priority;
        this.next = null;
    }
}

// Round Robin Scheduler using Circular Linked List
class RoundRobinScheduler {

    private ProcessNode head;
    private ProcessNode tail;
    private int timeQuantum;
    private int time = 0;
    private int totalProcesses = 0;

    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at end
    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
        totalProcesses++;

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    // Remove process by ID
    private void removeProcess(int pid) {
        if (head == null) return;

        ProcessNode curr = head;
        ProcessNode prev = tail;

        do {
            if (curr.processId == pid) {

                if (curr == head) {
                    head = head.next;
                    tail.next = head;
                } else if (curr == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = curr.next;
                }

                totalProcesses--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Simulate Round Robin Scheduling
    public void simulate() {
        if (head == null) {
            System.out.println("No processes available");
            return;
        }

        ProcessNode current = head;

        System.out.println("Round Robin Scheduling Simulation:\n");

        while (totalProcesses > 0) {

            System.out.println("Executing Process P" + current.processId);

            if (current.remainingTime <= timeQuantum) {
                time += current.remainingTime;
                current.remainingTime = 0;
                current.turnaroundTime = time;
                current.waitingTime = current.turnaroundTime - current.burstTime;

                System.out.println("Process P" + current.processId + " finished");

                int finishedPid = current.processId;
                current = current.next;
                removeProcess(finishedPid);

            } else {
                current.remainingTime -= timeQuantum;
                time += timeQuantum;
                current = current.next;
            }

            displayQueue();
            System.out.println("------------------------");
        }
    }

    // Display current queue
    private void displayQueue() {
        if (head == null) {
            System.out.println("Queue empty");
            return;
        }

        ProcessNode temp = head;
        System.out.print("Current Queue: ");

        do {
            System.out.print(
                "P" + temp.processId +
                "(RT=" + temp.remainingTime + ")  "
            );
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }
}

// Class name is NOT Main
public class RoundRobinApp {
    public static void main(String[] args) {

        int timeQuantum = 4;
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        scheduler.simulate();
    }
}
