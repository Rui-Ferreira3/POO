package videopoker;

import player.Player;

import javax.lang.model.util.ElementScanner14;

import deck.Deck;

public class VideoPoker {
	private int wins;
	private Deck deck;

	public VideoPoker(Player player) {
		super();
		this.wins = 0;


	}
	public boolean playround(int bet) {
		
		return false;
	}
	public static void main(String[] args) {
		String mode = new String();
		mode = args[0];
		if (mode.equals("-d"))
			System.out.println("Debug mode!");
		else if (mode.equals("-s"))
			System.out.println("Simulation mode!");
		else
			System.out.println("Invalid mode!");

		int credit;
		try{
            credit = Integer.parseInt(args[1]);
			System.out.println("Credit:" + credit);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        // PLayer player = new Player(credit);
    }
}
