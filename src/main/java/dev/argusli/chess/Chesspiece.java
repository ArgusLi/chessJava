package dev.argusli.chess;

public class Chesspiece {
    private PieceColour colour;
    private PieceType pieceType;

    public Chesspiece() {
    }

    public Chesspiece(PieceColour newColour) {
        this.colour = newColour;
    }

    public PieceColour getColour(){
        return this.colour;
    }

    public void setColour(PieceColour newColour) {
        this.colour = newColour;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }

    public void setPieceType(PieceType newType){
        this.pieceType = newType;
    }
}
