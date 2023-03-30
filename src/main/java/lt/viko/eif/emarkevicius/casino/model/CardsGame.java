package lt.viko.eif.emarkevicius.casino.model;

import jakarta.xml.bind.annotation.*;
import lt.viko.eif.emarkevicius.casino.service.Dealer;
import lt.viko.eif.emarkevicius.casino.service.Deck;

import lt.viko.eif.emarkevicius.casino.service.BlackJack;
import lt.viko.eif.emarkevicius.casino.service.Poker;

/**
 * A class representing a card game.
 * Extends the abstract class {@link Game}
 *
 * @author Ernestas
 * @see CardsGame
 * @since 1.0
 */
@XmlRootElement(name = "cards-game")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({BlackJack.class, Poker.class})
public abstract class CardsGame extends Game {
    @XmlTransient
    private Deck deck;
    @XmlTransient
    private Dealer dealer;

    /**
     * Constructor for CardsGame class.
     * @param id The id of the game.
     * @param name The name of the game.
     * @param description The description of the game.
     * @param rules The rules of the game.
     * @param minBet The minimum bet for the game.
     * @param maxBet The maximum bet for the game.
     * @param deck The deck of cards for the game.
     * @param dealer The dealer for the game.
     */
    public CardsGame(int id, String name, String description, String rules, double minBet, double maxBet, Deck deck, Dealer dealer) {
        super(id, name, description, rules, minBet, maxBet);
        this.deck = deck;
        this.dealer = dealer;
    }

    /**
     * Constructor for CardsGame class without id.
     * @param name The name of the game.
     * @param description The description of the game.
     * @param rules The rules of the game.
     * @param minBet The minimum bet for the game.
     * @param maxBet The maximum bet for the game.
     * @param deck The deck of cards for the game.
     * @param dealer The dealer for the game.
     */
    public CardsGame(String name, String description, String rules, double minBet, double maxBet, Deck deck, Dealer dealer) {
        super(name, description, rules, minBet, maxBet);
        this.deck = deck;
        this.dealer = dealer;
    }

    /**
     * no-arg constructor
     */
    public CardsGame() {
    }

    /**
     * An abstract method for playing the game.
     */
    public abstract void play();

    /**
     * A method for dealing a specified number of cards in the game.
     * @param cards The number of cards to deal.
     */
    protected void dealCards(int cards) {

    }

    public String toString() {
        return String.format("\t\tCardsGame:\n\t" +
                        "\t\tId = %d\n" +
                        "\t\t\tName = %s\n" +
                        "\t\t\tDescription = %s\n" +
                        "\t\t\tRules = %s\n" +
                        "\t\t\tMin bet = %s\n" +
                        "\t\t\tMax bet = %s\n"
                ,
                super.getId(),
                super.getName(),
                super.getDescription(),
                super.getRules(),
                super.getMinBet(),
                super.getMaxBet());
    }
}
