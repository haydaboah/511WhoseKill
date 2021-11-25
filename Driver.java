import java.util.*;
//import java.util.concurrent.TimeUnit;

public class Driver {
    
    public static void main(String[] args) {

        //6 possible evidence combinations - The rest are AT BOTTOM OF THIS FILE (for safe keeping)
        Evidence[] combo15 = {Evidence.CIGAR, Evidence.ROOM_KEY, Evidence.STRAY_HAIR};
        Evidence[] combo18 = {Evidence.EMPTY_BILLFOLD, Evidence.ROOM_KEY, Evidence.STRAY_HAIR};
        Evidence[] combo0 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.EMPTY_BILLFOLD};
        Evidence[] combo1 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.HIP_FLASK};
        Evidence[] combo17 = {Evidence.EMPTY_BILLFOLD, Evidence.HIP_FLASK, Evidence.STRAY_HAIR};
        Evidence[] combo7 = {Evidence.ANTIQUE_WATCH, Evidence.HIP_FLASK, Evidence.ROOM_KEY};
        

        //Evidence Booleans (PLAYER)
        // boolean hasWatch = false;
        // boolean hasCigar = false;
        // boolean hasFlask = false;
        // boolean hasFold = false;
        // boolean hasHair = false;
        // boolean hasKey = false;

        //Player object 
        Player player = new Player();

        //Character Parameters:
        //String charName, String role, String room, Evidence[] combo, int posX, int posY, Boolean isSuspect, Boolean isWitness
        NPC chef = new NPC("Chef", "chef", combo15, null, false, false);
        NPC maid = new NPC("Maid", "maid", combo18, null, false, false);
        NPC sen = new NPC("Senator", "senator", combo0, null, false, false);
        NPC imp = new NPC("Imperialist", "imperialist", combo1, null, false, false);
        NPC dan = new NPC("Dancer", "dancer", combo17, null, false, false);
        NPC goon = new NPC("Goon", "goon", combo7, null, false, false);

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

            //Room Assignment for Chef and Maid
            Hotel hotel = new Hotel();
            chef.setRoom(hotel.K1);                     //chef located in kitchen
            hotel.K1.setNPC(chef);                      //double bond
            hotel.K1.setHasNPC(true);                   //kitchen now has NPC
            int clos = rand.nextInt(2);
            if (clos == 0) {
                maid.setRoom(hotel.C1);                 //maid located in closet 1
                hotel.C1.setNPC(maid);                  //double bond
                hotel.C1.setHasNPC(true);               //clost1 has NPC
            } else {                                    //or
                maid.setRoom(hotel.C2);                 //maid located in closet 2
                hotel.C2.setNPC(maid);                  //double bond
                hotel.C2.setHasNPC(true);               //clost2 has NPC
            }

            //Simulate Room Randomness
            //  -> A private room (1) is randomly assigned murder room
            //  -> Plant first evidence of suspect, at random, in room (1)
            //  -> A public room (2) is randomly assigned witness room (where the witness directs the player)
            //  -> Plant second evidence of suspect, at random, in room (2)
            //  -> Plant third piece of evidence in the Suspect's personal room (3)

            Room[] privRooms = {hotel.R1, hotel.R2, hotel.R3, hotel.R4, hotel.R5, hotel.R6, hotel.R7};
            Room[] pubRooms = {hotel.Lobby, hotel.Rr1, hotel.B1};
            Evidence[] susCombo = characters[sus].getCombo();
            Collections.shuffle(Arrays.asList(privRooms));      //Shuffle list of private rooms
            Collections.shuffle(Arrays.asList(susCombo));       //Shuffle list of suspect combo
            Collections.shuffle(Arrays.asList(pubRooms));       //Shuffle list of public rooms
            privRooms[0].crime = true;                          //1st privRoom assigned crime
            for (int i = 0; i < 3; i++) {                       //Array Swap for loop
                if (susCombo[i] == Evidence.ROOM_KEY) {         //If the Room Key is in sus combo
                    Evidence temp = susCombo[0];                // -> swap first element with Room Key
                    susCombo[0] = susCombo[i];
                    susCombo[i] = temp;
                }
            }
            privRooms[0].Set_Overall_Text(coDeath.toString().toLowerCase());
            privRooms[0].Set_Evidence(susCombo[0]);             //evidence planted in 1st privRoom
            privRooms[0].setHasEvidence(true);                  //1st privRoom has evidence
            sen.setRoom(privRooms[1]);                          //2nd privRoom assigned senator
            privRooms[1].setNPC(sen);                           //double bond
            privRooms[1].setHasNPC(true);                       //2nd privRoom has NPC
            imp.setRoom(privRooms[2]);                          //3rd privRoom assigned imperialist
            privRooms[2].setNPC(imp);                           //double bond
            privRooms[2].setHasNPC(true);                       //3rd privRoom has NPC
            dan.setRoom(privRooms[3]);                          //4th privRoom assigned dancer 
            privRooms[3].setNPC(dan);                           //double bond     
            privRooms[3].setHasNPC(true);                       //4th privRoom has NPC
            goon.setRoom(privRooms[4]);                         //5th privRoom assigned goon
            privRooms[4].setNPC(goon);                          //double bond
            privRooms[4].setHasNPC(true);                       //5th privRoom has NPC
            pubRooms[0].Set_Evidence(susCombo[1]);              //evidence planted in 1st pubRoom
            pubRooms[0].setHasEvidence(true);                   //1st pubRoom has evidence
            characters[sus].getRoom().Set_Evidence(susCombo[2]);//evidence planted in sus room
            characters[sus].getRoom().setHasEvidence(true);     //sus rooom has evidence

        //Movement Handler
        Movement mov = new Movement(hotel);

        //Dialogue Handlers
        HotelManagerHandler hmh = new HotelManagerHandler(characters, player, characters[sus]);
        GeneralDialogueHandler gdh = new GeneralDialogueHandler(characters, pubRooms[0]);
        Search search = new Search(player);

        int choice; //choices in loop
        Scanner scan = new Scanner(System.in); //scanner
        boolean endGame = false;  //while loop condition
        boolean thisLevel = false; //level while loop condition

        String howMapWorks = "The series of H's in the middle is the hallway, you are free to roam it as you please and investigate its adjacent rooms. 'R' stands for a private bedroom, 'C' a closet, 'Rr' the restaurant, 'K' the kitchen, and 'B' the ballroom. Use the key to reference your current location, the crime location, and visited locations. Use the WASD keys and ENTER to navigate.";
        System.out.println("\nYou are a detective hired to solve a murder at the Sierra Baker Hotel. The murderer is almost certainly someone already present at the location, either a guest or a staff member. Investigate the crime scene to discover evidence that connects one of the other people at the hotel to the crime. Be sure to carefully interview everyone you meet as they might know something about the other people - or even the evidence you find - that can help you in your investigation. When you are ready to make an accusation, visit the Hotel Manager in the lobby and inform him of your findings.\n\nThe box matrix will serve as your map. " + howMapWorks + "\n\nGood luck.\n");

        while (endGame == false) {
            choice = 0;

            mov.Run();

            //If the current room is the Crime room
            if (mov.CurrentLocation().crime == true) {
                thisLevel = true;

                while (thisLevel == true) {
                    System.out.println();
                    System.out.println("(1) Talk to Coroner | (2) Search | (3) Exit Room");
                    choice = scan.nextInt();

                    if (choice == 1) {
                        System.out.println();
                        System.out.println(coroner.greeting());
                        System.out.println();
                        System.out.println();
                        System.out.println(coroner.coronerInteraction());
                        System.out.println();
                    }

                    if (choice == 2) {
                        System.out.println();
                        search.initiate(mov.CurrentLocation());
                        System.out.println();
                    }

                    if (choice == 3) {
                        mov.Set_Loc(mov.loc[0],1);
                        thisLevel = false;
                    }
                }

            } else if (mov.CurrentLocation().hasNPC) { //If the current room has an NPC inside of it
                thisLevel = true;

                while (thisLevel == true) {
                    System.out.println();
                    System.out.println("(1) Talk to " + mov.CurrentLocation().getNPC().getCharName() + " | (2) Search | (3) Exit Room");
                    choice = scan.nextInt();

                    if (choice == 1) {
                        System.out.println();
                        gdh.initiate(mov.CurrentLocation().npc.getIsWitness());
                        System.out.println();
                    }

                    if (choice == 2) {
                        System.out.println();
                        search.initiate(mov.CurrentLocation());
                        System.out.println();
                    }

                    if (choice == 3) {
                        mov.Set_Loc(mov.loc[0],1);
                        thisLevel = false;
                    }
                }

            } else if (mov.CurrentLocation().isLobby) { //If the current room is the lobby
                thisLevel = true;
                while (thisLevel == true) {
                    System.out.println();
                    System.out.println("(1) Talk to Hotel Manager | (2) Search | (3) Stop Lingering");
                    choice = scan.nextInt();

                    if (choice == 1) {
                        System.out.println();
                        hmh.initiate();
                        System.out.println();
                    }

                    if (choice == 2) {
                        System.out.println();
                        search.initiate(mov.CurrentLocation());
                        System.out.println();
                    }

                    if (choice == 3) {
                        thisLevel = false;
                        mov.Set_Loc(mov.loc[0],1);
                    }

                    if (player.getGameOver() == true)
                        break;
                }
        
            } else if (mov.CurrentLocation().isPublic) {
                thisLevel = true;
                while (thisLevel == true) {
                    System.out.println("(1) Call out | (2) Search | (3) Exit Room");
                    choice = scan.nextInt();

                    if (choice == 1) {
                        System.out.println();
                        System.out.println("No one seems to acknowledge you.");
                        System.out.println();
                    }

                    if (choice == 2) {
                        System.out.println();
                        search.initiate(mov.CurrentLocation());
                        System.out.println();
                    }

                    if (choice == 3) {
                        thisLevel = false;
                        mov.Set_Loc(mov.loc[0],1);
                    }                    
                }
            } else {
                mov.Set_Loc(mov.loc[0],1);
            }

            if (player.getGameOver() == true)
                endGame = true;
        }

        if (player.getCorrectAccusation() == true) {
            System.out.println("******************************");
            System.out.println("*                            *");
            System.out.println("*         YOU WIN!!!         *");
            System.out.println("*                            *");
            System.out.println("******************************");
        } else {
            System.out.println("******************************");
            System.out.println("*                            *");
            System.out.println("*         YOU LOSE!!!        *");
            System.out.println("*                            *");
            System.out.println("******************************");
        }

        // while (endGame == false) {
        //     choice = 0;
        //     System.out.println();
            
        //     //Start
        //     System.out.println("Who would you like to talk to?\nPress (1) for Hotel Manager\nPress (2) for General Character\nPress (3) for Coroner\nPress (4) to exit game\n");
        //     choice = scan.nextInt();
            
        //     //Hotel Manager
        //     if(choice == 1) {
        //         hmh.initiate();
        //     }

        //     //General Character
        //     if (choice == 2) {
        //         gdh.initiate();
        //     }

        //     //Coroner
        //     if(choice == 3) {
        //         System.out.println();
        //         System.out.println(coroner.greeting());
        //         System.out.println();
        //         System.out.println(coroner.coronerInteraction());
        //     }

        //     //Exit Game
        //     if(choice == 4) {
        //         endGame = true;
        //     } 
        //}

        //scan.close();


        //Layer 1: Map Shown - movement keys (w,a,s,d)
        //Layer 2: Map Hidden (Room Entered) - search, encounter, exit
        //Layer 3a: search options -> return strings
        //Layer 3b: encounter options -> return strings
    }
}

