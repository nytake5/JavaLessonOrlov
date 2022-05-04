package ssu.daniil_orlov.java.lesson_2.task_1.food;

import java.io.Serializable;

public class Fruit extends Ingredient implements Serializable {
    public Fruit(String title, TypeOfCooking type, Condition condition, int count, int calories){
        super(title, type, condition, count, calories);
    }
}
