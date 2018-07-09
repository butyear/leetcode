package Problems;

public class P9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        // get x size
        int n = 0;
        while (x / Math.pow(10, n) >= 1) {
            n++;
        }

        int num = x;
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = x % 10;
            x /= 10;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += input[i] * (int) Math.pow(10, n - i - 1);
        }

        return num == result;
    }
}