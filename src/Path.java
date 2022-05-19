import java.util.ArrayList;

public class Path {

    private boolean isASolution;
    private ArrayList<BoardSnapShot> boardStateSnapShot;

    public Path() {
        isASolution = false;
        boardStateSnapShot = new ArrayList<>();
    }

    public void addBoardSnapShot(BoardSnapShot boardSnapShot) {
        boardStateSnapShot.add(boardSnapShot);
    }

    public void markAsASolution() {
        isASolution = true;
    }


    public void printPathSteps() {
        int boardSize = getBoardSize();
        String spacer;
        String header;
        header = isASolution ? "Solution!" : " ";

        System.out.println(header);
        for (int i = 0; i < boardSize; i++) {
            for (BoardSnapShot boardSnapShot : boardStateSnapShot) {
                spacer = "      ";
                // put an arrow at middle
                if (i == (boardSize / 2)) spacer = " ---> ";
                if (boardStateSnapShot.lastIndexOf(boardSnapShot) == boardStateSnapShot.size() - 1) {
                    spacer = "";
                }
                System.out.print(boardSnapShot.getRow(i) + spacer);
            }
            System.out.println();
        }
        System.out.println();
    }

    private int getBoardSize() {
        int boardSize = 0;

        if (!boardStateSnapShot.isEmpty()) {
            boardSize = boardStateSnapShot.get(0).getBoardSize();
        }
        return boardSize;
    }
}
