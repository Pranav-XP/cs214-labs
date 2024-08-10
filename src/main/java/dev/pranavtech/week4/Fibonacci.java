package dev.pranavtech.week4;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibIter(5));
        System.out.println(fibRec(5));
    }

    public static long fibRec(long n){
        if(n<=1){
            return n;
        }else {
            return fibRec(n-1) + fibRec(n-2);
        }
    }

    public static long fibIter(long n){
        if(n<=1){
            return n;
        }
        long fib =  1;
        long prevFib = 1;

        for(int i = 2; i < n; i++){
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
}
