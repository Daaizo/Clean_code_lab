package org.example.lab2.strategy;

public class BubbleSort implements SortStrategy {

    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
