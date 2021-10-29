public class Player {
    
    private boolean firstEvidence;
    private boolean secondEvidence;
    private boolean thirdEvidence;
    private boolean gameOver;
    private boolean correctAccusation;

    public Player() {
        firstEvidence = false;
        secondEvidence = false;
        thirdEvidence = false;
        gameOver = false;
        correctAccusation = false;
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

    public boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    } 

    public boolean getCorrectAccusation() {
        return correctAccusation;
    }
    
    public void setCorrectAccusation(boolean correctAccusation) {
        this.correctAccusation = correctAccusation;
    }
}
