package ssu.daniil_orlov.java.lesson_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

public class ThreadQuickSort implements Runnable{
    public static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();
    static final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

    final int[] my_array;
    final int start, end;

    public ThreadQuickSort(int[] my_array, int start, int end) {
        this.my_array = my_array;
        this.start = start;
        this.end = end;
    }

    public void quickSort(int[] arr, int start, int end){
        if (end - start + 1 <= 1)
            return;

        int pivot = arr[end];

        int storeIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int swapTemp = arr[i];
                arr[i] = arr[storeIndex];
                arr[storeIndex] = swapTemp;
                storeIndex++;
            }
        }

        int swapTemp = arr[storeIndex];
        arr[storeIndex] = arr[end];
        arr[end] = swapTemp;

        if (end - start + 1 > (int)(arr.length / MAX_THREADS)){
            ThreadQuickSort quick = new ThreadQuickSort(arr, start, storeIndex - 1);
            Future<?> future = executor.submit(quick);
            quickSort(arr, storeIndex + 1, end);

            try {
                future.get(1000, TimeUnit.SECONDS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            quickSort(arr, start, storeIndex - 1);
            quickSort(arr, storeIndex + 1, end);
        }
    }

    @Override
    public void run() {
        quickSort(my_array, start, end);
    }
}
