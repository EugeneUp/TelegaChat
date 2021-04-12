package ru.Geekbrains.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson6Test {

    private Lesson6 tester;
    @Test
    void findLastNumberFourTest() {
        tester = new Lesson6();
        Assertions.assertArrayEquals(new int[]{1, 7}, tester.findLastNumberFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
        Assertions.assertArrayEquals(new int[]{2, 1, 9, 2, 3, 7, 1, 7}, tester.findLastNumberFour(new int[]{4, 2, 1, 9, 2, 3, 7, 1, 7}));
        Assertions.assertArrayEquals(new int[]{}, tester.findLastNumberFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 4}));
    }

    @Test
    void findLastNumberFourTestExc(){
        tester = new Lesson6();
        Assertions.assertThrows(
                RuntimeException.class,
                () -> tester.findLastNumberFour(new int[]{1, 2, 5, 3, 9, 6, 8, 7, 0}));
        Assertions.assertThrows(
                RuntimeException.class,
                () -> tester.findLastNumberFour(new int[]{}));
    }

    @Test
    void checkOneAndFourTest() {
        tester = new Lesson6();
        Assertions.assertTrue(tester.checkOneAndFour(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assertions.assertTrue(tester.checkOneAndFour(new int[]{1, 2, 3, 5, 6, 7, 8, 9}));
        Assertions.assertTrue(tester.checkOneAndFour(new int[]{2, 3, 4, 5, 6, 7, 8, 9}));
        Assertions.assertFalse(tester.checkOneAndFour(new int[]{2, 3, 5, 6, 7, 8, 9}));
        Assertions.assertFalse(tester.checkOneAndFour(new int[]{}));
    }
}