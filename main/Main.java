package main;

import videopoker.Debug;
import videopoker.Deck;
import videopoker.Player;
import videopoker.Simulation;
import videopoker.VideoPoker;

public class Main {
    public static void main(String[] args) {
        int credit=0, bet=0, nbdeals=0;
		String comand_file = new String();
		String card_file = new String();

		if (args.length < 4)
			System.exit(0);

		try{
            credit = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

		Deck deck = new Deck();
        Player player = new Player(credit);
		VideoPoker game;

		String mode = new String();
		mode = args[0];
		if (mode.equals("-d")) {
			comand_file = args[2];
			card_file = args[3];
			deck.create_from_file(card_file);					// criar deck a partir do card_file
			game = new Debug(deck, player, comand_file);
			game.play();
		}else if (mode.equals("-s")) {
			try{
				bet = Integer.parseInt(args[2]);
				nbdeals = Integer.parseInt(args[3]);
			}
			catch (NumberFormatException ex){
				ex.printStackTrace();
			}
			deck.create_deck();									// criar deck com 52 cartas
			deck.shuffle();
            game = new Simulation(deck, player, bet, nbdeals);
			game.play();
		}else {
			System.exit(0);
		}
    }
}
