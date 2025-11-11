import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        Scanner input = new Scanner(System.in);
        System.out.println("\n --Blackjack Game-- \n");
        System.out.println("What is your name?");
        String playerName = input.nextLine();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        Player player = new Player(playerHand, playerName, 100);
        Dealer dealer = new Dealer(dealerHand, "Dealer");
        Deck deck = new Deck();

        Stats stats = new Stats(playerName);

        BlackjackGame blackjackGame = new BlackjackGame(deck, player, dealer);

        boolean gameActive = true;

        while (gameActive) {
            blackjackGame.startGame();
            Player winner = blackjackGame.playRound();
            if (player.hand.calculateValue() == dealer.hand.calculateValue()) {
                System.out.println("It's a Tie!");
                player.tieBet();
            } else {
                System.out.println(winner.name + " Wins!");
                winner.winBet(winner.getBlackjack());
            }

            dealer.printFullHand();

            System.out.println("--Beginning New Round--");
            System.out.println("Press Enter To Continue (Q To Quit)");
            int key = System.in.read();

            if (key == 81 || key == 113) {
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