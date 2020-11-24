package Lab8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Problem1 {
    public static void main(String[] args) {
        int [][] matrix = new int[5][20];
        Random random = new Random();
        int max = 200;
        int min = 20;
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 20 ; j++){
                int num = (random.nextInt((max - min) + 1) + min)*2;
                matrix[i][j]=num;
            }
        }
        //TASK1
        for(int i = 0 ; i < 5 ;i++){
            if(i%2!=0){
                Arrays.sort(matrix[i]);
            } else {
                Arrays.sort(new int[][]{matrix[i]}, Collections.reverseOrder());
            }
        }

        printingArrays(matrix);
        printingUniqueElements(matrix);
    }

    private static void printingUniqueElements(int[][] matrix) {
        boolean visited[][] = new boolean[5][20];
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 20 ;j++){
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < 5; i++) {
            for(int j = 0 ; j < 20 ; j++){
                if (visited[i][j])
                    break;
                int count = 1;
                for (int i1 = i + 1; i1 < 5; i1++) {
                    for(int j1 = j +1 ; j1 < 20 ; j1++){
                        if (matrix[i][j] == matrix[i1][j1]) {
                            visited[i1][j1] = true;
                            count++;
                        }
                    }
                }
                System.out.println(matrix[i][j] + " Occurs " + count + " Time(s) In A Matrix");
            }
        }
    }

    private static void printingArrays(int[][] matrix) {
        for(int i = 0 ; i < 5 ; i ++){
            int k = i+1;
            System.out.println("START OF ROW -> " + k);
            for(int j = 0 ; j < 20 ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
            System.out.println("END OF ROW -> " + k + "\n");
        }
    }
}