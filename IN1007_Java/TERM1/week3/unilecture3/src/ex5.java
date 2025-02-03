import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter how many numbers you want to enter: ");
        int n = sc.nextInt();

        double[] numbers= new double[n];
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

    private static double arithmetic(double numbers[]) {
        double sum=0;
        for (int i = 0; i < numbers.length; i++) {
            sum+=numbers[i];
        }
        return (sum)/numbers.length;
    }

    private static double geometric(double numbers[]) {
        double sum=0;
        for (int i = 0; i < numbers.length; i++) {
            sum*=numbers[i];
        }
        return Math.sqrt(sum);
    }
}
