import java.util.*;
//import java.util.concurrent.TimeUnit;

public class Driver {
    
    public static void main(String[] args) {

        //6 possible evidence combinations - The rest are AT BOTTOM OF THIS FILE (for safe keeping)
        Evidence[] combo0 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.EMPTY_BILLFOLD};
        Evidence[] combo1 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.HIP_FLASK};
        Evidence[] combo2 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.ROOM_KEY};
        Evidence[] combo3 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.STRAY_HAIR};
        Evidence[] combo4 = {Evidence.ANTIQUE_WATCH, Evidence.EMPTY_BILLFOLD, Evidence.HIP_FLASK};
        Evidence[] combo5 = {Evidence.ANTIQUE_WATCH, Evidence.EMPTY_BILLFOLD, Evidence.ROOM_KEY};

        //Evidence Booleans (PLAYER)
        // boolean hasWatch = false;
        // boolean hasCigar = false;
        // boolean hasFlask = false;
        // boolean hasFold = false;
        // boolean hasHair = false;
        // boolean hasKey = false;

        //Character Parameters:
        //String charName, String role, String room, Evidence[] combo, int posX, int posY, Boolean isSuspect, Boolean isWitness
        NPC chef = new NPC("Chef", "chef", "kitchen", combo0, 0, 0, false, false);
        NPC maid = new NPC("Maid", "maid", "closet", combo1, 0, 0, false, false);
        NPC sen = new NPC("Senator", "senator", "Room 1", combo2, 0, 0, false, false);
        NPC imp = new NPC("Imperialist", "imperialist", "Room 2", combo3, 0, 0, false, false);
        NPC dan = new NPC("Dancer", "dancer", "ballroom", combo4, 0, 0, false, false);
        NPC goon = new NPC("Goon", "goon", "Room 3", combo5, 0, 0, false, false);

        //Array of characters to pass to necessary classes (more convenient than passing each character individually)
        NPC[] characters = {chef, maid, sen, imp, dan, goon}; //must stay in this order
        CauseOfDeath[] cods = {CauseOfDeath.SHOT, CauseOfDeath.STABBED, CauseOfDeath.STRANGLED, CauseOfDeath.POSSESSED};

        //**********GAME INITIATION**********
            Random rand = new Random();

            //Simulate Character Randomness
            int sus = rand.nextInt(6);                  //Pick a random int for character
            characters[sus].setIsSuspect(true);         //Assign random character suspect
            int wit = rand.nextInt(6);                  //Pick a random int for character
            while (sus == wit) {                        //Ensure sus and wit are not the same
                wit = rand.nextInt(6);                  //If they are, choose new random int
            }
            characters[wit].setIsWitness(true);         //Assign a random character witness

            //Simulate Cause of Death Randomness
            int cod = rand.nextInt(4);                  //Pick a random int for Cause of Death
            CauseOfDeath coDeath = cods[cod];           //Assign random CoD to be the CoD
            Coroner coroner = new Coroner(coDeath);     //Initiate the coroner with CoD

            //Room Creation

            //Simulate Room Randomness
            //  -> A private room (1) is randomly assigned murder room
            //  -> Plant first evidence of suspect, at random, in room (1)
            //  -> A public room (2) is randomly assigned witness room (where the witness directs the player)
            //  -> Plant second evidence of suspect, at random, in room (2)
            //  -> Plant third piece of evidence in the Suspect's personal room (3)

        //Dialogue Handlers
        HotelManagerHandler hmh = new HotelManagerHandler(characters);
        GeneralDialogueHandler gdh = new GeneralDialogueHandler(characters);

        int choice; //choices in loop
        Scanner scan = new Scanner(System.in); //scanner
        boolean endGame = false;  //while loop condition

        while (endGame == false) {
            choice = 0;
            System.out.println();
            
            //Start
            System.out.println("Who would you like to talk to?\nPress (1) for Hotel Manager\nPress (2) for General Character\nPress (3) for Coroner\nPress (4) to exit game\n");
            choice = scan.nextInt();
            
            //Hotel Manager
            if(choice == 1) {
                hmh.initiate();
            }

            //General Character
            if (choice == 2) {
                gdh.initiate();
            }

            //Coroner
            if(choice == 3) {
                System.out.println();
                System.out.println(coroner.greeting());
                System.out.println();
                System.out.println(coroner.coronerInteraction());
            }

            //Exit Game
            if(choice == 4) {
                endGame = true;
            } 
        }
        scan.close();


        //Layer 1: Map Shown - movement keys (w,a,s,d)
        //Layer 2: Map Hidden (Room Entered) - search, encounter, exit
        //Layer 2a: search options -> return strings
        //Layer 2b: encounter options -> return strings
    }
}

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