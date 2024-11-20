public class q4 {
    public static void main(String[] args) {
        System.out.println(mystery(4,3));
    }

    private static int mystery(int x, int y) {
        boolean b=(x<y);
        x=2*x;
        if (b){
            return y++;
        }else{
            return x++;
        }
    }
}
