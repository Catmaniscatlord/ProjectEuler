package problem_8;

public class Problem8 {
    public static void main(String[] args) {
        Problem8 kevin = new Problem8(13);

        kevin.calculateLargestProduct();
        System.out.println(kevin.getProduct());

    }

    private String digits;
    private long largestProduct;
    int numDigits;

    public Problem8 (int numDigits) {
        this.numDigits = numDigits;
        digits = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
       
    }

    /* returns the index of the first zero in the string if there is one
     * otherwise returns -1
     */
    private int productConatainsZero(int stringIndex) {
        String checkString = digits.substring(stringIndex, stringIndex + numDigits);
        return checkString.indexOf('0');
    }

    private long stringProduct(int stringIndex) {
        long product = 1;
        for (int i = 0; i < numDigits; i++) {
            product *= Integer.parseInt(digits.substring(i + stringIndex, i + stringIndex + 1));
        }
        
        return product;
    }

    public void calculateLargestProduct() {
        int indexOfZero = 0;
        for (int i = 0; i < digits.length() - numDigits + 1; i++) {
            indexOfZero = productConatainsZero(i);
            if(indexOfZero == -1) {
                if ((i != 0) && (i != digits.length() - numDigits + 1)) {
                    if(Integer.parseInt(String.valueOf(digits.charAt(i - 1))) < Integer.parseInt(String.valueOf(digits.charAt(i + numDigits - 1)))  ) {
                        if(stringProduct(i) > largestProduct) {
                            largestProduct = stringProduct(i);
                            System.out.println(digits.substring(i, i + numDigits));
                            System.out.println(largestProduct);
                        }
                    }
                }
            } else {
                i += indexOfZero;
            }
        }
    }

    public long getProduct() {
        return largestProduct;
    }
}
