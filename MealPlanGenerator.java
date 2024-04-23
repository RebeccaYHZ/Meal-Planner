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
        double targetCalories = (double) CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);
        List<FoodItem> mealPlan = generateMealPlan(foods, targetCalories);

        System.out.println("Generated Meal Plan:");
        for (FoodItem food : mealPlan) {
            System.out.println(food.getName());
        }
    }

    public static List<FoodItem> generateMealPlan(List<FoodItem> foods, double targetCalories) {
        int n = foods.size();
        int[][] dp = new int[n + 1][targetCalories + 1];

        int meatCount = 2;
        int carbCount = 2;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetCalories; j++) {
                if (foods.get(i - 1).getCalories() <= j) {
                    int meatValue = 0;
                    int carbValue = 0;

                    if (foods.get(i - 1).getCategory().equalsIgnoreCase("meat") && meatCount > 0) {
                        meatValue = foods.get(i - 1).getProtein();
                        meatCount--;
                    } else if (foods.get(i - 1).getCategory().equalsIgnoreCase("carbs") && carbCount > 0) {
                        carbValue = foods.get(i - 1).getProtein();
                        carbCount--;
                    }

                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - foods.get(i - 1).getCalories()] + meatValue + carbValue);
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
