public class Player {
    
    private boolean firstEvidence;
    private boolean secondEvidence;
    private boolean thirdEvidence;

    public Player() {
        firstEvidence = false;
        secondEvidence = false;
        thirdEvidence = false;
    }

    public boolean getFirstEvidence() {
        return firstEvidence;
    }

    public void setFirstEvidence(boolean firstEvidence) {
        this.firstEvidence = firstEvidence;
    }

    public boolean getSecondEvidence() {
        return secondEvidence;
    }

    public void setSecondEvidence(boolean secondEvidence) {
        this.secondEvidence = secondEvidence;
    }

    public boolean getThirdEvidence() {
        return thirdEvidence;
    }

    public void setThirdEvidence(boolean thirdEvidence) {
        this.thirdEvidence = thirdEvidence;
    }
}
