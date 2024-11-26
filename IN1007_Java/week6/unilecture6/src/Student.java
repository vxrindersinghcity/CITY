public class Student {
    private int age;
    private int year_group;
    static int amount_saved = 0;
    private String name;

    {
        System.out.println("Hello from a student");
    }
    Student(){
        age = 18;
        year_group = 1;
        name = "";
    }

    Student(String name, int a, int b){
        this.name = name;
        age = a;
        year_group = b;
    }

    Student(int a, int b){
        this("Mai", 20, 2);
        age = a;
        year_group = b;
    }

    public static int increasedAmount() {
        amount_saved++;
        return amount_saved;
    }

    public void setAge(int a){
        age = a;

    }
    public int getAge(){
        return  age;
    }
    public String getName(){
        int x = 5;
        x = 4;
        x = x -1;
        
        return  name;
    }
}

