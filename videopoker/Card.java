package videopoker;

public class Card {
	
	public static final Integer[] ranks= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	public static final Character[] suits= {'C', 'D', 'H', 'S'};

	private int rank;
	private int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	Integer get_rank() {
		return ranks[rank];
	}

	int get_rank_idx() {
		return this.rank;
	}

	Character get_suit() {
		return suits[suit];
	}

	int get_suit_idx() {
		return this.suit;
	}
	
}
