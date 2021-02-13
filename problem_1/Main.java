package problem_1;

public class Main {
    static int LIMIT=1000;
    
    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i <= (LIMIT - 1)/3; i++) {
            total += 3 * i;
        }
        for (int i = 1; i <= (LIMIT - 1)/5; i++) {
            if(i%3 != 0) {
                total += 5 * i;
            }
        }
        System.out.println(total);
    }
}
