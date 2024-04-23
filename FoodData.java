import java.util.ArrayList;
import java.util.List;

public class FoodData {
    public static List<FoodItem> generateFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        int id = 1; // Starting ID
        
        // Adding fruits
        foodItems.add(new FoodItem(id++, "Apple (1 medium)", "Fruit", 95, 1, 10, 0, 25));
        foodItems.add(new FoodItem(id++, "Banana (1 medium)", "Fruit", 105, 1, 10, 0, 27));
        foodItems.add(new FoodItem(id++, "Orange (1 medium)", "Fruit", 62, 1, 60, 0, 15));
        foodItems.add(new FoodItem(id++, "Blueberries (100g)", "Fruit", 57, 1, 10, 0, 14));
        foodItems.add(new FoodItem(id++, "Strawberries (100g)", "Fruit", 32, 1, 60, 0, 8));
        foodItems.add(new FoodItem(id++, "Kiwi (1 medium)", "Fruit", 42, 1, 60, 0, 10));
        foodItems.add(new FoodItem(id++, "Grapes (100g)", "Fruit", 69, 1, 10, 0, 18));
        foodItems.add(new FoodItem(id++, "Watermelon (100g)", "Fruit", 30, 1, 10, 0, 8));
        foodItems.add(new FoodItem(id++, "Peach (1 medium)", "Fruit", 58, 1, 10, 0, 14));
        foodItems.add(new FoodItem(id++, "Cherries (100g)", "Fruit", 50, 1, 10, 0, 12));

        // Adding vegetables
        foodItems.add(new FoodItem(id++, "Carrot (1 medium)", "Vegetable", 25, 1, 10, 0, 6));
        foodItems.add(new FoodItem(id++, "Broccoli (100g)", "Vegetable", 34, 3, 60, 0, 7));
        foodItems.add(new FoodItem(id++, "Spinach (100g)", "Vegetable", 23, 3, 90, 0, 4));
        foodItems.add(new FoodItem(id++, "Tomato (1 medium)", "Vegetable", 22, 1, 15, 0, 5));
        foodItems.add(new FoodItem(id++, "Bell Pepper (1 medium)", "Vegetable", 24, 1, 190, 0, 6));
        foodItems.add(new FoodItem(id++, "Cucumber (1 medium)", "Vegetable", 16, 1, 10, 0, 4));
        foodItems.add(new FoodItem(id++, "Kale (100g)", "Vegetable", 49, 4, 120, 1, 9));
        foodItems.add(new FoodItem(id++, "Mushroom (100g)", "Vegetable", 22, 3, 5, 0, 3));
        foodItems.add(new FoodItem(id++, "Cauliflower (100g)", "Vegetable", 25, 2, 15, 0, 5));
        foodItems.add(new FoodItem(id++, "Onion (1 medium)", "Vegetable", 44, 1, 10, 0, 10));

        // Adding meats
        foodItems.add(new FoodItem(id++, "Chicken Breast (100g)", "Meat", 165, 31, 0, 4, 0));
        foodItems.add(new FoodItem(id++, "Salmon (100g)", "Meat", 208, 20, 0, 13, 0));
        foodItems.add(new FoodItem(id++, "Beef Steak (100g)", "Meat", 271, 26, 0, 17, 0));
        foodItems.add(new FoodItem(id++, "Pork Chop (100g)", "Meat", 231, 25, 0, 14, 0));
        foodItems.add(new FoodItem(id++, "Turkey (100g)", "Meat", 135, 30, 0, 1, 0));
        foodItems.add(new FoodItem(id++, "Lamb (100g)", "Meat", 294, 25, 0, 21, 0));
        foodItems.add(new FoodItem(id++, "Duck (100g)", "Meat", 404, 27, 0, 28, 0));
        foodItems.add(new FoodItem(id++, "Venison (100g)", "Meat", 158, 30, 0, 3, 0));
        foodItems.add(new FoodItem(id++, "Rabbit (100g)", "Meat", 173, 28, 0, 8, 0));
        foodItems.add(new FoodItem(id++, "Buffalo (100g)", "Meat", 146, 21, 0, 7, 0));

        // Adding carbs category
        foodItems.add(new FoodItem(id++, "White Rice (100g cooked)", "Carbs", 130, 3, 0, 0, 28));
        foodItems.add(new FoodItem(id++, "Pasta (100g cooked)", "Carbs", 158, 6, 0, 1, 30));
        foodItems.add(new FoodItem(id++, "Quinoa (100g cooked)", "Carbs", 120, 4, 0, 2, 21));
        foodItems.add(new FoodItem(id++, "Oats (100g)", "Carbs", 389, 17, 0, 7, 66));
        foodItems.add(new FoodItem(id++, "Sweet Potato (100g)", "Carbs", 86, 2, 0, 0, 20));
        foodItems.add(new FoodItem(id++, "Lentils (100g cooked)", "Carbs", 116, 9, 0, 0, 20));
        foodItems.add(new FoodItem(id++, "Black Beans (100g cooked)", "Carbs", 132, 9, 0, 0, 23));
        foodItems.add(new FoodItem(id++, "Corn (100g)", "Carbs", 96, 3, 0, 1, 21));
        foodItems.add(new FoodItem(id++, "Chickpeas (100g cooked)", "Carbs", 164, 9, 0, 3, 27));
        foodItems.add(new FoodItem(id++, "Potato (100g)", "Carbs", 77, 2, 0, 0, 17));

        return foodItems;
    }

    public static void main(String[] args) {
        List<FoodItem> foodItems = generateFoodItems();
        for (FoodItem item : foodItems) {
            System.out.println(item);
        }
    }
}
