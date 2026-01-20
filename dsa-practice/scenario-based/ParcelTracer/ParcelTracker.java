// Manages the singly linked list of parcel stages
public class ParcelTracker {

    private StageNode head; // First stage of the parcel

    // Add a stage at the end of the list
    public void addStage(String stage) {

        StageNode newNode = new StageNode(stage);

        // If parcel is not registered
        if (head == null) {
            head = newNode;
            return;
        }

        // Move to the last stage
        StageNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Attach new stage
        current.next = newNode;
    }

    // Add a custom checkpoint after a given stage
    public void addCheckpointAfter(String existingStage, String newStage) {

        StageNode current = head;

        while (current != null) {

            if (current.stage.equals(existingStage)) {
                StageNode checkpoint = new StageNode(newStage);
                checkpoint.next = current.next;
                current.next = checkpoint;
                return;
            }

            current = current.next;
        }

        System.out.println("Stage not found: " + existingStage);
    }

    // Track parcel forward through all stages
    public void trackParcel() {

        // Handle lost or missing parcel
        if (head == null) {
            System.out.println("Parcel is lost or not registered.");
            return;
        }

        StageNode current = head;
        System.out.println("Parcel Tracking Status:");

        while (current != null) {
            System.out.print(current.stage + " -> ");
            current = current.next;
        }

        System.out.println("END");
    }
}
