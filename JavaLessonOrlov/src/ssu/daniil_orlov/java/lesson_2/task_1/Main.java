package ssu.daniil_orlov.java.lesson_2.task_1;

import ssu.daniil_orlov.java.lesson_2.task_1.food.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MyApplicationTwo {

    public static void main(String[] args) {
        MyApplicationTwo app = new MyApplicationTwo();
        app.startApplication();
    }

    private void startApplication() {
        Fridge fridge = createFridgeWithProduct();

        List<Ingredient> ingredients = getProductForBorsch(fridge);

        Dish dish = new Dish("Borsh", ingredients);

        System.out.println(dish.toString());

        dish.sort();

        System.out.println(dish.toString());
        //findIngredient(dish);
    }

    private List<Ingredient> getProductForBorsch(Fridge fridge)  {
        List<Ingredient> res = new ArrayList<Ingredient>();
        res.add( fridge.getProduct("Meat", 1));
        res.add(fridge.getProduct("Carrot", 1));
        res.add(fridge.getProduct("Potato", 3));
        res.add(fridge.getProduct("Onion", 1));
        res.add(fridge.getProduct("Beet", 1));
        return res;
    }

    private Fridge createFridgeWithProduct() {
        Fridge fridge = new Fridge();
        fridge.addProduct(new Vegetable("Carrot", TypeOfCooking.COOK, Condition.RAW, 3, 200));
        fridge.addProduct(new Vegetable("Potato", TypeOfCooking.COOK, Condition.RAW, 6, 100));
        fridge.addProduct(new Vegetable("Tomato", TypeOfCooking.COOK, Condition.RAW, 10, 300));
        fridge.addProduct(new Vegetable("Cabbage", TypeOfCooking.COOK, Condition.RAW, 2, 150));
        fridge.addProduct(new Vegetable("Onion", TypeOfCooking.COOK, Condition.RAW, 1, 50));
        fridge.addProduct(new Vegetable("Beet", TypeOfCooking.COOK, Condition.RAW, 2,  70));
        fridge.addProduct(new Vegetable("Eggplant", TypeOfCooking.COOK, Condition.RAW, 2, 350));
        fridge.addProduct(new Vegetable("Zucchini", TypeOfCooking.COOK, Condition.RAW, 3, 150));
        fridge.addProduct(new Meat("Meat", TypeOfCooking.FRY, Condition.RAW, 5, 500));

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
            case "FRY":
                type = TypeOfCooking.FRY;
                break;
            case "COOK":
                type = TypeOfCooking.COOK;
                break;
            case "BAKE":
                type = TypeOfCooking.BAKE;
                break;
            case "NOTHING":
                type = TypeOfCooking.NOTHING;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + in.next());
        }
        System.out.println("Input condition:");
        switch (in.next()){
            case "RAW":
                condition = Condition.RAW;
                break;
            case "READY":
                condition = Condition.READY;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + in.next());
        }

        for(Ingredient ingredient : dish.ingredientList){
            if (ingredient.condition.equals(condition) &&
                ingredient.typeOfCooking.equals(type) &&
                ingredient.getCalories() == calories){
                System.out.println(ingredient.toString());
            }
        }
    }
}
