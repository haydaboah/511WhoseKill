import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DialogueDriver {
    
    public static void main(String[] args) {

        //All possible evidence combinations (for safe keeping)
        Evidence[] combo0 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.EMPTY_BILLFOLD};
        Evidence[] combo1 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.HIP_FLASK};
        Evidence[] combo2 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.ROOM_KEY};
        Evidence[] combo3 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.STRAY_HAIR};
        Evidence[] combo4 = {Evidence.ANTIQUE_WATCH, Evidence.EMPTY_BILLFOLD, Evidence.HIP_FLASK};
        Evidence[] combo5 = {Evidence.ANTIQUE_WATCH, Evidence.EMPTY_BILLFOLD, Evidence.ROOM_KEY};
        // Evidence[] combo6 = {Evidence.ANTIQUE_WATCH, Evidence.EMPTY_BILLFOLD, Evidence.STRAY_HAIR};
        // Evidence[] combo7 = {Evidence.ANTIQUE_WATCH, Evidence.HIP_FLASK, Evidence.ROOM_KEY};
        // Evidence[] combo8 = {Evidence.ANTIQUE_WATCH, Evidence.HIP_FLASK, Evidence.STRAY_HAIR};
        // Evidence[] combo9 = {Evidence.ANTIQUE_WATCH, Evidence.ROOM_KEY, Evidence.STRAY_HAIR};
        // Evidence[] combo10 = {Evidence.CIGAR, Evidence.EMPTY_BILLFOLD, Evidence.HIP_FLASK};
        // Evidence[] combo11 = {Evidence.CIGAR, Evidence.EMPTY_BILLFOLD, Evidence.ROOM_KEY};
        // Evidence[] combo12 = {Evidence.CIGAR, Evidence.EMPTY_BILLFOLD, Evidence.STRAY_HAIR};
        // Evidence[] combo13 = {Evidence.CIGAR, Evidence.HIP_FLASK, Evidence.ROOM_KEY};
        // Evidence[] combo14 = {Evidence.CIGAR, Evidence.HIP_FLASK, Evidence.STRAY_HAIR};
        // Evidence[] combo15 = {Evidence.CIGAR, Evidence.ROOM_KEY, Evidence.STRAY_HAIR};
        // Evidence[] combo16 = {Evidence.EMPTY_BILLFOLD, Evidence.HIP_FLASK, Evidence.ROOM_KEY};
        // Evidence[] combo17 = {Evidence.EMPTY_BILLFOLD, Evidence.HIP_FLASK, Evidence.STRAY_HAIR};
        // Evidence[] combo18 = {Evidence.EMPTY_BILLFOLD, Evidence.ROOM_KEY, Evidence.STRAY_HAIR};
        // Evidence[] combo19 = {Evidence.HIP_FLASK, Evidence.ROOM_KEY, Evidence.STRAY_HAIR};

        //Evidence Booleans (PLAYER)
        boolean hasWatch = false;
        boolean hasCigar = false;
        boolean hasFlask = false;
        boolean hasFold = false;
        boolean hasHair = false;
        boolean hasKey = false;

        //Choices in Loop
        int firstChoice;
        int secondChoice;
        int characterChoice;


        Scanner scan = new Scanner(System.in);

        //while loop conditions
        boolean endGame = false;
        boolean hmLevel1 = false;
        boolean hmLevel2 = false;
        boolean diLevel1 = false;
        boolean diLevel2 = false;

        //Character Parameters:
        //String charName, String role, String room, Evidence[] combo, int posX, int posY, Boolean isSuspect
        NPC chef = new NPC("Chef", "chef", "kitchen", combo0, 0, 0, false);
        NPC maid = new NPC("Maid", "maid", "closet", combo1, 0, 0, false);
        NPC sen = new NPC("Senator", "senator", "Room 1", combo2, 0, 0, false);
        NPC imp = new NPC("Imperialist", "imperialist", "Room 2", combo3, 0, 0, false);
        NPC dan = new NPC("Dancer", "dancer", "Room 3", combo4, 0, 0, false);
        NPC goon = new NPC("Goon", "goon", "Room 3", combo5, 0, 0, false);

        //Dialogue Parameters:
        //String chef, String maid, String goon, String dancer, String senator, String imperialist
        Dialogue di = new Dialogue(chef.getCharName(), maid.getCharName(), goon.getCharName(), dan.getCharName(), sen.getCharName(), imp.getCharName());

        HotelManager hm = new HotelManager();

        while (endGame == false) {
            firstChoice = 0;
            secondChoice = 0;
            characterChoice = 0;
            System.out.println();
            
            //Start (First Choice)
            System.out.println("Who would you like to talk to?\nPress (1) for Hotel Manager\nPress (2) for General Character\nPress (3) to exit game\n");
            firstChoice = scan.nextInt();
            
            //Hotel Manager
            if(firstChoice == 1) {

                System.out.println(hm.firstEncounter("ENTER MURDER ROOM HERE"));
                System.out.println();
                //TimeUnit.SECONDS.sleep(1); //Wait one second
                System.out.println(hm.greeting());
                
                //HM Level 1 While
                while (hmLevel1 == false) {
                    secondChoice = 0; //must reset every iteration
                    //Second Choice
                    System.out.println("(1) Inquire about crime\n(2) Tell me about the other people here\n(3) Go back\n");
                    secondChoice = scan.nextInt();
                    System.out.println();

                    //call inquireCrime()
                    if(secondChoice == 1) {
                        System.out.println();
                        System.out.println(hm.inquireCrime("ENTER MURDER ROOM HERE"));
                    }

                    //call otherPeople()
                    if(secondChoice == 2) {
                        System.out.println();
                        System.out.println(hm.otherPeople());
                        hmLevel2 = false; //must reset every iteration

                        //HM Level 2 While
                        while (hmLevel2 == false) {
                            characterChoice = 0; //must reset every iteration
                            System.out.println();
                            System.out.println("(1) Chef\n(2) Maid\n(3) Senator\n(4) Imperialist\n(5) Dancer\n(6) Goon\n(7) Go back");
                            characterChoice = scan.nextInt();
                            System.out.println();

                            //Switch for charChoice
                            switch (characterChoice) {
                                case 1:
                                    System.out.println(hm.chefChosen(chef.getRoom()));
                                    break;
                                case 2:
                                    System.out.println(hm.maidChosen(maid.getRoom()));
                                    break;
                                case 3:
                                    System.out.println(hm.senChosen(sen.getRoom()));
                                    break;
                                case 4:
                                    System.out.println(hm.impChosen(imp.getRoom()));
                                    break;
                                case 5:
                                    System.out.println(hm.danChosen(dan.getRoom()));
                                    break;
                                case 6:
                                    System.out.println(hm.goonChosen(goon.getRoom()));
                                    break;
                                case 7:
                                    hmLevel2 = true; //Exit Level 2 loop
                                    break;
                                default:
                                    System.out.println("I\'m afraid I don\'t know who that is.");
                            }
                        }
                    }

                    //Exit Level 1  loop
                    if (secondChoice == 3) {
                        hmLevel1 = true;
                    }
                }
                
            }

            //General Character
            if(firstChoice == 2) {

                //General Level 1 While 
                while (diLevel1 == false) {
                    secondChoice = 0; //must reset every iteration
                    System.out.println();
                    //TimeUnit.SECONDS.sleep(1); //Wait one second

                    //Second Choice
                    System.out.println("(1) Where were you at the time of the murder?\n(2) I'm going to have to search you\n(3) Did you know the victim?\n(4) What can you tell me about the other people here?\n(5) Go back");
                    secondChoice = scan.nextInt();
                    System.out.println();

                    //call timeOfMurder()
                    if(secondChoice == 1) {
                        System.out.println(di.timeOfMurder());
                    }

                    //call searchYou()
                    if(secondChoice == 2) {
                        System.out.println(di.searchYou(true, "ENTER SUSPECTED CHARACTER NAME HERE"));
                    }

                    //call knowVictim()
                    if(secondChoice == 3) {
                        System.out.println(di.knowVictim());
                    }

                    //call otherPeople
                    if(secondChoice == 4) {
                        diLevel2 = false;//must reset every iteration
                        System.out.println("\"Sure, shoot away.\"\n");

                        //General Level 2 While Loop
                        while (diLevel2 == false) {
                            characterChoice = 0; //must reset every iteration
                            System.out.println("(1) Chef\n(2) Maid\n(3) Senator\n(4) Imperialist\n(5) Dancer\n(6) Goon\n(7) Go back");
                            characterChoice = scan.nextInt();

                            switch (characterChoice) {
                                case 1:
                                    System.out.println(di.otherPeopleHere(chef.getCharName()));
                                    break;
                                case 2:
                                    System.out.println(di.otherPeopleHere(maid.getCharName()));
                                    break;
                                case 3:
                                    System.out.println(di.otherPeopleHere(sen.getCharName()));
                                    break;
                                case 4:
                                    System.out.println(di.otherPeopleHere(imp.getCharName()));
                                    break;
                                case 5:
                                    System.out.println(di.otherPeopleHere(dan.getCharName()));
                                    break;
                                case 6:
                                    System.out.println(di.otherPeopleHere(goon.getCharName()));
                                    break;
                                case 7:
                                    diLevel2 = true; //Exit Level 2 Loop
                                    break;
                                default:
                                    System.out.println("I\'m afraid I don\'t know who that is.");
                            }
                        }
                    }

                    //Exit Level 1 Loop
                    if (secondChoice == 5) {
                        diLevel1 = true;
                    }
                }
            }

            //Exit Game
            if(firstChoice == 3) {
                endGame = true;
            } 
        }
    }
}