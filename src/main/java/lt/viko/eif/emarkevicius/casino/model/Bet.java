package lt.viko.eif.emarkevicius.casino.model;

import jakarta.xml.bind.annotation.XmlType;

import javax.persistence.*;

/**
 * Represents a bet made by a specific player in a specific game.
 *
 * @author Ernestas
 * @see Bet
 * @since 1.0
 */
@XmlType(propOrder = {"id", "betAmount", "outcome"})
@Entity
@Table(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "bet_amount")
    private double betAmount;
    private String outcome;

    /**
     * Creates a new bet with the specified parameters.
     * @param id the unique identifier for this bet
     * @param betAmount the amount of the bet
     * @param outcome the outcome of the bet
     */
    public Bet(long id, double betAmount, String outcome) {
        this.id = id;
        this.betAmount = betAmount;
        this.outcome = outcome;
    }

    /**
     * Creates a new bet with the specified parameters.
     * @param betAmount the amount of the bet
     * @param outcome the outcome of the bet
     */
    public Bet(double betAmount, String outcome) {
        this.betAmount = betAmount;
        this.outcome = outcome;
    }

    /**
     * no-arg constructor
     */
    public Bet(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

}
