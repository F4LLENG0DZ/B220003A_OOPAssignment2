package assignment2;

import java.util.ArrayList;

public class Recipe implements RecipeSteps, RecipeNutritionInfo, Comparable<Recipe>, Cloneable {
    private String name;
    private String description;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> steps;
    private int servings;
    private int prepTime;  // in minutes

    public Recipe(String name, String description, int servings, int prepTime) {
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.servings = servings;
        this.prepTime = prepTime;
    }

    // Ingredient management
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(String ingredientName) {
        ingredients.removeIf(ingredient -> ingredient.getName().equalsIgnoreCase(ingredientName));
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    // RecipeSteps interface implementation
    @Override
    public void addStep(String step) {
        steps.add(step);
    }

    @Override
    public void removeStep(int stepNumber) {
        if (stepNumber >= 0 && stepNumber < steps.size()) {
            steps.remove(stepNumber);
        } else {
            System.out.println("Invalid step number.");
        }
    }

    @Override
    public String getStep(int stepNumber) {
        if (stepNumber >= 0 && stepNumber < steps.size()) {
            return steps.get(stepNumber);
        } else {
            return "Step not found.";
        }
    }

    // RecipeNutritionInfo interface implementation
    @Override
    public int calculateCalories() {
        // Assume each ingredient has some calorie count logic, sum all the calories
        int totalCalories = 0;
        for (Ingredient ingredient : ingredients) {
            totalCalories += ingredient.getQuantity() * 50;  // Simulated calorie calculation
        }
        return totalCalories;
    }

    @Override
    public int calculateServings() {
        return servings;
    }

    @Override
    public int calculatePrepTime() {
        return prepTime;
    }

    // Comparable implementation to compare recipes based on prep time
    @Override
    public int compareTo(Recipe otherRecipe) {
        return Integer.compare(this.prepTime, otherRecipe.prepTime);
    }

    // Cloneable implementation
    @Override
    public Recipe clone() throws CloneNotSupportedException {
        Recipe cloned = (Recipe) super.clone();
        cloned.ingredients = new ArrayList<>(this.ingredients);  // Deep copy of ingredients
        cloned.steps = new ArrayList<>(this.steps);  // Deep copy of steps
        return cloned;
    }

    // Simple getters and setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Recipe: " + name + " | Servings: " + servings + " | Prep Time: " + prepTime + " minutes";
    }
}
