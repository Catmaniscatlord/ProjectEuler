package problem_26;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem26 {
    public static void main(String[] args) {
        
        ArrayList<Integer> remainderList = new ArrayList<Integer>();
    
        int[] cycleLength = new int[1001];

        int remainder;

        for (int i = 1; i < 1001; i++) {
            remainder = 1;
            while(true) {
                remainder *= 10;
                while(remainder < i) {
                    remainder *= 10;
                    remainderList.add(remainder);
                }
                remainder %= i;
                if(remainderList.contains(remainder)) {
                    cycleLength[i] = remainderList.size() - remainderList.indexOf(remainder);
                    break;
                } 
                if(remainder == 0) {
                    cycleLength[i] = 0;
                    break;
                }
                remainderList.add(remainder);
            }
            remainderList = new ArrayList<Integer>();
        }

        System.out.println(Arrays.toString(cycleLength));

        int maxCycleNum = 0;
        for (int i = 0; i < cycleLength.length; i++) {
            if(cycleLength[i] > cycleLength[maxCycleNum]) {
                maxCycleNum = i;
            }
        }
        System.out.println(maxCycleNum);
        System.out.println(cycleLength[maxCycleNum]);
    }    
}
