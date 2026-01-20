// Entry point of the application
public class Main {

    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();

        // Adding standard delivery stages
        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        // Adding a custom intermediate checkpoint
        tracker.addCheckpointAfter("Shipped", "Custom Clearance");

        // Forward tracking of parcel
        tracker.trackParcel();
    }
}
