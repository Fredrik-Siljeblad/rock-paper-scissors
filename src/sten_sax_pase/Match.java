package sten_sax_pase;

import java.util.Random;

public class Match {
    private String playerMove, computerMove, matchResult;
    // the moves array needs to "wrap around" due to the +[0-2] computerMove
    private String [] moves = {"sten", "sax", "påse", "sten", "sax"};
    private String [] results = {"oavgjort", "vinst", "förlust"};

    /**
     * playerMoveNr 0=sten, 1=sax, 2=påse
     * resultNr 0=oavgjort, 1=vinst, 2=förlust (for the player)
     * @param playerMoveNr playerMoveNr
     * @return int resultNr
     */
    public int getResult(int playerMoveNr){
        // 0 = "sten", 1 = "sax" eller 2 = "påse"
        this.playerMove = moves[playerMoveNr];
        // Win, loss or draw? random 0-2 gives both computerMove and win/lose/draw.
        Random random = new Random();
        int resultNr = random.nextInt(3);
        // i = 0 => draw/computerMove = playerMove, 1 win (computerMove = playerMove+1) and 2 loss
        // N.B. It doesn't matter to the outcome of the game if the outcome or the computers move
        // is random!!
        this.computerMove = moves[playerMoveNr + resultNr];
        // "vinst", "oavgjort" eller "förlust", beror på playerMove & computerMove.
        this.matchResult = results[resultNr];
        return resultNr;
    }
    /**
     * Prints the match to the console in the format:
     * "vinst: sten mot påse."
     */
    public void printResult(){
        String report = this.matchResult;
        report += ": " + this.playerMove;
        report += " mot " + this.computerMove + ".";
        System.out.println(report);
        return;
    }
}
