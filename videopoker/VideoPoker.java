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
	private char last_command;
	private Deck played_cards;

	private Deck deck;
	private Player player;
	private final int num_rounds;

	private DoubleBonus variation;

	public VideoPoker(Deck deck, Player player, int num) {
		super();
		this.deck = deck;
		this.player = player;
		this.num_rounds = num;

		this.played = 0;
		this.wins = 0;
		this.last_bet = 5;
		this.played_cards = new Deck();

		this.variation = new DoubleBonus();
	}

	public void play() {
		String command = new String();
		do {
			command = this.get_command();
			System.out.println("Command: " + command);

			switch (command.charAt(0)) {
				case 'b': this.bet(command);
				case '$': this.credit();
				case 'd': this.deal();
				case 'h': this.hold(command);
				case 'a': this.advice();
				case 's': this.statistics();
				case 'e': break;
				default: 
					System.out.println("Invalid command! Try again!");
					System.exit(0);
			}

			if (this.num_rounds != -1) {
				if (this.played > this.num_rounds) {
					break;
				}
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

	private void bet(String command) {
		if (this.last_command == 'b' || this.last_command == 'd') {
			System.out.println("b: illegal command");
			return;
		}

		int bet = this.last_bet;
		if (command.length()>1) {
			try{
				bet = Integer.parseInt(String.valueOf(command.charAt(2)));
			}
			catch (NumberFormatException ex){
				ex.printStackTrace();
			}
			if (bet > 5)
				bet = 5;
			if (bet < 1)
				bet = 1;
		}

		if (this.player.sub_credit(bet)) {
			this.last_bet = bet;
			this.last_command = 'b';
		} else {
			System.out.println("b: insuficient funds");
		}
	}

	private void credit() {
		System.out.println("Available credits: " + this.player.get_credit());
	}

	private void deal() {
		if (this.last_command != 'b') {
			System.out.println("d: illegal command");
			return;
		}
		
		for (int i=0; i<5; i++) {
			Card card = this.deck.remove_card();
			this.player.add_card(card);
		}
	}

	private void hold(String command) {
		if (this.last_command != 'd') {
			System.out.println("d: illegal command");
			return;
		}

		int index;

		for (int i=2; i<command.length(); i+=2) {
			try{
				index = Integer.parseInt(String.valueOf(command.charAt(i)));		// recebe indice da carta a remover
			}
			catch (NumberFormatException ex){
				ex.printStackTrace();
			}
			Card removed_card = this.player.remove_card(index);					// remove carta da mão do jogador
			this.played_cards.add_card(removed_card);							// adiciona carta às cartas jogadas
			Card card = this.deck.remove_card();								// recebe carta nova do deck
			this.player.add_card(card);											// adiciona carta nova à mão do jogador
		}

		System.out.println("New hand: " + this.player.hand_to_String());

		boolean win = this.variation.check_win();
		if (win) {
			System.out.println("player wins with a " + this.player.hand_to_String() + " and his credit is " + this.player.get_credit());
			this.wins++;
		} else {
			System.out.println("player loses and his credit is " + this.player.get_credit());
		}

		this.played++;
		this.variation.update_statistics();
		this.reset_hand();
		this.reset_deck();
	}

	private void advice() {

	}

	private void statistics() {

	}

	private void reset_hand() {
		for (int i=0; i<5; i++) {
			Card card = this.player.remove_card(i);								// removes card from player hand
			this.played_cards.add_card(card);									// adds card to played card list
		}
	}

	private void reset_deck() {
		for (Card card: this.played_cards.cards) {
			this.deck.add_card(card);											// adds card back to deck
			this.played_cards.remove_card();									// removes card from played card list
		}
		this.deck.shuffle();
	}
}
