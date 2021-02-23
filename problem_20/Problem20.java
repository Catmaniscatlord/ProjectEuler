package problem_20;

import java.math.BigInteger;

public class Problem20 {
    public static void main(String[] args) {
        BigInteger n = Problem20.factorial(100);

        int nSum = 0;

        String nString = n.toString();
        for (int i = 0; i < nString.length(); i++) {
            nSum += Integer.parseInt(nString.substring(i, i + 1));
        } 
    
        System.out.println(nSum);
    }

    public static BigInteger factorial(int n) {
        BigInteger bigN = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            bigN = bigN.multiply(BigInteger.valueOf(i));
        }

        return bigN;
    }
}
