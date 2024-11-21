import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] allNames = {"Varinder", "David", "Michele", "Ivan", "Hamza", "Oliver"};
        int[] allStudentIDs = {101, 102, 103, 104, 105, 106};

        Random random = new Random();
        int numberOfMembers = 4 + random.nextInt(3);

        ExpeditionMember[] members = new ExpeditionMember[numberOfMembers];

        for (int i = 0; i < members.length; i++) {
            members[i] = new ExpeditionMember(allNames[i], allStudentIDs[i]);
        }

        ResearchExpedition pyramidExpedition = new ResearchExpedition(members[0], members[1], members[2]);
        ResearchExpedition nileExpedition= new ResearchExpedition(members[members.length-1], members[members.length-2], members[members.length-3]);
        System.out.println("Leader: "+pyramidExpedition.getExpeditionLeaderName()+
                " Archivist: "+pyramidExpedition.getArchivistName()+
                " Researcher: "+pyramidExpedition.getFieldResearcherName());
        System.out.println("Leader: "+nileExpedition.getExpeditionLeaderName()+
                " Archivist: "+nileExpedition.getArchivistName()+
                " Researcher: "+nileExpedition.getFieldResearcherName());

        if (members.length==ExpeditionMember.member_counter){
            System.out.println("SUCCESS");
        }
    }
}