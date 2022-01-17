package dev.argusli.chess;

public class Chesspiece {
    private PieceColour colour;
    private PieceType pieceType;
    private char displayC;
    private void setDisplayC(PieceType pieceType) {
        switch (pieceType) {
            case PAWN -> this.displayC = 'p';
            case BISHOP -> this.displayC = 'b';
            case KNIGHT -> this.displayC = 'n';
            case ROOK -> this.displayC = 'r';
            case QUEEN -> this.displayC = 'q';
            case KING -> this.displayC = 'k';
        }
        if (colour == PieceColour.BLACK) {
            displayC = Character.toUpperCase(displayC);
        }
    }

    public Chesspiece(PieceColour newColour, PieceType newPieceType) {
        this.colour = newColour;
        this.pieceType = newPieceType;
        setDisplayC(newPieceType);
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
        setDisplayC(newType);
    }

    public char getDisplayC(){
        return this.displayC;
    }
}
