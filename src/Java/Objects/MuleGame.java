package Java.Objects;

import java.util.Random;

/**
 * Created by AveryDingler on 9/8/15.
 */
public class MuleGame {

    public Player[] players;
    public String difficulty;
    public Map map;
    private int round = 0;
    private int price;

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

    public void setPrice(int round) {
        Random rng = new Random();
        if (round <= 2) {
            price = 0;
        } else {
            price = 300 + (round * rng.nextInt(101));
        }
    }

    public int getPrice() { return price; }

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
