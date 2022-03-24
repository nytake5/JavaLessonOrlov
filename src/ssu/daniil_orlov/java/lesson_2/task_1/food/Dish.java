package ssu.daniil_orlov.java.lesson_2.task_1.food;

import java.util.ArrayList;
import java.util.Collections;

public class Dish{
    public ArrayList<Ingredient> Ingredients;

    private String _title;

    public String getTitle(){
        return _title;
    }

    public void setTitle(String value){
        _title = value;
    }

    public Dish(String title, ArrayList<Ingredient> ingredients){
        setTitle(title);
        Ingredients = ingredients;
    }

    public Integer getCalories(){
        Integer res = 0;
        for(Ingredient ingredient : Ingredients){
            res += ingredient.getCalories();
        }
        return res;
    }

    public void sort(){
        Collections.sort(Ingredients, Ingredient.COMPARE_BY_CALORIES);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "_ingredients=" + Ingredients +
                ", _title='" + _title + '\'' +
                '}';
    }
}
