// Generic class to hold a meal plan
public class Meal<T extends MealPlan> {

    private T mealPlan;

    // Constructor
    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    // Execute meal plan
    public void serve() {
        mealPlan.prepare();
    }

    public T getMealPlan() {
        return mealPlan;
    }
}
