package Problems;

public class P66PlusOne {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        boolean needShift = false;
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] == 10) {

                digits[i] = 0;
                if (i - 1 < 0) needShift = true;
                else digits[i - 1]++;
            }
        }

        if (needShift) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = 0;
            }
            return result;
        }

        return digits;
    }
}