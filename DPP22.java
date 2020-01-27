import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a dictionary of words and a string made up of those words (no spaces),
 * return the original sentence in a list. If there is more than one possible reconstruction, 
 * return any of them. If there is no possible reconstruction, then return null.
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
 * you should return ['the', 'quick', 'brown', 'fox'].
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
 * return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class DPP22{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            String[] words = bufferedReader.readLine().split("\\s+");
            String sentences = bufferedReader.readLine().trim();
            Set<String> dictionary = new HashSet<>();
            for(String word : words){
                dictionary.add(word);
            }
            ArrayList<String> _out = process(dictionary,sentences);
            for(String word: _out){
                System.out.print(word + " ");
            }
            System.out.println("");
        }
    }

    static ArrayList<String> process(Set<String> dictionary, String sentences){
        ArrayList<String> answer = new ArrayList<>();
        if(sentences.equals("")){
            answer.add("");
            return answer;
        }

        boolean dp[] = new boolean[sentences.length()+1];
        Arrays.fill(dp, false);

        for(int i = 1; i<= sentences.length();i++){
            String word1 = sentences.substring(0, i);
            if(!dp[i] && dictionary.contains(word1)){
                dp[i] = true;
                answer.add(word1);
                //System.out.println("yo" + word1);
            }
            if(dp[i]){
                if(i==sentences.length())
                    return answer;
                for(int j = i+1; j<=sentences.length();j++){
                    if(!dp[j] && dictionary.contains(sentences.substring(i, j))){
                        dp[j] = true;
                        answer.add(sentences.substring(i, j));
                        //System.out.println("yo" + sentences.substring(i, j));
                    }

                    if(j==sentences.length() && dp[j])
                        return answer;
                }
            }
        }

        return answer;
    }
}