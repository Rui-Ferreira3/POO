package videopoker;

public class Player {
    private final int initial_credit;
    private int credit;
    private Deck hand;
    /**
     * Construtor do player
     * @param credit inicialização do credito do jogador
     * @param hand inicialização da mão do player do tipo deck
     */
    public Player(int credit) {
        this.credit = credit;
        this.initial_credit = credit;
        this.hand = new Deck();
    }
    /**
     * @return credito do jogador
     */
    int get_credit() {
        return this.credit;
    }
    /**
     * @return credito inicial do jogador
     */
    int get_initial_credit() {
        return this.initial_credit;
    }
    /**
     * Subtrai a bet ao credito do jogador
     * @param bet 
     * @return boolean para confirmar a subtracao do credito ao jogador (não é possivel credito negativo)
     */
    boolean sub_credit(int bet) {
        if(this.credit - bet < 0){
            return false;
        }else{
            this.credit-=bet;
            return true;
        }
    } 
    /**
     * Adiciona valor ao credito do jogador
     * @param bet 
     */
    void add_credit(int value) {
        this.credit+=value;
    }
    /**
     * Adiciona uma carta à mao do jogador
     * @param card
     */
    void add_card(Card card) {
        this.hand.add_card(card);
    }

    /**
     * Remove uma carta da mão do jogador
     * @param i indice da carta a remover
     * @return a carta que foi removida
     */
    Card remove_card(int i) {
        return this.hand.remove_card(i);
    }

    /**
     * Substitui uma carta na mão do jogador
     * @param i indice da carta a ser substituida
     * @param card nova carta a ser colocada na mao do jogador
     * @return a carta que foi removida
     */   
    Card replace_card(int i, Card card) {
        return this.hand.put_card(i, card);
    }
    /**
     * Converte as cartas da mão do jogador numa string
     * @return a string com as cartas da mao do jogador
     */
    String hand_to_String() {
        String hand_String="";
        String aux_String;

        for(Card card:this.hand.get_cards()){
            if (card.get_rank() == 1)
                aux_String = "A";
            else if (card.get_rank() == 10)
                aux_String = "T";
            else if (card.get_rank() == 11)
                aux_String = "J";
            else if (card.get_rank() == 12)
                aux_String = "Q";
            else if (card.get_rank() == 13)
                aux_String = "K";
            else
                aux_String = card.get_rank().toString();
			hand_String += aux_String + card.get_suit() + " ";
        }
        return hand_String;
    }
    /**
     * Cria uma cópia da mão do jogador
     * @return cópia da mão
     */
    Deck get_hand(){
        Deck hand_copy = new Deck();
        for (Card card: this.hand.get_cards()) {
            Card card_copy = new Card(card.get_rank_idx(), card.get_suit_idx());
            hand_copy.add_card(card_copy);
        }
        return hand_copy;
    }
}
