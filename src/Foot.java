import java.util.*;

public class Foot {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int n = input.nextInt();
        int[] input1 = new int[n];
        int[] input2 = new int[n];
        for (int i = 0; i < n; i++) {
            input1[i] = input.nextInt();
            input2[i] = input.nextInt();
        }
        int minPass = pass(input1, input2, n);
        if (minPass == 0) {
            System.out.println("0");
        } else {
            System.out.println(90 / (minPass * t));
        }
    }

    private static int pass(int input1[], int input2[], int n) {
        int[] player = new int[11];
        player[0] = 1;
        int counter = 0;
        int s = 1;
        while (s < 11) {
            int h = s;
            for (int i = 0; i < n; i++) {
                int t = s;
                for (int j = 0; j < h; j++) {
                    if (input1[i] == player[j]) {
                        int p = 0;
                        for (int l = 0; l < t; l++) {
                            if (input2[i] != player[l]) {
                                p++;
                            }
                        }
                        if (p == t) {
                            player[s] = input2[i];
                            s++;
                            break;
                        }
                    }
                    if (input2[i] == player[j]) {
                        int p = 0;
                        for (int l = 0; l < t; l++) {
                            if (input1[i] != player[l]) {
                                p++;
                            }
                        }
                        if (t == p) {
                            player[s] = input1[i];
                            s++;
                            break;
                        }
                    }
                }
                if (s > 10) {
                    break;
                }
            }
            if (s == h) {
                return 0;
            }
            counter++;
            for (int i = 0; i < s; i++) {
                if (player[i] == 11) {
                    return counter;
                }
            }
        }
        return counter;
    }
}
