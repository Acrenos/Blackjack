public class Dealer extends Player {

    public Dealer(Hand hand, String name) {
        super(hand, name);
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
        String cards = "";
        for (int x = 0; x < hand.getCards().size(); x++) {
            if (x == 0) {
                cards += "---";
            } else {
                cards += ", ";
                cards += hand.getCards().get(x).toString();
            }
        }
        System.out.println("Dealer Hand: " + cards);
    }


}
