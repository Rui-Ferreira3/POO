package videopoker;

public class Player {
    private int credit;
    private Deck hand;
    public Player(int credit) {
        this.credit = credit;
        this.hand = new Deck();
    }
    protected boolean sub_credit(int bet){
        if(this.credit - bet < 0){
            return false;
        }else{
            this.credit-=bet;
            return true;
        }
    } 
    protected void add_credit(int bet){
        this.credit+=bet;
    }
    protected void add_card(Card card){
        hand.add_card(card);
    }
    protected void remove_card(Card card){
        hand.remove_card(card);
    }
    public int get_credit() {
        return this.credit;
    }
}
