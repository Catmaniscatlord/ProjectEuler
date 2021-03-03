package problem_27;

import java.util.Arrays;

public class problem_27 {
    public static void main(String[] args) {
        Primes p = new Primes();
        p.generatePrimesToNum(1000);

        Integer[] primes = p.getPrimes().toArray(new Integer[p.getPrimes().size()]);
    
        int maxA = 0; 
        int maxB = 0;
        int maxN = 0;

        int n = 0;
        int x; // this store the result of n^2 + ab + b


        for (int i = 0 ; i < primes.length - 1; i++) {
            for (int j = -999; j < 1000; j += 2) {
                n = 0;
                while(true) {
                    x = (n*n) + (j * n) + primes[i];
                    p.generatePrimesToNum(x);
                    if(p.getPrimes().contains(x)) {
                        n++;
                    }
                    else {
                        break;
                    }
                }
                if(n >= maxN) {
                    maxA = j;
                    maxB = primes[i];
                    maxN = n;
                }
            }
        }

        System.out.println(maxA + " " + maxB + " " +  maxN);
        System.out.println(maxA * maxB);
    }
}
