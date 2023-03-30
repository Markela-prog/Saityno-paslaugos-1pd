package lt.viko.eif.emarkevicius.casino.tests;

import lt.viko.eif.emarkevicius.casino.service.Card;
import lt.viko.eif.emarkevicius.casino.service.Deck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests for the Deck class
 *
 * @author Ernestas
 * @see DeckTest
 * @since 1.0
 */
public class DeckTest {
    private Deck deck = new Deck();

    /**
     * Deck should have a size of 52
     */
    @Test
    public void testDeckSize() {
        int expectedSize = 52;
        assertEquals("Deck size should be 52", expectedSize,deck.getSize());
    }

    /**
     * Tests if the deck is shuffled
     */
    @Test
    public void testShuffle() {
        Card firstCard = deck.getCardAt(0);
        Card lastCard = deck.getCardAt(51);
        deck.shuffle();
        assertNotEquals("Deck should be shuffled",firstCard, deck.getCardAt(0));
        assertNotEquals("Deck should be shuffled",lastCard, deck.getCardAt(51));
    }
}
