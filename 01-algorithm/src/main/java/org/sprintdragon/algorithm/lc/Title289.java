package org.sprintdragon.algorithm.lc;

import java.util.*;

public class Title289 {
    public static void main(String[] args) {
        Title289 test = new Title289();
        int[][] a = {{1, 1}};
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        test.gameOfLife(a);
        System.out.println("#######");
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public void gameOfLife(int[][] board) {
        List<Integer[]> toResume = new ArrayList<>(board.length * board[0].length);
        //2代表0->1 3代表1->0
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (update(board, i, j)) {
                    toResume.add(new Integer[]{i, j});
                }
            }
        }
        for (Integer[] entry : toResume) {
            int x = entry[0];
            int y = entry[1];
            int status = board[x][y];
            board[x][y] = status == 2 ? 1 : 0;
        }
    }

    public boolean update(int[][] board, int row, int column) {
        int status = board[row][column];
        int liveAroundCount = 0;
        int tmp = 0;
        if (row > 0 && column > 0) {
            tmp = board[row - 1][column - 1];
            liveAroundCount += isLife(tmp) ? 1 : 0;
        }
        if (row > 0) {
            tmp = board[row - 1][column];
            liveAroundCount += isLife(tmp) ? 1 : 0;
        }
        if (row > 0 && column < board[0].length - 1) {
            tmp = board[row - 1][column + 1];
            liveAroundCount += isLife(tmp) ? 1 : 0;
        }
        if (column > 0) {
            tmp = board[row][column - 1];
            liveAroundCount += isLife(tmp) ? 1 : 0;
        }
        if (column < board[0].length - 1) {
            tmp = board[row][column + 1];
            liveAroundCount += isLife(tmp) ? 1 : 0;
        }
        if (row < board.length - 1 && column > 0) {
            tmp = board[row + 1][column - 1];
            liveAroundCount += isLife(tmp) ? 1 : 0;
        }
        if (row < board.length - 1) {
            tmp = board[row + 1][column];
            liveAroundCount += isLife(tmp) ? 1 : 0;
        }
        if (row < board.length - 1 && column < board[0].length - 1) {
            tmp = board[row + 1][column + 1];
            liveAroundCount += isLife(tmp) ? 1 : 0;
        }
        int toStatus = 0;
        if (liveAroundCount < 2) {
            toStatus = isLife(status) ? 3 : status;
        } else if (liveAroundCount == 2) {
            toStatus = status;
        } else if (liveAroundCount == 3) {
            toStatus = isLife(status) ? status : 2;
        } else {
            toStatus = isLife(status) ? 3 : status;
        }
        board[row][column] = toStatus;
        return toStatus == 2 || toStatus == 3 ? true : false;
    }

    public boolean isLife(int status) {
        return status == 1 || status == 3;
    }

}
