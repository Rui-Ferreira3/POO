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
		this.statistics = new HashMap<String, Integer>();

		this.set_statistics();

		this.variation = new DoubleBonus();
	}

	public void play() {
		String command = new String();
		do {
			command = this.get_command();
			System.out.println("Command: " + command);

			char c = command.charAt(0);
			if (c == 'b')
				this.bet(command.split(" "));
			else if (c == '$')
				this.credit();
			else if (c == 'd')
				this.deal();
			else if (c == 'h')
				this.hold(command.split(" "));
			else if (c == 'a')
				this.advice();
			else if (c == 's')
				this.statistics();
			else if (c == 'e')
				break;
			else {
				System.out.println("Invalid command! Try again!");
					System.exit(0);
			}

			if (c == 'h' && this.last_command == 'd') {
				Deck ordered_hand = this.player.get_hand();
				ordered_hand.order_deck();
				String win = this.check_win(ordered_hand);
				if (win.equals("other")) {
					System.out.println("player loses and his credit is " + this.player.get_credit());
				} else {
					System.out.println("player wins with a " + this.player.hand_to_String() + " and his credit is " + this.player.get_credit());
					System.out.println(win);
					this.wins++;
				}

				this.played++;
				this.update_statistics(win);
				this.reset_hand();
				this.reset_deck();
				this.last_command = 'h';
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

	void bet(String[] command) {
		if (this.last_command == 'b' || this.last_command == 'd') {
			System.out.println("b: illegal command");
			return;
		}

		int bet = this.last_bet;
		if (command.length>1) {
			try{
				bet = Integer.parseInt(String.valueOf(command[1]));
			}
			catch (NumberFormatException ex){
				ex.printStackTrace();
				return;
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
			Card card = this.deck.remove_card(0);
			this.player.add_card(card);
		}
		System.out.println("hand:" + this.player.hand_to_String());
		this.last_command = 'd';
	}

	void hold(String[] command) {
		if (!(this.last_command == 'd' || this.last_command == 'a')) {
			System.out.println("h: illegal command");
			return;
		}

		int index = 0;
		int command_idx = 1;
		for (int i=0; i<5; i++) {
			if (i == index) {
				try{
					if (command_idx < command.length){
						index = Integer.parseInt(String.valueOf(command[command_idx]));		// recebe indice da carta a remover
						command_idx ++;
					} else
						index = 6;
				}
				catch (NumberFormatException ex){
					ex.printStackTrace();
				}
			}
			if (i != index-1) {
				Card card = this.deck.remove_card(0);
				Card removed_card = this.player.replace_card(i, card);
				this.played_cards.add_card(removed_card);
			}
		}

		System.out.println("new hand: " + this.player.hand_to_String());
	}

	void advice() {
		if (this.last_command != 'd') {
			System.out.println("a: illegal command");
			return;
		}
		String action = this.variation.get_optimal(this.player.get_hand());
		System.out.println(action);
		this.last_command = 'a';
	}

	void statistics() {
		for (Map.Entry<String, Integer> map:this.statistics.entrySet()) {
			System.out.println(map.getKey() + ":\t" + map.getValue());
		}
		this.last_command = 's';
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
			Card card = this.player.remove_card(0);								// removes card from player hand
			this.played_cards.add_card(card);									// adds card to played card list
		}
	}

	void reset_deck() {
		int num = this.played_cards.get_cards().size();
		for (int i=0; i<num; i++) {
			Card card = this.played_cards.remove_card(0);				// removes card from played card list
			this.deck.add_card(card);											// adds card back to deck
		}
		this.deck.shuffle();
	}

	String check_win(Deck hand) {
		if (check_S(hand) && check_F(hand) &&  hand.get_cards().get(4).get_rank() == 13 && hand.get_cards().get(0).get_rank() == 1)
			return "RF";
		else if (check_S(hand) && check_F(hand))
			return "SF";
		else if (check_FoaK(hand))
			return "FoaK";
		else if (check_S(hand))
			return "S";
		else if (check_F(hand))
			return "F";
		else if (check_ToaK(hand))
			return "ToaK";
		else if (3 == 1)
			return "TP";
		else if (2 == 1)
			return "JOB";
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
		ArrayList<Card> cards = hand.get_cards();
		int low_rank = cards.get(4).get_rank();

		if (low_rank == 1)
			if (cards.get(3).get_rank() == 10 && cards.get(2).get_rank() == 11 && cards.get(1).get_rank() == 12 && cards.get(0).get_rank() == 13) 
				return true;

		for (int i=3; i>=0; i--) {
			if (cards.get(i).get_rank() == low_rank-1)	
				low_rank++;
			else
				return false;
		}

		return true;
	}

	boolean check_F(Deck hand) {
		ArrayList<Card> cards = hand.get_cards();
		Character suit = cards.get(0).get_suit();

		for (Card card: cards) {
			if (!suit.equals(card.get_suit())) {
				return false;
			}
		}
		return true;
	}

	boolean check_FoaK(Deck hand) {
		ArrayList<Card> cards = hand.get_cards();

		
		return false;
	}

}
