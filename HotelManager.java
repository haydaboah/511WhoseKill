import java.util.Random;

import javax.lang.model.util.ElementScanner14;

public class HotelManager {
    
    private boolean hasAsked; //this variable needed for inquireCrime() method
    private String[] evidence = {"Stray Hair", "Cigar", "Room Key", "Empty Billfold", "Antique Watch", "Hipflask"};
    private Random rand;

    public HotelManager() {
        rand = new Random();
        hasAsked = false;
    }

    public String firstEncounter(String murdRoom) {
        String intro = "An anxious Hotel Manager approaches you and shakes your hand.\n\n\"I\'m sure you\'ve deduced this by now, detective, but there has been a murder. I am the manager of this establishment, and I would appreciate it if the case was solved before the police become involved. Many of my guests had a purely political disagreement with Congress when the Eighteenth amendment passed, and gumshoes make them anxious. You understand?\n\n\nThe deed seems to have happened in the " + murdRoom + ". The coroner is already there with the departed. I will stay here in the Hotel Lobby. Please come to me with any questions you have and let me know when you’re prepared to make an accusation.\"";
        return intro;
    }

    public String greeting() {
        String greeting = "\"Hello, Detective. How can I help you?\"";
        return greeting;
    }

    public String inquireCrime(String murdRoom) {
        String r11 = "\"One of the maids came to me and said she had heard awful noises coming from the " + murdRoom + ". I went there myself to check things out and...it was just awful. I didn’t even want to go inside. The coroner can tell you more.\"";
        String r12 = "\"I already told you, one of the maids heard a commotion and when I went to look, I found the victim dead.\"";

        if (hasAsked == false) {
            hasAsked = true;
            return r11;
        } else {
            return r12;
        }
    }

    //This will need special attention in the driver
    //Calling otherPeople MUST be followed up by specific Character selected
    //We could either do one function that takes in a character parameter OR one function for each character
    public String otherPeople() { 
        String r20 = "\"Who do you want to know more about?\"";
        return r20;
    }
        //Implementation of one function per character chosen
        public String chefChosen(String charRoom) {
            String r21 = "\"Oh! He\'s our own gourmand. A swell cook and all that. You can find him in the " + charRoom + " I think he trained in Europe. He has that...you know...he seems like he did, anyway.\"";
            return r21;
        }

        public String maidChosen(String charRoom) {
            String r22 = "\"She cleans the guest rooms. I haven\'t found a good reason to fire her. She\'s probably strolling in the " + charRoom + ".\"";
            return r22;
        }

        public String senChosen(String charRoom) {
            String r23 = "\"He\'s been here for a few months in the " + charRoom + ". I don\'t think his wife is going to let him back into the house. I'd say it was a shame but he voted for the dry laws. What goes around comes around.\"";
            return r23;
        }
        
        public String impChosen(String charRoom) {
            String r24 = "\"I don\'t know much about him except that he looks down his nose at the staff and will jaw on and on about how everything was better back in 'his day,\' whatever that means. He stays in the " + charRoom + ".\"";
            return r24;
        }

        public String danChosen(String charRoom) {
            String r25 = "\"I think she used to do ballet, or maybe line dancing? She\'s blotted most of the time. You can find her in the " + charRoom + ".\"";
            return r25;
        }

        public String goonChosen(String charRoom) {
            String r26 = "\"He pays his dues on time. You can almost always find him at the " + charRoom + ". A word of advice: don\'t bother him.\"";
            return r26;
        }

    //Takes in Evidence variable and returns random and correpsonding string
    public String lookFamiliar(String evName) {
        int num = 0;

        //Stray Hair
        String r31A = "\"Umm. It looks like a hair? It’s pretty long.\"";
        String r31B = "\"It’s not one of mine if that’s what you’re asking.\"";
        String r31C = "\"It probably belongs to someone with long hair. Please, stop waving it in my face.\"";

        //Cigar
        String r32A = "\"A number of our guests smoke. The Senator has imported cigars delivered to his room.\"";
        String r32B = "\"Are you asking me to identify a cigarette by its ash? Oh, wait, it smells like those cigars Eclectic Chef is fond of.\"";

        //Room Key
        String r33A = "\"All of our staff members have skeleton keys in case they need to enter a locked room.\"";
        String r33B = "\"It’s possible Stoic Goon stole one of our keys. I’ve caught him in parts of the hotel guests shouldn’t be able to access.\"";

        //Empty Billfold
        String r34A = "\"Whoever it belongs to doesn’t have much money.\"";
        String r34B = "\"If this belongs to a guest then I’m glad they paid for their room up front.\"";
        String r34C = "\"It’s hard times for people when they can lose their wallets and not even notice.\"";

        //Antique Watch
        String r35A = "\"Craftsmanship this fine must belong to someone important!\"";
        String r35B = "\"There was a guest a few months back who reported their pocket watch was stolen.\"";

        //Hipflask
        String r36A = "\"This belongs to a professional drinker. I can’t imagine where they would have gotten the hooch from, though.\"";
        String r36B = "\"Wherever this came from, I assure you that my establishment is dry.\"";
        String r36C = "\"Sniff around until you find the drunk who smells like the flask, and you’ll have your owner.\"";

        if (evName.equals(evidence[0])) {           //Stray Hair
            num = rand.nextInt(3);
            if (num == 0) {
                return r31A;
            } else if (num == 1) {
                return r31B;
            } else {
                return r31C;
            }
        } else if (evName.equals(evidence[1])) {    //Cigar
            num = rand.nextInt(2);
            if (num == 0) {
                return r32A;
            } else {
                return r32B;
            }
        } else if (evName.equals(evidence[2])) {    //Room Key
            num = rand.nextInt(2);
            if (num == 0) {
                return r33A;
            } else {
                return r33B;
            }
        } else if (evName.equals(evidence[3])) {    //Empty Billfold
            num = rand.nextInt(3);
            if (num == 0) {
                return r34A;
            } else if (num == 1) {
                return r34B;
            } else {
                return r34C;
            }
        } else if (evName.equals(evidence[4])) {    //Antique Watch
            num = rand.nextInt(2);
            if (num == 0) {
                return r35A;
            } else {
                return r35B;
            }
        } else if (evName.equals(evidence[5])) {    //Bill Flask
            num = rand.nextInt(3);
            if (num == 0) {
                return r36A;
            } else if (num == 1) {
                return r36B;
            } else {
                return r36C;
            }
        } else {
            return "ERROR HOTELMANAGER.JAVA 156";
        }
    }

    //method for making an accusation
    public String makeAccusation(String charName, String susGuess, String susChar) {
        String r4 = "\"Oh. God. Okay. Are you sure? I’ll meet you at the " + charName +"'s room. If they really did do it, then they must have evidence of the murder on their person. I can have security guards wait outside to help you with the arrest.\"\n\nThe anxious Manager disappears through a door behind the front desk.";
        return r4;
    }

    //method for the result of the accusation (true/false)
    public String postAccusation(boolean accusation) {
        String r5 = "\"Swell job, Detective! I wasn’t confident you’d be able to pull this off, but you’ve brought a criminal to justice and peace of mind to my humble hotel. Well done!\"";
        String r6 = "\"I suppose this is my fault. Mom always said I was a bad judge of character. Thank you for your services, Detective, but I think I’ll be looking elsewhere for help from now on.\"";

        if (accusation == true) {
            return r5;
        } else {
            return r6;
        }
    }
}