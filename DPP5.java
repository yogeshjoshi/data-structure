import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */
public class DPP5{
    public static void main(String[] args) throws IOException{
        DPP5 dpp5 = new DPP5();
        System.out.println(dpp5.car(dpp5.cons(3,4)));
        System.out.println(dpp5.cdr(dpp5.cons(3,4)));
    }

    public Pair cons(int a,int b){
        Pair pair = new Pair(a,b);
        return pair;
    }

    public int car(Pair pair){
        return pair.getFirstElement();
    }

    public int cdr(Pair pair){
        return pair.getSecondElement();
    }

    class Pair {
        int firstElement;
        int secondElement;
        Pair(int firstElement, int secondElement ){
            this.firstElement = firstElement;
            this.secondElement = secondElement;
        }

        /**
         * @return the firstElement
         */
        public int getFirstElement() {
            return firstElement;
        }

        /**
         * @return the secondElement
         */
        public int getSecondElement() {
            return secondElement;
        }
    }
}