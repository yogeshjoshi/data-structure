import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement - Given array of integers, return a new array such that each element at index is the product of the all numbers in the orignal array except the one at i.
 *
 */
class DPP2{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase > 0){
            int number = Integer.parseInt(bufferedReader.readLine().trim());
            int[] array = new int[number];
            String input[] = bufferedReader.readLine().split("\\s+");
            for(int i= 0; i < number; i++){
                array[i] = Integer.parseInt(input[i].trim());
            }
            int[]  _out = process(number,array);
            for(int element : _out){
                System.out.print(element + " ");
            }
            // System.out.println(_out);
            testCase--;
        }
    }

    public static int[] process(int number,int[] array){
        int[] answer = new int[number];
        int product = 1;
        for(int i = 0; i<number;i++){
            product = product * array[i];
        }
        for(int i = 0 ; i< number;i++){
            answer[i] = product / array[i];
        }
        return answer;
    }
}