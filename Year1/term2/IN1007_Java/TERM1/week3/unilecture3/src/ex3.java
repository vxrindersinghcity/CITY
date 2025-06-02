public class ex3 {
    public static void main(String[] args) {
        System.out.println(sumFromOneToN(5)); // Outputs: 15
        System.out.println(sumFromOneToN(-1)); // Outputs: 0
    }

    public static int sumFromOneToN(int n) {
        if (n <= 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
