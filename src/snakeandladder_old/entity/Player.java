package snakeandladder_old.entity;

public class Player {
    int position;
    String playerName;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }



    public Player(int position, String playerName) {
        this.position = position;
        this.playerName = playerName;
    }
}
