package videopoker;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        this.hand.add_card(card);
    }
    protected void remove_card(int i){
        this.hand.remove_card(i);
    }
    public int get_credit() {
        return this.credit;
    }
    protected String hand_to_String(){
        String hand_String;
        //perceber como é que o rui faz a hash table para fazer o ciclo for a percorrer a mao e sacar as cartas a cada ciclo
        for(Card card:this.hand.get_deck()){
			hand_String+=card.get_rank()+card.get_suit()+" ";
        }
        return hand_String;
    }
    protected Deck get_hand(){
        return hand;
    }
}
