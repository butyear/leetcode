import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import P746_Min_Cost_Climbing_Stairs.*;

public class MainClass {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/746.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            Solution solution = new Solution();

            int size = sc.nextInt();
            int[] input = new int[size];
            for (int i=0; i<size; i++) {
                input[i] = sc.nextInt();
            }
            System.out.println("#" + test_case + " " + solution.minCostClimbingStairs(input));
        }
    }
}
