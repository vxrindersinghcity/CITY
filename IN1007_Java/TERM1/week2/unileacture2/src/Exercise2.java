import java.util.Scanner;

public class Exercise2{
    public static void main (String[] args){
        int n;
        int s=0;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter an integer");
        n = sc.nextInt();
        for (int i=1;i<=n;i++) {
            s = s+i;
        }
        System.out.println(s);
    }
}