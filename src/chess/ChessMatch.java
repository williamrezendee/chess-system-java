package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                matrix[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return matrix;
    }

    private void initialSetup() {
        board.insertPiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.insertPiece(new King(board, Color.BLACK), new Position(0, 4));
        board.insertPiece(new King(board, Color.WHITE), new Position(7, 4));
    }
}