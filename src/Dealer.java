import java.util.Scanner;

public class Dealer extends Player {

    public Dealer(Hand hand, String name) {
        super(hand, name, Integer.MAX_VALUE);
    }

    @Override
    public boolean takeTurn(Deck deck) {
        System.out.println("--Dealer Turn--");
        printHand();
        boolean complete = false;
        while (!complete) {
            if (hand.calculateValue() >= 17) {
                System.out.println("--Dealer Stands--");
                complete = true;
            } else {
                System.out.println("--Dealer Hits--");
                hand.addCard(deck.dealCard());
                printHand();
                if (hand.calculateValue() > 21) {
                    System.out.println("Dealer Busted!");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void printHand() {
        StringBuilder cards = new StringBuilder();
        for (int x = 0; x < hand.getCards().size(); x++) {
            if (x == 0) {
                cards.append("---");
            } else {
                cards.append(", ");
                cards.append(hand.getCards().get(x).toString());
            }
        }
        System.out.println("Dealer Hand: " + cards);
        pause();
    }

    public void printFullHand() {
        StringBuilder cards = new StringBuilder();
        for (int x = 0; x < hand.getCards().size(); x++) {
            if (x != 0) {
                cards.append(", ");
            }
            cards.append(hand.getCards().get(x).toString());
        }
        System.out.println("Dealer Hand: " + cards);
        System.out.println("Total Value: " + hand.calculateValue());
        pause();
    }

    public void pause() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hit enter to continue");
        input.nextLine();
    }

    @Override
    public void winBet(boolean blackjack) {
        printFullHand();
    }

    @Override
    public boolean getBlackjack() {
        return false;
    }
}
