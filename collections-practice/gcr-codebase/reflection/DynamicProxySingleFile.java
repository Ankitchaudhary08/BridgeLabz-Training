import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxySingleFile {

    // Step 1: Interface
    interface Greeting {
        void sayHello();
    }

    // Step 2: Real Implementation
    static class GreetingImpl implements Greeting {
        @Override
        public void sayHello() {
            System.out.println("Hello, Welcome!");
        }
    }

    // Step 3: Logging Proxy Handler
    static class LoggingHandler implements InvocationHandler {

        private Object target;

        public LoggingHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            // Log before method execution
            System.out.println("Calling method: " + method.getName());

            // Call actual method using reflection
            return method.invoke(target, args);
        }
    }

    // Step 4: Main method (Test)
    public static void main(String[] args) {

        // Real object
        Greeting realObject = new GreetingImpl();

        // Create proxy object dynamically
        Greeting proxyObject = (Greeting) Proxy.newProxyInstance(
                realObject.getClass().getClassLoader(),
                new Class<?>[]{Greeting.class},
                new LoggingHandler(realObject)
        );

        // Call method via proxy
        proxyObject.sayHello();
    }
}
