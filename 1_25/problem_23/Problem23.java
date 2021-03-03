package problem_23;

import java.util.ArrayList;

public class Problem23 {
    
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Problem23 kevin = new Problem23();
        
        long abundantSum = 0;

        boolean[] isASum = new boolean[28124];

        kevin.findAbundentNumbers();

        ArrayList<Integer> abundantNums = kevin.abundantNums;
        
        int sum;

        for (int i = 0; i < abundantNums.size(); i++) {
            for (int j = i; j < abundantNums.size(); j++) {
                sum = abundantNums.get(i) + abundantNums.get(j);
                if(sum < 28124)
                    isASum[sum] = true;
            }
        }

        for (int i = 0; i < isASum.length; i++) {
            if(!isASum[i])
                abundantSum += i;
        }


        System.out.println(System.currentTimeMillis() - time);
        
        System.out.println(abundantNums.size());
        System.out.println(abundantSum);
    }
     
    public PrimeFactors factors = new PrimeFactors(1);
    public ArrayList<Integer> abundantNums = new ArrayList<Integer>();
    
    public Problem23() {
    }

    public boolean isAbundent(int n) {
        return (factors.sumOfFactors(n) > n ? true : false);
    }

    public void findAbundentNumbers() {
        for (int i = 2; i < 28124; i++) {
            if(isAbundent(i))
                abundantNums.add(i);
        }
    }
}
 