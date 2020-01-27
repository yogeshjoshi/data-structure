import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Compute the running median of a sequence of numbers. That is, given a stream of numbers, 
 * print out the median of the list so far on each new element.
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 * 
 * 
 * Insertion Sort Basically But not preferable solution since it would be stream of numbers 
 * or basically may be enough ... and complexcity of Insertion Sort is O(N2) in worst case.
 * 
 *  
 */
public class DPP33{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            String[] input = bufferedReader.readLine().split("\\s+");
            int[] array = new int[input.length];
            for(int i =0;i<input.length;i++){
                array[i] = Integer.parseInt(input[i]);
            }

            process(array,input.length);
        }
    }

    static void process(int[] array,int len){
        System.out.println(array[0]);
        for(int i=1;i<len;i++){
            int j = i-1;
            int key = array[i];
            while(j>=0 && key<array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
            int elementInINPlaceArray = i + 1;
            float midian = 0;
            if(elementInINPlaceArray % 2 == 0){
                int mid = elementInINPlaceArray / 2;
                midian = array[mid-1] + array[mid];
                midian = midian/2;
            }else{
                midian = array[elementInINPlaceArray/2];
            }
            System.out.println(midian);
        }
    }
}