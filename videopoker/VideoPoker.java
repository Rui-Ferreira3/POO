package videopoker;

public class VideoPoker {
	private int wins;
	private Deck deck;
	private Player player;
	private String[] comands = new String[] {"b", "$", "d", "h", "a", "s"};

	public VideoPoker(/*Deck deck, */Player player) {
		super();
		//this.deck = deck;
		this.player = player;
		this.wins = 0;
	}
}
