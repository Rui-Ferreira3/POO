package videopoker;

public class Card {
	
	public static final String[] Ranks= {null, null, "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	public static final String[] Suits= {"C", "D", "H", "S"};

	private int rank;
	private int suit;
	
	
	//Constructor
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	//Getters
	public String getRank() {
		return Ranks[rank];
	}

	public String getSuit() {
		return Suits[suit];
	}
	

}
