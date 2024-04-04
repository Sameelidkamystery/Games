package Helper;
import java.util.Scanner;
import java.lang.Thread;

public final class tools {    
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
                System.out.println("Please enter a number between " + min + " and " + max + ".\n");
                return getInteger(min, max,prompt);
            } else {
                return number;
            }
        }
        catch (Exception e) {
            System.out.println("Please enter a number between " + min + " and " + max + ":\n");
            return getInteger(min, max,prompt);
        }
    }

    /**
    @param prompt prompt to display to the user
    @return a string from the user
     */
    public static String getString(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
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
                System.out.println("Please enter a number between " + min + " and " + max + ".\n");
                return getDouble(min, max, prompt);
            } else {
                return number;
            }
        }
        catch (Exception e) {
            System.out.println("Please enter a number between " + min + " and " + max + ":\n");
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
}
