
import java.util.ArrayList;

public class Games {
    int difficulty;
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

    public Games(int aDifficulty) {
        difficulty = aDifficulty;
    }

    public int MemOvr() {
        String[][] memoryChoicesArr = { {"apple", "banana", "orange", "kiwi", "pineapple", "watermelon", "grape",
    "strawberry", "blueberry", "guava", "fig", "mango"}, {"tomato", "corn", "lettuce", "pumpkin", "cucumber", "celery", "zucchini",
    "potato", "spinach", "eggplant", "bean", "pepper"}, {"red", "orange", "yellow", "green", "blue", "violet", "white", "black",
    "brown", "grey", "pink", "lime"} };
        int score = 0;
        ArrayList<String> toRemember = new ArrayList<String>();
        System.out.println(WHITE_TEXT+"Memory Overloader!");

        System.out.println("You will get " + difficulty + " words to remember per round");

        while (true) {
            for (int i = 0; i < difficulty; i++) {
                toRemember.add(memoryChoicesArr[i][Helper.tools.getRandomNumber(0, memoryChoicesArr[i].length - 1)]);
            }
            System.out.println(WHITE_TEXT+"These are your words to remember:\n");
            for (String element : toRemember) {
                System.out.println(GREEN_TEXT+element);
                Helper.tools.waiting(1000);
            }
            System.out.println(WHITE_TEXT+"__________________________________");
            System.out.println("Five");
            Helper.tools.waiting(1000);;
            System.out.println("Four");
            Helper.tools.waiting(1000);
            System.out.println("Three");
            Helper.tools.waiting(1000);
            System.out.println("Two");
            Helper.tools.waiting(1000);
            System.out.println("One");
            Helper.tools.waiting(1000);
            System.out.print("\033[H\033[2J");
            Boolean correct = true;
            int x = 1;

            for (String words : toRemember) {
                if (correct) {
                    String user_guess = Helper.tools.getString(WHITE_TEXT+"Enter word number"+x+": ");
                    x++;
                    if (user_guess.equalsIgnoreCase(words)) {
                        System.out.println(GREEN_TEXT+"Correct");
                    }
                    else {
                        correct = false;
                        System.out.println(RED_TEXT+"Incorrect");
                    }
                }
                else {
                    break;
                }
            
            }

            Helper.tools.waiting(1000);
            System.out.print("\033[H\033[2J");
            Helper.tools.waiting(1000);

            if (correct) {
                score++;
            }
            else {
                System.out.println (WHITE_TEXT+"The correct answers were: ");
                for (String words : toRemember) {
                    System.out.println(YELLOW_TEXT+words);
                    Helper.tools.waiting(500);
                }
                System.out.print("\033[H\033[2J");
                break;
            }

        }

        return score;
    }

