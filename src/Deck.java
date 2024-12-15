import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {

    }




    private void initializeNumberCards() {
        for (int x = 0; x < 9; x++) {
            for (int i = 0; i < 4; i++) {
                cards.add(new Card(Card.intToSuite(i), Integer.toString(x), x));
            }
        }
    }

    private void initializeFaceCards() {
        for (int x = 0; x < 4; x++) {
            cards.add(new Card(Card.intToSuite(x), "Jack", 10));
        }
        for (int x = 0; x < 4; x++) {
            cards.add(new Card(Card.intToSuite(x), "Queen", 10));
        }
        for (int x = 0; x < 4; x++) {
            cards.add(new Card(Card.intToSuite(x), "King", 10));
        }
        for (int x = 0; x < 4; x++) {
            cards.add(new Card(Card.intToSuite(x), "Jack", 10));
        }
    }


}
