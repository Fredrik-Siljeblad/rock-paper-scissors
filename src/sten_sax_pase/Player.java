package sten_sax_pase;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private ArrayList<Match> matches = new ArrayList<>();
    private int [] results = {0, 0, 0};

    public Player(String name) {
        this.name = name;
    }

    /**
     * Prints out the players game history.
     */
    public void reportHistory(){
        System.out.print(this.name + " har vunnit " + this.results[1]);
        System.out.print(", förlorat " + this.results[2]);
        System.out.print(" och spelat oavgjort " + this.results[0]);
        System.out.print(".\nTotalt " + (this.results[0] + this.results[1] + this.results[2]) + ".\n");
        for (Match match:this.matches) {
            match.printResult();
        }
    }

    /**
     * makes a move, creates a new match, sends the move in numeric form to the match, gets the
     * result in numeric form and uses that to increment the right element of the this.results array.
     */
    public void makeMove() {
        System.out.println("Vad väljer du?");
        System.out.println("1. Sten   2. Sax   3. Påse");
        System.out.println("User Input: (här matas en siffra in av spelaren, antingen \"1\", \"2\", eller \"3\")");
        Scanner myScanner = new Scanner(System.in);
        String menuChoice = myScanner.nextLine();
        while( !(menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3"))){
            System.out.println("Du valde \"" + menuChoice + "\".");
            System.out.println("Du måste välja \"1\", \"2\", eller \"3\"!");
            menuChoice = myScanner.nextLine();
        }
        Match match = new Match();
        this.results[match.getResult(Integer.parseInt(menuChoice) - 1)]++;
        match.printResult();
        this.matches.add(match);
    }


}

