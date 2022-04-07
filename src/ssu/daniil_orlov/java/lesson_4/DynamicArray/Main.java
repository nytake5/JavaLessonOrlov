package ssu.daniil_orlov.java.lesson_4.DynamicArray;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.startApplication();
    }

    private void startApplication() {
        DynamicArray<Integer> arr = new DynamicArray<Integer>(10);

        for (int i = 1; i < 10; i++){
            arr.add(i);
        }

        System.out.println(arr.toString());

        arr.set(100, 4);

        System.out.println(arr.toString());

        arr.remove(4);

        System.out.println(arr.toString());

    }
}