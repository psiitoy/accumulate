package org.sprintdragon.algorithm.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Title36 {
    public static void main(String[] args) {
        Title36 test = new Title36();
        char[][] a = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(test.isValidSudoku(a));
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> indexMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columnSet.add(board[j][i])) {
                    return false;
                }
                if (board[i][j] == '.') {
                    continue;
                }
//                int mapIndex = getMapIndex(i, j);
                //此处可替换 int mapIndex = i / 3 * 3 + j / 3;
                int mapIndex = i / 3 * 3 + j / 3;
                if (!indexMap.containsKey(mapIndex)) {
                    indexMap.put(mapIndex, new HashSet<>());
                }
                if (!indexMap.get(mapIndex).add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getMapIndex(int row, int column) {
        if (row < 3 && column < 3) {
            return 0;
        } else if (row < 3 && column < 6) {
            return 1;
        } else if (row < 3 && column < 9) {
            return 2;
        } else if (row < 6 && column < 3) {
            return 3;
        } else if (row < 6 && column < 6) {
            return 4;
        } else if (row < 6 && column < 9) {
            return 5;
        } else if (row < 9 && column < 3) {
            return 6;
        } else if (row < 9 && column < 6) {
            return 7;
        } else if (row < 9 && column < 9) {
            return 8;
        }
        return -1;
    }
}
