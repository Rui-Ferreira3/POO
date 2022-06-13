package videopoker;

public class Player {
    private final int initial_credit;
    private int credit;
    private Deck hand;

    public Player(int credit) {
        this.credit = credit;
        this.initial_credit = credit;
        this.hand = new Deck();
    }

    int get_credit() {
        return this.credit;
    }

    int get_initial_credit() {
        return this.initial_credit;
    }

    boolean sub_credit(int bet) {
        if(this.credit - bet < 0){
            return false;
        }else{
            this.credit-=bet;
            return true;
        }
    } 

    void add_credit(int bet) {
        this.credit+=bet;
    }

    void add_card(Card card) {
        this.hand.add_card(card);
    }

    Card remove_card(int i) {
        return this.hand.remove_card(i);
    }

    Card replace_card(int i, Card card) {
        return this.hand.put_card(i, card);
    }

    String hand_to_String() {
        String hand_String="";
        String aux_String;
        //perceber como é que o rui faz a hash table para fazer o ciclo for a percorrer a mao e sacar as cartas a cada ciclo
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

    protected Deck get_hand(){
        Deck hand_copy = new Deck();
        for (Card card: this.hand.get_cards()) {
            Card card_copy = new Card(card.get_rank_idx(), card.get_suit_idx());
            hand_copy.add_card(card_copy);
        }
        return hand_copy;
    }

}
