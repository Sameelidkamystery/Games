public class Main {

    public static void main(String[] args) {
        String[] gamesArr = {"Memory Overloader","Yo Tengo", "Mountain Glider","Dance Macabre", "Ice Scooper", "Witch Run?"};
        int[] gameScores = new int[gamesArr.length];
        int difficulty = Helper.tools.getInteger(1,3,"Pick the level of difficulty you want to play (1-3): ");
        Games game1 = new Games(difficulty);
        Helper.tools.waiting(500);
        String characterName = Helper.tools.getString("\nWhat is your name? ");
        Helper.tools.waiting(500);
        System.out.println("\nWelcome " + characterName + "!\n");
        Helper.tools.waiting(500);
        while (true) {
            for (int i = 0; i < gameScores.length; i++) {
                System.out.println((i+1) + "       " + gamesArr[i]);
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
            System.out.println("Thats a New High Score " + name);
            System.out.println("New High Score: " + newestScore);
            gameScoresArr[index] = newestScore;
        }
        else if (newestScore <= gameScoresArr[index] && newestScore+(gameScoresArr[index]*0.1) >= gameScoresArr[index]) {
            System.out.println("Almost there, " + name);
            System.out.println("High Score: " + gameScoresArr[index]);
        }
    }

}

