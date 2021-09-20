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
     * The main loop that keeps the game running until the user chooses to end the game.
     */
    private void runGame() {

        while(continuePlaying){
            switch (nextMenu){
                case 1:
                    runMenu1();
                    break;
                case 2:
                    runMenu2();
            }
        }
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

    private void endGame() {
        this.continuePlaying = false;
        return;
    }

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
