package Lab4;

import java.util.Random;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Float [] A = new Float[n] ;
        for(int i =  0 ; i < n ; i++){
            A[i]=random.nextFloat();
        }
        displayArray(A,0,A.length-1);
        float sum = 0 ;
        for(int i =  0 ; i < A.length ; i++){
            sum = sum + A[i];
        }
        sum  = sum / A.length;
        pairConsecutiveNumbers(A , sum , 0 );
    }
    public static void  displayArray(Float [] A , int start , int end){
        if (start < end){
            System.out.println(A[start]);
            displayArray(A,start+1,end);
        }
    }
    public static void pairConsecutiveNumbers(Float [] A , float sum , int p ){
        if(p < A.length-1) {
            if(A[p]+A[p+1] <= sum){
                System.out.println(A[p] + " " + A[p+1] );
            }
            pairConsecutiveNumbers(A , sum , p+1);
        }
    }
}
