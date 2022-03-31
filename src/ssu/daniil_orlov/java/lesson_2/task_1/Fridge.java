package ssu.daniil_orlov.java.lesson_2.task_1;

import ssu.daniil_orlov.java.lesson_2.task_1.KitchenExcptions.IngredientNotEnoughException;
import ssu.daniil_orlov.java.lesson_2.task_1.KitchenExcptions.IngredientNotFoundException;
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

    public Ingredient getProduct(String foodName, int count) throws IngredientNotFoundException, IngredientNotEnoughException {
        for (int i = 0; i < ingredients.size(); i++){
            if (ingredients.get(i).getTitle().equals(foodName)){
                Ingredient tempIngredient = ingredients.get(i);
                tempIngredient.setCount(tempIngredient.getCount() - count);
                if (tempIngredient.getCount() < 0){
                    throw new IngredientNotEnoughException("Ingredient not enough!");
                }
                ingredients.set(i, tempIngredient);
                Ingredient resIngredient = ingredients.get(i).clone();
                resIngredient.setCount(count);
                return resIngredient;
            }
        }
        throw new IngredientNotFoundException("Ingredient not found!");
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
