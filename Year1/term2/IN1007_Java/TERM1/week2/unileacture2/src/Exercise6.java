import java.util.Scanner;

public class Exercise6{
    public static void main (String[] args){
        int n;
        int a;
        int s = 0;
        int b = 1;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter an integer");
        n = sc.nextInt();
        for (int i=1;i<=n;i++) {
            System.out.println("Enter an integer");
            a = sc.nextInt();
            s = s + b*a;
            b = -b;
        }
        System.out.println(s);
    }
}
