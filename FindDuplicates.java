import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Problem statement - Find Duplicates in Array : Positive Numbers only 
 * In Linear time and constant space.
 * Max element should be greater than or equal to size of array
 */
public class FindDuplicates{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase > 0){
            int number = Integer.parseInt(bufferedReader.readLine().trim());
            String[] input = bufferedReader.readLine().split("\\s+");
            int[] array = new int[number];
            for(int i =0;i<number;i++){
                array[i] = Integer.parseInt(input[i].trim());
            }
            ArrayList<Integer> _out = process(number,array);
            for(Integer entry : _out){
                System.out.print(entry + " ");
            }
            testCase--;
        }
    }
    /**
     * Only For positive numbers (>0) will work this solution
     * If Max Element of Input Array is x than, question must satisfy the equation x >= n
     * @param n
     * @param array
     * @return
     */
    static ArrayList<Integer> process(int n, int[] array){
        ArrayList<Integer> answer  = new ArrayList<>();
        for(int i = 0 ; i<n;i++){
            if(array[Math.abs(array[i])] >= 0){
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
                //System.out.println(array[i]);
            }else{
                answer.add(Math.abs(array[i]));
            }
        }
        return answer;
    }
}