package Tictactoe.models.game;

import Tictactoe.models.cell.Cell;

import java.util.ArrayList;
import java.util.List;

public final class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        board = new ArrayList<>();
        this.size = size;
        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(i, j));
            }
            board.add(row);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
    public Cell getCell(int row, int col) {
        return board.get(row).get(col);
    }

    public void setCell(int row, int col, Cell cell) {
        board.get(row).set(col, cell);
    }


}
