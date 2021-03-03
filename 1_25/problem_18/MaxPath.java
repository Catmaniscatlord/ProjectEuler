package problem_18;

public class MaxPath {
    public static void main(String[] args) {
        MaxPath kevin = new MaxPath();
        System.out.println(kevin.method2());
        System.out.println(kevin.method1());
    }
    
    private int[][] triangle = {
        {75},
        {95,64},
        {17,47,82},
        {18,35,87,10},
        {20, 4,82,47,65},
        {19, 1,23,75, 3,34},
        {88, 2,77,73, 7,63,67},
        {99,65, 4,28, 6,16,70,92},
        {41,41,26,56,83,40,80,70,33},
        {41,48,72,33,47,32,37,16,94,29},
        {53,71,44,65,25,43,91,52,97,51,14},
        {70,11,33,28,77,73,17,78,39,68,17,57},
        {91,71,52,38,17,14,91,43,58,50,27,29,48},
        {63,66, 4,68,89,53,67,30,73,16,69,87,40,31},
        { 4,62,98,27,23, 9,70,98,73,93,38,53,60, 4,23},
    };

    //breadth first
    public int method1() {
        for (int i = triangle.length - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++)
				triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
		}
		return triangle[0][0];
    }


    //depth first (wont work)
    public int method2() {
        int leftSum = 0;
        int rightSum = 0;
        int lOffset = 0;
        int rOffset = 0;
        int total = triangle[0][0];
        for (int i = 0; i < triangle.length - 1; i++) {
            if(leftSum > 0) {
                leftSum -= triangle[i + 1][lOffset];
                for (int j = i + 1; j < triangle.length; j++) {
                    rightSum += triangle[j][j - rOffset];                
                }
            } else if(rightSum > 0) {
                rightSum -= triangle[i + 1][i + 1 - rOffset];
                for (int j = i + 1; j < triangle.length; j++) {
                    leftSum += triangle[j][lOffset];
                }
            } else {
                for (int j = i + 1; j < triangle.length; j++) {
                    leftSum += triangle[j][lOffset];
                    rightSum += triangle[j][j - rOffset];                
                }
            }

            if(leftSum >= rightSum) {
                total += triangle[i + 1][lOffset];
                rightSum = 0;
                rOffset++;
            } else {
                total += triangle[i + 1][i + 1 - rOffset];
                leftSum = 0;
                lOffset++;
            }
        }
        return total;
    }

    
}
