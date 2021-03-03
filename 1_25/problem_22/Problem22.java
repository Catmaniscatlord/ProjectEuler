package problem_22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem22 {
    
    public static void main(String[] args) {
        ArrayList<String> nameList =  new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("problem_22\\p022_names.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] names = line.replace("\"","").split(",");
                Collections.addAll(nameList, names);
            }
        } catch (Exception e) {
            System.out.println("e");
        }

        Collections.sort(nameList);

        String name = nameList.get(0);
        int total = 0;
        int nameValue = 0;
        for (int i = 0; i < nameList.size(); i++) {
            for (char c : (name = nameList.get(i)).toCharArray()) {
                nameValue += (int) c - 64;
            }
            total += nameValue * (i + 1);
            nameValue = 0;
        }

        System.out.println(total);
    }
}
