import java.util.ArrayList;
import java.util.List;

public class MyChristmasList{
    private List myList;
    public MyChristmasList(){
        myList= new ArrayList();
    }
    public List getList(){
        return myList;
    }
    public void setList(List myList){
        this.myList=myList;
    }
    public void addGift(ChristmasGift gift){
        myList.add(gift);
    }
}
