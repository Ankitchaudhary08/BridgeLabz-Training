// Superclass
class Device {
    String deviceId;
    String status; // ON or OFF

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass
class Thermostat extends Device {
    int temperatureSetting;

    Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class
public class SmartHomeTest {
    public static void main(String[] args) {

        Thermostat t1 = new Thermostat("TH-101", "ON", 24);
        Thermostat t2 = new Thermostat("TH-102", "OFF", 20);

        t1.displayStatus();
        System.out.println();
        t2.displayStatus();
    }
}





