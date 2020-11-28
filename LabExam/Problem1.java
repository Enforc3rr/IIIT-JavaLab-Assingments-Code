package LabExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Problem1 {
    public static void main(String[] args) {
        Random random = new Random();
        int max = 500;
        int min = 100;

        random.setSeed(10128);
        int [] array = new int[3000];
        int [] array1 = new int[1000];
        int [] array2 = new int[1000];
        int [] array3 = new int[1000];

        for(int i = 0 ; i < 3000 ; i++){
            array[i] = (random.nextInt((max - min) + 1) + min)*2;
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 1000 ; i++){
                    array1[i] = array[i];
                }
                Arrays.sort(array1);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1000 ; i < 2000 ; i++){
                    array2[i-1000] = array[i];
                }
                Arrays.sort(new int[][]{array2}, Collections.reverseOrder());
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 2000 ; i < 3000 ; i++){
                    array3[i-2000] = array[i];
                }
                Arrays.sort(array3);
            }
        });

        thread1.run();
        thread2.run();
        thread3.run();

       printArray(mergeInIncreasingOrder(array1 , array2 , array3));

    }

    private static int [] mergeInIncreasingOrder(int[] array1, int[] array2, int[] array3) {
        int [] mergedArray = new int[3000];
        for(int i = 0 ; i < 1000 ; i ++){
            mergedArray[i] = array1[i];
        }
        for(int i = 0 ; i < 1000 ; i ++){
            mergedArray[i+1000] = array2[i];
        }
        for(int i = 0 ; i < 1000 ; i ++){
            mergedArray[i+2000] = array3[i];
        }

         Arrays.sort(mergedArray);
        return mergedArray;
    }

    private static void printArray(int [] array){
        for(int i = 0 ; i < 3000 ; i++){
            System.out.println(array[i]);
        }
    }
}
