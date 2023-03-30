package lt.viko.eif.emarkevicius.casino.model;
import lt.viko.eif.emarkevicius.casino.service.BlackJack;
import lt.viko.eif.emarkevicius.casino.service.Poker;
import lt.viko.eif.emarkevicius.casino.service.Roulette;

import javax.persistence.*;

import jakarta.xml.bind.annotation.*;

/**
 * The abstract Game class represents a generic game that can be played in a casino.
 * It contains information about the game, such as its name, description, rules, minimum bet, and maximum bet
 * This class is abstract and cannot be instantiated directly. Instead, it serves as a base class for
 *  specific game implementations, such as Blackjack, Poker, or Roulette
 *
 * @author Ernestas
 * @see Game
 * @since 1.0
 */
@XmlRootElement(name = "game")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Roulette.class})
@XmlType(propOrder = {"id", "name", "description", "rules", "minBet", "maxBet"})
@Entity
@Table(name = "games")
public abstract class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String rules;
    @Column(name = "minimum_bet")
    private double minBet;
    @Column(name = "maximum_bet")
    private double maxBet;


    /**
     * Constructs a new Game object with the specified ID, name, description, rules, minimum bet, and maximum bet.
     * @param id The unique ID of the game.
     * @param name The name of the game.
     * @param description A brief description of the game.
     * @param rules The rules of the game.
     * @param minBet The minimum bet allowed for the game.
     * @param maxBet The maximum bet allowed for the game.
     */
    public Game(int id, String name, String description, String rules, double minBet, double maxBet) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rules = rules;
        this.minBet = minBet;
        this.maxBet = maxBet;
    }

    /**
     * Constructs a new Game object with the specified name, description, rules, minimum bet, and maximum bet.
     * The ID of the game will be automatically generated
     * @param name The name of the game.
     * @param description A brief description of the game.
     * @param rules The rules of the game.
     * @param minBet The minimum bet allowed for the game.
     * @param maxBet The maximum bet allowed for the game.
     */
    public Game(String name, String description, String rules, double minBet, double maxBet) {
        this.name = name;
        this.description = description;
        this.rules = rules;
        this.minBet = minBet;
        this.maxBet = maxBet;
    }

    /**
     * no-arg constructor
     */
    public Game() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public double getMinBet() {
        return minBet;
    }

    public void setMinBet(double minBet) {
        this.minBet = minBet;
    }

    public double getMaxBet() {
        return maxBet;
    }

    public void setMaxBet(double maxBet) {
        this.maxBet = maxBet;
    }

    /**
     * This method is used to start playing the game.
     * The implementation of the method should vary based on the type of game being played
     * For example, a card game would have a different implementation than a board game
     * The method is expected to execute the game logic and produce a result
     * This method should be implemented by the subclasses of the Game class
     */
    public abstract void play();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tGame: \n");
        sb.append("\t\t\tId = ").append(id).append("\n");
        sb.append("\t\t\tName = ").append(name).append("\n");
        sb.append("\t\t\tDescription = ").append(description).append("\n");
        sb.append("\t\t\tRules = ").append(rules).append("\n");
        sb.append("\t\t\tMin Bet = ").append(minBet).append("\n");
        sb.append("\t\t\tMax Bet = ").append(maxBet).append("\n");

        return sb.toString();
    }
}
