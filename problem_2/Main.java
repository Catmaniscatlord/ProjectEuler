package problem_2;

import java.lang.reflect.Array;

public class Main {
    static int LIMIT = 4000000;
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;
        int sum = 0;

        while (c < LIMIT) {
            c = a + b;
            if(c % 2 == 0) {
                sum+=c;
            }
            a = b;
            b = c;
        }

        System.out.println("sum : " + sum);
    }
}