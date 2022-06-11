package videopoker;

public class Card {
    private String rank;
    private String suit;
    public Card(String rank, String suit) {
        this.rank=rank;
        this.suit=suit;
    }

    protected String get_rank(){
        return this.rank;
    }

    protected String get_suit(){
        return this.suit;
    }
}
