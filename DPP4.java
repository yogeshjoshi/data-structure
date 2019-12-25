import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Problem Statement - Find out the least positive number missing in Array
 */
public class DPP4{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testcase>0){
            int number = Integer.parseInt(bufferedReader.readLine().trim());
            int array[] = new int[number];
            String[] input = bufferedReader.readLine().split("\\s+");
            for(int i = 0; i< number;i++){
                array[i] = Integer.parseInt(input[i].trim());
            }
            int _out = process(number,array);
            System.out.println(_out);
            testcase--;
        }
    }

    static int process(int number, int[] array){
        //First put side Negative Numbers if exist.
        int l = 0;
        int r = number-1;
        while(l<=r){
            //we will have to swap the numbers.
            if(array[l]<0){
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                r--;
            }else{
                l++;
            }
        }
        // for(int i=0;i<number;i++){
        //     System.out.print(array[i] + " ");
        // }
        // System.out.println(l);
        for(int i=0 ;i<l;i++){
            if( Math.abs(array[i])<number && array[Math.abs(array[i])]>0){
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            }
        }
        int desiredNumber =1;
        for(int i=1;i<l;i++){
            if(array[i]>0){
                desiredNumber = i;
                break;
            }else if(array[i] != 0){
                desiredNumber++;
            }
        }
        return desiredNumber;
    }
}
