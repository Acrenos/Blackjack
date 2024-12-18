import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        shuffleCards();
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

        // Shuffles Deck using Fisher-Yates Shuffle
        for (int i = cards.size() - 1; i >= 0; i--) {
        int j = (int) (Math.floor(Math.random() * (i + 1)));
        ArrayList<Card> temp = new ArrayList<>();
        temp.add(cards.get(i));
        cards.set(i, cards.get(j));
        cards.set(j, temp.getFirst());
        }
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
        Card dealCard = cards.getFirst();
        cards.remove(dealCard);
        return dealCard;
    }

    private void initializeNumberCards() {
        for (int x = 2; x < 9; x++) {
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
