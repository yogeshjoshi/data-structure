
/**
 * Implement a stack that has the following methods:
 * push(val), which pushes an element onto the stack
 * pop(), which pops off and returns the topmost element of the stack. 
 * If there are no elements in the stack, then it should throw an error or return null.
 * max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
 */

public class DPP43{

    customStack stack;
    public static void main(String[] args) {
        DPP43 dpp43 = new DPP43();
        dpp43.stack = new customStack();

        // Operation Here ...
        dpp43.stack.push(5);
        System.out.println("Max Yet - "+dpp43.stack.getMax());
        dpp43.stack.push(6);
        System.out.println("Max Yet - " +dpp43.stack.getMax());
        System.out.println(dpp43.stack.pop());
        System.out.println("Max Yet - " + dpp43.stack.getMax());
    }
}

// Seprate window to store max or min value till now, at each step we should store this value 
class customStack{
    int[] array = new int[100];
    int[] maxArray = new int[100];
    int top = 0;
    int max = Integer.MIN_VALUE;

    public void push(int val){
        array[top] = val;
        if(val > max)
            max = val;
        maxArray[top] = max;
        top += 1;
    }

    
    public Integer getMax(){
        if(max == Integer.MIN_VALUE)
            return null;
        else 
            return maxArray[top-1];
    }
    public Integer pop(){
        top--;
        return array[top];
    }
}