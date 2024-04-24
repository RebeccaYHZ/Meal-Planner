import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodListGenerator {
    public static List<List<FoodItem>> generateFoodList() {
        // Create the result list, the result list contains 4 kinds of food
        // each kind contains 5 FoodItem
        // Create lists to hold foods for each nutrient type
        List<FoodItem> fruitFoods = new ArrayList<>();
        List<FoodItem> vegetableFoods = new ArrayList<>();
        List<FoodItem> meatFoods = new ArrayList<>();
        List<FoodItem> carbFoods = new ArrayList<>();
        List<FoodItem> veganProteins = new ArrayList<>();

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
            } else if (food.getCategory().equals("Vegan Protein")) {
                veganProteins.add(food);
            }
        }

        // Randomly select 5 items from fruits and 5 items from vegetables
        List<FoodItem> selectedFruits = selectRandomFoods(fruitFoods, 5);
        List<FoodItem> selectedVegetables = selectRandomFoods(vegetableFoods, 5);

        // Combine selected fruits and vegetables into one list
        List<FoodItem> combinedPlants = new ArrayList<>();
        combinedPlants.addAll(selectedFruits);
        combinedPlants.addAll(selectedVegetables);

        // Randomly select 5 items from meats and carbs
        List<FoodItem> selectedMeats = selectRandomFoods(meatFoods, 5);
        List<FoodItem> selectedCarbs = selectRandomFoods(carbFoods, 5);
        List<FoodItem> selectedVeganProteins = selectRandomFoods(veganProteins, 5);

        // Prepare a list of lists to return three separate category lists
        List<List<FoodItem>> categorizedFoodLists = new ArrayList<>();
        categorizedFoodLists.add(combinedPlants); // Combined list of fruits and vegetables
        categorizedFoodLists.add(selectedMeats);  // Separate list for meats
        categorizedFoodLists.add(selectedCarbs);  // Separate list for carbs
        categorizedFoodLists.add(selectedVeganProteins);  // Separate list for vegan proteins

        return categorizedFoodLists;
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
