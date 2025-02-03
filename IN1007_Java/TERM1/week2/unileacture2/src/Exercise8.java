import java.util.Scanner;

public class Exercise8{
    public static void main (String[] args){
        int n;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter an integer");
        n = sc.nextInt();
        for (int j=0; j<n; j++){
            for (int i=0; i<n-j; i++){
                System.out.print(" ");
            }
            for (int i=n-j; i<=n+j; i++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}