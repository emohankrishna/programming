package com.mohan.ede;

public class BoggleBoard {
    static int[] rowDir = {+1,+1,+0,-1,-1,-1,+0,+1};
    static int[] colDir = {+0,+1,+1,+1,0,-1,-1,-1};
    static int[][] lookUp = new int[3][3];
    static String[] board = new String[]{"GIZ","UEK","QSE"};
    static String[] dict = {"GEEK","FOR","QUIZ","GO"};

    static boolean isValidMove(int r,int c){
        return r>=0 && r < 3 &&
                c>=0 && c < 3 &&
                lookUp[r][c] == 0;
    }

    static boolean isWordInDict(String word){
        for (int i = 0; i <dict.length ; i++) {
            if(word.equals(dict[i])) return true;
        }
        return false;
    }

    static void solveBoggleBoard(int curRow,int curCol,String word){
        System.out.println(word);
        if(isWordInDict(word)){
            System.out.println("=======================");
            System.out.println(word+" in Dictionary");
            System.out.println("=======================");
            return;
        }

        for (int i = 0; i <8 ; i++) {
            int newRow = curRow + rowDir[i];
            int newCol = curCol + colDir[i];
            if(isValidMove(newRow,newCol)){
                lookUp[newRow][newCol] = 1;
                solveBoggleBoard(newRow,newCol,word+board[newRow].charAt(newCol));
                lookUp[newRow][newCol] = 0;
            }
        }
    }
    public static void main(String[] args) {

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                lookUp[i][j] = 1;
                solveBoggleBoard(0,0,board[i].charAt(j)+"");
                lookUp[i][j] = 0;
            }
        }

    }
}
