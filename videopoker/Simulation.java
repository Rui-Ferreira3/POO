package videopoker;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends VideoPoker {
    private List<String> command_List;
    private int command_idx;
    private final Integer bet;
    private final Integer num_rounds;

    public Simulation(Deck deck, Player player, int bet, int nbdeals) {
        super(deck, player);

        this.bet = bet;
        this.num_rounds = nbdeals;

        this.command_idx = 0;

        this.command_List = new ArrayList<String>();
        this.command_List.add("b");
        this.command_List.add("d");
        this.command_List.add("a");
        this.command_List.add("h");
    }

    String get_command() {
        String command = this.command_List.get(this.command_idx);

        if (command.equals("b")) {
            command = command + " " + bet.toString();
            this.command_idx++;
        }else if  (command.equals("h")) {
            command = command + this.advice;
            this.command_idx = 0;
        } else
            this.command_idx++;

        if (this.played == this.num_rounds)
            command = "e";
        return command;
    }
}