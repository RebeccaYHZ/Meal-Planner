import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MealPlanGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Please select your gender (0 for male, 1 for female): ");
        int gender = scanner.nextInt();

        System.out.print("Please enter your height (in centimeters): ");
        double height = scanner.nextDouble();

        System.out.print("Please enter your weight (in kilograms): ");
        double weight = scanner.nextDouble();

        System.out.print("Please enter your activity level (a value between 1.2 and 2.4): ");
        double activityLevel = scanner.nextDouble();

        System.out.print("Please enter your goal number (0: Maintain weight, 1: keep fit, 2: lose weight): ");
        int goal = scanner.nextInt();

        scanner.close();

        double targetCalories = (double) CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);

        System.out.println(targetCalories);

        System.out.println("Generated Meal Plan:");
        for (int i = 0; i < 3; i++) {
            categoryPlan(targetCalories, i, goal); // 0 for vegetables, 1 for meat, 2 for carbs
        }

    }

    public static void categoryPlan(double targetCalories, int categoryIndex, int goal) {
        List<FoodItem> foods = FoodListGenerator.generateFoodList().get(categoryIndex);
        if (categoryIndex == 0) {
            int vegeCalories = (int) NutritionNeed.vitaminNeed(targetCalories, goal);
            List<FoodItem> vegePlan = generateMealPlan(foods, vegeCalories);
            System.out.println("Vegetable Meal Plan:");
            for (FoodItem food : vegePlan) {
                System.out.println(food.getName());
            }
        } else if (categoryIndex == 1) {
            int meatCalories = (int) NutritionNeed.proteinNeed(targetCalories, goal);
            System.out.println(meatCalories);
            List<FoodItem> meatPlan = generateMealPlan(foods, meatCalories);
            System.out.println("Meat Meal Plan:");
            for (FoodItem food : meatPlan) {
                System.out.println(food.getName());
            }
        } else {
            int carbCalories = (int) NutritionNeed.carbsNeed(targetCalories, goal);
            List<FoodItem> carbPlan = generateMealPlan(foods, carbCalories);
            System.out.println("Carb Meal Plan:");
            for (FoodItem food : carbPlan) {
                System.out.println(food.getName());
            }
        }

    }

    public static List<FoodItem> generateMealPlan(List<FoodItem> foods, int targetCalories) {
        int n = foods.size();
        int[][] dp = new int[n + 1][targetCalories + 1];

        List<FoodItem> selectedFoods = new ArrayList<>();

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
