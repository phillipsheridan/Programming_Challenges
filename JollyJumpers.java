
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phillip
 */

//Starting with one test case for brevity
public class JollyJumpers {
    int n;  //n is the number of inputs
    HashMap<Integer, Integer> map; //map for checking if jolly
    String[] line;  //Each input line
    ArrayList<Integer> differences;     //array list of the calculated absolute differences
    public static void main(String[] args) {
        JollyJumpers j = new JollyJumpers();
        j.init();
    }
    public void init() {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
        line = input.nextLine().split(" ");
        n = Integer.parseInt(line[0]);
        if (n <= 0) {
            System.out.println("Not Jolly");
        }
        differences = new ArrayList<>();  
        map = new HashMap<>();
        for (int i = 1; i < n; i++) {  // update map to contain 1 to n-1 and set values to 0
            map.put(i, 0);
            }
        
        if (line.length == 2) { //single digit, has to be jolly
            System.out.println("Jolly");
            continue;
            
        }
        
        for (int i = 1; i < n; i++) {
            int num1 = Integer.parseInt(line[i]);
            int num2 = Integer.parseInt(line[i+1]);
            int diff = Math.abs(num1 - num2);
            differences.add(diff);
            
        }
        // now check the map for each key, set value to 1 if it contains key
        for (int e: differences) {
            if (map.containsKey(e)) {
                map.put(e, 1);
            }
        }
        
        //now just need to add up all values to check if it equals n-1
        int sum = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
        }
        
        if (sum == n-1) {
            System.out.println("Jolly");
        } else {
            System.out.println("Not jolly");
        }
        
        
        
        }
    }
}
