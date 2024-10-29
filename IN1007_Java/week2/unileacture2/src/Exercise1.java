import java.util.Scanner;

public class Exercise1 {
    public static void main (String[] args){
        int a, b;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter two integers");
        a = sc.nextInt();
        b = sc.nextInt();
        if (a>b) {
            System.out.println("greater");
        } else {
            System.out.println("smaller or equal");
        }
    }
}
