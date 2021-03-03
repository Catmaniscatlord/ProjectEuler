package problem_29;

import java.util.HashSet;
import java.util.Set;

public class Problem29 {
    static int b = 1000; // the limit of the calculations
    public static void main(String[] args) {

        Set<Double> powers = new HashSet<Double>();
        for (int i = 2; i <= b; i++) {
            for (int j = 2; j <= b; j++) {
                powers.add(Math.pow(i, j));
            }
        }
        System.out.println(powers.size());
    }
    
}
