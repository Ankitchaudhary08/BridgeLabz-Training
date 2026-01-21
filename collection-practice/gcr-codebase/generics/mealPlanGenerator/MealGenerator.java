// Utility class for generating meals
public class MealGenerator {

    // Generic method to validate and generate meal
    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {

        // Validation can be extended here
        System.out.println("Generating personalized meal plan...");

        return new Meal<>(plan);
    }
}
