package org.example.lab2.strategy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void sort_shouldSortArrayAscendingTest() {
        // given
        int[] array = {5, 1, 4, 2, 8};
        int[] expected = {1, 2, 4, 5, 8};
        BubbleSort sorter = new BubbleSort();

        // when
        sorter.sort(array);

        // then
        assertArrayEquals(expected, array);
    }

    @Test
    void sort_shouldHandleEmptyArrayTest() {
        // given
        int[] array = {};
        BubbleSort sorter = new BubbleSort();

        // when
        sorter.sort(array);

        // then
        assertArrayEquals(new int[]{}, array);
        assertTrue(out.toString().contains("Sorting using Bubble Sort"));
    }

    @Test
    void sort_shouldHandleAlreadySortedArrayTest() {
        // given
        int[] array = {1, 2, 3, 4, 5};
        int[] copyBefore = Arrays.copyOf(array, array.length);
        BubbleSort sorter = new BubbleSort();

        // when
        sorter.sort(array);

        // then
        assertArrayEquals(copyBefore, array, "Already sorted array should remain unchanged");
    }

    @Test
    void sort_shouldHandleArrayWithDuplicatesTest() {
        // given
        int[] array = {3, 2, 1, 2};
        int[] expected = {1, 2, 2, 3};
        BubbleSort sorter = new BubbleSort();

        // when
        sorter.sort(array);

        // then
        assertArrayEquals(expected, array);
    }

    @Test
    void getName_shouldReturnExpectedAlgorithmNameTest() {
        // given
        BubbleSort sorter = new BubbleSort();

        // when
        String name = sorter.getName();

        // then
        assertEquals("Bubble Sort", name);
    }
}
