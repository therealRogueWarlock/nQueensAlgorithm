import java.util.Arrays;

public class BoardSnapShot {

    private char boardState[][];
    private int boardSize;
    public BoardSnapShot(char[][] boardStateSnapShot) {
        boardSize = boardStateSnapShot.length;
        this.boardState = new char[boardStateSnapShot.length][];
        for (int i = 0; i < boardStateSnapShot.length; i++) {
            boardState[i] = boardStateSnapShot[i].clone();
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (char[] row : boardState) {
            builder.append(Arrays.toString(row)).append("\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public String getRow(int rowNumber){
        return Arrays.toString(boardState[rowNumber]);
    }
}
