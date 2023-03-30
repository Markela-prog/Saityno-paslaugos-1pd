package lt.viko.eif.emarkevicius.casino.service;

import javax.persistence.*;

/**
 * Represents a dealer.
 *
 * @author Ernestas
 * @see Dealer
 * @since 1.0
 */
public class Dealer {

    private int id;
    private String name;
    private Deck deck;

    /**
     * Constructs a dealer with the specified id, name and deck.
     * This constructor is for cards games
     * @param id the id of the dealer
     * @param name the name of the dealer
     * @param deck The deck of cards that the dealer has for the game.
     */
    public Dealer(int id, String name, Deck deck) {
        this.id = id;
        this.name = name;
        this.deck = deck;
    }

    public Dealer(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public Dealer(String name){
        this.name = name;
    }

    public Dealer(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }


    public Card dealCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return deck.dealCard();
    }
    public String toString(){
        return String.format("\n\t\tDealer: \n\t\t\tID = %d\t\t\t",
                this.id);
    }
}
