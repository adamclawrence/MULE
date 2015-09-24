package Java.Objects;

import java.util.Objects;

/**
 * Created by AveryDingler on 9/8/15.
 */
public class Player {

    public String name;
    public String race;
    public String color;
    public int food;
    public int energy;
    public int ore;
    public int money;
    public int landCounter;
    private int score;
    private boolean isLast;

    //beginner
    //standard
    //tournament

    public Player(String name, String race, String difficulty, String color) {
        this.color = color;
        this.name = name;
        this.race  = race;
        this.score = 0;
        if (difficulty.contains("Beginner")) {
            food = 8;
            energy = 4;
            ore = 0;
        } else if (difficulty.contains("Standard")) {
            food = 4;
            energy = 2;
            ore = 0;
        } else {
            food = 4;
            energy = 2;
            ore = 0;
        }
        if (race.contains("Flapper")) {
            money = 1600;
        } else if (race.contains("Human")) {
            money = 600;
        } else {
            money = 100;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public String getColor() {
        return color;
    }

    public void incLandCounter() {
        landCounter++;
    }

    public void refreshScore() {
        int newScore = 0;
        newScore += landCounter * 500;
        newScore += money;
        newScore += energy;
        newScore += food;
        newScore += ore;
        score = newScore;
    }

    public int getScore() {
        return score;
    }

    public boolean getIsLast() {
        return isLast;
    }

    public void setIsLast(boolean value) {
        isLast = value;
    }
}
