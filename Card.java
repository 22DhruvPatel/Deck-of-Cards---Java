/**
 * @author Dhruv Patel
 */


public class Card {
    private int rank;
    private int suit;



    /**
     *
     * It is a constructor.
     *
     */
    public Card(){

        this.rank = 50;
        this.suit = 80;
    }


    /**
     *
     * It is a constructor.
     *
     * @param rank  the rank.
     * @param suit  the suit.
     */
    public Card(int rank ,int suit){

        this.rank = rank;
        this.suit = suit;
    }



    /**
     *
     * Rank
     *
     * @return int
     */
    public int rank(){

        return this.rank;

    }



    /**
     *
     * Suit
     *
     * @return int
     */
    public int suit(){


        return  this.suit;
    }


    /**
     *
     * Gets the value
     *
     * @return the value
     */
    public int getValue(){


        return this.rank * this.suit;
    }

    //toString() method that reports its rank and suit.
    @Override

/**
 *
 * To string
 *
 * @return String
 */
    public String toString() {


        return "Card S" + suit + "R" + rank;
    }
}
