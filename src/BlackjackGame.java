public class BlackjackGame {

    private Deck deck;
    private Player player;
    private Dealer dealer;

    public BlackjackGame(Deck deck, Player player, Dealer dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }

    public void startGame() {
        System.out.println("--Dealing Starting Cards--");
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.printHand();
        player.printHand();
    }

    public Player playRound() {
        if (player.takeTurn(deck)) {
            return dealer;
        }
        if (dealer.takeTurn(deck)) {
            return player;
        }
        return determineWinner();
    }

    public Player determineWinner() {
        if (player.hand.calculateValue() == dealer.hand.calculateValue()) {
            System.out.println("It's a tie!");
        }
        return player.hand.calculateValue() > dealer.hand.calculateValue() ? player : dealer;
    }

}
