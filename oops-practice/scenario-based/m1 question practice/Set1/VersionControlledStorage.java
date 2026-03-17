import java.util.*;

public class VersionControlledStorage {

    static Map<String, LinkedHashMap<String, Integer>> fileVersions = new LinkedHashMap<>();
    static Map<String, List<String>> uploadOrder = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String op = parts[0];

            if (op.equals("UPLOAD")) {
                String fileName = parts[1];
                String version = parts[2];
                int size = Integer.parseInt(parts[3]);

                fileVersions.putIfAbsent(fileName, new LinkedHashMap<>());
                uploadOrder.putIfAbsent(fileName, new ArrayList<>());

                if (!fileVersions.get(fileName).containsKey(version)) {
                    fileVersions.get(fileName).put(version, size);
                    uploadOrder.get(fileName).add(version);
                }

            } else if (op.equals("FETCH")) {
                String fileName = parts[1];
                if (!fileVersions.containsKey(fileName)) {
                    System.out.println("File Not Found");
                } else {
                    Map<String, Integer> versions = fileVersions.get(fileName);
                    List<Map.Entry<String, Integer>> entries = new ArrayList<>(versions.entrySet());
                    entries.sort((a, b) -> {
                        int cmp = a.getValue() - b.getValue();
                        if (cmp != 0) return cmp;
                        return a.getKey().compareTo(b.getKey());
                    });
                    for (Map.Entry<String, Integer> e : entries) {
                        System.out.println(fileName + " " + e.getKey() + " " + e.getValue());
                    }
                }

            } else if (op.equals("LATEST")) {
                String fileName = parts[1];
                if (!fileVersions.containsKey(fileName) || uploadOrder.get(fileName).isEmpty()) {
                    System.out.println("File Not Found");
                } else {
                    List<String> order = uploadOrder.get(fileName);
                    String latest = order.get(order.size() - 1);
                    int size = fileVersions.get(fileName).get(latest);
                    System.out.println(fileName + " " + latest + " " + size);
                }

            } else if (op.equals("TOTAL_STORAGE")) {
                String fileName = parts[1];
                if (!fileVersions.containsKey(fileName)) {
                    System.out.println("File Not Found");
                } else {
                    int total = 0;
                    for (int sz : fileVersions.get(fileName).values()) total += sz;
                    System.out.println(fileName + " " + total);
                }
            }
        }
        sc.close();
    }
}
