import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheResultDemo {

    // ================= Step 1: Create @CacheResult Annotation =================
    @Retention(RetentionPolicy.RUNTIME)    // Needed for Reflection
    @Target(ElementType.METHOD)             // Method-level annotation
    @interface CacheResult {
    }

    // ================= Step 2: Service Class =================
    static class MathService {

        @CacheResult
        public int slowSquare(int n) {
            System.out.println("Computing square for: " + n);
            try {
                Thread.sleep(2000); // simulate expensive computation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return n * n;
        }
    }

    // ================= Step 3: Simple Cache Container =================
    static class CacheManager {

        private static final Map<String, Object> cache = new HashMap<>();

        public static Object invokeWithCache(Object obj, Method method, Object[] args)
                throws Exception {

            // Cache key = methodName + arguments
            String cacheKey = method.getName() + "-" + args[0];

            // If result already cached
            if (cache.containsKey(cacheKey)) {
                System.out.println("Returning cached result for: " + args[0]);
                return cache.get(cacheKey);
            }

            // Else compute result
            Object result = method.invoke(obj, args);

            // Store in cache
            cache.put(cacheKey, result);
            return result;
        }
    }

    // ================= Step 4: Test =================
    public static void main(String[] args) throws Exception {

        MathService service = new MathService();
        Method method = MathService.class.getMethod("slowSquare", int.class);

        // First call (computation happens)
        Object result1 = CacheManager.invokeWithCache(service, method, new Object[]{5});
        System.out.println("Result: " + result1);

        // Second call with same input (cached result)
        Object result2 = CacheManager.invokeWithCache(service, method, new Object[]{5});
        System.out.println("Result: " + result2);

        // Third call with different input (new computation)
        Object result3 = CacheManager.invokeWithCache(service, method, new Object[]{6});
        System.out.println("Result: " + result3);
    }
}
