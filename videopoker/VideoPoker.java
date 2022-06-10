package videopoker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VideoPoker {
	private int played;
	private int wins;
	private int last_bet;

	private Deck deck;
	private Player player;
	private final int num_rounds;

	private DoubleBonus variation;

	public VideoPoker(/*Deck deck, */Player player, int num) {
		super();
		//this.deck = deck;
		this.player = player;
		this.num_rounds = num;

		this.played = 0;
		this.wins = 0;
		this.last_bet = 5;

		this.variation = new DoubleBonus();
	}

	public void play() {
		String command = new String();
		do {
			command = this.get_command();
			System.out.println("Command: " + command);

			switch (command.charAt(0)) {
				case 'b':
					int bet = this.last_bet;
					if (command.length()>1) {
						try{
							bet = Integer.parseInt(String.valueOf(command.charAt(1)));
						}
						catch (NumberFormatException ex){
							ex.printStackTrace();
						}
						if (bet > 5)
							bet = 5;
						if (bet < 1)
							bet = 1;
					}
					this.bet(bet);
				case '$':
					this.player.get_credit();
			}

		} while (!(command.equals("e")));
	}

	private String get_command() {
		String command = new String();
		System.out.println("What's next command?");
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try {
			command = stdin.readLine();
		} catch(IOException e) {
			System.err.println("Error in reading");
		}
		return command;
	}

	private void bet(int value) {

	}
}
