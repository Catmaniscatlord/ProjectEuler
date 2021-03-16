package problem_34;

public class Problem34 {

    public static int[] factorials = new int[10]; 
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        //this fills up the factorial array for fast access
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = factorials[i - 1] * i; 
        }


        // we start with 99 because numbers less than 10 aren't factorial sums
        System.out.println(curiousNumber(99, 0));  
        System.out.println(System.currentTimeMillis() - time);
    }

    public static int factorialSum(int n) {
        String nString = String.valueOf(n);
        int sum = 0;

        for (char c : nString.toCharArray()) {
            sum += factorials[c - '0'];
        }

        return sum;
    }

    public static int curiousNumber(int startingNumber, int sum) {
        // If the factorial sum is greater than a number of all 9's, we can go up by a power of ten.
        // as there still might be factorial sum numbers.
        if(factorialSum(startingNumber) > startingNumber) {
            // we multiply by 10 and add 9 so we can stay in the form of a number with only 9's
            sum += curiousNumber(startingNumber * 10 + 9, sum);
        }
        int factorialSum = 0;
        // if we have a lower bound less then startingNumber / 10 then
        // we will be checking numbers that have already been checked.
        for (int i = startingNumber; i > startingNumber / 10; i--) {
            factorialSum = factorialSum(i);
            if(factorialSum == i) {
                System.out.println(i);
                sum += i;
            }
        }

        return sum;
    }
}
