import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Problem Statement - Given a list of numbers and number k, return whether any two numbers from the list add up to k.
 */
class DPP1{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        while(testCase > 0){
            int n = Integer.parseInt(bufferedReader.readLine());
            int array[] = new int[n];
            String input [] = bufferedReader.readLine().split("\\s+");
            for(int i = 0 ;i <n;i++){
                array[i] = Integer.parseInt(input[i].trim());
            }
            int sum = Integer.parseInt(bufferedReader.readLine());
            String _out = pairSumExist(n, array, sum);
            System.out.println(_out);
            testCase--;
        }
    }
    static String pairSumExist(int n , int[] array, int sum){
        HashMap<Integer,String> map = new HashMap<>();
        for (int var :array) {
           if(map.get(sum-var) != null){
               return "Exist"; 
           }else{
               map.put(var, "");
           }
        }
        return "Not Exist";
    }
}