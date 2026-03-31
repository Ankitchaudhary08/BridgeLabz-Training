import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Step 1: Create @Inject Annotation 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

//  Step 2: Dependency Class
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

//  Step 3: Class that needs Dependency
class Car {

    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is running");
    }
}

//  Step 4: Simple DI Container 
class SimpleDIContainer {

    public static <T> T getObject(Class<T> clazz) throws Exception {

        // Create main object
        T obj = clazz.getDeclaredConstructor().newInstance();

        // Scan all fields
        for (Field field : clazz.getDeclaredFields()) {

            // Check if @Inject is present
            if (field.isAnnotationPresent(Inject.class)) {

                // Create dependency object
                Class<?> dependencyType = field.getType();
                Object dependency = dependencyType
                        .getDeclaredConstructor()
                        .newInstance();

                // Inject dependency
                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }
        return obj;
    }
}

//  Step 5: Test 
public class SimpleDIDemo {

    public static void main(String[] args) throws Exception {

        // Get object from DI container
        Car car = SimpleDIContainer.getObject(Car.class);

        // Use object
        car.drive();
    }
}
