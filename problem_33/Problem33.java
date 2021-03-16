package problem_33;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem33 {
    public static void main(String[] args) {
        Set<Integer[]> curiousFraction = new HashSet<>();
        int total = 0;

        int[] product = new int[] {1,1};
        
        double n;
        for (int i = 1; i < 10; i++) {
            for (int i2 = 1; i2 < 10; i2++) {
                for (int j = i; j < 10; j++) {
                    for (int j2 = 1; j2 < 10; j2++) {
                        if(i == j && i2 == j2) {
                            continue;
                        }
                        n = divideInts(i, i2, j, j2);
                        if(i == j &&  n== ((double) i2) / j2) {
                            curiousFraction.add(new Integer[] {i2,j2});
                            total ++;
                        } else if(i2 == j && n == ((double) i) / j2) {
                            curiousFraction.add(new Integer[] {i,j2});
                            total ++;
                        } else if(i == j2 && n == ((double) i2) / j) {
                            curiousFraction.add(new Integer[] {i2,j});
                            total ++;
                        } else if(i2 == j2 && n == ((double) i) / j) {
                            curiousFraction.add(new Integer[] {i,j});
                            total ++;
                        } 
                    }
                }
            }
        }
        System.out.println(divideInts(1, 7, 4, 9));
        System.out.println(total);

        for (Integer[] i : curiousFraction) {
            product[0] *= i[0];
            product[1] *= i[1];
        }

        System.out.println(Arrays.toString(product));

    }

    public static double divideInts(int num1, int num2, int den1, int den2) {
        return ((num1 * 10.0) + num2)/((den1 * 10.0) + den2); // 10.0 casts it to a double so we can do float division
    }
}
