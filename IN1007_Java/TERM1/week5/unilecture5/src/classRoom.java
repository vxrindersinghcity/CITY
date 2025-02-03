import java.util.ArrayList;

public class classRoom {
    private int size;
    private Student rep;
    private ArrayList<Student> stlist;

    public classRoom(int size, Student rep) {
        this.size = size;
        this.rep = rep;
    }
    public int getrepAge() {
        return rep.getAge();
    }
    public void setRepAge(int age) {
        rep.setAge(age);
    }
}
