//1st Clue: Found when searching the crime room
//2nd Clue: Found after questioning the witness (leads to a PUBLIC ACCESS room)
//3rd Clue: Found when searching the suspect's room

//General Note: The player must find these clues in order
// -> 1st clue must be found before the 2nd clue
//   -> 2nd clue must be found before the 3rd clue

import java.util.Random;

public class EvidenceDialogue {

    private Random rand;
    private Player player;
    
    public EvidenceDialogue(Player player) {
        this.player = player;
        rand = new Random();
    }

    //********************IF INSIDE THE CRIME ROOM (FIRST EVIDENCE)********************
        public String crimeAntiqueWatch(boolean isThere) {
            if (isThere == true) {
                player.setFirstEvidence(true);                                                                                                          //Hayden Addition
                String description = "You find a smashed pocket watch peeking out from beneath a table. It looks like it was thrown there.\nANTIQUE WATCH FOUND";
                return description;
            } else {
                String notThere = "The undersides of things are clean and free of dust. You should complement the maid service.";
                return notThere;
            }
        }

        public String crimeEmptyBillfold(boolean isThere) {
            if (isThere == true) {   
                player.setFirstEvidence(true);                                                                                                              //Hayden Addition
                String description = "A wallet is wide open on the floor at the edge of the room. There\'s nothing inside it, not even cobwebs.\nEMPTY BILLFOLD FOUND";
                return description;
            } else {
                String notThere = "It\'s a murder scene. You\'ve seen many like it. They wear on you.";
                return notThere;
            }
        }

        public String crimeStrayHair(boolean isThere) {
            if (isThere == true) {   
                player.setFirstEvidence(true);                                                                                                                                                               //Hayden Addition
                String description = "When you inspect the victim more closely, you notice a single strand of hair clinging to their shirt. It is long and clearly doesn\'t belong to the victim.\nSTRAY HAIR FOUND";
                return description;
            } else {
                String notThere = "Things are the way the coroner said they were. You find yourself staring into the victims eyes. The coroner coughs. You remember yourself, and step away.";
                return notThere;
            }
        }

        public String crimeHipFlask(boolean isThere) {
            if (isThere == true) {  
                player.setFirstEvidence(true);                                                                                                                                                   //Hayden Addition
                String description = "A small, metal drinking flask sits open on the bedside table. It stinks of liquor. The coroner assures you that the victim wasn\'t drinking\nHIP FLASK FOUND";
                return description;
            } else {
                String notThere = "There are loose clothes in the closet, a suitcase, a locket, and a few books. Nothing out of the ordinary.";
                return notThere;
            }
        }

        public String crimeCigar(boolean isThere) {
            if (isThere == true) {   
                player.setFirstEvidence(true);                                                                                                                                                                                                         //Hayden Addition
                String description = "There are scattered ashes around the victim and near the window. It appears that someone paced the room while smoking and, if you sniff, you can almost make out the scent of tobacco still on the air.\nCIGAR FOUND";
                return description;
            } else {
                String notThere = "It appears well swept and free of debris. Well...except for the dead person.";
                return notThere;
            }
        }

        public String crimeRoomKey(boolean isThere) {
            if (isThere == true) {   
                player.setFirstEvidence(true);                                                                                                                                                                             //Hayden Addition
                String description = "The door swings easily on its hinges and the knob turns smoothly. You deduce there are no signs of forced entry. Whoever is responsible must have had a key to the lock.\nROOM KEY FOUND";
                return description;
            } else {
                String notThere = "The door has been kicked in. The wood around the locking mechanism is splintered like broken teeth.";
                return notThere;
            }
        }

    //********************IF INSIDE PUBLIC ROOM (SECOND EVIDENCE)********************

        public String pubAntiqueWatch() {
            player.setSecondEvidence(true);
            String description = "An old pocketwatch catches your eye with a wink of light. It\'s ornamented cover is made of well-polished silver.\nANTIQUE WATCH FOUND";
            return description;
        }

        public String pubEmptyBillfold() {
            player.setSecondEvidence(true);
            String description = "A discarded wallet is on the floor. There\'s nothing inside it, not even cobwebs.\nEMPTY BILLFOLD FOUND";
            return description;
        }

        public String pubStrayHair() {
            player.setSecondEvidence(true);
            String description = "By a trick of the light you happen to notice a single strand of hair. It is quite long, and shines like a spider\'s string on a damp morning.\nSTRAY HAIR FOUND";
            return description;
        }

        public String pubHipFlask() {
            player.setSecondEvidence(true);
            String description = "Here you find a discarded hipflask, a neccessary item for discrete drinkers on the go.\nHIP FLASK FOUND";
            return description;
        }

        public String pubCigar() {
            player.setSecondEvidence(true);
            String description = "Something smells like smoke, but all the ash trays have been recently cleaned. You notice black specs on the floor beside a once luxuriant carpet. When you lift it, you see a trampled cigar butt beneath. Singe marks testify how narrowly this place came to a fire.\nCIGAR FOUND";
            return description;
        }

    //********************IF INSIDE A PRIVATE ROOM (THIRD EVIDENCE)*******************
        
        public String privAntiqueWatch(boolean isThere) {
            if (isThere == true) {
                player.setThirdEvidence(true);
                String description = "\nANTIQUE WATCH FOUND";
                return description;
            } else {
                String notThere = "Nothing to fucking return yet";
                return notThere;
            }
        }

        public String privEmptyBillfold(boolean isThere) {
            if (isThere == true) {
                player.setThirdEvidence(true);
                String description = "\nEMPTY BILLFOLD FOUND";
                return description;
            } else {
                String notThere = "This is all because of you Winton";
                return notThere;
            }
        }

        public String privStrayHair(boolean isThere) {
            if (isThere == true) {
                player.setThirdEvidence(true);
                String description = "\nSTRAY HAIR FOUND";
                return description;
            } else {
                String notThere = "Are you seriously this selfish?";
                return notThere;
            }
        }

        public String privHipFlask(boolean isThere) {
            if (isThere == true) {
                player.setThirdEvidence(true);
                String description = "\nHIPFLASK FOUND";
                return description;
            } else {
                String notThere = "Never should've trusted a fucking English major";
                return notThere;
            }
        }

        public String privCigar(boolean isThere) {
            if (isThere == true) {
                player.setThirdEvidence(true);
                String description = "\nCIGAR FOUND";
                return description;
            } else {
                String notThere = "This is fucking bullshit";
                return notThere;
            }
        }

    //********************RETURN STRINGS IF THERE IS NOTHING TO SEARCH********************
    public String nothing() {
        String zero = "There doesn\'t seem to be anything here.";
        String one = "Nothing in here is going to help the case.";
        String two = "Not every two dots are going to be connected.";
        String three = "Maybe try again later?";
        String four = "Nothing seems out of the ordinary.";

        int num = rand.nextInt(5);

        if (num == 0) {
            return zero;
        } else if (num == 1) {
            return one;
        } else if (num == 2) {
            return two;
        } else if (num == 3) {
            return three;
        } else {
            return four;
        }
    }
}
