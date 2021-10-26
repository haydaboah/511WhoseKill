import java.util.Scanner;

public class HotelManagerHandler {

    private Scanner scan;
    private HotelManager hm;
    private int choice;
    private NPC[] characters;

    public HotelManagerHandler(NPC[] characters) {
        scan = new Scanner(System.in);
        this.characters = characters;
        hm = new HotelManager();
        choice = 0;
    }

    public void initiate() {
        System.out.println();
        System.out.println(hm.firstEncounter("ENTER MURDER ROOM HERE"));
        System.out.println();
        //TimeUnit.SECONDS.sleep(1); //Wait one second
        System.out.println(hm.greeting());
        System.out.println();
        level1(true);
    }

    //First level of the Hotel Manager dialogue tree
    public void level1(Boolean level1) {

            //while we are on the first level
            while(level1 == true) {
                choice = 0;
                System.out.println("(1) Inquire about crime\n(2) Tell me about the other people here\n(3) Does this look familiar to you?\n(4) Go back\n");
                System.out.println();
                choice = scan.nextInt();
                System.out.println();

                        //call inquireCrime()
                        if(choice == 1) {
                            System.out.println(hm.inquireCrime("ENTER MURDER ROOM HERE"));
                            System.out.println();
                        }

                        //call otherPeople()
                        if(choice == 2) {
                            System.out.println(hm.otherPeople());
                            level2(true); //Jump to level 2
                            level1 = false; //must reset every iteration
                        }

                        if(choice == 3) {
                            level4(true);
                        }
                        //exit level 1
                        if(choice == 4) {
                            level1 = false;
                        }
        }
    }

    //Which Character To Know More About
    public void level2(Boolean level2) {

            //while we are on the second level
            while(level2 == true) {
                choice = 0;
                System.out.println();
                System.out.println("(1) Chef\n(2) Maid\n(3) Senator\n(4) Imperialist\n(5) Dancer\n(6) Goon\n(7) Go back");
                System.out.println();
                choice = scan.nextInt();
                System.out.println();

                if(choice != 7) {
                    level3(choice);
                } else {
                    level2 = false;
                    level1(true);
                }
            }
    }

    //Switch statement for otherPeopleHere()
    public void level3(int choice) {
        //Switch for Choice
        switch (choice) {
            case 1:
                System.out.println(hm.chefChosen("ENTER CHEF ROOM HERE"));
                break;
            case 2:
                System.out.println(hm.maidChosen("ENTER MAID ROOM HERE"));
                break;
            case 3:
                System.out.println(hm.senChosen("ENTER SENATOR ROOM HERE"));
                break;
            case 4:
                System.out.println(hm.impChosen("ENTER IMPERIALIST ROOM HERE"));
                break;
            case 5:
                System.out.println(hm.danChosen("ENTER DANCER ROOM HERE"));
                break;
            case 6:
                System.out.println(hm.goonChosen("ENTER GOON ROOM HERE"));
                break;
            default:
                System.out.println("I\'m afraid I don\'t know who that is.");
        }

    }
    
    //Which Evidence To Know More About
    public void level4(Boolean level4) {
        choice = 0;

        while (level4 == true) {
            System.out.println();
            System.out.println("(1) Stray Hair\n(2) Cigar\n(3) Empty Billfold\n(4) Room Key\n(5) Antique Watch\n(6) Hipflask\n(7) Go Back");
            System.out.println();
            choice = scan.nextInt();
            System.out.println();

            if(choice != 7) {
                level5(choice);
            } else {
                level4 = false;
            }
        }
    }

    public void level5(int choice) {
        //Switch for Choice
        switch (choice) {
            case 1:
                System.out.println(hm.lookFamiliar("Stray Hair"));
                break;
            case 2:
                System.out.println(hm.lookFamiliar("Cigar"));
                break;
            case 3:
                System.out.println(hm.lookFamiliar("Empty Billfold"));
                break;
            case 4:
                System.out.println(hm.lookFamiliar("Room Key"));
                break;
            case 5:
                System.out.println(hm.lookFamiliar("Antique Watch"));
                break;
            case 6:
                System.out.println(hm.lookFamiliar("Hipflask"));
                break;
            default:
                System.out.println("I\'m afraid I don\'t know what that is.");
        }
    }
}