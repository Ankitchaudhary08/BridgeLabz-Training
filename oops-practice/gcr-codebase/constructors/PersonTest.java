class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class PersonTest {
    public static void main(String[] args) {

        Person p1 = new Person("Ankit", 21);
        Person p2 = new Person(p1);   // copy p1

        System.out.println("Original Person:");
        p1.display();

        System.out.println("\nCopied Person:");
        p2.display();
    }
}
