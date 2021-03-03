package problem_16;


import java.math.BigInteger;
import java.util.ArrayList;

public class Problem15 {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("2");
        int power = 1000;
        long time = System.currentTimeMillis();
        Problem15 kevin = new Problem15(power);
        
        for(int i = 0; i < kevin.getPrimes().size(); i++) {
            for (int j = 0; j < kevin.getPrimesMultiplier().get(i); j++) {
                b = b.pow(kevin.getPrimes().get(i));
            }
        }

        // b = b.pow(power);

        System.out.println((System.currentTimeMillis() - time));
        //System.out.println(b);

        String numString = b.toString();
        int sum = 0;
        for (int i = 0; i < numString.length(); i++) {
            sum += Integer.parseInt(numString.substring(i, i + 1));
        }
        System.out.println(sum);
    }

    private Primes primes;
    private int limit;
    private ArrayList<Integer> primesMultiplier;

    public Problem15(int limit){
        this.primes = new Primes();
        this.limit = limit;
        calculatePrimeMultiplier();
    }

    public void calculatePrimeMultiplier() {
        int multiplier = 0;
        primesMultiplier = new ArrayList<Integer>();
        
        primes.generatePrimesToNum(limit);

        for (int i = 0; i < primes.getPrimes().size(); i++) {
            while(true) {
                if(limit % primes.getPrime(i) == 0) {
                    multiplier++;
                    limit /= primes.getPrime(i);
                } else {
                    break;
                }
            }

            primesMultiplier.add(multiplier);
            multiplier = 0;
        }
    }

    public ArrayList<Integer> getPrimesMultiplier() {
        return primesMultiplier;
    }

    public ArrayList<Integer> getPrimes() {
        return primes.getPrimes();
    }   
}
