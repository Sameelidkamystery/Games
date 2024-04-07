package Helper;
import java.util.Scanner;
import java.lang.Thread;

public final class tools {
    
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
    /**
    @param min minimum value
    @param max maximum value
    @param prompt prompt to display to the user
    @return an integer from the user
     */
    public static int getInteger(int min, int max, String prompt) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print(prompt);
            int number = input.nextInt();
            if (number < min || number > max) {
                System.out.print(CYAN_TEXT+"Please enter a number between " + min + " and " + max + ".\n");
                return getInteger(min, max,prompt);
            } else {
                return number;
            }
        }
        catch (Exception e) {
            System.out.print(RED_TEXT+"Please enter a number between " + min + " and " + max + ":\n");
            return getInteger(min, max,prompt);
        }
    }

    /**
    @param prompt prompt to display to the user
    @return a string from the user
     */
    public static String getString(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(CYAN_TEXT+prompt);
        String inputString = input.nextLine();
        return inputString;
        }
    /**
     * @param min minimum value
     * @param max maximum value
     * @param prompt prompt to display to the user
     * @return a double from the user
     */
    public static double getDouble(double min, double max, String prompt) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print(prompt);
            double number = input.nextDouble();
            if (number < min || number > max) {
                System.out.print(CYAN_TEXT+"Please enter a number between " + min + " and " + max + ".\n");
                return getDouble(min, max, prompt);
            } else {
                return number;
            }
        }
        catch (Exception e) {
            System.out.print(CYAN_TEXT+"Please enter a number between " + min + " and " + max + ":\n");
            return getDouble(min, max, prompt);
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void waiting(int timeMili) {
        try {
            Thread.sleep(timeMili);
        }
        catch (InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }

    public static String getRandomFrom(String[] strings) {
        return (strings[getRandomNumber(0, strings.length-1)]);
    }
}
