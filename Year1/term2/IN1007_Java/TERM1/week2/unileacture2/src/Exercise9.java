import java.util.Scanner;

public class Exercise9{
    public static void main (String[] args){
        int n;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter an integer");
        n = sc.nextInt();
        while (n!=1){
            if (n%2 == 0) {
                n = n/2;
            } else {
                n = 3*n+1;
            }
            System.out.print(n + ",");
        }
    }
}