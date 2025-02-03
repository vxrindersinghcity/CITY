import java.util.Scanner;

public class exercises {
    public static void main(String[] args) {
      //ex1and2();//ex3and4();
      //ex7();
        ex7a();
    }


    public static void ex1and2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Varinder Singh");
        System.out.println("enter current year");
        int year = sc.nextInt();
        System.out.println("enter birth year");
        int birthYear = sc.nextInt();

        System.out.println(year-birthYear);
    }
    public static void ex3and4() {
        System.out.println((float)4/3);
        System.out.println((4-3)*5);
        System.out.println(1.3/0);
        System.out.println(4/3.0);
        System.out.println(117%7);
        System.out.println((-1.3)/0);
        System.out.println(4-3*5);
        System.out.println(0.3-0.2);
        System.out.println(0/1.3);
        System.out.println(4-(3*5));
        System.out.println(0.2-0.1);
        System.out.println((float)0/0);
        System.out.println(10>5);
        System.out.println( false||(5!=4));
        System.out.println(10==5);
        System.out.println(false&&(5!=4));
        System.out.println(5==5);
        System.out.println(!(30%3==0));
        System.out.println(5==11-6);
        System.out.println(0.3-0.2==0.2-0.1);
    }
    public static void ex7() {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string");
        String str = sc.nextLine();
        int j=0;
        if (str.length()%2!=0){
            double halfpoint =str.length()/2;
            int mid=(int) halfpoint;
            char[] sum1= new char[mid];
            char[] sum2= new char[mid];
            char[] reversed=new char[mid];
            char temp;
            for (int i=0; i<mid; i++){
                sum1[i]=str.charAt(i);
            }
            for (int i=mid+1; i<str.length(); i++){
                sum2[j]=str.charAt(i);
                j++;
            }
            j=0;
           for (int i=sum2.length-1; i>=0; i--){

               reversed[j]=sum2[i];
               j++;
           }
            j=0;
            for (int i=0; i<mid; i++){
                if (sum1[i]==reversed[i]){
                    j++;
                }
            }
            if (j==mid){
                System.out.println(true);
            }else{
                System.out.println(false);
            }

        }else{
            double halfpoint =str.length()/2 -1;
            int mid=(int) halfpoint;
            if (str.charAt(mid)==str.charAt(mid+1)){

                char[] sum1= new char[mid];
                char[] sum2= new char[mid];
                char[] reversed=new char[mid];
                for (int i=0; i<mid; i++){
                    sum1[i]=str.charAt(i);
                }
                for (int i=mid+2; i<str.length(); i++){
                    sum2[j]=str.charAt(i);
                    j++;
                }

                j=0;
                for (int i=sum2.length-1; i>=0; i--){

                    reversed[j]=sum2[i];
                    j++;
                }
                j=0;
                for (int i=0; i<mid; i++){
                    if (sum1[i]==reversed[i]){
                        j++;
                    }
                }
                if (j==mid){
                    System.out.println(true);
                }

            }else{
                System.out.println(false);
            }

        }
    }
    private static void ex7a() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string");
        String str = sc.nextLine();

        if (str.length() % 2 != 0) {
            int mid = str.length() / 2;
            String sum1 = str.substring(0, mid);
            System.out.println(sum1);
            String sum2 = new StringBuilder(str.substring(mid + 1)).reverse().toString();
            if (sum1.equals(sum2)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        } else {
            int mid = str.length() / 2 - 1;
            if (str.charAt(mid) == str.charAt(mid + 1)) {
                String sum1 = str.substring(0, mid);
                String sum2 = new StringBuilder(str.substring(mid + 2)).reverse().toString();
                if (sum1.equals(sum2)) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            } else {
                System.out.println(false);
            }
        }
    }
}
