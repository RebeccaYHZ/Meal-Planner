import java.util.ArrayList;
import java.util.List;

class Food {
    String name;
    int protein;
    int carbs;
    int fat;
    int vitamins;
    int calories;

    public Food(String name, int protein, int carbs, int fat, int vitamins, int calories) {
        this.name = name;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.vitamins = vitamins;
        this.calories = calories;
    }
}

public class MealPlanGenerator {

    public static List<Food> generateMealPlan(List<Food> foods, int targetCalories) {
        int n = foods.size();
        int[][] dp = new int[n + 1][targetCalories + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetCalories; j++) {
                if (foods.get(i - 1).calories <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - foods.get(i - 1).calories] + foods.get(i - 1).protein);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        List<Food> selectedFoods = new ArrayList<>();
        int i = n, j = targetCalories;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedFoods.add(foods.get(i - 1));
                j -= foods.get(i - 1).calories;
            }
            i--;
        }

        return selectedFoods;
    }

    public static void main(String[] args) {
        List<Food> foods = new ArrayList<>();
        int targetCalories = 500;
        List<Food> mealPlan = generateMealPlan(foods, targetCalories);

        System.out.println("Generated Meal Plan:");
        for (Food food : mealPlan) {
            System.out.println(food.name);
        }
    }
}
