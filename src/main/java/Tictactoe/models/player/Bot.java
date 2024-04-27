package Tictactoe.models.player;

public final class Bot extends Player {
    private BotDifficultyLevel botDificultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDificultyLevel) {
        super(name, symbol, playerType);
        this.botDificultyLevel = botDificultyLevel;
    }

    public void setBotDificultyLevel(BotDifficultyLevel botDificultyLevel) {
        this.botDificultyLevel = botDificultyLevel;
    }
}
