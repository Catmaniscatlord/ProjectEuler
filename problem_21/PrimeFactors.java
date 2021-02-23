package problem_21;

import java.math.BigInteger;
import java.util.ArrayList;

public class PrimeFactors {
    
    private Primes primes;
    private int limit;
    private ArrayList<Integer> primesMultiplier;

    public PrimeFactors() {
        this(1);
    }

    public PrimeFactors(int limit){
        this.primes = new Primes();
        this.limit = limit;
    }

    public void calculatePrimeMultiplier(int n) {
        int multiplier = 0;
        int maxFactor = (int) Math.sqrt(n);
        primesMultiplier = new ArrayList<Integer>();
     
        if(n > limit) {
            limit = n;
            primes.generatePrimesToNum(limit);
        }

        for (int i = 0; i < primes.getPrimesGenerated(); i++) {
            while(true) {
                if(n % primes.getPrime(i) == 0) {
                    multiplier++;
                    n /= primes.getPrime(i);
                } else {
                    break;
                }
            }

            primesMultiplier.add(multiplier);
            multiplier = 0;
        }
    }

    public ArrayList<Integer> getPrimesMultiplier(int n) {

        return primesMultiplier;
    }

    public ArrayList<Integer> getPrimes() {
        return primes.getPrimes();
    }

    public int sumOfFactors(int n) {
        int factorSum = 1;
        calculatePrimeMultiplier(n);
        for (int i = 0; i < primesMultiplier.size(); i++) {
            factorSum *= (1 - Math.pow(primes.getPrime(i), primesMultiplier.get(i) + 1))/(1 - primes.getPrime(i));
        }
        return factorSum - n;
    }
}
