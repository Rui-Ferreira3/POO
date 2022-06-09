package main;

import player.Player;
import videopoker.Debug;
//import videopoker.Simulation;
import videopoker.VideoPoker;

public class Main {
    public static void main(String[] args) {
        int credit=0;
		try{
            credit = Integer.parseInt(args[1]);
			System.out.println("Credit:" + credit);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        Player player = new Player(credit);
		VideoPoker game;

		String mode = new String();
		mode = args[0];
		if (mode.equals("-d")) {
			System.out.println("Debug mode!");
			game = new Debug(player);
			System.out.println(game.get_comand());
		}else if (mode.equals("-s")) {
			System.out.println("Simulation mode!");
            game = new VideoPoker(player);
			System.out.println(game.get_comand());
		}else {
			System.out.println("Invalid mode!");
			System.exit(0);
		}

		
    }
}
