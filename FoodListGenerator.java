import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodListGenerator {
    public static List<FoodItem> generateFoodList() {
        // Create the result list, the result list contains 4 kinds of food
        // each kind contains 5 FoodItem

        List<FoodItem> foodList = new ArrayList<>();

        // Create lists to hold foods for each nutrient type
        List<FoodItem> fruitFoods = new ArrayList<>();
        List<FoodItem> vegetableFoods = new ArrayList<>();
        List<FoodItem> meatFoods = new ArrayList<>();
        List<FoodItem> carbFoods = new ArrayList<>();

        // Add food items to the corresponding lists based on nutrient type
        for (FoodItem food : FoodData.generateFoodItems()) {
            if (food.getCategory().equals("Fruit")) {
                fruitFoods.add(food);
            } else if (food.getCategory().equals("Vegetable")) {
                vegetableFoods.add(food);
            } else if (food.getCategory().equals("Meat")) {
                meatFoods.add(food);
            } else if (food.getCategory().equals("Carbs")) {
                carbFoods.add(food);
            }
        }

        // Randomly select 5 foods from each nutrient type list
        foodList.addAll(selectRandomFoods(fruitFoods, 5));
        foodList.addAll(selectRandomFoods(vegetableFoods, 5));
        foodList.addAll(selectRandomFoods(meatFoods, 5));
        foodList.addAll(selectRandomFoods(carbFoods, 5));

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
