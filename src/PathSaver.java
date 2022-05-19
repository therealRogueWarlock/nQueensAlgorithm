import java.util.ArrayList;

public class PathSaver {

   static ArrayList<Path> paths = new ArrayList<>();
   static Path currentPath = new Path();

   private PathSaver(){}

   static void addBoardStateToSolution(BoardSnapShot boardSnapShot){
      currentPath.addBoardSnapShot(boardSnapShot);
   }

   static void savePath(){
      paths.add(currentPath);
      currentPath = new Path();
   }

   static void markPathAsSolution(){
      currentPath.markAsASolution();
   }


   static void printAllSavedPaths(){
      for (Path path : paths) {
         path.printPathSteps();
      }
   }

}
