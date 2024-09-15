package util;

public class ClearScreen {

    public static void clear() {
        // Clear the console screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
