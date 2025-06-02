public class Main {
    public static void main(String[] args) {
        int x=3,y=4;
        boolean b=(x<y);
        x=x*2;
        if (b){
            System.out.println(++y);
        }else{
            System.out.println(++x);
        }
    }
}