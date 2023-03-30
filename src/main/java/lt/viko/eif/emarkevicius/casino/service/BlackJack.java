package lt.viko.eif.emarkevicius.casino.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lt.viko.eif.emarkevicius.casino.model.CardsGame;


/**
 * A class that represents the BlackJack game, which is a sub-class of the {@link CardsGame} class.
 * Represents the whole logic of blackjack game
 *
 * @author Ernestas
 * @see BlackJack
 * @since 1.0
 */
@XmlRootElement(name = "BlackJack")
@XmlAccessorType(XmlAccessType.FIELD)

public class BlackJack extends CardsGame {
    /**
     * The number of cards that each player gets at the start of the game.
     */
    private static final int NUM_CARDS_PER_HAND = 2;

    /**
     * Constructor for the BlackJack class that takes in all necessary parameters.
     * @param id the unique identifier for the game.
     * @param name the name of the game.
     * @param description a brief description of the game.
     * @param rules the rules of the game.
     * @param minBet the minimum bet amount for the game.
     * @param maxBet the maximum bet amount for the game.
     * @param deck the deck of cards used in the game.
     * @param dealer the dealer object used in the game.
     */
    public BlackJack(int id, String name, String description, String rules, double minBet, double maxBet,
                     Deck deck, Dealer dealer) {
        super(id, name, description, rules, minBet, maxBet, deck, dealer);
    }

    /**
     * Constructor for the BlackJack class that does not take in an id parameter.
     * @param name the name of the game.
     * @param description a brief description of the game.
     * @param rules the rules of the game.
     * @param minBet the minimum bet amount for the game.
     * @param maxBet the maximum bet amount for the game.
     * @param deck the deck of cards used in the game.
     * @param dealer the dealer object used in the game.
     */
    public BlackJack(String name, String description, String rules, double minBet, double maxBet,
                     Deck deck, Dealer dealer) {
        super(name, description, rules, minBet, maxBet, deck, dealer);
    }

    /**
     * no-arg constructor
     */
    public BlackJack(){}

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
