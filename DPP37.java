import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Print PowerSet of Given Set
 */
public class DPP37{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            String[] str = bufferedReader.readLine().trim().split("\\s+");
            process(str);
        }
    }

    static void process(String[] str){
        System.out.println("Power Sets are ..");
        System.out.print("{}");
        int length = str.length;
        int power =  (int) Math.pow(2, length);
        for(int i=0;i<power;i++){
            for(int j = 0; j< length;j++){
                if((i & (1 << j)) > 0){   // Shift 1 by J bit to left or simply 1 multiply by 2^j
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
}