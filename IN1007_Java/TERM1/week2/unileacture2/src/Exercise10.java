import java.util.Scanner;

public class Exercise10{
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter two String");
        String x = sc.next();
        String y = sc.next();
        search:
        for (int l = x.length(); l > 0; l--) {
            int i = 0;
            while (l + i <= x.length()){
                if (y.contains(x.substring(i, i + l))){
                    System.out.println(x.substring(i, i + l));
                    break search;
                }
                i++;
            }
        }
    }
}