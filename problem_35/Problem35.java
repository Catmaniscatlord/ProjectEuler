package problem_35;

import java.util.ArrayList;

public class Problem35 {
    public static void main(String[] args) {
        Primes primes = new Primes();
        primes.generatePrimesToNum(1000000);
        ArrayList<Integer> p = primes.getPrimes();
        
        int numCircularPrimes = p.size();

        String num;
        int rotation;
        for (Integer i : p) {
            num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                rotation = Integer.parseInt(num.substring(j) + num.substring(0, j));
                if(!p.contains(rotation)) {
                    numCircularPrimes --;
                    break;
                }
            }
        }
        System.out.println(numCircularPrimes);
    }

}
