package Tictactoe;

import Tictactoe.controller.GameController;
import Tictactoe.exception.InvalidMoveException;
import Tictactoe.models.game.Game;
import Tictactoe.models.game.GameState;
import Tictactoe.models.player.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameController gameControllerInstance = new GameController();

        int gameDimension = 3;
        List<Player> gamePlayers = List.of(new Player("Satish", new Symbol('X'), PlayerType.HUMAN), new Bot("Bot", new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.EASY));

        Game currentGame = gameControllerInstance.startGame(gameDimension, gamePlayers);

        try {
            while (GameState.IN_PROGRESS.equals(currentGame.getState())) {
                gameControllerInstance.printBoard(currentGame);
                gameControllerInstance.makeMove(currentGame);
            }
        }
        catch (InvalidMoveException e) {
            System.out.println(e.getMessage());
        }

        if (!GameState.ENDED.equals(gameControllerInstance.checkState(currentGame))) {
            currentGame.setState(GameState.DRAW);
            System.out.println("Game DRAW");
        } else {
            gameControllerInstance.printBoard(currentGame);
            System.out.println("Player " + gameControllerInstance.getWinner(currentGame).getName() + " is the winner");
        }
    }
}