package com.volkodav4ik;

import java.util.Arrays;

public class IntArrayList implements IntList {


    private int size = 0;
    private int[] elementData = new int[10];

    public IntArrayList(int size, int[] elementData) {
        this.size = size;
        this.elementData = elementData;
    }

    public IntArrayList() {
    }

    @Override
    public int get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be in 0.." + size);
        }
        return elementData[index];
    }

    @Override
    public boolean add(int element) {
        if (elementData.length <= size + 1) {
            int[] tmpArray = new int[elementData.length * 3 / 2 + 1];
            System.arraycopy(elementData, 0, tmpArray, 0, size);
            elementData = tmpArray;
        }
        elementData[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, int element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be on range from 0 to " + size);
        }
        if (elementData.length <= size + 1) {
            int[] tmpArray = new int[elementData.length * 3 / 2 + 1];
            System.arraycopy(elementData, 0, tmpArray, 0, size);
            elementData = tmpArray;
        }
        int[] tmpArray = new int[elementData.length];
        System.arraycopy(elementData, 0, tmpArray, 0, index);
        tmpArray[index] = element;
        System.arraycopy(elementData, index, tmpArray, index + 1, size - index);
        elementData = tmpArray;
        size++;
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        elementData = new int[10];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be on range from 0 to " + (size - 1));
        }
        int[] tmpArr = new int[elementData.length];
        System.arraycopy(elementData, 0, tmpArr, 0, index);
        int nextElem = index + 1;
        System.arraycopy(elementData, nextElem, tmpArr, index, size - nextElem);
        elementData = tmpArr;
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        boolean b = false;
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == value) {
                int[] tmpArr = new int[elementData.length];
                System.arraycopy(elementData, 0, tmpArr, 0, i);
                int nextElem = i + 1;
                System.arraycopy(elementData, nextElem, tmpArr, i, size - nextElem);
                elementData = tmpArr;
                size--;
                b = true;
                break;
            }
        }
        if (!b) {
            System.out.println("Element " + value + " wasn't been found in data.");
        }
        return b;
    }

    @Override
    public boolean set(int index, int element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be on range from 0 to " + (size - 1));
        }
        elementData[index] = element;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if ((fromIndex < 0 || toIndex > size || fromIndex > toIndex)) {
            throw new IndexOutOfBoundsException("Index should be on range from 0 to " + (size - 1)
                    + "and start index can't equal or more than final index");
        }
        int elements = toIndex - fromIndex + 1;
        int[] tmpArr = new int[elements];
        int index = fromIndex;
        for (int i = 0; i < tmpArr.length; i++) {
            tmpArr[i] = elementData[index];
            index++;
        }
        return new IntArrayList(elements, tmpArr);
    }

    @Override
    public int[] toArray() {
        int[] tmpArr = new int[size];
        System.arraycopy(elementData, 0, tmpArr, 0, size);
        return tmpArr;
    }

    @Override
    public void listSort() {
        boolean isSorted;
        int[] tmpArr = new int[size];
        System.arraycopy(elementData, 0, tmpArr, 0, size);
        for (int i = 0; i < tmpArr.length; i++) {
            isSorted = true;
            for (int j = 1; j <= (tmpArr.length - 1); j++) {
                if (tmpArr[j - 1] > tmpArr[j]) {
                    swap(tmpArr, j - 1, j);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.arraycopy(tmpArr, 0, elementData, 0, size);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    @Override
    public String toString() {
        return "IntArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }
}
