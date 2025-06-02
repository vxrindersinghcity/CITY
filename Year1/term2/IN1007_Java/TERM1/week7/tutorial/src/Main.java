import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
     ChristmasGift a=new ChristmasGift("toy","charlie",12);
     ChristmasGift b=new ChristmasGift("car","ellie",2);
     ChristmasGift c=new ChristmasGift("remote","ivan",8);
     MyChristmasList mainlist=new MyChristmasList();
     mainlist.addGift(a);
     mainlist.addGift(b);
     mainlist.addGift(c);
       printList(mainlist);
       printsize(mainlist);
       int highest=mostExpensive(mainlist);
        System.out.println("price: "+highest);
    }

    private static int mostExpensive(MyChristmasList mainlist) {
        Iterator<ChristmasGift> iterator= mainlist.getList().iterator();
        int[] highprice=new int[mainlist.getList().size()];
        int i=0;
        int highest=0;
        while (iterator.hasNext()) {
            ChristmasGift christmasGift = iterator.next();
           highprice[i]=christmasGift.getPrice();
           i++;
        }
        for (int j = 0; j < highprice.length; j++) {
            if (highprice[j]>highest) {
                highest=highprice[j];
            }
        }
        return highest;
    }

    private static void printsize(MyChristmasList mainlist) {
        System.out.println(mainlist.getList().size());
    }

    private static void printList(MyChristmasList mainlist) {
        Iterator<ChristmasGift> iterator= mainlist.getList().iterator();
        while (iterator.hasNext()) {
            ChristmasGift christmasGift = iterator.next();
            System.out.println(christmasGift.getName()+" "+christmasGift.getReciept()+" "+christmasGift.getPrice());
        }
    }

}