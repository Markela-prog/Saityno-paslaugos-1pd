package lt.viko.eif.emarkevicius.casino.tests;

import lt.viko.eif.emarkevicius.casino.model.Casino;
import lt.viko.eif.emarkevicius.casino.model.Game;
import lt.viko.eif.emarkevicius.casino.service.Roulette;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class tests the addGame() method of the Casino class.
 * Ensures that a new game can be added to the casino's list of games
 * and that the game can be retrieved correctly
 *
 * @author Ernestas
 * @see CasinoTest
 * @since 1.0
 */
public class CasinoTest {
    @Test
    public void testAddGame() {
        Casino casino = new Casino(1);
        Game game = new Roulette(1, "Roulette", "Desc", "Rules",
                10.0, 100.0);

        casino.addGame(game);

        // ensure the game was added to the list
        assertTrue(casino.getGames().contains(game));

        // ensure the game can be retrieved correctly
        Game retrievedGame = casino.getGameById(game.getId());
        assertEquals(game, retrievedGame);
    }
}
