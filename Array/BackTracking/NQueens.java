package Array.BackTracking;

import java.util.*;

//Problem Statement
//
//Given an integer N, place N queens on an N × N chessboard such that:
//
//No two queens attack each other
//
//A queen can attack:
//
//Same row
//
//Same column
//
//Same diagonal
//
//Return all possible valid board configurations.

public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        Solution sol = new Solution();
        List<List<String>> result = sol.solveNQueens(n);

        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backTrack(ans, board, 0);
        return ans;
    }

    public void backTrack(List<List<String>> ans, char[][] board, int col) {
        int n = board.length;

        // Base case
        if (col == n) {
            ans.add(constructBoard(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (safePlace(board, row, col)) {
                board[row][col] = 'Q';
                backTrack(ans, board, col + 1);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    public boolean safePlace(char[][] board, int row, int col) {
        int n = board.length;

        int dupr = row;
        int dupc = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q')return false;
            row--;
            col--;
        }
        col = dupc;
        row = dupr;
        while(col >= 0){
            if(board[row][col] == 'Q')return false;
            col--;
        }

        col = dupc;
        row = dupr;
        while(col >= 0 && row < n){
            if(board[row][col] == 'Q')return false;
            col--;
            row++;
        }
        return true;
    }

    private List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}

