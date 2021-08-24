import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            String playerOne;
            String playerTwo;
            boolean play = true;

            System.out.println("Player One: ");
            playerOne = scanner.nextLine();
            while (play) {
                if (!search(playerOne)) {
                    System.out.println("That word does not exist, enter new one!");
                    playerOne = scanner.nextLine();
                } else {
                    break;
                }
            }

            play = true;
            System.out.println("Player Two: ");
            playerTwo = scanner.nextLine();
            while (play) {
                if (!search(playerTwo)) {
                    System.out.println("That word does not exist, enter new one!");
                    playerTwo = scanner.nextLine();
                } else {
                    break;
                }
            }

            if (check(playerOne, playerTwo)) {

            } else {
                System.out.println("Player One is the winner!");
                break;
            }

            play = true;
            System.out.println("Player One: ");
            String c = scanner.nextLine();
            while (play) {
                if (!search(c)) {
                    System.out.println("That word does not exist, enter new one!");
                    c = scanner.nextLine();
                } else {
                    break;
                }
            }

            if (check(playerTwo, c)) {
            } else {
                System.out.println("Player Two is the winner!");
                break;
            }

            play = true;
            System.out.println("Player Two ");
            String d = scanner.nextLine();
            while (play) {
                if (!search(d)) {
                    System.out.println("That word does not exist, enter new one!");
                    d = scanner.nextLine();
                } else {
                    break;
                }
            }

            if (check(c, d)) {
            } else {
                System.out.println("Player One is the winner!");
                break;
            }
        }

    }


    public static boolean check(String first, String second) {

        char[] a = first.toCharArray();
        char[] b = second.toCharArray();
        int length = first.length();
        int j = 0;
        for (int i = length - 2; i < length; i++) {
            if (a[i] == b[j]) {
                j++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean search(String word) throws IOException {
        //Enter the path of your file that contains words to use in game
        long count = Files.lines(Paths.get("C:\\...\\...\\...\\words.txt"))
                .filter(s -> s.matches(word))
                .count();
        if (count > 0) {
            return true;
        } else {
            return false;
        }

    }


}
