import java.util.Scanner;

public class Exercise4{
    public static void main (String[] args){
        String m;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a month of the year");
        m = sc.next();
        switch (m) {
            case "JANUARY":  System.out.print(1);
                break;
            case "FEBRUARY":  System.out.print(2);
                break;
            case "MARCH":  System.out.print(3);
                break;
            case "APRIL":  System.out.print(4);
                break;
            case "MAY":  System.out.print(5);
                break;
            case "JUNE":  System.out.print(6);
                break;
            case "JULY":  System.out.print(7);
                break;
            case "AUGUST":  System.out.print(8);
                break;
            case "SEPTEMBER":  System.out.print(9);
                break;
            case "OCTOBER":  System.out.print(10);
                break;
            case "NOVEMBER":  System.out.print(11);
                break;
            case "DECEMBER":  System.out.print(12);
                break;
            default: System.out.print("Invalid month");
                break;
        }
    }
}
