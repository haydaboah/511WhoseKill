import java.util.Scanner;

public class HotelManagerHandler {

    private Scanner scan;
    private HotelManager hm;
    private int choice;
    private NPC[] characters;
    private Player player;
    private NPC suspect;
    private boolean intro;

    public HotelManagerHandler(NPC[] characters, Player player, NPC suspect) {
        scan = new Scanner(System.in);
        this.characters = characters;
        this.player = player;
        this.suspect = suspect;
        hm = new HotelManager();
        choice = 0;
        intro = true;
    }

    public void initiate() { //if the player has found all 3 evidences
        if ((player.getFirstEvidence() == true) && (player.getSecondEvidence() == true) && (player.getThirdEvidence() == true)) {
            System.out.println();
            endGame(true);

        } else { //regular HM interaction
            System.out.println();
            if (intro == true) {
                System.out.println(hm.firstEncounter("ENTER MURDER ROOM HERE"));
                intro = false;
                System.out.println();
            }
            System.out.println();
            //TimeUnit.SECONDS.sleep(1); //Wait one second
            System.out.println(hm.greeting());
            System.out.println();
            level1(true);
        }
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

    public void endGame(Boolean thisLevel) {
        while (thisLevel == true) {
            choice = 0;
            System.out.println("(1) Inquire about crime\n(2) Tell me about the other people here\n(3) Does this look familiar to you?\n(4) MAKE ACCUSATION \n(5) Go back\n");
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
                        thisLevel = false; //must reset every iteration
                    }

                    //call lookFamiliar (level4) evidence loop
                    if(choice == 3) {
                        level4(true);
                    }

                    if (choice == 4) {
                        makeAccusation(true);
                    }

                    //exit endGame
                    if(choice == 5) {
                        thisLevel = false;
                    }

            if (player.getGameOver() == true)
                break;
        }
    }

    public void makeAccusation(Boolean thisLevel) {
        System.out.println();
        System.out.println("Oh! Have you discovered something Detective?");
        while (thisLevel == true) {
            choice = 0;
            System.out.println();
            System.out.println("(1) Chef\n(2) Maid\n(3) Senator\n(4) Imperialist\n(5) Dancer\n(6) Goon\n(7) Go back");
            System.out.println();
            choice = scan.nextInt();
            System.out.println();

            if (choice != 7) {
                System.out.println(hm.makeAccusation(characters[choice-1].getCharName()));
                System.out.println();
                finalDecision(choice);
                thisLevel = false;
            } else {
                thisLevel = false;
            }

            if (player.getGameOver() == true)
                break;
        }
    }

    public void finalDecision(int choice) {
        switch (choice) {
            case 1:    //chef
                System.out.println(hm.postAccusation(suspect.equals(characters[0])));
                if (suspect.equals(characters[0]) == true) {
                    player.setCorrectAccusation(true);
                    player.setGameOver(true);
                } else {
                    player.setGameOver(true);
                }
                break;
            case 2:     //maid
                System.out.println(hm.postAccusation(suspect.equals(characters[1])));
                if (suspect.equals(characters[1]) == true) {
                    player.setCorrectAccusation(true);
                    player.setGameOver(true);
                } else {
                    player.setGameOver(true);
                }
                break;
            case 3:     //sen
                System.out.println(hm.postAccusation(suspect.equals(characters[2])));
                if (suspect.equals(characters[2]) == true) {
                    player.setCorrectAccusation(true);
                    player.setGameOver(true);
                } else {
                    player.setGameOver(true);
                }
                break;
            case 4:     //imp
                System.out.println(hm.postAccusation(suspect.equals(characters[3])));
                if (suspect.equals(characters[3]) == true) {
                    player.setCorrectAccusation(true);
                    player.setGameOver(true);
                } else {
                    player.setGameOver(true);
                }
                break;
            case 5:     //dan
                System.out.println(hm.postAccusation(suspect.equals(characters[4])));
                if (suspect.equals(characters[4]) == true) {
                    player.setCorrectAccusation(true);
                    player.setGameOver(true);
                } else {
                    player.setGameOver(true);
                }
                break;
            case 6:     //goon
                System.out.println(hm.postAccusation(suspect.equals(characters[5])));
                if (suspect.equals(characters[5]) == true) {
                    player.setCorrectAccusation(true);
                    player.setGameOver(true);
                } else {
                    player.setGameOver(true);
                }
                break;
        }
    }  
}
