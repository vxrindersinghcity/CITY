import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    List list = new ArrayList();
    list.add("A");

    /*String s=list.get(0);*/ //cant do as list doesn't know the data type
    String s =(String) list.get(0);

    ArrayList<Integer> al=new ArrayList<>();
    al.add(1);
    al.add(12);
    al.add(13);
    al.add(3);
    al.add(8);
    al.remove(3);
    al.remove(Integer.valueOf(8));
        System.out.println(al);
        Iterator it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}