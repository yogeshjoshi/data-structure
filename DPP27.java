import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string of round, curly, and square open and closing brackets, 
 * return whether the brackets are balanced (well-formed).
 * For example, given the string "([])[]({})", you should return true.
 * Given the string "([)]" or "((()", you should return false.
 */
public class DPP27{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            String str = bufferedReader.readLine().trim();
            boolean _out = process(str);
            System.out.println(_out);
        }
    }

    static boolean process(String str){
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '[' ||  str.charAt(i) == '{'){
                stack.push(str.charAt(i));
            }else{
                if(map.get(str.charAt(i)) == stack.peek())
                    stack.pop();
                else{
                    flag = false;
                    return flag;
                }              
            }
        }
        if(stack.isEmpty()){
            flag = true;
        }
        return flag;
    }
}