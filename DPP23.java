import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * You are given an M by N matrix consisting of booleans that represents a board. 
 * Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 * Given this matrix, a start coordinate, and an end coordinate, return the minimum number of 
 * steps required to reach the end coordinate from the start. If there is no possible path, then 
 * return null. You can move up, left, down, and right. You cannot move through walls.
 * You cannot wrap around the edges of the board.
 * 
 * question accepts input format -- 
 * 
 * 1  -- TestCase
 * 4  -- Row
 * 4  -- column
 * 1 1 1 1 0 0 1 0 1 1 1 1 1 1 1 1 -- Grid Input 1 represents step , 0 represents wall
 * 0  -- x1
 * 0  -- y1
 * 3  -- x2
 * 0  -- y2
 */
public class DPP23{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        while(testCase>0){
            int row = Integer.parseInt(bufferedReader.readLine());
            int col = Integer.parseInt(bufferedReader.readLine());
            int[][] grid = new int[row][col];
            String[] input = bufferedReader.readLine().split("\\s+");
            int index = 0;
            for(int i = 0; i<row; i++){
                for(int j = 0; j< col;j++){
                    grid[i][j] = Integer.parseInt(input[index++]);
                }
            }

            int x1 = Integer.parseInt(bufferedReader.readLine());
            int y1 = Integer.parseInt(bufferedReader.readLine());

            int x2 = Integer.parseInt(bufferedReader.readLine());
            int y2 = Integer.parseInt(bufferedReader.readLine());

            DPP23 dpp23 = new DPP23();
            int _out = dpp23.process(row,col,grid,x1,x2,y1,y2);
            System.out.println(_out);


            testCase--;
        }
    }

    boolean isValid(int row, int col, int x1, int y1){
        return (x1 >= 0 && x1 < row) && (y1 >= 0 && y1<col);
    }

    int process(int row, int col, int[][] grid, int x1, int x2, int y1, int y2){
        boolean[][] visted = new boolean[row][col];
        for (boolean[] v : visted) 
            Arrays.fill(v, false);

        // first check both point are valid or not
        if(grid[x1][y1] != 1 || grid[x2][y2] != 1){
            //If not valid returning -1
            return -1; 
        }

        //Possible Neighbour Coordinate
        int [] NX = {-1,1,0,0};
        int [] NY = {0,0,-1,1} ;

        visted[x1][y1] = true;
        Point point = new Point(x1, y1, 0);
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        while(!queue.isEmpty()){
            Point p = queue.remove();
            // System.out.println(p.getX() + "     " + p.getY());
            if(p.getX() == x2 && p.getY() == y2){
                return p.getDistace();
            }
            for(int i=0;i<4;i++){
                int x = NX[i]+p.getX();
                int y = NY[i]+p.getY();
                // System.out.println(x + "     " + y);
                if(isValid(row, col, x, y) && grid[x][y] == 1 && !visted[x][y]){
                    Point tempPoint = new Point(x,y,p.getDistace()+1);
                    queue.add(tempPoint);
                    visted[x][y] = true;
                }
            }
        }

        return -1;
    }

    class Point{
        int x;
        int y;

        int distace;

        Point(int x, int y, int distace){
            this.x = x;
            this.y = y;
            this.distace = distace;
        }

        /**
         * @return the distace
         */
        public int getDistace() {
            return distace;
        }

        /**
         * @return the x
         */
        public int getX() {
            return x;
        }

        /**
         * @return the y
         */
        public int getY() {
            return y;
        }
    }
}