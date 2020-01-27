import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given an array of non-negative integers that represents a two-dimensional elevation map 
 * where each element is unit-width wall and the integer is the height. 
 * Suppose it will rain and all spots between two walls get filled up.
 * 
 * Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
 * 
 * For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
 * Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, 
 * and 3 in the fourth index (we cannot hold 5 since it would run off to the left), 
 * so we can trap 8 units of water.
 */
public class DPP30{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        while(testCase-->0){
            String [] input = bufferedReader.readLine().trim().split("\\s+");
            int[] array = new int[input.length];
            int index = 0;
            for(String in:input){
                array[index++] = Integer.parseInt(in);
            }

            int _out = process(array);
            System.out.println(_out);
        }
    }

    static int process(int[] array){
        if(array.length==1)
            return 0;
        int len = array.length;
        int leftMax[] = new int[len];
        int rightMax[] = new int[len];
        int lMax = 0;
        int rMax = 0;
        for(int i=0;i<len;i++){
            leftMax[i] = lMax;
            if(array[i]>lMax)
                lMax=array[i];
        }
        for(int i=len-1;i>=0;i--){
            rightMax[i] = rMax;
            if(array[i]>rMax)
                rMax = array[i];
        }

        int sum = 0;
        for(int i=1;i<len-1;i++){
            if(leftMax[i]>rightMax[i] && rightMax[i]-array[i]>0)
                sum = sum + (rightMax[i]-array[i]);
            else if(leftMax[i]-array[i]>0)
                sum = sum + (leftMax[i]-array[i]);
        }
        return sum;
    }
}