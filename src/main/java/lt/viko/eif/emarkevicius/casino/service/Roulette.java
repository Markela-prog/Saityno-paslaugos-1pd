package lt.viko.eif.emarkevicius.casino.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lt.viko.eif.emarkevicius.casino.model.Game;


/**
 * A class that represents the Roulette game, which is a sub-class of the {@link Game} class.
 * Represents the whole logic of roulette game
 *
 * @author Ernestas
 * @see Roulette
 * @since 1.0
 */
@XmlRootElement(name = "game")
@XmlAccessorType(XmlAccessType.FIELD)
public class Roulette extends Game {

    /**
     * Constructor for the Roulette class that initializes the game with the specified parameters.
     * @param id the ID of the game.
     * @param name the name of the game.
     * @param description the description of the game.
     * @param rules the rules of the game.
     * @param minBet the minimum bet allowed in the game.
     * @param maxBet the maximum bet allowed in the game.
     */
    public Roulette(int id, String name, String description, String rules, double minBet, double maxBet) {
        super(id, name, description, rules, minBet, maxBet);
    }

    /**
     * Constructor for the Roulette class that initializes the game with the specified parameters.
     * @param name the name of the game.
     * @param description the description of the game.
     * @param rules the rules of the game.
     * @param minBet the minimum bet allowed in the game.
     * @param maxBet the maximum bet allowed in the game.
     */
    public Roulette(String name, String description, String rules, double minBet, double maxBet) {
        super( name, description, rules, minBet, maxBet);
    }

    /**
     * no-arg constructor
     */
    public Roulette(){}

    /**
     * Implements the play method for a game of Roulette.
     */
    @Override
    public void play() {
        // implementation for roulette game
    }
}
