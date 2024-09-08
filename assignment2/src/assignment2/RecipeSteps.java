package assignment2;

public interface RecipeSteps {
    void addStep(String step);            // Add a cooking step
    void removeStep(int stepNumber);      // Remove a step by its number
    String getStep(int stepNumber);       // Retrieve a specific step
}
