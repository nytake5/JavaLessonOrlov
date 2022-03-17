package ssu.daniil_orlov.java.lesson_2.task_1;

import ssu.daniil_orlov.java.lesson_2.task_1.food.Food;
import ssu.daniil_orlov.java.lesson_2.task_1.food.TypeOfCooking;
import ssu.daniil_orlov.java.lesson_2.task_1.food.Condition;
import ssu.daniil_orlov.java.lesson_2.task_1.food.ingredients.Ingredient;

import java.util.ArrayList;

class MyApplicationTwo {

    public static void main(String[] args) {
        MyApplicationTwo app = new MyApplicationTwo();
        app.startApplication();
    }

    private void startApplication() {
        Fridge fridge = CreateFridgeWithProduct();

        Cook cook = new Cook("Petia");

        ArrayList<Food> ingredients = GetProductForBorsch(fridge);

        fridge.AddProduct(cook.PrepareBorsch(ingredients));

        System.out.println(fridge.toString());
    }

    private ArrayList<Food> GetProductForBorsch(Fridge fridge)  {
        ArrayList<Food> res = new ArrayList<Food>();
        res.add( fridge.getProduct("Meat", 1));
        res.add(fridge.getProduct("Carrot", 1));
        res.add(fridge.getProduct("Potato", 3));
        res.add(fridge.getProduct("Onion", 1));
        res.add(fridge.getProduct("Beet", 1));
        return res;
    }

    private Fridge CreateFridgeWithProduct() {
        Fridge fridge = new Fridge();
        fridge.AddProduct(new Ingredient("Carrot", TypeOfCooking.Cook, Condition.Raw, 3, 200));
        fridge.AddProduct(new Ingredient("Potato", TypeOfCooking.Cook, Condition.Raw, 6, 100));
        fridge.AddProduct(new Ingredient("Tomato", TypeOfCooking.Cook, Condition.Raw, 10, 300));
        fridge.AddProduct(new Ingredient("Cabbage", TypeOfCooking.Cook, Condition.Raw, 2, 150));
        fridge.AddProduct(new Ingredient("Onion", TypeOfCooking.Cook, Condition.Raw, 1, 50));
        fridge.AddProduct(new Ingredient("Beet", TypeOfCooking.Cook, Condition.Raw, 2,  70));
        fridge.AddProduct(new Ingredient("Eggplant", TypeOfCooking.Cook, Condition.Raw, 2, 350));
        fridge.AddProduct(new Ingredient("Zucchini", TypeOfCooking.Cook, Condition.Raw, 3, 150));
        fridge.AddProduct(new Ingredient("Meat", TypeOfCooking.Fry, Condition.Raw, 2, 500));

        return fridge;
    }
}
