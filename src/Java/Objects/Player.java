package Java.Objects;

import java.util.Objects;

/**
 * Created by AveryDingler on 9/8/15.
 */
public class Player {

    public String name;
    public String race;
    public int food;
    public int energy;
    public int ore;
    public int money;

    //beginner
    //standard
    //tournament

    public Player(String name, String race, String difficulty) {
        this.name = name;
        this.race  = race;
        if (Objects.equals(difficulty, "Beginner")) {
            food = 8;
            energy = 4;
            ore = 0;
        } else if (Objects.equals(difficulty, "Standard")) {
            food = 4;
            energy = 2;
            ore = 0;
        } else {
            food = 4;
            energy = 2;
            ore = 0;
        }
        if (Objects.equals(race, "Flapper")) {
            money = 1600;
        } else if (Objects.equals(race, "Human")) {
            money = 600;
        } else {
            money = 100;
        }
    }

}
