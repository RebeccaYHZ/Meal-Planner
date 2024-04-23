import java.util.*;
public class CalorieCalculator {

    // Function to calculate Total Daily Energy Expenditure (TDEE)
    public static double calculateTDEE(int age, int gender, double height, double weight, double activityLevel) {
        double bmr;
        //Integer 0 means male
        //Integer 1 means female
        //activity level is from 1.2 to 2.4;
        if(age < 0) throw new IllegalArgumentException("unsupported age");
        if(gender != 0 && gender != 1)if(age < 0) throw new IllegalArgumentException("unsupported gender");
        if(height < 0) throw new IllegalArgumentException("unsupported height");
        if(weight < 0) throw new IllegalArgumentException("unsupported weight");

        if (gender == 0) {
            //Harris-Benedict Equation for male (BMR calculation)
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else{
            //Harris-Benedict Equation for female (BMR calculation)
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        // Total Daily Energy Expenditure (TDEE) calculation based on activity level
        double tdee = 0;
        tdee = bmr * activityLevel;

        return tdee;
    }
}