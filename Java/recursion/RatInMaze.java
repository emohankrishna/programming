package recursion;

public class RatInMaze {
    private static final int MAZE_SIZE = 5;
    private static final int[] rowDir={0,+1,0,-1};
    private static final int[] colDir={1,0,+1,0};
    private static int[][] maze={
            {1,1,0,0,0},
            {0,1,1,1,1},
            {0,0,1,0,1},
            {1,1,1,1,1},
            {1,1,1,1,1}};
    private final static int[][] visited =new int[MAZE_SIZE][MAZE_SIZE];

    static boolean isValidMove(int r, int c){
        return r >=0 && r < MAZE_SIZE &&
                c >=0 && c < MAZE_SIZE &&
                maze[r][c] == 1 &&
                visited[r][c] == 0;
    }
    static void printSolution(int[][] arr){
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();

        }
    }
    static boolean ratInMazeSolution(int row, int col, int move, int destRow, int destCol){
        if(row == destRow && col == destCol){
            printSolution(visited);
            return true;
        } else{
            for (int i = 0; i <4 ; i++) {
                int newRow = row + rowDir[i];
                int newCol = col + colDir[i];
                if(isValidMove(newRow,newCol)){
                    visited[newRow][newCol] = move+1;
                    boolean res = ratInMazeSolution(newRow,newCol,move+1,destRow,destCol);
                    visited[newRow][newCol] = 0;

                    if(res) return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        visited[0][0] =1;
//        printSolution(visited);
//        printSolution(maze);
        System.out.println(ratInMazeSolution(0,0,1,4,4));
    }
}
