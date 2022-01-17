package dev.argusli.chess;

public class Chessboard {
    private Chesspiece[][] board;
    private int xSize = 8;
    private int ySize = 8;
    private String spacing = " ";
    private PieceType[] pieces = {PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN, PieceType.KING, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK};
    private char[] header = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public Chessboard(){
        board = new Chesspiece[xSize][ySize];
        for(int i = 0; i < xSize; i++){
            //pawns
            board[i][1] = new Chesspiece(PieceColour.WHITE, PieceType.PAWN);
            board[i][ySize - 2] = new Chesspiece(PieceColour.BLACK, PieceType.PAWN);
            //pieces
            board[i][0] = new Chesspiece(PieceColour.WHITE, pieces[i]);
            board[i][ySize - 1] = new Chesspiece(PieceColour.BLACK, pieces[i]);
        }
    }

    public Chesspiece[][] getBoard(){
        return board;
    }

    public void displayBoard(){

        for(int y = ySize + 1; y >= 0; y--){
            for(int x = 0; x <= xSize; x++){
                if(y < ySize && x < xSize){
                    Chesspiece selected = board[x][y];
                    if(selected != null){
                        System.out.print(selected.getDisplayC());
                    } else{
                        System.out.print(spacing);
                    }
                    System.out.print(spacing);
                }

                else{
                    if(y == ySize && x < xSize){
                        System.out.print('-' + spacing);
                    }
                    if(x == xSize && y < ySize){
                        System.out.print('|' + spacing);
                        System.out.print(y + 1);
                    }
                    if(y == ySize + 1 && x < xSize){
                        System.out.print(header[x] + spacing);
                    }
                }
            }
            System.out.println();
        }

        /*
        for(int y = ySize - 1; y >= 0; y--) {
            for (int x = 0; x < xSize; x++) {
                Chesspiece selected = board[x][y];
                if(selected != null){
                    System.out.print(selected.getDisplayC());
                } else{
                    System.out.print(spacing);
                }
                System.out.print(spacing);
            }
            System.out.println();
        }

         */
    }
}
