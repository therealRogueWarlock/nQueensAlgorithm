

public class Main {

    public static boolean savePath = true;
    public static boolean saveBacktrackPath = true;
    public static boolean oneSolution = false;
    public static int solutionCounter = 0;

    public static void main(String[] args) {

        Board newBoard = new Board(6);
        nQueenAlgorithm(newBoard, new Queen(0, 0));
        PathSaver.printAllSavedPaths();
        System.out.println("Solutions found: " + solutionCounter);
    }


    public static boolean nQueenAlgorithm(Board board, Queen queen) {

        // solution reached when the last queen is placed
        if (queen.getyPos() >= board.getSize()) {

            // a solution is found !
            solutionCounter++;

            // if it did not save the path as it was solving, save last board state
            if (!savePath){
                PathSaver.addBoardStateToSolution(board.getBoardSnapShot());
            }

            PathSaver.markPathAsSolution();
            PathSaver.savePath();
            if(oneSolution) return true;

        }

        // check if the queens position is on the board.
        if (!board.onBoard(queen)) return false;

        for (int i = 0; i < board.getSize(); i++) {
            queen.setxPos(i);
            boolean isPlaced = board.placeQueen(queen);

            if (isPlaced) {
                if (savePath){PathSaver.addBoardStateToSolution(board.getBoardSnapShot());}

                // if the previous queen is added try adding a new to the next column
                // if this lead to a solution return true.
                if (nQueenAlgorithm(board, new Queen(0, queen.getyPos() + 1))) return true;

                //the previous path didn't lead to a solution
                if (saveBacktrackPath) {
                    //add board state to path before backtracking
                    PathSaver.addBoardStateToSolution(board.getBoardSnapShot());
                    // saving path
                    PathSaver.savePath();
                }
                //remove the last queen added to the board: backtrack
                board.backTrackBoard();
            }

        }

        return false;
    }
}
