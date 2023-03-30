package lt.viko.eif.emarkevicius.casino.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lt.viko.eif.emarkevicius.casino.model.CardsGame;

/**
 * A class that represents the Poker game, which is a sub-class of the {@link CardsGame} class.
 * Representing the whole logic of poker game
 *
 * @author Ernestas
 * @see Poker
 * @since 1.0
 */
@XmlRootElement(name = "Poker")
@XmlAccessorType(XmlAccessType.FIELD)

public class Poker extends CardsGame {

    /**
     * The number of cards to deal per hand in a game of Poker.
     */
    private static final int NUM_CARDS_PER_HAND = 5;

    /**
     * Constructor for the Poker class that initializes the game with the specified parameters.
     * @param id the ID of the game.
     * @param name the name of the game.
     * @param description the description of the game.
     * @param rules the rules of the game.
     * @param minBet the minimum bet allowed in the game.
     * @param maxBet the maximum bet allowed in the game.
     * @param deck the deck of cards to use in the game.
     * @param dealer the dealer to use in the game.
     */
    public Poker(int id, String name, String description, String rules, double minBet, double maxBet,
                 Deck deck, Dealer dealer) {
        super(id, name, description, rules, minBet, maxBet, deck, dealer);

    }

    /**
     * Constructor for the Poker class that initializes the game with the specified parameters.
     * @param name the name of the game.
     * @param description the description of the game.
     * @param rules the rules of the game.
     * @param minBet the minimum bet allowed in the game.
     * @param maxBet the maximum bet allowed in the game.
     * @param deck the deck of cards to use in the game.
     * @param dealer the dealer to use in the game.
     */

    public Poker(String name, String description, String rules, double minBet, double maxBet,
                 Deck deck, Dealer dealer) {
        super( name, description, rules, minBet, maxBet, deck, dealer);
    }

    /**
     * no-arg constructor
     */
    public Poker(){}

    /**
     * Implements the play method for the BlackJack class.
     * Deals the specified number of cards per hand to each player
     *  and proceeds with the rest of the game implementation
     */
    @Override
    public void play() {
        dealCards(NUM_CARDS_PER_HAND);
        // rest of game implementation
    }
}
