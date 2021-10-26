import java.util.Random;

public class GeneralDialogue {

    private String chef, maid, sen, imp, dan, goon;
    private Random rand;

    public GeneralDialogue(String chef, String maid, String sen, String imp, String dan, String goon) {
        rand = new Random();
        this.chef = chef;
        this.maid = maid;
        this.sen = sen;
        this.imp = imp;
        this.dan = dan;
        this.goon = goon;
    }

    /********************Generic Dialogue Tree********************/
    public String timeOfMurder() {
        String r1A = "\"I believe I was here, occupying my time.\"";
        String r1B = "\"Sitting right there. Haven\'t left this room all day. It\'s a good room.\"";
        String r1C = "\"I...well, hold on, when did this murder happen exactly?\"";

        int num = rand.nextInt(3);

        if (num == 0) {
            return r1A;
        } else if (num == 1) {
            return r1B;
        } else {
            return r1C;
        }
    }
    
    public String searchYou(boolean managerPresent, String charName) {
        if (managerPresent == true) {
            String r21A = "\"Like heck you are. Come back with a warrant, cop.\"";
            String r21B = "\"Over my dead body, and haven\'t you done enough of that for one day?\"";

            int num = rand.nextInt(2);

            if (num == 0) {
                return r21A;
            } else {
                return r21B;
            }

        } else {
            String r22 = charName + " looks to the manager with an anxious glare but says nothing. They lift their arms in a sign of assent.";
            return r22;
        }
    }

    public String knowVictim() {
        String r3A = "\"Everybody knows everybody here. We\'re all regulars.\"";
        String r3B = "\"Not very well, but well enough.\"";
        String r3C = "\"The walls are thin and the keyholes are wide, if ya know what I mean.\"";

        int num = rand.nextInt(3);

        if (num == 0) {
            return r3A;
        } else if (num == 1) {
            return r3B;
        } else {
            return r3C;
        }
    }

    public String witness(Boolean isWitness, String secondEvRoom, String murdRoom) {
        if (isWitness == true) {
            String reply = "\"I saw someone running toward " + secondEvRoom + " just before the body was found. They seemed to be running from the " + murdRoom + ".\"";
            return reply;
        } else {
            String reply0 = "\"No, I can\'t say I have.\"";
            String reply1 = "\"What does ordinary even mean around here?\"";
            String reply2 = "\"Strange people come through here every day. Do you want a list?\"";
            String reply3 = "\"Even if I have, maybe I don\'t want to tell you.\"";

            int num = rand.nextInt(4);

            if (num == 0) {
                return reply0;
            } else if (num == 1) {
                return reply1;
            } else if (num == 2) {
                return reply2;
            } else {
                return reply3;
            }
        }
    }

    public String otherPeopleHere(String charName) {

        int num = rand.nextInt(2);

        if (charName.equals(chef)) {
            String r91A = "\"The chef here makes great food, but I wish he\'d wear a hair net.\"";
            String r91B = "\"" + imp + " and " + chef + " share a puff together some nights, but all they talk about is their time in France.\"" ;

            if (num == 0) {
                return r91A;
            } else {
                return r91B;
            }
        } else if (charName.equals(maid)) {
            String r92A = "\"The maid tried to guilt me into tipping her yesterday. Can you even imagine?\"";
            String r92B = "\"Don\'t leave valuables in your room. They disappear after the cleaning lady comes around.\"";

            if (num == 0) {
                return r92A;
            } else {
                return r92B;
            }
        } else if (charName.equals(sen)) {
            String r93A = "\"" + sen + " likes to flash his timepiece a lot. It\'s the last bit of glamour he has left.\"";
            String r93B = "\"" + sen + " drinks on the roof late at night. You can hear him stumbling down the stairs, after.\"";

            if (num == 0) {
                return r93A;
            } else {
                return r93B;
            }
        } else if (charName.equals(imp)) {
            String r94A = "\"He might act like the bees knees, but " + imp + " hasn\'t paid his bar tab.\n\n\"Did I say bar tab? I meant...coffee...budget. I haven\'t stepped foot in a bar in years. Couldn\'t tell you where to find one. Honest.\"";
            String r94B = "\"He smells like old money, and he doesn\'t even have the money anymore.\"";

            if (num == 0) {
                return r94A;
            } else {
                return r94B;
            }
        } else if (charName.equals(dan)) {
            String r95A = "\"I can believe she\'s an excellent performer, I\'ve just never seen her sober.\"";
            String r95B = "\"She doesn\'t buy her own drinks. No, I don\'t think anyone is flirting with her, I think they feel bad.\"";

            if (num == 0) {
                return r95A;
            } else {
                return r95B;
            }
        } else if (charName.equals(goon)) {
            String r96A = "\"He was waiting for me in my room, once. It was my own fault; I know what happens to loudmouths. Thankfully, he was just there to give me a warning.\"";
            String r96B = "\"I heard he took his timepiece off a Kraut officer at Belleau Wood.\"";

            if (num == 0) {
                return r96A;
            } else {
                return r96B;
            }
        } else {
            return "ERROR: DIALOGUE.JAVA 131";
        }
    }

