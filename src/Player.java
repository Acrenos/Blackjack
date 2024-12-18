import java.util.Scanner;

public class Player {

    protected Hand hand;
    protected String name;

    private int chipsBalance;
    private int currentBet;

    private boolean blackjack;

    public Player(Hand hand, String name, int startingChipsBalance) {
        this.hand = hand;
        this.name = name;
        chipsBalance = startingChipsBalance;
        blackjack = false;
    }

    public void preBet() {
        System.out.println("Balance: $" + chipsBalance);
        Scanner input = new Scanner(System.in);
        boolean properBet = false;
        while (!properBet) {
            System.out.println("Enter Bet: ");
            currentBet = input.nextInt();
            if (currentBet > 0 && chipsBalance >= currentBet) {
                chipsBalance -= currentBet;
                properBet = true;
            }
        }
    }

    public boolean takeTurn(Deck deck) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--Your Turn--\n");

        printHand();

        boolean complete = false;
        while (!complete) {
            System.out.println("Choose Action: (1) Stand (2) Hit" + (chipsBalance >= currentBet && hand.calculateValue() < 21 ? " (3) Double Down" : ""));
            int userInput = input.nextInt();
            if (userInput == 1) {
                System.out.println("--Turn Over--");
                complete = true;
            }
            else if (userInput == 2) {
                System.out.println("--Dealing New Card--");
                addCard(deck.dealCard());
                printHand();
                if (hand.calculateValue() > 21) {
                    System.out.println("You Busted!");
                    return true;
                }

            } else if (userInput == 3 && chipsBalance >= currentBet && hand.calculateValue() < 21) {
                System.out.println("--Doubling Down--");
                chipsBalance -= currentBet;
                currentBet *= 2;
                addCard(deck.dealCard());
                printHand();
                if (hand.calculateValue() > 21) {
                    System.out.println("You Busted!");
                    return true;
                }
            }else {
                System.out.println("Unexpected Input!");
                System.out.println("Please Try Again");
            }
        }
        if (hand.calculateValue() == 21 && hand.getCards().size() == 2) {
            blackjack = true;
        }
        return false;
    }

    public void printHand() {
        StringBuilder cards = new StringBuilder();
        for (int x = 0; x < hand.getCards().size(); x++) {
            if (x != 0) {
                cards.append(", ");
            }
            cards.append(hand.getCards().get(x).toString());
        }
        System.out.println("Your Hand: " + cards);
        System.out.println("Total Value: " + hand.calculateValue());
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public void winBet(boolean blackjack) {
        chipsBalance += blackjack ? (5 * currentBet) / 2 : 2 * currentBet;
        currentBet = 0;
        this.blackjack = false;
    }

    public boolean getBlackjack() {
        return blackjack;
    }

}
