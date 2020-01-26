import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Heap Sorts
 */
public class HeapSort{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            String[] str = bufferedReader.readLine().trim().split("\\s+");
            int array[] = new int[str.length];
            int index = 0;
            for(String s : str){
                array[index++] = Integer.parseInt(s);
            }
            int[] _out = process(array,array.length);
            //Output Here ...
            for(int digit : _out){
                System.out.print(digit + " ");
            }
        }
    }

    static int[] process(int[] array, int length){
        //build heap 
        //Heap sort according
        //Building Heap by Percolate Down -- in Reverse Ordering
        for(int i = length/2;i>=0;i--){
            heapify(array, length, i);
        }

        //We are buuilding Max Heap Here
        //One By one swap max element to last of the array
        for(int i = length-1;i>=0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        return array;
    }

    /**
     * Heapify -- Percolate Down
     */
    static void heapify(int arr[], int n,int i){

        int left = 2*i+1;
        int right = 2*i+2;

        int max = i;

        if(left<n && arr[left] > arr[i])
            max = left;
        if(right<n && arr[right]>arr[max])
            max = right;
        if(max != i){
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;

            heapify(arr, n, i);
        }
    }
}