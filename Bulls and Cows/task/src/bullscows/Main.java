package bullscows;

import java.util.*;

public class Main {

    public static int length = 0;

    public static void main(String[] args) {
        // long pseudoRandomNumber = System.nanoTime();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        length = scanner.nextInt();
        if (length > 9) {
            System.out.println("error");
            System.out.println("Please, enter the secret code's length:");
            length = scanner.nextInt();
        }

        String original = generateRandomDigits();
        //String original = "5729";
        System.out.println(original);
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
        scanner.close();

    }

    public static String generateRandomDigits() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        String s="";
        while (true) {
            int value = random.nextInt(10);
            if (!list.contains(value)) {
                list.add(value);
                s=s+value;
            }
            if(list.size()==length)
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
