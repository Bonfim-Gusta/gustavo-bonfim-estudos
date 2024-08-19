package chess;

import boardgame.Board;
import boardgame.Position;
import chess.enums.Color;
import chess.pieces.King;
import chess.pieces.Rock;

public class ChessMatch {
    private Board board;

    public ChessMatch(){
        board = new Board(8,8);
        initalSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece)board.piece(i,j);
            }
        }

        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece chessPiece){
        board.placePiece(chessPiece, new ChessPosition(column, row).toPosition());
    }

    private void initalSetup() {
        placeNewPiece('a', 5, new King(board, Color.BLACK));
        placeNewPiece('b', 8, new Rock(board, Color.BLACK));
    }
}
