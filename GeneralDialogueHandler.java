import java.util.Scanner;

public class GeneralDialogueHandler {
   
    private Scanner scan;
    private GeneralDialogue di;
    private boolean isWitness; //This will need to be implemented
    private int choice;
    private NPC[] characters;

    public GeneralDialogueHandler(NPC[] characters) {
        scan = new Scanner(System.in);
        this.characters = characters;
        
        //Dialogue Parameters:
        //String chef, String maid, String goon, String dancer, String senator, String imperialist
        di =  new GeneralDialogue(characters[0].getCharName(), characters[1].getCharName(), characters[2].getCharName(), characters[3].getCharName(), characters[4].getCharName(), characters[5].getCharName());

        choice = 0;
    }

    public void initiate() {
        level1(true); //starting isWitness as true
    }

    //First Level of the General Dialogue Tree
    public void level1(boolean level1) {

            while (level1 == true) {
                this.choice = 0;
                System.out.println();
                System.out.println("(1) Where were you at the time of the murder?\n(2) I'm going to have to search you\n(3) Did you know the victim?\n(4) Have you noticed anything out of the ordinary?\n(5) What can you tell me about the other people here?\n(6) Go back");
                System.out.println();
                choice = scan.nextInt();
                System.out.println();

                        //call timeOfMurder()
                        if(choice == 1) {
                            System.out.println(di.timeOfMurder());
                        }

                        //call searchYou()
                        if(choice == 2) {
                            System.out.println(di.searchYou(true, "ENTER SUSPECTED CHARACTER NAME HERE"));
                        }

                        //call knowVictim()
                        if(choice == 3) {
                            System.out.println(di.knowVictim());
                        }

                        if (choice == 4) {
                            System.out.println(di.witness(isWitness, "ENTER SECOND EVIDENCE ROOM", "ENTER MURDER ROOM"));
                        }

                        if(choice == 5) {
                            System.out.println("\"Anyone specific?\"\n");
                            level2(true); //Advance to Level 2
                        }

                        //Exit Level 1
                        if (choice == 6) {
                            level1 = false;
                        }
            }
    }

    //Second level of the General Dialogue Tree
    public void level2(boolean level2) {
        choice = 0;

            while (level2 == true) {
                System.out.println();
                System.out.println("(1) Chef\n(2) Maid\n(3) Senator\n(4) Imperialist\n(5) Dancer\n(6) Goon\n(7) Go back");
                System.out.println();
                choice = scan.nextInt();
                System.out.println();
                
                if (choice != 7) {
                    level3(choice);
                } else {
                    level2 = false;
                }
            }
    }

    //Switch statement for otherPeopleHere() method
    public void level3(int choice) {
        switch (choice) {
            case 1:
                System.out.println(di.otherPeopleHere(characters[0].getCharName()));
                break;
            case 2:
                System.out.println(di.otherPeopleHere(characters[1].getCharName()));
                break;
            case 3:
                System.out.println(di.otherPeopleHere(characters[2].getCharName()));
                break;
            case 4:
                System.out.println(di.otherPeopleHere(characters[3].getCharName()));
                break;
            case 5:
                System.out.println(di.otherPeopleHere(characters[4].getCharName()));
                break;
            case 6:
                System.out.println(di.otherPeopleHere(characters[5].getCharName()));
                break;
            default:
                System.out.println("I\'m afraid I don\'t know who that is.");
        }
    }
}