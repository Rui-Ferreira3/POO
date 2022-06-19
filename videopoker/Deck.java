package videopoker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    /**
     * Constructs the Deck.
     * Creates an empty list in deck class
     */
    public Deck(){
        this.deck= new ArrayList<Card>();
    }
    /**
     * Adds a card to the deck
     */
	void add_card(Card card) {
		this.deck.add(card);
	}

    /**
     * Removes a card from the deck
     */
	Card remove_card(int index) {
        Card carta = deck.remove(index);
        return carta;
	}

    /**
     * Places a card in list of cards in deck
     */   
    Card put_card(int i, Card card) {
        Card removed_card = this.deck.get(i);
        this.deck.set(i, card);
        return removed_card;
    }
    /**
     * @return deck
     */
    ArrayList<Card> get_cards() {
        return this.deck;
    }

    /**
     * Shuffles list of cards in deck with random order
     */
	public void shuffle() {
		Collections.shuffle(deck);
	}

    /**
     * Fills the list of cards from deck
     */
    public void create_deck() {
        for (int suit = 0; suit < 4; suit++)
            for (int rank = 0; rank < 13; rank++)
                deck.add(new Card(rank, suit));
    }

    /**
     * Orders the cards in the list of cards from the highest to the lowest, the ace is the lowest
     */
    void order_deck(){
        Collections.sort(this.deck, (d1, d2) -> {
            return d2.get_rank() - d1.get_rank();
        });
    }

    /**
     * Adds cards to the list of cards from input file
     */   
    public void create_from_file(String card_file) {
        try {
            File file = new File(card_file);
            Scanner scan = new Scanner(file);

            int rank = 1, suit = 1;

            String[] cartas = scan.nextLine().split(" ");

            for (String carta: cartas){
                if (carta.length() == 2) {
                    for (int j=1; j<9; j++) {
                        if (Character.getNumericValue(carta.charAt(0)) == Card.ranks[j])
                            rank= j;
                    }

                    if (carta.charAt(0) == 'T')
                        rank = 9;
                    else if (carta.charAt(0) == 'J')
                        rank = 10;
                    else if (carta.charAt(0) == 'Q')
                        rank = 11;
                    else if (carta.charAt(0) == 'K')
                        rank = 12;
                    else if (carta.charAt(0) == 'A')
                        rank = 0;

                    for (int a=0; a<4; a++) {
                        if (carta.charAt(1) == Card.suits[a])
                            suit = a;
                    }

                    deck.add(new Card(rank, suit));
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("an error occurred readinng cards file");
            e.printStackTrace();
        }
    }

}
