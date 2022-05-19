import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private int size;
    private char boardState[][];
    private char resetChar = ' ';

    // is used as "null" char when resetting a pos in board state matrix
    private ArrayList<Queen> queens;


    public Board(int size) {
        this.size = size;
        this.boardState = new char[size][size];
        restBoardState();
        this.queens = new ArrayList<>();
    }

    public boolean onBoard(Queen queen) {

        return (queen.getyPos() < size && queen.getxPos() < size);
    }

    private void restBoardState(){
        for (int i = 0; i < size; i++) {
            for (int s = 0; s < size; s++) {
                boardState[i][s] = ' ';
            }
        }

    }

    public boolean placeQueen(Queen queen) {

        if (isSpotValid(queen)) {
            boardState[queen.getxPos()][queen.getyPos()] = 'Q';
            queens.add(queen);
            return true;
        }

        boardState[queen.getxPos()][queen.getyPos()] = 'X';
        return false;
    }

    public boolean isSpotValid(Queen queen) {
        if (!queens.isEmpty()) {
            for (Queen lastQueen : queens) {
                if (lastQueen.canAttack(queen)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public void backTrackBoard() {
        removeLastQueen();
    }

    private void removeLastQueen() {
        if (!queens.isEmpty()) {
            Queen queenToRemove = queens.get(queens.size() - 1);
            boardState[queenToRemove.getxPos()][queenToRemove.getyPos()] = resetChar;
            // rest the col right to the removed queen
            restCol(queenToRemove.getyPos() + 1);
            queens.remove(queenToRemove);
        }
    }

    private void restCol(int colNumber) {
        if (colNumber < size)
            for (int i = 0; i < size; i++) {
                boardState[i][colNumber] = resetChar;
            }
    }

    public Board copy(){
        Board copyBoard = new Board(size);
        copyBoard.setBoardState(boardState.clone());
        copyBoard.setQueens((ArrayList<Queen>) queens.clone());
        return copyBoard;
    }

    public BoardSnapShot getBoardSnapShot(){
        return new BoardSnapShot(boardState.clone());
    }

    private void setBoardState(char[][] boardState) {
        this.boardState = boardState;
    }

    private void setQueens(ArrayList<Queen> queens) {
        this.queens = queens;
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
}
