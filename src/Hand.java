import java.util.ArrayList;
import java.util.Objects;

public class Hand {

    private ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateValue() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getCardValue();
        }
        if (sum > 21) {
            for (Card card : cards) {
                if (Objects.equals(card.getRank(), "Ace")) {
                    card.setCardValue(1);
                    sum -= 10;
                }
            }
        }

        return sum;
    }

    public void clearHand() {
        cards.clear();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }


}
