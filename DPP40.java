import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array of integers where every integer occurs three times except for one integer, 
 * which only occurs once, find and return the non-duplicated integer.
 * For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
 * Do this in O(N) time and O(1) space.
 */
public class DPP40{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            String[] str = bufferedReader.readLine().trim().split("\\s+");
            int[] array = new int[str.length];
            int index = 0;
            for(String s : str){
                array[index++] = Integer.parseInt(s);
            }
            int _out = process(array);
            System.out.println(_out);
        }
    }

    static int process(int[] array){
        //Here Some Steps 
        int ones = 0;
        int twoes = 0;
        int thrice = 0;
        for(int x : array){
            twoes |= ones & x; //add it to twos if it exists in ones
            ones = ones ^ x; //if it exists in ones, remove it, otherwise, add it
            thrice = ~(ones & twoes);
            ones = ones & thrice;
            twoes = twoes & thrice;
        }

        System.out.println(twoes);
        return ones;
    }
}