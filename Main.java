public class Main {
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
    public static void main(String[] args) {
        String[] gamesArr = {"Memory Overloader","Yo Tengo        ", "Mountain Glider ","Dance Macabre   ", "Ice Scooper     ", "Witch Run?      "};
        int[] gameScores = new int[gamesArr.length];
        int difficulty = Helper.tools.getInteger(1,3,"Pick the level of difficulty you want to play (1-3): ");
        Games game1 = new Games(difficulty);
        Helper.tools.waiting(500);
        String characterName = Helper.tools.getString("\nWhat is your name? ");
        Helper.tools.waiting(500);
        System.out.println(WHITE_TEXT+"\nWelcome " + characterName + "!\n");
        Helper.tools.waiting(500);
        while (true) {
            System.out.println(WHITE_TEXT + "You are playing on level " + difficulty + " difficulty");
            for (int i = 0; i < gameScores.length; i++) {
                System.out.println((i+1) + "\t" + gamesArr[i] + "\t" + gameScores[i]);
                Helper.tools.waiting(500);
            }
            int select = (Helper.tools.getInteger(1, gamesArr.length, "\nWhich game would you like to play? (1-" + gamesArr.length + ") ")-1);
            
            if (gamesArr[select].equals(gamesArr[0])) {
                scoreCalc(game1.MemOvr(),0,gameScores,characterName);
            }
            else if (gamesArr[select].equals(gamesArr[1])) {
                scoreCalc(game1.YoTengo(),1,gameScores,characterName);
            }
            else if (gamesArr[select].equals(gamesArr[2])) {
            }
            else if (gamesArr[select].equals(gamesArr[3])) {
                
            }
            else if (gamesArr[select].equals(gamesArr[4])) {
            }
            else if (gamesArr[select].equals(gamesArr[5])) {
            }
            

        }
    }
    public static void scoreCalc(int newestScore, int index, int[] gameScoresArr, String name) {
        if (newestScore > gameScoresArr[index]) {
            System.out.println(GREEN_BACKGROUND+"Thats a New High Score " + name);
            System.out.println(RESET+WHITE_TEXT+"New High Score: " + newestScore);
            gameScoresArr[index] = newestScore;
        }
        else if (newestScore <= gameScoresArr[index] && newestScore+(gameScoresArr[index]*0.1) >= gameScoresArr[index]) {
            System.out.println(YELLOW_BACKGROUND+"Almost there, " + name);
            System.out.println(RESET+WHITE_TEXT+"High Score: " + gameScoresArr[index]);
        }
        else {
            System.out.println(RED_BACKGROUND+"You suck");
            System.out.println(RESET+WHITE_TEXT+"High Score: " + gameScoresArr[index]);
        }
    }

}

