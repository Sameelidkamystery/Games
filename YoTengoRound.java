
public class YoTengoRound {
    public static final String RESET = "\u001B[0m";
    public static final String BLUE_TEXT = "\u001B[34m";
    public static final String CYAN_TEXT = "\u001B[36m";
    public static final String BLACK_TEXT = "\u001B[31m";
    public static final String RED_TEXT = "\u001B[32m";
    public static final String WHITE_TEXT = "\u001B[37m";
    public static final String GREEN_TEXT = "\u001B[33m";
    public static final String YELLOW_TEXT = "\u001B[30m";
    public static final String MAGENTA_TEXT = "\u001B[35m";
    
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String MAGENTA_BACKGROUND = "\u001B[45m";
    int wager;
    int chance;
    int multiplier;
    int inRounds;

    public YoTengoRound(int difficulty, int round, int coins) {
        wager = Helper.tools.getRandomNumber(1, coins);
        chance = Helper.tools.getRandomNumber((int) Helper.tools.getRandomNumber( (int) 100/round, (int) 30/difficulty),99);

        if (difficulty == 3) {
            chance = Helper.tools.getRandomNumber((int) Helper.tools.getRandomNumber( (int) 100/round, (int) 30/difficulty),Helper.tools.getRandomNumber(60,Helper.tools.getRandomNumber(90,99)));
        }
        else if (difficulty == 2) {
            chance = Helper.tools.getRandomNumber((int) Helper.tools.getRandomNumber( (int) 100/round, (int) 30/difficulty),Helper.tools.getRandomNumber(80,99));
        }
        else {
            chance = Helper.tools.getRandomNumber((int) Helper.tools.getRandomNumber( (int) 100/round, (int) 30/difficulty),99);
        }
        
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

        if ((wager*multiplier) < 0) {
            System.out.println(RED_TEXT+"YOU ARE IN DANGER!\nYOUR GREED GOT THE BEST OF YOU AND THE GODS ARE SMITING YOU FOR IT!!!\nGET OUT AS SOON AS POSSIBLE");
        }

        System.out.println(GREEN_TEXT+"If you wager " + wager + " coins, you could get " + multiplier*wager + " coins.");
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
            System.out.println(RED_TEXT+"You lost " + wager + " coins");
            return (wager*-1);
        }
        else {
            System.out.println(GREEN_TEXT+"You gained " + wager*multiplier + " coins");
            return wager*multiplier;
        }
    }

}
