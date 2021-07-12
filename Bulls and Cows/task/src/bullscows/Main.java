package bullscows;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {


        public static int length = 0;

        public static void main(String[] args) {
            long pseudoRandomNumber = System.nanoTime();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please, enter the secret code's length:");
            length = scanner.nextInt();
            if(length > 9){
                System.out.println("error");
                System.out.println("Please, enter the secret code's length:");
                length = scanner.nextInt();
            }
            String original = randomGenerator(length);
            System.out.println(original);
            System.out.println("Okay, let's start a game!");
            int i = 0;
            while (true) {
                System.out.println("Turn " + (++i));
                String verify = scanner.next();
                char[] o = original.toCharArray();
                char[] a = verify.toCharArray();
                int cows = checkingForCows(o, a);
                int bulls = checkingForBulls(o, a);
                cows = cows - bulls;
                if (cows > 0 && bulls > 0)
                    System.out.println(bulls + " bulls and " + cows + " cow");
                else if (cows > 0)
                    System.out.println(cows + " cows.");
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

        public static String randomGenerator(int length) {
            List<Integer> randomList = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7, 8, 9));
            Collections.shuffle(randomList);
            StringBuilder result = new StringBuilder();
            for (var ch : randomList.subList(0, length)) {
                result.append(ch);
            }
            return result.toString();
        }

        public static int checkingForCows(char[] o, char[] a) {
            int count = 0;
            for (int i = 0; i < length; i++)
                for (int j = 0; j < length; j++)
                    if (o[i] == a[j])
                        count++;

            if (count == 0)
                return 0;
            else
                return count;
        }

        public static int checkingForBulls(char[] o, char[] a) {
            int count = 0;
            for (int i = 0; i < length; i++)
                for (int j = 0; j < length; j++)
                    if (o[i] == a[j] && i == j)
                        count++;
            if (count == 0)
                return 0;
            else
                return count;
        }

    }