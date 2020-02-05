package com.volkodav4ik;

//1) Реализовать класс IntArrayList и интерфейс IntList по аналогии с List<Integer> (ArrayList)
//2) Про помощи своего класса IntList заполнить случайными числами и отсортировать.
//3) Протестировать по быстродействию выполнения метода add() 10к раз.

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();
    private static final int MAX_VALUE = 1000;
    private static final int ARRAY_SIZE = 10;
    private static final int MAX_INDEX = 100000;

    public static void main(String[] args) {

        IntList list = new IntArrayList();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            list.add(RANDOM.nextInt(MAX_VALUE));
        }
        System.out.println(list.toString());
        list.listSort();
        System.out.println(list.toString());

        IntList list2 = new IntArrayList();
        long timeAdding = System.currentTimeMillis();
        for (int i = 0; i < MAX_INDEX; i++) {
            list2.add(RANDOM.nextInt(MAX_VALUE));
        }
        timeAdding = System.currentTimeMillis() - timeAdding;
        System.out.println("Time of adding " + MAX_INDEX + " elements in InArrayList is " + timeAdding / 1000.0 + " s");

        System.out.println(list.get(0));
        list.add(5, 555);
        System.out.println(list.toString());
        list.removeByValue(555);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.set(2, 555);
        System.out.println(list.toString());
        System.out.println(list.size());
        System.out.println(list.subList(1, 5).toString());
        int[] someArr = list.toArray();
        System.out.println(Arrays.toString(someArr));
        list.clear();
        System.out.println(list.toString());
        System.out.println(list.isEmpty());

    }
}
