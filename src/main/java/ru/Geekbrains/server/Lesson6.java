package ru.Geekbrains.server;

public class Lesson6 {

    public int[] findLastNumberFour(int[] arr) throws RuntimeException {
        if (arr.length == 0)
            throw new RuntimeException("Empty array");
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == 4) {
                if (i == arr.length - 1) return new int[]{};
                int[] result = new int[arr.length - i - 1];
                System.arraycopy(arr, i + 1, result, 0, arr.length - i - 1);
                return result;
            }
        }
        throw new RuntimeException("The array does not contain number 4.");
    }

    public boolean checkOneAndFour(int[] arr) {
        for (int i : arr) {
            if (i == 1 || i == 4) return true;
        }
        return false;
    }
}
