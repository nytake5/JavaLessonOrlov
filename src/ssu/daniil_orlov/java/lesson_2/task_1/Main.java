package ssu.daniil_orlov.java.lesson_2.task_1;

import ssu.daniil_orlov.java.lesson_2.task_1.KitchenExcptions.ConditionException;
import ssu.daniil_orlov.java.lesson_2.task_1.KitchenExcptions.IngredientNotEnoughException;
import ssu.daniil_orlov.java.lesson_2.task_1.KitchenExcptions.IngredientNotFoundException;
import ssu.daniil_orlov.java.lesson_2.task_1.KitchenExcptions.TypeOfCookingException;
import ssu.daniil_orlov.java.lesson_2.task_1.food.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class MyApplicationTwo {

    public static void main(String[] args) {
        MyApplicationTwo app = new MyApplicationTwo();
        app.startApplication();
    }

    private void startApplication(){
        Fridge fridge = createFridgeWithProduct();

        ArrayList<Ingredient> ingredients = getProductForBorsch(fridge);

        Dish dish = new Dish("Borsh", ingredients);

        serializeDish(dish);

        Dish desDish = deserializeDish();
        System.out.println(dish.toString());
        System.out.println(desDish.toString());
        /* System.out.println(dish.toString());

        dish.sort();

        System.out.println(dish.toString());
        try {
            findIngredient(dish);
        }
        catch (ConditionException | TypeOfCookingException exception){
            System.out.println(exception.toString());
            return;
        }*/
    }

    public void serializeDish(Dish dish){
        try(ObjectOutputStream ios = new ObjectOutputStream(new FileOutputStream("data.bin"))){
            ios.writeObject(dish);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dish deserializeDish(){
        try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream("data.bin"))) {
            return (Dish) ios.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Ingredient> getProductForBorsch(Fridge fridge)  {
        ArrayList<Ingredient> res = new ArrayList<Ingredient>();
        try{
            res.add( fridge.getProduct("Meat", 1));
            res.add(fridge.getProduct("Carrot", 1));
            res.add(fridge.getProduct("Potato", 3));
            res.add(fridge.getProduct("Onion", 1));
        }
        catch (IngredientNotEnoughException | IngredientNotFoundException exception){
            System.out.println(exception.toString());
            return new ArrayList<Ingredient>();
        }
        return res;
    }

    private Fridge createFridgeWithProduct() {
        Fridge fridge = new Fridge();
        fridge.addProduct(new Vegetable("Carrot", TypeOfCooking.Cook, Condition.Raw, 3, 200));
        fridge.addProduct(new Vegetable("Potato", TypeOfCooking.Cook, Condition.Raw, 6, 100));
        fridge.addProduct(new Vegetable("Tomato", TypeOfCooking.Cook, Condition.Raw, 10, 300));
        fridge.addProduct(new Vegetable("Cabbage", TypeOfCooking.Cook, Condition.Raw, 2, 150));
        fridge.addProduct(new Vegetable("Onion", TypeOfCooking.Cook, Condition.Raw, 2, 50));
        fridge.addProduct(new Vegetable("Beet", TypeOfCooking.Cook, Condition.Raw, 2,  70));
        fridge.addProduct(new Vegetable("Eggplant", TypeOfCooking.Cook, Condition.Raw, 2, 350));
        fridge.addProduct(new Vegetable("Zucchini", TypeOfCooking.Cook, Condition.Raw, 3, 150));
        fridge.addProduct(new Meat("Meat", TypeOfCooking.Fry, Condition.Raw, 5, 500));

        return fridge;
    }

    public void findIngredient(Dish dish) throws TypeOfCookingException, ConditionException {
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
                throw new TypeOfCookingException("Unexpected value: " + in.next());
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
                throw new ConditionException("Unexpected value: " + in.next());
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
