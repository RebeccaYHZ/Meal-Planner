# Meal-Planner
Authors: Yahui Zhang, Xiangyue Zhang, Ke Feng

This is an application that help people decide daily meal plan.

# FoodItem:
The FoodItem class represents a model for nutritional information of food items. It is designed to encapsulate the key nutritional metrics such as calories, protein, vitamins, fats, and carbohydrates, alongside general information about the food such as its ID, name, and category. This class can be utilized in applications that require management of food data, such as in nutritional databases, health and diet apps, or meal planning software.
# FoodData:
The FoodData class serves as a utility class that generates a list of predefined FoodItem objects. This class can be used to quickly instantiate a diverse set of food items categorized into fruits, vegetables, meats, carbs, and vegan proteins. It is ideal for use in applications that require a large dataset of foods, such as nutritional analysis tools, diet trackers, or menu planning apps.
# CalorieCalculator
This Java class provides a simple yet effective way to calculate Total Daily Energy Expenditure (TDEE) based on age, gender, height, weight, and activity level. The calculateTDEE method takes in these parameters and returns the estimated TDEE using the Harris-Benedict Equation, a widely used formula in nutritional science.
# NutritionNeed
The NutritionNeed class offers a straightforward solution for estimating protein, carbohydrate, and vitamin needs based on Total Daily Energy Expenditure (TDEE) and user-defined goals. By providing inputs for TDEE and goal type, users can obtain personalized recommendations tailored to their objectives of maintaining weight, building muscle, or losing weight.
# FoodListGenerator
The FoodListGenerator class offers a convenient solution for generating categorized lists of food items, facilitating meal planning and dietary diversity. By leveraging the provided FoodData class, which contains a comprehensive list of food items, this generator categorizes foods into distinct groups such as fruits, vegetables, meats, carbs, and vegan proteins.
# MealPlanGenerator
The MealPlanGenerator class generates a personalized meal plan based on user input such as age, gender, height, weight, activity level, dietary preferences, and fitness goals. It calculates the target daily calorie intake and divides it into three main food categories: vegetables/fruits, meat/vegan protein, and carbohydrates. It then generates a meal plan for each category according to the calorie and nutrient requirements.
