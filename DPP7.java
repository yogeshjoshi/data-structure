import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
 * count the number of ways it can be decoded.
 */
public class DPP7{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        while(testCase-->0){
            String number = bufferedReader.readLine().trim();

            int _out = process(number,number.length());

            System.out.println(_out);
        }
    }

    static int process(String number , int n){
        if(n==0 || n == 1){
            return 1;
        }
        if(number.charAt(0) == '0'){
            return 0;
        }
        int count = 0;

        if(Character.getNumericValue(number.charAt(n-1))>0){
            count = process(number, n-1);
        }

        if(Character.getNumericValue(number.charAt(n-2))==1 || (Character.getNumericValue(number.charAt(n-2))==2 && Character.getNumericValue(n-1)<7))
            count += process(number, n-2);
        return count;
    }
}