    public int YoTengo() {
        int coins = 30/difficulty;
        int hiScore = coins;
        int round = 1;
        int score = 0;

        String[] AztexGodsForYes = {"Ahluic (The god of merchants and material wealth) ", "Acan (The god of intoxication, wine, and the art of brewing Balche) ","F (A god of war associated with human sacrifice and repeated victories over Ekchuah) "};
        String[] AztexGodsForNo = {"Ah-Chun-Cann (The god of protection at dusk and dawn ","Ah-Mun (The god of fertility and protection) ","The B\'alam (The Jaguar deities who protect individual communities against external threat.) "};

        ArrayList<YoTengoRound> YoTengoRoundOffers = new ArrayList<YoTengoRound>();
        ArrayList<String> InputList = new ArrayList<String>();
        
        System.out.print("\033[H\033[2J");
        System.out.println(WHITE_TEXT+"Yo Tengo!!!");
        System.out.println("You start with " + (30/difficulty) + " coins. \nYour task is to get as much coins as possible.");
        System.out.println("You can only say no " + (6-difficulty) + " times in a row.\n");
        System.out.print("\nThere are however certain gods that have taken an interest in you, watch out\n");
        Helper.tools.waiting(4000);
        System.out.print("\n \n");

        while (coins > 0) {
            if (Helper.tools.getRandomNumber(1,20) == 1) {
                System.out.println(YELLOW_TEXT+Helper.tools.getRandomFrom(AztexGodsForYes) + "decides to smite you. \nBye Bye coins (You lose half your coins).\n");
                coins /= 2;
            }
            else if (Helper.tools.getRandomNumber(1,20) == 1) {
                System.out.println(YELLOW_TEXT+Helper.tools.getRandomFrom(AztexGodsForNo) + "takes pity on you.\n Be thankful (You double your coins).\n");
                coins *= 2;
            }
            score = (int) hiScore/(round*10);
            System.out.println(WHITE_TEXT + "You have " + coins + " coins. \nHighest Coin Score: " + hiScore + "\nRound " + round);
            System.out.println("Score: " + score);
            YoTengoRoundOffers.add(new YoTengoRound(difficulty,round,coins));
            boolean tooManyNos = true;
            Boolean NoCheck = true;
            Boolean ForGodsSake = false;
            while (tooManyNos) {
                String input;
                if (Helper.tools.getRandomNumber(1,10) == 1) {
                    System.out.println();
                    System.out.println(YELLOW_TEXT+Helper.tools.getRandomFrom(AztexGodsForYes) + " fills you with the need to risk it. \nYou accept this deal despite your best judgment.");
                    Helper.tools.waiting(1500);
                    input = "y";
                    ForGodsSake = true;
                    Helper.tools.getString("Click enter to continue ");

                }
                else if (Helper.tools.getRandomNumber(1,10) == 1) {
                    System.out.println();
                    System.out.println(YELLOW_TEXT+Helper.tools.getRandomFrom(AztexGodsForNo) + " protects you from that stupid need to bet. \nYou reject this deal despite your best judgment.");
                    Helper.tools.waiting(1500);
                    input = "n";
                    ForGodsSake = true;
                    Helper.tools.getString("Click enter to continue ");
                }
                else {
                    input = Helper.tools.getString("Do you accept this deal? (y or n) ");
                }
                if (input.equals("n")) {
                    if (round < (6-difficulty)) {
                        NoCheck = false;
                    }
                    if (ForGodsSake){
                        NoCheck = false;
                    }
                    if (NoCheck) {
                        for (String s : InputList) {
                            if (s.equals("y")) {
                                YoTengoRoundOffers.remove(YoTengoRoundOffers.size()-1);
                                InputList.add("n");
                                tooManyNos = false;
                                break;
                            }
                        }
                        if (tooManyNos) {
                            Helper.tools.waiting(500);
                            System.out.println("You have rejected too many rounds, you must accept this deal");
                        }
                    }
                    else {
                        YoTengoRoundOffers.remove(YoTengoRoundOffers.size()-1);
                        InputList.add("n");
                        tooManyNos = false;
                    }
                }
                else if (input.equals("y")) {
                    InputList.add("y");
                    tooManyNos = false;
                }
                else {
                    System.out.println("Please enter either y or n");
                }
            }
            int i = 0;
            while (i < YoTengoRoundOffers.size()) {
                if ((YoTengoRoundOffers.get(i)).getRounds() == 0) {
                    coins += YoTengoRoundOffers.get(i).Bet();
                    YoTengoRoundOffers.remove(i);
                }
                else {
                    i++;
                }
            }
            for (YoTengoRound o : YoTengoRoundOffers) {
                o.advanceRound();
            }
            round++;
            if (coins > hiScore) {
                hiScore = coins;
            }
            Helper.tools.waiting(3000);
            System.out.print("\033[H\033[2J");

            if (InputList.size() > 6-difficulty) {
                InputList.remove(0);
            }
        }

        return score;
    }

}
