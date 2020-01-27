import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), 
 * find the minimum number of rooms required.
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class DPP21{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            int number = Integer.parseInt(bufferedReader.readLine().trim());
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i<number;i++){
                String[] str = bufferedReader.readLine().split("\\s+");
                map.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }
            int _out = process(map,number);

            System.out.println(_out);
        }
    }

    static int process(HashMap<Integer,Integer> map , int number){
        int array[] = new int[2*number];
        int index = 0;
        for(Map.Entry<Integer,Integer> entity : map.entrySet()){
            int key = (int)entity.getKey();
            int value = (int)entity.getValue();
            array[index++] = key;
            array[index++] = value;
        }
        Arrays.sort(array);
        int max = 0;
        int count = 0;
        for(int i=0;i<array.length;i++){
            if(map.get(array[i]) != null){
                count++;
                if(count>max)
                    max = count;
            }else{
                count--;
            }

        }
        return max;
    }
}