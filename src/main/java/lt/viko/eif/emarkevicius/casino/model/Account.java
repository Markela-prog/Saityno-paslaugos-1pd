package lt.viko.eif.emarkevicius.casino.model;

import jakarta.xml.bind.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an account assigned to particular player,
 * represented by {@link Player} class.
 * An account contains information about the user's identity, balance,
 *  and transaction history
 * The class provides methods to deposit and withdraw money from the user's balance,
 *  and to add bets to the user's list of bets. It also includes methods to retrieve
 *  information about the player's account, such as their email, password, and transaction history
 *
 *
 * @author Ernestas
 * @see Account
 * @since 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "email", "password", "age", "balance", "credits", "transactions", "bets"})
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private int age;
    private double balance;
    private int credits;
    /**
     * A list of transactions associated with the user's account
     */
    @XmlElementWrapper(name = "transactions")
    @XmlElement(name = "transaction")
    @OneToMany(targetEntity = Transaction.class,cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    /**
     * A list of bets associated with the user's account
     */
    @XmlElementWrapper(name = "bets")
    @XmlElement(name = "bet")
    @OneToMany(targetEntity = Bet.class,cascade = CascadeType.ALL)
    private List<Bet> bets;

    /**
     * Constructor that initializes an account object with specified values for all fields
     * @param id the id of the account
     * @param email the email address associated with the account
     * @param password the password associated with the account
     * @param age the age of the user associated with the account
     * @param balance the current balance of the user's account
     * @param credits the number of credits associated with the user's account
     */
    public Account(int id, String email, String password, int age, double balance, int credits) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.age = age;
        this.balance = balance;
        this.credits = credits;
        this.transactions = new ArrayList<>();
        this.bets = new ArrayList<>();
    }

    /**
     * Constructor that initializes an account object with specified values for all fields except the id
     * @param email the email address associated with the account
     * @param password the password associated with the account
     * @param age the age of the user associated with the account
     * @param balance the current balance of the user's account
     * @param credits the number of credits associated with the user's account
     */
    public Account(String email, String password, int age, double balance, int credits) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.balance = balance;
        this.credits = credits;
        this.transactions = new ArrayList<>();
        this.bets = new ArrayList<>();
    }

    /**
     * no-arg constructor
     */
    public Account(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public void addBet(Bet bet) {
        bets.add(bet);
    }

    /**
     * Assume legal age is 18
     *
     * @return true if older than 18
     */
    public boolean isLegalAge() {
        return age >= 18;
    }

    /**
     * Withdraws the specified amount from the account balance.
     *
     * @param amount the amount of balance that player wants to withdraw
     *
     */
    public void withdrawn(double amount) {
        balance -= amount;
        Transaction transaction = new Transaction((int) getNextTransactionId(),
                "withdrawal", amount);
        transactions.add(transaction);
        /*if (balance >= amount) {
            balance -= amount;
            Transaction transaction = new Transaction((int) getNextTransactionId(), this,
                    "withdrawal", amount);
            transactions.add(transaction);
        } else {
            throw new Exception("Insufficient funds");
        }*/
    }

    /**
     * Deposits the specified amount into the account balance.
     * @param amount the amount to deposit
     */
    public void deposit(double amount){
        balance += amount;
        Transaction transaction = new Transaction((int) getNextTransactionId(),"deposit",amount);
        transactions.add(transaction);
    }

    /**
     * Method generates the next transaction ID to be used for a new transaction.
     *
     * @return the next transaction ID
     */
    private long getNextTransactionId(){
        //implementation of getting next transaction id
        return 0;
    }

    private String constructTransactionString() {
        String result = "";
        for (Transaction transaction : this.transactions) {
            result += transaction.toString();
        }
        return result;
    }

    public String toString() {
        return String.format("\t\t\tEmail = %s\n"+
                "\t\t\t\tPassword = %s\n" +
                "\t\t\t\tBalance = %f\n" +
                "\t\t\t\tCredits = %s\n" +
                "\t\t\t\tTransactions: %s",
                this.email,
                this.password,
                this.balance,
                this.credits,
                constructTransactionString());
    }
}
