package videopoker;

import java.util.ArrayList;

public class Rules {

    boolean check_JOB(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();

        if (cards.get(0).get_rank() == cards.get(1).get_rank() &&					// P P X Y Z
            cards.get(1).get_rank() != cards.get(2).get_rank() &&
            cards.get(2).get_rank() != cards.get(3).get_rank() &&
            cards.get(3).get_rank() != cards.get(4).get_rank() &&
            (cards.get(0).get_rank() >= 11 || cards.get(0).get_rank() == 1))
            return true;
        else if (cards.get(0).get_rank() != cards.get(1).get_rank() &&			// X P P Y Z
            cards.get(1).get_rank() == cards.get(2).get_rank() &&	
            cards.get(2).get_rank() != cards.get(3).get_rank() &&
            cards.get(3).get_rank() != cards.get(4).get_rank() &&
            (cards.get(1).get_rank() >= 11 || cards.get(1).get_rank() == 1))
            return true;
        else if (cards.get(0).get_rank() != cards.get(1).get_rank() &&			// X Y P P Z
            cards.get(2).get_rank() != cards.get(2).get_rank() &&
            cards.get(2).get_rank() == cards.get(3).get_rank() &&
            cards.get(3).get_rank() != cards.get(4).get_rank() &&
            (cards.get(2).get_rank() >= 11 || cards.get(2).get_rank() == 1))
            return true;
        else if (cards.get(0).get_rank() != cards.get(1).get_rank() &&			// X Y Z P P
            cards.get(1).get_rank() != cards.get(2).get_rank() &&
            cards.get(2).get_rank() != cards.get(3).get_rank() &&
            cards.get(3).get_rank() == cards.get(4).get_rank() &&
            (cards.get(3).get_rank() >= 11 || cards.get(3).get_rank() == 1))
                return true;
        else
            return false;
    }

    boolean check_TP(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();

        if (cards.get(0).get_rank() == cards.get(1).get_rank() &&					// P1 P1 P2 P2 X
            cards.get(0).get_rank() != cards.get(2).get_rank() &&
            cards.get(2).get_rank() == cards.get(3).get_rank() &&
            cards.get(2).get_rank() != cards.get(4).get_rank() &&
            cards.get(0).get_rank() != cards.get(4).get_rank())
            return true;
        else if (cards.get(0).get_rank() != cards.get(1).get_rank() &&			// X P1 P1 P2 P2
            cards.get(1).get_rank() == cards.get(2).get_rank() &&	
            cards.get(1).get_rank() != cards.get(3).get_rank() &&
            cards.get(3).get_rank() == cards.get(4).get_rank() &&
            cards.get(3).get_rank() != cards.get(0).get_rank())
            return true;
        else if (cards.get(0).get_rank() == cards.get(1).get_rank() &&			// P1 P1 X P2 P2
            cards.get(0).get_rank() != cards.get(2).get_rank() &&
            cards.get(2).get_rank() != cards.get(3).get_rank() &&
            cards.get(3).get_rank() == cards.get(4).get_rank() &&
            cards.get(3).get_rank() != cards.get(2).get_rank())
            return true;
        else
            return false;
    }

    boolean check_ToaK(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();

        if (cards.get(0).get_rank() == cards.get(1).get_rank() &&					// T T T X Y
            cards.get(0).get_rank() == cards.get(2).get_rank() &&
            cards.get(0).get_rank() != cards.get(3).get_rank() &&
            cards.get(0).get_rank() != cards.get(4).get_rank() &&
            cards.get(3).get_rank() != cards.get(4).get_rank())
            return true;
        else if (cards.get(1).get_rank() == cards.get(2).get_rank() &&			// X T T T Y
            cards.get(1).get_rank() == cards.get(3).get_rank() &&
            cards.get(1).get_rank() != cards.get(0).get_rank() &&
            cards.get(1).get_rank() != cards.get(4).get_rank() &&
            cards.get(0).get_rank() != cards.get(4).get_rank())
            return true;
        else if (cards.get(2).get_rank() == cards.get(3).get_rank() &&			// X Y T T T
            cards.get(2).get_rank() == cards.get(4).get_rank() &&
            cards.get(2).get_rank() != cards.get(0).get_rank() &&
            cards.get(2).get_rank() != cards.get(1).get_rank() &&
            cards.get(0).get_rank() != cards.get(1).get_rank())
            return true;
        else
            return false;
    }

    boolean check_S(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        int low_rank = cards.get(4).get_rank();

        if (low_rank == 1)
            if (cards.get(3).get_rank() == 10 && cards.get(2).get_rank() == 11 && cards.get(1).get_rank() == 12 && cards.get(0).get_rank() == 13) 
                return true;

        for (int i=3; i>=0; i--) {
            if (cards.get(i).get_rank() == low_rank+1)	
                low_rank++;
            else
                return false;
        }

        return true;
    }

    boolean check_F(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        Character suit = cards.get(0).get_suit();

        for (Card card: cards) {
            if (!suit.equals(card.get_suit())) {
                return false;
            }
        }
        return true;
    }

    boolean check_FH(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();

        if (cards.get(0).get_rank() == cards.get(1).get_rank() &&					// T T T P P
            cards.get(2).get_rank() == cards.get(3).get_rank() &&
            cards.get(2).get_rank() == cards.get(4).get_rank())
            return true;
        else if (cards.get(0).get_rank() == cards.get(1).get_rank() &&			// P P T T T
            cards.get(0).get_rank() == cards.get(2).get_rank() &&
            cards.get(3).get_rank() == cards.get(4).get_rank())
            return true;
        else
            return false;
    }

    boolean check_FoaK(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();

        if (cards.get(0).get_rank() == cards.get(1).get_rank() &&					// 4 4 4 4 X
            cards.get(0).get_rank() == cards.get(2).get_rank() &&
            cards.get(0).get_rank() == cards.get(3).get_rank())
            return true;
        else if (cards.get(1).get_rank() == cards.get(2).get_rank() &&			// X 4 4 4 4
            cards.get(1).get_rank() == cards.get(3).get_rank() &&
            cards.get(1).get_rank() == cards.get(4).get_rank())
            return true;
        else
            return false;
    }

    protected String get_optimal(Deck hand) {
		String optimal = new String();

		return optimal;
	}
    
}