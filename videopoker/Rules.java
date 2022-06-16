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

    boolean check_SF(Deck hand) {
        if(this.check_S(hand) && this.check_F(hand))
            return true;
        else
            return false;
    }

    boolean check_RF(Deck hand) {
        if(this.check_S(hand) && this.check_F(hand) &&  hand.get_cards().get(0).get_rank() == 13 && hand.get_cards().get(4).get_rank() == 1)
            return true;
        else
            return false;
    }

    ArrayList<Card> get_optimal(Deck hand) {
        ArrayList<Card> keepers;
        keepers = isRForSForFoaK(hand);
        if (keepers != null)
            return keepers;
        keepers = is4toRF(hand);
        if (keepers != null)
            return keepers;
        keepers = is3A(hand);
        if (keepers != null)
            return keepers;
        keepers = isSFFH(hand);
        if (keepers != null)
            return keepers;
        keepers = isToaK(hand);
        if (keepers != null)
            return keepers;
        keepers = is4toSF(hand);
        if (keepers != null)
            return keepers;                 
        keepers = isTP(hand);
        if (keepers != null)
            return keepers;
        keepers = isHP(hand);
        if (keepers != null)
            return keepers;
        keepers = is4toF(hand);
        if (keepers != null)
            return keepers;
        keepers = is3toRF(hand);
        if (keepers != null)
            return keepers;
        keepers = is4toOutsideS(hand);
        if (keepers != null)
            return keepers;
        keepers = isLP(hand);
        if (keepers != null)
            return keepers;
        keepers = isAKQJ(hand);
        if (keepers != null)
            return keepers;
        keepers = is3toSF1(hand);
        if (keepers != null)
            return keepers;
        keepers = is4toInsideS_3HC(hand);
        if (keepers != null)
            return keepers;
        keepers = isQJ(hand, true);
        if (keepers != null)
            return keepers;
        keepers = is3toF_2HC(hand);  
        if (keepers != null)
            return keepers;
        keepers = is2SuitedHC(hand);
        if (keepers != null)
            return keepers;
        keepers = is4toInsideS_2HC(hand);
        if (keepers != null)
            return keepers;
        keepers = is3toSF2(hand);
        if (keepers != null)
            return keepers;
        keepers = is4toInsideS_1HC(hand);
        if (keepers != null)
            return keepers;
        keepers = isKQJunsuited(hand);
        if (keepers != null)
            return keepers;
        keepers = isJT(hand, true);
        if (keepers != null)
            return keepers;
        keepers = isQJ(hand, false);
        if (keepers != null)
            return keepers;
        keepers = is3toF_1HC(hand);
        if (keepers != null)
            return keepers;
        keepers = isQT(hand, true);
        if (keepers != null)
            return keepers;
        keepers = is3toSF3(hand);
        if (keepers != null)
            return keepers;
        keepers = isKQorKJ(hand);
        if (keepers != null)
            return keepers;
        keepers = isA(hand);
        if (keepers != null)
            return keepers;
        keepers = isKT(hand, true);
        if (keepers != null)
            return keepers;
        keepers = isJorQorK(hand);
        if (keepers != null)
            return keepers;
        keepers = is4toInsideS_0HC(hand);
        if (keepers != null)
            return keepers;
        keepers = is3toF_0HC(hand);
        if (keepers != null)
            return keepers;
        return null;
	}

    ArrayList<Card> isRForSForFoaK(Deck hand) {
        if (this.check_RF(hand))
            return hand.get_cards();
        else if (this.check_SF(hand))
            return hand.get_cards();
        else if (this.check_FoaK(hand))
            return hand.get_cards();
        else
            return null;
    }

    ArrayList<Card> is4toRF(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0, flag5 = 0;
        for (int i=0; i<4; i++) {
            keepers.clear();
            for(Card card: cards) {
                if (card.get_suit_idx()==i) {
                    if (card.get_rank() == 1 && flag1 == 0) {
                        keepers.add(card);
                        flag1 = 1;
                    }
                    if (card.get_rank() == 13 && flag2 == 0) {
                        keepers.add(card);
                        flag2 = 1;
                    }
                    if (card.get_rank() == 12 && flag3 == 0) {
                        keepers.add(card);
                        flag3 = 1;
                    }
                    if (card.get_rank() == 11 && flag4 == 0) {
                        keepers.add(card);
                        flag4 = 1;
                    }
                    if (card.get_rank() == 10 && flag5 == 0) {
                        keepers.add(card);
                        flag5 = 1;
                    }
                }
            }
            if (keepers.size() == 4){
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> is3A(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        for (Card card: cards) {
            if (card.get_rank() == 1) {
                keepers.add(card);
            }
        }
        if (keepers.size() == 3)
            return keepers;
        return null;
    }

    ArrayList<Card> isSFFH(Deck hand) {
        if (check_S(hand))
            return hand.get_cards();
        else if (check_F(hand))
            return hand.get_cards();
        else if (check_FH(hand))
            return hand.get_cards();
        else
            return null;
    }

    ArrayList<Card> isToaK(Deck hand) {
        if (check_ToaK(hand) && hand.get_cards().get(4).get_rank() != '1')
            return hand.get_cards();
        else
            return null;
    }

    ArrayList<Card> is4toSF(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        for (int i=0; i<2; i++) {
            int high_rank = cards.get(i).get_rank();
            int flag = 0;
            keepers.clear();
            for(Card card: cards) {
                if (high_rank-card.get_rank() == 2 && flag == 0) {
                    keepers.add(card);
                    high_rank -= 2;
                    flag = 1;
                } else {
                    if (high_rank-card.get_rank() == 1) {
                        keepers.add(card);
                        high_rank--;
                    }
                }
            }
            if (keepers.size() == 4){
                Character suit = keepers.get(0).get_suit();
                for (Card card: keepers) {
                    if (!suit.equals(card.get_suit())) {
                        return null;
                    }
                }
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> isTP(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int pairs = 0;
        for (int i=0; i<4; i++) {
            if (cards.get(i).get_rank() == cards.get(i+1).get_rank()) {
                if (i == 3 || cards.get(i).get_rank() != cards.get(i+2).get_rank()){
                    keepers.add(cards.get(i));
                    keepers.add(cards.get(i+1));
                    pairs++;
                }
            }
        }
        if (pairs == 2)
            return keepers;
        return null;
    }

    ArrayList<Card> isHP(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        for (int i=0; i<4; i++) {
            if (cards.get(i).get_rank() == cards.get(i+1).get_rank() && (cards.get(i).get_rank()>=11 || cards.get(i).get_rank()==1)) {
                if (i == 3 || cards.get(i).get_rank() != cards.get(i+2).get_rank()){
                    keepers.add(cards.get(i));
                    keepers.add(cards.get(i+1));
                    return keepers;
                }
            }
        }
        return null;
    }

    ArrayList<Card> is4toF(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        for (int i=0; i<=3; i++) {
            for (Card card:cards){
                if (card.get_suit_idx()==i){
                    keepers.add(card);
                }
            }
            if (keepers.size()==4){
                return keepers;
            }else{
                keepers.clear();
            }
        }  
        return null;
    }

    ArrayList<Card> is3toRF(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();

        for(Card card: cards) {
            if (card.get_rank() == 1)
                keepers.add(card);
            if (card.get_rank() == 13)
                keepers.add(card);
            if (card.get_rank() == 12)
                keepers.add(card);
            if (card.get_rank() == 11)
                keepers.add(card);
            if (card.get_rank() == 10)
                keepers.add(card);
        }
        if (keepers.size() == 3){
            Character suit = keepers.get(0).get_suit();
            for (Card card: keepers) {
                if (!suit.equals(card.get_suit())) {
                    return keepers;
                }
            }
        }
        return null;
    }

    ArrayList<Card> is4toOutsideS(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        for (int i=0; i<2; i++) {
            int high_rank = cards.get(i).get_rank();
            keepers.clear();
            keepers.add(cards.get(i));
            for(Card card: cards) {
                if (high_rank-card.get_rank() == 1) {
                    high_rank--;
                    keepers.add(card);
                }
            }
            if (keepers.size() == 4) {
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> isLP(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        for (int i=0; i<4; i++) {
            if (cards.get(i).get_rank() == cards.get(i+1).get_rank()) {
                if (i == 3 || cards.get(i).get_rank() != cards.get(i+2).get_rank()){
                    keepers.add(cards.get(i));
                    keepers.add(cards.get(i+1));
                    return keepers;
                }
            }
        }
        return null;
    }

    ArrayList<Card> isAKQJ(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        
        if (cards.get(4).get_rank() == 1 && cards.get(0).get_rank() == 13 &&
        cards.get(1).get_rank() == 12 && cards.get(2).get_rank() == 11) {
            keepers.add(cards.get(0));
            keepers.add(cards.get(1));
            keepers.add(cards.get(2));
            keepers.add(cards.get(4));
            return keepers;
        }
        return null;
    }

    ArrayList<Card> is3toSF1(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int high_cards = 0, gaps = 0;
        for (int i=0; i<3; i++) {
            int high_rank = cards.get(i).get_rank();
            keepers.clear();
            gaps = 0;
            for(Card card: cards) {
                if (card.get_rank()>10 || card.get_rank()==1){
                    high_cards++;
                }
                if (card.get_rank() == 2 && high_cards > 0) {
                    high_cards = 0;
                }
                if (high_rank-card.get_rank() == 3) {
                    gaps += 2;
                    keepers.add(card);
                    high_rank -= 3;
                } else if (high_rank-card.get_rank() == 2) {
                    gaps += 1;
                    keepers.add(card);
                    high_rank -= 2;
                } else {
                    if (high_rank-card.get_rank() == 1) {
                        keepers.add(card);
                        high_rank--;
                    }
                }
            }
            if (keepers.size() == 3 && high_cards >= gaps) {
                Character suit = keepers.get(0).get_suit();
                for (Card card: keepers) {
                    if (!suit.equals(card.get_suit())) {
                        return null;
                    }
                }
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> is4toInsideS_3HC(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int high_cards = 0, flag = 0;
        for (int i=0; i<3; i++) {
            int high_rank = cards.get(i).get_rank();
            keepers.clear();
            for(Card card: cards) {
                if (card.get_rank()>10 || card.get_rank()==1){
                    high_cards++;
                }
                if (high_rank-card.get_rank() == 1) {
                    keepers.add(card);
                    high_rank--;
                } else if (high_rank-card.get_rank() == 2 && flag == 0) {
                    keepers.add(card);
                    high_rank -= 2;
                    flag = 1;
                }
            }
            if (keepers.size() == 4 && high_cards==3) {
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> is3toF_2HC(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int high_cards;
        for (int i=0; i<=3; i++) {
            high_cards = 0;
            for (Card card:cards){
                if (card.get_suit_idx()==i){
                    if (card.get_rank() >= 11 || card.get_rank() == 1)
                        high_cards++;
                    keepers.add(card);
                }
            }
            if (keepers.size()==3 && high_cards==2)
                return keepers;
            keepers.clear();
        }
        return null;
    }

    ArrayList<Card> is2SuitedHC(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int high_cards = 0;
        ArrayList<Integer> idx = new ArrayList<Integer>();
        int i, j;

        for (i=4; i>=0; i--) {
            if (cards.get(i).get_rank() > 10 || cards.get(i).get_rank() == 1){
                high_cards++;
                idx.add(i);
            }
        }
        if(high_cards >= 2) {
            for (i=0; i< idx.size(); i++){
                for (j=i+1; j< idx.size(); j++){
                    if (cards.get(idx.get(i)).get_suit() == cards.get(idx.get(j)).get_suit()) {
                        keepers.add(cards.get(idx.get(i)));
                        keepers.add(cards.get(idx.get(j)));
                        return keepers;
                    }  
                }
            }
        }
            
        return null;
    }

    ArrayList<Card> is4toInsideS_2HC(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int high_cards = 0, flag = 0;
        for (int i=0; i<3; i++) {
            int high_rank = cards.get(i).get_rank();
            keepers.clear();
            for(Card card: cards) {
                if (card.get_rank()>10 || card.get_rank()==1){
                    high_cards++;
                }
                if (high_rank-card.get_rank() == 1) {
                    keepers.add(card);
                    high_rank--;
                } else if (high_rank-card.get_rank() == 2 && flag == 0) {
                    keepers.add(card);
                    high_rank -= 2;
                    flag = 1;
                }
            }
            if (keepers.size() == 4 && high_cards==2) {
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> is3toSF2(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int high_cards = 0, gaps = 0;
        for (int i=0; i<3; i++) {
            int high_rank = cards.get(i).get_rank();
            keepers.clear();
            gaps = 0;
            for(Card card: cards) {
                if (card.get_rank()>10 || card.get_rank()==1){
                    high_cards++;
                }
                if (high_rank-card.get_rank() == 3) {
                    gaps += 2;
                    keepers.add(card);
                    high_rank -= 3;
                } else if (high_rank-card.get_rank() == 2) {
                    gaps += 1;
                    keepers.add(card);
                    high_rank -= 2;
                } else {
                    if (high_rank-card.get_rank() == 1) {
                        keepers.add(card);
                        high_rank--;
                    }
                }
            }
            if (keepers.size() == 3 && (gaps==1 || (gaps==2 && high_cards==1))) {
                Character suit = keepers.get(0).get_suit();
                for (Card card: keepers) {
                    if (!suit.equals(card.get_suit())) {
                        return null;
                    }
                }
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> is4toInsideS_1HC(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int high_cards = 0, flag = 0;
        for (int i=0; i<3; i++) {
            int high_rank = cards.get(i).get_rank();
            keepers.clear();
            for(Card card: cards) {
                if (card.get_rank()>10 || card.get_rank()==1){
                    high_cards++;
                }
                if (high_rank-card.get_rank() == 1) {
                    keepers.add(card);
                    high_rank--;
                } else if (high_rank-card.get_rank() == 2 && flag == 0) {
                    keepers.add(card);
                    high_rank -= 2;
                    flag = 1;
                }
            }
            if (keepers.size() == 4 && high_cards==1) {
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> isKQJunsuited(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        
        if (cards.get(0).get_rank() == 13 && cards.get(1).get_rank() == 12 && cards.get(2).get_rank() == 11) {
            keepers.add(cards.get(0));
            keepers.add(cards.get(1));
            keepers.add(cards.get(2));
            return keepers;
        }
        return null;
    }

    ArrayList<Card> isJT(Deck hand, boolean suited) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();

        Card jack=null, ten=null;

        for (Card card: cards) {
            if (card.get_rank() == 11)
                jack = card;
            if (card.get_rank() == 10)
                ten = card;
        }
        if (jack!=null && ten!=null) {
            keepers.add(jack);
            keepers.add(ten);
            if (suited) {
                if (jack.get_suit() == ten.get_suit()) {
                    return keepers;
                }
            } else
                return keepers;
        }
        
        return null;
    }

    ArrayList<Card> isQJ(Deck hand, boolean suited) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();

        Card queen=null, jack=null;

        for (Card card: cards) {
            if (card.get_rank() == 12)
                queen = card;
            if (card.get_rank() == 11)
                jack = card;
        }
        if (queen!=null && jack!=null) {
            keepers.add(queen);
            keepers.add(jack);
            if (suited) {
                if (queen.get_suit() == jack.get_suit()) {
                    return keepers;
                }
            } else
                return keepers;
        }
        
        return null;
    }

    ArrayList<Card> is3toF_1HC(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int high_cards;
        for (int i=0; i<=3; i++) {
            high_cards = 0;
            for (Card card:cards){
                if (card.get_suit_idx()==i){
                    if (card.get_rank() >= 11 || card.get_rank() == 1)
                        high_cards++;
                    keepers.add(card);
                }
            }
            if (keepers.size()==3 && high_cards==1)
                return keepers;
            keepers.clear();
        }
        return null;
    }

    ArrayList<Card> isQT(Deck hand, boolean suited) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();

        Card queen=null, ten=null;

        for (Card card: cards) {
            if (card.get_rank() == 12)
                queen = card;
            if (card.get_rank() == 10)
                ten = card;
        }
        if (queen!=null && ten!=null) {
            keepers.add(queen);
            keepers.add(ten);
            if (suited) {
                if (queen.get_suit() == ten.get_suit()) {
                    return keepers;
                }
            } else
                return keepers;
        }
        
        return null;
    }

    ArrayList<Card> is3toSF3(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int gaps;
        for (int i=0; i<3; i++) {
            int high_rank = cards.get(i).get_rank();
            keepers.clear();
            gaps = 0;
            for(Card card: cards) {
                if (high_rank-card.get_rank() == 3) {
                    gaps += 2;
                    keepers.add(card);
                    high_rank -= 3;
                } else if (high_rank-card.get_rank() == 2) {
                    gaps += 1;
                    keepers.add(card);
                    high_rank -= 2;
                } else {
                    if (high_rank-card.get_rank() == 1) {
                        keepers.add(card);
                        high_rank--;
                    }
                }
            }
            if (keepers.size() == 3 && gaps == 2) {
                Character suit = keepers.get(0).get_suit();
                for (Card card: keepers) {
                    if (!suit.equals(card.get_suit())) {
                        return null;
                    }
                }
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> isKQorKJ(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();

        Card king=null, queen=null, jack=null;

        for (Card card: cards) {
            if (card.get_rank() == 13)
                king = card;
            if (card.get_rank() == 12)
                queen = card;
            if (card.get_rank() == 11)
                jack = card;
        }
        if (king!=null) {
            keepers.add(king);
            if (queen!=null) {
                keepers.add(queen);
                return keepers;
            }
            if (jack!=null) {
                keepers.add(jack);
                return keepers;
            }
        }

        return null;
    }

    ArrayList<Card> isA(Deck hand) {
        ArrayList<Card> keepers = new ArrayList<Card>();
        if (hand.get_cards().get(4).get_rank() == 1) {
            keepers.add(hand.get_cards().get(4));
            return keepers;
        }

        return null;
    }

    ArrayList<Card> isKT(Deck hand, boolean suited) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();

        Card king=null, ten=null;

        for (Card card: cards) {
            if (card.get_rank() == 13)
                king = card;
            if (card.get_rank() == 10)
                ten = card;
        }
        if (king!=null && ten!=null) {
            keepers.add(king);
            keepers.add(ten);
            if (suited) {
                if (king.get_suit() == ten.get_suit()) {
                    return keepers;
                }
            } else
                return keepers;
        }
        
        return null;
    }

    ArrayList<Card> isJorQorK(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();

        for (Card card: cards) {
            if (card.get_rank() == 13) {
                keepers.add(card);
                return keepers;
            } else if (card.get_rank() == 12) {
                keepers.add(card);
                return keepers;
            } else if (card.get_rank() == 11) {
                keepers.add(card);
                return keepers;
            }
        }

        return null;
    }

    ArrayList<Card> is4toInsideS_0HC(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        int high_cards = 0, flag = 0;
        for (int i=0; i<3; i++) {
            int high_rank = cards.get(i).get_rank();
            keepers.clear();
            keepers.add(cards.get(i));
            for(Card card: cards) {
                if (high_rank-card.get_rank() == 1) {
                    keepers.add(card);
                    high_rank--;
                } else if (high_rank-card.get_rank() == 2 && flag == 0) {
                    keepers.add(card);
                    high_rank -= 2;
                    flag = 1;
                }
            }
            if (keepers.size() == 4 && high_cards==0) {
                return keepers;
            }
        }
        return null;
    }

    ArrayList<Card> is3toF_0HC(Deck hand) {
        ArrayList<Card> cards = hand.get_cards();
        ArrayList<Card> keepers = new ArrayList<Card>();
        for (int i=0; i<=3; i++) {
            for (Card card:cards){
                if (card.get_suit_idx()==i){
                    if (card.get_rank() >= 11 || card.get_rank() == 1)
                    keepers.add(card);
                }
            }
            if (keepers.size()==3)
                return keepers;
            keepers.clear();
        }
        return null;
    }

}