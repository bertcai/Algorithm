package SwordToOffer;

import java.util.ArrayList;

public class minNumRotate {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int length = array.length;
        int min = array[0];
        for (int i = 0; i < length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}