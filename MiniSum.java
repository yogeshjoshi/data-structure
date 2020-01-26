import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array of digits (values are from 0 to 9), 
 * find the minimum possible sum of two numbers formed from digits of the array. 
 * All digits of given array must be used to form the two numbers.
 * Input: [6, 8, 4, 5, 2, 3]
 * Output: 604
 * The minimum sum is formed by numbers 
 * 358 and 246
 */
public class MiniSum{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            String[] str = bufferedReader.readLine().trim().split("\\s+");
            int length = str.length;
            int[] array = new int[length];
            int index = 0;
            for(String s : str){
                array[index++] = Integer.parseInt(s);
            }

            int _out = process(array);
            System.out.println(_out);
        }
    }

    static int process(int[] array){

        return 0;
    }
}