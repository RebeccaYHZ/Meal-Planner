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

        scanner.close();

        List<FoodItem> foods = FoodListGenerator.generateFoodList();
        int targetCalories = (int) CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);
        System.out.println(targetCalories);
        List<FoodItem> mealPlan = generateMealPlan(foods, targetCalories);

        int total = 0;
        for (FoodItem food : mealPlan) {
            total += food.getCalories();
        }

        System.out.println("total: " + total);
        System.out.println("Generated Meal Plan:");
        for (FoodItem food : mealPlan) {
            System.out.println(food.getName());
        }
    }

    public static List<FoodItem> generateMealPlan(List<FoodItem> foods, int targetCalories) {
        int n = foods.size();
        int[][] dp = new int[n + 1][targetCalories + 1];

        // Define counts for each food category
        int meatCount = 2;
        int carbCount = 4;
        int vegetableCount = 4; // Set initial count of vegetables to the maximum available
        int fruitCount = 4; // Set initial count of fruits to the maximum available

        // Iterate over each food item
        for (int i = 1; i <= n; i++) {
            // Check if all options are used up or target calories are met
            if (meatCount == 0 && carbCount == 0 && vegetableCount == 0 && fruitCount == 0) {
                break;
            }

            FoodItem food = foods.get(i - 1);
            String category = food.getCategory();
            int calories = food.getCalories();
            int proteinValue = food.getProtein();

            // Determine protein value based on category and available counts
            if (category.equalsIgnoreCase("meat") && meatCount > 0) {
                meatCount--;
            } else if (category.equalsIgnoreCase("carbs") && carbCount > 0) {
                carbCount--;
            } else if (category.equalsIgnoreCase("vegetable") && vegetableCount > 0) {
                vegetableCount--;
            } else if (category.equalsIgnoreCase("fruit") && fruitCount > 0) {
                fruitCount--;
            } else {
                continue; // Skip if the food category is not applicable
            }

            // Iterate over target calories for dynamic programming
            for (int j = 0; j <= targetCalories; j++) {
                if (calories <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - calories] + proteinValue);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Construct selected foods based on dynamic programming results
        List<FoodItem> selectedFoods = new ArrayList<>();
        int i = n, j = targetCalories;
        while (j > 0 && i > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedFoods.add(foods.get(i - 1));
                j -= foods.get(i - 1).getCalories();
            }
            i--;
        }

        return selectedFoods;
    }

}
