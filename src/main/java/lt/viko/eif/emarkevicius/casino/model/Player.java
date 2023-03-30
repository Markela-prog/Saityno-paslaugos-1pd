package lt.viko.eif.emarkevicius.casino.model;

import javax.persistence.*;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Represents a player in casino.
 *
 * @author Ernestas
 * @see Player
 * @since 1.0
 */
@XmlType(propOrder = {"id", "name", "account"})
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "profile_name")
    private String name;
    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    private Account account;

    /**
     * Constructs a player with the specified id, name, account and transactions.
     *
     * @param id      id of the player
     * @param name    name of the player
     * @param account account of the player
     */
    public Player(int id, String name, Account account) {
        this.id = id;
        this.name = name;
        this.account = account;

    }


    /**
     * Constructs a player with the specified name, account and transactions.
     *
     * @param name    name of the player
     * @param account account of the player
     */
    public Player(String name, Account account) {
        this.name = name;
        this.account = account;

    }

    /**
     * no-arg constructor
     */
    public Player(){

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public String toString() {
        return String.format("\t\tPlayer:\n\t\t\tName = %s\n\t\t\t" +
                        "Account: \n\t%s\n",
                this.name,
                this.account);
    }
}
