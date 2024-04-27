package Tictactoe.controller;

import Tictactoe.exception.InvalidMoveException;
import Tictactoe.models.game.Game;
import Tictactoe.models.game.GameState;
import Tictactoe.models.player.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players) {
        return new Game(dimension, players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        System.out.println(game);
    }
}
