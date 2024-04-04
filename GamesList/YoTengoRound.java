
public class YoTengoRound {
    int wager;
    int chance;
    int multiplier;
    int inRounds;

    public YoTengoRound(int difficulty, int round, int coins) {
        wager = Helper.tools.getRandomNumber(1, coins);
        chance = Helper.tools.getRandomNumber((int) Helper.tools.getRandomNumber( (int) 100/round, (int) 30/difficulty),99);
        
        if (difficulty == 3) {
            multiplier = Helper.tools.getRandomNumber(2,Helper.tools.getRandomNumber(2,Helper.tools.getRandomNumber(3,4)));
        }
        else if (difficulty == 2) {
            multiplier = Helper.tools.getRandomNumber(2,Helper.tools.getRandomNumber(3,4));
        }
        else {
            multiplier = Helper.tools.getRandomNumber(2,4);
        }
        inRounds = Helper.tools.getRandomNumber(0, difficulty+1);
        System.out.println("If you wager " + wager + " coins, you could get " + multiplier*wager + " coins.");
        System.out.println("The chances of getting this number is " + chance + "/100");
        System.out.println("You can test this in " + inRounds + " rounds.");
        Helper.tools.waiting(10);
    }

    public int getRounds() {
        return inRounds;
    }

    public void advanceRound() {
        inRounds--;
    }

    public int Bet() {
        if (Helper.tools.getRandomNumber(1,100)>chance) {
            System.out.println("You lost " + wager + " coins");
            return (wager*-1);
        }
        else {
            System.out.println("You gained " + wager*multiplier + " coins");
            return wager*multiplier;
        }
    }

}
