package problem_17;

import java.util.HashMap;

public class NumberLetterCount {
    public static void main(String[] args)  {
        NumberLetterCount kevin = new NumberLetterCount();
        int letterCount = 0;
        for (int i = 1; i <= 1000; i++) {
            letterCount += kevin.intToString(i).length();
        } 

        System.out.println(letterCount);

    }


    private String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                              "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    public String intToString(int n) {
        String number = "";
        int num = n;

        if(num >= 1000 && num < 10000) {
            number += ones[num/1000] + "thousand";
            num %= 1000;
        }

        if(num >= 100 && num < 1000) {
            number += ones[num/100] + "hundred";
            num %= 100;
            if(num != 0) {
                number += "and";
            } else {
                return number;
            }
        }
        
        if(num < 20) {
            number += ones[num];
            return number;
        }

        if(num >= 20 && num < 100) {
            number += tens[num/10] + ones[num % 10];
        } 


        return number;
    }
}
