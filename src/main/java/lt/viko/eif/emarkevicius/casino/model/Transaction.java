package lt.viko.eif.emarkevicius.casino.model;

import javax.persistence.*;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Represents a financial transaction associated with an account.
 *
 * @author Ernestas
 * @see Transaction
 * @since 1.0
 */
@XmlType(propOrder = {"id","transactionType","amount"})
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "transaction_type")
    private String transactionType;
    private double amount;

    /**
     * Creates a new transaction with the specified parameters.
     * @param id the unique identifier for this transaction
     * @param transactionType the type of transaction, e.g. deposit or withdrawal
     * @param amount the amount of the transaction
     */
    public Transaction(int id, String transactionType, double amount) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    /**
     * Creates a new transaction with the specified parameters.
     * @param transactionType the type of transaction, e.g. deposit or withdrawal
     * @param amount the amount of the transaction
     */
    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    /**
     * no-arg constructor
     */
    public Transaction(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\t\t\tTransaction: \n");
        sb.append("\t\t\t\t\t\tId = ").append(id).append("\n");
        sb.append("\t\t\t\t\t\tType = ").append(transactionType).append("\n");
        sb.append("\t\t\t\t\t\tAmount = ").append(amount).append("");


        return sb.toString();
    }

}
