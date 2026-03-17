import java.util.*;

public class HybridNetworkIdentifiers {

    static boolean validateIdentifier(String input) {
        // Format: <IP6_Address>::<MAC_Address>
        // Split on ::
        int sepIdx = input.indexOf("::");
        if (sepIdx < 0) return false;

        // Make sure :: appears exactly once
        if (input.indexOf("::", sepIdx + 1) >= 0) return false;

        String ip6 = input.substring(0, sepIdx);
        String mac = input.substring(sepIdx + 2);

        // Validate IP6: exactly 8 groups of 1-4 hex chars separated by :
        String[] ip6Groups = ip6.split(":", -1);
        if (ip6Groups.length != 8) return false;
        for (String g : ip6Groups) {
            if (g.length() < 1 || g.length() > 4) return false;
            if (!g.matches("[0-9a-fA-F]+")) return false;
        }

        // Validate MAC: exactly 6 groups of exactly 2 UPPERCASE hex chars separated by :
        String[] macGroups = mac.split(":", -1);
        if (macGroups.length != 6) return false;
        for (String g : macGroups) {
            if (g.length() != 2) return false;
            if (!g.matches("[0-9A-F]{2}")) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            System.out.println(validateIdentifier(line) ? "AUTHENTIC DEVICE" : "REJECTED DEVICE");
        }
        sc.close();
    }
}
