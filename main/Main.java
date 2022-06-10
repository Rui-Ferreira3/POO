package main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import videopoker.Debug;
import videopoker.Deck;
import videopoker.Player;
import videopoker.VideoPoker;

public class Main {
    public static void main(String[] args) {
        int credit=0, bet=0, nbdeals=0;
		String comand_file = new String();
		String card_file = new String();

		Deck deck;

		try{
            credit = Integer.parseInt(args[1]);
			System.out.println("Credit:" + credit);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        Player player = new Player(credit);
		VideoPoker game;

		String mode = new String();
		mode = args[0];
		if (mode.equals("-d")) {
			System.out.println("Debug mode!");
			comand_file = args[2];
			card_file = args[3];
			// criar deck a partir do card_file
			game = new Debug(/*deck, */player, comand_file);
			
		}else if (mode.equals("-s")) {
			System.out.println("Simulation mode!");
			try{
				bet = Integer.parseInt(args[2]);
				nbdeals = Integer.parseInt(args[3]);
				System.out.println("Credit:" + credit);
			}
			catch (NumberFormatException ex){
				ex.printStackTrace();
			}
			// criar deck com 52 cartas  
            game = new VideoPoker(/*deck, */player);
		}else {
			System.out.println("Invalid mode!");
			System.exit(0);
		}


    }
}
