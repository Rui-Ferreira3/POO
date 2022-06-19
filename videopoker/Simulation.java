package videopoker;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends VideoPoker {
    private List<String> command_List;
    private int command_idx;
    private final Integer bet;
    private final Integer num_rounds;

    /**
     * Constructs the simulation.
     * @super deck,player receives this values from videopoker class
     * @param num_rounds is the number of rounds that are going to be played in the simulation
     * @param bet is the value that is going to be beted in the rounds
     * @param command_List is the list of commands executed during each round. It starts with bet (b), then deal(d), advice(a), hold (h). 
     *                          This commands are repeated until the num_rounds its reached. The the command exit(e) is executed
     *                          The hold command is completed based on the return of the advice.
     */
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
    /**
     * Returns the completed command. The bet and hold commands depend on the input value for the bets and on the return of advice funciton.
     * Therefore they must be completed correctly depending on the value of this parameters.
     * The number of rounds must be verified in order to finish the simulation when the max value is reached
     * @param command string with the command to be modified
     */
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