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


}
