package main;

import java.io.File;											// Import the File class
import java.io.FileNotFoundException;							// Import this class to handle errors
import java.util.Scanner;										// Import the Scanner class to read text files

import videopoker.Debug;
import videopoker.Deck;
import videopoker.Player;
import videopoker.VideoPoker;

public class Main {
    public static void main(String[] args) {
        int credit=0, bet=0, nbdeals=0;
		String comand_file = new String();
		String card_file = new String();

		try{
            credit = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
			System.exit(0);
        }

		Deck deck = new Deck();
        Player player = new Player(credit);
		VideoPoker game;

		String mode = new String();
		mode = args[0];
		if (mode.equals("-d")) {
			System.out.println("Debug mode!");
			comand_file = args[2];
			card_file = args[3];
			deck.create_from_file(card_file);					// criar deck a partir do card_file
			game = new Debug(deck, player, comand_file);
			game.play();
		}else if (mode.equals("-s")) {
			System.out.println("Simulation mode!");
			try{
				bet = Integer.parseInt(args[2]);
				nbdeals = Integer.parseInt(args[3]);
			}
			catch (NumberFormatException ex){
				ex.printStackTrace();
			}
			deck.create_deck();									// criar deck com 52 cartas
			deck.shuffle();
            game = new VideoPoker(deck, player, nbdeals);
			game.play();
		}else {
			System.out.println("Invalid mode!");
			System.exit(0);
		}
    }
}
