public class Classroom {
    private int size;
    private Student rep;

    Classroom(int size, Student rep){
        this.size = size;
        this.rep = rep;
    }

    public int getRepAge(){
        return rep.getAge();
    }
    public void setRepAge(int age){
        rep.setAge(age);
    }
}


