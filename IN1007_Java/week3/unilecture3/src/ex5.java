import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter how many numbers you want to enter: ");
        int n = sc.nextInt();

        int[] numbers= new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i]=sc.nextInt();
        }
        double arith=arithmetic(numbers);
        double geo=geometric(numbers);
        if (arith>geo){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }

    private static double arithmetic(int a, int b) {
        return (a+b)/2;
    }

    private static double geometric(int a, int b) {
        return Math.sqrt(a*b);
    }
}
