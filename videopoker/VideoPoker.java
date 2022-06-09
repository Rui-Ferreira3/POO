package videopoker;

import player.Player;
import deck.Deck;

public class VideoPoker {
	public String[] comands = new String[] {"bet", "credit", "deal", "hold", "advice", "statistics"};
	private int wins;
	private Deck deck;

	public VideoPoker(Player player) {
		super();
		this.wins = 0;
	}
    public String get_comand() {
        String comand = new String();

        comand = this.comands[1];

        return comand;
    }
}
