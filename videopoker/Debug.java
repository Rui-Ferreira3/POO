package videopoker;

import player.Player;

public class Debug extends VideoPoker {

    public Debug(Player player) {
        super(player);
    }
    public String get_comand() {
        String comand = new String();

        comand = this.comands[2];

        return comand;
    }
}