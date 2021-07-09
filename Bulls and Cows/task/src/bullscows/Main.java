package bullscows;
import java.util.Scanner;
public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int value = scanner.nextInt();
            int original = 9305;
            int[] o = convertingToArray(original);
            int[] a = convertingToArray(value);
            for (int i = 0; i < 4; i++) {
                a[i] = value % 10;
                value = value / 10;
            }
            int cows = checkingForCows(o, a);
            int bulls = checkingForBulls(o, a);
            cows = cows - bulls;
            if (cows > 0 && bulls > 0)
                System.out.print(bulls + " bull(s) and " + cows + " cow(s).");
            else if (cows > 0)
                System.out.print(cows + " cow(s).");
            else if (bulls > 0)
                System.out.print(bulls + " bull(s).");
            else
                System.out.print("None.");
            System.out.print("The secret code is 9305.");
            scanner.close();
        }

        public static int[] convertingToArray(int value) {
            int[] a = new int[4];
            for (int i = 0; i < 4; i++) {
                a[i] = value % 10;
                value = value / 10;
            }
            return a;
        }

        public static int checkingForCows(int[] o, int[] a) {
            int count = 0;
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (o[i] == a[j])
                        count++;

            if (count == 0)
                return 0;
            else
                return count;
        }

        public static int checkingForBulls(int[] o, int[] a) {
            int count = 0;
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (o[i] == a[j] && i == j)
                        count++;
            if (count == 0)
                return 0;
            else
                return count;
        }
    }




