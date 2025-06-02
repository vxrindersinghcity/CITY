public class Main {
    public static void main(String[] args) {
    Student me= new Student(18,1,"varinder");
    Student you= new Student(21,3,"ivan");
    classRoom in1007 = new classRoom(450,me);
    me.setAge(24);
    Student.amountSaved=500;//should use class name to access static variables
        //local scopes memory efficient
        String myStudentname =new Student("hi",10).name;
        System.out.println(myStudentname);
        System.out.println(me.getAge());
        System.out.println(you.getAge());
        System.out.println(Student.amountSaved);

    }
}