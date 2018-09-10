package SwordToOffer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                String flag = sc.next();
                if (flag.equals("Q")) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    if(a>b){
                        int temp = a;
                        a = b;
                        b = temp;
                    }
                    int[] temp = Arrays.copyOfRange(scores, a - 1, b);
                    System.out.println(findHighest(temp));
                }
                if (flag.equals("U")) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    scores[a - 1] = b;
                }
            }
        }
        sc.close();
    }

    private static int findHighest(int[] scores) {
        int highestScore = -1;
        for (int i = 0; i < scores.length; i++) {
            if (highestScore < scores[i]) {
                highestScore = scores[i];
            }
        }
        return highestScore;
    }
}