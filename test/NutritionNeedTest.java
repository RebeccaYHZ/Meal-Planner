import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NutritionNeedTest {

    // Test for proteinNeed method
    @Test
    public void testProteinNeed() {
        double tdee = 2000; // Example TDEE
        int[] goals = {0, 1, 2}; // Goals: 0 - maintain weight, 1 - build muscle, 2 - lose weight
        double[] expectedProtein = {400, 600, 200}; // Expected protein needs for each goal

        for (int i = 0; i < goals.length; i++) {
            double protein = NutritionNeed.proteinNeed(tdee, goals[i]);
            assertEquals(expectedProtein[i], protein, 0.1); // Tolerate small deviations
        }
    }

    // Test for carbsNeed method
    @Test
    public void testCarbsNeed() {
        double tdee = 2000; // Example TDEE
        int[] goals = {0, 1, 2}; // Goals: 0 - maintain weight, 1 - build muscle, 2 - lose weight
        double[] expectedCarbs = {1000, 600, 800}; // Expected carbs needs for each goal

        for (int i = 0; i < goals.length; i++) {
            double carbs = NutritionNeed.carbsNeed(tdee, goals[i]);
            assertEquals(expectedCarbs[i], carbs, 0.1); // Tolerate small deviations
        }
    }

    // Test for vitaminNeed method
    @Test
    public void testVitaminNeed() {
        double tdee = 2000; // Example TDEE
        int[] goals = {0, 1, 2}; // Goals: 0 - maintain weight, 1 - build muscle, 2 - lose weight
        double[] expectedVitamin = {200, 300, 400}; // Expected vitamin needs for each goal

        for (int i = 0; i < goals.length; i++) {
            double vitamin = NutritionNeed.vitaminNeed(tdee, goals[i]);
            assertEquals(expectedVitamin[i], vitamin, 0.1); // Tolerate small deviations
        }
    }
}
