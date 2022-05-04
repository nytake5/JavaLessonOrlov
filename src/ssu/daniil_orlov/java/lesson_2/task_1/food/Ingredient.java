package ssu.daniil_orlov.java.lesson_2.task_1.food;

import java.io.Serializable;
import java.util.Comparator;

public class Ingredient implements Serializable {

    public Ingredient(){}

    public Ingredient(String title, TypeOfCooking type, Condition condition, int count, int calories){
        setTitle(title);
        typeOfCooking = type;
        this.condition = condition;
        setCount(count);
        setCalories(calories);
    }

    private String _title;

    public TypeOfCooking typeOfCooking;

    public Condition condition;

    protected transient int _count;

    protected transient int _calories;

    public String getTitle(){
        return _title;
    }

    public void setTitle(String value){
        _title = value;
    }

    public int getCount() {
        return _count;
    }

    public void setCount(int value){
        if(value > -1){
            _count = value;
        }
    }

    public int getCalories(){
        return _calories;
    }

    public void setCalories(int value) {
        if(value > -1) {
            _calories = value;
        }
    }

    public Ingredient clone(){
        Ingredient ingredient = new Ingredient();
        ingredient.setCalories(getCalories());
        ingredient.condition = condition;
        ingredient.setTitle(getTitle());
        ingredient.setCount(getCount());
        ingredient.typeOfCooking = typeOfCooking;
        return ingredient;
    }

    @Override
    public String toString(){
        return getTitle() + " " + typeOfCooking + " " + condition + " " + getCount() + " " + getCalories();
    }

    public static final Comparator<Ingredient> COMPARE_BY_CALORIES = new Comparator<Ingredient>() {
        @Override
        public int compare(Ingredient lhs, Ingredient rhs) {
            return lhs.getCalories() - rhs.getCalories();
        }
    };
}
