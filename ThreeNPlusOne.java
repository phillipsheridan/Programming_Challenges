
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ThreeNPlusOne {
    Scanner input;
    long start; //first input
    long end; //second input
    boolean switched; //Is second input greater than first?
    ArrayList<String> lines;
    HashMap<Long, Long> memo; //holds the current number of cycles for each number
    
    public static void main(String[] args) {
        ThreeNPlusOne a = new ThreeNPlusOne();
        a.start();
        
    }
    void start() {
        memo = new HashMap<>();
        input = new Scanner(System.in);
        while(input.hasNextLine()) {
            switched = false;
        String[] line = input.nextLine().split(" ");
        start = Integer.parseInt(line[0]);
        end = Integer.parseInt(line[1]);
        if (end < start) {
            switched = true;
            long temp = start;
            start = end;
            end = temp;
            
        }
        // load the memo
        for (long i = start; i <= end; i++) {
            memo.put(i, 0L);
        }
        
        doCycle();
        
        long max = memo.get(start);
        
        for (long i = start + 1; i <= end; i++) {
            if (memo.get(i) > max) {
                max = memo.get(i);
            }
        }
        if (switched) {
        System.out.println(end + " " + start + " " + (max + 1));
        } else {
            System.out.println(start + " " + end + " " + (max + 1));
        }
        }
        
    }
//iterate this to get cycle length
    long cycle(long k) {
        
        if (k % 2 == 0) {
            return (k / 2);
        }
        return 3 * k + 1;
    }
    
    void doCycle() {
        for (long i = start; i <= end; i++) {
            long number = i;
            if (number == 1) {
                memo.put(number, 3L);
                continue;
            }
            
            while (number != 1) {
                number = cycle(number);
                memo.put(i, (memo.get(i) + 1)); //check if we need this
                if (memo.containsKey(number) && memo.get(number) > 0 && number != 1) {
                    memo.put(i, memo.get(i) + memo.get(number));
                    break;
                }
               
            }
            
        }
    }

}
