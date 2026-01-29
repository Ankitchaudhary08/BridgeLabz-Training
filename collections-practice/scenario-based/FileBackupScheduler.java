import java.util.PriorityQueue;

// Custom Exception 
class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

// BackupTask Class 
class BackupTask implements Comparable<BackupTask> {

    private String folderPath;
    private int priority; // Higher value = higher priority
    private String scheduleTime;

    public BackupTask(String folderPath, int priority, String scheduleTime)
            throws InvalidBackupPathException {

        if (folderPath == null || folderPath.isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path");
        }

        this.folderPath = folderPath;
        this.priority = priority;
        this.scheduleTime = scheduleTime;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public int getPriority() {
        return priority;
    }

    // Higher priority tasks executed first
    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "BackupTask [Path=" + folderPath +
               ", Priority=" + priority +
               ", Time=" + scheduleTime + "]";
    }
}

//  Backup Scheduler
class BackupScheduler {

    private PriorityQueue<BackupTask> taskQueue = new PriorityQueue<>();

    // Add backup task
    public void addTask(BackupTask task) {
        taskQueue.offer(task);
        System.out.println("Task added: " + task.getFolderPath());
    }

    // Execute tasks in priority order
    public void executeBackups() {
        System.out.println("\nExecuting backup tasks:");

        while (!taskQueue.isEmpty()) {
            BackupTask task = taskQueue.poll();
            System.out.println("Backing up: " + task);
        }
    }
}

//  Main Class 
public class FileBackupScheduler {
    public static void main(String[] args) {

        BackupScheduler scheduler = new BackupScheduler();

        try {
            BackupTask t1 = new BackupTask("/home/user/documents", 2, "10:00 AM");
            BackupTask t2 = new BackupTask("/home/user/system", 5, "09:00 AM"); // critical
            BackupTask t3 = new BackupTask("/home/user/media", 1, "11:00 AM");

            scheduler.addTask(t1);
            scheduler.addTask(t2);
            scheduler.addTask(t3);

        } catch (InvalidBackupPathException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Execute tasks based on priority
        scheduler.executeBackups();
    }
}
