import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FoodListGeneratorTest {

    @Test
    public void testGenerateFoodList() {
        int numberOfFoods = 20; // Test with 20 food items
        List<FoodItem> foodList = FoodListGenerator.generateFoodList(numberOfFoods);

        // Check if the generated list size is 20 (5 foods for each nutrient type)
        assertEquals(20, foodList.size());

        // Check if all generated food items have unique IDs
        for (int i = 0; i < foodList.size(); i++) {
            for (int j = i + 1; j < foodList.size(); j++) {
                assertTrue(foodList.get(i).getId() != foodList.get(j).getId());
            }
        }

        // Check if each nutrient type has exactly 5 food items
        int proteinCount = 0;
        int carbCount = 0;
        int fatCount = 0;
        int vitaminCount = 0;

        for (FoodItem food : foodList) {
            proteinCount += (food.getProtein() > 0) ? 1 : 0;
            carbCount += (food.getCarb() > 0) ? 1 : 0;
            fatCount += (food.getFat() > 0) ? 1 : 0;
            vitaminCount += (food.getVitamin() > 0) ? 1 : 0;
        }

        assertEquals(5, proteinCount);
        assertEquals(5, carbCount);
        assertEquals(5, fatCount);
        assertEquals(5, vitaminCount);
    }
}
