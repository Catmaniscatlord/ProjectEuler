package problem_14;

import java.util.HashMap;

public class Collatz {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Collatz kevin = new Collatz();
        int max = 0;
        int maxInt = 0;
        int chainLength = 0;
        for (int i = 1; i < 1000000; i++) {
            chainLength = kevin.calculateChain(i);
            if(chainLength > max) {
                maxInt = i;
                max = chainLength;
            }
        }
        System.out.println(System.currentTimeMillis() - time);
        System.out.println(chainLength);
        System.out.println(maxInt);

    }

    HashMap<Long,Integer> intChain = new HashMap<Long,Integer>();

    public Collatz() {
        intChain.put((long) 1, 1);
    }

    public int lengthOfChain(int e) {
        return calculateChain(e);
    }

    private int calculateChain(long e) {
        if(intChain.containsKey((long) e)) {
           return intChain.get((long) e); 
        }

        if(e % 2 == 0) {
            e /= 2;
        } else {
            e = 3 * e + 1;
        }
        
        int chainLength = calculateChain(e) + 1;
        intChain.put((long) e, chainLength);

        return chainLength;
    }
}
