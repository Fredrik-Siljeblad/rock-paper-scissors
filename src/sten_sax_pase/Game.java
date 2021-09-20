package sten_sax_pase;

import java.util.Scanner;

public class Game {
    private Player currentPlayer;
    private int nextMenu = 1;
    private Boolean continuePlaying = true;

    public Game() {
        this.currentPlayer = new Player("Spelare");
        this.runMenu1();
    }

    /**
     * Menu 1) chose between new match, show history or end game.
     */
    public void runMenu1(){
        System.out.println("1. Ny Match   2. Historik   3. Avsluta Spelet");
        System.out.println("User Input: (här matas en siffra in av spelaren, antingen \"1\", \"2\", eller \"3\")");

        Scanner myScanner = new Scanner(System.in);
        String menuChoice = myScanner.nextLine();

        while( !(menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3"))){
            System.out.println("Du valde \"" + menuChoice + "\".");
            System.out.println("Du måste välja \"1\", \"2\", eller \"3\"!");
            menuChoice = myScanner.nextLine();
        }
        switch (Integer.parseInt(menuChoice)){
            case 1:
                this.currentPlayer.makeMove();
                this.runMenu2();
                break;
            case 2:
                this.currentPlayer.reportHistory();
                this.runMenu1();
                break;
            default:
                this.endGame();
        }
    }

    /**
     * Allows game to exit main loop
     */
    private void endGame() {
        this.continuePlaying = false;
        return;
    }

    /**
     * Menu 2, the after match menu, choose between 1 back to main menu, 2 play again (same as 1 of
     * menu1) and 3 end the game (same as 3 of menu 1)
     */
    public void runMenu2() {
        System.out.println("1. Meny   2. Kör igen   3. Avsluta Spelet");
        System.out.println("User Input: (här matas en siffra in av spelaren, antingen \"1\", \"2\", eller \"3\")");
        Scanner myScanner = new Scanner(System.in);
        String menuChoice = myScanner.nextLine();
        while( !(menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3"))){
            System.out.println("Du valde \"" + menuChoice + "\".");
            System.out.println("Du måste välja \"1\", \"2\", eller \"3\"!");
            menuChoice = myScanner.nextLine();
        }
        switch (Integer.parseInt(menuChoice)){
            case 1:
                this.runMenu1();
                break;
            case 2:
                this.currentPlayer.makeMove();
                this.runMenu2();
                break;
            default: // We have already ruled out all but 1, 2 and 3 as possible menuChoices.
                endGame();
        }
    }
}
