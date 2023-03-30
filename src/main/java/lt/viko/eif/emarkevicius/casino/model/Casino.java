package lt.viko.eif.emarkevicius.casino.model;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.XmlTransient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  The Casino class represents a casino that contains a list of games and players.
 *  Each casino is identified by a unique ID
 *
 * @author Ernestas
 * @see Casino
 * @since 1.0
 */
@XmlType(propOrder = {"id", "games", "players"})
@XmlRootElement(name = "casino")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "casino")
public class Casino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @XmlElementWrapper(name = "games")
    @XmlElement(name = "game")
    @OneToMany(targetEntity = Game.class,cascade = CascadeType.ALL)
    @Transient
    private List<Game> games;

    @XmlElementWrapper(name = "players")
    @XmlElement(name = "player")
    @OneToMany(targetEntity = Player.class,cascade = CascadeType.ALL)
    @Transient
    private List<Player> players;

    /**
     * Constructs a Casino object with the given ID, list of games, and list of players.
     * @param id The ID of the casino.
     * @param gameList The list of games in the casino.
     * @param players The list of players in the casino.
     */
    public Casino(int id, List<Game> gameList, List<Player> players) {
        this.id = id;
        this.games = gameList;
        this.players = players;
    }

    /**
     * Constructs a Casino object with the given list of games and list of players.
     * @param gameList The list of games in the casino.
     * @param players The list of players in the casino.
     */
    public Casino(List<Game> gameList, List<Player> players) {
        this.games = gameList;
        this.players = players;
    }


    /**
     * no-arg constructor
     */
    public Casino() {
    }

    /**
     * Constructor for unit test
     * @param id The ID of the casino.
     */
    public Casino(int id){
        this.id = id;
        this.games = new ArrayList<Game>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> gameList) {
        this.games = gameList;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Returns the game with the specified id from the list of games in the casino.
     * If the game is not found, returns null.
     *
     * @param id the id of the game to retrieve
     * @return the game with the specified id, or null if not found
     */
    public Game getGameById(int id) {
        for (Game game : games) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null; // game with specified id not found
    }

    public void addGame(Game game) {
        games.add(game);
    }

    private String constructGameString() {
        String result = "";
        for (Game game : this.games) {
            result += game.toString();
        }
        return result;
    }

    private String constructPlayerString() {
        String result = "";
        for (Player player : this.players) {
            result += player.toString();
        }
        return result;
    }

    public String toString() {
        return String.format("Casino:\n" +
                        "\tGames: \n%s"+
                        "\tPlayers: \n%s",
                constructGameString(),
                constructPlayerString());
    }
}
