//THIS CLASS INCLUDES DIALOGUE FOR BOTH THE CORONER AND THE TRUE SUSPECT

public class Coroner {

    private CauseOfDeath cod;
   
    public Coroner(CauseOfDeath cod) {
        this.cod = cod;
    }

    public String greeting() { //On greeting the coroner
        String greet = "The coroner stands over the body. He chews on the end of a pencil and takes illegible notes on a small pad.\n\n\"I\'ll tell you what I know. For starters: they\'re dead.\"";
        return greet;
    }

    //General interaction that returns String based on Cause of Death
    public String coronerInteraction() {
        if (cod == CauseOfDeath.SHOT) {
            return coronerShot();
        } else if (cod == CauseOfDeath.STABBED) {
            return coronerStabbed();
        } else if (cod == CauseOfDeath.STRANGLED) {
            return coronerStrangled();
        } else {
            return coronerPossessed();
        }
    }

    //General interaction that returns String based on Cause of Death
    public String suspectInteraction() {
        if (cod == CauseOfDeath.SHOT) {
            return suspectShot();
        } else if (cod == CauseOfDeath.STABBED) {
            return suspectStabbed();
        } else if (cod == CauseOfDeath.STRANGLED) {
            return suspectStrangled();
        } else {
            return suspectPossessed();
        }
    }

    public String coronerShot() { //What coroner says if cause of death is Shot
        String shot = "\"Multiple entry wounds and mostly the same number of exit wounds. I\'d guess a small caliber handgun. Either the shooter was a poor shot, or they were firing close and from the hip. This dive must get noisy for no one to have heard all the banging.\"\n\nHe sticks the pencil through one of the wounds to test its depth.\n\n\"I sent my assistant to check all the trashcans and he didn\'t find a gun, so the suspect probably still has the weapon on them. Be careful.\"";
        return shot;
    }

    public String suspectShot() { //What suspect  says if cause of death is Shot
        String shot = "As soon as you reach to pat down the suspect, they quickly back away and reach behind them. You already know what\'s coming next and charge forward. The two of you tangle. A lamp is knocked over. The Manager screams like a soprano. The suspect swings a pistol toward you, but you smack it away and twist their arm into a painful vice.\n\nThe Manager ushers in two imposing guards who take the suspect away.";
        return shot;
    }

    public String coronerStabbed() { //What coroner says if cause of death is Stabbed
        String stabbed = "\"My brother once played a cruel joke on this boy we knew involving a knife, a thanksgiving turkey, and a campfire story. He must have stabbed that thing a hundred times, which is almost as many as our victim was stabbed.\n\n\"But they didn\"t go down without a fight. The knife broke in the struggle. I imagine at least some of the blood here belongs to our perp. Whoever it is, they\'ll have wounds and be needing treatment.\"";
        return stabbed;
    }

    public String suspectStabbed() { //What suspect says if cause of death is Stabbed
        String stabbed = "The first thing you notice is what looks like a stray thread hanging from the suspect\'s shirt sleeve. They bow their head and sigh while you pull the sleeves back to reveal fresh bandages wound tightly around their arms.\n\n\"Trouble shaving?\" You ask. The suspect doesn\'t smile.\n\nThe Manager ushers in two imposing guards who take the suspect away.";
        return stabbed;
    }

    public String coronerStrangled() { //What coroner says if cause of death is Strangled
        String strangled = "\"The victim expired due to asphyxia and, as you can see from the marks on the neck, it probably wasn\'t a natural occurrence. The room got torn apart in a fight and the victim has defensive wounds on the knuckles. I\'d bet your suspect is hiding some serious bruises.\"\n\nSuddenly, the coroner grabs his throat and gags. His face turns blue. He looks to you, terror filled eyes asking existential questions. Something in him gurgles and gives. He coughs and the pencil eraser spits out onto your shirt.\n\n\"Sorry,\" the coroner says, \"bit down too hard. Nervous habit.\"";
        return strangled;
    }

    public String suspectStrangled() { //What suspect says if cause of death is Strangled
        String strangled = "You give the suspect a simple pat down but put a touch more force than necessary into it. They wince and recoil, as if stung. Next you ask them to walk across the room. They try to hide it, but they have a slight limp. The suspect gives a halfhearted excuse about late night gorilla boxing.\n\nThe Manager ushers in two imposing guards who take the suspect away.";
        return strangled;
    }

    public String coronerPossessed() { //What coroner says if cause of death is Possessed
        String possessed = "The coroner holds you back at the doorway. He looks pale.\n\n\"I\'ve only seen this kind of thing once before. Notice the way the victims is twisted? And that smile...how does a corpse smile?\"\n\nHe points to a chalk circle in the center of the room.\n\n\"Something was summoned. We\'re dealing with a practitioner of the occult, and a skilled one too. I know you probably won\'t believe me, but anyone who knows enough to lay this kind of trap won\'t go far without their esoterica.\"\n\nAs you walk away, the coroner shouts one more thing at you.\n\n\"Figure this one out fast. Whatever the...thing...was I hope it\'s gone but I also don\'t want to stay here to find out.\"";
        return possessed;
    }

    public String suspectPossessed() { //What suspect says if cause of death is Possessed
        String possessed = "You conduct a thorough inspection of the suspect but find nothing. They smile at your helplessness and look to the manager for vindication.\n\nBut you notice the bedside drawer is slightly open. The suspect tries to draw you away from it: \"It\'s just a bible someone left. I was browsing,\" they say.\n\nIt is no bible. The binding is an unusual and wrinkled leather that makes your skin crawl to ponder. It stinks of sulfur and ozone. The suspect begins to chant something in an indescribable language. You see moonlight through the curtains (but isn\'t it almost noon?) and the floorboards moan with anger.\n\nThe manager beats you to the punch and decks the suspect in the mouth.\n\n\"I never did like Protestants,\" he says.\n\nThe Manager ushers in two imposing guards who take the suspect away.";
        return possessed;
    }
}