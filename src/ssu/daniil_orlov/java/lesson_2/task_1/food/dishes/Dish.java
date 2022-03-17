package ssu.daniil_orlov.java.lesson_2.task_1.food.dishes;

import ssu.daniil_orlov.java.lesson_2.task_1.food.Condition;
import ssu.daniil_orlov.java.lesson_2.task_1.food.Food;
import ssu.daniil_orlov.java.lesson_2.task_1.food.TypeOfCooking;
import ssu.daniil_orlov.java.lesson_2.task_1.food.ingredients.Ingredient;

import java.util.ArrayList;

public class Dish extends Food {
    private ArrayList<Food> _ingredients;

    public Dish(){}

    public Dish(String title, ArrayList<Food> ingredients){
        setTitle(title);
        _ingredients = ingredients;
        setCount(1);
        typeOfCooking = TypeOfCooking.Nothing;
        condition = Condition.Ready;
    }

    @Override
    public int getCalories(){
        int res = 0;
        for (int i = 0; i < _ingredients.size() - 2; i++){
            res += _ingredients.get(i).getCalories() * _ingredients.get(i).getCount();
        }
        return res;
    }
}
