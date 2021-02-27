package problem_25;

import java.math.BigInteger;

public class Problem25 {
    public static void main(String[] args) {
        int index = 2;
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        BigInteger c;
        while( a.toString().length() < 10000 && b.toString().length() < 10000) {
            c = a.add(b);
            b = a;
            a = c;
            index ++;
        }

        System.out.println(a);
        System.out.println(index);

        /* This can be solved uaing math, and the fact that the nth Fibonacci number
         * approaches phi^n , where n is the nth Fibbonacci number
         *  
         */

    }
}
