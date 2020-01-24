import java.util.concurrent.Callable;

/**
 * Implement a job scheduler which takes in a function f and an integer n, 
 * and calls f after n milliseconds.
 * */
public class DPP10{
    public static void main(String[] args) throws Exception{
        setTimeout(5000,  new Callable<Integer>() {
            public Integer call() {
                 return executeFuntion();
            }
         });
    }

    static void setTimeout(int time, Callable<Integer> myFunc) throws Exception{
        new Thread().sleep(time);
        myFunc.call();
    }

    static Integer executeFuntion(){
        System.out.println("Sample Function");
        return 0;
    }
}