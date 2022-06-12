package videopoker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoPoker {
	protected int played;
	protected int wins;
	protected int last_bet;
	protected char last_command;
	protected Deck played_cards;

	protected HashMap<String, Integer> statistics;

	protected Deck deck;
	protected Player player;
	protected final int num_rounds;

	protected DoubleBonus variation;

	public VideoPoker(Deck deck, Player player, int num) {
		super();
		this.deck = deck;
		this.player = player;
		this.num_rounds = num;

		this.played = 0;
		this.wins = 0;
		this.last_bet = 5;
		this.played_cards = new Deck();

		this.set_statistics();

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

			if (command.charAt(0) == 'h') {
				String win = this.check_win(this.player.get_hand());
				if (win.equals("other")) {
					System.out.println("player loses and his credit is " + this.player.get_credit());
				} else {
					System.out.println("player wins with a " + this.player.hand_to_String() + " and his credit is " + this.player.get_credit());
					this.wins++;
				}

				this.played++;
				this.update_statistics(win);
				this.reset_hand();
				this.reset_deck();
			}

			if (this.num_rounds != -1) {
				if (this.played > this.num_rounds) {
					break;
				}
			}

		} while (!(command.equals("e")));
	}

	String get_command() {
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

	void bet(String command) {
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

	void credit() {
		System.out.println("Available credits: " + this.player.get_credit());
	}

	void deal() {
		if (this.last_command != 'b') {
			System.out.println("d: illegal command");
			return;
		}
		
		for (int i=0; i<5; i++) {
			Card card = this.deck.remove_card();
			this.player.add_card(card);
		}
	}

	void hold(String command) {
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
	}

	void advice() {
		String action = this.variation.get_optimal(this.player.get_hand());
		System.out.println(action);
	}

	void statistics() {
		for (Map.Entry<String, Integer> map:this.statistics.entrySet()) {
			System.out.println(map.getKey() + ":\t" + map.getValue(););
		}
	}

	void set_statistics() {
		this.statistics.put("JOB", 0);
		this.statistics.put("TP", 0);
		this.statistics.put("ToaK", 0);
		this.statistics.put("S", 0);
		this.statistics.put("F", 0);
		this.statistics.put("FH", 0);
		this.statistics.put("FoaK", 0);
		this.statistics.put("SF", 0);
		this.statistics.put("RF", 0);
		this.statistics.put("other", 0);
		this.statistics.put("total", 0);
	}

	void update_statistics(String win) {
		for (Map.Entry<String, Integer> map:this.statistics.entrySet()) {
			if (win.equals(map.getKey())) {
				map.setValue(map.getValue()+1);
			}
		}
	}

	void reset_hand() {
		for (int i=0; i<5; i++) {
			Card card = this.player.remove_card(i);								// removes card from player hand
			this.played_cards.add_card(card);									// adds card to played card list
		}
	}

	void reset_deck() {
		for (Card card: this.played_cards.cards) {
			this.deck.add_card(card);											// adds card back to deck
			this.played_cards.remove_card();									// removes card from played card list
		}
		this.deck.shuffle();
	}

	String check_win(Deck hand) {
		if (check_JOB(hand))
			return "JOB";
		else if (check_TP(hand))
			return "TP";
		else if (check_ToaK(hand))
			return "ToaK";
		else if (check_S(hand))
			return "S";
		else if (check_F(hand))
			return "F";
		else if (check_FoaK(hand))
			return "FoaK";
		else if (check_SF(hand))
			return "SF";
		else if (check_RF(hand))
			return "RF";
		else
			return "other";
	}

	boolean check_JOB(Deck hand) {
		return false;
	}

	boolean check_TP(Deck hand) {
		return false;
	}

	boolean check_ToaK(Deck hand) {
		return false;
	}

	boolean check_S(Deck hand) {
		return false;
	}

	boolean check_F(Deck hand) {
		return false;
	}

	boolean check_FoaK(Deck hand) {
		return false;
	}

	boolean check_SF(Deck hand) {
		ArrayList<Card> cards = hand.get_cards();
		String suit = cards.get(0).get_suit();
		int first = cards.get(0).get_rank();
		int last = first;
		int score = 0;

		for (Card card: cards) {
			if (!suit.equals(card.get_suit())) {
				return false;
			}
			if (first-1 == card.get_rank()) {
				score++;
				first = card.get_rank();
			}else if (last+1 == card.get_rank()) {
				score++;
				last = card.get_rank();
			}
		}

		if (score == 5)
			return true;
		else
			return false;
	}

	boolean check_RF(Deck hand) {
		ArrayList<Card> cards = hand.get_cards();
		String suit = cards.get(0).get_suit();
		int score = 0;

		for (Card card: cards) {
			if (!suit.equals(card.get_suit())) {
				return false;
			}
			if (card.get_rank() == 10)
				score ++;
			if (card.get_rank() == 11)
				score ++;
			if (card.get_rank() == 12)
				score ++;
			if (card.get_rank() == 13)
				score ++;
			if (card.get_rank() == 14)
				score ++;
		}

		if (score == 5)
			return true;
		else
			return false;
	}

}
