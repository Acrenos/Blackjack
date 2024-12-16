import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        initializeNumberCards();
        initializeFaceCards();
    }


    /**
     * Resets the deck
     *
     * While it doesn't actually "shuffle" the cards,
     * the deal cards function randomly selects a card so it
     * serves the same purpose as shuffling the deck
     *
     */
    public void shuffleCards() {
        if (!cards.isEmpty()) {
            cards.clear();
        }
        initializeNumberCards();
        initializeFaceCards();
    }


    /**
     * Generates a random number from 0 to the size of cards
     * Gets a card from arraylist cards
     * Removes card from cards array list and
     * returns the removed card
     *
     *
     * @return random card from the deck
     */

    public Card dealCard() {
        int card = (int)(Math.random() * (double)cards.size());
        Card dealCard = cards.get(card);
        cards.remove(dealCard);
        return dealCard;
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
        for (int x = 0; x < 4; x++) {
            cards.add(new Card(Card.intToSuite(x), "Ace", 11));
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }


}
