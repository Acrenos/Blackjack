import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    protected Hand hand;
    protected String name;

    private ArrayList<Hand> hands = new ArrayList<>();

    private int chipsBalance;
    private int currentBet;

    private boolean blackjack;

    public Player(Hand hand, String name, int startingChipsBalance) {
        this.hand = hand;
        this.name = name;
        chipsBalance = startingChipsBalance;
        blackjack = false;
        hands.add(hand);
    }

    public void preBet() {
        if (chipsBalance <= 0) {
            System.out.println("You are out of money!");
            System.out.println("Press Enter To Continue");
            Scanner input = new Scanner(System.in);
            input.nextLine();

        }
        System.out.println("Balance: $" + chipsBalance);
        Scanner input = new Scanner(System.in);
        boolean properBet = false;
        while (!properBet) {
            System.out.println("Enter Bet: ");
            currentBet = (int) input.nextDouble();
            if (currentBet > 0 && chipsBalance >= currentBet) {
                chipsBalance -= currentBet;
                properBet = true;
            }
        }
    }

    public boolean takeTurn(Deck deck) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--Your Turn--\n");
        boolean noSplit = false;
        while (!noSplit) {
            System.out.println("Debug No Split Line 50");
            ArrayList<Hand> newHands;
            newHands = new ArrayList<>(hands);
            System.out.println(hands);
            System.out.println("Debug 7 Line 54");
            for (Hand loopHand : hands) {
                System.out.println("Debug Hand 2:" + hands.indexOf(hand));
                hand = loopHand;
                System.out.println("Debug Hand:" + hands.indexOf(hand));
                printHand();
                boolean complete = false;
                while (!complete) {
                    System.out.println("Choose Action: (1) Stand (2) Hit" +
                            (chipsBalance >= currentBet && hand.calculateValue() < 21 ? " (3) Double Down" : "") +
                            (hand.canSplit() ? " (4) Split Hand" : ""));
                    int userInput = input.nextInt();
                    if (userInput == 1) {
                        System.out.println("--Turn Over--");
                        complete = true;
                    } else if (userInput == 2) {
                        System.out.println("--Dealing New Card--");
                        System.out.println(hand);
                        System.out.println(hands.indexOf(hand));
                        hand.addCard(deck.dealCard());
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
                        // User cannot hit again after doubling down so we complete the loop
                        complete = true;
                    } else if (userInput == 4 && hand.canSplit()) {
                        System.out.println("--Splitting Hand--");
                        Hand newHand = new Hand();
                        newHand.addCard(hand.getCards().getLast());
                        System.out.println("Debug 1");
                        newHands.set(hands.indexOf(hand), newHand);
                        Hand splitHand = new Hand();
                        System.out.println("Debug 2");
                        splitHand.addCard(hand.getCards().getFirst());
                        newHands.add(hands.indexOf(hand) + 1, splitHand);
                        System.out.println("Debug 3");
                        complete = true;
                    } else {
                        System.out.println("Unexpected Input!");
                        System.out.println("Please Try Again");
                    }
                }
                System.out.println(hands);
                System.out.println("Debug 6 Line 106");
            }
            System.out.println("Debug 4");
            if (hands != newHands) {
                hands = newHands;
            } else {
                noSplit = true;
            }
            System.out.println("Debug 5");
        }
        if (hand.calculateValue() == 21 && hand.getCards().size() == 2) {
            blackjack = true;
        }
        return false;
    }

    public void printHand() {
        if (hands.size() == 1) {
            StringBuilder cards = new StringBuilder();
            for (int x = 0; x < hand.getCards().size(); x++) {
                if (x != 0) {
                    cards.append(", ");
                }
                cards.append(hand.getCards().get(x).toString());
            }
            System.out.println("Your Hand: " + cards);
            System.out.println("Total Value: " + hand.calculateValue());
        } else {
            for (Hand loopHand : hands) {
                hand = loopHand;
                System.out.println("--Hand " + (hands.indexOf(hand) + 1) + "--");
                StringBuilder cards = new StringBuilder();
                for (int x = 0; x < hand.getCards().size(); x++) {
                    if (x != 0) {
                        cards.append(", ");
                    }
                    cards.append(hand.getCards().get(x).toString());
                }
                System.out.println("Your Hand: " + cards);
                System.out.println("Total Value: " + hand.calculateValue());
                System.out.println("Press Enter To Continue");
                Scanner input = new Scanner(System.in);
                input.nextLine();
            }
        }
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public void winBet(boolean blackjack) {
        chipsBalance += blackjack ? (5 * currentBet) / 2 : 2 * currentBet;
        currentBet = 0;
        this.blackjack = false;
    }
    
    public void tieBet() {
        chipsBalance += currentBet;
        currentBet = 0;
        this.blackjack = false;
    }

    public boolean getBlackjack() {
        return blackjack;
    }

}
