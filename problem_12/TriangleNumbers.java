package problem_12;

public class TriangleNumbers {
    public static void main(String[] args) {
        TriangleNumbers kevin = new TriangleNumbers();

        int numDivisors = 0;


        int sqrt;
        while (true) {
            sqrt = (int) Math.sqrt(kevin.getCurrentTriangle());
            if(sqrt >= 250) {
                for (int i = 1; i < sqrt; i++) {
                    if(kevin.getCurrentTriangle() % i == 0) {
                        numDivisors += 2;
                    }
                }
                if(kevin.getCurrentTriangle() % sqrt == 0) {
                    numDivisors += 1;
                }
                if(numDivisors > 500) {
                    break;
                } else {
                    numDivisors = 0;
                }
            }
            kevin.calculateNextTriangle();
        }

        System.out.println(kevin.getCurrentTriangle());

    }

    long currentTriangle;
    int numTriangle;

    public TriangleNumbers () {
        currentTriangle = 1;
        numTriangle = 1;
    }

    public void calculateNextTriangle() {
        numTriangle += 1;
        if(currentTriangle > currentTriangle + numTriangle) {
            System.out.println(" :( ");
        }
        currentTriangle += numTriangle;
    }

    public long getCurrentTriangle() {
        return currentTriangle;
    }
}
 