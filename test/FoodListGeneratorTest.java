import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FoodListGeneratorTest {

    @Test
    public void testGenerateFoodList() {
        List<FoodItem> foodList = FoodListGenerator.generateFoodList();

        // Check if the generated list size is 20 (5 foods from each nutrient type)
        assertEquals(20, foodList.size());

        // Check if each category has exactly 5 food items
        int fruitCount = 0;
        int vegetableCount = 0;
        int meatCount = 0;
        int carbCount = 0;

        for (FoodItem food : foodList) {
            switch (food.getCategory()) {
                case "Fruit":
                    fruitCount++;
                    break;
                case "Vegetable":
                    vegetableCount++;
                    break;
                case "Meat":
                    meatCount++;
                    break;
                case "Carbs":
                    carbCount++;
                    break;
            }
        }

        assertEquals(5, fruitCount);
        assertEquals(5, vegetableCount);
        assertEquals(5, meatCount);
        assertEquals(5, carbCount);
    }
}

