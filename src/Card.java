public class Card {

    public enum Suite {
        Hearts,
        Clubs,
        Diamonds,
        Spades
    }

    private Suite suite;
    private String rank;
    private int cardValue;

    public Card(Suite suite, String rank, int cardValue) {
        this.suite = suite;
        this.rank = rank;
        this.cardValue = cardValue;
    }

    public Suite getSuite() {
        return suite;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getRank() {
        return rank;
    }

    public String toString() {
        return rank + " of " + suite.toString();
    }

    /**
     * Used to set aces to 1
     */
    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public static Suite intToSuite(int num) {
        switch (num) {
            case 0:
                return Suite.Hearts;
            case 1:
                return Suite.Clubs;
            case 2:
                return Suite.Diamonds;
            case 3:
                return Suite.Spades;
        }

        System.err.println("Invalid int passed into intToSuite function: num = " + num);
        return Suite.Hearts;
    }



}
