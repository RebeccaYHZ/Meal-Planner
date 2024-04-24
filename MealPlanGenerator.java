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

        int meatCount = 2;
        int carbCount = 2;
        int vegetableCount = 0;
        int fruitCount = 0;

        for (int i = 1; i <= n; i++) {
            // Check if all options are used up and if target calories are met
            if (meatCount == 0 && carbCount == 0 && vegetableCount == 0 && fruitCount == 0 && targetCalories <= 0) {
                break;
            }

            // Check the category of the current food item
            String category = foods.get(i - 1).getCategory();

            // Determine the protein value based on the category and available counts
            int proteinValue = 0;
            if (category.equalsIgnoreCase("meat") && meatCount > 0) {
                proteinValue = foods.get(i - 1).getProtein();
                meatCount--;
            } else if (category.equalsIgnoreCase("carbs") && carbCount > 0) {
                proteinValue = foods.get(i - 1).getProtein();
                carbCount--;
            } else if (category.equalsIgnoreCase("vegetable")) {
                if (vegetableCount < 2 && targetCalories > 0) {
                    proteinValue = foods.get(i - 1).getProtein();
                    vegetableCount++;
                    targetCalories -= foods.get(i - 1).getCalories();
                }
            } else if (category.equalsIgnoreCase("fruit")) {
                if (fruitCount < 2 && targetCalories > 0) {
                    proteinValue = foods.get(i - 1).getProtein();
                    fruitCount++;
                    targetCalories -= foods.get(i - 1).getCalories();
                }
            }

            for (int j = 1; j <= targetCalories; j++) {
                if (foods.get(i - 1).getCalories() <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - foods.get(i - 1).getCalories()] + proteinValue);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        List<FoodItem> selectedFoods = new ArrayList<>();
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
