package Problems;

public class P7ReverseInteger {
    public int reverse(int x) {
        boolean isPositive = true;
        if (x < 0) {
            isPositive = false;
            x = -x;
        }

        // get x size
        int n = 0;
        while (x / Math.pow(10, n) >= 1) {
            n++;
        }

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = x % 10;
            x /= 10;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += input[i] * Math.pow(10, n - i - 1);
        }

        if (result == 2147483647) return 0;

        if (!isPositive) result = -result;

        return result;
    }
}