package problem_30;

public class Problem30 {
    public static void main(String[] args) {
        
        int[] fifthPowers = new int[10];
        for (int i = 0; i < fifthPowers.length; i++) {
            fifthPowers[i] = (int) Math.pow(i, 5);
        } 
        
        int total = 0;
        int sum = 0;
        String num;


        // the upper bound was found by finding the point at which the multiple was equal  to the number of digits
        // the lower bound is set to 2 because the problem ignores 1 as a potential answer
        for (int i = 2; i < 6 * fifthPowers[9]; i++) {
            sum = 0;
            num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                sum += fifthPowers[Integer.parseInt(num.substring(j, j+1))];
            }

            if(i == sum) {
                System.out.println(i);
                total += i;
            }
        }
        System.out.println(total);
    }
}
