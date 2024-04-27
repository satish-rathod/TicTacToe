package Tictactoe.logic;

import Tictactoe.models.game.Board;
import Tictactoe.models.move.Move;

import java.util.HashMap;
import java.util.Map;

public class GameLogic {

    Map<Integer, Map<Character, Long>> rowSymbolCounts = new HashMap<>();
    Map<Integer, Map<Character, Long>> columnSymbolCounts = new HashMap<>();
    Map<Character, Long> leftDiagonalSymbolCounts = new HashMap<>();
    Map<Character, Long> rightDiagonalSymbolCounts = new HashMap<>();

    public boolean isWinner(Board gameBoard, Move playerMove) {
        int moveRow = playerMove.getCell().getRow();
        int moveColumn = playerMove.getCell().getCol();
        Character playerSymbol = playerMove.getPlayer().getSymbol().getSymbol();

        incrementSymbolCount(rowSymbolCounts, moveRow, playerSymbol);
        if (rowSymbolCounts.get(moveRow).get(playerSymbol) == gameBoard.getSize()) {
            return true;
        }

        incrementSymbolCount(columnSymbolCounts, moveColumn, playerSymbol);
        if (columnSymbolCounts.get(moveColumn).get(playerSymbol) == gameBoard.getSize()) {
            return true;
        }

        if (moveRow == moveColumn) {
            incrementSymbolCount(leftDiagonalSymbolCounts, playerSymbol);
            return leftDiagonalSymbolCounts.get(playerSymbol) == gameBoard.getSize();
        }

        if (moveRow + moveColumn == gameBoard.getSize() - 1) {
            incrementSymbolCount(rightDiagonalSymbolCounts, playerSymbol);
            return rightDiagonalSymbolCounts.get(playerSymbol) == gameBoard.getSize();
        }

        return false;
    }

    private void incrementSymbolCount(Map<Integer, Map<Character, Long>> symbolCounts, int key, Character symbol) {
        symbolCounts.computeIfAbsent(key, k -> new HashMap<>()).merge(symbol, 1L, Long::sum);
    }

    private void incrementSymbolCount(Map<Character, Long> symbolCounts, Character symbol) {
        symbolCounts.merge(symbol, 1L, Long::sum);
    }
}