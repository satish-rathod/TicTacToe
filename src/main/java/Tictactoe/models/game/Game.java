package Tictactoe.models.game;

import Tictactoe.exception.InvalidMoveException;
import Tictactoe.models.player.Player;
import Tictactoe.logic.GameLogic;
import Tictactoe.models.cell.Cell;
import Tictactoe.models.cell.CellStatus;
import Tictactoe.models.move.Move;

import java.util.ArrayList;
import java.util.List;

public final class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int currentPlayerIndex;
    private Player winner;
    private GameState state;
    private GameLogic winningAlgorithm;

    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.currentPlayerIndex = 0;
        this.state = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        winningAlgorithm = new GameLogic();
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            return false;
        }

        return board.getCell(row, col).getState() == CellStatus.EMPTY;
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(this.getCurrentPlayerIndex());

        System.out.println("It is " + currentPlayer.getName() + "'s move.");

        Move move = currentPlayer.makeMove(board);

        if (!validateMove(move)) {
            throw new InvalidMoveException("Invalid move made by " + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setState(CellStatus.Filled);

        Move finalMove = new Move(cellToChange, currentPlayer);
        moves.add(finalMove);
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();

        if (winningAlgorithm.isWinner(board, finalMove)) {
            state = GameState.ENDED;
            winner = currentPlayer;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                sb.append((board.getCell(i, j).getState() == CellStatus.EMPTY ? "..." : " " + board.getCell(i, j).getPlayer().getSymbol().getSymbol() + " "));
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
