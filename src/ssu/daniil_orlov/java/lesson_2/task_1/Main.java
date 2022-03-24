package ssu.daniil_orlov.java.lesson_2.task_1;

import ssu.daniil_orlov.java.lesson_2.task_1.food.*;

import java.util.ArrayList;
import java.util.Scanner;

class MyApplicationTwo {

    public static void main(String[] args) {
        MyApplicationTwo app = new MyApplicationTwo();
        app.startApplication();
    }

    private void startApplication() {
        Fridge fridge = createFridgeWithProduct();

        ArrayList<Ingredient> ingredients = getProductForBorsch(fridge);

        Dish dish = new Dish("Borsh", ingredients);

       /* System.out.println(dish.toString());

        dish.sort();

        System.out.println(dish.toString());*/
        findIngredient(dish);
    }

    private ArrayList<Ingredient> getProductForBorsch(Fridge fridge)  {
        ArrayList<Ingredient> res = new ArrayList<Ingredient>();
        res.add( fridge.getProduct("Meat", 1));
        res.add(fridge.getProduct("Carrot", 1));
        res.add(fridge.getProduct("Potato", 3));
        res.add(fridge.getProduct("Onion", 1));
        res.add(fridge.getProduct("Beet", 1));
        return res;
    }

    private Fridge createFridgeWithProduct() {
        Fridge fridge = new Fridge();
        fridge.addProduct(new Vegetable("Carrot", TypeOfCooking.Cook, Condition.Raw, 3, 200));
        fridge.addProduct(new Vegetable("Potato", TypeOfCooking.Cook, Condition.Raw, 6, 100));
        fridge.addProduct(new Vegetable("Tomato", TypeOfCooking.Cook, Condition.Raw, 10, 300));
        fridge.addProduct(new Vegetable("Cabbage", TypeOfCooking.Cook, Condition.Raw, 2, 150));
        fridge.addProduct(new Vegetable("Onion", TypeOfCooking.Cook, Condition.Raw, 1, 50));
        fridge.addProduct(new Vegetable("Beet", TypeOfCooking.Cook, Condition.Raw, 2,  70));
        fridge.addProduct(new Vegetable("Eggplant", TypeOfCooking.Cook, Condition.Raw, 2, 350));
        fridge.addProduct(new Vegetable("Zucchini", TypeOfCooking.Cook, Condition.Raw, 3, 150));
        fridge.addProduct(new Meat("Meat", TypeOfCooking.Fry, Condition.Raw, 5, 500));

        return fridge;
    }

    public void findIngredient(Dish dish){
        int calories;
        TypeOfCooking type;
        Condition condition;

        Scanner in = new Scanner(System.in);
        System.out.println("Input calories:");
        calories = in.nextInt();
        System.out.println("Input type:");
        switch (in.next()){
            case "Fry":
                type = TypeOfCooking.Fry;
                break;
            case "Cook":
                type = TypeOfCooking.Cook;
                break;
            case "Bake":
                type = TypeOfCooking.Bake;
                break;
            case "Nothing":
                type = TypeOfCooking.Nothing;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + in.next());
        }
        System.out.println("Input condition:");
        switch (in.next()){
            case "Raw":
                condition = Condition.Raw;
                break;
            case "Ready":
                condition = Condition.Ready;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + in.next());
        }
        for(Ingredient ingredient : dish.Ingredients){
            if (ingredient.condition.equals(condition) &&
                ingredient.typeOfCooking.equals(type) &&
                ingredient.getCalories() == calories){
                System.out.println(ingredient.toString());
            }
        }
    }
}
