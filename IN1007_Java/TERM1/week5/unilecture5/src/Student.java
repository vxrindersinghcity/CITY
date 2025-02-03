public class Student {
    private int age;
    private int year_group;
    static int amountSaved=0;
    String name;

    Student(int a, int b, String name) {
        age = a;
        year_group = b;
        this.name = name;

    }
    public Student(String name, int age){
        //this(); inherits from the base student constructor
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getYear_group() {
        return year_group;
    }
}
