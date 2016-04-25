package com.daily.April;

/**
 * Created by luckyyflv on 16-4-25.
 * <p/>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p/>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p/>
 * For example,
 * Given board =
 * <p/>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {
    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    //index表示搜索字符串中的第index个位置
    private boolean search(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (search(board, word, i - 1, j, index + 1) ||
                search(board, word, i + 1, j, index + 1) ||
                search(board, word, i, j - 1, index + 1) ||
                search(board, word, i, j + 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
