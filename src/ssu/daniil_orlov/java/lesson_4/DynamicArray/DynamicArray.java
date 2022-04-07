package ssu.daniil_orlov.java.lesson_4.DynamicArray;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<T> implements Iterable<T>{
    private T[] array;
    Integer count;
    Integer capacity;

    public DynamicArray(){
        array = (T[]) new Object[16];
        count = 0;
        capacity = 16;
    }

    public DynamicArray(Integer length){
        array = (T[]) new Object[length];
        count = 0;
        capacity = length;
    }

    public void add(T value){
        if (count == capacity - 1 || count == capacity){
            increaseSize();
        }
        array[count++] = value;
    }

    public T get(Integer index){
        if (index > count - 1 || index < 0){
            return null;
        }
        return array[index];
    }

    public void set(T value, Integer index){
        if(index > count){
            add(value);
        }
        if(index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(count == capacity - 1){
            increaseSize();
        }
        for (int i = count; i > index; i--){
            array[i] = array[i - 1];
        }
        array[index] = value;
        count++;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder(count);
        for(int i = 0; i < count - 1; i++){
            res.append(array[i].toString());
            res.append(" ");
        }
        return res.toString();
    }

    public boolean remove(Integer index){
        if (index >= count || index < 0){
            return false;
        }
        for(int i = index; i < count - 2; i++){
            array[i] = array[i + 1];
        }
        count--;
        return true;
    }

    private void increaseSize(){
        capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < count; i++){
            newArray[i] = (T) array[i];
        }
        array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex  = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < count - 1 && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }
        };
        return it;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
