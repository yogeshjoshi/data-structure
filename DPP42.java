import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a list of integers S and a target number k, 
 * write a function that returns a subset of S that adds up to k. 
 * If such a subset cannot be made, then return null.
 * Integers can appear more than once in the list. 
 * You may assume all numbers in the list are positive.
 * 
 * For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] 
 * since it sums up to 24.
 */
public class DPP42{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            String[] str = bufferedReader.readLine().trim().split("\\s+");
            int[] arr = new int[str.length];
            int index = 0;
            for(String s : str){
                arr[index++] = Integer.parseInt(s);
            }

            int sum = Integer.parseInt(bufferedReader.readLine().trim());

            boolean _out = process(arr,arr.length, sum);

            boolean _out1 = isSumSubet(arr,arr.length,sum);

            System.out.println(_out);
            System.out.println(_out1);
        }
    }

    static boolean process(int[] array, int n ,int sum){
        if(sum==0)
            return true;
        if(n==0 && sum != 0)
            return false;
        if(array[n-1] > sum)
            return process(array, n-1, sum);  
        return process(array, n-1, sum-array[n-1]) || process(array, n-1, sum);
    }

    static boolean isSumSubet(int[] array, int n, int sum){
        boolean dp[][] = new boolean[sum+1][n+1];
        for(int i=0;i<n+1;i++)
            dp[0][i] = true;
        for(int i=1;i<sum+1;i++)
            dp[i][0] = false;
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i][j-1];
                if(i>=array[j-1]){
                    dp[i][j] = dp[i-array[j-1]][j-1] || dp[i][j];
                }
            }
        }
        return dp[sum][n];
    }
}