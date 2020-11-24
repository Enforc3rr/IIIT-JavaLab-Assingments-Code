package Lab8;

import java.util.Random;

public class Problem4 {
    public static void main(String[] args) {
        int max = 9 ;
        int min = 7 ;
        Random random = new Random();
        int k = (random.nextInt((max - min) + 1) + min)*2;
        int [][] matrix = new int[k][k];

       int check = numberOfPathInGrid(0,0,3,2,matrix,0);

       if(check == 0){
           System.out.println("Not Possible");
       }else{
           System.out.println(check);
       }
    }

    public static int numberOfPathInGrid(int initialPositionX , int initialPositionY , int finalPositionX
            , int finalPositionY , int [][] grid , int count) {
        if (initialPositionX <= finalPositionX && initialPositionY <= finalPositionY) {
            if (initialPositionX == finalPositionX && initialPositionY == finalPositionY)
                return count;
            else
                return numberOfPathInGrid(initialPositionX + 1, initialPositionY + 1, finalPositionX, finalPositionY
                        , grid, count + 1);
        }else {
            return 0;
        }
    }
}
