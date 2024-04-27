package Tictactoe.models.cell;

import Tictactoe.models.player.Player;

public final class Cell {
    private int row;
    private int col;
    private CellStatus state;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.state = CellStatus.EMPTY;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellStatus getState() {
        return state;
    }

    public void setState(CellStatus state) {
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
