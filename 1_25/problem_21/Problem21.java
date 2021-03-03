package problem_21;

import java.util.HashMap;

public class Problem21 {
    
    public static int MAX = 10000;
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Problem21 kevin = new Problem21();
        
        int amicableSum = 0;

        for (int i = 1; i < MAX; i++) {
            kevin.generateChain(i);
            int pointsTo = kevin.amicableLinks.get(i);
            
            if(kevin.amicableLinks.containsKey(pointsTo)) {
                if(i == kevin.amicableLinks.get(pointsTo) && i != pointsTo) {
                    amicableSum += i;
                }
            }    
        }
        System.out.println(System.currentTimeMillis() - time);
        System.out.println(amicableSum);
    }
    
    public HashMap<Integer,Integer> amicableLinks = new HashMap<Integer,Integer>();
    
    public PrimeFactors factors = new PrimeFactors(1);
    
    public Problem21() {
        amicableLinks.put(0, 0);
    }

    public int generateChain(int n) {
        if(amicableLinks.containsKey(n)) {
            return 0;
        } else {
            int factorSum = factors.sumOfFactors(n);
            amicableLinks.put(n, factorSum);
            if(factorSum < MAX)
                generateChain(factorSum);
        }
        return 0;
    }

}
