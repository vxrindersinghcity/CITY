public class ChristmasGift {
    private String reciept,name;
    private int price;
    public ChristmasGift(String reciept, String name, int price) {
        this.reciept = reciept;
        this.name = name;
        this.price = price;
    }
    public String getReciept() {
        return reciept;
    }
    public void setReciept(String reciept) {
        this.reciept = reciept;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
