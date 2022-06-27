package dev.argusli.chess.pieces;

import dev.argusli.chess.PieceColour;

public abstract class Chesspiece {
    private PieceColour colour;
    private int lastTurnMoved = 0;
    private int x;
    private int y;

    public PieceColour getColour() {
        return colour;
    }

    public Chesspiece(PieceColour colour, int x, int y){
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    public int getLastTurnMoved(){
        return lastTurnMoved;
    }

    public void setLastTurnMoved(int lastTurnMoved) {
        this.lastTurnMoved = lastTurnMoved;
    }

    public int getXCoordinate() { return this.x;}
    public void setXCoordinate(int x) { this.x = x;}

    public int getYCoordinate() { return this.y;}
    public void setYCoordinate(int y) { this.y = y;}

    public abstract boolean moveTo(int newX, int newY, int currentTurn);
    public abstract boolean take(int newX, int newY, Chesspiece pieceTaken, int currentTurn);
}
