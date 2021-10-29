import java.util.*;

import javax.lang.model.util.ElementScanner14;

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
        this.player = player;
        ed = new EvidenceDialogue(player);
        scan = new Scanner(System.in);
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
            System.out.println();
            System.out.println(ed.nothing());
            System.out.println();
        }
    }

    //If player has not found the second evidence
    public void noSecondEvidence() {
        if (room.isPublic && room.hasEvidence) {
            searchSecondEvidence(true);
        } else {
            System.out.println();
            System.out.println(ed.nothing());
            System.out.println();
        }
    }

    //If player has not found the third evidence
    public void noThirdEvidence() {
        if (room.hasNPC) {
            searchThirdEvidence(true);
        } else {
            System.out.println();
            System.out.println(ed.nothing());
            System.out.println();
        }
    }

    //Simulates search for the First Evidence
    public void searchFirstEvidence(boolean stillSearching) {
        while (stillSearching == true) {
            choice = 0;

            System.out.println();
            System.out.println("(1) Search under the furniture");
            System.out.println("(2) Gaze around the room absentmindedly");
            System.out.println("(3) Examine the victim");
            System.out.println("(4) Inspect the victim\'s belongings");
            System.out.println("(5) Scrutinize the floor");
            System.out.println("(6) Check the door");
            System.out.println("(7) Exit Search");
            System.out.println();

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
    public void searchSecondEvidence(boolean stillSearching) {
        while (stillSearching == true) {
            choice = 0;
            System.out.println("(1) You notice something there...");
            choice = scan.nextInt();
            if (choice == 1) {
                if (room.Evidence.equals(Evidence.ANTIQUE_WATCH)) {
                    System.out.println();
                    System.out.println(ed.pubAntiqueWatch());
                    System.out.println();
                    stillSearching = false;
                }
                if (room.Evidence.equals(Evidence.EMPTY_BILLFOLD)) {
                    System.out.println();
                    System.out.println(ed.pubEmptyBillfold());
                    System.out.println();
                    stillSearching = false;
                }
                if (room.Evidence.equals(Evidence.STRAY_HAIR)) {
                    System.out.println();
                    System.out.println(ed.pubStrayHair());
                    System.out.println();
                    stillSearching = false;
                }
                if (room.Evidence.equals(Evidence.HIP_FLASK)) {
                    System.out.println();
                    System.out.println(ed.pubHipFlask());
                    System.out.println();
                    stillSearching = false;
                }
                if (room.Evidence.equals(Evidence.CIGAR)) {
                    System.out.println();
                    System.out.println(ed.pubCigar());
                    System.out.println();
                    stillSearching = false;
                }
            } 
        }

    }

    //Simulates search for the Third Evidence
    public void searchThirdEvidence(boolean stillSearching) {
        while (stillSearching == true) {
            choice = 0;

            System.out.println();
            System.out.println("(1) Hurry the fuck up Winton");
            System.out.println("(2) God damnit Winton");
            System.out.println("(3) Jesus fucking Christ");
            System.out.println("(4) Do you not have the fucking time?");
            System.out.println("(5) Don't fuck this up Winton");
            System.out.println("(6) Exit Search");
            System.out.println();

            choice = scan.nextInt();


            switch (choice) {
                case 1:
                    if (ev != null) //fixxing NullPointerException error
                        System.out.println(ed.privAntiqueWatch(ev.equals(Evidence.ANTIQUE_WATCH)));
                    else 
                        System.out.println(ed.privAntiqueWatch(false));
                    break;
                case 2:
                    if (ev != null) //fixxing NullPointerException error
                        System.out.println(ed.privEmptyBillfold(ev.equals(Evidence.EMPTY_BILLFOLD)));
                    else 
                        System.out.println(ed.privEmptyBillfold(false));
                    break;
                case 3:
                    if (ev != null) //fixxing NullPointerException error
                        System.out.println(ed.privStrayHair(ev.equals(Evidence.STRAY_HAIR)));
                    else 
                        System.out.println(ed.privStrayHair(false));
                    break;
                case 4:
                    if (ev != null) //fixxing NullPointerException error
                        System.out.println(ed.privHipFlask(ev.equals(Evidence.HIP_FLASK)));
                    else  
                        System.out.println(ed.privHipFlask(false));
                    break;
                case 5:
                    if (ev != null) //fixxing NullPointerException error
                        System.out.println(ed.privCigar(ev.equals(Evidence.CIGAR)));
                    else 
                        System.out.println(ed.privCigar(false));

                    break;
                case 6:
                    stillSearching = false;
                    break;
                default:
                    System.out.println("You continue standing.");
            }
        }
    }
}
