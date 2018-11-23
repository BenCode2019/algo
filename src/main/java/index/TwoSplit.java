package index;

/**
 * @Auther: Ben
 * @Date: 2018/11/15 14
 * @Description:
 */
public class TwoSplit {

    public static double sqrt(double number, double accuracy) {
        double higher = number;
        double lower = 0.0;
        double middle = (lower + higher) / 2;
        double last_middle = 0.00;
        int count = 0;
        if (number < 0) {
            return Double.NaN;
        }
        while (Math.abs(middle - last_middle) > accuracy) {
            if (middle * middle > number) {
                higher = middle;
            } else {
                lower = middle;
            }
            last_middle = middle;
            middle = (lower + higher) / 2;
            count++;
            System.out.printf("Dichotomy try count = %d, guess = %f\n", count, last_middle);
        }
        System.out.printf("Dichotomy final result = %f\n", last_middle);
        return last_middle;
    }


    public static void main(String[] args) {
        double sqrt = sqrt(25, 1e-3);
        System.out.printf(String.valueOf(sqrt));
    }
}
