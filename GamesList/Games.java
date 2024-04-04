
import java.util.ArrayList;

public class Games {
    int difficulty;

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
        System.out.println("Memory Overloader!");

        System.out.println("You will get " + difficulty + " words to remember per round");

        while (true) {
            for (int i = 0; i < difficulty; i++) {
                toRemember.add(memoryChoicesArr[i][Helper.tools.getRandomNumber(0, memoryChoicesArr[i].length - 1)]);
            }
            System.out.println("These are your words to remember:\n");
            for (String element : toRemember) {
                System.out.println(element);
                Helper.tools.waiting(1000);
            }
            System.out.println("__________________________________");
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
                    String user_guess = Helper.tools.getString("Enter word number"+x+": ");
                    x++;
                    if (user_guess.equalsIgnoreCase(words)) {
                        System.out.println("Correct");
                    }
                    else {
                        correct = false;
                        System.out.println("Incorrect");
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
                System.out.println ("The correct answers were: ");
                for (String words : toRemember) {
                    System.out.println(words);
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
        ArrayList<YoTengoRound> YoTengoRoundOffers = new ArrayList<YoTengoRound>();
        
        System.out.print("\033[H\033[2J");
        System.out.println("Yo Tengo!!!");
        System.out.println("You start with " + (30/difficulty) + " coins. \nYour task is to get as much coins as possible.\n");
        Helper.tools.waiting(3000);
        System.out.print("\n \n");

        while (coins > 0) {
            score = (int) hiScore/(round*10);
            System.out.println("You have " + coins + " coins. \nHighest Coin Score: " + hiScore + "\nRound " + round);
            System.out.println("Score: " + score);
            YoTengoRoundOffers.add(new YoTengoRound(difficulty,round,coins));
            String input = Helper.tools.getString("Do you accept this deal? (y or n) ");
            if (input.equals("n")) {
                YoTengoRoundOffers.remove(YoTengoRoundOffers.size()-1);
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
        }

        return score;
    }

}
