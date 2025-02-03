import java.util.Scanner;

public class ex1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number");
        int n = sc.nextInt();
        System.out.println(calculate(n));
    }

    private static int calculate(int n) {
       return (4*n)+5;
    }
}