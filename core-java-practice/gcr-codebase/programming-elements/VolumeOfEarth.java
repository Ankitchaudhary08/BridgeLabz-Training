public class VolumeOfEarth {
    public static void main(String[] args) {

        // Radius of Earth in kilometers
        double radiusKm = 6378;

        // Value of PI
        double pi = Math.PI;

        // Volume formula of sphere: (4/3) × π × r³
        double volumeKm = (4.0 / 3) * pi * radiusKm * radiusKm * radiusKm;

        // Convert cubic kilometers to cubic miles
        // 1 km = 0.621371 miles
        double volumeMiles = volumeKm * Math.pow(0.621371, 3);

        //  output
        System.out.println(
            "The volume of earth in cubic kilometers is " + volumeKm +
            " and cubic miles is " + volumeMiles
        );
    }
}
