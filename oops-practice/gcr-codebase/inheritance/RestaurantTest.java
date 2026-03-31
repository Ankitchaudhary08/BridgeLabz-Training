// Interface
interface Worker {
    void performDuties();
}

// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Chef class
class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is cooking food.");
    }
}

// Waiter class
class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving customers.");
    }
}

// Main class
public class RestaurantTest {
    public static void main(String[] args) {

        Worker w1 = new Chef("Ankit", 101);
        Worker w2 = new Waiter("Rohan", 102);

        w1.performDuties();
        w2.performDuties();
    }
}