//         .--,--.
//        `.  ,.'
//         |___|
//         :o o:   O    The Chef
//        _`~^~'_  |    
//      /'   ^   `\=)
//    .'  _______ '~|
//    `(<=|     |= /'
//        |     |
//       (|_____|)
//        |  |  |
//        |  |  |
//        |  |  |
//        |  |  |
//      (___(___|


//     _____
//     \/\  |  
//     ((/ \))))
//     ((),>(((
//      \__ ))
//       __\((__
//      /  )\/\,\         The Maid
//     /.|/ _)_) \
//    ( \ \  o| \|_
//     \|  )_o| (__\
//    _/| /.__|  _/ \__
//   _(_//  /|\\ \ ||\.\
//      /   \|/ \ \_____\
//     '-..___.'
//      \  |/
//       \ |
//      .')|
//     ( / |
//     /.\ |
//   (_ \ )|
//    ) -/ )
//     -'_/|

//                ,
//             ,:' `..;
//             `. ,;;'%
//             +;;'%%%%%
//              /- %,)%%
//              `   \ %%
//               =  )/ \
//               `-'/ / \
//                 /\/.-.\
//                |  (    |
//                |  |   ||
//            _.-----'   ||     The Senator
//           / \________,'|
//          (((/  |       |
//         //     | \     |
//        //      |  \    |
//       //       |   \   |
//      //        |    \  |
//     //         \    \\ |
//    c'          |\    \\|
//                |.\    \
//               _\  \.-' \ 
//              (___(__.'\/

