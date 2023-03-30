package lt.viko.eif.emarkevicius.casino.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class that represents a deck of cards used in card games.
 *
 * @author Ernestas
 * @see Deck
 * @since 1.0
 */
public class Deck {
    private List<Card> cards;

    /**
     * Constructor for the Deck class that initializes the list of cards
     *  to contain all possible cards in a standard deck.
     */
    public Deck() {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }

    }

    public Card getCardAt(int index) {
        return cards.get(index);
    }
    public int getSize() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Shuffles the deck by randomly rearranging the order of the cards.
     */
    public void shuffle() {
        Collections.shuffle(this.cards);

    }

    /**
     * Deals a single card from the top of the deck.
     * @return the card that was dealt.
     * @throws IllegalStateException if the deck is empty.
     */

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }


}

