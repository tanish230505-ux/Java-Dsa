class Solution {
    List<List<String>> ans = new ArrayList<>();
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; 
        boolean[] diag2 = new boolean[2 * n - 1]; 

        backtrack(0, n, col, diag1, diag2);

        return ans;
    }

    void backtrack(int row, int n, boolean[] col,
                   boolean[] diag1, boolean[] diag2) {

        if (row == n) {
            List<String> list = new ArrayList<>();

            for (char[] r : board)
                list.add(new String(r));

            ans.add(list);
            return;
        }

        for (int c = 0; c < n; c++) {

            int d1 = row + c;
            int d2 = row - c + n - 1;

            if (col[c] || diag1[d1] || diag2[d2])
                continue;

        
            board[row][c] = 'Q';
            col[c] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n, col, diag1, diag2);

    
            board[row][c] = '.';
            col[c] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}