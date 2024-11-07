import java.util.Scanner;

public class Exercise7{
    public static void main (String[] args){
        int n, a;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter an integer");
        n = sc.nextInt();
        int myarray[] = new int[n];
        for (int i=0;i<n;i++) {
            System.out.println("Enter an integer");
            myarray[i] = sc.nextInt();
        }
        for (int i=n-1;i>=0;i--) {
            System.out.print(myarray[i] + ",");
        }
    }
}
