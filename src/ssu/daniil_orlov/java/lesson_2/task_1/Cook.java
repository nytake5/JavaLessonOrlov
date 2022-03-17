package ssu.daniil_orlov.java.lesson_2.task_1;

import ssu.daniil_orlov.java.lesson_2.task_1.food.Food;
import ssu.daniil_orlov.java.lesson_2.task_1.food.dishes.Dish;
import ssu.daniil_orlov.java.lesson_2.task_1.food.ingredients.Ingredient;

import java.util.ArrayList;

public class Cook {

    public String Name;

    public Cook(){}

    public Cook(String Name){
        this.Name = Name;
    }

    public Dish PrepareBorsch(ArrayList<Food> ingredients){
        Dish borsch = new Dish("Borsch", ingredients);
        borsch.setCalories(0);
        return borsch;
    }
}
