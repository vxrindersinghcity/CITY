public class Main {
    public static void main(String[] args) {

      String[] s={"r","a","b","b","i","t"};
      foo(s,0,5);
        for (int i = 0; i < 6; i++) {
            System.out.println(s[i]);
        }
        String[] a={"a","b","c","d"};
        for (int i = 0; i < 4; i++) {
            a[(i+2)%4]=a[i];
        }
        System.out.println(a[0]+a[1]+a[2]+a[3]+"X");
    }

    private static void foo(String[] s, int i, int i1) {
        if(i<i1){
            String x=s[i];
            s[i++]=s[i1];
            s[i1--]=x;
            foo(s,i,i1);
        }
    }
}