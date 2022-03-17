package ssu.daniil_orlov.java.lesson_2.task_1.food;

public class Food {

    public Food(){}

    public Food(String title, TypeOfCooking type, Condition condition, int count, int calories){
        setTitle(title);
        typeOfCooking = type;
        this.condition = condition;
        setCount(count);
        setCalories(calories);
    }

    private String _title;

    public TypeOfCooking typeOfCooking;

    public Condition condition;
    public int _count;

    protected int _calories;

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

    public Food clone(){
        Food food = new Food();
        food.setCalories(getCalories());
        food.condition = condition;
        food.setTitle(getTitle());
        food.setCount(getCount());
        food.typeOfCooking = typeOfCooking;
        return food;
    }

    @Override
    public String toString(){
        return getTitle() + " " + typeOfCooking + " " + condition + " " + getCount() + " " + getCalories();
    }
}
