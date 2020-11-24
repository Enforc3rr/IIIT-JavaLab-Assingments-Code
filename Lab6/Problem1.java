package Lab6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Problem1 {
    public static void main(String[] args) {
        Random random = new Random();
        int max = 70 ;
        int min = 10;

        Circle circle = new Circle();
        Circle.Point point = circle.new Point();
        for(int i = 1 ; i<=10 ;i++){
            int x = random.nextInt((max - min) + 1) + min;
            int y = random.nextInt((max - min) + 1) + min;
            point.getPoint(x,y);
        }

        int [] randomNumber1 = new int[20];
        int max1 = 75;
        int min1 = 20;
        for(int i = 0 ; i < 20 ; i++){
            int num = (random.nextInt((max1 - min1) + 1) + min1)*2;
            randomNumber1[i] = num;
        }
        Factors factors = new Factors();
        factors.computePrimeFactors(10);
        System.out.println();
        System.out.println();
        System.out.println();
        factors.checkCommonFactors(randomNumber1);
    }

}
class Circle{
    class Point{
        int x;
        int y;
        public void getPoint(int x , int y){
            this.x = x;
            this.y = y;
            System.out.println(this.x + " " + this.y);
        }
    }
    float radius;
}


class Factors {
    public void computePrimeFactors(int k) {
        for (int l = 1; l <= k; l++) {
            int num = l ;
            boolean flag = false;
            for(int i = 2; i <= num/2; ++i)
            {
                if(num % i == 0)
                {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                primeFactors(num);
            }
        }
    }
    public void primeFactors(int i) {
        System.out.println("Prime Factor = " + i);
    }

    public int evenFactors(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

    public void checkCommonFactors(int[] num) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int l = 0; l < 20; l++) {
            int number = num[l];
            boolean flag = false;
            for (int i = 2; i <= number / 2; ++i) {
                if (number % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                hashSet.add(number);
            }
        }
        System.out.println("Common Prime Factors ->");
        List<Integer> list = new ArrayList<>(hashSet);
        for(int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i));
        }
    }
}