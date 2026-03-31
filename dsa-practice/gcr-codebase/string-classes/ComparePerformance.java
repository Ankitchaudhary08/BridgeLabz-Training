public class ComparePerformance {
    public static void main(String[] args) {

        int n = 1000000;

        // -------- StringBuffer --------
        long startBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            stringBuffer.append("hello");
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        // -------- StringBuilder --------
        long startBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            stringBuilder.append("hello");
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        // -------- Output --------
        System.out.println("StringBuffer Time (ns): " + bufferTime);
        System.out.println("StringBuilder Time (ns): " + builderTime);
    }
}
