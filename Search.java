import java.util.*;

//Cases for searching
//1)No Evidence has been found (firstEvidence = false)
//  -> IF the current room is the crime room, SEARCH
//  -> ELSE: "There doesn't seem to be anything here."
//2)First evidence has been found (secondEvidence = false)
//  -> IF the current room is public and has 2nd evidence, SEARCH
//  -> ELSE: "There doesn't seem to be anything here."
//3)Second evidence has been found (thirdEvidence = false)
//  -> IF the current room has NPC AND it's NPC is the suspect, SEARCH
//  -> ELSE IF: the current room has an NPC, SEARCH
//  -> ELSE: "There doesn't seem to be anything here."


public class Search {
    
    private EvidenceDialogue ed;
    private Scanner scan;
    private Room room;
    private Evidence ev;
    private Player player;
    private int choice;

    //Search options for no1 evidence, no2 evidence, and no3 evidence                                                                                                                       //Hayden modification
    //private String[] crimeOptions = {"Search under the furniture", "Gaze around the room absentmindedly", "Examine the victim", "Inspect the victim’s belongings", "Scrutinize the floor", "Check the door"}; //not complete
    //private String publicOption = "You notice something there";
    //private String[] privateOptions = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"}; //temporary 

    //Constructor(takes in player object)
    public Search(Player player) {
        ed = new EvidenceDialogue();
        scan = new Scanner(System.in);
        this.player = player;
        choice = 0;
    }

    //initiates search (takes in room object)
    public void initiate(Room room) {
        this.room = room;
        ev = room.Evidence;

        //checks whether the player has found the first, second, or third evidence
        if (player.getFirstEvidence() == false) {
            noFirstEvidence();
        } else if ((player.getFirstEvidence() == true) && (player.getSecondEvidence() == false)) {
            noSecondEvidence();
        } else if ((player.getFirstEvidence() == true) && (player.getSecondEvidence() == true) && (player.getThirdEvidence() == false)) {
            noThirdEvidence();
        } else {
            System.out.println(ed.nothing());
        }
    }

    //If the player has not found the first evidence
    public void noFirstEvidence() {
        if (room.crime == true) {
            searchFirstEvidence(true);
        } else {
            System.out.println(ed.nothing());
        }
    }

    //If player has not found the second evidence
    public void noSecondEvidence() {
        if (room.isPublic && room.hasEvidence) {
            searchSecondEvidence();
        } else {
            System.out.println(ed.nothing());
        }
    }

    //If player has not found the third evidence
    public void noThirdEvidence() {
        if (room.hasNPC) {
            searchThirdEvidence();
        } else {
            System.out.println(ed.nothing());
        }
    }

    //Simulates search for the First Evidence
    public void searchFirstEvidence(boolean stillSearching) {
        while (stillSearching == true) {
            choice = 0;

            System.out.println("(1) Search under the furniture");
            System.out.println("(2) Gaze around the room absentmindedly");
            System.out.println("(3) Examine the victim");
            System.out.println("(4) Inspect the victim\'s belongings");
            System.out.println("(5) Scrutinize the floor");
            System.out.println("(6) Check the door");
            System.out.println("(7) Exit Search");

            choice = scan.nextInt();

            //Pass each evidence dialogue method the boolean return of ev.equals()
            switch (choice) {
                case 1:
                    System.out.println(ed.crimeAntiqueWatch(ev.equals(Evidence.ANTIQUE_WATCH)));
                    break;
                case 2:
                    System.out.println(ed.crimeEmptyBillfold(ev.equals(Evidence.EMPTY_BILLFOLD)));
                    break;
                case 3:
                    System.out.println(ed.crimeStrayHair(ev.equals(Evidence.STRAY_HAIR)));
                    break;
                case 4:
                    System.out.println(ed.crimeHipFlask(ev.equals(Evidence.HIP_FLASK)));
                    break;
                case 5:
                    System.out.println(ed.crimeCigar(ev.equals(Evidence.CIGAR)));
                    break;
                case 6:
                    System.out.println(ed.crimeRoomKey(ev.equals(Evidence.ROOM_KEY)));
                    break;
                case 7:
                    stillSearching = false;
                    break;
                default:
                    System.out.println("You continue standing.");
            }
        }
    }

    //Simulates search for the Second Evidence
    public void searchSecondEvidence() {

    }

    //Simulates search for the Third Evidence
    public void searchThirdEvidence() {
        if (room.npc.getIsSuspect()) {

        } else {

        }
    }
}
