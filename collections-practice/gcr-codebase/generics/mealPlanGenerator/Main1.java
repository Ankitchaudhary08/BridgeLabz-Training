public class Main1 {

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal =
                MealGenerator.generateMeal(new VegetarianMeal());
        vegMeal.serve();

        Meal<VeganMeal> veganMeal =
                MealGenerator.generateMeal(new VeganMeal());
        veganMeal.serve();

        Meal<KetoMeal> ketoMeal =
                MealGenerator.generateMeal(new KetoMeal());
        ketoMeal.serve();

        Meal<HighProteinMeal> proteinMeal =
                MealGenerator.generateMeal(new HighProteinMeal());
        proteinMeal.serve();
    }
}
