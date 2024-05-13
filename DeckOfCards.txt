/**
 * @author Dhruv Patel
 */


import java.util.Random;


/**
 * The class Deck of cards
 */
public class DeckOfCards {
    private int maximumRank;
    private int numOfSuits;
    private Card[] cards;



    /**
     *
     * Most complex constructor with two parameters.
     *
     * @param maximumRank  the maximum rank.
     * @param numOfSuits  the num of suits.
     */
    public DeckOfCards(int maximumRank, int numOfSuits){

        this.maximumRank = maximumRank;
        this.numOfSuits = numOfSuits;

        cardObjectInArray();
    }


    /**
     *
     * Card object in array
     *
     */
    public void cardObjectInArray(){

        cards = new Card[this.maximumRank * this.numOfSuits];
        int x =0;
        for (int rank = 1; rank <= this.maximumRank; rank++) {
            for (int suit = 1; suit <= this.numOfSuits; suit++) {
                cards[x++] = new Card(rank, suit);
            }
        }
    }


    /**
     *
     * constructor to shuffle the card.
     *
     */
    public void shuffle() {

        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int swappingPairsOfCards = random.nextInt(cards.length);
            Card temp = cards[swappingPairsOfCards];
            cards[swappingPairsOfCards] = cards[i];
            cards[i] = temp;
        }
    }


    /**
     *
     * Total size
     *
     * @return int
     */
    public int totalSize(){

        return cards.length;
    }


    /**
     *
     * Gets the minimum value
     *
     * @return the minimum value
     */
    public int getMinimumValue(){

        return 1;
    }


    /**
     *
     * Gets the maximum value
     *
     * @return the maximum value
     */
    public int getMaximumValue(){

        return this.maximumRank * this.numOfSuits;
    }



    /**
     *
     * Deal top N cards
     *
     * @param numCards  the num cards.
     * @return Card[]
     */
    public Card[] dealTopNCards(int numCards) {

        if (numCards > cards.length) {
            System.out.println("Not enough cards in the deck.");
        }
        Card[] hand = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            hand[i] = cards[i];
        }
        return hand;
    }



    @Override

/**
 *
 * To string
 *
 * @return String
 */
    public String toString() {

        if (totalSize() == 0) {
            return "Empty deck";
        } else {
            return "Deck of " + totalSize() + " cards: low = " + getMinimumValue() + " high = " + getMaximumValue() + " top = " + cards[0];
        }
    }



    /**
     *
     * Histogram
     *
     * @param handSize  the hand size.
     * @param numberOfTrials  the number of trials.
     * @return int[]
     */
    public int[] histogram(int handSize, int numberOfTrials){

        int[] histogram =new int[getMaximumValue() * handSize + 1];

        for(int i = 0; i<numberOfTrials; i++){
            shuffle();

            int totalValue = 0;
            for (int j = 0; j < handSize; j++) {
                Card card = cards[j];
                totalValue += card.getValue();
            }
            histogram[totalValue]++;
        }
        return histogram;
    }

}
