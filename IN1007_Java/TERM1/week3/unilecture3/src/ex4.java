import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int n = sc.nextInt();
        System.out.println(productFromOneToN(n));
    }

    public static int productFromOneToN(int n) {
        if (n == 0) {
            return 0;
        }
        int product = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
        } else {
            for (int i = n; i <= -1; i++) {
                product *= i;
            }
        }
        return product;
    }
}
