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
        foodItems.add(new FoodItem(id++, "White Rice (200g cooked)", "Carbs", 260, 6, 0, 0, 56));
        foodItems.add(new FoodItem(id++, "Pasta (200g cooked)", "Carbs", 316, 12, 0, 2, 60));
        foodItems.add(new FoodItem(id++, "Quinoa (200g cooked)", "Carbs", 240, 8, 0, 4, 42));
        foodItems.add(new FoodItem(id++, "Oats (200g)", "Carbs", 778, 34, 0, 14, 132));
        foodItems.add(new FoodItem(id++, "Sweet Potato (200g)", "Carbs", 172, 4, 0, 0, 40));
        foodItems.add(new FoodItem(id++, "Lentils (200g cooked)", "Carbs", 232, 18, 0, 0, 40));
        foodItems.add(new FoodItem(id++, "Black Beans (200g cooked)", "Carbs", 264, 18, 0, 0, 46));
        foodItems.add(new FoodItem(id++, "Corn (200g)", "Carbs", 192, 6, 0, 2, 42));
        foodItems.add(new FoodItem(id++, "Chickpeas (200g cooked)", "Carbs", 328, 18, 0, 6, 54));
        foodItems.add(new FoodItem(id++, "Potato (200g)", "Carbs", 154, 4, 0, 0, 34));
        
        foodItems.add(new FoodItem(id++, "Tofu (200g)", "Vegan Protein", 150, 16, 0, 9, 4));
        foodItems.add(new FoodItem(id++, "Tempeh (200g)", "Vegan Protein", 320, 34, 0, 18, 16));
        foodItems.add(new FoodItem(id++, "Seitan (200g)", "Vegan Protein", 370, 75, 0, 2, 14));
        foodItems.add(new FoodItem(id++, "Lentils (200g cooked)", "Vegan Protein", 230, 18, 0, 0, 40));
        foodItems.add(new FoodItem(id++, "Chickpeas (200g cooked)", "Vegan Protein", 320, 19, 0, 6, 54));
        foodItems.add(new FoodItem(id++, "Black Beans (200g cooked)", "Vegan Protein", 260, 18, 0, 0, 48));
        foodItems.add(new FoodItem(id++, "Edamame (200g)", "Vegan Protein", 250, 22, 0, 12, 20));
        foodItems.add(new FoodItem(id++, "Quinoa (200g cooked)", "Vegan Protein", 222, 8, 0, 4, 39));
        foodItems.add(new FoodItem(id++, "Peanut Butter (50g)", "Vegan Protein", 300, 13, 0, 25, 10));
        foodItems.add(new FoodItem(id++, "Almonds (50g)", "Vegan Protein", 285, 11, 0, 25, 6));
        return foodItems;
    }

    public static void main(String[] args) {
        List<FoodItem> foodItems = generateFoodItems();
        for (FoodItem item : foodItems) {
            System.out.println(item);
        }
    }
}
