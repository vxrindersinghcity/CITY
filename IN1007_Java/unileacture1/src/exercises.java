import java.util.Scanner;

public class exercises {
    public static void main(String[] args) {
      //ex1();
      ex2();
    }
    public static void ex1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Varinder Singh");
        System.out.println("enter current year");
        int year = sc.nextInt();
        System.out.println("enter birth year");
        int birthYear = sc.nextInt();

        System.out.println(year-birthYear);
    }
    public static void ex2() {

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
}
