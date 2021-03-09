package problem_32;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem32 {
    public static void main(String[] args) {
       String digits = "123456789";
    
       
       String tmp;
       
       Set<Integer> panDigitals = new HashSet<Integer>();
       int total = 0;

        char[] tmpArray;

       for (int i = 1; i < 10; i++) {
           for (int j = 1000; j < 10000 ; j++) {
                tmp = "";
                tmp += i;
                tmp += j;
                tmp += (i * j);
                if(tmp.length() == 9){
                    tmpArray = tmp.toCharArray();
                    Arrays.sort(tmpArray);                    
                    if(new String(tmpArray).equals(digits)) {
                        if(!panDigitals.contains(i * j)) {
                            panDigitals.add(i * j);
                            total += i * j;
                        }
                        System.out.println(i * j + " = " + i + " * " + j);
                    }
                } else if (tmp.length() > 9){
                    break;
                }
            }
        }

        for (int i = 10; i < 100; i++) {
            for (int j = 100; j < 1000 ; j++) {
                tmp = "";
                tmp += i;
                tmp += j;
                tmp += (i * j);
                if(tmp.length() == 9){
                    tmpArray = tmp.toCharArray();
                    Arrays.sort(tmpArray);
                    if(new String(tmpArray).equals(digits)) {
                        if(!panDigitals.contains(i * j)) {
                            panDigitals.add(i * j);
                            total += i * j;
                        }
                        System.out.println(i * j + " = " + i + " * " + j);
                    }
                } else if (tmp.length() > 9){
                    break;
                }
            }
        }
        System.out.println(total);

    }
}
