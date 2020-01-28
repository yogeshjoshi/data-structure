import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * You have an N by N board. 
 * Write a function that, given N, returns the number of possible arrangements of the board 
 * where N queens can be placed on the board without threatening each other, 
 * i.e. no two queens share the same row, column, or diagonal.
 */
public class DPP38{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCase-->0){
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            isNQueenPossible(N);
        }
    }

    //N queen problem starts here

    static void isNQueenPossible(int N){
        int[][] board = new int[N][N];
        Arrays.stream(board).forEach(b -> Arrays.fill(b, 0));

        if(!nQueenUtil(board, 0))
            System.out.println("Solution Not Possible");

    }

    static boolean nQueenUtil(int[][] board, int col){

        if(col>= board[0].length)
            {
                //has been printed
                System.out.println("Solution Structure -- ");
                for(int i=0;i<board[0].length;i++){
                    for(int j=0;j<board[0].length;j++)
                        System.out.print(board[i][j] + " ");
                    System.out.println();
                }
               // return true;
            }

        for(int i=0;i<board[0].length;i++){
            if(isSafe(board, i, col, board[0].length)){
                board[i][col] = 1;
            if(nQueenUtil(board, col+1))
                return true;

            //backtrack back to the board at i and col
            board[i][col] = 0;
            }
        }

        return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int N){
        int i, j;
        for(i=0;i<col;i++){
            if(board[row][i] == 1)
                return false;
        }
/**
 * diagonal pointing top left to bottom right
 */
        for(i=row,j=col; j>=0 && i>=0 ; j--, i--){
            if(board[i][j] == 1)
                return false;
        }

        /**
         * diagonal pointing bottom left to top right
         */
        for(i=row,j=col;j>=0 && i<N; i++,j-- ){
            if(board[i][j] ==1)
                return false;
        }

        return true;
    }
}