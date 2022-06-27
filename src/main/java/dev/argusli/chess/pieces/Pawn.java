package dev.argusli.chess.pieces;

import dev.argusli.chess.PieceColour;

import static java.lang.Math.abs;

public class Pawn extends Chesspiece {
    public Pawn(PieceColour colour, int x, int y) {
        super(colour, x, y);
    }

    private void moveAndUpdateLastTurnMoved(int x, int y, int currentTurn){
        super.setXCoordinate(x);
        super.setYCoordinate(y);
        super.setLastTurnMoved(currentTurn);
    }

    @Override
    public boolean moveTo(int newX, int newY, int currentTurn) {
        int xDiff = newX - super.getXCoordinate();
        int yDiff = newY - super.getYCoordinate();
        if(xDiff == 0){
            if(yDiff == 1){
                moveAndUpdateLastTurnMoved(newX, newY, currentTurn);
                return true;
            }
            else if(yDiff == 2 && super.getLastTurnMoved()==0){
                moveAndUpdateLastTurnMoved(newX, newY, currentTurn);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean take(int newX, int newY, Chesspiece pieceTaken, int currentTurn) {
        return false;
    }
}

