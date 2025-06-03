package model;

public class Rook extends ChessPiece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        // Movimento reto na horizontal ou vertical
        if (fromRow == toRow || fromCol == toCol) {
            // Verificar se há obstáculos no caminho
            if (!hasObstacle(fromRow, fromCol, toRow, toCol, board)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasObstacle(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int rowStep = Integer.compare(toRow, fromRow);
        int colStep = Integer.compare(toCol, fromCol);
        int r = fromRow + rowStep, c = fromCol + colStep;

        while (r != toRow || c != toCol) {
            if (board[r][c] != null) return true;
            r += rowStep;
            c += colStep;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return white ? "♖" : "♜";
    }
}