package org.example.lab2.strategy;

import java.util.Arrays;

public class SortContext {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] array) {
        if (strategy != null) {
            strategy.sort(array);
            System.out.println("array = " + Arrays.toString(array));
        }
    }
}