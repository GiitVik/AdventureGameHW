package org.example.Utils;

import java.util.Random;

public class Helper {
    Random random = new Random();
    private int min;
    private int max;
    private int randomRange;

    public int generateRandomNumber(){
        min = 1;
        max = 100;
        randomRange = random.nextInt((max - min) + 1) + min;
        return randomRange;
    }
}
