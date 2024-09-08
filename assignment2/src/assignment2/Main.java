package assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create ingredients options
        ArrayList<Ingredient> availableIngredients = new ArrayList<>();
        availableIngredients.add(new Ingredient("Flour", 2, "cups"));
        availableIngredients.add(new Ingredient("Sugar", 1, "cup"));
        availableIngredients.add(new Ingredient("Eggs", 3, "pieces"));
        availableIngredients.add(new Ingredient("Milk", 1, "cup"));
        availableIngredients.add(new Ingredient("Butter", 1/2, "cup"));

        Scanner scanner = new Scanner(System.in);

        // Display available ingredients for user selection
        System.out.println("Select ingredients for your recipe by entering the corresponding number:");
        for (int i = 0; i < availableIngredients.size(); i++) {
            System.out.println((i + 1) + ". " + availableIngredients.get(i));
        }

        // Create a recipe
        Recipe recipe = new Recipe("Pancakes", "Delicious pancakes", 4, 20);

        // User input for selecting ingredients
        System.out.println("\nEnter ingredient numbers separated by spaces (e.g., 1 2 3):");
        String input = scanner.nextLine();
        String[] ingredientSelections = input.split(" ");

        // Add selected ingredients to the recipe
        for (String selection : ingredientSelections) {
            int selectedIndex = Integer.parseInt(selection) - 1;
            if (selectedIndex >= 0 && selectedIndex < availableIngredients.size()) {
                recipe.addIngredient(availableIngredients.get(selectedIndex));
            } else {
                System.out.println("Invalid selection: " + selection);
            }
        }

        // Display the selected ingredients
        System.out.println("\nSelected Ingredients:");
        for (Ingredient ingredient : recipe.getIngredients()) {
            System.out.println(ingredient);
        }

        // Add steps to the recipe
        recipe.addStep("Mix all ingredients.");
        recipe.addStep("Heat a frying pan.");
        recipe.addStep("Cook pancakes until golden brown.");

        // Display cooking steps
        System.out.println("\nWould you like to see the cooking steps? (yes/no)");
        String viewSteps = scanner.nextLine();
        if (viewSteps.equalsIgnoreCase("yes")) {
            System.out.println("\nCooking Steps:");
            for (int i = 0; i < recipe.getSteps().size(); i++) {
                System.out.println("Step " + (i + 1) + ": " + recipe.getStep(i));
            }
        }

        // Calculate and display total calories
        System.out.println("\nTotal Calories: " + recipe.calculateCalories());

        // Option to clone the recipe
        System.out.println("\nWould you like to clone the recipe? (yes/no)");
        String cloneRecipe = scanner.nextLine();
        if (cloneRecipe.equalsIgnoreCase("yes")) {
            try {
                Recipe clonedRecipe = recipe.clone();
                System.out.println("\nCloned Recipe Name: " + clonedRecipe.getName());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        // Option to compare recipes based on prep time
        System.out.println("\nWould you like to compare prep time with a quicker recipe? (yes/no)");
        String compareRecipe = scanner.nextLine();
        if (compareRecipe.equalsIgnoreCase("yes")) {
            Recipe quickRecipe = new Recipe("Quick Pancakes", "Faster version of pancakes", 4, 10);
            int comparisonResult = recipe.compareTo(quickRecipe);
            System.out.println("\nComparing prep times: " + comparisonResult);
            if (comparisonResult > 0) {
                System.out.println(recipe.getName() + " takes more prep time than " + quickRecipe.getName());
            } else if (comparisonResult < 0) {
                System.out.println(recipe.getName() + " takes less prep time than " + quickRecipe.getName());
            } else {
                System.out.println("Both recipes take the same prep time.");
            }
        }

        scanner.close();
    }
}
