class MobilePhone {

    String brand;
    String model;
    double price;

    // this method display mobile details
    void displayMobileDetails() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        // create first mobile object
        MobilePhone m1 = new MobilePhone();
        m1.brand = "VIVO";
        m1.model = "VIVO V29";
        m1.price = 15999.0;

        // create second mobile object
        MobilePhone m2 = new MobilePhone();
        m2.brand = "ONE PLUS";
        m2.model = "ONE PLUS nord4";
        m2.price = 39999.0;

        // create third mobile object
        MobilePhone m3 = new MobilePhone();
        m3.brand = "APPLE";
        m3.model = "iphone pro16";
        m3.price = 79999.0;

        // display mobile details
        m1.displayMobileDetails();
        m2.displayMobileDetails();
        m3.displayMobileDetails();
    }
}
