package recursion;

public class KinghtMove {
    public static final int[][] board = new int[8][8];
    private static final int[] rowDir = { -2, -1, 1, 2,2, 1, -1, -2};
    private static final int[] colDir = { -1, -2, -2, -1,1, 2, 2, 1};
    public static void main(String[] args) {
        board[0][4] = 1;
        System.out.println(solveKnightMove(1,0,4));
    }

    private static void printChessBoard(int[][] board){
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean canMove(int r,int c){
        return  r>=0 && r <8 && c >= 0 && c < 8 && board[r][c] == 0;
    }

    private static boolean solveKnightMove(int curMove,int curRow,int curCol) {
        /**
         * This function will be called hell lot of times so if you place the below print statement it will take a lot of time
         * So don't think the program will run into infinite loop. Be patient and it will give the result.
         */
//        System.out.println("current Move : "+curMove);
        if(curMove == 64) {
            printChessBoard(board);
            return true;
        };
        for (int curDir = 0; curDir < 8; curDir++) {
            int newRow = curRow + rowDir[curDir];
            int newCol = curCol + colDir[curDir];
            if(canMove(newRow,newCol)){
                curMove++;
                board[newRow][newCol] = curMove;
                boolean result = solveKnightMove(curMove,newRow,newCol);
                if(result){
                    return true;
                } else{
                    curMove--;
                    board[newRow][newCol] = 0;
                }
            }
        }
        return  false;
    }
}
