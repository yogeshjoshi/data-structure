import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The edit distance between two strings refers to the minimum number of character insertions, 
 * deletions, and substitutions required to change one string to the other. 
 * For example, the edit distance between “kitten” and “sitting” is three: 
 * substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
 */
public class DPP31{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            String source = bufferedReader.readLine().trim();
            String target = bufferedReader.readLine().trim();

            int _out = process(source,target);
            System.out.println(_out);
        }
    }

    static int process(String source, String target){
        int[][] editDistance = new int[source.length()+1][target.length()+1];
        for(int i=0;i<=source.length();i++){
            for(int j=0;j<=target.length();j++){
                if(i==0)
                    editDistance[i][j] = j;
                else if(j==0)
                    editDistance[i][j] = i;

                else if(source.charAt(i-1) == target.charAt(j-1))
                    editDistance[i][j] = editDistance[i-1][j-1];
                else{
                    editDistance[i][j] = 1 + Math.min(Math.min(editDistance[i][j-1], editDistance[i-1][j-1]),editDistance[i-1][j]);
                }
            }
        }
        return editDistance[source.length()][target.length()];
    }
}