package problem_10;

import problem_10.Primes;

public class PrimeSum {
    public static void main(String[] args) {
        Primes kevin = new Primes();
        long sum = 0;
        
        while(kevin.getLastPrime() < 2000000) {
            kevin.generateNextPrime();
        }
        
        for (Integer i : kevin.getPrimes()) {
            sum += i;
        }
        // we generate 1 more prime than needed, so we must subtract it.
        sum -= kevin.getLastPrime();

        System.out.println(sum);
    }
}
