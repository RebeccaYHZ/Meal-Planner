import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodListGenerator {
    public static List<FoodItem> generateFoodList() {
        // create the result list, the result list contains 4 kinds of food
        // each kind contains 5 FoodItem

        List<FoodItem> foodList = new ArrayList<>();

        // Create lists to hold foods for each nutrient type
        List<FoodItem> proteinFoods = new ArrayList<>();
        List<FoodItem> carbFoods = new ArrayList<>();
        List<FoodItem> fatFoods = new ArrayList<>();
        List<FoodItem> vitaminFoods = new ArrayList<>();

        // Add food items to the corresponding lists based on nutrient type
        for (FoodItem food : FoodData.generateFoodItems()) {
            if (food.getProtein() > 0) {
                proteinFoods.add(food);
            }
            if (food.getCarb() > 0) {
                carbFoods.add(food);
            }
            if (food.getFat() > 0) {
                fatFoods.add(food);
            }
            if (food.getVitamin() > 0) {
                vitaminFoods.add(food);
            }
        }

        // Randomly select 5 foods from each nutrient type list
        foodList.addAll(selectRandomFoods(proteinFoods, 5));
        foodList.addAll(selectRandomFoods(carbFoods, 5));
        foodList.addAll(selectRandomFoods(fatFoods, 5));
        foodList.addAll(selectRandomFoods(vitaminFoods, 5));

        return foodList;
    }

    private static List<FoodItem> selectRandomFoods(List<FoodItem> foods, int count) {
        List<FoodItem> selectedFoods = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < Math.min(count, foods.size()); i++) {
            int randomIndex = random.nextInt(foods.size());
            selectedFoods.add(foods.get(randomIndex));
            foods.remove(randomIndex); // Remove the selected food to avoid duplication
        }
        return selectedFoods;
    }
}
