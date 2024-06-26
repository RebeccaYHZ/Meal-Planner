import static org.junit.Assert.*;
import org.junit.Test;
public class CalorieCalculatorTest {

    @Test
    public void testCalculateTDEE_Male() {
        int age = 30;
        int gender = 0; // Male
        double height = 175; // in centimeters
        double weight = 70; // in kilograms
        double activityLevel = 1.5; // Moderately active

        double expectedTDEE = 2370.71;
        double actualTDEE = CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);

        assertEquals(expectedTDEE, actualTDEE, 0.01);
    }

    @Test
    public void testCalculateTDEE_Female() {
        int age = 30;
        int gender = 1; // Female
        double height = 160; // in centimeters
        double weight = 60; // in kilograms
        double activityLevel = 1.6; // Lightly active

        double expectedTDEE = 1747.38;
        double actualTDEE = CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);

        assertEquals(expectedTDEE, actualTDEE, 0.01);
    }

    @Test
    public void testCalculateTDEE_InvalidAge() {
        int age = -10; // Invalid age
        int gender = 0; // Male
        double height = 170; // in centimeters
        double weight = 65; // in kilograms
        double activityLevel = 1.2; // Sedentary

        // The function should throw IllegalArgumentException for negative age
        assertThrows(IllegalArgumentException.class, () -> {
            CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);
        });
    }

    @Test
    public void testCalculateTDEE_InvalidGender() {
        int age = 30;
        int gender = 2; // Invalid gender
        double height = 170; // in centimeters
        double weight = 65; // in kilograms
        double activityLevel = 1.2; // Sedentary

        // The function should throw IllegalArgumentException for unsupported gender
        assertThrows(IllegalArgumentException.class, () -> {
            CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);
        });
    }

    @Test
    public void testCalculateTDEE_InvalidHeight() {
        int age = 30;
        int gender = 0; // Male
        double height = -170; // Invalid height
        double weight = 65; // in kilograms
        double activityLevel = 1.2; // Sedentary

        // The function should throw IllegalArgumentException for negative height
        assertThrows(IllegalArgumentException.class, () -> {
            CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);
        });
    }

    @Test
    public void testCalculateTDEE_InvalidWeight() {
        int age = 30;
        int gender = 1; // Female
        double height = 160; // in centimeters
        double weight = -65; // Invalid weight
        double activityLevel = 1.2; // Sedentary

        // The function should throw IllegalArgumentException for negative weight
        assertThrows(IllegalArgumentException.class, () -> {
            CalorieCalculator.calculateTDEE(age, gender, height, weight, activityLevel);
        });
    }
}