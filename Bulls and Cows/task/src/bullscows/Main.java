package bullscows;

import java.util.*;

public class Main {
    public static int length = 0;
    public static int symbolsLength = 0;
    public static String s1 = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        // long pseudoRandomNumber = System.nanoTime();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please, enter the secret code's length:");
            length = scanner.nextInt();

            System.out.println("Input the number of possible symbols in the code:");
            symbolsLength = scanner.nextInt();

            if(length == 0) {
                System.out.println("Error: it's not possible to generate a code with a length of " + length + " with "
                        + symbolsLength + "  unique symbols.");
            }
            else if (length > symbolsLength) {
                System.out.println("Error: it's not possible to generate a code with a length of " + length + " with "
                        + symbolsLength + "  unique symbols.");
            }
            else if (symbolsLength > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            } else {
                String original = generateRandomDigits();
                String x = "";
                for (int i = 0; i < length; i++) {
                    x = x + "*";
                }
                // informing about the code length and values used in the code.
                System.out.println("The secret is prepared:" + x + " (0-9,a-" + s1.charAt(symbolsLength - 1) + ")");
                System.out.println("Okay, let's start a game!");
                int i = 0;
                while (true) {
                    System.out.println("Turn " + (++i));
                    String verify = scanner.next();
                    char[] o = original.toCharArray();
                    // System.out.println(original.length());
                    char[] a = verify.toCharArray();
                    // for(int j=0;j<a.length;j++) {
                    // System.out.println("i:" + j + " " + a[j]);
                    // } System.out.println(verify.length());
                    int cows = checkingForCows(o, a);
                    int bulls = checkingForBulls(o, a);
                    cows = cows - bulls;
                    if (cows > 0 && bulls > 0)
                        System.out.println(bulls + " bulls and " + cows + " cow");
                    else if (cows > 0)
                        System.out.println(cows + " cows");
                    else if (cows == 1 && bulls < 0)
                        System.out.println(cows + " cow");
                    else if (cows == 1 && bulls == 1)
                        System.out.println(bulls + " bull and " + cows + " cow");
                    else if (cows > 1 && bulls == 1)
                        System.out.println(bulls + " bull and " + cows + " cows");
                    else if (bulls == length) {
                        System.out.println(bulls + " bulls");
                        System.out.println("Congratulations! You guessed the secret code.");
                        break;
                    } else {
                        System.out.println(bulls + " bulls");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + length + " isn't a valid number");
        }

        scanner.close();

    }

    //generates random characters from the selected String, with defined length
    public static String generateRandomDigits() {
        ArrayList<Character> list = new ArrayList<Character>();
        Random random = new Random();
        String s1 = "0123456789abcdefghijklmnopqrstuvwxyz";
        String s = "";
        while (true) {
            char value = s1.charAt(random.nextInt(symbolsLength));
            if (!list.contains(value)) {
                list.add(value);
                s = s + value;
            }
            if (list.size() == length)
                break;
        }
        return s;
    }

    public static int checkingForCows(char[] o, char[] a) {
        int count = 0;
        for (int i = 0; i < o.length; i++)
            for (int j = 0; j < a.length; j++)
                if (o[i] == a[j]) {

                    count++;
                }

        if (count == 0)
            return 0;
        else
            return count;
    }

    public static int checkingForBulls(char[] o, char[] a) {
        int count = 0;
        for (int i = 0; i < o.length; i++)
            for (int j = 0; j < a.length; j++)
                if (o[i] == a[j] && i == j) {
                    count++;

                }

        if (count == 0)
            return 0;
        else
            return count;
    }

}
