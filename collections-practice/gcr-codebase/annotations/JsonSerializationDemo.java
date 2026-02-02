import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

public class JsonSerializationDemo {

    // Step 1: Create @JsonField Annotation
    @Retention(RetentionPolicy.RUNTIME)   // Needed for Reflection
    @Target(ElementType.FIELD)             // Field-level annotation
    @interface JsonField {
        String name();                     // JSON key name
    }

    // Step 2: User Class
    static class User {

        @JsonField(name = "user_name")
        private String username;

        @JsonField(name = "age")
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    // Step 3: Convert Object to JSON using Reflection
    public static String toJson(Object obj) throws Exception {

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        StringBuilder json = new StringBuilder();
        json.append("{");

        int count = 0;

        for (Field field : fields) {

            // Only serialize fields with @JsonField
            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);

                JsonField jf = field.getAnnotation(JsonField.class);
                String jsonKey = jf.name();
                Object value = field.get(obj);

                json.append("\"").append(jsonKey).append("\":");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                count++;
                if (count < fields.length) {
                    json.append(",");
                }
            }
        }

        json.append("}");
        return json.toString();
    }

    // Step 4: Test
    public static void main(String[] args) throws Exception {

        User user = new User("Ankit", 22);
        String json = toJson(user);

        System.out.println(json);
    }
}