            /*************************Evidence Questions************************/

            public String cigar(boolean hasCigar, String charName) {
                if (hasCigar == true) {
                    String r41 = charName + " snorts, \"Yes, but only Havanas. It isn’t just about the flavor, it’s about class\".";
                    return r41;
                } else {
                    String r42A = "\"Not for a long time, I quit during the war.\"";
                    String r42B = "\"Sure, butt me, though I ain’t got a light.\"";

                    int num = rand.nextInt(1);

                    if (num == 0) {
                        return r42A;
                    } else {
                        return r42B;
                    }
                }
            }

            public String antWatch(boolean hasWatch, String charName) {
                if (hasWatch == true) {
                    String r51 = charName + "reaches into their shirt and removes a gilded pocket watch of immaculate state and rare design.\n" + "\n \"It’s a quarter to noon,\" they say.";
                    return r51;
                } else {
                    String r52A = "\"Uh…noonish? Maybe?\"";
                    String r52B = charName + " holds their wrist to their face and squints at the dial on a wrist watch. \"It’s uh…shoot! Must have forgot to wind it, the thing’s kicked off.\"";

                    int num = rand.nextInt(2);

                    if (num == 0) {
                        return r52A;
                    } else {
                        return r52B;
                    }
                }
            }

            public String hipFlask(boolean hasFlask, String charName) {
                if (hasFlask == true) {
                    String r61 = "\"Here, have a nip on me,\" " + charName + " says. They produce a small flask from somewhere on their person. You did not see where it was hidden and after a sip of something strong and caustic you fail to see where it disappears to.";
                    return r61;
                } else {
                    String r62A = "\"There’s water in the kitchen.\"";
                    String r62B = charName + " sighs and says, \"Me too. But being quenched is expensive.\"";

                    int num = rand.nextInt(2);

                    if (num == 0) {
                        return r62A;
                    } else {
                        return r62B;
                    }
                }
            }

            public String strayHair(boolean hasHair, String charName) {
                if (hasHair == true) {
                    String r71 = "\"Thank you!\" " + charName + " runs their fingers through an exquisite mane that flows beyond their shoulders. \"I know it’s not in style, but what can I say? It grew on me.\"";
                    return r71;
                } else {
                    String r72A = "\"You must be joking.\"";
                    String r72B = "\"What? Are you trying to flirt with me?\"";

                    int num = rand.nextInt(1);

                    if (num == 2) {
                        return r72A;
                    } else {
                        return r72B;
                    }
                }
            }

            public String billFold(boolean hasFold, String charName) {
                if (hasFold == true) {
                    String r81 = "\"’Fraid I’m all out of clams.\" " + charName + " produces a small, worn wallet and opens it. \"Emptier than an upside-down jar.\"";
                    return r81;
                } else {
                    String r82A = "\"Yes, but I won’t.\""; 
                    String r82B = "\"All I have are $2 bills.\"";

                    int num = rand.nextInt(2);

                    if (num == 0) {
                        return r82A;
                    } else {
                        return r82B;
                    }
                }
            }
            
            
}