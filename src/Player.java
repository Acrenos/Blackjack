import java.util.Scanner;

public class Player {

    protected Hand hand;
    protected String name;

    public Player(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
    }

    public boolean takeTurn(Deck deck) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--Your Turn--\n");

        printHand();

        boolean complete = false;
        while (!complete) {
            System.out.println("Choose Action: (1) Stand (2) Hit");
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
            } else {
                System.out.println("Unexpected Input!");
                System.out.println("Please Try Again");
            }
        }
        return false;
    }

    public void printHand() {
        String cards = "";
        for (int x = 0; x < hand.getCards().size(); x++) {
            if (x != 0) {
                cards += ", ";
            }
            cards += hand.getCards().get(x).toString();
        }
        System.out.println("Your Hand: " + cards);
        System.out.println("Total Value: " + hand.calculateValue());
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

}
