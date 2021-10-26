public class NPC {
    
    private String charName, role; //may or may not use room here?
    private Evidence[] combo; //enum array of 3 evidences associated with character
    private Room room;
    private boolean isSuspect, isWitness; //Will need to be implemented later
    private Boolean hasWatch = false;
    private Boolean hasFold = false;
    private Boolean hasHair = false;
    private Boolean hasFlask = false;
    private Boolean hasCigar = false;
    private Boolean hasKey = false;

    public NPC(String charName, String role, Evidence[] combo, Room room, Boolean isSuspect, Boolean isWitness) {
        this.charName = charName;
        this.role = role;
        this.combo = combo;
        this.room = room;
        this.isSuspect = isSuspect;
        this.isSuspect = isWitness;
        initialize(combo); //initialize evidence booleans
    }

    //takes in enum evidence combo, then initializes evidence booleans
    public void initialize(Evidence[] combo) {
        for (int i = 0; i < 3; i++) {
            if (combo[i] == Evidence.ANTIQUE_WATCH) {
                hasWatch = true;
            } else if (combo[i] == Evidence.EMPTY_BILLFOLD) {
                hasFold = true;
            } else if (combo[i] == Evidence.STRAY_HAIR) {
                hasHair = true;
            } else if (combo[i] == Evidence.HIP_FLASK) {
                hasFlask = true;
            } else if (combo[i] == Evidence.CIGAR) {
                hasCigar = true;
            } else if (combo[i] == Evidence.ROOM_KEY) {
                hasKey = true;
            }
        }
    }

    /********************************GETTERS AND SETTERS****************************/
    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Evidence[] getCombo() {
        return combo;
    }

    public void setCombo(Evidence[] combo) {
        this.combo = combo;
        initialize(combo);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean getIsSuspect() {
        return isSuspect;
    }

    public void setIsSuspect(boolean isSuspect) {
        this.isSuspect = isSuspect;
    }

    public boolean getIsWitness() {
        return isWitness;
    }

    public void setIsWitness(Boolean isWitness) {
        this.isWitness = isWitness;
    }
}