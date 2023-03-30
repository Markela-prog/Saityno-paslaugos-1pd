package lt.viko.eif.emarkevicius.casino;

import lt.viko.eif.emarkevicius.casino.model.*;
import lt.viko.eif.emarkevicius.casino.service.Dealer;
import lt.viko.eif.emarkevicius.casino.service.Deck;
import lt.viko.eif.emarkevicius.casino.service.BlackJack;
import lt.viko.eif.emarkevicius.casino.service.Poker;
import lt.viko.eif.emarkevicius.casino.service.Roulette;
import lt.viko.eif.emarkevicius.casino.util.JaxbUtil;
import lt.viko.eif.emarkevicius.casino.util.XMLValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello world!");

        Account account = new Account(1,"1@gmail.com","password1",20,0,0);
        Account account2 = new Account( 1,"2@gmail.com", "password2", 22,0,0);
        account.setBalance(100);
        account2.setBalance(250);
        account2.setCredits(10);

        Player player = new Player( 1,"ProfileName1", account);
        Player player2 = new Player(1, "ProfileName2", account2);


        account.deposit(500);
        account.deposit(20);
        account.withdrawn(10);
        account2.deposit(100);
        account2.withdrawn(150);


        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        playerList.add(player2);

        Dealer dealer = new Dealer(1,"Dealer1");
        Dealer dealer1 = new Dealer(2,"Dealer2");

        List<Dealer> dealers = new ArrayList<>();
        dealers.add(dealer);
        dealers.add(dealer1);

        Deck deck = new Deck();
        deck.shuffle();

        CardsGame blackJack = new BlackJack(1,"Blackjack","desc","rules",0.5,100,deck,dealer);
        CardsGame poker = new Poker(2, "Poker", "desc","rules",1,1000,deck,
                dealers.get(1));
        Game roulette = new Roulette(3,"Roulette","desc","rules", 0.1,1000);

        account.addBet(new Bet(1,100,"Win"));
        account.addBet(new Bet(2,100,"Lose"));
        account2.addBet(new Bet(3,50,"Win"));
        account2.addBet(new Bet(4,100,"Lose"));

        List<Game> games = new ArrayList<>();
        games.add(roulette);
        List<CardsGame> cardsGames = new ArrayList<>();
        cardsGames.add(blackJack);
        cardsGames.add(poker);
        games.addAll(cardsGames);

        Casino casino = new Casino(1,games, playerList);

        //System.out.println(casino);

        JaxbUtil.convertToXML(casino);
        //HibernateApp.saveToDatabase(casino);


        if(XMLValidator.validateXML("generated.xml","casino.xsd")){
            Casino casino1 = JaxbUtil.convertFromXML("generated.xml");
            System.out.println(casino1);

            //MyMessageSender sender = new MyMessageSender();
            //sender.sendMessage(new File("generated.xml"));
        }





    }


}
