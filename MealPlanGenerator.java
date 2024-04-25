import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program generates a personalized meal plan based on user input such as
 * age, gender, height, weight, activity level,
 * dietary preferences, and fitness goals. It calculates the target daily
 * calorie intake and divides it into three main food categories:
 * vegetables/fruits, meat/vegan protein, and carbohydrates. It then generates a
 * meal plan for each category according to the calorie
 * and nutrient requirements.
 */

public class MealPlanGenerator {

    public static void main(String[] args) {

        // Collect user input for age, gender, height, weight, activity level, dietary
        // preferences, and fitness goals
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Please select your gender (0 for male, 1 for female): ");
        int gender = scanner.nextInt();

        System.out.print("Please enter your height (in centimeters): ");
        double height = scanner.nextDouble();

        System.out.print("Please enter your weight (in kilograms): ");
        double weight = scanner.nextDouble();

        System.out.print("Please enter your activity level (a value between 1 and 5): ");
        double activityLevel = scanner.nextDouble();

        System.out.print("Are you vegetarian? (0: Yes, 1: No): ");
        int checkVegetarian = scanner.nextInt();

        System.out.print("Please enter your goal number (0: Maintain weight, 1: keep fit, 2: lose weight): ");
        int goal = scanner.nextInt();

        scanner.close();

        // Calculate the target daily calorie intake
        double targetCalories = (double) CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);

        System.out.println("\nYour total daily calorie intake should be around " + targetCalories);

        // Determine if user is vegetarian based on input
        boolean isVegetarian;
        if (checkVegetarian == 0) {
            isVegetarian = true;
        } else {
            isVegetarian = false;
        }

        // Generate meal plan for each food category
        System.out.println("===== Generated Meal Plan =====");
        for (int i = 0; i < 3; i++) {
            categoryPlan(targetCalories, i, goal, isVegetarian); // 0 for vegetables, 1 for meat, 2 for carbs
        }
    }

    /**
     * Generates a meal plan for a specific food category based on target calorie
     * intake, fitness goals, and dietary preferences.
     * 
     * @param targetCalories Target daily calorie intake.
     * @param categoryIndex  Index of the food category (0 for vegetables/fruits, 1
     *                       for meat/vegan protein, 2 for carbohydrates).
     * @param goal           Fitness goal (0: Maintain weight, 1: Keep fit, 2: Lose
     *                       weight).
     * @param isVegetarian   Indicates whether the user is vegetarian.
     */
    public static void categoryPlan(double targetCalories, int categoryIndex, int goal, boolean isVegetarian) {
        List<FoodItem> foods = FoodListGenerator.generateFoodList().get(categoryIndex);

        // Generate meal plan for each food category based on calorie and nutrient
        // requirements
        if (categoryIndex == 0) {
            int vegeCalories = (int) NutritionNeed.vitaminNeed(targetCalories, goal);
            List<FoodItem> vegePlan = generateMealPlan(foods, vegeCalories);
            System.out.println("\n[Vegetable/fruit:]");
            for (FoodItem food : vegePlan) {
                System.out.println(food.getName());
            }
        } else if (categoryIndex == 1) {
            if (isVegetarian) {
                foods = FoodListGenerator.generateFoodList().get(3);
            }
            int meatCalories = (int) NutritionNeed.proteinNeed(targetCalories, goal);
            List<FoodItem> meatPlan = generateMealPlan(foods, meatCalories);
            System.out.println("\n[Meat/vegan protein:]");
            for (FoodItem food : meatPlan) {
                System.out.println(food.getName());
            }
        } else {
            int carbCalories = (int) NutritionNeed.carbsNeed(targetCalories, goal);
            List<FoodItem> carbPlan = generateMealPlan(foods, carbCalories);
            System.out.println("\n[Carb:]");
            for (FoodItem food : carbPlan) {
                System.out.println(food.getName());
            }
        }

    }

    /**
     * Generates a meal plan based on a list of food items and target calorie
     * intake.
     * 
     * @param foods          List of available food items.
     * @param targetCalories Target calorie intake for the meal plan.
     * @return List of selected food items for the meal plan.
     */
    public static List<FoodItem> generateMealPlan(List<FoodItem> foods, int targetCalories) {
        int n = foods.size();
        int[][] dp = new int[n + 1][targetCalories + 1];

        List<FoodItem> selectedFoods = new ArrayList<>();

        // Dynamic programming to generate the optimal meal plan based on calorie and
        // nutrient requirements
        for (int i = 1; i <= n; i++) {
            int calories = foods.get(i - 1).getCalories();
            int protein = foods.get(i - 1).getProtein();

            for (int j = 0; j <= targetCalories; j++) {
                if (calories <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - calories] + protein);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Backtrack to retrieve the selected food items for the meal plan
        int i = n, j = targetCalories;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedFoods.add(foods.get(i - 1));
                j -= foods.get(i - 1).getCalories();
            }
            i--;
        }

        return selectedFoods;
    }
}
