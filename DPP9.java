import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. 
 * Numbers can be 0 or negative.
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] 
 * should return 10, since we pick 5 and 5.
 */
public class DPP9{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            int number = Integer.parseInt(bufferedReader.readLine().trim());
            String input[] = bufferedReader.readLine().split("\\s+");
            int[] array = new int[number];
            int index = 0;
            for(String in: input){
                array[index++] = Integer.parseInt(in);
            }

            int _out = process(array);

            System.out.println(_out);
        }
    }

    static int process(int[] array){
        int sumIncludingIthStep = array[0];
        int sumExcludingIthStep = 0;

        for(int i = 1; i< array.length ; i++){
            int temp = sumIncludingIthStep;
            sumIncludingIthStep = array[i] + sumExcludingIthStep;
            // if(i==1 && temp<0)
            //     sumExcludingIthStep = Integer.MIN_VALUE;
            sumExcludingIthStep = Math.max(sumExcludingIthStep, temp);
        }
        return Math.max(sumExcludingIthStep, sumIncludingIthStep);
    }
}