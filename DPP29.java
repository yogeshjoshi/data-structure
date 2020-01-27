import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Run-length encoding is a fast and simple method of encoding strings. 
 * The basic idea is to represent repeated successive characters as a single count and character. 
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A"
 */
public class DPP29{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            int number = Integer.parseInt(bufferedReader.readLine().trim());
            String str = bufferedReader.readLine().trim();

            String _out = process(number, str);

            System.out.println(_out);
        }
    }

    static String process(int number, String str){
        String prevChar = null;
        Stack<String> stack = new Stack<>();
        stack.push(Character.toString(str.charAt(0)));
        StringBuilder returnStr = new StringBuilder();
        for(int i=1;i<str.length();i++){
            if(!stack.isEmpty())
                prevChar = stack.peek();
            if(prevChar != null){
                if(prevChar.equals(Character.toString(str.charAt(i)))){
                    stack.push(Character.toString(str.charAt(i)));
                }else{
                    int count = 1;
                    String c = stack.pop();
                    while(!stack.isEmpty() && c.equals(stack.peek())){
                        stack.pop();
                        count += 1;
                    }
                    stack.push(String.valueOf(count));
                    stack.push(c);
                    stack.push(Character.toString(str.charAt(i)));
                }
            }
        }

        int count = 1;
        String c = stack.pop();
        while(!stack.isEmpty() && c.equals(stack.peek())){
            stack.pop();
            count += 1;
        }
        stack.push(String.valueOf(count));
        stack.push(c);

        while(!stack.isEmpty()){
            returnStr.insert(0, stack.pop());
        }
        return returnStr.toString();
    }
}