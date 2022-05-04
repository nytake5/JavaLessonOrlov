package ssu.daniil_orlov.java.lesson_2.task_1.food;

import java.io.Serializable;

public class Meat extends Ingredient implements Serializable {
    public Meat(String title, TypeOfCooking type, Condition condition, int count, int calories){
        super(title, type, condition, count, calories);
    }
}
