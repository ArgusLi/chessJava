package dev.argusli.chess;

import java.util.Scanner;

public class Game {
    private Chessboard board;
    private PieceColour turn;
    private String instructions = "Welcome to chessJava by Argus.\nPlease input your move in the form 'PieceOriginalLocationFinalLocation', \ne.g. 'pd2d4' to move the pawn at d2 to d4.";
    private PieceColour winner;

    private boolean isThereAWinner(){
        return winner != null;
    }

    private void displayTurn(){
        switch(turn){
            case BLACK -> System.out.println("Black to move...");
            case WHITE -> System.out.println("White to move...");
        }
    }

    private void giveInstructions(){
        System.out.println(instructions);
    }

    private boolean isInputValid(String input){
        if(input.length() == 5){
            char lowerPiece = Character.toLowerCase(input.charAt(0));
            if(lowerPiece == 'p' || lowerPiece == 'b' || lowerPiece == 'n' || lowerPiece == 'r' || lowerPiece == 'q' || lowerPiece == 'k'){
                char fromLocationX = Character.toLowerCase(input.charAt(1));
                char fromLocationY = Character.toLowerCase(input.charAt(2));
                char toLocationX = Character.toLowerCase(input.charAt(3));
                char toLocationY = Character.toLowerCase(input.charAt(4));
                if(fromLocationX <= 'h' && fromLocationX >= 'a' && toLocationX <= 'h' && toLocationX >= 'a'){
                    if(fromLocationY >= '1' && fromLocationY <= '8' && toLocationY >= '1' && toLocationY <= '8'){
                        return true;
                    }
                }
            }

        }
        displayErrorMessage("input");
        return false;
    }

    private boolean isMoveValid(String move){
        char rawPiece = move.charAt(0);
        if((turn == PieceColour.BLACK && Character.isUpperCase(rawPiece)) || (turn == PieceColour.WHITE && Character.isLowerCase(rawPiece))){
            char lowerPiece = Character.toLowerCase(rawPiece);
            char fromLocationX = (char) (Character.toLowerCase(move.charAt(1)) - 49);
            char fromLocationY = (char) (Character.toLowerCase(move.charAt(2)) - 1);
            char toLocationX = (char) (Character.toLowerCase(move.charAt(3)) - 49);
            char toLocationY = (char) (Character.toLowerCase(move.charAt(4)) - 1);


            switch(lowerPiece){
                case 'p' -> {

                }
                case 'b' -> {

                }
                case 'n' -> {

                }
                case 'r' -> {

                }
                case 'q' -> {

                }
                case 'k' -> {

                }
            }
        }
        return true;
    }

    private void displayErrorMessage(String error){
        switch (error){
            case "input" -> System.out.println("Invalid input: please follow the pieceFromTo notation and try again.");
            case "move" -> System.out.println("Invalid move: please input a valid move.");
        }

    }

    public boolean makeMove(String input){
        if(isInputValid(input)){
            if(isMoveValid(input)){
                return true;
            }
        }

        return false;
    }

    public Game(){
        Scanner scanner = new Scanner(System.in);
        board = new Chessboard();
        turn = PieceColour.WHITE;
        giveInstructions();

        while(!isThereAWinner()){
            board.displayBoard();
            displayTurn();
            String input = scanner.nextLine();
            if(makeMove(input)){
                switch(turn){
                    case WHITE -> turn = PieceColour.BLACK;
                    case BLACK -> turn = PieceColour.WHITE;
                }
            }

        }
    }
}
