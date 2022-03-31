package ssu.daniil_orlov.java.lesson_2.task_1.food;

import java.io.Serializable;
import java.util.Comparator;

public class Ingredient implements Serializable {

    private String title;

    public TypeOfCooking typeOfCooking;

    public Condition condition;

    private int count;

    private int calories;

    public Ingredient(){}

    public Ingredient(String title, TypeOfCooking type, Condition condition, int count, int calories){
        setTitle(title);
        typeOfCooking = type;
        this.condition = condition;
        setCount(count);
        setCalories(calories);
    }


    public String getTitle(){
        return title;
    }

    public void setTitle(String value){
        title = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value){
        if(value > -1){
            count = value;
        }
    }

    public TypeOfCooking getTypeOfCooking() {
        return typeOfCooking;
    }

    public void setTypeOfCooking(TypeOfCooking typeOfCooking) {
        this.typeOfCooking = typeOfCooking;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public int getCalories(){
        return calories;
    }

    public void setCalories(int value) {
        if(value > -1) {
            calories = value;
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
            return Integer.compare(lhs.getCalories(), rhs.getCalories());
        }
    };
}
