public class ExpeditionMember {
    private String name;
    private int studentID;
    static int member_counter=0;

    public ExpeditionMember(String name, int studentID) {
        this.name = name;
        this.studentID = studentID;
        member_counter++;
    }

    public String getName() {
        return name;
    }
    public int getStudentID() {
        return studentID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
