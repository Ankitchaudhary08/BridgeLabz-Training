// Represents one stage in the delivery chain
public class StageNode {

    String stage;        // Name of the stage
    StageNode next;      // Reference to next stage

    // Create a new delivery stage
    public StageNode(String stage) {
        this.stage = stage;
        this.next = null;
    }
}
