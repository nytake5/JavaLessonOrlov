package ssu.daniil_orlov.java.lesson_2.task_1;

import ssu.daniil_orlov.java.lesson_2.task_1.food.Ingredient;

import java.util.ArrayList;

public class Fridge {
    public ArrayList<Ingredient> ingredients;

    public Fridge(){
        ingredients = new ArrayList<>();
    }

    public void addProduct(Ingredient ingredient){
        for (int i = 0; i < this.ingredients.size(); i++){
            if (this.ingredients.get(i).getTitle().equals(ingredient.getTitle())){
                Ingredient tempIngredient = this.ingredients.get(i);
                tempIngredient.setCount(tempIngredient.getCount() + ingredient.getCount());
                this.ingredients.set(i, tempIngredient);
                return;
            }
        }
        this.ingredients.add(ingredient);
    }

    public Ingredient getProduct(String foodName, int count) {
        for (int i = 0; i < ingredients.size(); i++){
            if (ingredients.get(i).getTitle().equals(foodName)){
                Ingredient tempIngredient = ingredients.get(i);
                tempIngredient.setCount(tempIngredient.getCount() - count);
                ingredients.set(i, tempIngredient);
                Ingredient resIngredient = ingredients.get(i).clone();
                resIngredient.setCount(count);
                return resIngredient;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Ingredient ingredient : this.ingredients) {
            res.append(ingredient.toString() + "\n");
        }
        return res.toString();
    }
}
