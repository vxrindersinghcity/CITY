public class ex2 {
    public static void main(String[] args) {
        int a=17,b=43;
        double arith=arithmetic(a,b);
        double geo=geometric(a,b);
        if (arith>geo){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }

    private static double arithmetic(int a, int b) {
        return (a+b)/2;
    }

    private static double geometric(int a, int b) {
        return Math.sqrt(a*b);
    }
}
