package ssu.daniil_orlov.java.lesson_2.task_1.food.ingredients;

import ssu.daniil_orlov.java.lesson_2.task_1.food.Food;
import ssu.daniil_orlov.java.lesson_2.task_1.food.TypeOfCooking;
import ssu.daniil_orlov.java.lesson_2.task_1.food.Condition;


public class Ingredient extends Food {
    public Ingredient(){}

    public Ingredient(String title, TypeOfCooking type, Condition condition, int count, int calories) {
        setTitle(title);
        typeOfCooking = type;
        this.condition = condition;
        setCount(count);
        setCalories(calories);
    }
}
