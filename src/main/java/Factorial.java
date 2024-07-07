package main.java;

public class Factorial {

    public static void main( String[] args )
    {
        System.out.println( "It's Main Method" );
    }

    public static long factorial(long n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
