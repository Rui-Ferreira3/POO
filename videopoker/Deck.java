package videopoker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    /**
     * Construtor do deck
     * Cria uma lista vazia no deck
     */
    public Deck(){
        this.deck= new ArrayList<Card>();
    }
    /**
     * Adiciona uma carta ao deck
     */
	void add_card(Card card) {
		this.deck.add(card);
	}

    /**
     * Retira uma carta do baralho
     * @param index é o indice da carta no deck
     * @return a carta da posição especificada
     */
	Card remove_card(int index) {
        Card carta = deck.remove(index);
        return carta;
	}

    /**
     * Coloca uma carta numa posição especifica do deck
     * @param i é o indice da carta a ser substituida da mao do jogador
     * @param card é a nova carta para ser colocada na mão do jogador
     * @return a carta para ser substituida da mao do jogador
     */   
    Card put_card(int i, Card card) {
        Card removed_card = this.deck.get(i);
        this.deck.set(i, card);
        return removed_card;
    }
    /**
     * @return a lista de cartas do deck
     */
    ArrayList<Card> get_cards() {
        return this.deck;
    }

    /**
     * Reeordena as cartas do deck de maneira aleatoria
     */
	public void shuffle() {
		Collections.shuffle(deck);
	}

    /**
     * Preenche a lista de cartas do deck com as cartas de um baralho
     */
    public void create_deck() {
        for (int suit = 0; suit < 4; suit++)
            for (int rank = 0; rank < 13; rank++)
                deck.add(new Card(rank, suit));
    }

    /**
     * Ordena as cartas com a mais alta na primeria posicao da fila e a mais baixa na ultima. O às é a carta mais baixa
     */
    void order_deck(){
        Collections.sort(this.deck, (d1, d2) -> {
            return d2.get_rank() - d1.get_rank();
        });
    }

    /**
     * Adiciona cartas do ficheiro recebido à lista de cartas do deck
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
                        if (Character.getNumericValue(carta.charAt(0)) == Card.ranks[j]){
                            rank= j;
                            break;
                        }
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
                        if (carta.charAt(1) == Card.suits[a]){
                            suit = a;
                            break;
                        }
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
