package problem_15;

import java.util.ArrayList;

public class Primes {
 
    private ArrayList<Integer> primes;

    private int primesGenerated;
    
    public Primes () {
        primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        primesGenerated = 2;
    }

    public void generatePrimes(int numPrimes) {
        while(primesGenerated < numPrimes) {
            generateNextPrime();
        }
    }

    public void generatePrimesToNum(int limit) {
        while(getLastPrime() < limit) {
            generateNextPrime();
        }
    }

    public void generateNextPrime() {
        int num = getLastPrime() + 2;

        while (!isPrime(num)) {
            num += 2;
        }
        primes.add(num);
        
        primesGenerated += 1;
    }

    private boolean isPrime(int n) {
        for (int i = 1; i < primes.size(); i++) {
            if(primes.get(i) <= Math.sqrt(n)){
                if(n % primes.get(i) == 0)
                    return false;
            } else {
                break;
            }
        }
        return true;
    }

    public int getLastPrime() {
        return primes.get(primes.size() - 1);
    }

    public int getPrime(int index) {
        return primes.get(index);
    }

    public int getPrimesGenerated() {
        return primesGenerated;
    }

    public ArrayList<Integer> getPrimes() {
        return primes;
    }
}
