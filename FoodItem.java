public class FoodItem {
    private int id;
    private String category;
    private int calories;
    private int protein;
    private int vitamin;
    private int fat;
    private int carb;
    private String name;

    public FoodItem(int id, String name, String category, int calories, int protein, int vitamin, int fat, int carb) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.calories = calories;
        this.protein = protein;
        this.vitamin = vitamin;
        this.fat = fat;
        this.carb = carb;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getVitamin() {
        return vitamin;
    }

    public int getFat() {
        return fat;
    }

    public int getCarb() {
        return carb;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", calories=" + calories +
                ", protein=" + protein +
                ", vitamin=" + vitamin +
                ", fat=" + fat +
                ", carb=" + carb +
                '}';
    }
}
