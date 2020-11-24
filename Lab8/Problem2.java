package Lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Problem2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        ArrayList<Integer> arrayList4 = new ArrayList<>();
        ArrayList<Integer> arrayList5 = new ArrayList<>();
        Random random = new Random();
        int max = 500 ;
        int min = 0;
        random.setSeed(10128);
        int [] matrix = new int[10000];
        for(int i = 0 ; i < 10000 ; i++){
            matrix[i] = (random.nextInt((max - min) + 1) + min)*2;
        }
        Runnable thread1 = new Runnable() {
            @Override
            public void run() {
                for(int number : matrix){
                    if(number<=2000){
                        arrayList1.add(number);
                    }
                }
                Collections.sort(arrayList1);
            }
        };
        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                for(int number : matrix){
                    if(number>2000 && number <= 4000){
                        arrayList2.add(number);
                    }
                }
                Collections.sort(arrayList2);
            }
        };
        Runnable thread3 = new Runnable() {
            @Override
            public void run() {
                for(int number : matrix){
                    if(number>4000 && number <= 6000){
                        arrayList3.add(number);
                    }
                }
                Collections.sort(arrayList3);
            }
        };
        Runnable thread4 = new Runnable() {
            @Override
            public void run() {
                for(int number : matrix){
                    if(number>6000 && number <= 8000){
                        arrayList4.add(number);
                    }
                }
                Collections.sort(arrayList4);
            }
        };
        Runnable thread5 = new Runnable() {
            @Override
            public void run() {
                for(int number : matrix){
                    if(number>8000 && number <= 10000){
                        arrayList5.add(number);
                    }
                }
                Collections.sort(arrayList5);
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


        thread1.run();
        thread2.run();
        thread3.run();
        thread4.run();
        thread5.run();

        ArrayList<Integer> combinedList = new ArrayList<>();
        combinedList.addAll(arrayList1);
        combinedList.addAll(arrayList2);
        combinedList.addAll(arrayList3);
        combinedList.addAll(arrayList4);
        combinedList.addAll(arrayList5);

        for(Integer i : combinedList){
            System.out.println(i);
        }
    }
}