//        .---.
//       /_____\
//       ( '.' )
//        \_-_/_
//     .-"`'V'//-.
//    / ,   |// , \
//   / /|Ll //Ll|\ \
//  / / |__//   | \_\
//  \ \/---|[]==| / /       The Imperialist
//   \/\__/ |   \/\/
//    |/_   | Ll_\|
//      |`^"""^`|
//      |   |   |
//      |   |   |
//      |   |   |
//      |   |   |
//      L___l___J
//       |_ | _|
//      (___|___)
//       ^^^ ^^^

//      _/.-
//   ../.-'(()
//  (( ) )))
//   /)- _))
//  ( \_  )
//   \-\|(__
//    \/-'  \  
//    (_) |\-\ 
//     | (  ) )          The Dancer
//     |--\/_'
// _.-'  . \_'._
// '-.'_|_|__\.-'
//     | /. \
//     |(  '.\
//     \ \   \'.
//      \_)   \_)
//       )|    \|   
// ___,-'__)___|\
//             | )
//             '.'

//          *
//         / \
//        / * \
//       @@@@@@@
//      (  @ @  )
//       \  l  /
//        \ 0 /
//      __@@@@@__
//     /    *    \
//    / /|  *  |\ \         The Goon
//   / / |  *  | \ \
//  ( (  |  *  |  ) )
//   \ \ |  *  | / /
//    \ \|#####|/ /
//     &&|#####|&&
//      %|##|##|%
//       |##|##|
//       (##|##)
//       |##|##|
//      _|##|##|_
//     (^^^^|^^^^)
//     """""""""""



        // 
        // 
        // Evidence[] combo2 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.ROOM_KEY};
        // Evidence[] combo3 = {Evidence.ANTIQUE_WATCH, Evidence.CIGAR, Evidence.STRAY_HAIR};
        // Evidence[] combo4 = {Evidence.ANTIQUE_WATCH, Evidence.EMPTY_BILLFOLD, Evidence.HIP_FLASK};
        // Evidence[] combo5 = {Evidence.ANTIQUE_WATCH, Evidence.EMPTY_BILLFOLD, Evidence.ROOM_KEY};
        // Evidence[] combo6 = {Evidence.ANTIQUE_WATCH, Evidence.EMPTY_BILLFOLD, Evidence.STRAY_HAIR};
        // 
        // Evidence[] combo8 = {Evidence.ANTIQUE_WATCH, Evidence.HIP_FLASK, Evidence.STRAY_HAIR};
        // Evidence[] combo9 = {Evidence.ANTIQUE_WATCH, Evidence.ROOM_KEY, Evidence.STRAY_HAIR};
        // Evidence[] combo10 = {Evidence.CIGAR, Evidence.EMPTY_BILLFOLD, Evidence.HIP_FLASK};
        // Evidence[] combo11 = {Evidence.CIGAR, Evidence.EMPTY_BILLFOLD, Evidence.ROOM_KEY};
        // Evidence[] combo12 = {Evidence.CIGAR, Evidence.EMPTY_BILLFOLD, Evidence.STRAY_HAIR};
        // Evidence[] combo13 = {Evidence.CIGAR, Evidence.HIP_FLASK, Evidence.ROOM_KEY};
        // Evidence[] combo14 = {Evidence.CIGAR, Evidence.HIP_FLASK, Evidence.STRAY_HAIR};
        // 
        // Evidence[] combo16 = {Evidence.EMPTY_BILLFOLD, Evidence.HIP_FLASK, Evidence.ROOM_KEY};
        //
        // 
        // Evidence[] combo19 = {Evidence.HIP_FLASK, Evidence.ROOM_KEY, Evidence.STRAY_HAIR};
