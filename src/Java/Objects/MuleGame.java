package Java.Objects;

/**
 * Created by AveryDingler on 9/8/15.
 */
public class MuleGame {

    public Player[] players;
    public String difficulty;
    public Map map;

    public MuleGame(String difficulty, Map map, Player[] players ) {
        this.difficulty = difficulty;
        this.map = map;
        this.players = players;

    }
    public Player[] getPlayers() {
        return players;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Map getMap() {
        return map;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
