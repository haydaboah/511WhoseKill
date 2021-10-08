//1st Clue: Found when searching the crime room
//2nd Clue: Found after questioning the witness (leads to a PUBLIC ACCESS room)
//3rd Clue: Found when searching the suspect's room

//General Note: The player must find these clues in order
// -> 1st clue must be found before the 2nd clue
//   -> 2nd clue must be found before the 3rd clue

public class EvidenceDialogue {
    
    public EvidenceDialogue() {

    }

    public String antiqueWatch(boolean isThere) {
        if (isThere == true) {
            String description = "You find a smashed pocket watch peeking out from beneath a table. It looks like it was thrown there.";
            return description;
        } else {
            String notThere = "The undersides of things are clean and free of dust. You should complement the maid service.";
            return notThere;
        }
    }

    public String emptyBillfold(boolean isThere) {
        if (isThere == true) {
            String description = "A wallet is wide open on the floor at the edge of the room. There’s nothing inside it, not even cobwebs.";
            return description;
        } else {
            String notThere = "It\'s a murder scene. You\'ve seen many like it. They wear on you.";
            return notThere;
        }
    }

    public String strayHair(boolean isThere) {
        if (isThere == true) {
            String description = "When you inspect the victim more closely, you notice a single strand of hair clinging to their shirt. It is long and clearly doesn\'t belong to the victim.";
            return description;
        } else {
            String notThere = "Things are the way the coroner said they were. You find yourself staring into the victims eyes. The coroner coughs. You remember yourself, and step away.";
            return notThere;
        }
    }

    public String hipFlask(boolean isThere) {
        if (isThere == true) {
            String description = "A small, metal drinking flask sits open on the bedside table. It stinks of liquor. The coroner assures you that the victim wasn\'t drinking";
            return description;
        } else {
            String notThere = "There are loose clothes in the closet, a suitcase, a locket, and a few books. Nothing out of the ordinary.";
            return notThere;
        }
    }

    public String cigar(boolean isThere) {
        if (isThere == true) {
            String description = "There are scattered ashes around the victim and near the window. It appears that someone paced the room while smoking and, if you sniff, you can almost make out the scent of tobacco still on the air.";
            return description;
        } else {
            String notThere = "It appears well swept and free of debris. Well...except for the dead person.";
            return notThere;
        }
    }

    public String roomKey(boolean isThere) {
        if (isThere == true) {
            String description = "The door swings easily on its hinges and the knob turns smoothly. You deduce there are no signs of forced entry. Whoever is responsible must have had a key to the lock.";
            return description;
        } else {
            String notThere = "The door has been kicked in. The wood around the locking mechanism is splintered like broken teeth.";
            return notThere;
        }
    }
}
