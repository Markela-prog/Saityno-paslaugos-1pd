package lt.viko.eif.emarkevicius.casino.service;

/**
 * Represents specific card parameters suit and rank
 *
 * @author Ernestas
 * @see Card
 * @since 1.0
 */
public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
