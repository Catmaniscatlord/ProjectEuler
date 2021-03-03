package problem_4;

public class Main {
    
    static int MAX = 999;
    
    public static void main(String[] args) {
        Main e = new Main();

        System.out.println(e.findPalindrome());
    }


    public Main() {
        super();
    }

    public int findPalindrome() {
        int maxPalindrome = 0;
        for (int i = MAX; i > 0; i--) {
            for (int j = MAX; j >= i; j--) {
                if(isPalindrome(i * j)) {
                    if((i*j) >  maxPalindrome) {
                        maxPalindrome =  i * j;
                        System.out.println("[ " + i + " , " + j + " ]");
                    }
                }
            }
        }
        return maxPalindrome;
    }

    public boolean isPalindrome(int num) {
        int numReversed = 0;
        int originalNum = num;
        while( num != 0 ){
            numReversed = (numReversed * 10) + (num % 10);
            num  /= 10;
        }

        if(numReversed == originalNum) {
            return true;
        }
        return false; 
    }

}
