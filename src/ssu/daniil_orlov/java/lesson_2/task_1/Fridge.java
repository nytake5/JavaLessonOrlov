package ssu.daniil_orlov.java.lesson_2.task_1;

import ssu.daniil_orlov.java.lesson_2.task_1.food.Food;

import java.util.ArrayList;

public class Fridge {
    public ArrayList<Food> foods;

    public Fridge(){
        foods = new ArrayList<>();
    }

    public void AddProduct(Food food){
        for (int i = 0; i < foods.size() - 1; i++){
            if (foods.get(i).getTitle().equals(food.getTitle())){
                Food tempFood = foods.get(i);
                tempFood.setCount(tempFood.getCount() + food.getCount());
                foods.set(i, tempFood);
                return;
            }
        }
        foods.add(food);
    }

    public Food getProduct(String foodName, int count) {
        for (int i = 0; i < foods.size() - 1; i++){
            if (foods.get(i).getTitle().equals(foodName)){
                Food tempFood = foods.get(i);
                tempFood.setCount(tempFood.getCount() - count);
                foods.set(i, tempFood);
                Food resFood = foods.get(i).clone();
                resFood.setCount(count);
                return resFood;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Food food : foods) {
            res.append(food.toString() + "\n");
        }
        return res.toString();
    }
}
