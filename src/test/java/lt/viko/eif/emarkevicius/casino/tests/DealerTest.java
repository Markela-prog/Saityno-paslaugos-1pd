package lt.viko.eif.emarkevicius.casino.tests;

import lt.viko.eif.emarkevicius.casino.service.Card;
import lt.viko.eif.emarkevicius.casino.service.Dealer;
import lt.viko.eif.emarkevicius.casino.service.Deck;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Test class for the Dealer class's dealCard() method to ensure that it deals a valid card from the deck.
 *
 * @author Ernestas
 * @see DealerTest
 * @since 1.0
 */
public class DealerTest {
    @Test
    public void testDealCard() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(1,"test",deck);
        Card card = dealer.dealCard();
        assertNotNull(card);
    }
}
