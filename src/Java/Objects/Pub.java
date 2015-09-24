package Java.Objects;
import java.util.Random;
/**
 * Created by AveryDingler on 9/8/15.
 */
public class Pub {
    //take in player time, round number
    //round bonus
    //1-3 are 50
    //4-7 are 100
    //8-11 are 150
    //12 is 200
    //max gambling money is 250 per round
    //bonus = round bonus * random # between 0 and time bonus
    //time bonus
    //37-50 =200
    //25-37=150
    //12-25=100
    //0-12=50
    public int gamble(int pTime, int round) {
        Random randy = new Random();
        int timeBonus = 0;
        int roundBonus = 0;
        if (pTime >= 37 && pTime <= 50) {
            timeBonus = 200;
        } else if (pTime <= 37 && pTime >= 25) {
            timeBonus = 150;
        } else if (pTime <= 25 && pTime >= 12) {
            timeBonus = 100;
        } else {
            timeBonus = 50;
        }

        if (round > 11) {
            roundBonus = 200;
        } else if (round <= 11 && round >= 8) {
            roundBonus = 150;
        } else if (round < 8 && round >= 4 ) {
            roundBonus = 100;
        } else {
            roundBonus = 50;
        }
        //I feel like the formula posted is wrong(what is beneath this)
        //it will almost always give out 250. the minimum round bonus is
        //50. and the random number is between 0 and 250.
        //so unless the number is 4 or lower, it will always be an output
        //of 250 (the limit)
        int bonus = roundBonus * randy.nextInt(timeBonus + 1);
        System.out.println(bonus);
        if (bonus > 250){
            bonus = 250;
        }
        return bonus;
    }
}
