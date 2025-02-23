package tictactoe;

public class Board {
    private final char[][] board;
    private int movesCount;
    private final int[] rows;
    private final int[] cols;
    private int diagonal;
    private int reverseDiagonal;
    protected int size;

    public Board(int n) {
        board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }
        movesCount = 0;
        size = n;
        rows = new int[n];
        cols = new int[n];
    }

    public synchronized boolean makeMove(int row, int col, Player player) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != '-') {
            System.out.println("Invalid move");
            return false;
        }
        char marker = player.getMarker();
        board[row][col] = marker;
        movesCount++;

        int cnt = (marker == 'X') ? 1 : -1;

        trackCounters(row,col,cnt);
        return true;
    }

    private void trackCounters(int row, int col, int cnt) {
        rows[row] += cnt;
        cols[col] += cnt;

        if(row == col){
            diagonal += cnt;
        }

        if(row+col == size-1){
            reverseDiagonal += cnt;
        }
    }

    public boolean checkWinner(int row, int col) {
        return Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size ||
                Math.abs(reverseDiagonal) == size;
    }

    void printBoard(){
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean isFull(){
        return movesCount == size*size;
    }
}
