import java.lang.reflect.Field;

class Student {

    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class ObjectToJsonDemo {

    // Method to convert object to JSON-like string
    public static String toJson(Object obj) throws Exception {

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        StringBuilder json = new StringBuilder();
        json.append("{");

        for (int i = 0; i < fields.length; i++) {

            Field field = fields[i];
            field.setAccessible(true);

            String fieldName = field.getName();
            Object value = field.get(obj);

            json.append("\"").append(fieldName).append("\":");

            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }

            if (i < fields.length - 1) {
                json.append(",");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {

        Student student = new Student(101, "Ankit", 22);

        String json = toJson(student);
        System.out.println(json);
    }
}
