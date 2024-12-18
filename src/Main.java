import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("\n --Blackjack Game-- \n");
        System.out.println("What is your name?");
        String playerName = input.nextLine();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        Player player = new Player(playerHand, playerName, 50);
        Dealer dealer = new Dealer(dealerHand, "Dealer");
        Deck deck = new Deck();

        BlackjackGame blackjackGame = new BlackjackGame(deck, player, dealer);

        boolean gameActive = true;

        while (gameActive) {
            blackjackGame.startGame();
            Player winner = blackjackGame.playRound();
            if (player.hand.calculateValue() == dealer.hand.calculateValue()) {
                System.out.println("It's a Tie!");
            } else {
                System.out.println(winner.name + " Wins!");
                winner.winBet(winner.getBlackjack());
            }

            System.out.println("Would you like to play again? (y/n)");
            if (!input.nextLine().equals("y")) {
                gameActive = false;
            }
            player.hand.clearHand();
            dealer.hand.clearHand();

            if (deck.getCards().size() < 10) {
                System.out.println("Shuffling Cards...");
                deck.shuffleCards();
            }
        }


    }
}