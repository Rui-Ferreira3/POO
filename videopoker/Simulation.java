package videopoker;

import player.Player;

public class Simulation extends VideoPoker {

    public Simulation(Player player) {
        super(player);
    }
    public String get_comand() {
        String comand = new String();

        comand = this.comands[1];

        return comand;
    }
}