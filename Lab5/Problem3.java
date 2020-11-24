package Lab5;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max  = 50 ;
        int min = 5 ;
        int [] triangleArrayList = new int[20];
        int [] triangleArea = new int[20];
        Random random = new Random();
        ArrayList [] vertex = new ArrayList[20];
        for(int i = 0 ; i < 20 ; i++){
            vertex[i] = new ArrayList();
        }
        for(int i = 0 ; i < 20 ; i++){
            int number = random.nextInt((max - min) + 1) + min;
            vertex[i].add(0,number);
            number = random.nextInt((max - min) + 1) + min;
            vertex[i].add(1,number);
            number = random.nextInt((max - min) + 1) + min;
            vertex[i].add(2,number);
        }
        triangleArea = areaOfTriangle(vertex);
        triangleInside(vertex);
        overlappingTriangle(vertex);
    }
    public static int [] areaOfTriangle(ArrayList [] vertex ){
        int [] triangleArea = new int[20];
        for(int i = 0 ; i < 20 ; i++){
            triangleArea[i] = ((int)vertex[i].get(0)*(int)vertex[i].get(1))/2;
        }
        return triangleArea;
    }
    public static void triangleInside(ArrayList [] vertex){
        for(int i = 0 ; i < 20 ; i++){
            if((int)vertex[i].get(0)<=40&&(int)vertex[i].get(0)>=10){
                if((int)vertex[i].get(1)<=40&&(int)vertex[i].get(1)>=10){
                    if((int)vertex[i].get(2)<=40&&(int)vertex[i].get(2)>=10){
                        System.out.println("vertices of Traingle Inside[10,40] are " + vertex[i].get(0).toString() + " " + vertex[i].get(1).toString() + " " + vertex[i].get(2).toString());
                    }
                }
            }
        }
    }
    public  static  void overlappingTriangle(ArrayList [] vertex){
        for(int i = 0 ; i < 19 ; i++){
            for(int j = i+1 ; j < 20 ; j++){
                if ((int)vertex[i].get(0)==(int)vertex[j].get(0)||(int)vertex[i].get(0)==(int)vertex[j].get(1)||(int)vertex[i].get(0)==(int)vertex[j].get(2)) {
                    if ((int)vertex[i].get(1)==(int)vertex[j].get(0)||(int)vertex[i].get(1)==(int)vertex[j].get(1)||(int)vertex[i].get(1)==(int)vertex[j].get(2)){
                        if ((int)vertex[i].get(2)==(int)vertex[j].get(0)||(int)vertex[i].get(2)==(int)vertex[j].get(1)||(int)vertex[i].get(2)==(int)vertex[j].get(2)){
                            System.out.println("vertices of overlapping triangle are -> " + vertex[i].get(0) + " " + vertex[i].get(1) + " " + vertex[i].get(2) );
                        }
                    }
                }
            }
        }
    }

}
