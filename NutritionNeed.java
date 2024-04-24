public class NutritionNeed {
    // for the input goal:
    // 0 stands for maintain weight
    // 1 stands for build muscle
    // 2 stands for lose weight

    public static double proteinNeed(double tdee, int goal) {

        double proteinRatio = 0.2; // Default protein ratio (20% of TDEE)
        if (goal == 1) {
            // Increase protein intake for muscle building
            proteinRatio = 0.3; // 30% of TDEE
        } else if (goal == 2) {
            proteinRatio = 0.1;
        }
        // Calculate protein need based on TDEE and protein ratio
        return tdee * proteinRatio;
    }

    public static double carbsNeed(double tdee, int goal) {
        double carbsRatio = 0.5; // Default carbs ratio (50% of TDEE)
        if (goal == 1) {
            carbsRatio = 0.3;
        } else if (goal == 2) {
            // Reduce carbs intake for weight loss
            carbsRatio = 0.4; // 40% of TDEE
        }
        // Calculate carbs need based on TDEE and carbs ratio
        return tdee * carbsRatio;
    }

    public static double vitaminNeed(double tdee, int goal) {
        double vitaminRatio = 0.3; // Default vitamin ratio (30% of TDEE)
        if (goal == 1) {
            // Increase vitamin intake for muscle building
            vitaminRatio = 0.4; // 40% of TDEE
        } else if (goal == 2) {
            vitaminRatio = 0.5;
        }
        // Calculate vitamin need based on TDEE and vitamin ratio
        return tdee * vitaminRatio;
    }
}
