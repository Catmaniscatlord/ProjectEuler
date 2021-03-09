package problem_31;

public class Problem31 {
    public static void main(String[] args) {
        int limit = 200;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};  
        
        System.out.println( count(coins, limit));
    }   

    public static int count(int[] coins,int limit) {
        int[] table = new int[ limit + 1];
        
        //base case
        table[0] = 1;

        for (int n : coins) {
            for (int i = n; i <= limit; i++) {
                table[i] += table[i - n];
            }
        }
        return table[limit];
    }
}
