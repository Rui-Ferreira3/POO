package videopoker;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends VideoPoker {
    private List<String> command_List;
    private int command_idx;
    private final Integer bet;
    private final Integer num_rounds;

    /**
     * Constroi a simulacao
     * @super Os atributos deck e player sao recebidos da classe videopoker
     * @param num_rounds é o numero de rondas que se vai jogar na simulacao
     * @param bet é o valor apostado nas rondas
     * @param command_List É a lista de comandos que irão ser executados em sequencia durante a simulacao
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
     * Retorna o comando completo a ser executado. O comando bet e hold precisam de ser completados com o valor da aposta e a posicao das cartas que são mantidas na mão do jogador.
     * O numero de rondas precisa de ser verificado para o jogo acabar
     * @param command string com o comando a ser modificado
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