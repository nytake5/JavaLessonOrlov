package ssu.daniil_orlov.java.lesson_2.task_1.food;

import java.util.Collections;
import java.util.List;

public class Dish{
    public List<Ingredient> ingredientList;

    private String title;

    public String getTitle(){
        return title;
    }

    public void setTitle(String value){
        title = value;
    }

    public Dish(String title, List<Ingredient> ingredientList){
        setTitle(title);
        this.ingredientList = ingredientList;
    }

    public Integer getCalories(){
        Integer res = 0;
        for(Ingredient ingredient : ingredientList){
            res += ingredient.getCalories();
        }
        return res;
    }

    public void sort(){
        Collections.sort(ingredientList, Ingredient.COMPARE_BY_CALORIES);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "_ingredients=" + ingredientList +
                ", title='" + title + '\'' +
                '}';
    }
}
