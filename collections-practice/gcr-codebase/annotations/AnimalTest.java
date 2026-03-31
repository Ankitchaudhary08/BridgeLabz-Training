public class AnimalTest {

    // Parent class
    static class Animal {

        public void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }

    // Child class
    static class Dog extends Animal {

        @Override
        public void makeSound() {
            System.out.println("Dog barks");
        }
    }

    // Main method
    public static void main(String[] args) {

        Dog d = new Dog();
        d.makeSound();
    }
}
