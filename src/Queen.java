
public class Queen {


    private int xPos;
    private int yPos;

    public Queen(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

/*
    public boolean canAttack(Queen queen) {

        if (xPos == queen.xPos || yPos == queen.yPos) return true;
        // is the slope is -1 or 1 they are the same line at 45degree
        int slope = (yPos - queen.yPos) / (xPos - queen.xPos);
        return slope == -1 || slope == 1;
    }*/

    public boolean canAttack(Queen queen){
        int deltaX = queen.xPos - this.xPos;
        int deltaY = queen.yPos - this.yPos;
        if (deltaX == 0 || deltaY ==0 ) return true;

        return Math.abs(((double) deltaX/(double)deltaY)) == 1d;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

}
