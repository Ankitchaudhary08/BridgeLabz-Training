public class DeprecatedExample {

    // Legacy class
    static class LegacyAPI {

        @Deprecated
        public void oldFeature() {
            System.out.println("This is the OLD feature (not recommended).");
        }

        public void newFeature() {
            System.out.println("This is the NEW feature (use this).");
        }
    }

    // Main method
    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        api.oldFeature();   // ⚠ Compiler warning
        api.newFeature();   // ✅ Recommended method
    }
}
