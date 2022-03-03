package ssu.daniil_orlov.java.lesson_1.task1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


class MyApplicationOne {

    public final int N = 20;

    public static void main(String[] args) {
        MyApplicationOne app = new MyApplicationOne();
        app.startApplication();
    }

    private void startApplication() {
        int[] arr = new int[N];

        GenerateRandomArray(arr);
        WriteArray(arr);

        int[] ans1 = SwapMaxNegativeWhitMinPositive(arr);
        WriteArray(ans1);

        int ans2 = SumEvenNumbers(arr);
        System.out.println(ans2);

        int[] ans3 = ReplaceNull(arr);
        WriteArray(ans3);

        int[] ans4 = TriplePositiveBeforeNegative(arr);
        WriteArray(ans4);

        double ans5 = DifferenceAverageAndMinimum(arr);
        System.out.println(ans5);

        ArrayList<Integer> ans6 = ElementWhatFoundMoreOneTime(arr);
        WriteList(ans6);
    }

    private ArrayList<Integer> ElementWhatFoundMoreOneTime(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++){
            if (hashMap.containsKey(array[i])){
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            }
            else{
                hashMap.put(array[i], 1);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) > 1)
            {
                arr.add(key);
            }
        }
        return arr;
    }

    private double DifferenceAverageAndMinimum(int[] array) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++){
            sum += array[i];
            if (min > array[i])
            {
                min = array[i];
            }
        }
        return Math.abs(((double)sum / N) - min);
    }

    private int[] TriplePositiveBeforeNegative(int[] array) {
        int countNewArray = N;
        for (int i = 0; i < array.length - 1; i++){
            if (array[i + 1] < 0 && array[i] > 0)
            {
                countNewArray += 2;
            }
        }
        int[] arr = new int[countNewArray];
        int j = 0;
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] > 0 && array[i + 1] < 0)
            {
                arr[j] = array[i];
                arr[j + 1] = array[i];
                j += 2;
            }
            arr[j] = array[i];
            j++;
        }
        arr[countNewArray - 1] = array[array.length - 1];
        return arr;
    }

    private int[] ReplaceNull(int[] array) {
        int[] arr = array.clone();
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] < 0){
                arr[i] = 0;
            }
        }
        return arr;
    }

    private int SumEvenNumbers(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i += 2){
            sum += array[i];
        }
        return sum;
    }

    private void WriteArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void WriteList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    private void GenerateRandomArray(int[] array){
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0, 20) - 10;
        }
    }

    private int[] SwapMaxNegativeWhitMinPositive(int[] array){
        int[] arr = array.clone();
        int max = Integer.MIN_VALUE;
        int maxId = -1;
        int min = Integer.MAX_VALUE;
        int minId = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 && Math.abs(arr[i]) > max){
                max = Math.abs(arr[i]);
                maxId = i;
            }
            if (arr[i] > 0 && min > arr[i]){
                min = arr[i];
                minId = i;
            }
        }

        arr[minId] = -max;
        arr[maxId] = min;

        return arr;
    }
}
