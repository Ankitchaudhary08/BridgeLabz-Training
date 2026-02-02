import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Student {
    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

public class ObjectMapperDemo {

    // Custom Object Mapper Method
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties)
            throws Exception {

        // Step 1: Create object dynamically
        T obj = clazz.getDeclaredConstructor().newInstance();

        // Step 2: Loop through map entries
        for (Map.Entry<String, Object> entry : properties.entrySet()) {

            String fieldName = entry.getKey();
            Object value = entry.getValue();

            // Step 3: Get field from class
            Field field = clazz.getDeclaredField(fieldName);

            // Step 4: Allow access to private fields
            field.setAccessible(true);

            // Step 5: Set value to field
            field.set(obj, value);
        }

        return obj;
    }

    public static void main(String[] args) throws Exception {

        Map<String, Object> data = new HashMap<>();
        data.put("id", 101);
        data.put("name", "Ankit");
        data.put("age", 22);

        Student student = toObject(Student.class, data);
        System.out.println(student);
    }
}
