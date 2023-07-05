package boardGame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("The board must to have 1 row and 1 column at least.");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!isThisPositionExists(row, column)) {
            throw new BoardException("The position not exists on the board.");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!isThisPositionExists(position)) {
            throw new BoardException("The position not exists on the board.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void insertPiece(Piece piece, Position position) {
        if (isThereAChessPiece(position)) {
            throw new BoardException("The position already have a chess piece.");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean isThisPositionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean isThisPositionExists(Position position) {
        return isThisPositionExists(position.getRow(), position.getColumn());
    }

    public boolean isThereAChessPiece(Position position) {
        if (!isThisPositionExists(position)) {
            throw new BoardException("The position not exists on the board.");
        }
        return piece(position) != null;
    }
}
