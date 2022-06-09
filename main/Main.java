package main;

import player.Player;
import videopoker.Debug;
import videopoker.Simulation;
import videopoker.VideoPoker;

public class Main {
    private static VideoPoker game;
    private static Player player;

    public static void main(String[] args) {
        int credit=0;
		try{
            credit = Integer.parseInt(args[1]);
			System.out.println("Credit:" + credit);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        player = new Player(credit);

		String mode = new String();
		mode = args[0];
		if (mode.equals("-d")) {
			System.out.println("Debug mode!");
			game = new Debug(player);
		}else if (mode.equals("-s")) {
			System.out.println("Simulation mode!");
            game = new Simulation(player);
		}else {
			System.out.println("Invalid mode!");
			System.exit(0);
		}

		
    }
}
